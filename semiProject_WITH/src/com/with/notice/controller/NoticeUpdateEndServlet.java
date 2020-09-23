package com.with.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.with.common.MyFileRename;
import com.with.notice.model.service.NoticeService;
import com.with.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet("/notice/noticeUpdateEnd")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=getServletContext().getRealPath("/upload/notice");
		
		int maxSize=1024*1024*10;
		
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new MyFileRename());

		Notice n=new Notice();
		n.setNoticeIdx(Integer.parseInt(mr.getParameter("noticeIdx")));
		n.setNoticeTitle(mr.getParameter("notice_title"));
		n.setNoticeWriter(mr.getParameter("notice_writer"));
		n.setNoticeContent(mr.getParameter("notice_content"));
		System.out.println(mr.getOriginalFileName("fileview"));
		n.setNoticeOriginalFileName(mr.getOriginalFileName("fileview"));
		n.setNoticeRenamedFileName(mr.getFilesystemName("fileview"));
		
		int result=new NoticeService().updateNotice(n);
		String msg="";
		String loc="/notice/noticeList";
		if(result>0) {
			msg="게시글 수정 성공";
		}else {
			msg="게시글 수정 실패";	
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
