package course.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import course.model.KhoaHoc;
import course.model.KhoaHocDaBan;
import course.model.ThongKeDoanhThuKhoaHoc;
import course.repository.KhoaHocRepository;

public class KhoaHocService {
	private KhoaHocRepository khoaHocRepository = new KhoaHocRepository();

	public List<KhoaHoc> getKhoaHocs() {
		return khoaHocRepository.getKhoaHocs();
	}

	public boolean deleteKhoaHocById(int khoahoc_id) {
		return khoaHocRepository.deleteKhoaHocById(khoahoc_id) > 0 ? true : false;
	}

	public boolean insertKhoaHoc(String khoahoc_ten, String khoahoc_mota, String khoahoc_trinhdo, String khoahoc_loai,
			LocalDate khoahoc_ngaybatdau, LocalDate khoahoc_ngayketthuc, int khoahoc_thoiluong,
			int khoahoc_gia) {
		return khoaHocRepository.insertKhoaHoc(khoahoc_ten, khoahoc_mota, khoahoc_trinhdo, khoahoc_loai,
				khoahoc_ngaybatdau, khoahoc_ngayketthuc, khoahoc_thoiluong, khoahoc_gia) > 0 ? true : false;
	}
	
	public boolean updateKhoaHoc(String khoahoc_ten, 
			String khoahoc_mota, 
			String khoahoc_trinhdo, 
			String khoahoc_loai,
			String khoahoc_trangthai, 
			String khoahoc_ngaybatdau, 
			String khoahoc_ngayketthuc, 
			int khoahoc_thoiluong,
			int khoahoc_gia,
			int khoahoc_id) {
		
		
		return khoaHocRepository.updateKhoaHoc(khoahoc_ten,
				khoahoc_mota,
				khoahoc_trinhdo,
				khoahoc_loai,
				khoahoc_trangthai,
				khoahoc_ngaybatdau,
				khoahoc_ngayketthuc,
				khoahoc_thoiluong,
				khoahoc_gia,
				khoahoc_id) > 0 ? true:false;
	}
	
	public List<KhoaHoc> getKhoaHocById(int khoahoc_id){
		return khoaHocRepository.getKhoaHocById(khoahoc_id);
	}
	
	public List<KhoaHocDaBan> getKhoaHocDaBanTheoThang(){
		return khoaHocRepository.getKhoaHocDaBanTheoThang();
	}
	
	public List<ThongKeDoanhThuKhoaHoc> getDoanhThuKhoaHoc(){
		return khoaHocRepository.getDoanhThuKhoaHoc();
	}
	
	public List<KhoaHoc> getTimeLineKhoaHoc(){
		return khoaHocRepository.getTimeLineKhoaHoc();
	}
}
