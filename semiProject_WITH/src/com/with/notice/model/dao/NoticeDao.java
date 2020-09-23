package com.with.notice.model.dao;

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

import com.with.notice.model.vo.Notice;

public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
		try {
			String path = NoticeDao.class.getResource("/sql/notice/notice_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Notice> selectNoticeList(Connection conn,int page, String opt, String condition){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Notice> list = new ArrayList();
		try {
			if(opt==null) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeListAll"));
				pstmt.setInt(1, page);
				pstmt.setInt(2, page+4);
			}else if(opt.equals("0")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeListTitle"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+4);
			}else if(opt.equals("1")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeListContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+4);
			}else if(opt.equals("2")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeListTitleorContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, page);
				pstmt.setInt(4, page+4);
			}else if(opt.equals("3")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeListWriter"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, page+4);
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Notice n=new Notice();
				n.setNoticeIdx(rs.getInt("notice_idx"));
				n.setNoticeTitle(rs.getString("notice_title"));
				n.setNoticeWriter(rs.getString("notice_writer"));
				n.setNoticeContent(rs.getString("notice_content"));
				n.setNoticeOriginalFileName(rs.getString("notice_originalfilepath"));;
				n.setNoticeRenamedFileName(rs.getString("notice_renamedfilepath"));
				n.setNoticeEnrollDate(rs.getDate("notice_enrolldate"));
				list.add(n);	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int selectNoticeCount(Connection conn,int page,String opt, String condition) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int count=0;
		try {
			if(opt==null) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeCount"));	
			}else if(opt.equals("0")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeCountTitle"));
				pstmt.setString(1, "%"+condition+"%");
			}else if(opt.equals("1")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeCountContent"));
				pstmt.setString(1, "%"+condition+"%");
			}else if(opt.equals("2")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeCountTitleorContent"));
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
			}else if(opt.equals("3")) {
				pstmt=conn.prepareStatement(prop.getProperty("selectNoticeCountWriter"));
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
	
	

}
