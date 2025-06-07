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
import course.payload.ResponeData;
import course.service.NguoiDungService;

@WebServlet(name = "NguoiDungApi", urlPatterns = {"/api/nguoidung/giaovien"})
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
		}
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

}
