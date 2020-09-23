package com.with.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.with.common.MyFileRename;
import com.with.notice.model.service.NoticeService;
import com.with.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteEndServlet
 */
@WebServlet("/notice/noticeWriteEnd")
public class NoticeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항 입력오류[form:enctype]관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path=getServletContext().getRealPath("/upload/notice");

		int maxSize=1024*1024*10;

		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new MyFileRename());

		Notice n=new Notice();
		n.setNoticeTitle(mr.getParameter("notice_title"));
		n.setNoticeWriter(mr.getParameter("notice_writer"));
		n.setNoticeContent(mr.getParameter("notice_content"));
		n.setNoticeOriginalFileName(mr.getOriginalFileName("notice_filepath"));
		n.setNoticeRenamedFileName(mr.getFilesystemName("notice_filepath"));
		
		int result=new NoticeService().insertNotice(n);
		
		String msg="";
		String loc="/notice/noticeList";
		if(result>0) {
			msg="게시글 등록 성공";
		}else {
			msg="게시글 등록 실패";	
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
