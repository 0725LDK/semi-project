package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import vo.Emp;

public class EmpDao {

	// emp 리스트
	public ArrayList<Emp> selectEmpList(Connection conn) throws Exception {
		ArrayList<Emp> list = new ArrayList<Emp>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_code empCode, emp_id empId, emp_name empName, active, auth_code authCode, createdate"
				+ " FROM emp"
				+ " ORDER BY createdate DESC";
		stmt = conn.prepareStatement(sql);
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setEmpCode(rs.getInt("empCode"));
			emp.setEmpId(rs.getString("empId"));
			emp.setEmpName(rs.getString("empName"));
			emp.setActive(rs.getString("active"));
			emp.setAuthCode(rs.getInt("authCode"));
			emp.setCreatedate(rs.getString("createdate"));
			list.add(emp);
		}
		return list;
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
	
	// emp 회원가입
	public int addEmp(Connection conn, Emp emp) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO emp (emp_id, emp_pw, emp_name)"
				+ " VALUES (?, PASSWORD(?), ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpId());
		stmt.setString(2, emp.getEmpPw());
		stmt.setString(3, emp.getEmpName());
		
		row = stmt.executeUpdate();
		
		return row;
	}
}
