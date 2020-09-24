<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.question.model.vo.Question,com.with.question.model.vo.QuestionComment,java.util.List" %>
<%
	Question q = (Question)request.getAttribute("question");
	List<QuestionComment> list=(List)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#questionBox{
		margin:20px auto;
		background-color:rgba(114, 133, 63,0.8); 
		width:700px;
		height:10%;
		padding:20px;
	}
	table#tbl-QA{
		width:700px; 
		border:1px black solid; 
		border-collapse: collapse;
		min-width: 600px;
	}
	table#tbl-QA th
	{
		width:125px;
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
	
	/*댓글테이블*/
	div#comment-container{
		text-align:center;
		margin:20px auto; 
		border:1px gray solid; 
		width:40%;
		min-width: 700px;
		padding-bottom:20px;
	}
	div#comment-container>p{
		float:left;
		margin-left:35px;
		margin-top:20px;
	}

	#btn-insert{
		float:right;
		margin-right:10px;
	}
    table#tbl-comment{
    	width:520px; 
    	margin:10px auto; 
    	border-collapse:collapse; 
    	clear:both;
    } 
    table#tbl-comment tr td{
    	border-bottom:1px solid;  
    	padding:5px; 
    	text-align:left; 
    	line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 30px;}
    table#tbl-comment tr td:last-of-type {text-align:left; width: 100px;}
    table#tbl-comment tr td:first-of-type>p{padding-bottom: 5px;}
    table#tbl-comment tr td:last-of-type>p{padding-bottom: 5px;}
    table#tbl-comment button.btn-reply{display:none;}
    table#tbl-comment button.btn-delete{display:none;}
    table#tbl-comment button.btn-update{display:none;}
    table#tbl-comment tr:hover button.btn-update{display:inline;}
    table#tbl-comment tr:hover button.btn-reply{display:inline;}
    table#tbl-comment tr:hover button.btn-delete{display:inline;}
    table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
    table#tbl-comment p.comment-writer { font-size:14px}
    table#tbl-comment p.comment-date { font-size:10px}
    table#tbl-comment tr.level2 td:first-of-type{padding-left:80px;background-color:#F5F5F5	;}
    table#tbl-comment tr.level2 p.comment-writer {font-size:14px}
    table#tbl-comment tr.level2 p.comment-date {font-size:10px}
    /*답글관련*/
    /* table#tbl-comment textarea{margin: 4px 0 0 0;} */
    table#tbl-comment button.btn-insert2{width:60px; height:23px; color:black;  position:relative; top:5px;bottom:5px; float:right;}
	.btn-delete2{float:right;}
	#noSessionTextarea{margin:20px auto;width:610px; }
	#noSessionTextarea textarea{font-size:16px;}
	::-webkit-scrollbar{width: 15px;}
	::-webkit-scrollbar-track {background-color:#f1f1f1;}
	::-webkit-scrollbar-thumb {background-color:rgba(237,165,65,0.8);}
	::-webkit-scrollbar-thumb:hover {background: rgba(0,0,0,0.5);}
	::-webkit-scrollbar-button:start:decrement,::-webkit-scrollbar-button:end:increment {
	width:16px;height:16px;background:rgba(237,165,65,0.8);} 
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="QA-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="questionBox">
			<table id="tbl-QA">
				<tr>
					<th>글번호</th>
					<td>
						<%=q.getQuestionIdx() %>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=q.getQuestionTitle() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=q.getQuestionWriter() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<%if(q.getQuestionOriginalFilename()!=null){ %>
	     					<a href="javascript:fn_fileDownload('<%=q.getQuestionOriginalFilename()%>','<%=q.getQuestionRenamedFilename()%>');">
								<img src="<%=request.getContextPath()%>/img/file.png" width="20" height="20">
							</a>
							<script>
								function fn_fileDownload(oriname,rename){
									
									const url="<%=request.getContextPath()%>/question/questionFileDown";
									let oName=encodeURIComponent(oriname);
									location.assign(url+'?oName='+oName+'&rName='+rename);							
								}
							</script>
					<%}%>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<%=q.getQuestionContent()%>
					</td>
				</tr>
			 	<tr>
					<th colspan="3">
					<%if(logginedMember!=null) {%>
						<%if(logginedMember.getId().equals("admin")||q.getQuestionWriter().equals(logginedMember.getId())){ %>
						<button type="button" id="updateQA">수정하기</button>
						<button type="button" onclick="removeQA();">삭제하기</button>
						<%}
					}%>
					<button id="list">목록</button>
				</th>
				
			</tr> 
			
		</table>
		</div>
		
		<hr>
		
		<%if(logginedMember!=null){ %>
		<div id="comment-container">
			<p><%=logginedMember.getId() %></p>
			<br>
			<div class="comment-editor">
				<form action="<%=request.getContextPath()%>/question/questionCommentInsert" method="post">
					<input type="hidden" name="qaRef" value="<%=q.getQuestionIdx()%>">
					<input type="hidden" name="qaCommentWriter" value="<%=logginedMember!=null?logginedMember.getId():""%>">
					<input type="hidden" name="qaCommentLevel" value="1">
					<input type="hidden" name="qaCommentRef" value="0">
					<textarea name="qaCommentContent" cols="60" rows="5"></textarea>
					<button type="submit" id="btn-insert">등록</button>
				</form>
			</div>
		</div>
		<%} %>
<%-- 		<div id="comment-container">
			<p>손님</p>
			<br>
			<div class="comment-editor">
				<form action="<%=request.getContextPath()%>/question/questionCommentInsert" method="post">
					<input type="hidden" name="qaRef" value="<%=q.getQuestionIdx()%>">
					<input type="hidden" name="qaCommentWriter" value="<%=logginedMember!=null?logginedMember.getId():""%>">
					<input type="hidden" name="qaCommentLevel" value="1">
					<input type="hidden" name="qaCommentRef" value="0">
					<textarea name="qaCommentContent" cols="60" rows="5"></textarea>
					<button type="submit" id="btn-insert" style="opacity:0;">등록</button>
				</form>
			</div>
		</div>
		
		<%} %> --%>
