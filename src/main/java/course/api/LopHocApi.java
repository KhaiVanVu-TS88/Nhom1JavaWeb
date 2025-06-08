package course.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import course.model.LopHoc;
import course.model.NguoiDung;
import course.payload.ResponeData;
import course.service.LopHocService;
import course.service.NguoiDungService;

@WebServlet(name = "LopHocApi", urlPatterns = { "/api/lophoc/delete", "/api/lophoc/hienthi", "/api/lophoc/add",  
		"/api/lophoc/update", "/api/lophoc/detail", "/api/lophoc/danhsachhocvien"})
public class LopHocApi extends HttpServlet {
	private LopHocService lopHocService = new LopHocService();
	private NguoiDungService nguoiDungService = new NguoiDungService();
	private Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();

		switch(servletPath) {
		case "/api/lophoc/hienthi":
			hienThiLopHocTrongKhoahoc(req, resp);
			break;
		case "/api/lophoc/detail":
			detailLopHoc(req,resp);
			break;
		case "/api/lophoc/danhsachhocvien":
			getHocVienTheoLopHocId(req, resp);
			break;
		}
	}
	
	private void getHocVienTheoLopHocId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

		// Lấy tham số khoahoc_id
		String lophocId = req.getParameter("lophoc_id");
		System.out.println("hiển thị danh sách học viên trong lớp học có id: " + lophocId);
		if (lophocId == null || lophocId.trim().isEmpty()) {
			responeData.setSuccess(false);
			responeData.setDescription("Thiếu tham số ID lớp học");
			responeData.setData("");
			sendResponse(resp, responeData);
			return;
		}

		// Chuyển đổi khoahoc_id sang số nguyên
		int lophoc_id;
		try {
			lophoc_id = Integer.parseInt(lophocId);
			System.out.println("hiển thị danh sách học viên lớp học có id: " + lophoc_id);
		} catch (NumberFormatException e) {
			responeData.setSuccess(false);
			responeData.setDescription("danh sach hoc vien theo lớp học co ID khong hop le");
			responeData.setData("");
			sendResponse(resp, responeData);
			return;
		}

		// Lấy danh sách lớp học
		List<NguoiDung> hocVien = nguoiDungService.getHocVienTheoLopHocId(lophoc_id);
		responeData.setSuccess(true);
		responeData.setDescription(
				hocVien.isEmpty() ? "Không tìm thấy danh sach hoc vien theo lớp học" : "Lấy danh sach hoc vien theo lớp học");
		responeData.setData(hocVien);

		sendResponse(resp, responeData);
		
	}

	private void hienThiLopHocTrongKhoahoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

		// Lấy tham số khoahoc_id
		String khoahocIdStr = req.getParameter("khoahoc_id");
		System.out.println("hiển thị danh sách lớp học trong khóa học có id: " + khoahocIdStr);
		if (khoahocIdStr == null || khoahocIdStr.trim().isEmpty()) {
			responeData.setSuccess(false);
			responeData.setDescription("Thiếu tham số ID khóa học");
			responeData.setData("");
			sendResponse(resp, responeData);
			return;
		}

		// Chuyển đổi khoahoc_id sang số nguyên
		int khoahocId;
		try {
			khoahocId = Integer.parseInt(khoahocIdStr);
			System.out.println("hiển thị danh sách lớp học trong khóa học có id: " + khoahocId);
		} catch (NumberFormatException e) {
			responeData.setSuccess(false);
			responeData.setDescription("ID khóa học không hợp lệ");
			responeData.setData("");
			sendResponse(resp, responeData);
			return;
		}

		// Lấy danh sách lớp học
		List<LopHoc> listLopHoc = lopHocService.getLopHocByKhoaHocId(khoahocId);
		responeData.setSuccess(true);
		responeData.setDescription(
				listLopHoc.isEmpty() ? "Không tìm thấy lớp học" : "Lấy danh sách lớp học thành công");
		responeData.setData(listLopHoc);

		sendResponse(resp, responeData);
	}
	
	private void detailLopHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

		// Lấy tham số lophoc_id
		String lophocIdStr = req.getParameter("lophoc_id");
		System.out.println("hiển thị danh sách lớp học trong khóa học có id: " + lophocIdStr);
		if (lophocIdStr == null || lophocIdStr.trim().isEmpty()) {
			responeData.setSuccess(false);
			responeData.setDescription("Thiếu tham số ID lớp học");
			responeData.setData("");
			sendResponse(resp, responeData);
			return;
		}

		// Chuyển đổi lophoc_id sang số nguyên
		int lophocId;
		try {
			lophocId = Integer.parseInt(lophocIdStr);
			System.out.println("hiển thị thông tin lớp học có id: " + lophocId);
		} catch (NumberFormatException e) {
			responeData.setSuccess(false);
			responeData.setDescription("ID lớp học không hợp lệ");
			responeData.setData("");
			sendResponse(resp, responeData);
			return;
		}

		// Lấy danh sách lớp học
		List<LopHoc> listLopHoc = lopHocService.getLopHocById(lophocId);
		responeData.setSuccess(true);
		responeData.setDescription(
				listLopHoc.isEmpty() ? "Không tìm thấy lớp học" : "Lấy danh sách lớp học thành công");
		responeData.setData(listLopHoc);

		sendResponse(resp, responeData);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String urlPath = req.getServletPath();
		switch (urlPath) {
		case "/api/lophoc/delete":
			deleteLopHoc(req, resp);
			break;
		case "/api/lophoc/add":
			addLopHoc(req, resp);
			break;
		case "/api/lophoc/update":
			updateLopHoc(req, resp);
			break;
		}

	}
	
	private void updateLopHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

		try {
	        // Kiểm tra tham số
			int lophoc_id = Integer.parseInt(req.getParameter("lophoc_id"));
			int lophoc_khoahoc_id = Integer.parseInt(req.getParameter("lophoc_khoahoc_id"));
			String lophoc_ten = req.getParameter("lophoc_ten");
			String lophoc_mota = req.getParameter("lophoc_mota");
			String lophoc_trangthai = req.getParameter("lophoc_trangthai");
			String lophoc_ngaybatdau = req.getParameter("lophoc_ngaybatdau");
			String lophoc_ngayketthuc = req.getParameter("lophoc_ngayketthuc");
//			int lophoc_giaovien_id = Integer.parseInt(req.getParameter("lophoc_giaovien_id"));
			String giaovien_hoten = req.getParameter("giaovien_hoten");
			String lophoc_tailieu = req.getParameter("lophoc_tailieu");
			
	        // Thực hiện update lớp học
	        boolean isSuccess = lopHocService.updateLopHoc(lophoc_id, 
	        		lophoc_khoahoc_id, 
	        		lophoc_ten, 
	        		lophoc_mota, 
	        		lophoc_trangthai, 
	        		lophoc_ngaybatdau, 
	        		lophoc_ngayketthuc, 
	        		giaovien_hoten, 
	        		lophoc_tailieu);
	        
	        responeData.setSuccess(isSuccess);
	        responeData.setDescription(isSuccess ? "Cập nhật lớp học thành công" : "Không thể cập nhật lớp học: " + lophoc_ten);
	    } catch (Exception e) {
	        responeData.setSuccess(false);
	        responeData.setDescription("Có lỗi xảy ra: " + e.getMessage());
	    }

		sendResponse(resp, responeData);
	}

	private void addLopHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

		try {
	        // Kiểm tra tham số
	        int lophoc_khoahoc_id = Integer.parseInt(req.getParameter("lophoc_khoahoc_id"));
	        String lophoc_ten = req.getParameter("lophoc_ten");
	        String lophoc_tailieu = req.getParameter("lophoc_tailieu");
	        String lophoc_ngaybatdau = req.getParameter("lophoc_ngaybatdau");
	        String lophoc_ngayketthuc = req.getParameter("lophoc_ngayketthuc");
	        int lophoc_giaovien_id = Integer.parseInt(req.getParameter("lophoc_giaovien_id"));
	        String lophoc_mota = req.getParameter("lophoc_mota");
	        // Thực hiện thêm lớp học
	        boolean isSuccess = lopHocService.insertLopHoc(lophoc_khoahoc_id, lophoc_ten, lophoc_tailieu, lophoc_ngaybatdau, 
	                lophoc_ngayketthuc, lophoc_giaovien_id, lophoc_mota);
	        
	        responeData.setSuccess(isSuccess);
	        responeData.setDescription(isSuccess ? "Thêm lớp học thành công" : "Không thể thêm lớp học: " + lophoc_ten);
	    } catch (Exception e) {
	        responeData.setSuccess(false);
	        responeData.setDescription("Có lỗi xảy ra: " + e.getMessage());
	    }

		sendResponse(resp, responeData);
	}

	private void deleteLopHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

		// Kiểm tra tham số lophoc_id
		String lophocIdStr = req.getParameter("lophoc_id");
		if (lophocIdStr == null || lophocIdStr.trim().isEmpty()) {
			responeData.setSuccess(false);
			responeData.setDescription("Thiếu tham số ID lớp học");
			responeData.setData("");
			sendResponse(resp, responeData);
			return;
		}

		// Chuyển đổi lophoc_id sang số nguyên
		int lophocId;
		try {
			lophocId = Integer.parseInt(lophocIdStr);
		} catch (NumberFormatException e) {
			responeData.setSuccess(false);
			responeData.setDescription("ID lớp học không hợp lệ");
			responeData.setData("");
			sendResponse(resp, responeData);
			return;
		}

		// Thực hiện xóa lớp học
		boolean isSuccess = lopHocService.deleteLopHocById(lophocId);
		responeData.setSuccess(isSuccess);
		responeData.setDescription(isSuccess ? "Xóa lớp học thành công" : "Không tìm thấy lớp học với ID: " + lophocId);
		responeData.setData("");

		sendResponse(resp, responeData);

	}

	private void sendResponse(HttpServletResponse resp, ResponeData responeData) throws IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		try (PrintWriter printWriter = resp.getWriter()) {
			String json = gson.toJson(responeData);
			printWriter.print(json);
			printWriter.flush();
		}
	}

}