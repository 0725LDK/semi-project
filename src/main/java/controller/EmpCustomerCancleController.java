package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;


@WebServlet("/emp/empCustomerCancle")
public class EmpCustomerCancleController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<HashMap<String,Object>> list = null;
		EmpService empService = new EmpService();
		list = empService.empOrderCancleList();
		request.setAttribute("orderList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empCustomerCancle.jsp").forward(request, response);
	}

}