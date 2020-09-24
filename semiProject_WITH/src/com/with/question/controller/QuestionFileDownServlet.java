package com.with.question.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionFileDownServlet
 */
@WebServlet("/question/questionFileDown")
public class QuestionFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=getServletContext().getRealPath("/upload/question");
		String oName=request.getParameter("oName");
		String rName=request.getParameter("rName");

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path+"/"+rName));

		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		//한글 인코딩 처리
		String header = request.getHeader("user-agent");
		boolean isMS=header.indexOf("MSIE")!=-1||header.indexOf("Trident")!=-1;
		
		String reName="";
		if(isMS) {
			reName=URLEncoder.encode(oName,"UTF-8").replaceAll("//+","%20");
			
		}else {
			reName=new String(oName.getBytes("UTF-8"),"ISO-8859-1");
			
		}
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename="+reName);
		int read=-1;
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		bos.close();
		bis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
