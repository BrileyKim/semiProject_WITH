<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int meetIdx = (int)request.getAttribute("meetIdx");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Walk Write</title>
<style>
	#walkBox{
		margin:20px auto;
		background-color:rgb(250, 247, 242); 
		width:700px;
		height:420px;
		padding:10px;
	}
	table#tbl-Walk{
		width: 580px; 
		border-spacing:5px 15px;
		margin:20px auto;
	}
	#walksubmit{
		background:rgba(114, 133, 63,0.9);
		font-size:16px;
		border:1px solid rgba(0,0,0,0.3);
		border-radius:2px;
		margin-left:200px;
		margin-right:20px;
	}
	#walkreset{
		font-size:16px;
		border:1px solid rgba(0,0,0,0.3);
		border-radius:2px;
	}
	#walk_headcount, #walk_title, #walk_date, #walk_writer{
		width:220px;
	}
	#tbl-Walk td{
		font-size:17px;
	}
	#tbl-Walk td input{
		font-size:17px;
	}
	#tbl-Walk td textarea{
		font-size:17px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="walk-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="walkBox">
			<form id="walkfrm" action="<%=request.getContextPath()%>/walk/walkAddEnd" method="post" enctype="multipart/form-data">
				<input type="hidden" value="<%=meetIdx!=0?meetIdx:""%>" name="walk_meet_idx">
			<div>
				<table id="tbl-Walk">
					<tr>
						<td>산책 대표자</td>
 						<%--<td><input type="button" value="선택하기" onclick="window.open('<%=request.getContextPath()%>/iconChoose','아이콘 선택하기','top=20, right=20, width=300, height=300')"></td>--%>					
						<td><input type="text" name="walk_writer" id="walk_writer" value="<%=logginedMember!=null?logginedMember.getId():"" %>" readonly></td>
					</tr>
					<tr>
						<td>산책 이름</td>
						<td><input type="text" name="walk_title" id="walk_title"></td>
					</tr>
					<tr>
						<td>최대 참가 인원</td>
						<td><input type="number" step="1" min="2" max="15" name="walk_headcount" id="walk_headcount"></td>
					</tr>
					<tr>
						<td>산책일</td>
						<td><input type="date" name="walk_date" id="walk_date"></td>
					</tr>
					<tr>
						<td>산책시간</td>
						<td>
							<input type="number" min="0" max="24" name="walk_hour" id="walk_hour" value="24"> 시
    						<input type="number" min="0" max="60" step="10" name="walk_minute" id="walk_minute"> 분
						</td>
					</tr>
					<tr>
    					<td>산책 코스</td>
    					<td><textarea cols="40" rows="6" name="walk_content" id="walk_content">산책 출발점부터 도착지까지 경로를 상세히 설명해주세요.</textarea></td>
    				</tr>
					<tr>
	    				<td colspan="2">
	                		<input id="walksubmit" type="submit" value="등록하기">
	            			<input id="walkreset" type="reset" value="작성취소">
	            		</td>
    				</tr>
				</table>
				</div>
			</form>
		</div>
	</section>
<script>

$(document).ready(function(){
	var tomorrow=new Date();
	tomorrow.setDate(tomorrow.getDate()+2);
	document.getElementById("walk_date").value = tomorrow.toISOString().substring(0, 10);
});
	
</script>
</body>
</html>