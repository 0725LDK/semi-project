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
	
	//관리자 리뷰 추가&삭제 리스트 (검색어 없을떄)
	public ArrayList<HashMap<String,Object>> empReviewList(int beginRow, int rowPerPage)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.empReviewList(conn,beginRow, rowPerPage); 
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
	
	//관리자 고객 리뷰 추가&삭제 총 건수 (검색어 없을때)
	public int empReviewListCount(int beginRow, int rowPerPage)
	{
		int count = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			count = empDao.empReviewListCount(conn);
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
	
	//관리자 리뷰 추가&삭제 리스트 (검색어 있을떄)
	public ArrayList<HashMap<String,Object>> empReviewListSearch(int beginRow, int rowPerPage,String Search)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.empReviewListSearch(conn, beginRow, rowPerPage, Search); 
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
	
	//관리자 고객 리뷰 추가&삭제 총 건수 (검색어 있을때)
	public int empReviewListCountSearch(int beginRow, int rowPerPage, String search)
	{
		int count = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			count = empDao.empReviewListCountSearch(conn, search);
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
	
	//관리자 고객 주문 취소 내역 리스트(검색어 없을때)
	public ArrayList<HashMap<String,Object>> empOrderCancleList(int beginRow, int rowPerPage)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.empOrderCancleList(conn, beginRow, rowPerPage); 
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
	
	//관리자 고객 취소 총 건수 (검색어 없을때)
	public int empOrderCancleListCount(int beginRow, int rowPerPage)
	{
		int count = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			count = empDao.empOrderCancleListCount(conn);
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
	
	//관리자 고객 주문 취소 내역 리스트(검색어 없을때)
		public ArrayList<HashMap<String,Object>> empOrderCancleListSearch(int beginRow, int rowPerPage, String search)
		{
			ArrayList<HashMap<String,Object>> list = null;
			Connection conn = null;
			
			try {
				conn = DBUtil.getConnection();
				empDao = new EmpDao();
				list = empDao.empOrderCancleListSearch(conn, beginRow, rowPerPage, search); 
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
		
		//관리자 고객 취소 총 건수 (검색어 없을때)
		public int empOrderCancleListCountSearch(int beginRow, int rowPerPage, String search)
		{
			int count = 0;
			Connection conn = null;
			try {
				conn = DBUtil.getConnection();
				empDao = new EmpDao();
				count = empDao.empOrderCancleListCountSearch(conn, search);
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

	
	// emp 직원리스트(검색어 없을때)
	public ArrayList<Emp> selectEmpList(int beginRow, int rowPerPage) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.selectEmpList(conn, beginRow, rowPerPage);
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
	
	//emp 직원 총 수(검색어 없을떄)
	public int selectEmpListCount()
	{
		int count = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			count = empDao.selectEmpListCount(conn);
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
	// emp 직원리스트(검색어 있을때)
	public ArrayList<Emp> selectEmpListSearch(int beginRow, int rowPerPage, String search) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			list = empDao.selectEmpListSearch(conn, beginRow, rowPerPage, search);
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
	
	//emp 직원 총 수(검색어 있을떄)
	public int selectEmpListCountSearch(String search)
	{
		int count = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			empDao = new EmpDao();
			count = empDao.selectEmpListCountSearch(conn,search);
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