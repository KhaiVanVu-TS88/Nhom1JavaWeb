package hung.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class xoahocvien
 */
@WebServlet("/deleteUser")
public class xoahocvien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoahocvien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userInput = request.getParameter("value");
		 user u = new userImpl();
		 boolean isDeleted = u.delUser(Integer.parseInt(userInput));
		 JsonObject  jsonResponse = new JsonObject();
         if (isDeleted) {
             jsonResponse.addProperty("status", "success");
             jsonResponse.addProperty("message", "Đã xóa người dùng thành công!");
         } else {
             jsonResponse.addProperty("status", "error");
             jsonResponse.addProperty("message", "Xóa người dùng thất bại!");
         }
         
         // Gửi response dạng JSON
         response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(jsonResponse.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
