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
	
	public List<Walk> selectWalkList(int walkMeetIdx){
		Connection conn = getConnection();
		List<Walk> list = dao.selectWalkList(conn,walkMeetIdx);
		close(conn);
		return list;
	}
	
	public Walk selectWalkOne(String writer, String title) {
		Connection conn = getConnection();
		Walk w = dao.selectWalkOne(conn,writer,title);
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
}
