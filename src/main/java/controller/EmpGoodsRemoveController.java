package controller;

import java.io.File;
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
		String dir = request.getServletContext().getRealPath("/upload");
		String filename = request.getParameter("filename");
		
		System.out.println(goodsCode+"<-- EmpGoodsRemoveController goodsCode");		
		System.out.println(dir+"<-- EmpGoodsRemoveController dir");		
		System.out.println(filename+"<-- EmpGoodsRemoveController filename");		
		
		
		// 서비스 호출
		GoodsService goodsService = new GoodsService();
		int row = goodsService.removeGoods(goodsCode);
		
		if(row == 1) {
			File f = new File(dir + "\\" + filename);
			if(f.exists()) {
				f.delete();
			}			
		} else {
			System.out.println("삭제 실패");
		}


		response.sendRedirect(request.getContextPath()+"/emp/empGoodsList");
	}
}


