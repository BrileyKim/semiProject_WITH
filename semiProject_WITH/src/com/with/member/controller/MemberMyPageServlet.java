package com.with.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.dog.model.service.DogService;
import com.with.dog.model.vo.Dog;
import com.with.walk.model.service.WalkService;
import com.with.walk.model.vo.Walk;
import com.with.walk.model.vo.WalkAccept;

/**
 * Servlet implementation class MemberMyPageServlet
 */
@WebServlet("/myPage")
public class MemberMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMyPageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Take data(id) that client sent from sidebar.jsp
		// send Member data has id as ID
		
		String id=request.getParameter("id");
		
		Dog d = new DogService().selectDogOne(id);
		
		List<Walk> list = new WalkService().selectMyWalk(id);
		if(!list.isEmpty()) {
			List<WalkAccept> list2 = new WalkService().checkMyWalkAccept(id);
			request.setAttribute("walkAccepts", list2);
		}
			
	
		
		
			
		
		
		request.setAttribute("walk1", list);
		
		
		
		request.setAttribute("dog", d);			
		
		
		request.getRequestDispatcher("/views/member/myPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
