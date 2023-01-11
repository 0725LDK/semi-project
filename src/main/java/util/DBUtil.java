package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	public static Connection getConnection() throws Exception {
		String driver = "org.mariadb.jdbc.Driver";
		String uri = "jdbc:mariadb://localhost:3306/shop";
		String id = "root";
		String pw = "java1234";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(uri, id, pw);
		conn.setAutoCommit(false);
		return conn;
	}


}
