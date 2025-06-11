package course.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LopHoc {
	private int lophoc_id;
	private int lophoc_khoahoc_id;
	private String lophoc_ten;
	private String lophoc_mota;
	private String lophoc_trangthai;
	private String lophoc_ngaybatdau;
	private String lophoc_ngayketthuc;
	private int lophoc_soluonghv;
	private int lophoc_giaovien_id;
	private String giaovien_hoten;// thêm tên giáo viên
	private String lophoc_phonghoc;
	private String lophoc_lichhoc;
	private String lophoc_tailieu;
	private String lophoc_created_at;
	private String lophoc_updated_at;
	private int lophoc_tiendo;

	public int getLophoc_id() {
		return lophoc_id;
	}

	public void setLophoc_id(int lophoc_id) {
		this.lophoc_id = lophoc_id;
	}

	public int getLophoc_khoahoc_id() {
		return lophoc_khoahoc_id;
	}

	public void setLophoc_khoahoc_id(int lophoc_khoahoc_id) {
		this.lophoc_khoahoc_id = lophoc_khoahoc_id;
	}

	public String getLophoc_ten() {
		return lophoc_ten;
	}

	public void setLophoc_ten(String lophoc_ten) {
		this.lophoc_ten = lophoc_ten;
	}

	public String getLophoc_mota() {
		return lophoc_mota;
	}

	public void setLophoc_mota(String lophoc_mota) {
		this.lophoc_mota = lophoc_mota;
	}

	public String getLophoc_trangthai() {
		return lophoc_trangthai;
	}

	public void setLophoc_trangthai(String lophoc_trangthai) {
		this.lophoc_trangthai = lophoc_trangthai;
	}

	public String getLophoc_ngaybatdau() {
		return lophoc_ngaybatdau;
	}

	public void setLophoc_ngaybatdau(String lophoc_ngaybatdau) {
		this.lophoc_ngaybatdau = lophoc_ngaybatdau;
	}

	public String getLophoc_ngayketthuc() {
		return lophoc_ngayketthuc;
	}

	public void setLophoc_ngayketthuc(String lophoc_ngayketthuc) {
		this.lophoc_ngayketthuc = lophoc_ngayketthuc;
	}

	public int getLophoc_soluonghv() {
		return lophoc_soluonghv;
	}

	public void setLophoc_soluonghv(int lophoc_soluonghv) {
		this.lophoc_soluonghv = lophoc_soluonghv;
	}

	public int getLophoc_giaovien_id() {
		return lophoc_giaovien_id;
	}

	public void setLophoc_giaovien_id(int lophoc_giaovien_id) {
		this.lophoc_giaovien_id = lophoc_giaovien_id;
	}

	public String getLophoc_phonghoc() {
		return lophoc_phonghoc;
	}

	public void setLophoc_phonghoc(String lophoc_phonghoc) {
		this.lophoc_phonghoc = lophoc_phonghoc;
	}

	public String getLophoc_lichhoc() {
		return lophoc_lichhoc;
	}

	public void setLophoc_lichhoc(String lophoc_lichhoc) {
		this.lophoc_lichhoc = lophoc_lichhoc;
	}

	public String getLophoc_tailieu() {
		return lophoc_tailieu;
	}

	public void setLophoc_tailieu(String lophoc_tailieu) {
		this.lophoc_tailieu = lophoc_tailieu;
	}

	public String getLophoc_created_at() {
		return lophoc_created_at;
	}

	public void setLophoc_created_at(String lophoc_created_at) {
		this.lophoc_created_at = lophoc_created_at;
	}

	public String getLophoc_updated_at() {
		return lophoc_updated_at;
	}

	public void setLophoc_updated_at(String lophoc_updated_at) {
		this.lophoc_updated_at = lophoc_updated_at;
	}

	public String getGiaovien_hoten() {
		return giaovien_hoten;
	}

	public void setGiaovien_hoten(String giaovien_hoten) {
		this.giaovien_hoten = giaovien_hoten;
	}

	public int getLophoc_tiendo() {
		return lophoc_tiendo;
	}

	public void setLophoc_tiendo(int lophoc_tiendo) {
		this.lophoc_tiendo = lophoc_tiendo;
	}

	public void updateTienDo() {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate startDate = LocalDate.parse(lophoc_ngaybatdau, formatter);
			LocalDate endDate = LocalDate.parse(lophoc_ngayketthuc, formatter);
			LocalDate today = LocalDate.now();

			if (today.isBefore(startDate)) {
				lophoc_tiendo = 0;
				return;
			}

			if (today.isAfter(endDate)) {
				lophoc_tiendo = 100;
				return;
			}

			long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
			if (totalDays <= 0) {
				lophoc_tiendo = 0;
				return;
			}

			long daysPassed = ChronoUnit.DAYS.between(startDate, today);
			lophoc_tiendo = (int) Math.round((daysPassed * 100.0) / totalDays);
		} catch (Exception e) {
			e.printStackTrace();
			lophoc_tiendo = 0;
		}
	}

	public void updateTrangThai() {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate today = LocalDate.now();
			LocalDate startDate = LocalDate.parse(lophoc_ngaybatdau, formatter);
			LocalDate endDate = LocalDate.parse(lophoc_ngayketthuc, formatter);

			if (today.isBefore(startDate)) {
				lophoc_trangthai = "Chưa bắt đầu";
			} else if (today.isAfter(endDate)) {
				lophoc_trangthai = "Đã kết thúc";
			} else {
				lophoc_trangthai = "Đang học";
			}
		} catch (Exception e) {
			e.printStackTrace();
			lophoc_trangthai = "Lỗi";
		}
	}

}
