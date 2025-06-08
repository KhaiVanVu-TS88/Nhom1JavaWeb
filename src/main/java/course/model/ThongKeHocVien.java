package course.model;

public class ThongKeHocVien {
	private int tongSoHocVien;
	private int tongSoHocVienDaHoanThanh;
	private int tongSoHocVienDangHoc;

	public ThongKeHocVien(int tongSoHocVien, int tongSoHocVienDaHoanThanh, int tongSoHocVienDangHoc) {
		
		this.tongSoHocVien = tongSoHocVien;
		this.tongSoHocVienDaHoanThanh = tongSoHocVienDaHoanThanh;
		this.tongSoHocVienDangHoc = tongSoHocVienDangHoc;
	}

	public int getTongSoHocVien() {
		return tongSoHocVien;
	}

	public void setTongSoHocVien(int tongSoHocVien) {
		this.tongSoHocVien = tongSoHocVien;
	}

	public int getTongSoHocVienDaHoanThanh() {
		return tongSoHocVienDaHoanThanh;
	}

	public void setTongSoHocVienDaHoanThanh(int tongSoHocVienDaHoanThanh) {
		this.tongSoHocVienDaHoanThanh = tongSoHocVienDaHoanThanh;
	}

	public int getTongSoHocVienDangHoc() {
		return tongSoHocVienDangHoc;
	}

	public void setTongSoHocVienDangHoc(int tongSoHocVienDangHoc) {
		this.tongSoHocVienDangHoc = tongSoHocVienDangHoc;
	}

}
