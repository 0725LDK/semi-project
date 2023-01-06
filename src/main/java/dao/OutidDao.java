package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vo.Customer;

public class OutidDao {

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
}
