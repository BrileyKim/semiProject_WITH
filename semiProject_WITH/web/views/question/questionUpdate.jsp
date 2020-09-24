<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.question.model.vo.Question" %>
<%
	Question q = (Question)request.getAttribute("question");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Update</title>
<style>
	#questionUpdateBox{
		margin:20px auto;
		background-color:rgb(250, 247, 242); 
		width:700px;
		height:420px;
		padding:10px;
	}
	#upfile{
		width:230px;
	}
	table#tbl-QA{
		width: 580px; 
		border:1px black solid; 
		border-collapse: collapse;
		margin:20px auto;
	}
	table#tbl-QA th
	{
		width:120px;
		border:1px solid;
		padding:5px 0;
		text-align:center;
	}
	table#tbl-QA td
	{
		border:1px solid;
		padding:5px 0 5px 10px;
		text-align:left;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="question-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="questionUpdateBox">
			<form action="<%=request.getContextPath() %>/question/questionUpdateEnd" method="post" enctype="multipart/form-data">
				<table id="tbl-QA">
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="title" value="<%=q.getQuestionTitle() %>">
							<input type="hidden" name="no" value="<%=q.getQuestionIdx()%>">
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer" value="<%=q.getQuestionWriter() %>" readonly></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
							<input type="text" id="fileload" name="fileLoad" style="width:250px;"
							value="<%=q.getQuestionOriginalFilename()==null?"새롭게 첨부하시려면 수정을 클릭하세요.":q.getQuestionOriginalFilename()%>" style="border:none;" readonly> 
							<input type="file" class="fileview" name="upfile" >
					              <button type="button" class="fileadd" name="fileadd" >수정</button>
					              <button type="button" id="filedeletebtn" name="fileDeletebtn">삭제</button>
							<input type="hidden" id="filehidden" name="filehidden" value=""/>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" rows="10" cols="53"><%=q.getQuestionContent() %></textarea></td>
					</tr>
					<tr>
						<th colspan="2">
							<input type="submit" value="수정완료">
							<button>삭제하기</button>
							<button id="list">목록</button>
						</th>
						
					</tr>
					
				</table>
			</form>
		</div>
	</section>
	<script>
	$(document).ready(function(){
		$(".fileview").hide();//input type file 부분
		let fileCount=0;
		$(".fileadd").click(function(){ //수정버튼 
			if(fileCount==0){
	    		$("#fileload").hide();//input type text부분
	    		$(".fileview").show();
	    		$(".fileadd").html("수정취소");

	    		fileCount++;
			}else{
				$("#fileload").show();
	    		$(".fileview").hide();
	    		$(".fileadd").html("수정");
	    		fileCount=0;
			}
		})
	
		$(function(){
			let deleteCount=0;
			$("#filedeletebtn").click(function(){
				if(deleteCount==0){
					document.getElementById("filehidden").value="delete";
					$("#fileload").css("color","white");
					$("#filedeletebtn").html("초기화");
					console.log(document.getElementById("filehidden").value);
					deleteCount++;
				}else{
					document.getElementById("filehidden").value="";
					console.log(document.getElementById("filehidden").value);
					$("#filedeletebtn").html("삭제");
					$("#fileload").css("color","black");
					deleteCount=0;
				}			
			});
		});
	})
	</script>
</body>
</html>