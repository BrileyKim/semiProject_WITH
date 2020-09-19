package com.with.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.with.common.MyFileRename;
import com.with.member.model.service.MemberService;

/**
 * Servlet implementation class MemberChangeProfileEndServlet
 */
@WebServlet("/changeProfileEnd")
public class MemberChangeProfileEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberChangeProfileEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check the form type is multipart/formdata
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "프로필 변경오류[form:enctype]관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/")+"upload/member";
		int maxSize=1024*1024*10;
		String encode = "UTF-8";
		
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,encode,new MyFileRename());
		
		String file = mr.getFilesystemName("upProfile");
		String id = mr.getParameter("id");
		int result = new MemberService().profileUpdate(id,file);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
