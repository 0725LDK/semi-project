package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpService;
import vo.Customer;


@WebServlet("/emp/empCustomerList")
public class EmpCustomerListController extends HttpServlet {
	
	private EmpService empService;
	
	//회원정보 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
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
			lastPage = count/rowPerPage;
			
		}
		else if(search != null)
		{
			list = empService.getEmpCustomerListSearch(beginRow, rowPerPage, search);
			count = empService.empCustomerCountSearch(search);
			lastPage = count/rowPerPage;		
		}
		
		if(count%rowPerPage !=0)
		{
			lastPage = lastPage+1;
		}
		
		request.setAttribute("customerList", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("firstPage", firstPage);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empCustomerList.jsp").forward(request, response);
	}

}