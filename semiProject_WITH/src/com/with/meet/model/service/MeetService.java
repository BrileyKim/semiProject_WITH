package com.with.meet.model.service;

import static com.with.common.JDBCTemplate.close;
import static com.with.common.JDBCTemplate.commit;
import static com.with.common.JDBCTemplate.getConnection;
import static com.with.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.with.meet.model.dao.MeetDao;
import com.with.meet.model.vo.Accept;
import com.with.meet.model.vo.Meet;
import com.with.meet.model.vo.MeetMember;

public class MeetService {
	private MeetDao dao = new MeetDao();
	
	public List<Meet> selectMeetList(int page, String opt, String condition){
		Connection conn = getConnection();
		List<Meet> list = dao.selectMeetList(conn,page,opt,condition);
		close(conn);
		return list;
	}
	
	public int selectMeetCount(int page, String opt, String condition) {
		Connection conn = getConnection();
		int count=dao.selectMeetCount(conn,page,opt,condition);
		close(conn);
		return count;
	}
	
	public List<Meet> selectMyMeetList(String id){
		Connection conn = getConnection();
		List<Meet> list = dao.selectMyMeetList(conn,id);
		close(conn);
		return list;
	}
	
	public int enrollMeet(Meet m) {
		Connection conn = getConnection();
		int result = dao.enrollMeet(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int enrollMeetAdmin(MeetMember mm) {
		Connection conn = getConnection();
		int result = dao.enrollMeetAdmin(conn, mm);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Meet selectMeetOne(int no) {
		Connection conn = getConnection();
		Meet m = dao.selectMeetOne(conn,no);
		close(conn);
		return m;
	}
	
	public String getMyMeetGrade(String id, Meet m) {
		Connection conn = getConnection();
		String grade = dao.getMyMeetGrade(conn,id,m);
		close(conn);
		return grade;
	}
	
	public int getMyHeadCount(Meet m) {
		Connection conn=getConnection();
		int headCount=dao.getMyHeadCount(conn,m);
		close(conn);
		return headCount;
	}
	
	public Meet getMyMeet(String title) {
		Connection conn = getConnection();
		Meet m = dao.getMyMeet(conn,title);
		close(conn);
		return m;
	}
	
	public Accept checkAccept(Meet m, String id) {
		Connection conn = getConnection();
		Accept accept = dao.checkAccept(conn,m,id);
		close(conn);
		return accept;
	}
	
	public int enrollAccept(Meet m, String id) {
		Connection conn=getConnection();
		int result=dao.enrollAccept(conn,m,id);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
}
