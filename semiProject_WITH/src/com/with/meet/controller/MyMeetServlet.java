package com.with.meet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.meet.model.service.MeetService;
import com.with.meet.model.vo.Meet;

/**
 * Servlet implementation class MyMeetServlet
 */
@WebServlet("/myMeet")
public class MyMeetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMeetServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			List<Meet> list = new MeetService().selectMyMeetList(id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/meet/myMeet.jsp").forward(request, response);

		}catch(NullPointerException e) {
			e.printStackTrace();
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
