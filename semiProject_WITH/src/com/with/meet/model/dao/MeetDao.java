package com.with.meet.model.dao;

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

import com.with.meet.model.vo.Accept;
import com.with.meet.model.vo.Meet;
import com.with.meet.model.vo.MeetMember;
import com.with.member.model.vo.Member;

public class MeetDao {
	
	private Properties prop = new Properties();
	
	public MeetDao() {
		try {
			String path = MeetDao.class.getResource("/sql/meet/meet_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Meet> selectMeetList(Connection conn,int page,String opt,String condition){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Meet> list = new ArrayList();
		try {
			if(opt==null) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetListAll"));
				pstmt.setInt(1, page);
				pstmt.setInt(2, page+9);
			}else if(opt.equals("0")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetListTitle"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+9);
			}else if(opt.equals("1")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetListContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+9);
			}else if(opt.equals("2")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetListTitleorContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, page);
				pstmt.setInt(4, page+9);
			}else if(opt.equals("3")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetListWriter"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+9);
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Meet m =new Meet();
				m.setIdx(rs.getInt("meet_idx"));
				m.setTitle(rs.getString("meet_title"));
				m.setLeader(rs.getString("meet_leader"));
				m.setHeadCount(rs.getInt("meet_headcount"));
				m.setContent(rs.getString("meet_content"));
				m.setFrontOrigin(rs.getString("meet_frontorigin"));
				m.setFrontRename(rs.getString("meet_frontrename"));
				m.setBackOrigin(rs.getString("meet_backorigin"));
				m.setBackRename(rs.getString("meet_backrename"));
				m.setCreateDate(rs.getDate("meet_createdate"));
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int selectMeetCount(Connection conn, int page, String opt, String condition) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int count=0;
		try {
			if(opt==null) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetCount"));	
			}else if(opt.equals("0")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetCountTitle"));
				pstmt.setString(1, "%"+condition+"%");
			}else if(opt.equals("1")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetCountContent"));
				pstmt.setString(1, "%"+condition+"%");
			}else if(opt.equals("2")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetCountTitleorContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
			}else if(opt.equals("3")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectMeetCountWriter"));
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
	
	public List<Meet> selectMyMeetList(Connection conn, String id){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Meet> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMyMeetList"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Meet m = new Meet();
				m.setIdx(rs.getInt("meet_idx"));
				m.setTitle(rs.getString("meet_title"));
				m.setLeader(rs.getString("meet_leader"));
				m.setHeadCount(rs.getInt("meet_headcount"));
				m.setContent(rs.getString("meet_content"));
				m.setFrontOrigin(rs.getString("meet_frontorigin"));
				m.setFrontRename(rs.getString("meet_frontrename"));
				m.setBackOrigin(rs.getString("meet_backorigin"));
				m.setBackRename(rs.getString("meet_backrename"));
				m.setCreateDate(rs.getDate("meet_createdate"));
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int enrollMeet(Connection conn, Meet m) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("enrollMeet"));
			pstmt.setString(1, m.getTitle());
			pstmt.setString(2, m.getLeader());
			pstmt.setInt(3, m.getHeadCount());
			pstmt.setString(4, m.getContent());
			pstmt.setString(5, m.getFrontOrigin());
			pstmt.setString(6, m.getFrontRename());
			pstmt.setString(7, m.getBackOrigin());
			pstmt.setString(8, m.getBackRename());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int enrollMeetAdmin(Connection conn, MeetMember mm) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("enrollMeetAdmin"));
			pstmt.setString(1, mm.getMeetMembertitle());
			pstmt.setString(2, mm.getMeetMemberId());
			pstmt.setString(3, "모임장");
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Meet selectMeetOne(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Meet m = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMeetOne"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Meet();
				m.setIdx(rs.getInt("meet_idx"));
				m.setTitle(rs.getString("meet_title"));
				m.setLeader(rs.getString("meet_leader"));
				m.setHeadCount(rs.getInt("meet_headcount"));
				m.setContent(rs.getString("meet_content"));
				m.setFrontOrigin(rs.getString("meet_frontorigin"));
				m.setFrontRename(rs.getString("meet_frontrename"));
				m.setBackOrigin(rs.getString("meet_backorigin"));
				m.setBackRename(rs.getString("meet_backrename"));
				m.setCreateDate(rs.getDate("meet_createdate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public String getMyMeetGrade(Connection conn,String id,Meet m) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String grade=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("getMyMeetGrade"));
			pstmt.setString(1,m.getTitle());
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				grade=rs.getString("MEET_GRADE");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return grade;
	}
	
	public int getMyHeadCount(Connection conn,Meet m) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int headCount=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("getMyHeadCount"));
			pstmt.setString(1, m.getTitle());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				headCount=rs.getInt("COUNT(*)");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		return headCount;
	}
	
	public Meet getMyMeet(Connection conn,String title) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Meet m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("getMyMeet"));
			pstmt.setString(1, title);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Meet();
				m.setIdx(rs.getInt("MEET_IDX"));
				m.setTitle(rs.getString("MEET_TITLE"));
				m.setLeader(rs.getString("MEET_LEADER"));
				m.setHeadCount(rs.getInt("MEET_HEADCOUNT"));
				m.setContent(rs.getString("MEET_CONTENT"));
				m.setFrontOrigin(rs.getString("MEET_FRONTORIGIN"));
				m.setFrontRename(rs.getString("MEET_FRONTRENAME"));
				m.setBackOrigin(rs.getString("MEET_BACKORIGIN"));
				m.setBackRename(rs.getString("MEET_BACKRENAME"));
				m.setCreateDate(rs.getDate("MEET_CREATEDATE"));
				/* m.setDogSize(rs.getString("MEET_DOGSIZE")); */
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public Accept checkAccept(Connection conn,Meet m,String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Accept check=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("checkAccept"));
			pstmt.setString(1, m.getTitle());
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				check=new Accept();
				check.setNo(rs.getInt("ACCPET_NO"));
				check.setTitle(rs.getString("ACCEPT_TITLE"));
				check.setUserName(rs.getString("ACCEPT_USERNAME"));
				check.setCheck(rs.getString("ACCEPT_CHECK"));
				check.setYn(rs.getString("ACCEPT_YN"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return check;
	}
	
	
	public int enrollAccept(Connection conn,Meet m,String id) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("enrollAccept"));
			pstmt.setString(1, m.getTitle());
			pstmt.setString(2, id);
			pstmt.setString(3, "미처리");
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	

}
