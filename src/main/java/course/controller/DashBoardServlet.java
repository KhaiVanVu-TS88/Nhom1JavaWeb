package course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.KhoaHoc;
import course.model.NguoiDung;
import course.service.NguoiDungService;

@WebServlet(name = "Dashboard", urlPatterns = { "/Dashboard" })
public class DashBoardServlet extends HttpServlet {
	
	private NguoiDungService nguoiDungService = new NguoiDungService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do get dash board");
		
		List<NguoiDung> listGiangVien = nguoiDungService.getGiaoVienTieuBieu();
	    System.out.println("Danh sách giảng viên tiêu biểu : " + listGiangVien); // In log để kiểm tra
	    req.setAttribute("GiangVienTieuBieu", listGiangVien);
	    
	    int tongSoGiangVien = nguoiDungService.getTongSoGiangVien();
	    System.out.println("Tong so giang vien: "+tongSoGiangVien);
	    req.setAttribute("TongSoGiangVien", tongSoGiangVien);
	    
	    NguoiDung nguoiDung = (NguoiDung) req.getSession().getAttribute("NguoiDung");
	    System.out.println("Admin "+nguoiDung.getNguoidung_hoten() + " Đã đăng nhập vào hệ thống");
	    req.setAttribute("NguoiDungHienTai", nguoiDung);
	    
	    
		
		req.getRequestDispatcher("dist/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("do post dash board");
		req.getRequestDispatcher("dist/index.jsp").forward(req, resp);
	}
}
