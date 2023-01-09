package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.QuestionDao;
import util.DBUtil;
import vo.Question;
import vo.Question_comment;

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
	
	//관리자 - 고객센터 문의 리스트
	public ArrayList<HashMap<String,Object>> empGetQuestionListByPage()
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			questionDao = new QuestionDao();
			list = questionDao.EmpSelectQuestionListByPage(conn);
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
	
	//관리자 - 고객센터 문의 답변 작성
	public int empGetAddQuestion(Question_comment questionComment)
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
	public int empGetModifyQuestion(Question_comment questionComment)
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
