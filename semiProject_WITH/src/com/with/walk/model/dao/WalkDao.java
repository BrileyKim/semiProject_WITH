package com.with.walk.model.dao;

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

import com.with.walk.model.vo.Walk;
import com.with.walk.model.vo.WalkMember;

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
	
	public Walk selectWalkOne(Connection conn, String writer, String title) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Walk w = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectWalkOne"));
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				w = new Walk();
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
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return w;
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
	public int addWalk(Connection conn, Walk w) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("addWalk"));
			pstmt.setInt(1, w.getWalkMeetIdx());
			pstmt.setString(2, w.getWalkWriter());
			pstmt.setString(3, w.getWalkTitle());
			pstmt.setInt(4, w.getWalkHeadCount());
			pstmt.setString(5, w.getWalkDate());
			pstmt.setInt(6, w.getWalkHour());
			pstmt.setInt(7, w.getWalkMinute());
			pstmt.setString(8, w.getWalkContent());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int enrollMeetAdmin(Connection conn, WalkMember wm) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("enrollWalkAdmin"));
			pstmt.setInt(1, wm.getWalkNo());
			pstmt.setString(2, wm.getWalkId());
			pstmt.setString(3, "대표");
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
