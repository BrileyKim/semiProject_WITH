package com.with.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.with.member.model.service.MemberService;
import com.with.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet(name="login", urlPatterns="/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Bring data that client send from "sidebar.jsp"
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		// Deal login logic
		// check the existence of the data that client sent
		// Use JDBC
		Member m = new MemberService().loginMember(id,password);
		if(m!=null) {
			// Successfully loggined
			// Store loggined Member to data storing request object
			HttpSession session = request.getSession();
			session.setAttribute("logginedMember", m);
			//Stay the page tha tyou login
			response.sendRedirect(request.getHeader("Referer"));
		}else {
			request.setAttribute("msg", "아이디 혹은 비밀번호가 일치하지 않습니다.");
			request.setAttribute("loc","/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
