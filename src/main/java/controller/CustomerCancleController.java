package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerCancleController
 */
@WebServlet("/customer/customerCancle")
public class CustomerCancleController extends HttpServlet {
	
	// 취소/구매내역
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customer/customerCancle.jsp").forward(request, response);
	}

}