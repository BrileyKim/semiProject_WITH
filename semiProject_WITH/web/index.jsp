<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Walk WITH me</title>
<style>
<%--body{background-image:url("<%=request.getContextPath()%>/img/back.jpg");background-position:center;background-repeat: no-repeat;background-size: cover;min-height:590px;}--%>    
	body::-webkit-scrollbar{display:none;}
	#mainBox-img{
		width:700px;
		height:440px;
		margin-left:100px;
		margin-top:30px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="main-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="mainBox">
			<img src="<%=request.getContextPath()%>/img/back.jpg"
				id="mainBox-img"/> 
		</div>
	</section>
</body>
</html>