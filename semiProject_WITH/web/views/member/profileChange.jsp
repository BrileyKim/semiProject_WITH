<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.member.model.vo.Member" %>
<%
	Member logginedMember = (Member)(session.getAttribute("logginedMember"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Change</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@500&display=swap" rel="stylesheet">
<style>
	*{
		font-family:Noto Serif KR;
		text-align:center;
	}
	#submitProfile{
		font-size:15px;	
		margin-right:5px;
		background-color:rgba(114,133,63,0.79);
		border:1px solid rgba(250,247,242,0.7);
		width:90px;
		height:30px;
	}
	#btnProfile{
		font-size:15px;	
		background-color:white;
		border:1px solid rgba(0,0,0,0.5);
		width:90px;
		height:30px;
	}
	#upProfile{
		font-size:15px;
		margin-left:20px;
	}

</style>
</head>
<body>
	
	<h3>새로운 프로필 사진을 선택하세요.</h3>
	<form name="ProfileChangeFrm" action="<%=request.getContextPath() %>/changeProfileEnd?id=<%=logginedMember.getId()%>" method="post"
    enctype = "multipart/form-data">
    			<br>
    			<input type="file" name="upProfile" id="upProfile">
  
    			<br>
    			<br>
    			<br>
    			<input type="submit" id="submitProfile" value="변경하기"/>
    			<input type="button" id="btnProfile" value="취소하기 " onclick="self.close();"/>

		
	
	</form>
</body>
</html>