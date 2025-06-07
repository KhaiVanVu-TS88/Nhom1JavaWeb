package course.service;

import java.util.List;

import course.model.LopHoc;
import course.repository.LopHocRepository;

public class LopHocService {
	private LopHocRepository lopHocRepository = new LopHocRepository();

	public List<LopHoc> getLopHocs() {
		return lopHocRepository.getLopHocs();
	}
	
	public List<LopHoc> getLopHocByKhoaHocId(int khoahoc_id){
		return lopHocRepository.getLopHocByKhoaHocId(khoahoc_id);
	}
	
	public List<LopHoc> getLopHocById(int lophoc_id) {
		return lopHocRepository.getLopHocById(lophoc_id);
	}
	
	public boolean deleteLopHocById(int lophoc_id) {
		return lopHocRepository.deleteLopHocById(lophoc_id) > 0 ? true : false;
	}
	
	public boolean insertLopHoc(int lophoc_khoahoc_id, String lophoc_ten, String lophoc_tailieu, String lophoc_ngaybatdau,
			String lophoc_ngayketthuc, int lophoc_giaovien_id, String lophoc_mota) {
		return lopHocRepository.insertLopHoc(lophoc_khoahoc_id, lophoc_ten, lophoc_tailieu, 
				lophoc_ngaybatdau, lophoc_ngayketthuc, lophoc_giaovien_id, lophoc_mota) >0 ? true:false;
	}
	
	public boolean updateLopHoc(int lophoc_id,
    		int lophoc_khoahoc_id,
    		String lophoc_ten,
    		String lophoc_mota,
    		String lophoc_trangthai,
    		String lophoc_ngaybatdau,
    		String lophoc_ngayketthuc,
//    		int lophoc_giaovien_id,
    		String giaovien_hoten,
    		String lophoc_tailieu) {
		return lopHocRepository.updateLopHoc(lophoc_id, lophoc_khoahoc_id, 
				lophoc_ten, lophoc_mota, lophoc_trangthai, 
				lophoc_ngaybatdau, lophoc_ngayketthuc, 
				giaovien_hoten, lophoc_tailieu) >0 ? true: false;
	}
	
	
}
