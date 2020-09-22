package com.with.dog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.with.common.MyFileRename;
import com.with.dog.model.service.DogService;
import com.with.dog.model.vo.Dog;

/**
 * Servlet implementation class DogAddEndServlet
 */
@WebServlet("/addDogEnd")
public class DogAddEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DogAddEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "내 강아지 입력오류[form:enctype]관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/")+"upload/dog";
		int maxSize = 1024*1024*10;
		String encode = "UTF-8";
		
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,encode,new MyFileRename());

		String dogOwner = mr.getParameter("dog_owner");
		String dogName = mr.getParameter("dog_name");
		String dogProfile = mr.getFilesystemName("dog_profile");
		String dogBreed1=null;
		String dogBreed2=null;
		if(mr.getParameter("firstSelect").equals("1")) {
			dogBreed1 ="소형견";
			if(mr.getParameter("secondSelect").equals("0")) {
				dogBreed2 = "믹스견";
			}else if(mr.getParameter("secondSelect").equals("1")) {
				dogBreed2 = "스피츠";
			}else if(mr.getParameter("secondSelect").equals("2")) {
				dogBreed2 = "시츄";
			}else if(mr.getParameter("secondSelect").equals("3")) {
				dogBreed2 = "요크셔테리어";
			}else if(mr.getParameter("secondSelect").equals("4")) {
				dogBreed2 = "말티즈";
			}else if(mr.getParameter("secondSelect").equals("5")) {
				dogBreed2 = "포메라니안";
			}else if(mr.getParameter("secondSelect").equals("6")) {
				dogBreed2 = "푸들";
			}else if(mr.getParameter("secondSelect").equals("7")) {
				dogBreed2 = "치와와";
			}else if(mr.getParameter("secondSelect").equals("8")) {
				dogBreed2 = "미니핀";
			}else if(mr.getParameter("secondSelect").equals("9")) {
				dogBreed2 = "슈나우저";
			}else if(mr.getParameter("secondSelect").equals("10")) {
				dogBreed2 = "페키니즈";
			}else if(mr.getParameter("secondSelect").equals("11")) {
				dogBreed2 = "닥스훈트";
			}else if(mr.getParameter("secondSelect").equals("12")) {
				dogBreed2 = "빠삐용";
			}else if(mr.getParameter("secondSelect").equals("13")) {
				dogBreed2 = "기타";
			}
		}else if(mr.getParameter("firstSelect").equals("2")) {
			dogBreed1 = "중형견";
			if(mr.getParameter("secondSelect").equals("0")) {
				dogBreed2 = "비숑 프리제";
			}else if(mr.getParameter("secondSelect").equals("1")) {
				dogBreed2 = "보스턴 테리어";
			}else if(mr.getParameter("secondSelect").equals("2")) {
				dogBreed2 = "샤페이";
			}else if(mr.getParameter("secondSelect").equals("3")) {
				dogBreed2 = "웰시코기";
			}else if(mr.getParameter("secondSelect").equals("4")) {
				dogBreed2 = "비글";
			}else if(mr.getParameter("secondSelect").equals("5")) {
				dogBreed2 = "코카스파니엘";
			}else if(mr.getParameter("secondSelect").equals("6")) {
				dogBreed2 = "불독";
			}else if(mr.getParameter("secondSelect").equals("7")) {
				dogBreed2 = "기타";
			}
		}else if(mr.getParameter("firstSelect").equals("3")) {
			dogBreed1 = "대형견";
			if(mr.getParameter("secondSelect").equals("0")) {
				dogBreed2 = "사모예드";
			}else if(mr.getParameter("secondSelect").equals("1")) {
				dogBreed2 = "피레니즈";
			}else if(mr.getParameter("secondSelect").equals("2")) {
				dogBreed2 = "리트리버";
			}else if(mr.getParameter("secondSelect").equals("3")) {
				dogBreed2 = "말라뮤트";
			}else if(mr.getParameter("secondSelect").equals("4")) {
				dogBreed2 = "한국 토종견";
			}else if(mr.getParameter("secondSelect").equals("5")) {
				dogBreed2 = "허스키";
			}else if(mr.getParameter("secondSelect").equals("6")) {
				dogBreed2 = "세퍼트";
			}else if(mr.getParameter("secondSelect").equals("7")) {
				dogBreed2 = "하운드";
			}else if(mr.getParameter("secondSelect").equals("8")) {
				dogBreed2 = "달마시안";
			}else if(mr.getParameter("secondSelect").equals("9")) {
				dogBreed2 = "콜리";
			}else if(mr.getParameter("secondSelect").equals("10")) {
				dogBreed2 = "쉽독";
			}else if(mr.getParameter("secondSelect").equals("11")) {
				dogBreed2 = "기타";
			}
			
		}
		String dogGender = mr.getParameter("dog_gender");
		String dogBirth = mr.getParameter("dog_birth");
		String dogNeuter = mr.getParameter("dog_neuter");
		
		System.out.println(dogBreed1+dogBreed2);
		
		Dog d = new Dog();
		
		d.setDogOwner(dogOwner);
		d.setDogName(dogName);
		d.setDogGender(dogGender);
		d.setDogBreed1(dogBreed1);
		d.setDogBreed2(dogBreed2);
		d.setDogBirth(dogBirth);
		d.setDogNeuter(dogNeuter);
		d.setDogProfile(dogProfile);
		
		int result = new DogService().insertDog(d);
	
		String msg = "";
		String loc = "";
		if(result>0) {
			msg="내 강아지 등록 성공";
			loc="/myPage";
		}else {
			msg="내 강아지 등록 실패";
			loc="/views/member/myPage.jsp";
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
