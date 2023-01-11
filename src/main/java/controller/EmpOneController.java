package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/emp/empOne")
public class EmpOneController extends HttpServlet {
	
	//관리자 마이페이지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empOne.jsp").forward(request, response);
	}

}
