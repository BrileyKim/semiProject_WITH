package com.with.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.question.model.service.QuestionService;

/**
 * Servlet implementation class QuestionRemoveServlet
 */
@WebServlet("/question/questionRemove")
public class QuestionRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionRemoveServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int num=Integer.parseInt(request.getParameter("QANum"));
		
		int result = new QuestionService().questionRemove(num);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="성공적으로 삭제되었습니다";
			loc="/question/questionList";
		}else {
			msg="삭제에 실패하였습니다";
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
