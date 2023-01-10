package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.EmpDao;
import util.DBUtil;
import vo.Customer;
import vo.Emp;

public class EmpService {
	private EmpDao empDao;
	
	//emp 관리자 화면에서 고객 리스트 출력 서비스
	public ArrayList<Customer> getEmpCustomerList()
	{
		ArrayList<Customer> list = new ArrayList<Customer>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.empSelectCustomerList(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
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
	// emp 직원 정보 수정 서비스
	public int getEmpModifyInfo(Emp emp)
	{
		int row = 0;
		Connection conn = null;
		empDao = new EmpDao();
		
		try {
			conn = DBUtil.getConnection();
			row = empDao.updateEmpInfo(conn, emp);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
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
	
	//emp 직원 삭제 후 ID를 outId table에 추가
	public int deleteEmpAndAddOutId(int empCode, String empId)
	{
		int row = 0;
		int addOutId = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			addOutId = empDao.updateOutIdDeletedEmpId(conn, empId);
			if(addOutId == 1)
			{
				row = empDao.deleteEmp(conn, empCode);
			}
			else
			{
				throw new Exception();
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
}