package com.with.walk.model.service;

import static com.with.common.JDBCTemplate.close;
import static com.with.common.JDBCTemplate.commit;
import static com.with.common.JDBCTemplate.getConnection;
import static com.with.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.with.meet.model.vo.Accept;
import com.with.meet.model.vo.Meet;
import com.with.walk.model.dao.WalkDao;
import com.with.walk.model.vo.Walk;
import com.with.walk.model.vo.WalkAccept;
import com.with.walk.model.vo.WalkMember;


public class WalkService {
	private WalkDao dao = new WalkDao();
	
	public List<Walk> selectWalkList(int page,String opt,String condition,int walkMeetIdx){
		Connection conn = getConnection();
		List<Walk> list = dao.selectWalkList(conn,page,opt,condition,walkMeetIdx);
		close(conn);
		return list;
	}
	
	public int selectWalkCount(int page, String opt, String condition, int walkMeetIdx) {
		Connection conn = getConnection();
		int count = dao.selectWalkCount(conn,page,opt,condition,walkMeetIdx);
		close(conn);
		return count;
	}
	
	public Walk selectWalkOne(String writer, String title) {
		Connection conn = getConnection();
		Walk w = dao.selectWalkOne(conn,writer,title);
		close(conn);
		return w;
	}
	
	public List<Walk> selectMyWalk(String id) {
		Connection conn = getConnection();
		List<Walk> list = dao.selectMyWalk(conn,id);
		close(conn);
		return list;
	}
	
	public Walk selectWalkTwo(int walkIdx) {
		Connection conn = getConnection();
		Walk w = dao.selectWalkTwo(conn,walkIdx);
		close(conn);
		return w;
	}
	
	public int addWalk(Walk w) {
		Connection conn = getConnection();
		int result = dao.addWalk(conn, w);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int enrollWalkAdmin(WalkMember wm) {
		Connection conn = getConnection();
		int result = dao.enrollMeetAdmin(conn, wm);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int getWalkHeadCount(Walk w) {
		Connection conn=getConnection();
		int headCount = dao.getWalkHeadCount(conn,w);
		close(conn);
		return headCount;
	}
	
	public int updateWalk(Walk w) {
		Connection conn = getConnection();
		int result=dao.updateWalk(conn,w);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public WalkAccept checkWalkAccept(Walk w, String id) {
		Connection conn = getConnection();
		WalkAccept walkAccept = dao.checkWalkAccept(conn,w,id);
		close(conn);
		return walkAccept;
	}
	
	public int enrollAccept(Walk w, String id) {
		Connection conn=getConnection();
		int result=dao.enrollAccept(conn,w,id);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;	
	}
	
	public String getMyWalkGrade(String id, int walkNo) {
		Connection conn = getConnection();
		String grade = dao.getMyWalkGrade(conn,id,walkNo);
		close(conn);
		return grade;
	}
	
	public List<WalkAccept> checkMyWalkAccept(String id){
		Connection conn = getConnection();
		List<WalkAccept> list = dao.checkMyWalkAccept(conn,id);
		close(conn);
		return list;
	}
	
	public int walkAcceptChange(String yesNo, String walkIdx,String memberId) {
		Connection conn=getConnection();
		int result=dao.walkAcceptChange(conn,yesNo,walkIdx,memberId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;	
	}
	
	public int enrollWalkMember(String walkIdx, String memberId) {
		Connection conn=getConnection();
		int result=dao.enrollWalkMember(conn,walkIdx,memberId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	

}
