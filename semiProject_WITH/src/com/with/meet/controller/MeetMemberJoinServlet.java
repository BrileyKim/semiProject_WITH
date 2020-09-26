package com.with.meet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.meet.model.service.MeetService;
import com.with.meet.model.vo.Accept;
import com.with.meet.model.vo.Meet;

/**
 * Servlet implementation class MeetMemberJoinServlet
 */
@WebServlet("/meet/joinMember")
public class MeetMemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetMemberJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		
		Meet m = new MeetService().getMyMeet(title);
				
		int headCount = new MeetService().getMyHeadCount(m);

		String msg="";
		String loc="/";
		
		// 가입신청 한사람인지 체크
		Accept check = new MeetService().checkAccept(m,id);
		//현재인원이 가입하려는 모임의 인원수보다 크거나 같으면 false
		if(check==null&&m.getHeadCount()>headCount) {
			//가입신청 수락
			//가입신청 로직
			int result=new MeetService().enrollAccept(m,id);
			if(result>0) {
				//가입신청 넘김 성공
				msg=m.getTitle()+"에 가입신청 하셨습니다.";
				loc="/meet/meetList";
			}else {
				//가입신청 넘김 실패
				msg="오류로 인해 가입실패하였습니다. 관리자에게 문의하세요.";
				loc="/";
			}
		}else {
			//가입신청 거절(인원제한)
			msg="인원제한이 포화되었거나 가입신청을 한 상태입니다. 모임장에게 문의하세요.";
			loc="/meet/meetList";
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
