package course.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class KhoaHoc {
	private int khoahoc_id;
	private String khoahoc_ten;
	private String khoahoc_mota;
	private String khoahoc_thumbnail;
	private String khoahoc_trinhdo;
	private String khoahoc_loai;
	private String khoahoc_trangthai;
	private String khoahoc_ngaybatdau;
	private String khoahoc_ngayketthuc;
	private int khoahoc_thoiluong;
	private int khoahoc_gia;
	private int khoahoc_discount;
	private String khoahoc_created_at;
	private String khoahoc_updated_at;

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

	public String getKhoahoc_mota() {
		return khoahoc_mota;
	}

	public void setKhoahoc_mota(String khoahoc_mota) {
		this.khoahoc_mota = khoahoc_mota;
	}

	public String getKhoahoc_thumbnail() {
		return khoahoc_thumbnail;
	}

	public void setKhoahoc_thumbnail(String khoahoc_thumbnail) {
		this.khoahoc_thumbnail = khoahoc_thumbnail;
	}

	public String getKhoahoc_trinhdo() {
		return khoahoc_trinhdo;
	}

	public void setKhoahoc_trinhdo(String khoahoc_trinhdo) {
		this.khoahoc_trinhdo = khoahoc_trinhdo;
	}

	public String getKhoahoc_loai() {
		return khoahoc_loai;
	}

	public void setKhoahoc_loai(String khoahoc_loai) {
		this.khoahoc_loai = khoahoc_loai;
	}

	public String getKhoahoc_trangthai() {
		return khoahoc_trangthai;
	}

	public void setKhoahoc_trangthai(String khoahoc_trangthai) {
		this.khoahoc_trangthai = khoahoc_trangthai;
	}

	public String getKhoahoc_ngaybatdau() {
		return khoahoc_ngaybatdau;
	}

	public void setKhoahoc_ngaybatdau(String khoahoc_ngaybatdau) {
		this.khoahoc_ngaybatdau = khoahoc_ngaybatdau;
	}

	public String getKhoahoc_ngayketthuc() {
		return khoahoc_ngayketthuc;
	}

	public void setKhoahoc_ngayketthuc(String khoahoc_ngayketthuc) {
		this.khoahoc_ngayketthuc = khoahoc_ngayketthuc;
	}

	public int getKhoahoc_thoiluong() {
		return khoahoc_thoiluong;
	}

	public void setKhoahoc_thoiluong(int khoahoc_thoiluong) {
		this.khoahoc_thoiluong = khoahoc_thoiluong;
	}

	public int getKhoahoc_gia() {
		return khoahoc_gia;
	}

	public void setKhoahoc_gia(int khoahoc_gia) {
		this.khoahoc_gia = khoahoc_gia;
	}

	public int getKhoahoc_discount() {
		return khoahoc_discount;
	}

	public void setKhoahoc_discount(int khoahoc_discount) {
		this.khoahoc_discount = khoahoc_discount;
	}

	public String getKhoahoc_created_at() {
		return khoahoc_created_at;
	}

	public void setKhoahoc_created_at(String khoahoc_created_at) {
		this.khoahoc_created_at = khoahoc_created_at;
	}

	public String getKhoahoc_updated_at() {
		return khoahoc_updated_at;
	}

	public void setKhoahoc_updated_at(String khoahoc_updated_at) {
		this.khoahoc_updated_at = khoahoc_updated_at;
	}
	
	public double getTienDo() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate startDate = LocalDate.parse(khoahoc_ngaybatdau, formatter);
            LocalDate endDate = LocalDate.parse(khoahoc_ngayketthuc, formatter);
            LocalDate today = LocalDate.now();

            long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
            if (totalDays <= 0) return 0.0;

            long daysPassed = ChronoUnit.DAYS.between(startDate, today);
            daysPassed = Math.max(0, Math.min(daysPassed, totalDays));

            return (daysPassed * 100.0) / totalDays;

        } catch (Exception e) {
            // Có thể ghi log nếu cần
            return 0.0;
        }
    }
	
	public long getSoNgayConLai() {
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate today = LocalDate.now();
	        LocalDate endDate = LocalDate.parse(khoahoc_ngayketthuc, formatter);

	        long daysLeft = ChronoUnit.DAYS.between(today, endDate);
	        return Math.max(daysLeft, 0); // Không cho kết quả âm
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	
	public void updateTrangThai() {
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate today = LocalDate.now();
	        LocalDate startDate = LocalDate.parse(khoahoc_ngaybatdau, formatter);
	        LocalDate endDate = LocalDate.parse(khoahoc_ngayketthuc, formatter);

	        if (today.isBefore(startDate)) {
	            khoahoc_trangthai = "Sắp mở";
	        } else if (today.isAfter(endDate)) {
	            khoahoc_trangthai = "Đóng";
	        } else {
	            khoahoc_trangthai = "Đang mở";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        khoahoc_trangthai = "Lỗi";
	    }
	}
	
	public long getThoiGianKhoaHoc(String khoahoc_ngaybatdau, String khoahoc_ngayketthuc) {
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate startDate = LocalDate.parse(khoahoc_ngaybatdau, formatter);
	        LocalDate endDate = LocalDate.parse(khoahoc_ngayketthuc, formatter);

	        long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
	        return Math.max(monthsBetween, 0); // Ensure non-negative result
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

}
