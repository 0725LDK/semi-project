package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Customer;
import vo.Customer_address;

public class CustomerDao {

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
	
	// 아이디 중복검사
	// return boolean value : true(사용가능 아이디) / false(사용불가 아이디)
	public boolean checkId(Connection conn, String idCheck) throws Exception {
		boolean result = true;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT t.id"
				+ " FROM (SELECT customer_id id FROM customer"
				+ "			UNION"
				+ "			SELECT id FROM outid"
				+ "			UNION"
				+ "			SELECT emp_id FROM emp) t"
				+ " WHERE t.id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, idCheck);
		
		rs = stmt.executeQuery();
		if(rs.next()) { // 이미 사용된 아이디
			result = false;
		}
		return result;
	}
	
	// customer 회원가입
	public int addCustomer(Connection conn, Customer customer) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO customer (customer_id, customer_pw, customer_name, customer_phone, point)"
				+ " VALUES (?, PASSWORD(?), ?, ?, '0')";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		stmt.setString(2, customer.getCustomerPw());
		stmt.setString(3, customer.getCustomerName());
		stmt.setString(4, customer.getCustomerPhone());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// customer address
	public int addCustomerAddress(Connection conn, Customer_address customerAddress) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO customer_address (customer_id, address)"
				+ " VALUES (?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerAddress.getCustomerId());
		stmt.setString(2, customerAddress.getAddress());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
}
