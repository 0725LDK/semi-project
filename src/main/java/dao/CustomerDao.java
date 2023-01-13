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
		String sql = "SELECT customer_id customerId, customer_name customerName, customer_phone customerPhone"
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
			resultCustomer.setCustomerPhone(rs.getString("customerPhone"));
		}
		return resultCustomer;
	}
	
	// customer 회원정보
	public Customer selectCustomerByOne(Connection conn, String customerId) throws Exception {
		Customer customer = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT  t.customerId customerId, t.customerName customerName, t.customerPhone customerPhone, t.address address, t.addressCode addressCode, t.point point "
				+ "				FROM(SELECT POINT, c.customer_id customerId, c.customer_name customerName, c.customer_phone customerPhone, a.address address, a.address_code addressCode "
				+ "						FROM customer c INNER JOIN customer_address a "
				+ "						ON c.customer_id = a.customer_id) t "
				+ "				WHERE customerId = ? "
				+ "				ORDER BY addressCode DESC";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			customer = new Customer();
			customer.setCustomerId(rs.getString("customerId"));
			customer.setCustomerName(rs.getString("customerName"));
			customer.setCustomerPhone(rs.getString("customerPhone"));
			customer.setAddress(rs.getString("address"));
			customer.setPoint(rs.getInt("point"));
		}
		return customer;
	}
	
	// 아이디 중복검사 customer,outid,emp
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
		String sql = "INSERT INTO customer (customer_id, customer_pw, customer_name, customer_phone, point, createdate)"
				+ " VALUES (?, PASSWORD(?), ?, ?, '0', now())";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		stmt.setString(2, customer.getCustomerPw());
		stmt.setString(3, customer.getCustomerName());
		stmt.setString(4, customer.getCustomerPhone());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// 회원가입시 비밀번호 수정시 pw_history 입력
	public int addPwHistory(Connection conn, Customer customer) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO pw_history (customer_id, pw)"
				+ " VALUES (?, PASSWORD(?))";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		stmt.setString(2, customer.getCustomerPw());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// 회원가입시 customer address 입력
	public int addCustomerAddress(Connection conn, Customer customer) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO customer_address (customer_id, address, createdate)"
				+ " VALUES (?, ?, now())";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		stmt.setString(2, customer.getAddress());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// customer 회원정보 수정시 현재 비밀번호확인
	public int passwordCheck(Connection conn, String customerId, String customerPw) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM customer WHERE customer_id = ? AND customer_pw = PASSWORD(?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setString(2, customerPw);
		
		rs = stmt.executeQuery();
		if(rs.next()) {
			row = 1; // 현재 비밀번호 일치
		}
		return row;
	}
	
	// customer 회원정보 수정시 최근3번 변경값 중복확인 
	// return boolean true(사용가능), false(중복!사용불가)
	public boolean newPasswordCheck(Connection conn, Customer customer) throws Exception {
		boolean result = true;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT t.customer_id, t.pw"
				+ " FROM(SELECT customer_id, pw, createdate"
				+ "		FROM pw_history"
				+ "		WHERE customer_id = ?"
				+ "		ORDER BY createdate DESC"
				+ "		LIMIT 0,3) t"
				+ " WHERE t.pw = PASSWORD(?);";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		stmt.setString(2, customer.getCustomerPw());
		
		rs = stmt.executeQuery();
		if(rs.next()) {
			result = false; // 최근비밀번호 3개중 중복
		}
		return result;
	}
	
	// customer 회원정보 수정
	public int modifyCustomer(Connection conn, Customer customer) throws Exception {
		int result = 0;
		PreparedStatement stmt = null;
		String sql = "UPDATE customer"
				+ " SET customer_pw = PASSWORD(?), customer_name = ?, customer_phone = ?"
				+ " WHERE customer_id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerPw());
		stmt.setString(2, customer.getCustomerName());
		stmt.setString(3, customer.getCustomerPhone());
		stmt.setString(4, customer.getCustomerId());
		
		result = stmt.executeUpdate();
		
		return result;
	}
	
	// customer 회원정보 수정 후 pw_history 데이터 4개이상값 삭제
	public void removePwHistoryByFour(Connection conn, Customer customer) throws Exception {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM pw_history WHERE createdate IN"
				+ "		(SELECT * FROM"
				+ "			((SELECT createdate"
				+ "			FROM pw_history"
				+ "			WHERE customer_id = ?"
				+ "			order BY createdate DESC"
				+ "			LIMIT 3,1) resultT))";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		
		stmt.executeUpdate();
	}
	
	// customer 회원탈퇴
	public int removeCustomer(Connection conn, Customer customer) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM customer WHERE customer_id = ? AND customer_pw = PASSWORD(?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		stmt.setString(2, customer.getCustomerPw());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	// 회원탈퇴시 pw_history테이블 데이터 삭제
	public int removePwHistory(Connection conn, Customer customer) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM pw_history WHERE customer_id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		
		// row값 1~3 
		row = stmt.executeUpdate();
		
		return row;
	}
	// 회원탈퇴시 outid테이블에 입력
	public int addOutId(Connection conn, Customer customer) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO outid(id) VALUES(?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerId());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//회원 포인트 내역 조회
	public int customerSearchPoint(Connection conn, String customerId)throws Exception
	{
		int searchPoint = 0;

		String sql = "SELECT SUM(POINT) sumPoint "
				+ "		FROM point_history ph "
				+ "		RIGHT OUTER JOIN orders od ON ph.order_code = od.order_code "
				+ " WHERE customer_id = ? "
				+ " GROUP BY customer_id";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next())
		{
			searchPoint = rs.getInt("sumPoint");
			System.out.println(searchPoint+"<--고객포인트 Dao");
		}

		return searchPoint; 
	}
	public int customerPointUpdate(Connection conn, int searchPoint, String customerId)throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE customer SET POINT = ? WHERE customer_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, searchPoint);
		stmt.setString(2, customerId);
		row = stmt.executeUpdate(); 
		
		return row;
	}
	
}