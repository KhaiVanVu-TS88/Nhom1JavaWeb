package course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.NguoiDung;
import course.service.NguoiDungService;
import course.service.SigninService;

@WebServlet(name = "SignIn", urlPatterns = { "/signin" })
public class SigninServlet extends HttpServlet {

	private SigninService signinService = new SigninService();
	private NguoiDungService nguoiDungService = new NguoiDungService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("chay doGet signin");
		req.getRequestDispatcher("dist/ui-elements/auth-signin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("chay doPost");
		
		req.setCharacterEncoding("UTF-8");
		
		String nguoidung_email = req.getParameter("email");
		//System.out.println("email: "+nguoidung_email);
		
		String nguoidung_matkhau = req.getParameter("password");
		//System.out.println("password: "+nguoidung_matkhau);
		
		NguoiDung nguoiDung = nguoiDungService.getNguoiDung(nguoidung_email, nguoidung_matkhau);
		
		
		String quyen = signinService.getQuyenNguoiDung(nguoidung_email, nguoidung_matkhau);
		switch(quyen) {
		case "Quản trị viên":
			System.out.println("Quản trị viên đã đăng nhập vào hệ thống");
			req.getSession().setAttribute("NguoiDung", nguoiDung);// Lưu NguoiDung vào session
			resp.sendRedirect(req.getContextPath()+"/Dashboard");
			break;
		case "Giáo viên":
			System.out.println("Giáo viên đã đăng nhập vào hệ thống");
			resp.sendRedirect(req.getContextPath()+"/");
			break;
		case "Học viên":
			System.out.println("Học viên đã đăng nhập vào hệ thống");
			resp.sendRedirect(req.getContextPath()+"/");
			break;
		case "":
			System.out.println("Người dùng lạ đã cố đăng nhập vào hệ thống");
			resp.sendRedirect(req.getContextPath()+"/");
		}
	}
}
