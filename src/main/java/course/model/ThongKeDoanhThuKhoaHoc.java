package course.model;

public class ThongKeDoanhThuKhoaHoc {
	private int khoahoc_id;
	private String khoahoc_ten;
	private Double khoahoc_gia;
	private int so_luong_hoc_vien;
	private Double doanh_thu;

	

	public ThongKeDoanhThuKhoaHoc(int khoahoc_id, String khoahoc_ten, Double khoahoc_gia, int so_luong_hoc_vien,
			Double doanh_thu) {
		this.khoahoc_id = khoahoc_id;
		this.khoahoc_ten = khoahoc_ten;
		this.khoahoc_gia = khoahoc_gia;
		this.so_luong_hoc_vien = so_luong_hoc_vien;
		this.doanh_thu = doanh_thu;
	}

	public Double getKhoahoc_gia() {
		return khoahoc_gia;
	}

	public void setKhoahoc_gia(Double khoahoc_gia) {
		this.khoahoc_gia = khoahoc_gia;
	}

	public int getKhoahoc_id() {
		return khoahoc_id;
	}

	public void setKhoahoc_id(int khoahoc_id) {
		this.khoahoc_id = khoahoc_id;
	}

	public String getKhoahoc_ten() {
		return khoahoc_ten;
	}

	public void setKhoahoc_ten(String khoahoc_ten) {
		this.khoahoc_ten = khoahoc_ten;
	}

	public int getSo_luong_hoc_vien() {
		return so_luong_hoc_vien;
	}

	public void setSo_luong_hoc_vien(int so_luong_hoc_vien) {
		this.so_luong_hoc_vien = so_luong_hoc_vien;
	}

	public Double getDoanh_thu() {
		return doanh_thu;
	}

	public void setDoanh_thu(Double doanh_thu) {
		this.doanh_thu = doanh_thu;
	}

}
