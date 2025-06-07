package course.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import course.config.MySqlConnection;
import course.model.LopHoc;
import course.model.NguoiDung;

public class LopHocRepository  {
	private static final Logger logger = LoggerFactory.getLogger(LopHocRepository.class);

	
	public List<LopHoc> getLopHocs() {
		List<LopHoc> list = new ArrayList<>();
		String query = "SELECT * FROM english_courses_online.lophoc";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				LopHoc lopHoc = new LopHoc();
				lopHoc.setLophoc_id(resultSet.getInt("lophoc_id"));
				lopHoc.setLophoc_khoahoc_id(resultSet.getInt("lophoc_khoahoc_id"));
				lopHoc.setLophoc_ten(resultSet.getString("lophoc_ten"));
				lopHoc.setLophoc_mota(resultSet.getString("lophoc_mota"));
				lopHoc.setLophoc_trangthai(resultSet.getString("lophoc_trangthai"));
				lopHoc.setLophoc_ngaybatdau(resultSet.getString("lophoc_ngaybatdau"));
				lopHoc.setLophoc_ngayketthuc(resultSet.getString("lophoc_ngayketthuc"));
				lopHoc.setLophoc_soluonghv(resultSet.getInt("lophoc_soluonghv"));
				lopHoc.setLophoc_giaovien_id(resultSet.getInt("lophoc_giaovien_id"));
				lopHoc.setLophoc_phonghoc(resultSet.getString("lophoc_phonghoc"));
				lopHoc.setLophoc_lichhoc(resultSet.getString("lophoc_lichhoc"));
				lopHoc.setLophoc_tailieu(resultSet.getString("lophoc_tailieu"));
				lopHoc.setLophoc_created_at(resultSet.getString("lophoc_created_at"));
				lopHoc.setLophoc_updated_at(resultSet.getString("lophoc_updated_at"));

				list.add(lopHoc);
			}
		} catch (SQLException e) {
			logger.error("Error fetching LopHoc list", e);
		}

		return list;
	}

	
	public List<LopHoc> getLopHocByKhoaHocId(int khoahoc_id) {
		List<LopHoc> list = new ArrayList<>();
		String query = "SELECT " + "lophoc.lophoc_id, " + "lophoc.lophoc_khoahoc_id, " + "lophoc.lophoc_ten, "
				+ "lophoc.lophoc_mota, " + "lophoc.lophoc_trangthai, " + "lophoc.lophoc_ngaybatdau, "
				+ "lophoc.lophoc_ngayketthuc, " + "lophoc.lophoc_soluonghv, "
				+ "nguoidung.nguoidung_hoten AS giaovien_hoten, " + "lophoc.lophoc_phonghoc, "
				+ "lophoc.lophoc_lichhoc, " + "lophoc.lophoc_tailieu, " + "lophoc.lophoc_created_at, "
				+ "lophoc.lophoc_updated_at " + "FROM lophoc "
				+ "JOIN nguoidung ON lophoc.lophoc_giaovien_id = nguoidung.nguoidung_id "
				+ "WHERE lophoc.lophoc_khoahoc_id = ?";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, khoahoc_id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					LopHoc lopHoc = new LopHoc();
					lopHoc.setLophoc_id(resultSet.getInt("lophoc_id"));
					lopHoc.setLophoc_khoahoc_id(resultSet.getInt("lophoc_khoahoc_id"));
					lopHoc.setLophoc_ten(resultSet.getString("lophoc_ten"));
					lopHoc.setLophoc_mota(resultSet.getString("lophoc_mota"));
					lopHoc.setLophoc_trangthai(resultSet.getString("lophoc_trangthai"));
					lopHoc.setLophoc_ngaybatdau(resultSet.getString("lophoc_ngaybatdau"));
					lopHoc.setLophoc_ngayketthuc(resultSet.getString("lophoc_ngayketthuc"));
					lopHoc.setLophoc_soluonghv(resultSet.getInt("lophoc_soluonghv"));
					lopHoc.setGiaovien_hoten(resultSet.getString("giaovien_hoten"));
					lopHoc.setLophoc_phonghoc(resultSet.getString("lophoc_phonghoc"));
					lopHoc.setLophoc_lichhoc(resultSet.getString("lophoc_lichhoc"));
					lopHoc.setLophoc_tailieu(resultSet.getString("lophoc_tailieu"));
					lopHoc.setLophoc_created_at(resultSet.getString("lophoc_created_at"));
					lopHoc.setLophoc_updated_at(resultSet.getString("lophoc_updated_at"));
					list.add(lopHoc);
				}
			}
		} catch (SQLException e) {
			logger.error("Error fetching LopHoc list for khoahoc_id: " + khoahoc_id, e);
		}
		return list;
	}

	
	public int deleteLopHocById(int lophoc_id) {
		String query = "DELETE FROM english_courses_online.lophoc WHERE lophoc_id = ?";
		int isDelete = 0;

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, lophoc_id);
			isDelete = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error deleting LopHoc with id: {}", lophoc_id, e);
		}

		return isDelete;
	}

	
	public int insertLopHoc(int lophoc_khoahoc_id, String lophoc_ten, String lophoc_tailieu, String lophoc_ngaybatdau,
			String lophoc_ngayketthuc, int lophoc_giaovien_id, String lophoc_mota) {

		int isSuccess = 0;
		try (Connection connection = MySqlConnection.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.execute("SET FOREIGN_KEY_CHECKS = 0");

			String insertQuery = "INSERT INTO lophoc (" + "lophoc_khoahoc_id, lophoc_ten, lophoc_tailieu, "
					+ "lophoc_ngaybatdau, lophoc_ngayketthuc, " + "lophoc_giaovien_id, lophoc_mota) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
				preparedStatement.setInt(1, lophoc_khoahoc_id);
				preparedStatement.setString(2, lophoc_ten);
				preparedStatement.setString(3, lophoc_tailieu);
				preparedStatement.setString(4, lophoc_ngaybatdau);
				preparedStatement.setString(5, lophoc_ngayketthuc);
				preparedStatement.setInt(6, lophoc_giaovien_id);
				preparedStatement.setString(7, lophoc_mota);

				isSuccess = preparedStatement.executeUpdate();
			}

			stmt.execute("SET FOREIGN_KEY_CHECKS = 1");

			System.out.println("Đã thêm " + isSuccess + " dòng với lớp học " + lophoc_ten);

		} catch (SQLException e) {
			logger.error("Có lỗi khi thêm lớp học: {}", lophoc_ten, e);
		}

		return isSuccess;

	}

	
	public int updateLopHoc(int lophocId, int lophocKhoahocId, String lophocTen, String lophocMota,
			String lophocTrangthai, String lophocNgaybatdau, String lophocNgayketthuc, String giaovienHoten,
			String lophocTailieu) {
// Kiểm tra dữ liệu đầu vào
		if (lophocId <= 0 || lophocKhoahocId <= 0 || lophocTen == null || lophocTen.trim().isEmpty()) {
			logger.warn("Invalid input: lophocId={}, lophocKhoahocId={}, lophocTen={}", lophocId, lophocKhoahocId,
					lophocTen);
			return 0;
		}

// Tìm nguoidung_id dựa trên nguoidung_hoten và vaitro = 'Giáo viên'
		int giaovienId = 0;
		String findGiaoVienQuery = "SELECT nguoidung_id FROM english_courses_online.nguoidung "
				+ "WHERE nguoidung_hoten = ? AND nguoidung_vaitro = 'Giáo viên';";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement findStmt = connection.prepareStatement(findGiaoVienQuery)) {

			findStmt.setString(1, giaovienHoten);
			ResultSet rs = findStmt.executeQuery();
			if (rs.next()) {
				giaovienId = rs.getInt("nguoidung_id");
			} else {
				logger.warn("No teacher found with name: {}", giaovienHoten);
				return 0; // Không tìm thấy giáo viên
			}
		} catch (SQLException e) {
			logger.error("Error finding teacher with name: {}", giaovienHoten, e);
			return 0;
		}

