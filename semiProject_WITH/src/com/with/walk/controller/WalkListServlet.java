package com.with.walk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.meet.model.service.MeetService;
import com.with.meet.model.vo.Meet;
import com.with.walk.model.service.WalkService;
import com.with.walk.model.vo.Walk;

/**
 * Servlet implementation class WalkListServlet
 */
@WebServlet("/walk/walkList")
public class WalkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalkListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int walkMeetIdx=Integer.parseInt(request.getParameter("meet_idx"));
		String id = request.getParameter("id");
		
		Meet m = new MeetService().selectMeetOne(walkMeetIdx);
		
		String meetGrade = new MeetService().getMyMeetGrade(id,m);
		
		//paging
		int spage=1;
		String page = request.getParameter("page");
		if(page!=null) spage =Integer.parseInt(page);

		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");

		List<Walk> list = new WalkService().selectWalkList(spage*4-3,opt,condition,walkMeetIdx);
		int listCount = new WalkService().selectWalkCount(spage*4-3,opt,condition,walkMeetIdx);
		
		int maxPage = (int)(listCount/4.0+0.9);
		int startPage = (int)(spage/4.0+0.8)*4-3;

		int endPage = startPage + 3;
		
		if(endPage>maxPage) endPage = maxPage;
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		

		
		request.setAttribute("walks", list);
		request.setAttribute("meetIdx", walkMeetIdx);
		request.setAttribute("meetGrade", meetGrade);
		RequestDispatcher rd = request.getRequestDispatcher("/views/walk/walkList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
