package course.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import course.config.MySqlConnection;
import course.model.KhoaHoc;
import course.model.KhoaHocDaBan;
import course.model.ThongKeDoanhThuKhoaHoc;

public class KhoaHocRepository  {
	
	private static final Logger logger = LoggerFactory.getLogger(LopHocRepository.class);
	
	public List<KhoaHoc> getKhoaHocs() {
		List<KhoaHoc> list = new ArrayList<KhoaHoc>();
		String query = "SELECT * FROM english_courses_online.khoahoc";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				KhoaHoc khoaHoc = new KhoaHoc();
				khoaHoc.setKhoahoc_id(resultSet.getInt("khoahoc_id"));
				khoaHoc.setKhoahoc_ten(resultSet.getString("khoahoc_ten"));
				khoaHoc.setKhoahoc_mota(resultSet.getString("khoahoc_mota"));
				khoaHoc.setKhoahoc_thumbnail(resultSet.getString("khoahoc_thumbnail"));
				khoaHoc.setKhoahoc_trinhdo(resultSet.getString("khoahoc_trinhdo"));
				khoaHoc.setKhoahoc_loai(resultSet.getString("khoahoc_loai"));
				khoaHoc.setKhoahoc_trangthai(resultSet.getString("khoahoc_trangthai"));
				khoaHoc.setKhoahoc_ngaybatdau(resultSet.getString("khoahoc_ngaybatdau"));
				khoaHoc.setKhoahoc_ngayketthuc(resultSet.getString("khoahoc_ngayketthuc"));
				khoaHoc.setKhoahoc_thoiluong(resultSet.getInt("khoahoc_thoiluong"));
				khoaHoc.setKhoahoc_gia(resultSet.getInt("khoahoc_gia"));
				khoaHoc.setKhoahoc_discount(resultSet.getInt("khoahoc_discount"));
				khoaHoc.setKhoahoc_created_at(resultSet.getString("khoahoc_created_at"));
				khoaHoc.setKhoahoc_updated_at(resultSet.getString("khoahoc_updated_at"));

				list.add(khoaHoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public int deleteKhoaHocById(int khoahoc_id) {
		String query = "DELETE FROM english_courses_online.khoahoc WHERE khoahoc_id = ?";
		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, khoahoc_id);
			int affectedRows = preparedStatement.executeUpdate();

			System.out.println("Đã xóa " + affectedRows + " dòng với ID khóa học: " + khoahoc_id);
			return affectedRows;
		} catch (SQLException e) {
			System.err.println("Xảy ra lỗi khi xóa khóa học có ID: " + khoahoc_id + ": " + e.getMessage());
			return 0;
		}
	}

	
//	public int insertKhoaHoc(String khoahoc_ten, String khoahoc_mota, String khoahoc_trinhdo, String khoahoc_loai,
//			LocalDate khoahoc_ngaybatdau, LocalDate khoahoc_ngayketthuc, int khoahoc_thoiluong,
//			BigDecimal khoahoc_gia) {
//		String query = "INSERT INTO khoahoc ( khoahoc_ten, khoahoc_mota , khoahoc_trinhdo ,\r\n"
//				+ "				 khoahoc_loai, khoahoc_ngaybatdau , khoahoc_ngayketthuc,\r\n"
//				+ "				 khoahoc_thoiluong, khoahoc_gia) VALUES (?,?,?,?,?,?,?,?)";
//		int isSuccess = 0;
//		try (Connection connection = MySqlConnection.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//			preparedStatement.setString(1, khoahoc_ten);
//			preparedStatement.setString(2, khoahoc_mota);
//			preparedStatement.setString(3, khoahoc_trinhdo);
//			preparedStatement.setString(4, khoahoc_loai);
//			preparedStatement.setDate(5, java.sql.Date.valueOf(khoahoc_ngaybatdau));// Ngày: sử dụng java.sql.Date.valueOf(LocalDate)
//			preparedStatement.setDate(6, java.sql.Date.valueOf(khoahoc_ngayketthuc));
//			preparedStatement.setInt(7, khoahoc_thoiluong);// Thời lượng là int
//			preparedStatement.setBigDecimal(8, khoahoc_gia);// Giá là BigDecimal => dùng setBigDecimal
//
//			isSuccess = preparedStatement.executeUpdate();
//
//			System.out.println("Đã thêm " + isSuccess + " dòng với khóa học: " + khoahoc_ten);
//			return isSuccess;
//		} catch (SQLException e) {
//			System.err.println("Xảy ra lỗi khi thêm khóa học: " + khoahoc_ten + ": " + e.getMessage());
//			return 0;
//		}
//	}
	public int insertKhoaHoc(String khoahoc_ten, String khoahoc_mota, String khoahoc_trinhdo, String khoahoc_loai,
			LocalDate khoahoc_ngaybatdau, LocalDate khoahoc_ngayketthuc, int khoahoc_thoiluong,
			int khoahoc_gia) {
		String query = "INSERT INTO khoahoc ( khoahoc_ten, khoahoc_mota , khoahoc_trinhdo ,\r\n"
				+ "				 khoahoc_loai, khoahoc_trangthai, khoahoc_ngaybatdau , khoahoc_ngayketthuc,\r\n"
				+ "				 khoahoc_thoiluong, khoahoc_gia) VALUES (?,?,?,?,?,?,?,?,?)";
		int isSuccess = 0;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		KhoaHoc khoaHoc = new KhoaHoc();
		khoaHoc.setKhoahoc_ten(khoahoc_ten);
		khoaHoc.setKhoahoc_mota(khoahoc_mota);
		khoaHoc.setKhoahoc_trinhdo(khoahoc_trinhdo);
		khoaHoc.setKhoahoc_loai(khoahoc_loai);
		khoaHoc.setKhoahoc_ngaybatdau(khoahoc_ngayketthuc.format(formatter));
		khoaHoc.setKhoahoc_ngayketthuc(khoahoc_ngayketthuc.format(formatter));
		khoaHoc.setKhoahoc_thoiluong(khoahoc_thoiluong);
		khoaHoc.setKhoahoc_gia(khoahoc_gia);
		khoaHoc.updateTrangThai();
		
		
		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, khoaHoc.getKhoahoc_ten());
			preparedStatement.setString(2, khoaHoc.getKhoahoc_mota());
			preparedStatement.setString(3, khoaHoc.getKhoahoc_trinhdo());
			preparedStatement.setString(4, khoaHoc.getKhoahoc_loai());
			preparedStatement.setString(5, khoaHoc.getKhoahoc_trangthai());
			preparedStatement.setString(6, khoaHoc.getKhoahoc_ngaybatdau());// Ngày: sử dụng java.sql.Date.valueOf(LocalDate)
			preparedStatement.setString(7, khoaHoc.getKhoahoc_ngayketthuc());
			preparedStatement.setInt(8, khoaHoc.getKhoahoc_thoiluong());// Thời lượng là int
			preparedStatement.setInt(9, khoaHoc.getKhoahoc_gia());// Giá là BigDecimal => dùng setBigDecimal

