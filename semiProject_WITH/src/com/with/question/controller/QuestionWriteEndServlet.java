package com.with.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.with.common.MyFileRename;
import com.with.question.model.service.QuestionService;
import com.with.question.model.vo.Question;

/**
 * Servlet implementation class QuestionWriteEndServlet
 */
@WebServlet("/question/questionWriteEnd")
public class QuestionWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionWriteEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "Q & A 입력오류[form:enctype]관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/upload/question");
		int maxSize=1024*1024*10;
		
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,"UTF-8",new MyFileRename());
		
		Question q=new Question();
		q.setQuestionTitle(mr.getParameter("title"));
		q.setQuestionWriter(mr.getParameter("writer"));
		q.setQuestionContent(mr.getParameter("content"));
		q.setQuestionOriginalFilename(mr.getOriginalFileName("upfile"));
		q.setQuestionRenamedFilename(mr.getFilesystemName("upfile"));
		
		
		int result=new QuestionService().insertQuestion(q);
		String msg="";
		String loc="";
		if(result>0) {
			msg="질문 등록 성공!";
			loc="/question/questionList";
		}else {
			msg="질문 등록 실패!";
			loc="/question/questionList";
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
