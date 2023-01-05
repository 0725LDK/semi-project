package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Emp;

public class EmpDao {

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
