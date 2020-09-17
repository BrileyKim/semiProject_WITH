package com.with.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.with.member.model.vo.Member;

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
				m.setGrade(rs.getString("gender"));
				m.setBirth(rs.getString("birth"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setEnrolldate(rs.getDate("enrolldate"));		
			}
		}catch(SQLException e) {
			e.printStackTrace();
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
				m.setGrade(rs.getString("gender"));
				m.setBirth(rs.getString("birth"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setEnrolldate(rs.getDate("enrolldate"));	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

}
