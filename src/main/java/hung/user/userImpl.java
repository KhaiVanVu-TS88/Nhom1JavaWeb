package hung.user;

import java.sql.Connection;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import hung.Object.CauHoiObject;
import hung.Object.DiemSo;
import hung.Object.KhoaHoc;
import hung.Object.LichSuThanhToan;
import hung.Object.NguoiDungObject;

public class userImpl implements user {

	@Override
	public boolean addUser(NguoiDungObject item,String role) {
		// TODO Auto-generated method stub
        // Mã hóa mật khẩu
        String hashedPassword = BCrypt.hashpw(item.getNguoidung_matkhau(), BCrypt.gensalt(12));

        // Câu lệnh SQL để thêm người dùng mới
        String sql = "INSERT INTO nguoidung (" +
                "nguoidung_email, nguoidung_matkhau, nguoidung_hoten, nguoidung_sdt, " +
                "nguoidung_diachi, nguoidung_avatar, nguoidung_vaitro, nguoidung_trangthai, " +
                "nguoidung_sodu, nguoidung_nganhang, nguoidung_stk, nguoidung_trinhdo, " +
                "nguoidung_created_at, nguoidung_updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online", "root", "123456");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Gán giá trị cho các tham số trong PreparedStatement
            pstmt.setString(1, item.getNguoidung_email());
            pstmt.setString(2, hashedPassword); // Lưu mật khẩu đã mã hóa
            pstmt.setString(3, item.getNguoidung_hoten());
            pstmt.setString(4, item.getNguoidung_sdt());
            pstmt.setString(5, item.getNguoidung_diachi());
            pstmt.setString(6, item.getNguoidung_avatar());
            pstmt.setString(7, role);
            pstmt.setString(8, "Kích hoạt");
            pstmt.setDouble(9, 0.0);
            pstmt.setString(10, item.getNguoidung_nganhang());
            pstmt.setString(11, item.getNguoidung_stk());
            pstmt.setString(12, item.getNguoidung_trinhdo());
            pstmt.setTimestamp(13, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setTimestamp(14, Timestamp.valueOf(LocalDateTime.now()));

            // Thực thi câu lệnh
            int rowsAffected = pstmt.executeUpdate();
           return rowsAffected  > 0 ;
       } catch (SQLException e) {
            System.err.println("Lỗi khi thêm người dùng: " + e.getMessage());
            return false;
        }
	}

	@Override
	public boolean editUser(NguoiDungObject item) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online", "root", "123456")) {
	        String sql = "UPDATE nguoidung SET nguoidung_email = ?, nguoidung_matkhau = ?, nguoidung_hoten = ?, nguoidung_sdt = ?, nguoidung_diachi = ?, nguoidung_sodu = ?, nguoidung_trinhdo = ?, nguoidung_updated_at = NOW() WHERE nguoidung_id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, item.getNguoidung_email());
	        stmt.setString(2, item.getNguoidung_matkhau());
	        stmt.setString(3, item.getNguoidung_hoten());
	        stmt.setString(4, item.getNguoidung_sdt());
	        stmt.setString(5, item.getNguoidung_diachi());
	        stmt.setString(6, item.getNguoidung_sodu());
	        stmt.setString(7, item.getNguoidung_trinhdo());
	        stmt.setInt(8, item.getNguoidung_id());
	        int rows = stmt.executeUpdate();
	        return rows > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean delUser(NguoiDungObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<NguoiDungObject> getUsers(NguoiDungObject similar, int at, byte total,String role) {
		// TODO Auto-generated method stub
		
		
		ArrayList<NguoiDungObject> items = new ArrayList<>();
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Không tìm thấy MySQL JDBC Driver");
			}
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online","root","123456");
			String sql = "SELECT nguoidung_id, nguoidung_email,nguoidung_matkhau, nguoidung_hoten, "
	                   + "nguoidung_sdt, nguoidung_diachi, "
	                   + "nguoidung_sodu, nguoidung_created_at,nguoidung_updated_at FROM nguoidung where nguoidung_vaitro  = \""+role+"\" and nguoidung_trangthai!=\"Chờ xác nhận\" and nguoidung_trangthai!=\"Vô hiệu hóa\"";
			PreparedStatement pstmt = connect.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				 NguoiDungObject user = new NguoiDungObject();
				// Sử dụng ternary operator để kiểm tra NULL
				 user.setNguoidung_id(rs.getInt("nguoidung_id")); 
				 // getInt() trả về 0 nếu NULL nên không cần kiểm tra

				 // Với các trường String, kiểm tra NULL trước khi set
				 user.setNguoidung_email(rs.getString("nguoidung_email") != null ? rs.getString("nguoidung_email") : "");
				 user.setNguoidung_matkhau(rs.getString("nguoidung_matkhau") != null ? rs.getString("nguoidung_matkhau") : "");
				 user.setNguoidung_hoten(rs.getString("nguoidung_hoten") != null ? rs.getString("nguoidung_hoten") : "Không có tên");
				 user.setNguoidung_sdt(rs.getString("nguoidung_sdt") != null ? rs.getString("nguoidung_sdt") : "Chưa cập nhật");
				 user.setNguoidung_diachi(rs.getString("nguoidung_diachi") != null ? rs.getString("nguoidung_diachi") : "");
				 user.setNguoidung_sodu(rs.getString("nguoidung_sodu") != null ? rs.getString("nguoidung_sodu") : "0");

				 // Với trường ngày tháng
				 user.setNguoidung_created_at(rs.getString("nguoidung_created_at") != null ? rs.getString("nguoidung_created_at") : "");
				 user.setNguoidung_updated_at(rs.getString("nguoidung_updated_at") != null ? rs.getString("nguoidung_updated_at") : "");
	                
	                items.add(user);
	                
            }
			connect.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi ket noi");
		}finally {
			
		}
		return items;
	}

	@Override
	public NguoiDungObject getUser(int id) {
		// TODO Auto-generated method stub
		NguoiDungObject item = new NguoiDungObject();
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Không tìm thấy MySQL JDBC Driver");
			}
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online","root","123456");
			String sql = "SELECT nguoidung_id, nguoidung_email,nguoidung_matkhau, nguoidung_hoten, "
	                   + "nguoidung_sdt, nguoidung_diachi, nguoidung_nganhang , nguoidung_stk , nguoidung_vaitro ,  "
	                   + "nguoidung_trangthai,nguoidung_sodu, nguoidung_created_at,nguoidung_updated_at,nguoidung_trinhdo FROM nguoidung where nguoidung_id = ?";
			PreparedStatement pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			
				  
			while(rs.next()) {
				// Xử lý các trường cơ bản
				item.setNguoidung_id(rs.getInt("nguoidung_id")); // getInt() trả về 0 nếu NULL

				// Xử lý các trường String với giá trị mặc định phù hợp
				item.setNguoidung_email(rs.getString("nguoidung_email") != null ? rs.getString("nguoidung_email") : "");
				item.setNguoidung_matkhau(rs.getString("nguoidung_matkhau") != null ? rs.getString("nguoidung_matkhau") : "");
				item.setNguoidung_hoten(rs.getString("nguoidung_hoten") != null ? rs.getString("nguoidung_hoten") : "Không có");
				item.setNguoidung_sdt(rs.getString("nguoidung_sdt") != null ? rs.getString("nguoidung_sdt") : "Chưa cập nhật");
				item.setNguoidung_diachi(rs.getString("nguoidung_diachi") != null ? rs.getString("nguoidung_diachi") : "Không có");
				item.setNguoidung_sodu(rs.getString("nguoidung_sodu") != null ? rs.getString("nguoidung_sodu") : "0");

				// Xử lý trường ngày tháng
				item.setNguoidung_created_at(rs.getString("nguoidung_created_at") != null ? rs.getString("nguoidung_created_at") : "");
				item.setNguoidung_updated_at(rs.getString("nguoidung_updated_at") != null ? rs.getString("nguoidung_updated_at") : "");

				// Xử lý các trường thông tin khác
				item.setNguoidung_trinhdo(rs.getString("nguoidung_trinhdo") != null ? rs.getString("nguoidung_trinhdo") : "Chưa xác định");
				item.setNguoidung_nganhang(rs.getString("nguoidung_nganhang") != null ? rs.getString("nguoidung_nganhang") : "Không có");
				item.setNguoidung_stk(rs.getString("nguoidung_stk") != null ? rs.getString("nguoidung_stk") : "Không có");
				item.setNguoidung_vaitro(rs.getString("nguoidung_vaitro") != null ? rs.getString("nguoidung_vaitro") : "Học viên");
				item.setNguoidung_trangthai(rs.getString("nguoidung_trangthai") != null ? rs.getString("nguoidung_trangthai") : "Chờ kích hoạt");

				// Xử lý các danh sách liên quan
				ArrayList<KhoaHoc> khoaHocDangHoc = getKhoaHocDangHoc(connect, id);
				item.setKhoaHocDangHoc(khoaHocDangHoc != null ? khoaHocDangHoc : new ArrayList<>());
				ArrayList<KhoaHoc> khoaHocDaHoc = getKhoaHocDaHoc(connect, id);
				item.setKhoaHocDaHoc(khoaHocDaHoc != null ? khoaHocDaHoc : new ArrayList<>());
				ArrayList<LichSuThanhToan> thanhToan = getLichSuThanhToan(connect, id);
				item.setLichSuThanhToan(thanhToan != null ? thanhToan : new ArrayList<>());
				ArrayList<CauHoiObject> cauhoi = getCauHoi(connect, id);
				item.setCauhois(cauhoi!=null?cauhoi:new ArrayList<>());

				
			}
	                
			connect.close();
			pstmt.close();
			rs.close();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi ket noi");
		}finally {
			
		}
		return item;
	}

	@Override
	public NguoiDungObject getUser(String name, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DiemSo> getDiemso(Connection con, int id) {
	    return null;
	}

	@Override
	public  ArrayList<KhoaHoc> getKhoaHocDangHoc(Connection conn, int hocVienId){
        ArrayList<KhoaHoc> khoaHocList = new ArrayList<>();
        
        String sql = "SELECT hvlh.hvlh_id, lh.lophoc_id, kh.khoahoc_ten, " +
                     "lh.lophoc_ngaybatdau, lh.lophoc_ngayketthuc, hvlh.hvlh_trangthai ,kh.khoahoc_loai ,kh.khoahoc_trinhdo " +
                     "FROM hocvien_lophoc hvlh " +
                     "JOIN lophoc lh ON hvlh.hvlh_lophoc_id = lh.lophoc_id " +
                     "JOIN khoahoc kh ON lh.lophoc_khoahoc_id = kh.khoahoc_id " +
                     "WHERE hvlh.hvlh_hocvien_id = ? and hvlh.hvlh_trangthai = \"Đang học\"";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, hocVienId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	

                	KhoaHoc khoaHoc = new KhoaHoc();
                	khoaHoc.setHvlh_id(rs.getInt("hvlh_id"));
                	khoaHoc.setKhoahoc_trinhdo(rs.getString("khoahoc_trinhdo") != null ? rs.getString("khoahoc_trinhdo") : "Không có");
                	khoaHoc.setKhoahoc_loai(rs.getString("khoahoc_loai") != null ? rs.getString("khoahoc_loai") : "Không có");
                	khoaHoc.setLophoc_id(rs.getInt("lophoc_id"));
                	khoaHoc.setKhoahoc_ten(rs.getString("khoahoc_ten") != null ? rs.getString("khoahoc_ten") : "Không có");
                	khoaHoc.setLophoc_ngaybatdau(rs.getString("lophoc_ngaybatdau") != null ? rs.getString("lophoc_ngaybatdau") : "Không có");
                	khoaHoc.setLophoc_ngayketthuc(rs.getString("lophoc_ngayketthuc") != null ? rs.getString("lophoc_ngayketthuc") : "Không có");
                	khoaHoc.setHvlh_trangthai(rs.getString("hvlh_trangthai") != null ? rs.getString("hvlh_trangthai") : "Không có");
                	khoaHocList.add(khoaHoc);
                }
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return khoaHocList;
    }
	    
	    
	@Override
	public ArrayList<LichSuThanhToan> getLichSuThanhToan(Connection con, int id) {
		// TODO Auto-generated method stub
		ArrayList<LichSuThanhToan> thanhToanList = new ArrayList<>();
	    
	    String sql = "SELECT tt.thanhtoan_id, tt.thanhtoan_ngay, tt.thanhtoan_sotien, " +
	                "tt.thanhtoan_phuongthuc, tt.thanhtoan_trangthai, tt.thanhtoan_magiaodich " +
	                "" +
	                "FROM thanhtoan tt " +
	                "LEFT JOIN lophoc lh ON tt.thanhtoan_lophoc_id = lh.lophoc_id " +
	                "LEFT JOIN khoahoc kh ON lh.lophoc_khoahoc_id = kh.khoahoc_id " +
	                "WHERE tt.thanhtoan_hocvien_id = ? " +
	                "ORDER BY tt.thanhtoan_ngay DESC";
	    
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	            	LichSuThanhToan thanhToan = new LichSuThanhToan();
	            	thanhToan.setThanhtoan_id(rs.getInt("thanhtoan_id")); // int tự động thành 0 nếu NULL

	            	thanhToan.setThanhtoan_ngay(rs.getString("thanhtoan_ngay") != null ? rs.getString("thanhtoan_ngay") : "Chưa xác định");

	            	double sotien = rs.getDouble("thanhtoan_sotien");
	            	thanhToan.setThanhtoan_sotien(rs.wasNull() ? 0.0 : sotien);

	            	thanhToan.setThanhtoan_phuongthuc(rs.getString("thanhtoan_phuongthuc") != null ? rs.getString("thanhtoan_phuongthuc") : "Không rõ");
	            	thanhToan.setThanhtoan_trangthai(rs.getString("thanhtoan_trangthai") != null ? rs.getString("thanhtoan_trangthai") : "Chưa xác định");
	            	thanhToan.setThanhtoan_magiaodich(rs.getString("thanhtoan_magiaodich") != null ? rs.getString("thanhtoan_magiaodich") : "");
	                
	                
	                
	                thanhToanList.add(thanhToan);
	            }
	        }
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return thanhToanList;
	}

	@Override
	public ArrayList<KhoaHoc> getKhoaHocDaHoc(Connection con, int id) {
		// TODO Auto-generated method stub
		ArrayList<KhoaHoc> khoaHocList = new ArrayList<>();
        
        String sql = "SELECT hvlh.hvlh_id, lh.lophoc_id, kh.khoahoc_ten, " +
                     "lh.lophoc_ngaybatdau, lh.lophoc_ngayketthuc, hvlh.hvlh_trangthai ,kh.khoahoc_loai ,kh.khoahoc_trinhdo " +
                     "FROM hocvien_lophoc hvlh " +
                     "JOIN lophoc lh ON hvlh.hvlh_lophoc_id = lh.lophoc_id " +
                     "JOIN khoahoc kh ON lh.lophoc_khoahoc_id = kh.khoahoc_id " +
                     "WHERE hvlh.hvlh_hocvien_id = ? and hvlh.hvlh_trangthai = \"Đã hoàn thành\"";
        
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	

                	KhoaHoc khoaHoc = new KhoaHoc();
                	khoaHoc.setHvlh_id(rs.getInt("hvlh_id"));
                	khoaHoc.setKhoahoc_trinhdo(rs.getString("khoahoc_trinhdo") != null ? rs.getString("khoahoc_trinhdo") : "Không có");
                	khoaHoc.setKhoahoc_loai(rs.getString("khoahoc_loai") != null ? rs.getString("khoahoc_loai") : "Không có");
                	khoaHoc.setLophoc_id(rs.getInt("lophoc_id"));
                	khoaHoc.setKhoahoc_ten(rs.getString("khoahoc_ten") != null ? rs.getString("khoahoc_ten") : "Không có");
                	khoaHoc.setLophoc_ngaybatdau(rs.getString("lophoc_ngaybatdau") != null ? rs.getString("lophoc_ngaybatdau") : "Không có");
                	khoaHoc.setLophoc_ngayketthuc(rs.getString("lophoc_ngayketthuc") != null ? rs.getString("lophoc_ngayketthuc") : "Không có");
                	khoaHoc.setHvlh_trangthai(rs.getString("hvlh_trangthai") != null ? rs.getString("hvlh_trangthai") : "Không có");
                	khoaHocList.add(khoaHoc);
                }
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return khoaHocList;
	}

	@Override
	public ArrayList<CauHoiObject> getCauHoi(Connection con, int id) {
		// TODO Auto-generated method stub
		ArrayList<CauHoiObject> cauhoiList = new ArrayList<>();
        
        String sql = "SELECT \r\n"
        		+ "    c.caunhoi_id,\r\n"
        		+ "    c.caunhoi_noidung,\r\n"
        		+ "    c.caunhoi_ngaygui,\r\n"
        		+ "    c.caunhoi_trangthai,\r\n"
        		+ "    l.lophoc_ten ,\r\n"
        		+ "    c.caunhoi_lophoc_id\r\n"
        		+ "FROM caunhoi c\r\n"
        		+ "\r\n"
        		+ "JOIN lophoc l ON c.caunhoi_lophoc_id = l.lophoc_id\r\n"
        		+ "JOIN nguoidung n ON c.caunhoi_nguoigui_id = n.nguoidung_id\r\n"
        		+ "where n.nguoidung_id = ?";
        
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	

                	CauHoiObject cauhoi = new CauHoiObject();
                	cauhoi.setCaunhoi_id(rs.getInt("caunhoi_id"));
                	cauhoi.setCaunhoi_lophoc_id(rs.getInt("caunhoi_lophoc_id"));
                	cauhoi.setCaunhoi_ngaygui(rs.getString("caunhoi_ngaygui")!=null?rs.getString("caunhoi_ngaygui"):"Không có");
                	cauhoi.setCaunhoi_noidung(rs.getString("caunhoi_noidung")!=null?rs.getString("caunhoi_noidung"):"Không có");
                	cauhoi.setCaunhoi_trangthai(rs.getString("caunhoi_trangthai"));
                	cauhoi.setLophoc_ten(rs.getString("lophoc_ten"));
                	
                	cauhoiList.add(cauhoi);
                }
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return cauhoiList;
	}

	@Override
	public boolean delUser(int id) {
		 String sql = "UPDATE nguoidung SET nguoidung_trangthai = 'Chờ xác nhận', nguoidung_updated_at = CURRENT_TIMESTAMP WHERE nguoidung_id = ?";

	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online", "root", "123456");
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setInt(1, id);
	            int affectedRows = pstmt.executeUpdate();

	            return affectedRows > 0; // Trả về true nếu cập nhật thành công

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
		
	}

	@Override
	public ArrayList<NguoiDungObject> thungrachocvien(NguoiDungObject similar, int at, byte total,String role) {
		// TODO Auto-generated method stub
		ArrayList<NguoiDungObject> items = new ArrayList<>();
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Không tìm thấy MySQL JDBC Driver");
			}
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online","root","123456");
			String sql = "SELECT nguoidung_id, nguoidung_email,nguoidung_matkhau, nguoidung_hoten, "
	                   + "nguoidung_sdt, nguoidung_diachi, "
	                   + "nguoidung_sodu, nguoidung_created_at,nguoidung_updated_at FROM nguoidung where nguoidung_vaitro  = \""+role+"\" and nguoidung_trangthai=\"Chờ xác nhận\"";
			PreparedStatement pstmt = connect.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				 NguoiDungObject user = new NguoiDungObject();
				// Sử dụng ternary operator để kiểm tra NULL
				 user.setNguoidung_id(rs.getInt("nguoidung_id")); 
				 // getInt() trả về 0 nếu NULL nên không cần kiểm tra

				 // Với các trường String, kiểm tra NULL trước khi set
				 user.setNguoidung_email(rs.getString("nguoidung_email") != null ? rs.getString("nguoidung_email") : "");
				 user.setNguoidung_matkhau(rs.getString("nguoidung_matkhau") != null ? rs.getString("nguoidung_matkhau") : "");

				 // Với trường ngày tháng

				 user.setNguoidung_updated_at(rs.getString("nguoidung_updated_at") != null ? rs.getString("nguoidung_updated_at") : "");
	                
	                items.add(user);
	                
            }
			connect.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi ket noi");
		}finally {
			
		}
		return items;
	}

	@Override
	public boolean restoreUser(int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE nguoidung SET nguoidung_trangthai = 'Kích hoạt', nguoidung_updated_at = CURRENT_TIMESTAMP WHERE nguoidung_id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online", "root", "123456");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0; // Trả về true nếu cập nhật thành công

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean delcompleteUser(int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE nguoidung SET nguoidung_trangthai = 'Vô hiệu hóa', nguoidung_updated_at = CURRENT_TIMESTAMP WHERE nguoidung_id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online", "root", "123456");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0; // Trả về true nếu cập nhật thành công

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public int deleteUsersOlderThan60Days() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "UPDATE nguoidung " +
	             "SET nguoidung_trangthai = 'Vô hiệu hóa' " +
	             "WHERE nguoidung_trangthai = 'Chờ xác nhận' " + 
	             "AND TIMESTAMPDIFF(DAY, nguoidung_updated_at, NOW()) >= 60"
	             ;
	    
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/english_courses_online", "root", "123456");
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        count = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return count;
	}

}