// Câu lệnh UPDATE cho bảng lophoc
		String updateQuery = "UPDATE english_courses_online.lophoc " + "SET lophoc_khoahoc_id = ?, "
				+ "lophoc_ten = ?, " + "lophoc_mota = ?, " + "lophoc_trangthai = ?, " + "lophoc_ngaybatdau = ?, "
				+ "lophoc_ngayketthuc = ?, " + "lophoc_giaovien_id = ?, " + "lophoc_tailieu = ? "
				+ "WHERE lophoc_id = ?";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

			preparedStatement.setInt(1, lophocKhoahocId);
			preparedStatement.setString(2, lophocTen);
			preparedStatement.setString(3, lophocMota != null ? lophocMota : "");
			preparedStatement.setString(4, lophocTrangthai);
			preparedStatement.setString(5, lophocNgaybatdau);
			preparedStatement.setString(6, lophocNgayketthuc);
			preparedStatement.setInt(7, giaovienId);
			preparedStatement.setString(8, lophocTailieu != null ? lophocTailieu : "");
			preparedStatement.setInt(9, lophocId);

			int rowsAffected = preparedStatement.executeUpdate();
			logger.info("Updated {} row(s) for LopHoc with ID: {}, Name: {}", rowsAffected, lophocId, lophocTen);
			return rowsAffected;

		} catch (SQLException e) {
			logger.error("Error updating LopHoc with ID: {}", lophocId, e);
			return 0;
		}
	}
