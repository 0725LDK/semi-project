package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp/empGoodsRemove")
public class EmpGoodsRemoveController extends HttpServlet {
	
	//상품 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("상품 삭제 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empGoodsList");
	}

}