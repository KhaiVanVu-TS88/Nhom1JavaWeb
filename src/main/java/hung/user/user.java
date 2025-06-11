package hung.user;
import java.sql.Connection;
import java.util.ArrayList;
import hung.Object.*;

import hung.Object.NguoiDungObject;
public interface user {
	boolean addUser(NguoiDungObject item,String role);
	boolean editUser(NguoiDungObject item);
	boolean delUser(NguoiDungObject item);
	boolean delUser(int id);
	boolean restoreUser(int id);
	boolean delcompleteUser(int id);
	int deleteUsersOlderThan60Days();
	ArrayList<NguoiDungObject> getUsers(NguoiDungObject similar, int at, byte total,String role);
	ArrayList<NguoiDungObject> thungrachocvien(NguoiDungObject similar, int at, byte total,String role);
	NguoiDungObject getUser(int id);
	NguoiDungObject getUser(String name, String pass);
	ArrayList<DiemSo> getDiemso(Connection con, int id);
	ArrayList<KhoaHoc> getKhoaHocDangHoc(Connection con, int id);
	ArrayList<KhoaHoc> getKhoaHocDaHoc(Connection con, int id);
	ArrayList<CauHoiObject> getCauHoi(Connection con, int id);
	ArrayList<LichSuThanhToan> getLichSuThanhToan(Connection con,int id);
	
}
