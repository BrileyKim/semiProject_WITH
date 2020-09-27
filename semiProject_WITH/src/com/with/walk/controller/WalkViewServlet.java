package com.with.walk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.walk.model.service.WalkService;
import com.with.walk.model.vo.Walk;

/**
 * Servlet implementation class WalkViewServlet
 */
@WebServlet("/walk/walkView")
public class WalkViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalkViewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int walkIdx = Integer.parseInt(request.getParameter("walkIdx"));
		String meetIdx = request.getParameter("meetIdx");
		
/*		String date = "";
		
		if(month.length()<2) {
			if(day.length()<2) {
				date=year+"-0"+month+"-0"+day;
			}else {
				date=year+"-0"+month+"-"+day;
			}
		}else {
			if(day.length()<2) {
				date=year+"-"+month+"-0"+day;
			}else {
				date=year+"-"+month+"-"+day;
			}
		}*/
		
		Walk w = new WalkService().selectWalkTwo(walkIdx);
		int headCount = new WalkService().getWalkHeadCount(w);
		
		String view="";
		if(w==null) {
			request.setAttribute("msg", "조회된 산책이 없습니다.");
			request.setAttribute("loc", "/meet/meetView?meet_idx="+meetIdx);
			view="/views/common/msg.jsp";
		}else {
			request.setAttribute("walk",w);
			request.setAttribute("headCount", headCount);
			request.setAttribute("meetIdx", meetIdx);
			view="/views/walk/walkView.jsp";
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
