package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer/customerModify")
public class CustomerModifyController extends HttpServlet {
	
	//고객 정보 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customer/customerModify.jsp").forward(request, response);
	}

	//고객 정보 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("회원정보 수정 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerOne");
	}

}
