package com.with.walk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.walk.model.service.WalkService;

/**
 * Servlet implementation class WalkMemberJoinEndServlet
 */
@WebServlet("/walk/memberJoinEnd")
public class WalkMemberJoinEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalkMemberJoinEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yesNo=request.getParameter("accept_check");
		String walkIdx = request.getParameter("accept_walk_idx");
		String memberId=request.getParameter("accept_member_id");
		
		int result = new WalkService().walkAcceptChange(yesNo,walkIdx,memberId);
	
		String msg="";
		String loc="";
		if(result>0) {
			int result2 = new WalkService().enrollWalkMember(walkIdx,memberId);
			if(result2>0) {
				msg="산책 수락/거절에 성공했습니다.";
				loc="/myPage";
			}else {
				msg="산책 수락/거절에 실패했습니다.";
			}
		}else {
			msg="산책 수락/거절에 실패했습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
