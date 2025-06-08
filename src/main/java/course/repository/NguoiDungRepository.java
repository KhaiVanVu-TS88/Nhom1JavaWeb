package course.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import course.config.MySqlConnection;
import course.model.GiangVienData;
import course.model.NguoiDung;
import course.model.NguoiDungTheoNgay;
import course.model.ThongKeHocVien;

public class NguoiDungRepository {
	private static final Logger logger = LoggerFactory.getLogger(NguoiDungRepository.class);

	public List<NguoiDung> getNguoiDungByNguoiDung_emailAndNguoiDung_MatKhau(String nguoiDung_email,
			String nguoiDung_MatKhau) {
		List<NguoiDung> list = new ArrayList<>();
		String query = "SELECT * FROM nguoidung WHERE nguoidung_email = ? AND nguoidung_matkhau = ?";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, nguoiDung_email);
			preparedStatement.setString(2, nguoiDung_MatKhau);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					NguoiDung nguoiDung = new NguoiDung();
					nguoiDung.setNguoidung_id(resultSet.getInt("nguoidung_id"));
					nguoiDung.setNguoidung_email(resultSet.getString("nguoidung_email"));
					nguoiDung.setNguoidung_matkhau(resultSet.getString("nguoidung_matkhau"));
					nguoiDung.setNguoidung_hoten(resultSet.getString("nguoidung_hoten"));
					nguoiDung.setNguoidung_sdt(resultSet.getString("nguoidung_sdt"));
					nguoiDung.setNguoidung_diachi(resultSet.getString("nguoidung_diachi"));
					nguoiDung.setNguoidung_avatar(resultSet.getString("nguoidung_avatar"));
					nguoiDung.setNguoidung_vaitro(resultSet.getString("nguoidung_vaitro"));
					nguoiDung.setNguoidung_trangthai(resultSet.getString("nguoidung_trangthai"));
					nguoiDung.setNguoidung_sodu(resultSet.getInt("nguoidung_sodu"));
					nguoiDung.setNguoidung_nganhang(resultSet.getString("nguoidung_nganhang"));
					nguoiDung.setNguoidung_stk(resultSet.getString("nguoidung_stk"));
					nguoiDung.setNguoidung_created_at(resultSet.getString("nguoidung_created_at"));
					nguoiDung.setNguoidung_updated_at(resultSet.getString("nguoidung_updated_at"));

