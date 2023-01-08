package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.EmpDao;
import util.DBUtil;
import vo.Emp;

public class EmpService {
	private EmpDao empDao;
	
	// EmpListController 직원리스트
	public ArrayList<Emp> getEmpList() {
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.selectEmpList(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				System.out.println("롤백 EmpService : getEmpList");
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
		return list;
	}
	
	// LoginController 직원로그인
	public Emp EmpLogin(Emp paramEmp) {
		Emp resultEmp = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			resultEmp = empDao.selectEmpByIdAndPw(conn, paramEmp);
			conn.commit();
		} catch (Exception e) {
			try {
				System.out.println("롤백 EmpService : EmpLogin");
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
				System.out.println("롤백 EmpService : getAddEmp");
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
