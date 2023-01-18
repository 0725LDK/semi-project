package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpService;
import service.OrderService;
import vo.Customer;


@WebServlet("/emp/empOne")
public class EmpOneController extends HttpServlet {
	private EmpService empService;
	
	//관리자 마이페이지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		//관리자 메인페이지 고객 리스트 받아오기 - 시작
			this.empService = new EmpService();
			
			//페이징 변수
			int firstPage = 1;
			int currentPage = 1;
			if(request.getParameter("currentPage") != null)
			{
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int rowPerPage = 10;
			int beginRow = (currentPage-1)*rowPerPage;
			int lastPage = 0;
			int count = 0;//총 고객 수
			
			//검색 변수
			String search = request.getParameter("search");
			
			ArrayList<Customer> list = null;
			
			if(search == null)
			{
				
				list = empService.getEmpCustomerList(beginRow, rowPerPage);
				count = empService.empCustomerCount();
				
			}
			
			lastPage = count/rowPerPage;		
			if(count%rowPerPage !=0)
			{
				lastPage = lastPage+1;
			}
			
			request.setAttribute("customerList", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("firstPage", firstPage);
			request.setAttribute("lastPage", lastPage);
		//관리자 메인페이지 고객 리스트 받아오기 - 끝
		
		
		//관리자 메인페이지 주류 데이터 받아오기 - 시작
		
			//판매합계데이터
			ArrayList<HashMap<String,Object>> sumList = null;
			this.empService = new EmpService();
			sumList = empService.empSumAlcoholByCategory();
			request.setAttribute("sumByCategory", sumList);
		//관리자 메인페이지 주류 데이터 받아오기 - 끝
			
		//관리자 메인페이지 고객 주문 내역 받아오기 - 시작
			ArrayList<HashMap<String,Object>> orderList = null;
			OrderService orderService = new OrderService();
			
			if(search == null)
			{
				orderList = orderService.empGetOrderListAll(beginRow, rowPerPage);
				count = orderService.empOrderListCount();
			}

			lastPage = count/rowPerPage;
			if(count%rowPerPage !=0)
			{
				lastPage = lastPage+1;
			}
		
			request.setAttribute("orderList", orderList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("firstPage", firstPage);
			request.setAttribute("lastPage", lastPage);
			
		//관리자 메인페이지 고객 주문 내역 받아오기 - 끝
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empOne.jsp").forward(request, response);
	}

}
