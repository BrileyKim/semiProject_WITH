package com.with.notice.model.service;

import static com.with.common.JDBCTemplate.close;
import static com.with.common.JDBCTemplate.getConnection;

import java.sql.Connection;
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

}
