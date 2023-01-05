package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmpDao;
import util.DBUtil;
import vo.Emp;

public class EmpService {
	EmpDao empDao;
	
	// LoginController 직원로그인
	public Emp EmpLogin(Emp paramEmp) {
		empDao = new EmpDao();
		Emp resultEmp = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			resultEmp = empDao.selectEmpByIdAndPw(conn, paramEmp);
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
	
	// EmpAddController 직원 회원가입
	public int getAddEmp(Emp emp) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			row = empDao.addEmp(conn, emp);
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
