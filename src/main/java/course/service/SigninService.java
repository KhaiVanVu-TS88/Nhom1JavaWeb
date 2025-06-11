package course.service;

import java.util.List;

import course.model.NguoiDung;
import course.repository.NguoiDungRepository;

public class SigninService {
	
	private NguoiDungRepository nguoiDungRepository = new NguoiDungRepository();
	
	public boolean checkSignin(String nguoiDung_email, String nguoiDung_MatKhau) {
		List<NguoiDung> list = nguoiDungRepository.getNguoiDungByNguoiDung_emailAndNguoiDung_MatKhau(nguoiDung_email, 
				nguoiDung_MatKhau);
		
		return list.size() > 0 ? true : false;
	}
	
	public boolean checkSigninAdmin(String nguoiDung_email, String nguoiDung_MatKhau) {
		List<NguoiDung> list = nguoiDungRepository.getAdmin(nguoiDung_email, nguoiDung_MatKhau);
		return list.size() > 0 ? true : false;
	}
	
	public String getQuyenNguoiDung(String nguoiDung_email, String nguoiDung_MatKhau) {
		String quyen = nguoiDungRepository.getQuyenNguoiDung(nguoiDung_email, nguoiDung_MatKhau);
		if (quyen == null) {
			quyen = "";
		}
		return quyen;
	}
	
	
}
