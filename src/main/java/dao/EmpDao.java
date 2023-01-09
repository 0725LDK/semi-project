package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Customer;
import vo.Emp;

public class EmpDao {
	// emp 관리자 화면에서 고객 리스트업
	public ArrayList<Customer> empSelectCustomerList(Connection conn)throws Exception
	{
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		String sql = "SELECT customer_code customerCode, cu.customer_id customerId, customer_name customerName,"
				+ "		 customer_phone customerPhone, ca.address address, POINT, cu.createdate"
				+ " FROM customer cu"
				+ " INNER JOIN customer_address ca ON cu.customer_id = ca.customer_id";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			Customer c = new Customer();
			c.setCustomerCode(rs.getInt("customerCode"));
			c.setCustomerId(rs.getString("customerId"));
			c.setCustomerName(rs.getString("customerName"));
			c.setCustomerPhone(rs.getString("customerPhone"));
			c.setAddress(rs.getString("address"));
			c.setPoint(rs.getInt("point"));
			c.setCreatedate(rs.getString("createdate"));
			list.add(c);
		}
		
		return list;
		
	}
	
	//emp 직원 정보 변경
	public int updateEmpInfo(Connection conn, Emp emp) throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE emp SET emp_name = ?, active= ?, auth_code= ? WHERE emp_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpName());
		stmt.setString(2, emp.getActive());
		stmt.setInt(3, emp.getAuthCode());
		stmt.setInt(4,emp.getEmpCode());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//emp 직원 삭제시 outId에 추가
	public int updateOutIdDeletedEmpId(Connection conn, String empId) throws Exception
	{
		int addOutId = 0;
		
		String sql = "INSERT INTO outid(id)VALUE(?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, empId);
		
		addOutId = stmt.executeUpdate();
		
		return addOutId;
	}
	
	//emp 직원 삭제
	public int deleteEmp(Connection conn, int empCode) throws Exception
	{
		int row = 0;
		
		String sql ="DELETE FROM emp WHERE emp_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, empCode);
		row = stmt.executeUpdate();
		
		return row;
	}
	
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
