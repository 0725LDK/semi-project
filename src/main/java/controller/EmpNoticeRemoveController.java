package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpNoticeRemoveController
 */
@WebServlet("/emp/empNoticeRemove")
public class EmpNoticeRemoveController extends HttpServlet {
	
	//이벤트 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("이벤트 삭제 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empNoticeList");
	}
}
