package service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.OrderDao;
import dao.QuestionDao;
import util.DBUtil;
import vo.Question;
import vo.QuestionComment;
public class QuestionService {
	
	QuestionDao questionDao;
	
	//회원 - 고객센터 문의 리스트
	public ArrayList<HashMap<String,Object>> customerGetQuestionListByPage( String customerId)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			questionDao = new QuestionDao();
			list = questionDao.custormerSelectQuestionListByPage(conn, customerId);
			conn.commit();
			System.out.println("QuestionService 커밋");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("QuestionService 롤백");
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
	
	//회원 - 고객센터 문의 등록 서비스
	public int customerGetAddQuestion(int ordersCode, Question question)
	{
		questionDao = new QuestionDao();
		int row = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = questionDao.customerAddQuestion(conn, ordersCode, question);
			conn.commit();
			System.out.println("CustomerQuestionAddService commit 성공");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("CustomerQuestionAddService rollback됨");
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
	
	//회원 - 고객센터 삭제
	public int customerGetDeleteQuestion(int questionCode)
	{
		questionDao = new QuestionDao();
		int row = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = questionDao.customerDeleteQuestion(conn, questionCode);
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
	
	//회원 - 고객센터 수정
	public int customerGetupdateQuestion(Question question)
	{
		questionDao = new QuestionDao();
		int row = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = questionDao.customerUpdateQuestion(conn, question);
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
	
	//관리자 - 고객센터 문의 리스트(검색어 없을때) 1
	public ArrayList<HashMap<String,Object>> empQuestionList(int beginRow, int rowPerPage)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			questionDao = new QuestionDao();
			list = questionDao.empQuestionList(conn, beginRow, rowPerPage);
			conn.commit();
			System.out.println("EmpQuestionService 커밋");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("EmpQuestionService 롤백");
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
	
	//관리자 고객센터 문의 리스트 총 수(검색어 있을때)2
	public int empQuestionListCount()
	{
		int count = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			questionDao = new QuestionDao();
			count = questionDao.empQuestionListCount(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
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
	
	//관리자 - 고객센터 문의 리스트(검색어 있을때) 3
	public ArrayList<HashMap<String,Object>> empQuestionListSearch(int beginRow, int rowPerPage, String search)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			questionDao = new QuestionDao();
			list = questionDao.empQuestionListSearch(conn, beginRow, rowPerPage, search);
			conn.commit();
			System.out.println("EmpQuestionService 커밋");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("EmpQuestionService 롤백");
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
	
	//관리자 고객센터 문의 리스트 총 수(검색어 있을때)4
	public int empQuestionListCountSearch(String search)
	{
		int count = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			questionDao = new QuestionDao();
			count = questionDao.empQuestionListCountSearch(conn, search);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
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
	
	//관리자 전체 고객 주문내역 건 수 확인(검색어 없을때)
	public int empOrderListCount()
	{
		int count = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			questionDao = new QuestionDao();
			count = questionDao.empQuestionListCount(conn);
			System.out.println(count+"<--orderService count 수");
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
	
	//관리자 - 고객센터 문의 답변 작성
	public int empGetAddQuestion(QuestionComment questionComment)
	{
		questionDao = new QuestionDao();
		int row = 0;
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			row = questionDao.empAddQuestion(conn, questionComment);
			conn.commit();
			System.out.println("CustomerQuestionAddService commit 성공");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("CustomerQuestionAddService rollback됨");
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

	//관리자 - 고객센터 문의 답변 수정
	public int empGetModifyQuestion(QuestionComment questionComment)
	{
		questionDao = new QuestionDao();
		int row = 0;
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			row = questionDao.empModifyQuestion(conn, questionComment);
			conn.commit();
			System.out.println("CustomerQuestionModifyService commit 성공");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("CustomerQuestionModifyService rollback됨");
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
		