package course.model;

import java.sql.Date;

public class NguoiDungTheoNgay {
	private Date ngay;
	private int soLuong;

	public NguoiDungTheoNgay(Date ngay, int soLuong) {
		super();
		this.ngay = ngay;
		this.soLuong = soLuong;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
