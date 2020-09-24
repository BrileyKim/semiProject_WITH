package com.with.question.model.service;

import static com.with.common.JDBCTemplate.close;
import static com.with.common.JDBCTemplate.commit;
import static com.with.common.JDBCTemplate.getConnection;
import static com.with.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.with.question.model.dao.QuestionDao;
import com.with.question.model.vo.Question;
import com.with.question.model.vo.QuestionComment;

public class QuestionService {
	
	private QuestionDao dao= new QuestionDao();
	
	public List<Question> selectQuestionList(int page, String opt, String condition){
		Connection conn = getConnection();
		List<Question> list = dao.selectQuestionList(conn,page,opt,condition);
		close(conn);
		return list;
	}
	
	public int selectQuestionCount(int page, String opt, String condition) {
		Connection conn = getConnection();
		int count = dao.selectQuestionCount(conn,page,opt,condition);
		close(conn);
		return count;
	}
	
	public int insertQuestion(Question q) {
		Connection conn = getConnection();
		int result = dao.insertQuestion(conn, q);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	public Question selectQuestionOne(int num, boolean hasRead) {
		Connection conn = getConnection();
		Question q = dao.selectQuestionOne(conn,num);
		if(q!=null&&!hasRead) {
			int result = dao.updateReadCount(conn,num);
			if(result>0) commit(conn);
			else rollback(conn);
		}
		close(conn);
		return q;
	}
	
	public List<QuestionComment> selectQuestionCommentList(int num){
		Connection conn = getConnection();
		List<QuestionComment> list = dao.selectQuestionCommentList(conn,num);
		close(conn);
		return list;
	}
	
	public int insertQuestionComment(QuestionComment qc) {
		Connection conn = getConnection();
		int result = dao.insertQuestionComment(conn,qc);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	public int questionRemove(int num) {
		Connection conn=getConnection();
		int result=dao.questionRemove(conn,num);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Question selectQuestionOne(int num) {
		
		Connection conn = getConnection();
		Question q = dao.selectQuestionOne(conn, num);
		close(conn);
		return q;
	}
	
	public int questionUpdate(Question q,String hidden) {
		Connection conn = getConnection();
		int result = dao.questionUpdate(conn, q, hidden);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteQuestionComment(int qcCommentRef, int qcNo, int qcLev) {
		Connection conn = getConnection();
		int result = dao.deleteQuestionComment(conn,qcCommentRef,qcNo, qcLev);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	

}
