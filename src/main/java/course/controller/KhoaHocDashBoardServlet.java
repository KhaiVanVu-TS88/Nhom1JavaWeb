package course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.ThongKeHocVien;
import course.service.NguoiDungService;

@WebServlet(name = "KhoaHocDashboard", urlPatterns = { "/KhoaHocDashboard" })
public class KhoaHocDashBoardServlet extends HttpServlet {
	
	 private NguoiDungService nguoiDungService = new NguoiDungService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet Khoa hoc dashboard");
		
		ThongKeHocVien thongKeHocVien = nguoiDungService.getThongKeHocVien();
		System.out.println("thong ke hoc vien "+thongKeHocVien);
		req.setAttribute("ThongKeHocVien", thongKeHocVien);
		
		req.getRequestDispatcher("dist/project-dashboard.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post khoa hoc dashboard");
		req.getRequestDispatcher("dist/project-dashboard.jsp").forward(req, resp);
	}
}
