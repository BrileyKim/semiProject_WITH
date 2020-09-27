<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.walk.model.vo.Walk" %>
<% Walk w = (Walk)request.getAttribute("walk");
	String meetIdx=(String)request.getAttribute("meetIdx");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Walk Update</title>
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
	<form action="#" id="updateForm"  method="post" enctype="multipart/form-data">
		<input type="hidden" name="walk_no" value="<%=w.getWalkNo()%>">
		<input type="hidden" name="walk_meet_idx" value="<%=w.getWalkMeetIdx()%>">
		<table id="tbl-walk">
			<tr>
				<th>총 허용 인원</th>
				<td>
				 <input type="number" name="walk_headcount" id="walk_headcount" value="<%=w.getWalkHeadCount()%>" ></td>
			</tr>
			<tr>
				<th>산책 날짜</th>
				<td><input type="date" name="walk_date" id="walk_date" ></td>
			</tr>
			<tr>
				<th>산책 시간</th>
				<td><input type="number" name="walk_hour" value="<%=w.getWalkHour()%>" > 
				: <input type="number" name="walk_minute" value="<%=w.getWalkMinute() %>" step="10" min="0" max="50"></td>
			</tr>
			<tr>
				<th>산책 코스</th>
				<td><textarea cols="40" name="walk_content" rows="6" ><%=w.getWalkContent()%></textarea></td>
			</tr>
			<tr>
	           	<td style="text-align: center;" colspan="2">
                    <input type="button" id="cancelbtn" value="취  소" onclick="cancelbutton();"/> 
                    <input type="button" id="enrollbtn" value="수 정" onclick="updatebutton();" /> 

	           	</td> 
			</tr>
		</table>
	</form>
	</div>
</section>
<script>
function cancelbutton() {
    if (confirm("작성하신 내용은 저장되지 않습니다. 정말 취소하시겠습니까??") == true){    //확인
    	location.replace("<%=request.getContextPath() %>/walk/walkList?meet_idx=<%=meetIdx%>&id=<%=logginedMember!=null?logginedMember.getId():""%>");
    }else{   //취소
        return false;
    }
}

function updatebutton(){
	const frm=$("#updateForm");
	const url="<%=request.getContextPath()%>/walk/walkUpdateEnd";
	frm.attr({
		"action":url,
		"method":"post",
		"enctype":"multipart/form-data"
	});
	frm.submit();
}
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