//	public int updateLopHoc(int lophoc_id,
//    		int lophoc_khoahoc_id,
//    		String lophoc_ten,
//    		String lophoc_mota,
//    		String lophoc_trangthai,
//    		String lophoc_ngaybatdau,
//    		String lophoc_ngayketthuc,
////    		int lophoc_giaovien_id,
//    		String giaovien_hoten,
//    		String lophoc_tailieu) {
//        
//		String query = "UPDATE lophoc\r\n"
//				+ "SET\r\n"
//				+ "    lophoc_khoahoc_id = ?,\r\n"
//				+ "    lophoc_ten = ?,\r\n"
//				+ "    lophoc_mota = ?,\r\n"
//				+ "    lophoc_trangthai = ?,\r\n"
//				+ "    lophoc_ngaybatdau = ?,\r\n"
//				+ "    lophoc_ngayketthuc = ?,\r\n"
//				//+ "    lophoc_giaovien_id = ?,\r\n"
//				+ "    nguoidung_hoten = ?,\r\n"
//				+ "    lophoc_tailieu = ?\r\n"
//				+ "WHERE\r\n"
//				+ "    lophoc_id = ?;";
//		int isSuccess = 0;
//		try (Connection connection = MySqlConnection.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//			preparedStatement.setInt(1, lophoc_khoahoc_id);
//			preparedStatement.setString(2, lophoc_ten);
//			preparedStatement.setString(3, lophoc_mota);
//			preparedStatement.setString(4, lophoc_trangthai);
//			preparedStatement.setString(5, lophoc_ngaybatdau);
//			preparedStatement.setString(6, lophoc_ngayketthuc);
//			preparedStatement.setString(7, giaovien_hoten);
//			preparedStatement.setString(8, lophoc_tailieu);
//			preparedStatement.setInt(9, lophoc_id);
//			
//
//			isSuccess = preparedStatement.executeUpdate();
//
//			System.out.println("Đã update " + isSuccess + " dòng với lớp học: " + lophoc_ten);
//			return isSuccess;
//		} catch (SQLException e) {
//			System.err.println("Xảy ra lỗi khi update lớp học: " + lophoc_ten + ": " + e.getMessage());
//			return 0;
//		}
//    }

	
	public List<LopHoc> getLopHocById(int lophoc_id) {
		List<LopHoc> list = new ArrayList<>();
		String query = "SELECT lophoc.*, nguoidung.nguoidung_hoten\r\n" + "FROM english_courses_online.lophoc\r\n"
				+ "JOIN english_courses_online.nguoidung ON lophoc.lophoc_giaovien_id = nguoidung.nguoidung_id\r\n"
				+ "WHERE lophoc.lophoc_id = ? AND nguoidung.nguoidung_vaitro = 'Giáo viên';";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, lophoc_id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					LopHoc lopHoc = new LopHoc();
					lopHoc.setLophoc_id(resultSet.getInt("lophoc_id"));
					lopHoc.setLophoc_khoahoc_id(resultSet.getInt("lophoc_khoahoc_id"));
					lopHoc.setLophoc_ten(resultSet.getString("lophoc_ten"));
					lopHoc.setLophoc_mota(resultSet.getString("lophoc_mota"));
					lopHoc.setLophoc_trangthai(resultSet.getString("lophoc_trangthai"));
					lopHoc.setLophoc_ngaybatdau(resultSet.getString("lophoc_ngaybatdau"));
					lopHoc.setLophoc_ngayketthuc(resultSet.getString("lophoc_ngayketthuc"));
					lopHoc.setLophoc_soluonghv(resultSet.getInt("lophoc_soluonghv"));
					lopHoc.setLophoc_giaovien_id(resultSet.getInt("lophoc_giaovien_id"));
					lopHoc.setLophoc_phonghoc(resultSet.getString("lophoc_phonghoc"));
					lopHoc.setLophoc_lichhoc(resultSet.getString("lophoc_lichhoc"));
					lopHoc.setLophoc_tailieu(resultSet.getString("lophoc_tailieu"));
					lopHoc.setLophoc_created_at(resultSet.getString("lophoc_created_at"));
					lopHoc.setLophoc_updated_at(resultSet.getString("lophoc_updated_at"));
					lopHoc.setGiaovien_hoten(
							resultSet.getString("nguoidung_hoten") != null ? resultSet.getString("nguoidung_hoten")
									: "");

					list.add(lopHoc);
				}
			}
		} catch (SQLException e) {
			logger.error("Error fetching LopHoc list", e);
		}

		return list;
	}

}