					list.add(nguoiDung);
				}
			}
		} catch (SQLException e) {
			logger.error("Error fetching NguoiDung with email: {}", nguoiDung_email, e);
		}

		return list;
	}

	public List<NguoiDung> getNguoiDungHoTenByNguoiDungVaiTro(String nguoidung_vaitro) {
		List<NguoiDung> list = new ArrayList<>();
		String query = "SELECT * FROM nguoidung WHERE nguoidung_vaitro = ?;";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, nguoidung_vaitro);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					NguoiDung nguoiDung = new NguoiDung();
					nguoiDung.setNguoidung_id(resultSet.getInt("nguoidung_id"));
					nguoiDung.setNguoidung_hoten(resultSet.getString("nguoidung_hoten"));
					nguoiDung.setNguoidung_sdt(resultSet.getString("nguoidung_sdt"));
					nguoiDung.setNguoidung_diachi(resultSet.getString("nguoidung_diachi"));
					nguoiDung.setNguoidung_avatar(resultSet.getString("nguoidung_avatar"));
					nguoiDung.setNguoidung_vaitro(resultSet.getString("nguoidung_vaitro"));
					nguoiDung.setNguoidung_trangthai(resultSet.getString("nguoidung_trangthai"));
					nguoiDung.setNguoidung_sodu(resultSet.getInt("nguoidung_sodu"));
					nguoiDung.setNguoidung_nganhang(resultSet.getString("nguoidung_nganhang"));
					nguoiDung.setNguoidung_stk(resultSet.getString("nguoidung_stk"));
					nguoiDung.setNguoidung_created_at(resultSet.getString("nguoidung_created_at"));
					nguoiDung.setNguoidung_updated_at(resultSet.getString("nguoidung_updated_at"));

					list.add(nguoiDung);
				}
			}
		} catch (SQLException e) {
			logger.error("Error fetching NguoiDung with vaitro: {}", nguoidung_vaitro, e);
		}

		return list;
	}

	public List<NguoiDung> getGiaoVienTieuBieu() {
		List<NguoiDung> list = new ArrayList<>();
		String query = "SELECT \r\n" + "    nd.nguoidung_id,\r\n" + "    nd.nguoidung_hoten as hoten,\r\n"
				+ "    COUNT(lh.lophoc_id) as so_lophoc\r\n" + "FROM \r\n" + "    nguoidung nd\r\n"
				+ "    INNER JOIN lophoc lh ON nd.nguoidung_id = lh.lophoc_giaovien_id\r\n" + "WHERE \r\n"
				+ "    nd.nguoidung_vaitro = 'Giáo viên'\r\n" + "GROUP BY \r\n" + "    nd.nguoidung_id,\r\n"
				+ "    nd.nguoidung_hoten\r\n" + "ORDER BY \r\n" + "    so_lophoc DESC\r\n" + "LIMIT 7;";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					NguoiDung nguoiDung = new NguoiDung();
					nguoiDung.setNguoidung_id(resultSet.getInt("nguoidung_id"));
					nguoiDung.setNguoidung_hoten(resultSet.getString("hoten"));
					nguoiDung.setSolop_giaovien(resultSet.getInt("so_lophoc"));

					list.add(nguoiDung);
				}
			}
		} catch (SQLException e) {
			logger.error("Error fetching NguoiDung with {}", e);
		}

		return list;
	}

	public List<GiangVienData> getGiangVien() {
		List<GiangVienData> list = new ArrayList<>();
		String query = "SELECT \r\n" + "    CASE \r\n"
				+ "        WHEN nguoidung_trinhdo IN ('A1', 'A2') THEN 'Basic'\r\n"
				+ "        WHEN nguoidung_trinhdo IN ('B1', 'B2') THEN 'Intermediate'\r\n"
				+ "        WHEN nguoidung_trinhdo IN ('C1', 'C2') THEN 'Advanced'\r\n" + "        ELSE 'Unknown'\r\n"
				+ "    END AS level_category,\r\n" + "    COUNT(*) as count\r\n" + "FROM \r\n" + "    nguoidung\r\n"
				+ "WHERE nguoidung_vaitro = 'Giáo viên'\r\n" + "GROUP BY \r\n" + "    CASE \r\n"
				+ "        WHEN nguoidung_trinhdo IN ('A1', 'A2') THEN 'Basic'\r\n"
				+ "        WHEN nguoidung_trinhdo IN ('B1', 'B2') THEN 'Intermediate'\r\n"
				+ "        WHEN nguoidung_trinhdo IN ('C1', 'C2') THEN 'Advanced'\r\n" + "        ELSE 'Unknown'\r\n"
				+ "    END;";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			if (connection == null) {
				logger.error("Failed to establish database connection");
				return list;
			}

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String label = resultSet.getString("level_category");
					int value = resultSet.getInt("count");
					GiangVienData giangVien = new GiangVienData(label, value);
					list.add(giangVien);
				}
				if (list.isEmpty()) {
					logger.info("No data found for level distribution");
				}
			}
		} catch (SQLException e) {
			logger.error("Error fetching level distribution: {}", e.getMessage(), e);
		}

		return list;
	}

	public int getTongSoGiangVien() {
		int tongSoGiangVien = 0;
		String query = "SELECT COUNT(*) as total_teachers\n" + "FROM nguoidung\n"
				+ "WHERE nguoidung_vaitro = 'Giáo viên';";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			if (connection == null) {
				logger.error("Failed to establish database connection");
				return -1; // Trả về -1 để báo hiệu lỗi kết nối
			}

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					tongSoGiangVien = resultSet.getInt("total_teachers");
				} else {
					logger.warn("No data found for total teachers");
				}
			}
		} catch (SQLException e) {
			logger.error("Error fetching total teachers: {}", e.getMessage(), e);
			return -1; // Trả về -1 nếu có lỗi SQL
		}

		return tongSoGiangVien;
	}

	public List<NguoiDungTheoNgay> getSoLuongNguoiDungTheoNgay() {
		List<NguoiDungTheoNgay> list = new ArrayList<>();
		String query = "SELECT DATE(nguoidung_created_at) AS ngay, COUNT(nguoidung_id) AS so_luong " + "FROM nguoidung "
				+ "GROUP BY DATE(nguoidung_created_at) " + "ORDER BY ngay";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			if (connection == null) {
				logger.error("Database connection is null");
				return list; // Trả về danh sách rỗng nếu không kết nối được
			}

			while (resultSet.next()) {
				Date ngay = resultSet.getDate("ngay");
				int soLuong = resultSet.getInt("so_luong");
				NguoiDungTheoNgay nguoiDung = new NguoiDungTheoNgay(ngay, soLuong);
				list.add(nguoiDung);
			}
		} catch (SQLException e) {
			logger.error("Error fetching user registrations by date: {}", e.getMessage());
		}

		return list;
	}

	public ThongKeHocVien getThongKeHocVien() {
		ThongKeHocVien result = null;
		// Truy vấn 1: Tổng số học viên
		String query1 = "SELECT COUNT(*) AS tong_hoc_vien FROM nguoidung WHERE nguoidung_vaitro = 'Học viên'";
		// Truy vấn 2: Tổng số học viên đã hoàn thành
		String query2 = "SELECT COUNT(DISTINCT nguoidung.nguoidung_id) AS tong_hoan_thanh " + "FROM nguoidung "
				+ "JOIN hocvien_lophoc ON nguoidung.nguoidung_id = hocvien_lophoc.hvlh_hocvien_id "
				+ "WHERE nguoidung_vaitro = 'Học viên' AND hvlh_trangthai = 'Đã hoàn thành'";
		// Truy vấn 3: Tổng số học viên đang học
		String query3 = "SELECT COUNT(DISTINCT nguoidung.nguoidung_id) AS tong_dang_hoc " + "FROM nguoidung "
				+ "JOIN hocvien_lophoc ON nguoidung.nguoidung_id = hocvien_lophoc.hvlh_hocvien_id "
				+ "WHERE nguoidung_vaitro = 'Học viên' AND hvlh_trangthai = 'Đang học'";

		try (Connection connection = MySqlConnection.getConnection()) {
			if (connection == null) {
				logger.error("Database connection is null");
				return null;
			}

			// Thực thi truy vấn 1
			try (PreparedStatement ps1 = connection.prepareStatement(query1); ResultSet rs1 = ps1.executeQuery()) {
				if (rs1.next()) {
					int tongSoHocVien = rs1.getInt("tong_hoc_vien");
					// Thực thi truy vấn 2
					try (PreparedStatement ps2 = connection.prepareStatement(query2);
							ResultSet rs2 = ps2.executeQuery()) {
						if (rs2.next()) {
							int tongSoHocVienDaHoanThanh = rs2.getInt("tong_hoan_thanh");
							// Thực thi truy vấn 3
							try (PreparedStatement ps3 = connection.prepareStatement(query3);
									ResultSet rs3 = ps3.executeQuery()) {
								if (rs3.next()) {
									int tongSoHocVienDangHoc = rs3.getInt("tong_dang_hoc");
									result = new ThongKeHocVien(tongSoHocVien, tongSoHocVienDaHoanThanh,
											tongSoHocVienDangHoc);
								}
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			logger.error("Error fetching statistics for students: {}", e.getMessage());
		}

		return result;
	}

	public List<NguoiDung> getHocVienTheoLopHocId(int lophoc_id) {
        List<NguoiDung> list = new ArrayList<>();
        String query = "SELECT nd.nguoidung_id, nd.nguoidung_hoten, hvlh.hvlh_trangthai, " +
                      "hvlh.hvlh_ngaydangky, hvlh.hvlh_diemso " +
                      "FROM nguoidung nd " +
                      "LEFT JOIN hocvien_lophoc hvlh ON nd.nguoidung_id = hvlh.hvlh_hocvien_id " +
                      "LEFT JOIN lophoc lh ON hvlh.hvlh_lophoc_id = lh.lophoc_id " +
                      "WHERE nd.nguoidung_vaitro = 'Học viên' AND lh.lophoc_id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, lophoc_id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                	NguoiDung hocVien = new NguoiDung();
                    hocVien.setNguoidung_id(resultSet.getInt("nguoidung_id"));
                    hocVien.setNguoidung_hoten(resultSet.getString("nguoidung_hoten"));
                    hocVien.setNguoidung_trangthai(resultSet.getString("hvlh_trangthai"));
                    hocVien.setNgaydangky_lophoc(resultSet.getString("hvlh_ngaydangky"));
                    float diemSo = resultSet.getFloat("hvlh_diemso");
                    hocVien.setDiemso_hocvien(resultSet.wasNull() ? 0.0f : diemSo);

                    list.add(hocVien);
                }
            }
        } catch (SQLException e) {
            logger.error("Error fetching hoc vien for lophoc_id {}: {}", lophoc_id, e.getMessage());
            // Có thể ném ngoại lệ hoặc trả về danh sách rỗng tùy theo yêu cầu
            return list;
        }

        return list;
    }
	
	public int deleteNguoiDungById(int nguoidung_id) {
	    //Logger logger = LoggerFactory.getLogger(getClass());
	    String deleteHocVienLopHocQuery = "DELETE FROM english_courses_online.hocvien_lophoc WHERE hvlh_hocvien_id = ?";
	    String deleteNguoiDungQuery = "DELETE FROM english_courses_online.nguoidung WHERE nguoidung_id = ?";

	    try (Connection connection = MySqlConnection.getConnection()) {
	        // Bắt đầu giao dịch
	        connection.setAutoCommit(false);

	        // Xóa bản ghi trong hocvien_lophoc
	        try (PreparedStatement psHocVienLopHoc = connection.prepareStatement(deleteHocVienLopHocQuery)) {
	            psHocVienLopHoc.setInt(1, nguoidung_id);
	            int hocVienRows = psHocVienLopHoc.executeUpdate();
	            logger.info("Đã xóa {} bản ghi trong hocvien_lophoc cho nguoidung_id: {}", hocVienRows, nguoidung_id);
	        }

	        // Xóa bản ghi trong nguoidung
	        try (PreparedStatement psNguoiDung = connection.prepareStatement(deleteNguoiDungQuery)) {
	            psNguoiDung.setInt(1, nguoidung_id);
	            int affectedRows = psNguoiDung.executeUpdate();

	            if (affectedRows > 0) {
	                logger.info("Đã xóa thành công {} dòng trong nguoidung với nguoidung_id: {}", affectedRows, nguoidung_id);
	            } else {
	                logger.warn("Không tìm thấy người dùng với nguoidung_id: {}", nguoidung_id);
	            }

	            // Cam kết giao dịch
	            connection.commit();
	            return affectedRows;
	        }
	    } catch (SQLException e) {
	        logger.error("Lỗi khi xóa nguoidung_id: {}. SQLState: {}, ErrorCode: {}, Message: {}", 
	                     nguoidung_id, e.getSQLState(), e.getErrorCode(), e.getMessage());
	        
	        return 0;
	    } 
	}
	
	

}