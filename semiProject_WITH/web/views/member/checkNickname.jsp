<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.member.model.vo.Member" %>
<%
	Member m = (Member)request.getAttribute("result");
	String s = (String)request.getAttribute("sendedNickname");
%>  
 <%if(s.length()<2){ %>
 <span id="exist" style="color:red;">닉네임은 두글자 이상 입력하세요.</span>
 <%}else{
 		if(m!=null){%>
  			<span id="exist" style="color:red;">이미 사용된 닉네임 입니다.</span>
 		<%}else{ %>
			<i class="fas fa-check" style="color:green;" ></i>
 <%		}
 	}%>