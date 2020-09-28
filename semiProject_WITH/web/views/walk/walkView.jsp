<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.walk.model.vo.Walk" %>
<%
	Walk w=(Walk)request.getAttribute("walk");
	int headCount = (int)request.getAttribute("headCount");
	String meetIdx = (String)request.getAttribute("meetIdx");
	String meetGrade = (String)request.getAttribute("meetGrade");
	String walkGrade = (String) request.getAttribute("walkGrade");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>walk View</title>
<style>
	#walkBox{
		margin:20px auto;
		background-color:rgb(250, 247, 242); 
		width:650px;
		height:450px;
		padding:10px;
	}
	#walkBox h2{
		text-align:center;
	}
	table#tbl-walk{
		width:650px; 
/* 		border:1px black solid; 
		border-collapse: collapse; */
		border-spacing:10px 5px;
		min-width: 600px;
	}
	table#tbl-walk th
	{
		width:125px;
		/* border:1px solid; */
		padding:5px 0;
		text-align:center;
	}
	table#tbl-walk td
	{
		/* border:1px solid; */
		padding:5px 0 5px 10px;
		text-align:left;
	}	
	#tbl-walk td{
		font-size:17px;
	}
	#tbl-walk td input{
		font-size:17px;
	}
	#tbl-walk td textarea{
		font-size:17px;
	}
	#tbl-walk td input[type="number"]{
		width:115px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="main-container">
		<%@ include file="/views/common/sidebar.jsp" %>
	<div id="walkBox">
		<h2><%=w.getWalkTitle()%></h2>
		<table id="tbl-walk">
			<tr>
				<td colspan="2">
					<%if(logginedMember!=null&&meetGrade!=null&&walkGrade==null) {%>
						<input type="button" id="joinBtn" value="가입신청">
					<%}%>
				</td>
			</tr>
			<tr>
				<th>산책 대표</th>
				<td><input type="text" id="walk_writer" value="<%=w.getWalkWriter()%>" readonly></td>
			</tr>
			<tr>
				<th>산책 인원</th>
				<td><input type="number" class="walk_headcount" value="<%=headCount%>" readonly>
				 / <input type="number" class="walk_headcount" value="<%=w.getWalkHeadCount()%>" readonly></td>
			</tr>
			<tr>
				<th>산책 날짜</th>
				<td><input type="date" id="walk_date" readonly></td>
			</tr>
			<tr>
				<th>산책 시간</th>
				<td><input type="number" value="<%=w.getWalkHour()%>" readonly> 
				: <input type="number" value="<%=w.getWalkMinute() %>" readonly></td>
			</tr>
			<tr>
				<th>산책 코스</th>
				<td><textarea cols="40" rows="6" readonly><%=w.getWalkContent()%></textarea></td>
			</tr>
			<tr>
	           	<td style="text-align: center;">
	                <%if(logginedMember!=null && logginedMember.getId().equals(w.getWalkWriter())){ %>
	        			<input type="button" id="updatebtn" value="수정" onclick="location.href='<%=request.getContextPath()%>/walk/walkUpdate?walkIdx=<%=w.getWalkNo()%>&meetIdx=<%=meetIdx%>'">
	                	<input type="button" id="deletebtn" value="삭제" onclick="btn_notice_delete();">
	            
	            	<%} %>
	           	</td> 
			</tr>
		</table>
	</div>
	<form id="enrollAccept" action="<%=request.getContextPath()%>/walk/memberJoin" method="post">
			<input type="hidden" name="id" value="<%=logginedMember!=null?logginedMember.getId():""%>">
			<input type="hidden" name="walk_idx" value="<%=w.getWalkNo()%>">
	</form>
</section>
<script>
	$(function(){
		$("#joinBtn").click(function(){
			if(confirm('<%=w.getWalkTitle()%> 산책에 참여하시겠습니까?')){
				$("#enrollAccept").submit();
			}else{
				alert("취소되었습니다.");
			}
		})	
	});
	
	$(document).ready(function(){
		var walkDate='<%=w.getWalkDate()%>';
		var yyyy=walkDate.substr(0,4);
		var mm = walkDate.substr(5,2);
		var dd = walkDate.substr(8,2);
		
		console.log(walkDate);
		console.log(dd);
		
		var com_walkDate=new Date(yyyy,mm-1,dd);
		console.log(com_walkDate);
		document.getElementById("walk_date").value=
			com_walkDate.toISOString().slice(0,10);
		console.log(com_walkDate.toISOString().slice(0,10));
		console.log(com_walkDate.toISOString());
	})
		
</script>
</body>
</html>