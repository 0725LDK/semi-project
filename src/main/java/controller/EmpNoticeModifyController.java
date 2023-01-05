package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp/empNoticeModify")
public class EmpNoticeModifyController extends HttpServlet {
	
	//이벤트 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/emp/empNoticeModify.jsp").forward(request, response);
	}

	//이벤트 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("이벤트 수정 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empNoticeList");
	}

}
