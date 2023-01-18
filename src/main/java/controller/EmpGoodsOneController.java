package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GoodsService;


@WebServlet("/emp/empGoodsOne")
public class EmpGoodsOneController extends HttpServlet {
	
	//관리자 상품 상세 보기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		// goodsOne
		int goodsCode = 0;	
		if(request.getParameter("goodsCode") != null){
			goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		}
		// 디버깅
		System.out.println(goodsCode + "<-- EmpGoodsOneController goodsCode"); 
		
	    HashMap<String, Object> map = new HashMap<String, Object>();
		GoodsService goodsService = new GoodsService();
		map = goodsService.getGoodsOne(goodsCode);
	    
		request.setAttribute("map", map); // view 페이지와 공유할 모델데이터 저장
		
		// view
		request.getRequestDispatcher("/WEB-INF/view/emp/empGoodsOne.jsp").forward(request, response);

	
	}
	

}
