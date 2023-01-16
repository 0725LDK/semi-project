package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.EmpDao;
import dao.OrderDao;
import util.DBUtil;
import vo.Customer;
import vo.Emp;

public class EmpService {
	private EmpDao empDao;
	
	//관리자 리뷰 리스트
	public ArrayList<HashMap<String,Object>> empReviewList()
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.empReviewList(conn); 
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
	
	//관리자 주종별 판매금액 합계
	public ArrayList<HashMap<String,Object>> empSumAlcoholByCategory()
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.empSumAlcoholByCategory(conn); 
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
	
	//관리자 주종별 판매횟수 합계
		public ArrayList<HashMap<String,Object>> empCountAlcoholByCategory()
		{
			ArrayList<HashMap<String,Object>> list = null;
			Connection conn = null;
			
			try {
				conn = DBUtil.getConnection();
				empDao = new EmpDao();
				list = empDao.empSumAlcoholByCategory(conn); 
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
	
	//관리자 고객 주문 취소 내역 리스트
	public ArrayList<HashMap<String,Object>> empOrderCancleList()
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.empOrderCancleList(conn); 
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
	
	//emp 관리자 화면에서 고객 리스트 출력 (검색어 없을때)
	public ArrayList<Customer> getEmpCustomerList(int beginRow, int rowPerPage)
	{
		ArrayList<Customer> list = new ArrayList<Customer>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.empSelectCustomerList(conn, beginRow, rowPerPage);
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
	//emp 관리자 고객 총 수(검색어 없을떄)
	public int empCustomerCount()
	{
		int count = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			count = empDao.empCustomerCount(conn);
			System.out.println(count+"<--empService count 수");
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
		return count;
	}
	
	//emp 관리자 화면에서 고객 리스트 출력 (검색어 있을때)
		public ArrayList<Customer> getEmpCustomerListSearch(int beginRow, int rowPerPage, String search)
		{
			ArrayList<Customer> list = new ArrayList<Customer>();
			Connection conn = null;
			try {
				conn = DBUtil.getConnection();
				empDao = new EmpDao();
				list = empDao.empSelectCustomerListSearch(conn, beginRow, rowPerPage, search);
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
		//emp 관리자 고객 총 수(검색어 있을때)
		public int empCustomerCountSearch(String search)
		{
			int count = 0;
			Connection conn = null;
			try {
				conn = DBUtil.getConnection();
				empDao = new EmpDao();
				count = empDao.empCustomerCountSearch(conn, search);
				System.out.println(count+"<--empService searchCount 수");
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
			return count;
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