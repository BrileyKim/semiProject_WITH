package com.with.walk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.with.common.MyFileRename;
import com.with.meet.model.service.MeetService;
import com.with.walk.model.service.WalkService;
import com.with.walk.model.vo.Walk;
import com.with.walk.model.vo.WalkMember;

/**
 * Servlet implementation class WalkAddEndServlet
 */
@WebServlet("/walk/walkAddEnd")
public class WalkAddEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalkAddEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "산책 입력오류[form:enctype]관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/upload/walk");
		int maxSize=1024*1024*10;
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,"UTF-8",new MyFileRename());
		
		Walk w = new Walk();
		String meetIdx=mr.getParameter("walk_meet_idx");
		w.setWalkMeetIdx(Integer.parseInt(meetIdx));
		String writer = mr.getParameter("walk_writer");
		w.setWalkWriter(writer);
		String title = mr.getParameter("walk_title");
		w.setWalkTitle(title);
		w.setWalkHeadCount(Integer.parseInt(mr.getParameter("walk_headcount")));
		w.setWalkDate(mr.getParameter("walk_date"));
		w.setWalkHour(Integer.parseInt(mr.getParameter("walk_hour")));
		w.setWalkMinute(Integer.parseInt(mr.getParameter("walk_minute")));
		w.setWalkContent(mr.getParameter("walk_content"));
	
		int result = new WalkService().addWalk(w);
		
		String msg="";
		String loc="/meet/meetView?meet_idx="+meetIdx;
		if(result>0) {
			
			Walk w2 = new WalkService().selectWalkOne(writer,title);
			
			WalkMember wm = new WalkMember();
			wm.setWalkNo(w2.getWalkNo());
			wm.setWalkId(w2.getWalkWriter());
			new WalkService().enrollWalkAdmin(wm);
			msg="산책 개설 성공";
		}else {
			msg="산책 개설 실패, 관리자에게 문의하세요.";
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
