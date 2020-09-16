package com.with.member.model.service;

import java.sql.Connection;
import static com.with.common.JDBCTemplate.getConnection;
import static com.with.common.JDBCTemplate.close;
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
}
