package com.with.member.model.service;

import static com.with.common.JDBCTemplate.close;
import static com.with.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.with.member.model.dao.MemberDao;
import com.with.member.model.vo.Member;

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
}
