package com.with.question.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.with.question.model.service.QuestionService;
import com.with.question.model.vo.Question;
import com.with.question.model.vo.QuestionComment;

/**
 * Servlet implementation class QuestionViewServlet
 */
@WebServlet("/question/questionView")
public class QuestionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionViewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("question_idx"));
		
		Cookie[] cookies=request.getCookies();
		String QuestionHistory="";
		boolean hasRead=false;
		
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name=c.getName();
				String value=c.getValue();
				if("QuestionHistory".equals(name)) {
					QuestionHistory=value;
					if(value.contains("|"+num+"|")) {
						hasRead=true;
						break;
					}
				}
			}
		}
		
		if(!hasRead) {
			Cookie c=new Cookie("QuestionHistory",QuestionHistory+"|"+num+"|");
			c.setMaxAge(-1);
			response.addCookie(c);
		}
		
		Question q=new QuestionService().selectQuestionOne(num,hasRead);

		//댓글
		List<QuestionComment> list = new QuestionService().selectQuestionCommentList(num);
		
		String view="";
		if(q==null) {
			request.setAttribute("msg", "조회된 게시판 글이 없습니다. ");
			request.setAttribute("loc", "/question/questionList");
			view="/views/common/msg.jsp";
		}else {
			request.setAttribute("question", q);
			request.setAttribute("list", list);
			view="/views/question/questionView.jsp";
		}
		
		
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
