<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.meet.model.vo.Meet" %>
<%
	Meet m = (Meet)request.getAttribute("meet");
	String grade=(String)request.getAttribute("grade");
	int headCount=(int)request.getAttribute("headCount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meet View</title>
<style>
#myMeet{
		padding:0;
		margin:0;
		left:15%;
		top:100px;
		width:70%;
		height:200px;
		position:absolute;
		background-color:rgb(250, 247, 242); 
		border-radius:3px;
		text-align:center;
	}
	#walk, #gallery, #board{
		width:190px;
		height:50px;
		background:rgba(114, 133, 63,0.9);
		border-radius:3px;
		text-align:center;
		padding-top:16px;
		display:inline-block;
		margin: 15px;
	}
	#walk a, #gallery a, #board a{
		text-decoration:none;
		color:white;
		font-size: 23px;
		
	}
</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
	<section id="meet-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="myMeet">
			<h1><%=m.getTitle()%></h1>
			<%if(grade!=null){ %>
				<label id="grade">내 등급 : <%=grade %></label>
			<%} %>
			<label id="headCount" name="headCount">현재 인원 수  : <%=headCount %> / <%=m.getHeadCount() %></label>
			<div id="walk">
				<a href="#">산책</a>
			</div>
			<div id="gallery">
				<a href="#">갤러리 </a>
			</div>
			<div id="board">
				<a href="#">게시판</a>
			</div>
			<%if(logginedMember!=null&&grade==null) {%>
				<input type="button" id="joinBtn" value="가입신청">
			<%}%>
		</div>
		<form id="enrollAccept" action="<%=request.getContextPath()%>/meet/joinMember" method="post">
			<input type="hidden" name="id" value="<%=logginedMember.getId()%>">
			<input type="hidden" name="title" value="<%=m.getTitle()%>">
		</form>
		
		<div id="meetBox">
		</div>
	</section>
	
	<script>
	$(function(){
		$("#joinBtn").click(function(){
			console.log("실행");
			if(confirm('<%=m.getTitle()%> 모임에 가입하시겠습니까?')){
				$("#enrollAccept").submit();
			}else{
				alert("취소되었습니다.")
			}	
		});
	});
	
	</script>
</body>
</html>