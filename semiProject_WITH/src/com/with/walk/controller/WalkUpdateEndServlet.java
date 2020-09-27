package com.with.walk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.with.common.MyFileRename;
import com.with.walk.model.service.WalkService;
import com.with.walk.model.vo.Walk;

/**
 * Servlet implementation class WalkUpdateEndServlet
 */
@WebServlet("/walk/walkUpdateEnd")
public class WalkUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalkUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=getServletContext().getRealPath("/upload/walk");
		int maxSize=1024*1024*10;
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new MyFileRename());
		Walk w = new Walk();
		
		int walkMeetIdx = Integer.parseInt(mr.getParameter("walk_meet_idx"));
		int walkIdx = Integer.parseInt(mr.getParameter("walk_no"));
		int walkHeadcount=Integer.parseInt(mr.getParameter("walk_headcount"));
		String walkDate = mr.getParameter("walk_date");
		int walkHour = Integer.parseInt(mr.getParameter("walk_hour"));
		int walkMinute = Integer.parseInt(mr.getParameter("walk_minute"));
		String walkContent = mr.getParameter("walk_content");
		
		w.setWalkNo(walkIdx);
		w.setWalkHeadCount(walkHeadcount);
		w.setWalkDate(walkDate);
		w.setWalkHour(walkHour);
		w.setWalkMinute(walkMinute);
		w.setWalkContent(walkContent);
		
		int result = new WalkService().updateWalk(w);
		String msg="";
		String loc="/meet/meetView?meet_idx="+walkMeetIdx ;
		if(result>0) {
			msg="산책 수정 성공";
		}else {
			msg="산책 수정 실패, 관리자에게 문의하세요.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);;
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