			isSuccess = preparedStatement.executeUpdate();

			System.out.println("Đã thêm " + isSuccess + " dòng với khóa học: " + khoahoc_ten);
			return isSuccess;
		} catch (SQLException e) {
			System.err.println("Xảy ra lỗi khi thêm khóa học: " + khoahoc_ten + ": " + e.getMessage());
			return 0;
		}
	}

	
	public int updateKhoaHoc( 
			String khoahoc_ten, 
			String khoahoc_mota, 
			String khoahoc_trinhdo, 
			String khoahoc_loai,
			String khoahoc_trangthai, 
			String khoahoc_ngaybatdau, 
			String khoahoc_ngayketthuc, 
			int khoahoc_thoiluong,
			int khoahoc_gia,
			int khoahoc_id) {
		String query = "UPDATE khoahoc\r\n"
				+ "SET\r\n"
				+ "    khoahoc_ten = ?,\r\n"
				+ "    khoahoc_mota = ?,\r\n"
				+ "    khoahoc_trinhdo = ?,\r\n"
				+ "    khoahoc_loai = ?,\r\n"
				+ "    khoahoc_trangthai = ?,\r\n"
				+ "    khoahoc_ngaybatdau = ?,\r\n"
				+ "    khoahoc_ngayketthuc = ?,\r\n"
				+ "    khoahoc_thoiluong = ?,\r\n"
				+ "    khoahoc_gia = ?\r\n"
				+ "WHERE khoahoc_id = ?;";
		int isSuccess = 0;
		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, khoahoc_ten);
			preparedStatement.setString(2, khoahoc_mota);
			preparedStatement.setString(3, khoahoc_trinhdo);
			preparedStatement.setString(4, khoahoc_loai);
			preparedStatement.setString(5, khoahoc_trangthai);
			preparedStatement.setString(6, khoahoc_ngaybatdau);
			preparedStatement.setString(7, khoahoc_ngayketthuc);
			preparedStatement.setInt(8, khoahoc_thoiluong);
			preparedStatement.setInt(9, khoahoc_gia);
			preparedStatement.setInt(10, khoahoc_id);

			isSuccess = preparedStatement.executeUpdate();

			System.out.println("Đã update " + isSuccess + " dòng với khóa học: " + khoahoc_ten);
			return isSuccess;
		} catch (SQLException e) {
			System.err.println("Xảy ra lỗi khi update khóa học: " + khoahoc_ten + ": " + e.getMessage());
			return 0;
		}
	}

	
