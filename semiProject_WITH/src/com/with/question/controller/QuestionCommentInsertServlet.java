package com.with.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.question.model.service.QuestionService;
import com.with.question.model.vo.QuestionComment;

/**
 * Servlet implementation class QuestionCommentInsertServlet
 */
@WebServlet("/question/questionCommentInsert")
public class QuestionCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionCommentInsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qaRef=Integer.parseInt(request.getParameter("qaRef"));
		String qaCommentWriter=request.getParameter("qaCommentWriter");
		int qaCommentLevel = Integer.parseInt(request.getParameter("qaCommentLevel"));
		int qaCommentRef = Integer.parseInt(request.getParameter("qaCommentRef"));
		String qaCommentContent=request.getParameter("qaCommentContent");
		
		QuestionComment qc=new QuestionComment(0,qaCommentLevel,qaCommentWriter,qaCommentContent,qaRef,qaCommentRef,null);

		
		int result=new QuestionService().insertQuestionComment(qc);
		String msg="";
		String loc="/question/questionView?question_idx="+qaRef;
		if(result>0) {
			msg="댓글 등록 성공";
		}else {
			msg="댓글 등록 실패";
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
