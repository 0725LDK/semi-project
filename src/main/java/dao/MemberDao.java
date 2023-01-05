package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Customer;
import vo.Emp;

public class MemberDao {

	// customer 로그인
	public Customer selectCustomerByIdAndPw(Connection conn, Customer paramCustomer) throws Exception {
		Customer resultCustomer = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT customer_id customerId, customer_name customerName"
				+ " FROM customer"
				+ " WHERE customer_id = ? AND customer_pw = PASSWORD(?)";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, paramCustomer.getCustomerId());
		stmt.setString(2, paramCustomer.getCustomerPw());
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			resultCustomer = new Customer();
			resultCustomer.setCustomerId(rs.getString("customerId"));
			resultCustomer.setCustomerName(rs.getString("customerName"));
		}
		return resultCustomer;
	}
	
	// emp 로그인
	public Emp selectEmpByIdAndPw(Connection conn, Emp paramEmp) throws Exception {
		Emp resultEmp = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_id empId, emp_name empName, active, auth_code authCode"
				+ " FROM emp"
				+ " WHERE emp_id = ? AND emp_pw = PASSWORD(?)";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, paramEmp.getEmpId());
		stmt.setString(2, paramEmp.getEmpPw());
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			resultEmp = new Emp();
			resultEmp.setEmpId(rs.getString("empId"));
			resultEmp.setEmpName(rs.getString("empName"));
			resultEmp.setActive(rs.getString("active"));
			resultEmp.setAuthCode(rs.getInt("authCode"));
		}
		return resultEmp;
	}
	
	// customer 회원가입
	public int addCustomer(Connection conn, Customer customer) throws Exception {
		int row = 0;
		String sql = "INSERT INTO customer (customer_id, customer_pw, customer_name, customer_phone, point)"
				+ " VALUES (?, PASSWORD(?), ?, ?, '0')";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		stmt.setString(2, customer.getCustomerPw());
		stmt.setString(3, customer.getCustomerName());
		stmt.setString(4, customer.getCustomerPhone());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// emp 회원가입
	public int addEmp(Connection conn, Emp emp) throws Exception {
		int row = 0;
		String sql = "INSERT INTO emp (emp_id, emp_pw, emp_name)"
				+ " VALUES (?, PASSWORD(?), ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpId());
		stmt.setString(2, emp.getEmpPw());
		stmt.setString(3, emp.getEmpName());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	
	
}
