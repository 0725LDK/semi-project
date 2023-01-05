package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import util.DBUtil;
import vo.Customer;
import vo.Emp;

public class MemberService {
	MemberDao memberDao;

	// LoginController 고객로그인
	public Customer CustomerLogin(Customer paramCustomer) {
		memberDao = new MemberDao();
		Customer resultCustomer = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			resultCustomer = memberDao.selectCustomerByIdAndPw(conn, paramCustomer);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultCustomer;
	}
		
	// LoginController 직원로그인
	public Emp EmpLogin(Emp paramEmp) {
		memberDao = new MemberDao();
		Emp resultEmp = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			resultEmp = memberDao.selectEmpByIdAndPw(conn, paramEmp);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultEmp;
	}
	
	// EmpAddController 고객 회원가입
	public int getAddCustomer(Customer customer) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			memberDao = new MemberDao();
			row = memberDao.addCustomer(conn, customer);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// EmpAddController 직원 회원가입
	public int getAddEmp(Emp emp) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			memberDao = new MemberDao();
			row = memberDao.addEmp(conn, emp);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
}
