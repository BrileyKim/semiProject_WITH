package com.with.notice.model.service;

import static com.with.common.JDBCTemplate.close;
import static com.with.common.JDBCTemplate.commit;
import static com.with.common.JDBCTemplate.getConnection;
import static com.with.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.with.notice.model.dao.NoticeDao;
import com.with.notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDao dao = new NoticeDao();
	
	public List<Notice> selectNoticeList(int page, String opt, String condition){
		Connection conn = getConnection();
		List<Notice> list = dao.selectNoticeList(conn,page,opt,condition);
		close(conn);
		return list;
	}
	
	public int selectNoticeCount(int page,String opt,String condition) {
		Connection conn = getConnection();
		int count = dao.selectNoticeCount(conn,page,opt,condition);
		close(conn);
		return count;
	}
	
	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = dao.insertNotice(conn, n);
		if(result>0)  commit(conn); 
		else  rollback(conn); 
 		close(conn);
		return result;
	}
	
	public Notice selectNoticeOne(int noticeIdx) {
		Connection conn = getConnection();
		Notice n = dao.selectNoticeOne(conn,noticeIdx);
		close(conn);
		return n;
	}
	
	public int updateNotice(Notice n,String hidden) {
		Connection conn=getConnection();
		int result=dao.updateNotice(conn,n,hidden);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteNotice(int noticeIdx) {
		Connection conn=getConnection();
		int result=dao.deleteNotice(conn,noticeIdx);
		if(result>0) { commit(conn); }
		else { rollback(conn); }
		close(conn);
		return result;
	}
	


}
