package com.with.member.model.service;

import static com.with.common.JDBCTemplate.close;
import static com.with.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;

import com.with.member.model.dao.MemberDao;
import com.with.member.model.vo.Member;
import static com.with.common.JDBCTemplate.commit;
import static com.with.common.JDBCTemplate.rollback;

public class MemberService {
	private MemberDao dao=new MemberDao();
	
	public Member checkIdDuplicate(String id) {
		Connection conn = getConnection();
		Member m = dao.checkIdDuplicate(conn,id);
		close(conn);
		return m;
	}
	
	public Member checkNickname(String nickname) {
		Connection conn = getConnection();
		Member m = dao.checkNickname(conn,nickname);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = dao.insertMember(conn, m);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	public Member loginMember(String id, String password) {
		Connection conn = getConnection();
		Member m = dao.loginMember(conn,id,password);
		try {
			if(conn!=null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
}
