package com.with.walk.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.with.common.JDBCTemplate.close;
import com.with.walk.model.vo.Walk;

public class WalkDao {
	
	private Properties prop = new Properties();
	
	public WalkDao() {
		try {
			String path = WalkDao.class.getResource("/sql/walk/walk_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Walk> selectWalkList(Connection conn, int walkMeetIdx){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Walk> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectWalkList"));
			pstmt.setInt(1, walkMeetIdx);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Walk w = new Walk();
				w.setWalkNo(rs.getInt("walk_no"));
				w.setWalkMeetIdx(rs.getInt("walk_meet_idx"));
				w.setWalkWriter(rs.getString("walk_writer"));
				w.setWalkTitle(rs.getString("walk_title"));
				w.setWalkHeadCount(rs.getInt("walk_headcount"));
				w.setWalkDate(rs.getString("walk_date"));
				w.setWalkHour(rs.getInt("walk_hour"));
				w.setWalkMinute(rs.getInt("walk_minute"));
				w.setWalkContent(rs.getString("walk_content"));
				w.setWalkReadcount(rs.getInt("walk_readcount"));
				w.setWalkEnrolldate(rs.getDate("walk_enrolldate"));
				list.add(w);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;	
	}

}
