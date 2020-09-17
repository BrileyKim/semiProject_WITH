package com.with.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.member.model.service.MemberService;
import com.with.member.model.vo.Member;

/**
 * Servlet implementation class CheckNicknameServlet
 */
@WebServlet("/checkNickname")
public class CheckNicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNicknameServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get nickname that client send from joinMember.jsp 
		String nickname = request.getParameter("nickname");
		Member m = new MemberService().checkNickname(nickname);
		request.setAttribute("result", m);
		request.setAttribute("sendedNickname", nickname);
		request.getRequestDispatcher("/views/member/checkNickname.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
