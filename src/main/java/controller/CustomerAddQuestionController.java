package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customer/customerAddQuestion")
public class CustomerAddQuestionController extends HttpServlet {
	
	//고객센터 추가 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ordersCode = Integer.parseInt(request.getParameter("ordersCode"));
		request.setAttribute("ordersCode", ordersCode);
		
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerAddQuestion.jsp").forward(request, response);
	}

	//고객센터 추가 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		
		
		
		
		System.out.println("문의사항 추가 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerQuestion");
	}

}
