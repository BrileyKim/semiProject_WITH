<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.member.model.vo.Member" %>
<%
	Member m = (Member)request.getAttribute("result");
%>
<i id="exist" class="fas fa-check"></i>
<style>
<%if(m!=null){%>
	#exist{
		color:red;
	}
<%}else{%>
	#exist{
		color:green;
	}
<%}%>
</style>