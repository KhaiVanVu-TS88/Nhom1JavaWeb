package course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.NguoiDung;

@WebServlet(name = "GiangVien", urlPatterns = { "/giangvien" })
public class GiangVienServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		NguoiDung nguoiDung = (NguoiDung) req.getSession().getAttribute("NguoiDung");
	    System.out.println("Admin "+nguoiDung.getNguoidung_hoten() + " Đã đăng nhập vào hệ thống");
	    req.setAttribute("NguoiDungHienTai", nguoiDung);
		
		req.getRequestDispatcher("/dist/ourclients.jsp").forward(req, resp);
	}
	
}
