package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Question;

public class QuestionDao {
	
	//고객센터 리스트
	public ArrayList<HashMap<String,Object>> selectQuestionListByPage(Connection conn,int questionCode)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT qc.question_code questionCode, orders_code ordersCode, category, question_memo questionMemo, qc.createdate,comment_memo commentMemo"
				+ " FROM question qu"
				+ " INNER JOIN question_comment qc ON qu.question_code = qc.question_code"
				+ " WHERE qu.question_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, questionCode);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			HashMap<String,Object> q = new HashMap<String,Object>();
			q.put("questionCode", rs.getInt("questionCode"));
			q.put("ordersCode", rs.getInt("ordersCode"));
			q.put("category", rs.getString("category"));
			q.put("setQuestionMemo", rs.getString("setQuestionMemo"));
			q.put("commentMemo", rs.getString("commentMemo"));
			list.add(q);
		}
		
		return list;
	}
	
	
	//고객센터 문의 등록
	public int addQuestion(Connection conn, int ordersCode, Question question) throws Exception
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
	
	//고객센터 문의 삭제
	public int deleteQuestion(Connection conn, int questionCode)throws Exception
	{
		int row = 0;
		
		String sql = "DELETE from question WHERE question_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, questionCode);
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//고객센터 문의 수정
	public int updateQuestion(Connection conn, Question question)throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE question SET question_memo = ? WHERE question_code= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, question.getQuestionMemo());
		stmt.setInt(2, question.getQuestionCode());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
}
