package course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.KhoaHoc;
import course.model.LopHoc;
import course.model.NguoiDung;
import course.service.KhoaHocService;
import course.service.LopHocService;
import course.service.NguoiDungService;

@WebServlet(urlPatterns = { "/KhoaHoc" })
public class KhoaHocServlet extends HttpServlet {

	private KhoaHocService khoaHocService = new KhoaHocService();
	private LopHocService lopHocService = new LopHocService();
	private NguoiDungService nguoiDungService = new NguoiDungService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		List<KhoaHoc> listKhoaHoc = khoaHocService.getKhoaHocs();
	    System.out.println("Danh sách khóa học: " + listKhoaHoc); // In log để kiểm tra
	    req.setAttribute("KhoaHoc", listKhoaHoc);
	    
	    List<NguoiDung> listNguoiDung = nguoiDungService.getNguoiDungHoTenByNguoiDungVaiTro("Giáo viên");
	    System.out.println("Danh sach nguoi dung: "+ listNguoiDung);
	    req.setAttribute("NguoiDung", listNguoiDung);
	    
	    NguoiDung nguoiDung = (NguoiDung) req.getSession().getAttribute("NguoiDung");
	    System.out.println("Admin "+nguoiDung.getNguoidung_hoten() + " Đã đăng nhập vào hệ thống");
	    req.setAttribute("NguoiDungHienTai", nguoiDung);
	    	
		req.getRequestDispatcher("/dist/projects.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}

}
