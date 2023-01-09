package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp/empRemove")
public class EmpRemoveController extends HttpServlet {
	
	//직원 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("직원 삭제 성공");
		request.getRequestDispatcher("/WEB-INF/view/emp/empList.jsp").forward(request, response);
	}
}
