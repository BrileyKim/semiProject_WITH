package com.with.walk.model.service;

import static com.with.common.JDBCTemplate.getConnection;
import static com.with.common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.List;

import com.with.walk.model.dao.WalkDao;
import com.with.walk.model.vo.Walk;

public class WalkService {
	private WalkDao dao = new WalkDao();
	
	public List<Walk> selectWalkList(int walkMeetIdx){
		Connection conn = getConnection();
		List<Walk> list = dao.selectWalkList(conn,walkMeetIdx);
		close(conn);
		return list;
	}
}
