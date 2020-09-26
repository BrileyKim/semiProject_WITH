package com.with.walk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		List<Walk> list = new WalkService().selectWalkList(walkMeetIdx);
		
		request.setAttribute("walks", list);
		request.setAttribute("meetIdx", walkMeetIdx);
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