<!-- 		<div id="comment-container">
			<p>손님</p>
			<div class="comment-editor"> -->
				<%-- <form action="<%=request.getContextPath()%>/question/questionCommentInsert" method="post">  --%>
 				<%-- 	<input type="hidden" name="qaRef" value="<%=q.getQuestionIdx()%>">
					<input type="hidden" name="qaCommentWriter" value="<%=logginedMember!=null?logginedMember.getId():""%>">
					<input type="hidden" name="qaCommentLevel" value="1">
					<input type="hidden" name="qaCommentRef" value="0"> --%>
<!-- 					<div id="noSessionTextarea">
					<textarea  cols="60" rows="5" placeholder="댓글을 작성하시려면 로그인을 해주세요."></textarea>
 					</div> -->
 					<!--<button type="submit" id="btn-insert">등록</button> 
				</form> -->
<!-- 			</div>
			</div> -->
		
			 <div>
		<table id="tbl-comment">
		<%for(QuestionComment qc : list) {
		
			if(qc.getQaCommentLevel()==1){
		%>
			<tr class="level1">
				<td>
					<p class="comment-writer"><%=qc.getQaCommentWriter()%></p>
					<p class="comment-date"><%=qc.getQaCommentDate()%></p>
					
					
					<%=qc.getQaCommentContent() %>
				</td>
				<td>
					<button class="btn-reply" value="<%=qc.getQaCommentNo()%>">답글</button>
					 <%if(logginedMember!=null&&(logginedMember.getId().equals(qc.getQaCommentWriter())||
							logginedMember.getId().equals("admin"))) %>
						
					
					<form action="<%=request.getContextPath()%>/question/questionCommentDelete" id="frm-delete">
						<input type="hidden" value="<%=qc.getCommentRef()%>" name="qcCommentRef" id="qaRef">
						<input type="hidden" value="<%=q.getQuestionIdx()%>" name="qaNo">
						<input type="hidden" value="<%=qc.getQaCommentNo() %>" name="qcNo">
						<input type="hidden" value="<%=qc.getQaCommentLevel()%>" name="qcLev">
						<button class="btn-delete" value="<%=qc.getQaCommentNo()%>">삭제</button>
 					</form>
				</td>
			</tr>
			 <%}
			else{ %> 
			<tr class="level2">
				<td colspan="3">
					<p><%=qc.getQaCommentWriter()%></p>
					<p><%=qc.getQaCommentDate()%></p>
					
					<p><%=qc.getQaCommentContent() %></p>
					<form action="<%=request.getContextPath()%>/question/questionCommentDelete" id="frm-delete2">
						<input type="hidden" value="<%=qc.getQaRef()%>" name="qcCommentRef" id="qaRef_">
						<input type="hidden" value="<%=q.getQuestionIdx()%>" name="qaNo">
						<input type="hidden" value="<%=qc.getQaCommentNo() %>" name="qcNo">
						<input type="hidden" value="<%=qc.getQaCommentLevel()%>" name="qcLev">	
						<button class="btn-delete2" value="<%=qc.getQaCommentNo()%>">삭제</button>
					</form>
				</td>
			</tr>
		 	<% }
		} %> 
		</table>
	</div> 
		
	</section>
	<script>

$(function(){
	
	$(".btn-update").click(e=>{
		$("div#comment-container").clone()
	}),
	
	
	$("[name=qaCommentContent]").focus(e=>{
		if(<%=logginedMember==null%>){
			alert("로그인 후 이용해주세요!");
			
		}
	}),
	
	//답글 클릭시 이벤트
	$(".btn-reply").click(e=>{
		<%if(logginedMember!=null){%>
			let tr=$("<tr>");
			let form=$(".comment-editor>form").clone();
			form.find("[name=qaCommentLevel]").val("2");
			form.find("[name=qaCommentRef]").val(e.target.value);
			let td=$("<td>");
			tr.append(td.append(form));
			tr.insertAfter($(e.target).parents("tr"));
			$(e.target).off("click"); 
		 <%}%> 
		 $(".btn-insert2").prev().remove();
		 
	}),
	
	
	
	$(".btn-delete").click(e=>{
		
		$("#frm-delete").submit();
	
	}),
	
	$(".btn-delete2").click(e=>{
		
		$("#frm-delete2").submit();
	
	});
	
	
	
	

})

	
	

	

function removeQA(){
	window.location.replace('<%=request.getContextPath()%>/question/questionRemove?QANum=<%=q.getQuestionIdx()%>');
	}
	
	
	$(function(){
		$("#updateQA").click(e=>{
			
			window.location.replace('<%=request.getContextPath()%>/question/questionUpdate?QANum=<%=q.getQuestionIdx()%>');
		});
	});
	
		
			
	

	<%-- function updateQA(){
	window.location.replace('<%=request.getContextPath()%>/QA/QAUpdate?QANum=<%=qa.getQuestionIdx()%>');
	} --%>
	
	$("#list").click(e=>{
		location.replace('<%=request.getContextPath()%>/question/questionList');
	});
	
	
</script>	
</body>
</html>