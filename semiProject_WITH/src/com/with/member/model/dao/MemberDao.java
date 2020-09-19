package com.with.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.with.member.model.vo.Member;
import static com.with.common.JDBCTemplate.close;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member checkIdDuplicate(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("checkIdDuplicate"));
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setNickname(rs.getString("nickname"));
				m.setGrade(rs.getString("grade"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getString("birth"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setProfile(rs.getString("profile"));
				m.setEnrolldate(rs.getDate("enrolldate"));		
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public Member checkNickname(Connection conn, String nickname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("checkNickname"));
			pstmt.setNString(1, nickname);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setNickname(rs.getString("nickname"));
				m.setGrade(rs.getString("grade"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getString("birth"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setProfile(rs.getString("profile"));
				m.setEnrolldate(rs.getDate("enrolldate"));	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("joinMember"));
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getNickname());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getBirth());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getEmail());
			pstmt.setString(8, m.getAddress());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Member loginMember(Connection conn, String id, String password) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectMemberone"));
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setNickname(rs.getString("nickname"));
				m.setGrade(rs.getString("grade"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getString("birth"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setAddress(rs.getString("profile"));
				m.setEnrolldate(rs.getDate("enrolldate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public int profileUpdate(Connection conn, String id, String file) {
		PreparedStatement pstmt = null;
		int result =0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updateProfile"));
			pstmt.setString(1, file);
			pstmt.setString(2, id);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
