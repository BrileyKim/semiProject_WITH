package com.with.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.notice.model.service.NoticeService;
import com.with.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/notice/noticeView")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("noticeIdx"));
		
		Notice n=new NoticeService().selectNoticeOne(no);
		String view="";
		if(n==null) {
			request.setAttribute("msg", "조회된 공지사항이 없습니다.");
			request.setAttribute("loc", "/notice/noticeList");
			view="/views/common/msg.jsp";
		}else {
			request.setAttribute("notice",n);
			view="/views/notice/noticeView.jsp";
		}
		request.getRequestDispatcher(view).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
