package hung.Object;

//import lombok.Data;

//@Data
public class CauHoiObject {
	protected int caunhoi_id;
	protected int caunhoi_lophoc_id;
	protected int caunhoi_nguoigui_id;
	protected String caunhoi_noidung;
	protected String caunhoi_ngaygui;
	protected String caunhoi_trangthai;
	protected String lophoc_ten;

	public int getCaunhoi_id() {
		return caunhoi_id;
	}

	public void setCaunhoi_id(int caunhoi_id) {
		this.caunhoi_id = caunhoi_id;
	}

	public int getCaunhoi_lophoc_id() {
		return caunhoi_lophoc_id;
	}

	public void setCaunhoi_lophoc_id(int caunhoi_lophoc_id) {
		this.caunhoi_lophoc_id = caunhoi_lophoc_id;
	}

	public int getCaunhoi_nguoigui_id() {
		return caunhoi_nguoigui_id;
	}

	public void setCaunhoi_nguoigui_id(int caunhoi_nguoigui_id) {
		this.caunhoi_nguoigui_id = caunhoi_nguoigui_id;
	}

	public String getCaunhoi_noidung() {
		return caunhoi_noidung;
	}

	public void setCaunhoi_noidung(String caunhoi_noidung) {
		this.caunhoi_noidung = caunhoi_noidung;
	}

	public String getCaunhoi_ngaygui() {
		return caunhoi_ngaygui;
	}

	public void setCaunhoi_ngaygui(String caunhoi_ngaygui) {
		this.caunhoi_ngaygui = caunhoi_ngaygui;
	}

	public String getCaunhoi_trangthai() {
		return caunhoi_trangthai;
	}

	public void setCaunhoi_trangthai(String caunhoi_trangthai) {
		this.caunhoi_trangthai = caunhoi_trangthai;
	}

	public String getLophoc_ten() {
		return lophoc_ten;
	}

	public void setLophoc_ten(String lophoc_ten) {
		this.lophoc_ten = lophoc_ten;
	}
}
