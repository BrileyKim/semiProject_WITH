package com.with.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.with.common.MyFileRename;
import com.with.question.model.service.QuestionService;
import com.with.question.model.vo.Question;

/**
 * Servlet implementation class QuestionUpdateEndServlet
 */
@WebServlet("/question/questionUpdateEnd")
public class QuestionUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionUpdateEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=getServletContext().getRealPath("/upload/question");
		int maxSize=1024*1024*10;
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,"UTF-8",new MyFileRename());
		Question q = new Question();
		q.setQuestionIdx(Integer.parseInt(mr.getParameter("no")));
		q.setQuestionTitle(mr.getParameter("title"));
		q.setQuestionOriginalFilename(mr.getOriginalFileName("upfile"));
		q.setQuestionWriter(mr.getParameter("writer"));
		q.setQuestionRenamedFilename(mr.getFilesystemName("upfile"));
		q.setQuestionContent(mr.getParameter("content"));
		
		String hidden = mr.getParameter("filehidden");

		int result = new QuestionService().questionUpdate(q,hidden);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="성공적으로 수정되었습니다";
			loc="/question/questionList";
		}else {
			msg="수정에 실패하였습니다";
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
