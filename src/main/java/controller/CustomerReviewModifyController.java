package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerModifyReviewController
 */
@WebServlet("/customer/customerReviewModify")
public class CustomerReviewModifyController extends HttpServlet {
	
    //리뷰 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customer/customerReviewModify.jsp").forward(request, response);
	}
	
	//리뷰 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리뷰 수정 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerReview");
	}

}
