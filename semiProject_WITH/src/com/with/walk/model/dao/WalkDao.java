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
	
	public Walk selectWalkTwo(Connection conn, int walkIdx) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Walk w = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectWalkTwo"));
			pstmt.setInt(1, walkIdx);
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
	
	public List<Walk> selectWalkList(Connection conn,int page,String opt, String condition, int walkMeetIdx){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Walk> list = new ArrayList();
		try {
			if(opt==null) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkListAll"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+3);
			}else if(opt.equals("0")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkListTitle"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, page);
				pstmt.setInt(4, page+3);
			}else if(opt.equals("1")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkListContent"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, page);
				pstmt.setInt(4, page+3);
			}else if(opt.equals("2")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkListTitleorContent"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setString(3, "%"+condition+"%");
				pstmt.setInt(4, page);
				pstmt.setInt(5, page+3);
			}else if(opt.equals("3")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkListWriter"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, page);
				pstmt.setInt(4, page+4);
			}
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
	
	public int selectWalkCount(Connection conn,int page, String opt,String condition,int walkMeetIdx) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int count=0;
		try {
			if(opt==null) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkCount"));
				pstmt.setInt(1, walkMeetIdx);
			}else if(opt.equals("0")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkCountTitle"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setString(2, "%"+condition+"%");
			}else if(opt.equals("1")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkCountContent"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setString(2, "%"+condition+"%");
			}else if(opt.equals("2")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkCountTitleorContent"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setString(3, "%"+condition+"%");
			}else if(opt.equals("3")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectWalkCountWriter"));
				pstmt.setInt(1, walkMeetIdx);
				pstmt.setString(2, "%"+condition+"%");
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
	
	public int getWalkHeadCount(Connection conn,Walk w) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int headCount=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("getWalkHeadCount"));
			pstmt.setInt(1, w.getWalkNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				headCount=rs.getInt("COUNT(*)");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return headCount;
	}
	
	public int updateWalk(Connection conn, Walk w) {
		PreparedStatement pstmt = null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateWalk"));
			pstmt.setInt(1, w.getWalkHeadCount());
			pstmt.setString(2, w.getWalkDate());
			pstmt.setInt(3, w.getWalkHour());
			pstmt.setInt(4, w.getWalkMinute());
			pstmt.setString(5, w.getWalkContent());
			pstmt.setInt(6, w.getWalkNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
