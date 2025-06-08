package course.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import course.model.KhoaHoc;
import course.model.KhoaHocDaBan;
import course.model.ThongKeDoanhThuKhoaHoc;
import course.payload.ResponeData;
import course.service.KhoaHocService;

@WebServlet(name = "KhoaHocApi", urlPatterns = { "/api/khoahoc/delete", "/api/khoahoc/add", "/api/khoahoc/update",
		"/api/khoahoc/detail", "/api/khoahoc/khoahocdaban", "/api/khoahoc/doanhthu", "/api/khoahoc/timeline" })
public class KhoaHocApi extends HttpServlet {

	private KhoaHocService khoaHocService = new KhoaHocService();
	private Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		switch(urlPath) {
		case "/api/khoahoc/detail":
			System.out.println("dang lay api");
			detailKhoaHoc(req, resp);
			break;
		case "/api/khoahoc/khoahocdaban":
			khoaHocDaBan(req, resp);
			break;
		case "/api/khoahoc/doanhthu":
			doanhThuKhoaHoc(req,resp);
			break;
		case "/api/khoahoc/timeline":
			getTimeLineKhoaHoc(req, resp);
			break;
		}
	}
	
	private void getTimeLineKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

        try {
            // Lấy dữ liệu từ service <- repository
            List<KhoaHoc> timelineKhoaHoc = khoaHocService.getTimeLineKhoaHoc();

            if (!timelineKhoaHoc.isEmpty()) {
                responeData.setSuccess(true);
                responeData.setDescription("Lấy dữ liệu biểu đồ timelineKhoaHoc thành công");
                responeData.setData(timelineKhoaHoc);
                System.out.println("API /api/chart-data lấy được dữ liệu biểu đồ timelineKhoaHoc");
            } else {
                responeData.setSuccess(false);
                responeData.setDescription("Không tìm thấy dữ liệu biểu đồ timelineKhoaHoc");
                System.out.println("API /api/chart-data không tìm thấy dữ liệu biểu đồ timelineKhoaHoc");
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

	private void doanhThuKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

        try {
            // Lấy dữ liệu từ service <- repository
            List<ThongKeDoanhThuKhoaHoc> doanhThuKhoaHoc = khoaHocService.getDoanhThuKhoaHoc();

            if (!doanhThuKhoaHoc.isEmpty()) {
                responeData.setSuccess(true);
                responeData.setDescription("Lấy dữ liệu biểu đồ doanhThuKhoaHoc thành công");
                responeData.setData(doanhThuKhoaHoc);
                System.out.println("API /api/chart-data lấy được dữ liệu biểu đồ doanhThuKhoaHoc");
            } else {
                responeData.setSuccess(false);
                responeData.setDescription("Không tìm thấy dữ liệu biểu đồ doanhThuKhoaHoc");
                System.out.println("API /api/chart-data không tìm thấy dữ liệu biểu đồ doanhThuKhoaHoc");
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

	private void khoaHocDaBan(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

        try {
            // Lấy dữ liệu từ service <- repository
            List<KhoaHocDaBan> khoaHocDaBan = khoaHocService.getKhoaHocDaBanTheoThang();

            if (!khoaHocDaBan.isEmpty()) {
                responeData.setSuccess(true);
                responeData.setDescription("Lấy dữ liệu biểu đồ thành công");
                responeData.setData(khoaHocDaBan);
                System.out.println("API /api/chart-data lấy được dữ liệu biểu đồ");
            } else {
                responeData.setSuccess(false);
                responeData.setDescription("Không tìm thấy dữ liệu biểu đồ");
                System.out.println("API /api/chart-data không tìm thấy dữ liệu biểu đồ");
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
	
	private void detailKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();

		try {
			String khoahocIdParam = req.getParameter("khoahoc_id");
			if (khoahocIdParam == null || khoahocIdParam.trim().isEmpty()) {
				responeData.setSuccess(false);
				responeData.setDescription("Tham số khoahoc_id không được cung cấp hoặc rỗng");
				System.out.println("Lỗi: Tham số khoahoc_id không được cung cấp hoặc rỗng");
				
				String json = gson.toJson(responeData);// chuyển respone thành json

				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				PrintWriter printWriter = resp.getWriter();// ghi nội dung vào phản hồi HTTP gửi về client
				printWriter.print(json);// Ghi nội dung JSON vào phản hồi – tức là server gửi JSON này về cho client.
				printWriter.flush();// Đảm bảo rằng toàn bộ dữ liệu đã được ghi hết ra phản hồi.
				
				return;
			}

			int khoahoc_id = Integer.parseInt(khoahocIdParam);
			List<KhoaHoc> khoaHocList = khoaHocService.getKhoaHocById(khoahoc_id);

			if (!khoaHocList.isEmpty()) {
				responeData.setSuccess(true);
				responeData.setDescription("Lấy thông tin khóa học thành công");
				responeData.setData(khoaHocList.get(0)); // Trả về bản ghi đầu tiên
				System.out.println("API /api/khoahoc/detail lấy được thông tin khóa học: " + khoahoc_id);
			} else {
				responeData.setSuccess(false);
				responeData.setDescription("Không tìm thấy khóa học với ID: " + khoahoc_id);
				System.out.println("API /api/khoahoc/detail không tìm thấy khóa học: " + khoahoc_id);
			}
		} catch (NumberFormatException e) {
			responeData.setSuccess(false);
			responeData.setDescription("ID khóa học không hợp lệ: " + e.getMessage());
			System.out.println("Lỗi: ID khóa học không hợp lệ - " + e.getMessage());
		} catch (Exception e) {
			responeData.setSuccess(false);
			responeData.setDescription("Lỗi server: " + e.getMessage());
			System.out.println("Lỗi server: " + e.getMessage());
		}

		String json = gson.toJson(responeData);// chuyển respone thành json

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();// ghi nội dung vào phản hồi HTTP gửi về client
		printWriter.print(json);// Ghi nội dung JSON vào phản hồi – tức là server gửi JSON này về cho client.
		printWriter.flush();// Đảm bảo rằng toàn bộ dữ liệu đã được ghi hết ra phản hồi.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		switch (urlPath) {
		case "/api/khoahoc/delete":
			deleteKhoaHoc(req, resp);
			break;
		case "/api/khoahoc/add":
			addKhoaHoc(req, resp);
			break;
		case "/api/khoahoc/update":
			updateKhoaHoc(req, resp);
			break;
		}

	}
	
	
	
	private void updateKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ResponeData responeData = new ResponeData();
		
		String khoahoc_ten = req.getParameter("khoahoc_ten");
		String khoahoc_mota = req.getParameter("khoahoc_mota");
		String khoahoc_trinhdo = req.getParameter("khoahoc_trinhdo");
		String khoahoc_loai = req.getParameter("khoahoc_loai");
		String khoahoc_trangthai = req.getParameter("khoahoc_trangthai");
		String khoahoc_ngaybatdau = req.getParameter("khoahoc_ngaybatdau");
		String khoahoc_ngayketthuc = req.getParameter("khoahoc_ngayketthuc");
		int khoahoc_thoiluong = Integer.parseInt(req.getParameter("khoahoc_thoiluong"));
		int khoahoc_gia = Integer.parseInt(req.getParameter("khoahoc_gia"));
		int khoahoc_id = Integer.parseInt(req.getParameter("khoahoc_id"));

		boolean isSuccess = khoaHocService.updateKhoaHoc(khoahoc_ten,
				khoahoc_mota,
				khoahoc_trinhdo,
				khoahoc_loai,
				khoahoc_trangthai,
				khoahoc_ngaybatdau,
				khoahoc_ngayketthuc,
				khoahoc_thoiluong,
				khoahoc_gia,
				khoahoc_id);

		if (isSuccess) {
			System.out.println("api vua update khoa hoc: " + khoahoc_ten);
			
			responeData.setSuccess(isSuccess);
			responeData.setDescription("");
			responeData.setData("");
		}else {
			System.out.println("api không update được khóa học"+ khoahoc_ten);
		}

		String json = gson.toJson(responeData);// chuyển respone thành json

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();// ghi nội dung vào phản hồi HTTP gửi về client
		printWriter.print(json);// Ghi nội dung JSON vào phản hồi – tức là server gửi JSON này về cho client.
		printWriter.flush();// Đảm bảo rằng toàn bộ dữ liệu đã được ghi hết ra phản hồi.
	}

	private void addKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String khoahoc_ten = req.getParameter("khoahoc_ten");
		String khoahoc_mota = req.getParameter("khoahoc_mota");
		String khoahoc_trinhdo = req.getParameter("khoahoc_trinhdo");
		String khoahoc_loai = req.getParameter("khoahoc_loai");
		LocalDate khoahoc_ngaybatdau = LocalDate.parse(req.getParameter("khoahoc_ngaybatdau"));// Parse LocalDate từ String (format phải là yyyy-MM-dd)
		LocalDate khoahoc_ngayketthuc = LocalDate.parse(req.getParameter("khoahoc_ngayketthuc"));
		int khoahoc_thoiluong = Integer.parseInt(req.getParameter("khoahoc_thoiluong"));// Parse int và BigDecimal đúng cách
		BigDecimal khoahoc_gia = new BigDecimal(req.getParameter("khoahoc_gia"));

		boolean isSuccess = khoaHocService.insertKhoaHoc( khoahoc_ten, khoahoc_mota , khoahoc_trinhdo ,
				 khoahoc_loai, khoahoc_ngaybatdau , khoahoc_ngayketthuc,
				 khoahoc_thoiluong, khoahoc_gia);

		if (isSuccess)
			System.out.println("api vua them khoa hoc: " + khoahoc_ten);

		ResponeData responeData = new ResponeData();
		responeData.setSuccess(isSuccess);
		responeData.setDescription("");
		responeData.setData("");

		String json = gson.toJson(responeData);// chuyển respone thành json

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();// ghi nội dung vào phản hồi HTTP gửi về client
		printWriter.print(json);// Ghi nội dung JSON vào phản hồi – tức là server gửi JSON này về cho client.
		printWriter.flush();// Đảm bảo rằng toàn bộ dữ liệu đã được ghi hết ra phản hồi.
	}

	private void deleteKhoaHoc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int khoahoc_id = Integer.parseInt(req.getParameter("khoahoc_id"));// lấy tham số khoahoc_id được gửi qua AJAX

		System.out.println("id khoa hoc bi xoa la: " + khoahoc_id);// kiểm tra id khoa học muốn xóa

		boolean isSuccess = khoaHocService.deleteKhoaHocById(khoahoc_id);// GỌi hàm để xóa theo id

		if (isSuccess)
			System.out.println("api vua xoa khoa hoc co ID: " + khoahoc_id);

		ResponeData responeData = new ResponeData();
		responeData.setSuccess(isSuccess);
		responeData.setDescription("");
		responeData.setData("");

		String json = gson.toJson(responeData);// chuyển respone thành json

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();// ghi nội dung vào phản hồi HTTP gửi về client
		printWriter.print(json);// Ghi nội dung JSON vào phản hồi – tức là server gửi JSON này về cho client.
		printWriter.flush();// Đảm bảo rằng toàn bộ dữ liệu đã được ghi hết ra phản hồi.
	}

}
