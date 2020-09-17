<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.member.model.vo.Member" %>
<%
	Member m = (Member)request.getAttribute("result");
	String s = (String)request.getAttribute("sendedId");
%>

<!-- 1. s.length() shorter than 4 but m ==null
	 2. s.length() longer than 4 but m!=null
	 3. s.length() longer than 4 and m==null 
 -->
 <%if(s.length()<4){ %>
 <span id="exist" style="color:red;">아이디는 4글자 이상 입력하세요.</span>
 <%}else{
 		if(m!=null){%>
  			<span id="exist" style="color:red;">이미 사용된 아이디 입니다.</span>
 		<%}else{ %>
			<i class="fas fa-check" style="color:green;" ></i>
 <%		}
 	}%>
 