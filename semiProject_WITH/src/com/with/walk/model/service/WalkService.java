package com.with.walk.model.service;

import static com.with.common.JDBCTemplate.close;
import static com.with.common.JDBCTemplate.commit;
import static com.with.common.JDBCTemplate.getConnection;
import static com.with.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.with.walk.model.dao.WalkDao;
import com.with.walk.model.vo.Walk;
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
	

}
