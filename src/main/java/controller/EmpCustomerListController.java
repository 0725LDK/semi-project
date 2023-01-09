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
		
		ArrayList<Customer> list = null;
		this.empService = new EmpService();
		list = empService.getEmpCustomerList();
		
		request.setAttribute("customerList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empCustomerList.jsp").forward(request, response);
	}

}
