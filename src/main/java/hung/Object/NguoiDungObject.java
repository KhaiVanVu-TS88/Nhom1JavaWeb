package hung.Object;

import java.util.ArrayList;

//import lombok.Data;

//@Data
public class NguoiDungObject {
	protected int nguoidung_id;
	protected String nguoidung_email;
	protected String nguoidung_matkhau;
	protected String nguoidung_hoten;
	protected String nguoidung_sdt;
	protected String nguoidung_diachi;
	protected String nguoidung_avatar;
	protected String nguoidung_vaitro;
	protected String nguoidung_trangthai;
	protected String nguoidung_sodu;
	protected String nguoidung_nganhang;
	protected String nguoidung_stk;
	protected String nguoidung_created_at;
	protected String nguoidung_updated_at;
	protected String nguoidung_trinhdo;
	protected ArrayList<KhoaHoc> khoaHocDangHoc;
	protected ArrayList<KhoaHoc> khoaHocDaHoc;
	protected ArrayList<CauHoiObject> cauhois;
	protected ArrayList<LichSuThanhToan> lichSuThanhToan;

	public int getNguoidung_id() {
		return nguoidung_id;
	}

	public void setNguoidung_id(int nguoidung_id) {
		this.nguoidung_id = nguoidung_id;
	}

	public String getNguoidung_email() {
		return nguoidung_email;
	}

	public void setNguoidung_email(String nguoidung_email) {
		this.nguoidung_email = nguoidung_email;
	}

	public String getNguoidung_matkhau() {
		return nguoidung_matkhau;
	}

	public void setNguoidung_matkhau(String nguoidung_matkhau) {
		this.nguoidung_matkhau = nguoidung_matkhau;
	}

	public String getNguoidung_hoten() {
		return nguoidung_hoten;
	}

	public void setNguoidung_hoten(String nguoidung_hoten) {
		this.nguoidung_hoten = nguoidung_hoten;
	}

	public String getNguoidung_sdt() {
		return nguoidung_sdt;
	}

	public void setNguoidung_sdt(String nguoidung_sdt) {
		this.nguoidung_sdt = nguoidung_sdt;
	}

	public String getNguoidung_diachi() {
		return nguoidung_diachi;
	}

	public void setNguoidung_diachi(String nguoidung_diachi) {
		this.nguoidung_diachi = nguoidung_diachi;
	}

	public String getNguoidung_avatar() {
		return nguoidung_avatar;
	}

	public void setNguoidung_avatar(String nguoidung_avatar) {
		this.nguoidung_avatar = nguoidung_avatar;
	}

	public String getNguoidung_vaitro() {
		return nguoidung_vaitro;
	}

	public void setNguoidung_vaitro(String nguoidung_vaitro) {
		this.nguoidung_vaitro = nguoidung_vaitro;
	}

	public String getNguoidung_trangthai() {
		return nguoidung_trangthai;
	}

	public void setNguoidung_trangthai(String nguoidung_trangthai) {
		this.nguoidung_trangthai = nguoidung_trangthai;
	}

	public String getNguoidung_sodu() {
		return nguoidung_sodu;
	}

	public void setNguoidung_sodu(String nguoidung_sodu) {
		this.nguoidung_sodu = nguoidung_sodu;
	}

	public String getNguoidung_nganhang() {
		return nguoidung_nganhang;
	}

	public void setNguoidung_nganhang(String nguoidung_nganhang) {
		this.nguoidung_nganhang = nguoidung_nganhang;
	}

	public String getNguoidung_stk() {
		return nguoidung_stk;
	}

	public void setNguoidung_stk(String nguoidung_stk) {
		this.nguoidung_stk = nguoidung_stk;
	}

	public String getNguoidung_created_at() {
		return nguoidung_created_at;
	}

	public void setNguoidung_created_at(String nguoidung_created_at) {
		this.nguoidung_created_at = nguoidung_created_at;
	}

	public String getNguoidung_updated_at() {
		return nguoidung_updated_at;
	}

	public void setNguoidung_updated_at(String nguoidung_updated_at) {
		this.nguoidung_updated_at = nguoidung_updated_at;
	}

	public String getNguoidung_trinhdo() {
		return nguoidung_trinhdo;
	}

	public void setNguoidung_trinhdo(String nguoidung_trinhdo) {
		this.nguoidung_trinhdo = nguoidung_trinhdo;
	}

	public ArrayList<KhoaHoc> getKhoaHocDangHoc() {
		return khoaHocDangHoc;
	}

	public void setKhoaHocDangHoc(ArrayList<KhoaHoc> khoaHocDangHoc) {
		this.khoaHocDangHoc = khoaHocDangHoc;
	}

	public ArrayList<KhoaHoc> getKhoaHocDaHoc() {
		return khoaHocDaHoc;
	}

	public void setKhoaHocDaHoc(ArrayList<KhoaHoc> khoaHocDaHoc) {
		this.khoaHocDaHoc = khoaHocDaHoc;
	}

	public ArrayList<CauHoiObject> getCauhois() {
		return cauhois;
	}

	public void setCauhois(ArrayList<CauHoiObject> cauhois) {
		this.cauhois = cauhois;
	}

	public ArrayList<LichSuThanhToan> getLichSuThanhToan() {
		return lichSuThanhToan;
	}

	public void setLichSuThanhToan(ArrayList<LichSuThanhToan> lichSuThanhToan) {
		this.lichSuThanhToan = lichSuThanhToan;
	}
}