//	public List<KhoaHoc> getKhoaHocById(int khoahoc_id) {
//        List<KhoaHoc> list = new ArrayList<>();
//        String query = "SELECT * FROM english_courses_online.khoahoc WHERE khoahoc_id = ?";
//
//        try (Connection connection = MySqlConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setInt(1, khoahoc_id); // Gán tham số trước
//            try (ResultSet resultSet = preparedStatement.executeQuery()) { // Thực thi sau
//                while (resultSet.next()) {
//                    KhoaHoc khoaHoc = new KhoaHoc();
//                    khoaHoc.setKhoahoc_id(resultSet.getInt("khoahoc_id"));
//                    khoaHoc.setKhoahoc_ten(resultSet.getString("khoahoc_ten"));
//                    khoaHoc.setKhoahoc_mota(resultSet.getString("khoahoc_mota"));
//                    khoaHoc.setKhoahoc_thumbnail(resultSet.getString("khoahoc_thumbnail"));
//                    khoaHoc.setKhoahoc_trinhdo(resultSet.getString("khoahoc_trinhdo"));
//                    khoaHoc.setKhoahoc_loai(resultSet.getString("khoahoc_loai"));
//                    khoaHoc.setKhoahoc_trangthai(resultSet.getString("khoahoc_trangthai"));
//                    khoaHoc.setKhoahoc_ngaybatdau(resultSet.getString("khoahoc_ngaybatdau"));
//                    khoaHoc.setKhoahoc_ngayketthuc(resultSet.getString("khoahoc_ngayketthuc"));
//                    khoaHoc.setKhoahoc_thoiluong(resultSet.getInt("khoahoc_thoiluong"));
//                    khoaHoc.setKhoahoc_gia(resultSet.getInt("khoahoc_gia"));
//                    khoaHoc.setKhoahoc_discount(resultSet.getInt("khoahoc_discount"));
//                    khoaHoc.setKhoahoc_created_at(resultSet.getString("khoahoc_created_at"));
//                    khoaHoc.setKhoahoc_updated_at(resultSet.getString("khoahoc_updated_at"));
//                    list.add(khoaHoc);
//                }
//            }
//        } catch (SQLException e) {
//            System.err.println("Lỗi SQL khi lấy khóa học: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return list;
//    }
	public List<KhoaHoc> getKhoaHocById(int khoahoc_id) {
        List<KhoaHoc> list = new ArrayList<>();
        String query = "SELECT * FROM english_courses_online.khoahoc WHERE khoahoc_id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, khoahoc_id); // Gán tham số trước
            try (ResultSet resultSet = preparedStatement.executeQuery()) { // Thực thi sau
                while (resultSet.next()) {
                    KhoaHoc khoaHoc = new KhoaHoc();
                    khoaHoc.setKhoahoc_id(resultSet.getInt("khoahoc_id"));
                    khoaHoc.setKhoahoc_ten(resultSet.getString("khoahoc_ten"));
                    khoaHoc.setKhoahoc_mota(resultSet.getString("khoahoc_mota"));
                    khoaHoc.setKhoahoc_thumbnail(resultSet.getString("khoahoc_thumbnail"));
                    khoaHoc.setKhoahoc_trinhdo(resultSet.getString("khoahoc_trinhdo"));
                    khoaHoc.setKhoahoc_loai(resultSet.getString("khoahoc_loai"));
                    khoaHoc.setKhoahoc_trangthai(resultSet.getString("khoahoc_trangthai"));
                    khoaHoc.setKhoahoc_ngaybatdau(resultSet.getString("khoahoc_ngaybatdau"));
                    khoaHoc.setKhoahoc_ngayketthuc(resultSet.getString("khoahoc_ngayketthuc"));
                    khoaHoc.setKhoahoc_thoiluong(resultSet.getInt("khoahoc_thoiluong"));
                    khoaHoc.setKhoahoc_gia(resultSet.getInt("khoahoc_gia"));
                    khoaHoc.setKhoahoc_discount(resultSet.getInt("khoahoc_discount"));
                    khoaHoc.setKhoahoc_created_at(resultSet.getString("khoahoc_created_at"));
                    khoaHoc.setKhoahoc_updated_at(resultSet.getString("khoahoc_updated_at"));
                    khoaHoc.updateTrangThai();
                    list.add(khoaHoc);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi lấy khóa học: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

	
//	public List<KhoaHocDaBan> getKhoaHocDaBanTheoThang() {
//		List<KhoaHocDaBan> khoaHocDaBanList = new ArrayList<>();
//        String query = "SELECT k.khoahoc_ten AS name, " +
//                      "JSON_ARRAY(" +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 1 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 2 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 3 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 4 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 5 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 6 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 7 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 8 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 9 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 10 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 11 THEN 1 ELSE 0 END), " +
//                      "SUM(CASE WHEN MONTH(k.khoahoc_ngaybatdau) = 12 THEN 1 ELSE 0 END)" +
//                      ") AS data " +
//                      "FROM khoahoc k " +
//                      "LEFT JOIN lophoc l ON k.khoahoc_id = l.lophoc_khoahoc_id " +
//                      "LEFT JOIN hocvien_lophoc hl ON l.lophoc_id = hl.hvlh_lophoc_id " +
//                      "GROUP BY k.khoahoc_id, k.khoahoc_ten";
//
//        try (Connection connection = MySqlConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query);
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String jsonData = resultSet.getString("data");
//
//                // Parse JSON array to int array
//                String[] dataStr = jsonData.replaceAll("[\\[\\]]", "").split(",");
//                int[] data = new int[12];
//                for (int i = 0; i < dataStr.length; i++) {
//                    data[i] = Integer.parseInt(dataStr[i].trim());
//                }
//
//                KhoaHocDaBan chartData = new KhoaHocDaBan(name, data);
//                khoaHocDaBanList.add(chartData);
//            }
//        } catch (SQLException e) {
//            System.err.println("Lỗi SQL khi lấy dữ liệu biểu đồ: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return khoaHocDaBanList;
//    }
	public List<KhoaHocDaBan> getKhoaHocDaBanTheoThang() {
		List<KhoaHocDaBan> khoaHocDaBanList = new ArrayList<>();
        String query = "SELECT k.khoahoc_ten AS name,\r\n"
        		+ "       JSON_ARRAY(\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 1 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 2 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 3 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 4 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 5 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 6 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 7 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 8 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 9 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 10 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 11 THEN 1 ELSE 0 END),\r\n"
        		+ "           SUM(CASE WHEN MONTH(hl.hvlh_ngaydangky) = 12 THEN 1 ELSE 0 END)\r\n"
        		+ "       ) AS data\r\n"
        		+ "FROM khoahoc k\r\n"
        		+ "LEFT JOIN lophoc l ON k.khoahoc_id = l.lophoc_khoahoc_id\r\n"
        		+ "LEFT JOIN hocvien_lophoc hl ON l.lophoc_id = hl.hvlh_lophoc_id\r\n"
        		+ "GROUP BY k.khoahoc_id, k.khoahoc_ten;";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String jsonData = resultSet.getString("data");

                // Parse JSON array to int array
                String[] dataStr = jsonData.replaceAll("[\\[\\]]", "").split(",");
                int[] data = new int[12];
                for (int i = 0; i < dataStr.length; i++) {
                    data[i] = Integer.parseInt(dataStr[i].trim());
                }

                KhoaHocDaBan chartData = new KhoaHocDaBan(name, data);
                khoaHocDaBanList.add(chartData);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi lấy dữ liệu biểu đồ: " + e.getMessage());
            e.printStackTrace();
        }

        return khoaHocDaBanList;
    }
	
	public List<ThongKeDoanhThuKhoaHoc> getDoanhThuKhoaHoc() {
        List<ThongKeDoanhThuKhoaHoc> list = new ArrayList<>();

        String query = "SELECT " +
                "    khoahoc.khoahoc_id, " +
                "    khoahoc.khoahoc_ten, " +
                "    khoahoc.khoahoc_gia, " +
                "    COUNT(DISTINCT hocvien_lophoc.hvlh_hocvien_id) AS so_luong_hoc_vien, " +
                "    (khoahoc.khoahoc_gia * COUNT(DISTINCT hocvien_lophoc.hvlh_hocvien_id)) AS doanh_thu " +
                "FROM khoahoc " +
                "JOIN lophoc ON khoahoc.khoahoc_id = lophoc.lophoc_khoahoc_id " +
                "JOIN hocvien_lophoc ON lophoc.lophoc_id = hocvien_lophoc.hvlh_lophoc_id " +
                "JOIN nguoidung ON hocvien_lophoc.hvlh_hocvien_id = nguoidung.nguoidung_id " +
                "WHERE nguoidung.nguoidung_vaitro = 'Học viên' " +
                "GROUP BY khoahoc.khoahoc_id, khoahoc.khoahoc_ten, khoahoc.khoahoc_gia";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (connection == null) {
                logger.error("Database connection is null");
                return list; // Trả về danh sách rỗng nếu không kết nối được
            }

            while (resultSet.next()) {
                ThongKeDoanhThuKhoaHoc doanhThuKhoaHoc = new ThongKeDoanhThuKhoaHoc(
                    resultSet.getInt("khoahoc_id"),
                    resultSet.getString("khoahoc_ten"),
                    resultSet.getDouble("khoahoc_gia"),
                    resultSet.getInt("so_luong_hoc_vien"),
                    resultSet.getDouble("doanh_thu")
                );
                list.add(doanhThuKhoaHoc);
            }
        } catch (SQLException e) {
            logger.error("Lỗi SQL khi lấy dữ liệu biểu đồ: {}", e.getMessage());
        }

        return list;
    }
	
	public List<KhoaHoc> getTimeLineKhoaHoc(){
		List<KhoaHoc> list = new ArrayList<>();

        String query = "SELECT " +
                "    khoahoc_id, " +
                "    khoahoc_ten, " +
                "    khoahoc_ngaybatdau, " +
                "    khoahoc_ngayketthuc " +
                "FROM khoahoc " +
                "WHERE khoahoc_ngaybatdau IS NOT NULL " +
                "AND khoahoc_ngayketthuc IS NOT NULL " +
                "ORDER BY khoahoc_ngaybatdau";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (connection == null) {
                logger.error("Database connection is null");
                return list; // Trả về danh sách rỗng nếu không kết nối được
            }

            if (!resultSet.isBeforeFirst()) {
                logger.warn("No data found in result set");
            }

            while (resultSet.next()) {
                KhoaHoc khoaHoc = new KhoaHoc();
                khoaHoc.setKhoahoc_id(resultSet.getInt("khoahoc_id"));
                khoaHoc.setKhoahoc_ten(resultSet.getString("khoahoc_ten"));
                khoaHoc.setKhoahoc_ngaybatdau(resultSet.getString("khoahoc_ngaybatdau"));
                khoaHoc.setKhoahoc_ngayketthuc(resultSet.getString("khoahoc_ngayketthuc"));
                list.add(khoaHoc);
            }
        } catch (SQLException e) {
            logger.error("Lỗi SQL khi lấy dữ liệu biểu đồ: {}", e.getMessage());
        }

        return list;
    }

}
