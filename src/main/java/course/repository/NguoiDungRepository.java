package course.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import course.config.MySqlConnection;
import course.model.GiangVienData;
import course.model.NguoiDung;

public class NguoiDungRepository {
    private static final Logger logger = LoggerFactory.getLogger(NguoiDungRepository.class);

    public List<NguoiDung> getNguoiDungByNguoiDung_emailAndNguoiDung_MatKhau(String nguoiDung_email, String nguoiDung_MatKhau) {
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
        String query = "SELECT \r\n"
        		+ "    nd.nguoidung_id,\r\n"
        		+ "    nd.nguoidung_hoten as hoten,\r\n"
        		+ "    COUNT(lh.lophoc_id) as so_lophoc\r\n"
        		+ "FROM \r\n"
        		+ "    nguoidung nd\r\n"
        		+ "    INNER JOIN lophoc lh ON nd.nguoidung_id = lh.lophoc_giaovien_id\r\n"
        		+ "WHERE \r\n"
        		+ "    nd.nguoidung_vaitro = 'Giáo viên'\r\n"
        		+ "GROUP BY \r\n"
        		+ "    nd.nguoidung_id,\r\n"
        		+ "    nd.nguoidung_hoten\r\n"
        		+ "ORDER BY \r\n"
        		+ "    so_lophoc DESC\r\n"
        		+ "LIMIT 7;";

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
            logger.error("Error fetching NguoiDung with {}",  e);
        }

        return list;
    }
    
    
    public List<GiangVienData> getGiangVien() {
        List<GiangVienData> list = new ArrayList<>();
        String query = "SELECT \r\n"
        		+ "    CASE \r\n"
        		+ "        WHEN nguoidung_trinhdo IN ('A1', 'A2') THEN 'Basic'\r\n"
        		+ "        WHEN nguoidung_trinhdo IN ('B1', 'B2') THEN 'Intermediate'\r\n"
        		+ "        WHEN nguoidung_trinhdo IN ('C1', 'C2') THEN 'Advanced'\r\n"
        		+ "        ELSE 'Unknown'\r\n"
        		+ "    END AS level_category,\r\n"
        		+ "    COUNT(*) as count\r\n"
        		+ "FROM \r\n"
        		+ "    nguoidung\r\n"
        		+ "WHERE nguoidung_vaitro = 'Giáo viên'\r\n"
        		+ "GROUP BY \r\n"
        		+ "    CASE \r\n"
        		+ "        WHEN nguoidung_trinhdo IN ('A1', 'A2') THEN 'Basic'\r\n"
        		+ "        WHEN nguoidung_trinhdo IN ('B1', 'B2') THEN 'Intermediate'\r\n"
        		+ "        WHEN nguoidung_trinhdo IN ('C1', 'C2') THEN 'Advanced'\r\n"
        		+ "        ELSE 'Unknown'\r\n"
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
        String query = "SELECT COUNT(*) as total_teachers\n"
                + "FROM nguoidung\n"
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
    
}