package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import vo.Customer;


@WebServlet("/customer/customerCartAddAddress")
public class CustomerCartAddAddressController extends HttpServlet {
	private CustomerService customerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		// 세션 로그인 아이디
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId+" : customerId CustomerCartAddAddressController");
		
		// form에서 넘어온 주소값
		String address = request.getParameter("newAddress");
		System.out.println(address+" : address CustomerCartAddAddressController");
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setAddress(address);
		
		customerService = new CustomerService();
		int row = customerService.getAddCustomerAddress(customer);
		
		if(row == 0) {
			System.out.println("주소입력실패 CustomerCartAddAddressController, getAddCustomerAddress");
		} else {
			System.out.println("주소입력성공 CustomerCartAddAddressController, getAddCustomerAddress");
			// /customer/customerCartOrder
			response.sendRedirect(request.getContextPath()+"/customer/customerCartOrder");
		}
		
		
	}

}
