<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.member.model.vo.Member" %>
<!-- Apply header.css to header.jsp 
	Please do not use relative path when you apply documents-->    
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<header>
	<div class="header">
		<div class="header-left">
			<a class="active" href="<%=request.getContextPath()%>/meet/meetList">Meet</a>
			<a class="active" href="<%=request.getContextPath() %>/notice/noticeList">Notice</a>
			<a class="active" href="<%=request.getContextPath() %>/question/questionList">Q & A</a>
		</div>
	</div>
</header>
