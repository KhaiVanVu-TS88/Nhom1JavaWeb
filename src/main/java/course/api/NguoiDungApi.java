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

import course.model.GiangVienData;
import course.model.KhoaHocDaBan;
import course.model.NguoiDungTheoNgay;
import course.model.ThongKeHocVien;
import course.payload.ResponeData;
import course.service.NguoiDungService;

@WebServlet(name = "NguoiDungApi", urlPatterns = {"/api/nguoidung/giaovien","/api/nguoidung/soluongtheongay", "/api/nguoidung/delete"})
public class NguoiDungApi extends HttpServlet{
	
	private NguoiDungService nguoiDungService = new NguoiDungService();
	private Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		switch(urlPath) {
		case "/api/nguoidung/giaovien":
			getGiangVien(req,resp);
			break;
		case "/api/nguoidung/soluongtheongay":
			getSoLuongNguoiDungTheoNgay(req, resp);
			break;
		
		
		}
	}

	private void getSoLuongNguoiDungTheoNgay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

        try {
            // Lấy dữ liệu từ service <- repository
            List<NguoiDungTheoNgay> soLuongNguoiDungTheoNgay = nguoiDungService.getSoLuongNguoiDungTheoNgay();

            if (!soLuongNguoiDungTheoNgay.isEmpty()) {
                responeData.setSuccess(true);
                responeData.setDescription("Lấy dữ liệu biểu đồ soLuongNguoiDungTheoNgay thành công ");
                responeData.setData(soLuongNguoiDungTheoNgay);
                System.out.println("API /api/chart-data lấy được dữ liệu biểu đồ soLuongNguoiDungTheoNgay");
            } else {
                responeData.setSuccess(false);
                responeData.setDescription("Không tìm thấy dữ liệu biểu đồ soLuongNguoiDungTheoNgay");
                System.out.println("API /api/nguoidung/soluongtheongay không tìm thấy dữ liệu biểu đồ");
            }
        } catch (Exception e) {
            responeData.setSuccess(false);
            responeData.setDescription("Lỗi server: " + e.getMessage());
            System.out.println("Lỗi server: " + e.getMessage());
        }

        // Chuyển đổi responeData thành JSON
        String json = gson.toJson(responeData);

        // Thiết lập response
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(json);
        printWriter.flush();
		
	}

	private void getGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

        try {
            // Lấy dữ liệu từ service <- repository
            List<GiangVienData> giangVien = nguoiDungService.getGiangVien();

            if (!giangVien.isEmpty()) {
                responeData.setSuccess(true);
                responeData.setDescription("Lấy dữ liệu biểu đồ thành công giảng viên");
                responeData.setData(giangVien);
                System.out.println("API /api/chart-data lấy được dữ liệu biểu đồ giảng viên");
            } else {
                responeData.setSuccess(false);
                responeData.setDescription("Không tìm thấy dữ liệu biểu đồ giảng viên");
                System.out.println("API /api/nguoidung/giaovien không tìm thấy dữ liệu biểu đồ");
            }
        } catch (Exception e) {
            responeData.setSuccess(false);
            responeData.setDescription("Lỗi server: " + e.getMessage());
            System.out.println("Lỗi server: " + e.getMessage());
        }

        // Chuyển đổi responeData thành JSON
        String json = gson.toJson(responeData);

        // Thiết lập response
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(json);
        printWriter.flush();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		switch(urlPath) {
		
		case "/api/nguoidung/delete":
			deleteNguoiDungById(req, resp);
			break;
		
		} 
	}
	
	private void deleteNguoiDungById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ResponeData responseData = new ResponeData();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            // Lấy và kiểm tra tham số nguoidung_id
            String nguoiDungIdParam = req.getParameter("nguoidung_id");
            if (nguoiDungIdParam == null || nguoiDungIdParam.trim().isEmpty()) {
                responseData.setSuccess(false);
                responseData.setDescription("Thiếu tham số nguoidung_id");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
                sendResponse(resp, responseData);
                return;
            }

            int nguoidungId;
            try {
                nguoidungId = Integer.parseInt(nguoiDungIdParam);
            } catch (NumberFormatException e) {
                responseData.setSuccess(false);
                responseData.setDescription("nguoidung_id không hợp lệ");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
                sendResponse(resp, responseData);
                return;
            }

            System.out.println("ID người dùng bị xóa là: " + nguoidungId);

            // Gọi service để xóa
            boolean isSuccess = nguoiDungService.deleteNguoiDungById(nguoidungId);
            if (isSuccess) {
                System.out.println("API vừa xóa người dùng có ID: " + nguoidungId);
                responseData.setSuccess(true);
                responseData.setDescription("Xóa người dùng thành công");
                resp.setStatus(HttpServletResponse.SC_OK); // 200
            } else {
                System.out.println("Không tìm thấy người dùng với ID: " + nguoidungId);
                responseData.setSuccess(false);
                responseData.setDescription("Không tìm thấy người dùng với ID: " + nguoidungId);
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            }

        } catch (Exception e) {
            System.out.println("Lỗi khi xóa người dùng: " + e.getMessage());
            responseData.setSuccess(false);
            responseData.setDescription("Lỗi server: " + e.getMessage());
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500
        }

        sendResponse(resp, responseData);
    }

    private void sendResponse(HttpServletResponse resp, ResponeData responseData) throws IOException {
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.print(gson.toJson(responseData));
            printWriter.flush();
        }
    }

}
