package com.with.question.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.question.model.service.QuestionService;
import com.with.question.model.vo.Question;

/**
 * Servlet implementation class QAListServlet
 */
@WebServlet("/question/questionList")
public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//current page number
		int spage=1;
		String page = request.getParameter("page");
		if(page!=null) spage =Integer.parseInt(page);
		
		//Bring search condition and search contents
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		
		List<Question> list = new QuestionService().selectQuestionList(spage*5-4,opt,condition);
		int listCount = new QuestionService().selectQuestionCount(spage*5-4,opt,condition);
		
		//the number of total Page
		int maxPage = (int)(listCount/5.0+0.9);
		//start page number
		int startPage = (int)(spage/5.0+0.8)*5-4;
		//last page number
		int endPage = startPage + 4;
		if(endPage>maxPage) endPage = maxPage;
		
		//store 4 number of page
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		request.setAttribute("questions", list);
		RequestDispatcher rd = request.getRequestDispatcher("/views/question/questionList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
