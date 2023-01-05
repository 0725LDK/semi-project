package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Customer;

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
	
}
