package com.with.meet.controller;

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
import com.with.meet.model.vo.Meet;
import com.with.meet.model.vo.MeetMember;

/**
 * Servlet implementation class MeetEnrollEndServlet
 */
@WebServlet("/meet/meetEnrollEnd")
public class MeetEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetEnrollEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "모임등록 실패 [enctype] 관리자에게 문의하세요!");
			request.setAttribute("loc","/meet");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		String path=getServletContext().getRealPath("/upload/meet");

		int maxSize=1024*1024*10;

		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new MyFileRename());

		Meet m=new Meet();
		m.setTitle(mr.getParameter("title"));
		m.setLeader(mr.getParameter("leader"));
		m.setHeadCount(Integer.parseInt(mr.getParameter("headCount")));
		m.setContent(mr.getParameter("content"));
		m.setFrontOrigin(mr.getOriginalFileName("upFront"));
		m.setFrontRename(mr.getFilesystemName("upFront"));
		m.setBackOrigin(mr.getOriginalFileName("upBack"));
		m.setBackRename(mr.getFilesystemName("upBack"));
		
		int result=new MeetService().enrollMeet(m);
		
		String msg="";
		String loc="/meet/meetList";
		if(result>0) {
			MeetMember mm=new MeetMember();
			mm.setMeetMembertitle(mr.getParameter("title"));
			mm.setMeetMemberId(mr.getParameter("leader"));
			new MeetService().enrollMeetAdmin(mm);
			msg="모임 개설 성공";
		}else {
			msg="모임 개설 실패 관리자에게 문의하세요";
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
