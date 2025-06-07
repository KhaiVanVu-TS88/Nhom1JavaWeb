$(document).ready(function() {
	//let currentKhoaHocId = NULL;
	// Đảm bảo sự kiện click chỉ được gắn một lần
	$('.btn-xoa-khoahoc').off('click').on('click', function(e) {
		e.preventDefault(); // Ngăn hành động mặc định của nút (nếu có)

		var id = $(this).data('id-khoahoc');
		var div = $(this).closest('.card-khoahoc');

		// Kiểm tra xem id có được lấy đúng không
		if (!id) {
			alert('Không tìm thấy ID khóa học!');
			return;
		}

		// Hiển thị cảnh báo xác nhận
		if (confirm('Bạn có chắc chắn muốn xóa khóa học này không?')) {
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/course/api/khoahoc/delete",
				data: { khoahoc_id: id },
				dataType: "json"
			})
				.done(function(responseData) {
					if (responseData.isSuccess) {
						div.remove();
						alert('Xóa khóa học thành công!');
					} else {
						alert('Xóa thất bại: ' + (responseData.message || 'Lỗi không xác định'));
					}
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					alert('Lỗi khi gửi yêu cầu: ' + textStatus + ' - ' + errorThrown);
				});
		} else {
			console.log('Hủy xóa khóa học với ID: ' + id);
		}
	});

	$('#btn-add-khoahoc').off('click').on('click', function(e) {
		e.preventDefault(); // Ngăn hành động mặc định của nút (nếu có)

		var ten = $("#khoahoc_ten").val();
		var mota = $("#khoahoc_mota").val();
		var trinhdo = $("#khoahoc_trinhdo").val();
		var loai = $("#khoahoc_loai").val();
		var ngaybatdau = $("#khoahoc_ngaybatdau").val();
		var ngayketthuc = $("#khoahoc_ngayketthuc").val();
		var thoiluong = $("#khoahoc_thoiluong").val();
		var gia = $("#khoahoc_gia").val();

		// Hiển thị cảnh báo xác nhận
		if (confirm('Bạn có chắc chắn muốn thêm khóa học này không?')) {
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/course/api/khoahoc/add",
				data: {
					khoahoc_ten: ten,
					khoahoc_mota: mota,
					khoahoc_trinhdo: trinhdo,
					khoahoc_loai: loai,
					khoahoc_ngaybatdau: ngaybatdau,
					khoahoc_ngayketthuc: ngayketthuc,
					khoahoc_thoiluong: thoiluong,
					khoahoc_gia: gia
				},
				dataType: "json"
			})
				.done(function(responseData) {
					if (responseData.isSuccess) {
						alert('Thêm khóa học thành công!');
						location.reload(); // ✅ Reload lại trang để cập nhật dữ liệu
					} else {
						alert('Thêm thất bại: ' + (responseData.message || 'Lỗi không xác định'));
					}
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					alert('Lỗi khi gửi yêu cầu: ' + textStatus + ' - ' + errorThrown);
				});
		} else {
			console.log('Hủy thêm khóa học');
		}
	});
	// Xử lý sự kiện click nút chỉnh sửa khóa học
	$(document).on('click', '.btn.btn-outline-secondary[data-bs-target="#editKhoaHoc"]', function() {
		var khoahocId = $(this).data('id-khoahoc');

		// Kiểm tra khoahocId
		if (!khoahocId) {
			alert('ID khóa học không hợp lệ');
			return;
		}

		// Gửi yêu cầu AJAX để lấy thông tin chi tiết khóa học
		$.ajax({
			method: 'GET',
			url: 'http://localhost:8080/course/api/khoahoc/detail',
			data: { khoahoc_id: khoahocId },
			dataType: 'json'
		})
			.done(function(responseData) {
				if (responseData?.isSuccess && responseData.data) {
					var khoahoc = responseData.data;

					// Điền dữ liệu vào các trường trong modal
					$('#khoahoc_id_update').val(khoahoc.khoahoc_id || '');
					$('#khoahoc_ten_update').val(khoahoc.khoahoc_ten || '');
					$('#khoahoc_mota_update').val(khoahoc.khoahoc_mota || '');
					$('#khoahoc_trinhdo_update').val(khoahoc.khoahoc_trinhdo || '');
					$('#khoahoc_loai_update').val(khoahoc.khoahoc_loai || '');
					$('#khoahoc_trangthai_update').val(khoahoc.khoahoc_trangthai || '');
					$('#khoahoc_ngaybatdau_update').val(khoahoc.khoahoc_ngaybatdau || '');
					$('#khoahoc_ngayketthuc_update').val(khoahoc.khoahoc_ngayketthuc || '');
					$('#khoahoc_thoiluong_update').val(khoahoc.khoahoc_thoiluong || '');
					$('#khoahoc_gia_update').val(khoahoc.khoahoc_gia || '');

					// Hiển thị modal
					$('#editKhoaHoc').modal('show');
				} else {
					alert('Lấy thông tin khóa học thất bại: ' + (responseData?.message || 'Lỗi không xác định'));
				}
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert('Lỗi khi gửi yêu cầu: ' + textStatus + ' - ' + errorThrown);
			});
	});

	$('#editKhoaHoc form').off('submit').on('submit', function(e) {
		e.preventDefault(); // Ngăn hành động mặc định của form

		var ten = $("#khoahoc_ten_update").val();
		var mota = $("#khoahoc_mota_update").val();
		var trinhdo = $("#khoahoc_trinhdo_update").val();
		var loai = $("#khoahoc_loai_update").val();
		var trangthai = $("#khoahoc_trangthai_update").val();
		var ngaybatdau = $("#khoahoc_ngaybatdau_update").val();
		var ngayketthuc = $("#khoahoc_ngayketthuc_update").val();
		var thoiluong = $("#khoahoc_thoiluong_update").val();
		var gia = $("#khoahoc_gia_update").val();
		var khoahocid = $("#khoahoc_id_update").val();

		// Kiểm tra dữ liệu
		if (!ten) {
			alert('Vui lòng điền đầy đủ ten!');
			return;
		}
		if (!gia) {
			alert('Vui lòng điền đầy đủ gia ');
			return;
		}
		if (!thoiluong) {
			alert('Vui lòng điền đầy đủ thoiluong ');
			return;
		}
		if (!ngaybatdau) {
			alert('Vui lòng điền đầy đủ ngaybatdau ');
			return;
		}
		if (!ngayketthuc) {
			alert('Vui lòng điền đầy đủ ngayketthuc ');
			return;
		}

		if (confirm('Bạn có chắc chắn muốn cập nhật khóa học này không?')) {
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/course/api/khoahoc/update",
				data: {
					khoahoc_ten: ten,
					khoahoc_mota: mota,
					khoahoc_trinhdo: trinhdo,
					khoahoc_loai: loai,
					khoahoc_trangthai: trangthai,
					khoahoc_ngaybatdau: ngaybatdau,
					khoahoc_ngayketthuc: ngayketthuc,
					khoahoc_thoiluong: thoiluong,
					khoahoc_gia: gia,
					khoahoc_id: khoahocid
				},
				dataType: "json"
			})
				.done(function(responseData) {
					if (responseData.isSuccess) {
						alert('Cập nhật khóa học thành công!');
						location.reload();
					} else {
						alert('Cập nhật thất bại: ' + (responseData.message || 'Lỗi không xác định'));
					}
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					alert('Lỗi khi gửi yêu cầu: ' + textStatus + ' - ' + errorThrown);
				});
		} else {
			console.log('Hủy Cập nhật khóa học');
		}
	});

	$(document).on('click', '.btn-hienthi-danhsachlophoc', function() {
		var khoahocId = $(this).data('id-khoahoc');

		var tableBody = $('#patient-table tbody');
		tableBody.empty(); // Xóa các hàng hiện tại

		// Kiểm tra khoahocId
		if (!khoahocId) {
			alert('ID khóa học không hợp lệ');
			tableBody.html('<tr><td colspan="9">ID khóa học không hợp lệ</td></tr>');
			return;
		}

		//currentKhoaHocId = khoahocId;

		$.ajax({
			method: 'GET',
			url: 'http://localhost:8080/course/api/lophoc/hienthi',
			data: { khoahoc_id: khoahocId },
			dataType: 'json'
		})
			.done(function(responseData) {
				if (responseData?.isSuccess && Array.isArray(responseData.data)) {
					if (responseData.data.length === 0) {
						tableBody.html('<tr><td colspan="9">Không có lớp học nào</td></tr>');
						return;
					}

					responseData.data.forEach(function(lopHoc) {
						// Xác định class cho badge trạng thái
						let badgeClass = 'bg-info';
						if (lopHoc.lophoc_trangthai === 'Đang diễn ra') badgeClass = 'bg-success';
						else if (lopHoc.lophoc_trangthai === 'Chưa bắt đầu') badgeClass = 'bg-warning';
						else if (lopHoc.lophoc_trangthai === 'Đã kết thúc') badgeClass = 'bg-danger';

						// Lấy tiến độ từ dữ liệu (nếu có) hoặc mặc định 40%
						const progress = lopHoc.lophoc_tiendo || 40;

						// Tạo hàng bảng
						const row = `
                            <tr>
                                <td>${lopHoc.lophoc_id || ''}</td>
                                <td>
                                    <img src="/course/dist/assets/images/xs/avatar3.jpg" class="avatar sm rounded-circle me-2" alt="profile-image">
                                    <span>${lopHoc.giaovien_hoten || 'Chưa xác định'}</span>
                                </td>
                                <td>${lopHoc.lophoc_soluonghv || 0}</td>
                                <td>${lopHoc.lophoc_mota || ''}</td>
                                <td>${lopHoc.lophoc_ngaybatdau || ''}</td>
                                <td>${lopHoc.lophoc_ngayketthuc || ''}</td>
                                <td>
                                    <div class="progress" style="height: 3px;">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" 
                                            aria-valuenow="${progress}" aria-valuemin="0" aria-valuemax="100" 
                                            style="width: ${progress}%;">
                                            <span class="sr-only">${progress}% Complete</span>
                                        </div>
                                    </div>
                                </td>
                                <td><span class="badge ${badgeClass}">${lopHoc.lophoc_trangthai || 'Chưa xác định'}</span></td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic outlined example">
                                        <button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#readclass" data-lophoc-id="${lopHoc.lophoc_id}">
                                            <i class="icofont-eye text-success"></i>
                                        </button>
                                        <button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#editLopHoc" data-khoahoc-id="${khoahocId}" data-lophoc-id="${lopHoc.lophoc_id}">
                                            <i class="icofont-edit text-success"></i>
                                        </button>
                                        <button type="button" class="btn btn-outline-secondary btn-xoa-lophoc" data-lophoc-id="${lopHoc.lophoc_id}">
                                            <i class="icofont-ui-delete text-danger"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>`;
						tableBody.append(row);
					});

					// Thêm sự kiện xóa lớp học
					$('.btn-xoa-lophoc').off('click').on('click', function() {
						const lophocId = $(this).data('lophoc-id');
						if (confirm('Bạn có chắc chắn muốn xóa lớp học này?')) {
							$.ajax({
								method: 'POST',
								url: 'http://localhost:8080/course/api/lophoc/delete',
								data: { lophoc_id: lophocId },
								dataType: 'json'
							})
								.done(function(response) {
									if (response.isSuccess) {
										alert('Xóa lớp học thành công');
										$(`button[data-lophoc-id="${lophocId}"]`).closest('tr').remove();
									} else {
										alert('Xóa lớp học thất bại: ' + (response.description || 'Lỗi không xác định'));
									}
								})
								.fail(function(jqXHR, textStatus, errorThrown) {
									alert('Lỗi khi gửi yêu cầu xóa: ' + textStatus + ' - ' + errorThrown);
								});
						}
					});



				} else {
					alert('Lấy danh sách lớp học thất bại: ' + (responseData?.description || 'Lỗi không xác định'));
					tableBody.html('<tr><td colspan="9">Không thể tải danh sách lớp học</td></tr>');
				}
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert('Lỗi khi gửi yêu cầu: ' + textStatus + ' - ' + errorThrown);
				tableBody.html('<tr><td colspan="9">Không thể tải danh sách lớp học</td></tr>');
			});


	});
	//thêm lớp học
	$('#btn-add-lophoc').off('click').on('click', function(e) {
		e.preventDefault();

		var khoahocid = $("#lophoc_khoahoc_id").val();
		//var khoahocid = currentKhoaHocId;
		var ten = $("#lophoc_ten").val();
		var tailieu = $("#lophoc_tailieu").val();
		var ngaybatdau = $("#lophoc_ngaybatdau").val();
		var ngayketthuc = $("#lophoc_ngayketthuc").val();
		var giaovienid = $("#lophoc_giaovien_id").val();
		var mota = $("#lophoc_mota").val();

		if (confirm('Bạn có chắc chắn muốn thêm lớp học này không?')) {
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/course/api/lophoc/add",
				data: {
					lophoc_khoahoc_id: khoahocid,
					lophoc_ten: ten,
					lophoc_tailieu: tailieu,
					lophoc_ngaybatdau: ngaybatdau,
					lophoc_ngayketthuc: ngayketthuc,
					lophoc_giaovien_id: giaovienid,
					lophoc_mota: mota
				},
				dataType: "json"
			})
				.done(function(responseData) {
					if (responseData.isSuccess) {
						alert('Thêm lớp học thành công!');
						location.reload();
					} else {
						alert('Thêm thất bại: ' + (responseData.message || 'Lỗi không xác định'));
					}
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					alert('Lỗi khi gửi yêu cầu: ' + textStatus + ' - ' + errorThrown);
				});
		} else {
			console.log('Hủy thêm lớp học');
		}
	});

	// Xử lý sự kiện click nút chỉnh sửa lớp học
	$(document).on('click', '.btn.btn-outline-secondary[data-bs-target="#editLopHoc"]', function() {
		var lophocId = $(this).data('lophoc-id');
		var khoahocId = $(this).data('khoahoc-id');

		// Kiểm tra lophocId
		if (!lophocId) {
			alert('ID lớp học không hợp lệ');
			return;
		}

		// Gửi yêu cầu AJAX để lấy thông tin chi tiết lớp học
		$.ajax({
			method: 'GET',
			url: 'http://localhost:8080/course/api/lophoc/detail',
			data: { lophoc_id: lophocId },
			dataType: 'json'
		})
			.done(function(responseData) {
				if (responseData?.isSuccess && responseData.data && responseData.data.length > 0) {
					var lopHoc = responseData.data[0]; // Lấy lớp học đầu tiên từ mảng data

					// Điền dữ liệu vào các trường trong modal
					$('#lophoc_id_update').val(lopHoc.lophoc_id || '');
					$('#lophoc_khoahoc_id_update').val(lopHoc.lophoc_khoahoc_id || khoahocId || '');
					$('#lophoc_ten_update').val(lopHoc.lophoc_ten || '');
					$('#lophoc_mota_update').val(lopHoc.lophoc_mota || '');
					$('#lophoc_trangthai_update').val(lopHoc.lophoc_trangthai === 'Chưa bắt đầu' ? '1' :
						lopHoc.lophoc_trangthai === 'Đang học' ? '2' :
							lopHoc.lophoc_trangthai === 'Đã kết thúc' ? '3' :
								lopHoc.lophoc_trangthai === 'Tạm dừng' ? '4' : '');
					$('#lophoc_ngaybatdau_update').val(lopHoc.lophoc_ngaybatdau || '');
					$('#lophoc_ngayketthuc_update').val(lopHoc.lophoc_ngayketthuc || '');
					$('#lophoc_giaovien_id_update').val(lopHoc.giaovien_hoten || '');
					$('#lophoc_tailieu_update').val(lopHoc.lophoc_tailieu || '');

					// Hiển thị modal
					$('#editLopHoc').modal('show');
				} else {
					alert('Lấy thông tin lớp học thất bại: ' + (responseData?.description || 'Lỗi không xác định'));
				}
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert('Lỗi khi gửi yêu cầu: ' + textStatus + ' - ' + errorThrown);
			});
	});

	//cập nhật lớp học
	$('#editLopHoc form').off('submit').on('submit', function(e) {
		e.preventDefault(); // Ngăn hành động mặc định của form

		var lophoc_id_update = $("#lophoc_id_update").val();
		var lophoc_khoahoc_id_update = $("#lophoc_khoahoc_id_update").val();
		var lophoc_ten_update = $("#lophoc_ten_update").val();
		var lophoc_mota_update = $("#lophoc_mota_update").val();
		var lophoc_trangthai_update = $("#lophoc_trangthai_update").val();
		var lophoc_ngaybatdau_update = $("#lophoc_ngaybatdau_update").val();
		var lophoc_ngayketthuc_update = $("#lophoc_ngayketthuc_update").val();
		var giaovien_hoten_update = $("#lophoc_giaovien_id_update").val();
		var lophoc_tailieu_update = $("#lophoc_tailieu_update").val();



		if (confirm('Bạn có chắc chắn muốn cập nhật lớp học này không?')) {
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/course/api/lophoc/update",
				data: {
					lophoc_id: lophoc_id_update,
					lophoc_khoahoc_id: lophoc_khoahoc_id_update,
					lophoc_ten: lophoc_ten_update,
					lophoc_mota: lophoc_mota_update,
					lophoc_trangthai: lophoc_trangthai_update,
					lophoc_ngaybatdau: lophoc_ngaybatdau_update,
					lophoc_ngayketthuc: lophoc_ngayketthuc_update,
					giaovien_hoten: giaovien_hoten_update,
					lophoc_tailieu: lophoc_tailieu_update
				},
				dataType: "json"
			})
				.done(function(responseData) {
					if (responseData.isSuccess) {
						alert('Cập nhật lớp học thành công!');
						location.reload();
					} else {
						alert('Cập nhật thất bại: ' + (responseData.message || 'Lỗi không xác định'));
					}
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					alert('Lỗi khi gửi yêu cầu: ' + textStatus + ' - ' + errorThrown);
				});
		} else {
			console.log('Hủy Cập nhật lớp học');
		}
	});


});