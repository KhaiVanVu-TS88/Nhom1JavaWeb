package hung.main;

import java.io.IOException;
import com.google.gson.JsonObject;

import course.model.NguoiDung;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hung.Object.NguoiDungObject;
import hung.user.*;

/**
 * Servlet implementation class tablemember
 */
@WebServlet("/tablemember")
public class tablemember extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public tablemember() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json;charset=UTF-8");
    	response.setContentType(CONTENT_TYPE);
    	
    	NguoiDung nguoiDungHienTai = (NguoiDung) request.getSession().getAttribute("NguoiDung");
	    System.out.println("Admin "+nguoiDungHienTai.getNguoidung_hoten() + " Đã đăng nhập vào hệ thống");
	    sidebar.vitri = "tablemember";
	    getServletContext().setAttribute("sharedValue", "Học viên");
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
        out.append("<div class=\"col-auto d-flex w-sm-100\">");
        out.append("<button type=\"button\" class=\"btn btn-dark btn-set-task w-sm-100\" data-bs-toggle=\"modal\" data-bs-target=\"#addholiday\"><i class=\"icofont-plus-circle me-2 fs-6\"></i>Thêm học viên</button>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div> <!-- Row end  -->");
        out.append("<div class=\"row clearfix g-3\">");
        out.append("<div class=\"col-sm-12\">");
        out.append("<div class=\"card mb-3\">");
        out.append("<div class=\"card-body\">");
        user u = new userImpl();
        ArrayList<NguoiDungObject> items = u.getUsers(null, 0, (byte)0,"Học viên");
        String views = userLibrary.viewUsers(items);
        out.append(views);
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div><!-- Row End -->");
        out.append("</div>");
        out.append("</div>");
        out.append("<!-- Add Holiday-->");
        out.append("<div class=\"modal fade\" id=\"addholiday\" tabindex=\"-1\"  aria-hidden=\"true\">");
        out.append("<div class=\"modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable\">");
        out.append("<div class=\"modal-content\">");
        out.append("<div class=\"modal-header\">");
        out.append("<h5 class=\"modal-title  fw-bold\" id=\"addholidayLabel\"> Thêm học viên</h5>");
        out.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
        out.append("</div>");
        out.append("<div class=\"modal-body\">");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"exampleFormControlInput1\" class=\"form-label\">Tên đăng nhập</label>");
        out.append("<input type=\"email\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"name@example.com\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"exampleFormControlInput2\" class=\"form-label\">Mật khẩu</label>");
        out.append("<input type=\"password\" class=\"form-control\" id=\"exampleFormControlInput2\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"exampleFormControlInput3\" class=\"form-label\">Tên người dùng</label>");
        out.append("<input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput3\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"exampleFormControlInput4\" class=\"form-label\">Số điện thoại</label>");
        out.append("<input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput4\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"exampleFormControlInput5\" class=\"form-label\">Địa chỉ</label>");
        out.append("<input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput5\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"exampleFormControlInput7\" class=\"form-label\">Số dư</label>");
        out.append("<input type=\"number\" class=\"form-control\" id=\"exampleFormControlInput7\" value=\"0\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"exampleFormControlInput8\" class=\"form-label\">Trình độ</label>");
        out.append("<div class=\"radio-group\">");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"A1\" name=\"trinhdo\" value=\"A1\">");
        out.append("<label for=\"A1\" class=\"form-label\">A1</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"A2\" name=\"trinhdo\" value=\"A2\">");
        out.append("<label for=\"A2\" class=\"form-label\">A2</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"B1\" name=\"trinhdo\" value=\"B1\">");
        out.append("<label for=\"B1\" class=\"form-label\">B1</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"B2\" name=\"trinhdo\" value=\"B2\">");
        out.append("<label for=\"B2\" class=\"form-label\">B2</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"C1\" name=\"trinhdo\" value=\"C1\">");
        out.append("<label for=\"C1\" class=\"form-label\">C1</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"C2\" name=\"trinhdo\" value=\"C2\">");
        out.append("<label for=\"C2\" class=\"form-label\">C2</label>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("<div class=\"modal-footer\">");
        out.append("<button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Hủy bỏ</button>");
        out.append("<button type=\"button\" class=\"btn btn-primary\" id=\"addUserBtn\">Thêm</button>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
       
        out.append("<!-- Edit User Modal -->");
        out.append("<div class=\"modal fade\" id=\"editholiday\" tabindex=\"-1\" aria-hidden=\"true\">");
        out.append("<div class=\"modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable\">");
        out.append("<div class=\"modal-content\">");
        out.append("<div class=\"modal-header\">");
        out.append("<h5 class=\"modal-title fw-bold\" id=\"editholidayLabel\">Sửa thông tin người dùng</h5>");
        out.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
        out.append("</div>");
        out.append("<div class=\"modal-body\">");
        out.append("<input type=\"hidden\" id=\"editUserId\">");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"editEmail\" class=\"form-label\">Tên đăng nhập</label>");
        out.append("<input type=\"email\" class=\"form-control\" id=\"editEmail\" placeholder=\"name@example.com\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"editPassword\" class=\"form-label\">Mật khẩu</label>");
        out.append("<input type=\"password\" class=\"form-control\" id=\"editPassword\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"editFullName\" class=\"form-label\">Tên người dùng</label>");
        out.append("<input type=\"text\" class=\"form-control\" id=\"editFullName\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"editPhone\" class=\"form-label\">Số điện thoại</label>");
        out.append("<input type=\"text\" class=\"form-control\" id=\"editPhone\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"editAddress\" class=\"form-label\">Địa chỉ</label>");
        out.append("<input type=\"text\" class=\"form-control\" id=\"editAddress\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"editBalance\" class=\"form-label\">Số dư</label>");
        out.append("<input type=\"number\" class=\"form-control\" id=\"editBalance\" value=\"0\">");
        out.append("</div>");
        out.append("<div class=\"mb-3\">");
        out.append("<label for=\"editEnglishLevel\" class=\"form-label\">Trình độ</label>");
        out.append("<div class=\"radio-group\">");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"editA1\" name=\"editTrinhdo\" value=\"A1\">");
        out.append("<label for=\"editA1\" class=\"form-label\">A1</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"editA2\" name=\"editTrinhdo\" value=\"A2\">");
        out.append("<label for=\"editA2\" class=\"form-label\">A2</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"editB1\" name=\"editTrinhdo\" value=\"B1\">");
        out.append("<label for=\"editB1\" class=\"form-label\">B1</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"editB2\" name=\"editTrinhdo\" value=\"B2\">");
        out.append("<label for=\"editB2\" class=\"form-label\">B2</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"editC1\" name=\"editTrinhdo\" value=\"C1\">");
        out.append("<label for=\"editC1\" class=\"form-label\">C1</label>");
        out.append("</div>");
        out.append("<div class=\"radio-option\">");
        out.append("<input type=\"radio\" id=\"editC2\" name=\"editTrinhdo\" value=\"C2\">");
        out.append("<label for=\"editC2\" class=\"form-label\">C2</label>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("<div class=\"modal-footer\">");
        out.append("<button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Hủy bỏ</button>");
        out.append("<button type=\"button\" class=\"btn btn-primary\" id=\"editUserBtn\">Cập nhật</button>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("<!-- Jquery Core Js -->");
        out.append("<script src=\"dist/assets/bundles/libscripts.bundle.js\"></script>");
        out.append("<!-- Plugin Js-->");
        out.append("<script src=\"dist/assets/bundles/dataTables.bundle.js\"></script>");
        out.append("<!-- Jquery Page Js -->");
        out.append("<script src=\"../js/template.js\"></script>");
        out.append("<script src=\"dist/assets/bundles/phantrang.js\"></script>");
        out.append("<script src=\"dist/assets/bundles/themsuaxoahocvien.js\"></script>");
        out.append("<script src=\"dist/assets/bundles/xemthongtinchitiet.js\"></script>");
        out.append("<script src=\"dist/assets/bundles/themhocvien.js\"></script>");
        out.append("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
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
    	String role  = (String) getServletContext().getAttribute("sharedValue");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        // Thiết lập các header CORS
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        
        PrintWriter out = response.getWriter();
        JsonObject jsonResponse = new JsonObject();

        try {
            String action = request.getParameter("action");
            if (action == null) {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Thiếu tham số action");
                out.print(jsonResponse.toString());
                out.flush();
                return;
            }

            user u = new userImpl();

            if ("add".equals(action)) {
            	String email = request.getParameter("email");
                String password = request.getParameter("password");
                String fullName = request.getParameter("fullName");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String sodu = request.getParameter("balance");
                String englishLevel = request.getParameter("englishLevel");
                String giaovien = request.getParameter("giaovien");
                
                System.out.println(role);
                if (email == null || password == null || fullName == null) {
                    jsonResponse.addProperty("success", false);
                    jsonResponse.addProperty("message", "Email, mật khẩu và tên người dùng là bắt buộc");
                    out.print(jsonResponse.toString());
                    out.flush();
                    return;
                }

                double balance;
                try {
                    balance = sodu != null ? Double.parseDouble(sodu) : 0.0;
                } catch (NumberFormatException e) {
                    jsonResponse.addProperty("success", false);
                    jsonResponse.addProperty("message", "Số dư không hợp lệ");
                    out.print(jsonResponse.toString());
                    out.flush();
                    return;
                }

                NguoiDungObject item = new NguoiDungObject();
                item.setNguoidung_email(email);
                item.setNguoidung_matkhau(password);
                item.setNguoidung_hoten(fullName);
                item.setNguoidung_sdt(phone);
                item.setNguoidung_diachi(address);
                item.setNguoidung_sodu(String.valueOf(balance));
                item.setNguoidung_trinhdo(englishLevel);

                boolean isAdded = u.addUser(item,role);
                if (isAdded) {
                    jsonResponse.addProperty("success", true);
                    jsonResponse.addProperty("message", "Thêm người dùng thành công");
                } else {
                    jsonResponse.addProperty("success", false);
                    jsonResponse.addProperty("message", "Không thể thêm người dùng, có thể email đã tồn tại");
                }
            } else if ("delete".equals(action)) {
                String userIdStr = request.getParameter("id");
                if (userIdStr == null) {
                    jsonResponse.addProperty("success", false);
                    jsonResponse.addProperty("message", "Thiếu tham số id");
                    out.print(jsonResponse.toString());
                    out.flush();
                    return;
                }

                int userId;
                try {
                    userId = Integer.parseInt(userIdStr);
                } catch (NumberFormatException e) {
                    jsonResponse.addProperty("success", false);
                    jsonResponse.addProperty("message", "ID không hợp lệ");
                    out.print(jsonResponse.toString());
                    out.flush();
                    return;
                }

                boolean isDeleted = u.delUser(userId);

                if (isDeleted) {
                    jsonResponse.addProperty("success", true);
                    jsonResponse.addProperty("message", "Người dùng chuyển vào thùng rác");
                } else {
                    jsonResponse.addProperty("success", false);
                    jsonResponse.addProperty("message", "Không thể xóa người dùng");
                }
            } else {
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Hành động không hợp lệ: " + action);
            }
        } catch (Exception e) {
            jsonResponse.addProperty("success", false);
            jsonResponse.addProperty("message", "Lỗi server: " + e.getMessage());
        }
        
        out.print(jsonResponse.toString());
        out.flush();
    }
}