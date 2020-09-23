package com.with.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.notice.model.service.NoticeService;
import com.with.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/noticeList")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//current page number
		int spage=1;
		String page = request.getParameter("page");
		if(page!=null) spage =Integer.parseInt(page);
		
		//Bring search condition and search contents
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		
		List<Notice> list = new NoticeService().selectNoticeList(spage*3-2,opt,condition);
		int listCount = new NoticeService().selectNoticeCount(spage*3-2,opt,condition);
		
		//the number of total Page
		int maxPage = (int)(listCount/3.0+0.9);
		//start page number
		int startPage = (int)(spage/3.0+0.8)*3-2;
		//last page number
		int endPage = startPage + 2;
		if(endPage>maxPage) endPage = maxPage;
		
		//store 4 number of page
		request.setAttribute("spage", spage);
		request.setAttribute("masPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		request.setAttribute("notices", list);
		RequestDispatcher rd = request.getRequestDispatcher("/views/notice/noticeList.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
