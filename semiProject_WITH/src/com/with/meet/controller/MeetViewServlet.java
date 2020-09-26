package com.with.meet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.meet.model.service.MeetService;
import com.with.meet.model.vo.Meet;

/**
 * Servlet implementation class MeetViewServlet
 */
@WebServlet("/meet/meetView")
public class MeetViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int no = Integer.parseInt(request.getParameter("meet_idx"));
		
		Meet m = new MeetService().selectMeetOne(no);
		
		String grade = new MeetService().getMyMeetGrade(id,m);
		
		int headCount = new MeetService().getMyHeadCount(m);
		
		
		String view="";
		if(m==null) {
			request.setAttribute("msg", "조회된 공지사항이 없습니다.");
			request.setAttribute("loc", "/meet/meetList");
			view="/views/common/msg.jsp";
		}else {
			request.setAttribute("meet",m);
			request.setAttribute("headCount", headCount);
			request.setAttribute("grade", grade);
			view="/views/meet/meetView.jsp";
		}
		request.getRequestDispatcher(view).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
