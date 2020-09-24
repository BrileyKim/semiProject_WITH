package com.with.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.question.model.service.QuestionService;

/**
 * Servlet implementation class QuestionCommentDeleteServlet
 */
@WebServlet("/question/questionCommentDelete")
public class QuestionCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionCommentDeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qaNum=Integer.parseInt(request.getParameter("qaNo"));
		int qcCommentRef=Integer.parseInt(request.getParameter("qcCommentRef"));
		int qcNo=Integer.parseInt(request.getParameter("qcNo"));
		int qcLev= Integer.parseInt(request.getParameter("qcLev"));
		
		int result = new QuestionService().deleteQuestionComment(qcCommentRef, qcNo,qcLev);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="성공적으로 삭제되었습니다.";
			loc="/question/questionView?question_idx="+qaNum+"";
		}else {
			msg="삭제에 실패했습니다.";
			loc="/question/questionView?question_idx="+qaNum+"";
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
