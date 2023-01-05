package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp/empGoodsList")
public class EmpGoodsList extends HttpServlet {
	
	//상품정보 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empGoods.jsp").forward(request, response);
		
	}

}
