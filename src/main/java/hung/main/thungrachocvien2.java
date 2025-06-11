package hung.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.NguoiDung;
import hung.Object.NguoiDungObject;
import hung.user.user;
import hung.user.userImpl;
import hung.user.userLibrary;
import hung.user.userthungrac;

/**
 * Servlet implementation class thungrachocvien
 */
@WebServlet("/thungrachocvien2")
public class thungrachocvien2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thungrachocvien2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json;charset=UTF-8");
    	response.setContentType(CONTENT_TYPE);
        sidebar.vitri = "thungrachocvien2";
        
        NguoiDung nguoiDungHienTai = (NguoiDung) request.getSession().getAttribute("NguoiDung");
        
        RequestDispatcher h = request.getRequestDispatcher("/sidebar");
        if (h != null) {
            h.include(request, response);
        }
        PrintWriter out = response.getWriter();
        // Existing HTML output (unchanged for brevity, same as provided)
        out.append("<!-- main body area -->");
        out.append("<div class=\"main px-lg-4 px-md-4\">");
        out.append("<!-- Body: Header -->");
        out.append("<div class=\"header\">");
        out.append("<nav class=\"navbar py-4\">");
        out.append("<div class=\"container-xxl\">");
        out.append("<!-- header rightbar icon -->");
        out.append("<div class=\"h-right d-flex align-items-center mr-5 mr-lg-0 order-1\">");
        out.append("<div class=\"dropdown user-profile ml-2 ml-sm-3 d-flex align-items-center zindex-popover\">");
        out.append("<div class=\"u-info me-2\">");
        out.append("<p class=\"mb-0 text-end line-height-sm \"><span class=\"font-weight-bold\">"+nguoiDungHienTai.getNguoidung_hoten()+"</span></p>");
        out.append("<small>"+nguoiDungHienTai.getNguoidung_vaitro()+"</small>");
        out.append("</div>");
        out.append("<a class=\"nav-link dropdown-toggle pulse p-0\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" data-bs-display=\"static\">");
        out.append("<img class=\"avatar lg rounded-circle img-thumbnail\" src=\"dist/assets/images/profile_av.png\" alt=\"profile\">");
        out.append("</a>");
        out.append("<div class=\"dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-end p-0 m-0\">");
        out.append("<div class=\"card border-0 w280\">");
        out.append("<div class=\"card-body pb-0\">");
        out.append("<div class=\"d-flex py-1\">");
        out.append("<img class=\"avatar rounded-circle\" src=\"dist/assets/images/profile_av.png\" alt=\"profile\">");
        out.append("<div class=\"flex-fill ms-3\">");
        out.append("<p class=\"mb-0\"><span class=\"font-weight-bold\">"+nguoiDungHienTai.getNguoidung_hoten()+"</span></p>");
        out.append("<small class=\"\">"+nguoiDungHienTai.getNguoidung_email()+"</small>");
        out.append("</div>");
        out.append("</div>");
        out.append("<div><hr class=\"dropdown-divider border-dark\"></div>");
        out.append("</div>");
        out.append("<div class=\"list-group m-2 \">");
        out.append("<a href=\"/course/Dashboard\" class=\"list-group-item list-group-item-action border-0 \"><i class=\"icofont-tasks fs-5 me-3\"></i>Quản lý</a>");
        out.append("<a href=\"/course/signin\" class=\"list-group-item list-group-item-action border-0 \"><i class=\"icofont-logout fs-6 me-3\"></i>Đăng xuất</a>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("<!-- menu toggler -->");
        out.append("<button class=\"navbar-toggler p-0 border-0 menu-toggle order-3\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#mainHeader\">");
        out.append("<span class=\"fa fa-bars\"></span>");
        out.append("</button>");
        out.append("<!-- main menu Search-->");
        out.append("<div class=\"order-0 col-lg-4 col-md-4 col-sm-12 col-12 mb-3 mb-md-0 \">");
        out.append("<div class=\"input-group flex-nowrap input-group-lg\">");
        out.append("<button type=\"button\" class=\"input-group-text\" id=\"addon-wrapping\"><i class=\"fa fa-search\"></i></button>");
        out.append("<input type=\"search\" class=\"form-control\" placeholder=\"Tìm kiếm\" aria-label=\"search\" aria-describedby=\"addon-wrapping\">");
        out.append("<button type=\"button\" class=\"input-group-text add-member-top\" id=\"addon-wrappingone\" data-bs-toggle=\"modal\" data-bs-target=\"#addUser\"><i class=\"fa fa-plus\"></i></button>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</nav>");
        out.append("</div>");
        
        out.append("<!-- Body: Body -->");
        out.append("<div class=\"body d-flex py-lg-3 py-md-2\">");
        out.append("<div class=\"container-xxl\">");
        out.append("<div class=\"row align-items-center\">");
        out.append("<div class=\"border-0 mb-4\">");
        out.append("<div class=\"card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap\">");
        out.append("<h3 class=\"fw-bold mb-0\">Danh sách học viên</h3>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div> <!-- Row end  -->");
        out.append("<div class=\"row clearfix g-3\">");
        out.append("<div class=\"col-sm-12\">");
        out.append("<div class=\"card mb-3\">");
        out.append("<div class=\"card-body\">");
        user u = new userImpl();
        ArrayList<NguoiDungObject> items = u.thungrachocvien(null, 0, (byte)0,"Giáo viên");
        String views = userthungrac.viewUsers(items);
        out.append(views);
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div><!-- Row End -->");
        out.append("</div>");
        out.append("</div>");
 
        out.append("<!-- Jquery Core Js -->");
        out.append("<script src=\"dist/assets/bundles/libscripts.bundle.js\"></script>");
        out.append("<!-- Plugin Js-->");
        out.append("<script src=\"dist/assets/bundles/dataTables.bundle.js\"></script>");
        out.append("<!-- Jquery Page Js -->");
        out.append("<script src=\"dist/js/template.js\"></script>");
        out.append("<script src=\"dist/assets/bundles/phantrang.js\"></script>");
        out.append("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
        String msg = request.getParameter("msg");
        if (msg != null) {
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
            out.println("<script>");
            switch (msg) {
                case "restore_success":
                    out.println("Swal.fire('Thành công!', 'Người dùng đã được hoàn tác.', 'success');");
                    break;
                case "delete_success":
                    out.println("Swal.fire('Thành công!', 'Người dùng đã bị xóa vĩnh viễn.', 'success');");
                    break;
                case "error":
                    out.println("Swal.fire('Lỗi!', 'Không thể xử lý yêu cầu.', 'error');");
                    break;
            }
            out.println("</script>");
        }
        out.append("<style>");
        out.append("td.text-truncate {");
        out.append("    max-width: 70px;");
        out.append("    overflow: hidden;");
        out.append("    text-overflow: ellipsis;");
        out.append("    white-space: nowrap;");
        out.append("}");
        out.append(".radio-group {");
        out.append("    display: flex;");
        out.append("    gap: 20px;");
        out.append("    align-items: center;");
        out.append("    margin-top: 8px;");
        out.append("}");
        out.append(".radio-option {");
        out.append("    display: flex;");
        out.append("    align-items: center;");
        out.append("    gap: 5px;");
        out.append("}");
        out.append(".radio-option input[type=\"radio\"] {");
        out.append("    margin: 0;");
        out.append("}");
        out.append("</style>");
        out.append("</body>");
        out.append("</html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
	    String idParam = request.getParameter("id");

	    response.setContentType("application/json;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    if (action != null && idParam != null) {
	        int userId = Integer.parseInt(idParam);
	        userImpl user = new userImpl();
	        boolean result = false;

	        if ("restore".equals(action)) {
	            result = user.restoreUser(userId);
	            if (result) {
	                out.print("{\"success\":true, \"message\":\"Hoàn tác người dùng thành công.\"}");
	            } else {
	                out.print("{\"success\":false, \"message\":\"Hoàn tác người dùng thất bại.\"}");
	            }
	            out.flush();
	            return;
	        } else if ("delete".equals(action)) {
	            result = user.delcompleteUser(userId);
	            if (result) {
	                out.print("{\"success\":true, \"message\":\"Xóa người dùng thành công.\"}");
	            } else {
	                out.print("{\"success\":false, \"message\":\"Xóa người dùng thất bại.\"}");
	            }
	            out.flush();
	            return;
	        }
	    }

	    // Nếu thiếu param hoặc không hợp lệ, trả về lỗi JSON
	    out.print("{\"success\":false, \"message\":\"Thiếu tham số hoặc hành động không hợp lệ.\"}");
	    out.flush();
	}

}
