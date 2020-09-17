package com.with.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.common.AESCrypto;
import com.with.member.model.service.MemberService;
import com.with.member.model.vo.Member;

/**
 * Servlet implementation class MemberJoinEndServlet
 */
@WebServlet(name="joinMember", urlPatterns="/joinMemberEnd")
public class MemberJoinEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = new Member();
		m.setId(request.getParameter("Id"));
		m.setPassword(request.getParameter("Password"));
		m.setNickname(request.getParameter("nickname"));
		m.setGender(request.getParameter("gender"));
		m.setBirth(request.getParameter("birth"));
		
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		try {
			m.setPhone(AESCrypto.encrypt(phone));
			m.setEmail(AESCrypto.encrypt(email));
		}catch(Exception e) {
			m.setPhone(phone);
			m.setEmail(email);
		}
		String si = request.getParameter("si");
		String gu = request.getParameter("gu");
		String dong = request.getParameter("dong");
		m.setAddress(si+","+gu+","+dong);
		System.out.println(m);
		
		int result = new MemberService().insertMember(m);
		
		String msg = "";
		String loc="";
		if(result>0) {
			msg="회원가입성공";
			loc="/";
		}else {
			msg="회원가입실패";
			loc="/joinMember";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
