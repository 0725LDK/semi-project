package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customer/customerModifyQuestion")
public class CustomerModifyQuestionController extends HttpServlet {
	
	//고객센터 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customer/customerModifyQuestion.jsp").forward(request, response);
	}

	//고객센터 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("고객센터 수정 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerQuestion");
		
	}

}
