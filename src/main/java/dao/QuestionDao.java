package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Question;
import vo.QuestionComment;

public class QuestionDao {
	
	//회원 - 고객센터 리스트
	public ArrayList<HashMap<String,Object>> custormerSelectQuestionListByPage(Connection conn,String customerId)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT cu.customer_id customerId, qu.question_code questionCode, orders_code ordersCode, category, question_memo questionMemo, qu.createdate,comment_memo commentMemo"
				+ " FROM orders od"
				+ " inner JOIN customer cu ON od.customer_id = cu.customer_id"
				+ "	INNER JOIN question qu ON od.order_code = qu.orders_code"
				+ "	left OUTER JOIN question_comment qc ON qu.question_code = qc.question_code"
				+ " WHERE od.customer_id = ? ";
				
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			HashMap<String,Object> q = new HashMap<String,Object>();
			q.put("questionCode", rs.getInt("questionCode"));
			q.put("ordersCode", rs.getInt("ordersCode"));
			q.put("category", rs.getString("category"));
			q.put("questionMemo", rs.getString("questionMemo"));
			q.put("createdate", rs.getString("createdate"));
			q.put("commentMemo", rs.getString("commentMemo"));
			list.add(q);
		}
		
		return list;
	}
	
	
	//회원 - 고객센터 문의 등록
	public int customerAddQuestion(Connection conn, int ordersCode, Question question) throws Exception
	{
		int row = 0;
		
		String sql = "INSERT INTO question(orders_code,category,question_memo,createdate) "
				+ " VALUES(?, ?, ?, CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, ordersCode);
		stmt.setString(2, question.getCategory());
		stmt.setString(3, question.getQuestionMemo());
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//회원 - 고객센터 문의 삭제
	public int customerDeleteQuestion(Connection conn, int questionCode)throws Exception
	{
		int row = 0;
		
		String sql = "DELETE from question WHERE question_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, questionCode);
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//회원 - 고객센터 문의 수정
	public int customerUpdateQuestion(Connection conn, Question question)throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE question SET question_memo = ? WHERE question_code= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, question.getQuestionMemo());
		stmt.setInt(2, question.getQuestionCode());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//관리자 - 고객센터 문의 리스트
	public ArrayList<HashMap<String,Object>> EmpSelectQuestionListByPage(Connection conn)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT qu.question_code questionCode, qu.orders_code ordersCode, qu.category category "
				+ " 		 , qu.question_memo questionMemo, qu.createdate questionCreatedate"
				+ "          , qc.comment_memo commentMemo, qc.createdate commentCreatedate"
				+ " FROM question qu"
				+ " LEFT OUTER JOIN question_comment qc ON qu.question_code = qc.question_code";
				
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			HashMap<String,Object> q = new HashMap<String,Object>();
			q.put("questionCode", rs.getInt("questionCode"));
			q.put("ordersCode", rs.getInt("ordersCode"));
			q.put("category", rs.getString("category"));
			q.put("questionMemo", rs.getString("questionMemo"));
			q.put("questionCreatedate", rs.getString("questionCreatedate"));
			q.put("commentMemo", rs.getString("commentMemo"));
			q.put("commentCreatedate", rs.getString("commentCreatedate"));
			list.add(q);
		}
		
		return list;
	}
	
	//관리자 - 고객센터 답변 작성
	public int empAddQuestion(Connection conn, QuestionComment questionComment) throws Exception
	{
		int row = 0;
		
		String sql = "INSERT INTO question_comment(question_code,comment_memo,createdate) "
				+ " VALUES(?, ? , CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, questionComment.getQuestionCode());
		stmt.setString(2, questionComment.getCommentMemo());
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//관리자 - 고객센터 답변 수정
	public int empModifyQuestion(Connection conn, QuestionComment questionComment )throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE question_comment SET comment_memo = ? WHERE question_code= ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, questionComment.getCommentMemo());
		stmt.setInt(2, questionComment.getQuestionCode());
		row = stmt.executeUpdate();
		
		return row;
	}
}