package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;


@WebServlet("/emp/empGoodsRemove")
public class EmpGoodsRemoveController extends HttpServlet {
	
	//상품 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 
		 * 로그인 넣기
		 */
		int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		String goodsImg = request.getParameter("goodsImg");
		System.out.println(goodsCode+"<-- EmpGoodsRemoveController goodsCode");		
		
		//m
		GoodsService goodsService = new GoodsService();
		int row = goodsService.removeGoods(null, null);
		System.out.println(row + "<--  row");
		if(row == 1){
			System.out.println("<-- 글 삭제 완료");		

		response.sendRedirect(request.getContextPath()+"/emp/empGoodsList");
		}
	}
}

