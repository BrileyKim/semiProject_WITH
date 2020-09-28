package com.with.walk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.meet.model.service.MeetService;
import com.with.walk.model.service.WalkService;
import com.with.walk.model.vo.Walk;
import com.with.walk.model.vo.WalkAccept;

/**
 * Servlet implementation class WalkMemberJoinServlet
 */
@WebServlet("/walk/memberJoin")
public class WalkMemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalkMemberJoinServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int walkIdx = Integer.parseInt(request.getParameter("walk_idx"));
		
		Walk w = new WalkService().selectWalkTwo(walkIdx);
		int headCount = new WalkService().getWalkHeadCount(w);
		String msg = "";
		String loc = "/";
		
		WalkAccept check = new WalkService().checkWalkAccept(w,id);
		if(check==null&&w.getWalkHeadCount()>headCount) {
			int result = new WalkService().enrollAccept(w,id);
			if(result>0) {
				msg=w.getWalkTitle()+"에 가입신청 완료되셨습니다.";
				loc="/walk/walkList?meet_idx="+w.getWalkMeetIdx()+"&id="+id;
			}else {
				msg="오류로 인해 참여신청에 실패하였습니다. 관리자에게 문의하세요.";
				loc="/";
			}
		}else {
			msg="인원이 포화되었거나 가입신청을 한 상태입니다. 산책 대표에게 문의하세요.";
			loc="/walk/walkList?meet_idx="+w.getWalkMeetIdx()+"&id="+id;

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
