if (typeof jQuery === "undefined") {
	throw new Error("jQuery plugins need to be before this file");
}
$(function() {
	"use strict";
	var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
		return new bootstrap.Tooltip(tooltipTriggerEl)
	})

	//số lượng người dùng đăng ký theo ngày
	$(document).ready(function() {
		"use strict";

		// Khởi tạo tooltip nếu cần (bỏ qua nếu không sử dụng)
		var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
		var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
			return new bootstrap.Tooltip(tooltipTriggerEl);
		});

		$.ajax({
			url: 'http://localhost:8080/course/api/nguoidung/soluongtheongay',
			method: 'GET',
			dataType: 'json',
			success: function(response) {
				if (response.isSuccess) {
					var seriesData = response.data.map(item => item.soLuong);
					var categories = response.data.map(item => item.ngay);

					var options = {
						series: [{
							name: 'Available',
							data: seriesData,
						}],
						chart: {
							height: 140,
							type: 'line',
							toolbar: {
								show: false,
							}
						},
						grid: {
							show: false,
							xaxis: {
								lines: {
									show: false
								}
							},
							yaxis: {
								lines: {
									show: false
								}
							},
						},
						stroke: {
							width: 4,
							curve: 'smooth',
							colors: ['var(--chart-color2)'],
						},
						xaxis: {
							type: 'category',
							categories: categories,
							tickAmount: 10,
							labels: {
								formatter: function(value) {
									return value;
								}
							}
						},
						fill: {
							type: 'gradient',
							gradient: {
								shade: 'dark',
								gradientToColors: ["var(--chart-color3)"],
								shadeIntensity: 1,
								type: 'horizontal',
								opacityFrom: 1,
								opacityTo: 1,
								stops: [0, 100, 100, 100],
							},
						},
						markers: {
							size: 3,
							colors: ["#FFA41B"],
							strokeColors: "#ffffff",
							strokeWidth: 2,
							hover: {
								size: 7,
							}
						},
						yaxis: {
							show: false,
							min: -10,
							max: 50,
						}
					};

					var chart = new ApexCharts(document.querySelector("#soluongnguoidungtheongay"), options);
					chart.render();
				} else {
					console.error('Failed to fetch data:', response.description);
				}
			},
			error: function(xhr, status, error) {
				console.error('Error fetching data:', error);
			}
		});
	});


	//doanh thu khóa học
	$(document).ready(function() {
		$.ajax({
			url: 'http://localhost:8080/course/api/khoahoc/doanhthu', // Endpoint API
			method: 'GET',
			dataType: 'json',
			success: function(response) {
				if (response.isSuccess) {
					var seriesData = response.data.map(item => item.doanh_thu);
					var labels = response.data.map(item => item.khoahoc_ten);

					var options = {
						align: 'center',
						series: seriesData,
						responsive: [{
							breakpoint: 420,
							options: {
								chart: {
									width: 200,
									align: 'center',
								},
								legend: {
									position: 'bottom',
									markers: {
										fillColors: 'var(--chart-color1)'
									},
									labels: {
										colors: 'var(--chart-color1)'
									},
								}
							}
						}],
						chart: {
							height: 336,
							type: 'polarArea',
							toolbar: {
								show: false,
							},
						},
						labels: labels,
						fill: {
							opacity: 1,
							colors: ['var(--chart-color1)', 'var(--chart-color2)', 'var(--chart-color3)', 'var(--chart-color4)',
								'var(--chart-color5)', 'var(--chart-color6)', 'var(--chart-color7)', 'var(--chart-color8)', 
								'#000000', '#FF5733', '#33FF57', '#3375FF', '#FFC300', '#DAF7A6', '#8E44AD', '#1ABC9C', 
								'#E74C3C', '#F39C12', '#2ECC71', '#3498DB',
							'#7F8C8D', '#C0392B', '#9B59B6', '#16A085'],
						},
						stroke: {
							width: 1,
							colors: undefined
						},
						yaxis: {
							show: false
						},
						legend: {
							position: 'bottom',
							horizontalAlign: 'center',
						},
						plotOptions: {
							polarArea: {
								rings: {
									strokeWidth: 0
								}
							}
						},
						theme: {
							monochrome: {
								enabled: true,
								shadeTo: 'light',
								shadeIntensity: 0.6
							}
						}
					};

					var chart = new ApexCharts(document.querySelector("#doanhthukhoahoc"), options);
					chart.render();
				} else {
					console.error('Failed to fetch data:', response.description);
				}
			},
			error: function(xhr, status, error) {
				console.error('Error fetching data:', error);
			}
		});
	});
	$(document).ready(function() {
		var options = {
			chart: {
				height: 500, // Tăng chiều cao để hiển thị nhiều khóa học
				type: 'rangeBar',
				toolbar: {
					show: false,
				}
			},
			plotOptions: {
				bar: {
					horizontal: true,
					distributed: true, // Mỗi thanh có màu riêng dựa trên nhãn
					barWidth: '50%' // Đặt độ rộng của khối, có thể dùng giá trị cố định (px) hoặc phần trăm (%)
				}
			},
			colors: ['#2c3e50', '#e74c3c', '#3498db', '#f1c40f', 
			'#9b59b6', '#1abc9c', '#e67e22', '#8e44ad', '#27ae60', 
			'#d35400', '#34495e', '#c0392b', '#16a085', '#f39c12', '#6c5ce7', 
			'#7f8c8d', '#e84393', '#2980b9', '#95a5a6', '#bdc3c7'], // 20 màu khác nhau

			series: [], // Sẽ được điền động từ API
			yaxis: {
				min: new Date('2025-01-01').getTime(),
				max: new Date('2025-12-31').getTime()
			},
			xaxis: {
				type: 'datetime'
			},
			fill: {
				type: 'solid' // Chỉ sử dụng màu đơn sắc
			},
			dataLabels: {
				enabled: true, // Giữ enabled để có thể tùy chỉnh
				formatter: function(val, opts) {
					return ''; // Trả về chuỗi rỗng để loại bỏ chữ trong ô màu
				},
				style: {
					fontSize: '10px',
					colors: ['#fff']
				}
			}
		};

		$.ajax({
			url: 'http://localhost:8080/course/api/khoahoc/timeline',
			method: 'GET',
			dataType: 'json',
			success: function(response) {
				if (response.isSuccess) {
					// Tạo series duy nhất cho tất cả khóa học
					options.series = [{
						name: 'Khóa học',
						data: response.data.map(item => ({
							x: item.khoahoc_ten,
							y: [new Date(item.khoahoc_ngaybatdau).getTime(), new Date(item.khoahoc_ngayketthuc).getTime()]
						}))
					}];

					// Điều chỉnh yaxis min và max dựa trên dữ liệu thực tế
					let allDates = response.data.flatMap(item => [
						new Date(item.khoahoc_ngaybatdau).getTime(),
						new Date(item.khoahoc_ngayketthuc).getTime()
					]);
					options.yaxis.min = Math.min(...allDates);
					options.yaxis.max = Math.max(...allDates) + 24 * 60 * 60 * 1000; // Thêm 1 ngày

					var chart = new ApexCharts(document.querySelector("#timelinekhoahoc"), options);
					chart.render();
				} else {
					console.error('Failed to fetch data:', response.description);
				}
			},
			error: function(xhr, status, error) {
				console.error('Error fetching data:', error);
			}
		});
	});


});