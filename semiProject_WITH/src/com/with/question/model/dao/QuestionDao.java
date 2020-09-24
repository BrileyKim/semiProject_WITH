package com.with.question.model.dao;

import static com.with.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.with.question.model.vo.Question;
import com.with.question.model.vo.QuestionComment;

public class QuestionDao {
	
	private Properties prop = new Properties();
	
	public QuestionDao() {
		try {
			String path = QuestionDao.class.getResource("/sql/question/question_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<Question> selectQuestionList(Connection conn, int page, String opt, String condition){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Question> list = new ArrayList();
		try {
			if(opt==null) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionListAll"));
				pstmt.setInt(1, page);
				pstmt.setInt(2, page+4);
			}else if(opt.equals("0")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionListTitle"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+4);
			}else if(opt.equals("1")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionListContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+4);
			}else if(opt.equals("2")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionListTitleorContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, page);
				pstmt.setInt(4, page+4);
			}else if(opt.equals("3")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionListWriter"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+4);
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Question q=new Question();
				q.setQuestionIdx(rs.getInt("question_idx"));
				q.setQuestionWriter(rs.getString("question_writer"));
				q.setQuestionTitle(rs.getString("question_title"));
				q.setQuestionContent(rs.getString("question_content"));
				q.setQuestionOriginalFilename(rs.getString("question_original_filename"));
				q.setQuestionRenamedFilename(rs.getString("question_renamed_filename"));
				q.setQuestionEnrollDate(rs.getDate("question_enrolldate"));
				q.setQuestionReadCount(rs.getInt("question_readcount"));
				list.add(q);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int selectQuestionCount(Connection conn,int page,String opt, String condition) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int count=0;
		try {
			if(opt==null) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionCount"));	
			}else if(opt.equals("0")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionCountTitle"));
				pstmt.setString(1, "%"+condition+"%");
			}else if(opt.equals("1")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionCountContent"));
				pstmt.setString(1, "%"+condition+"%");
			}else if(opt.equals("2")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionCountTitleorContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
			}else if(opt.equals("3")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectQuestionCountWriter"));
				pstmt.setString(1, "%"+condition+"%");
			}
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}
	
	public int insertQuestion(Connection conn, Question q) {
		PreparedStatement pstmt = null;
		int result = 0 ; 
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertQuestion"));
			pstmt.setString(1, q.getQuestionWriter());
			pstmt.setString(2, q.getQuestionTitle());
			pstmt.setString(3, q.getQuestionContent());
			pstmt.setString(4, q.getQuestionOriginalFilename());
			pstmt.setString(5, q.getQuestionRenamedFilename());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Question selectQuestionOne(Connection conn, int num) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Question q=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectQuestionOne"));
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				q=new Question();
				q.setQuestionIdx(rs.getInt("question_idx"));
				q.setQuestionWriter(rs.getString("question_writer"));
				q.setQuestionTitle(rs.getString("question_title"));
				q.setQuestionContent(rs.getString("question_content"));
				q.setQuestionOriginalFilename(rs.getString("question_original_filename"));
				q.setQuestionRenamedFilename(rs.getString("question_renamed_filename"));
				q.setQuestionEnrollDate(rs.getDate("question_enrolldate"));
				q.setQuestionReadCount(rs.getInt("question_readcount"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return q;
	}
	
	public int updateReadCount(Connection conn, int num) {
		PreparedStatement pstmt = null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateReadCount"));
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<QuestionComment> selectQuestionCommentList(Connection conn, int num){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QuestionComment> list =new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectQuestionCommentList"));
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				QuestionComment qc = new QuestionComment();
				qc.setQaCommentNo(rs.getInt(1));
				qc.setQaCommentLevel(rs.getInt(2));
				qc.setQaCommentWriter(rs.getString(3));
				qc.setQaCommentContent(rs.getString(4));
				qc.setQaRef(rs.getInt(5));
				qc.setCommentRef(rs.getInt(6));
				qc.setQaCommentDate(rs.getDate(7));
				list.add(qc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	public int insertQuestionComment(Connection conn, QuestionComment qc) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertQuestionComment"));
			pstmt.setInt(1, qc.getQaCommentLevel());
			pstmt.setString(2, qc.getQaCommentWriter());
			pstmt.setString(3, qc.getQaCommentContent());
			pstmt.setInt(4, qc.getQaRef());
			pstmt.setString(5, qc.getCommentRef()==0?null:String.valueOf(qc.getCommentRef()));
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int questionRemove(Connection conn, int num) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("questionRemove"));
			pstmt.setInt(1, num);
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int questionUpdate(Connection conn,Question q, String hidden) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			if(q.getQuestionOriginalFilename()==null) {
				if(hidden.equals("delete")) {
					pstmt=conn.prepareStatement(prop.getProperty("questionUpdate"));
					pstmt.setString(1, q.getQuestionTitle());
					pstmt.setString(2, q.getQuestionWriter());
					pstmt.setString(3, q.getQuestionOriginalFilename());
					pstmt.setString(4, q.getQuestionRenamedFilename());
					pstmt.setString(5, q.getQuestionContent());
					pstmt.setInt(6, q.getQuestionIdx());
				}else {
					pstmt=conn.prepareStatement(prop.getProperty("questionUpdateNull"));
					pstmt.setString(1, q.getQuestionTitle());
					pstmt.setString(2, q.getQuestionWriter());
					pstmt.setString(3, q.getQuestionContent());
					pstmt.setInt(4, q.getQuestionIdx());
				}
			}else {
				pstmt=conn.prepareStatement(prop.getProperty("questionUpdate"));
				pstmt.setString(1, q.getQuestionTitle());
				pstmt.setString(2, q.getQuestionWriter());
				pstmt.setString(3, q.getQuestionOriginalFilename());
				pstmt.setString(4, q.getQuestionRenamedFilename());
				pstmt.setString(5, q.getQuestionContent());
				pstmt.setInt(6, q.getQuestionIdx());
			}
			result=pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	public int deleteQuestionComment(Connection conn,int qcCommentRef, int qcNo, int qcLev) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			if(qcLev==1) {
				pstmt=conn.prepareStatement(prop.getProperty("deleteMainComment"));
				pstmt.setInt(1, qcNo);
			}else if(qcLev==2) {
				pstmt=conn.prepareStatement(prop.getProperty("deleteComment"));
				pstmt.setInt(1, qcCommentRef);
				pstmt.setInt(2, qcNo);
			}
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}


