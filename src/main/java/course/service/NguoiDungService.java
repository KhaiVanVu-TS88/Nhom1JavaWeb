package course.service;

import java.util.List;

import course.model.GiangVienData;
import course.model.LopHoc;
import course.model.NguoiDung;
import course.model.NguoiDungTheoNgay;
import course.model.ThongKeHocVien;
import course.repository.NguoiDungRepository;

public class NguoiDungService {
	private NguoiDungRepository nguoiDungRepository = new NguoiDungRepository();

	public List<NguoiDung> getNguoiDungHoTenByNguoiDungVaiTro(String nguoidung_vaitro) {
		return nguoiDungRepository.getNguoiDungHoTenByNguoiDungVaiTro(nguoidung_vaitro);
	}

	public List<NguoiDung> getGiaoVienTieuBieu() {
		return nguoiDungRepository.getGiaoVienTieuBieu();
	}

	public List<GiangVienData> getGiangVien() {
		return nguoiDungRepository.getGiangVien();
	}

	public int getTongSoGiangVien() {
		return nguoiDungRepository.getTongSoGiangVien();
	}

	public List<NguoiDungTheoNgay> getSoLuongNguoiDungTheoNgay() {
		return nguoiDungRepository.getSoLuongNguoiDungTheoNgay();
	}
	
	public ThongKeHocVien getThongKeHocVien() {
		return nguoiDungRepository.getThongKeHocVien();
	}
	
	public List<NguoiDung> getHocVienTheoLopHocId(int lophoc_id){
		return nguoiDungRepository.getHocVienTheoLopHocId(lophoc_id);
	}
	
	public boolean deleteNguoiDungById(int nguoidung_id) {
		return nguoiDungRepository.deleteNguoiDungById(nguoidung_id) > 0 ? true : false;
	}
}
