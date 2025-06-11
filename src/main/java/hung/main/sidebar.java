package hung.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sidebar
 */
@WebServlet("/sidebar")
public class sidebar extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	private static final long serialVersionUID = 1L;
	public static String vitri = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sidebar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<!doctype html>");
		out.append("<html class=\"no-js\" lang=\"vi\" dir=\"ltr\">");
		out.append("<head>");
		    out.append("<meta charset=\"utf-8\">");
		    out.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">");
		    out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		    out.append("<title>:: My-Task:: Bảng điều khiển nhân viên</title>");
		    out.append("<link rel=\"icon\" href=\"favicon.ico\" type=\"image/x-icon\"> <!-- Favicon-->");
		    out.append("<!-- project css file  -->");
		    out.append("<link rel=\"stylesheet\" href=\"dist/assets/css/my-task.style.min.css\">");
		    out.append("<link rel=\"stylesheet\" href=\"dist/assets/plugin/datatables/responsive.dataTables.min.css\">");
		    out.append("<link rel=\"stylesheet\" href=\"dist/assets/plugin/datatables/dataTables.bootstrap5.min.css\">");
		    out.append("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css\">");
		    out.append("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>");
		    out.append("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>");
		out.append("</head>");
		out.append("<body>");
		out.append("<div id=\"mytask-layout\" class=\"theme-indigo\">");
		         out.append("<!-- sidebar -->");
		         out.append("<div class=\"sidebar px-4 py-4 py-md-5 me-0\">");
		         out.append("    <div class=\"d-flex flex-column h-100\">");
		         out.append("        <a href=\"/course/Dashboard\" class=\"mb-0 brand-icon\">");
		         out.append("            <span class=\"logo-icon\">");
		         out.append("                <svg width=\"35\" height=\"35\" fill=\"currentColor\" class=\"bi bi-clipboard-check\" viewBox=\"0 0 16 16\">");
		         out.append("                    <path fill-rule=\"evenodd\" d=\"M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z\" />");
		         out.append("                    <path d=\"M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z\" />");
		         out.append("                    <path d=\"M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z\" />");
		         out.append("                </svg>");
		         out.append("            </span><span class=\"logo-text\">My-Task</span>");
		         out.append("        </a>");
		         out.append("        <ul class=\"menu-list flex-grow-1 mt-3\">");
		         out.append("            <li class=\"collapsed\">");
		         out.append("                <a class=\"m-link active\" data-bs-toggle=\"collapse\" data-bs-target=\"#dashboard-Components\" href=\"#\">");
		         out.append("                    <i class=\"icofont-home fs-5\"></i><span>Dashboard</span><span class=\"arrow icofont-dotted-down ms-auto text-end fs-5\"></span>");
		         out.append("                </a>");
		         out.append("                <ul class=\"sub-menu collapse show\" id=\"dashboard-Components\">");
		         out.append("                    <li><a class=\"ms-link active\" href=\"/course/Dashboard\"><span>Admin Dashboard</span></a></li>");
		         out.append("                    <li><a class=\"ms-link\" href=\"/course/KhoaHocDashboard\"><span>Khóa học Dashboard</span></a></li>");
		         out.append("                </ul>");
		         out.append("            </li>");
		         out.append("            <li class=\"collapsed\">");
		         out.append("                <a class=\"m-link\" data-bs-toggle=\"collapse\" data-bs-target=\"#project-Components\" href=\"#\">");
		         out.append("                    <i class=\"icofont-briefcase\"></i><span>Khóa học</span><span class=\"arrow icofont-dotted-down ms-auto text-end fs-5\"></span>");
		         out.append("                </a>");
		         out.append("                <ul class=\"sub-menu collapse\" id=\"project-Components\">");
		         out.append("                    <li><a class=\"ms-link\" href=\"/course/KhoaHoc\"><span>Khóa học</span></a></li>");
		         out.append("                </ul>");
		         out.append("            </li>");
	                if(vitri.equals("tablemember2")||vitri.equals("thungrachocvien2")) {
		                out.append("<li class=\"collapsed\">");
	                    out.append("<a class=\"m-link active\" data-bs-toggle=\"collapse\" data-bs-target=\"#client-Components\" href=\"#\"><i ");
	                            out.append("class=\"icofont-user-male\"></i> <span>Giảng viên</span> <span class=\"arrow icofont-dotted-down ms-auto text-end fs-5\"></span></a>");
	                    out.append("<!-- Menu: Sub menu ul -->");
	                    out.append("<ul class=\"sub-menu collapse show\" id=\"client-Components\">");
	                }else {
		                out.append("<li class=\"collapsed\">");
	                    out.append("<a class=\"m-link\" data-bs-toggle=\"collapse\" data-bs-target=\"#client-Components\" href=\"#\"><i ");
	                            out.append("class=\"icofont-user-male\"></i> <span>Giảng viên</span> <span class=\"arrow icofont-dotted-down ms-auto text-end fs-5\"></span></a>");
	                    out.append("<!-- Menu: Sub menu ul -->");
	                    out.append("<ul class=\"sub-menu collapse\" id=\"client-Components\">");
	                }
	                if(vitri.equals("tablemember2")) {
	                	out.append("<li><a class=\"ms-link active\" href=\"tablemember2\"> <span>Danh sách</span></a></li>");
	                }else {
	                	out.append("<li><a class=\"ms-link\" href=\"tablemember2\"> <span>Danh sách</span></a></li>");
	                }
	                
	                if(vitri.equals("thungrachocvien2")) {
	                	out.append("<li><a class=\"ms-link active\" href=\"thungrachocvien2\"> <span>Thùng rác</span></a></li>");
	                    out.append("</ul>");
	                out.append("</li>");
	                }else {
	                	out.append("<li><a class=\"ms-link\" href=\"thungrachocvien2\"> <span>Thùng rác</span></a></li>");
	                    out.append("</ul>");
	                out.append("</li>");
	                }
	                
	                if(vitri.equals("tablemember")||vitri.equals("thungrachocvien")) {
	        			out.append("<li class=\"collapsed\">");
	                    out.append("<a class=\"m-link active\" data-bs-toggle=\"collapse\" data-bs-target=\"#emp-Components\" href=\"#\"><i ");
	                            out.append("class=\"icofont-users-alt-5\"></i> <span>Học viên</span> <span class=\"arrow icofont-dotted-down ms-auto text-end fs-5\"></span></a>");
	                    out.append("<!-- Menu: Sub menu ul -->");
	                    out.append("<ul class=\"sub-menu collapse show\" id=\"emp-Components\">");
	                }else {
	                	out.append("<li class=\"collapsed\">");
	                    out.append("<a class=\"m-link\" data-bs-toggle=\"collapse\" data-bs-target=\"#emp-Components\" href=\"#\"><i ");
	                            out.append("class=\"icofont-users-alt-5\"></i> <span>Học viên</span> <span class=\"arrow icofont-dotted-down ms-auto text-end fs-5\"></span></a>");
	                    out.append("<!-- Menu: Sub menu ul -->");
	                    out.append("<ul class=\"sub-menu collapse\" id=\"emp-Components\">");
	                }
	                
	                
	                
	                if(vitri.equalsIgnoreCase("tablemember")) {
	                        out.append("<li><a class=\"ms-link active \" href=\"tablemember\"> <span>Danh sách</span></a></li>");
	        		}else {
	                        out.append("<li><a class=\"ms-link \" href=\"tablemember\"> <span>Danh sách</span></a></li>");
	        		}
	                
	                if(vitri.equals("thungrachocvien")){
                        out.append("<li><a class=\"ms-link active\" href=\"thungrachocvien\"> <span>Thùng rác</span></a></li>");
                    out.append("</ul>");
                out.append("</li>");
	                }else {
                        out.append("<li><a class=\"ms-link\" href=\"thungrachocvien\"> <span>Thùng rác</span></a></li>");
                    out.append("</ul>");
                out.append("</li>");
	                }
		         out.append("        </ul>");
		         out.append("        <ul class=\"list-unstyled mb-0\">");
		         out.append("            <li class=\"d-flex align-items-center justify-content-center\">");
		         out.append("                <div class=\"form-check form-switch theme-switch\">");
		         out.append("                    <input class=\"form-check-input\" type=\"checkbox\" id=\"theme-switch\">");
		         out.append("                    <label class=\"form-check-label\" for=\"theme-switch\">Enable Dark Mode!</label>");
		         out.append("                </div>");
		         out.append("            </li>");
		         out.append("            <li class=\"d-flex align-items-center justify-content-center\">");
		         out.append("                <div class=\"form-check form-switch theme-rtl\">");
		         out.append("                    <input class=\"form-check-input\" type=\"checkbox\" id=\"theme-rtl\">");
		         out.append("                    <label class=\"form-check-label\" for=\"theme-rtl\">Enable RTL Mode!</label>");
		         out.append("                </div>");
		         out.append("            </li>");
		         out.append("        </ul>");
		         out.append("        <button type=\"button\" class=\"btn btn-link sidebar-mini-btn text-light\">");
		         out.append("            <span class=\"ms-2\"><i class=\"icofont-bubble-right\"></i></span>");
		         out.append("        </button>");
		         out.append("    </div>");
		         out.append("</div>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
