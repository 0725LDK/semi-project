package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp/empGoodsAdd")
public class EmpGoodsAddController extends HttpServlet {
	
	//상품등록 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/emp/empGoodsAdd.jsp").forward(request, response);
	}

	//상품등록 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("상품 등록 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empGoodsList");
	}

}
