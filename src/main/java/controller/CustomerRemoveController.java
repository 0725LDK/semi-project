package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerRemoveController
 */
@WebServlet("/customer/customerRemove")
public class CustomerRemoveController extends HttpServlet {
	
	//회원 탈퇴 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerRemove.jsp").forward(request, response);
	}

	//회원 탈퇴 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("회원탈퇴 성공");
		response.sendRedirect(request.getContextPath()+"/home/login");
	}

}
