<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.question.model.vo.Question, java.util.List" %>
<%
	List<Question> list = (List<Question>)request.getAttribute("questions");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QA List</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#questionBox{
		margin:20px auto; 
		width:700px;
		height:435px;
		text-align:center;
		background:rgba(114, 133, 63,0.9);
		padding-top:5px;
	}
	#tbl-div{
		width: 660px;
		background-color:rgb(250, 247, 242); 
		margin:20px;
		padding-top:10px;
		padding-bottom:10px;
	}
	table#tbl-QA{
		width:630px;
		border-spacing:5px 10px;
		border:1px black solid; 
		border-collapse:collapse;
		margin:15px;
	}
	table#tbl-QA th, table#tbl-QA td{
		border:1px solid; 
		padding-top:5px;
		padding-bottom:5px;
	}
	#tbl-QA a{
	text-decoration:none;color:black;}
	#tablecontainer{
	height:240px;
	}
	#pageForm{
	margin-bottom:10px;}
	a{
	text-decoration:none;
	color:black;
	}
</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
	<section id="question-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="questionBox">
			<div id="tbl-div">
			<h1>Q & A</h1>
			<div id="tablecontainer">
			<table id="tbl-QA">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>첨부파일</th>
					<th>작성날짜</th>
					<th>조회수</th>
				</tr>
				<% if(list.isEmpty()){%>
				<tr>
					<td colspan="6">
						등록된 게시글이 없습니다. 
					</td>
				<tr>
				<%}else{ 
						for(Question q : list){%>
				<tr>
					<td><%=q.getQuestionIdx() %></td>
					<td><%=q.getQuestionWriter() %></td>
					<td><a href="<%=request.getContextPath()%>/question/questionView?question_idx=<%=q.getQuestionIdx()%>"><%=q.getQuestionTitle() %></a></td>
					<td>
					<%if(q.getQuestionOriginalFilename()!=null) {%>
						<img src="<%=request.getContextPath()%>/img/file.png" width="20" height="20">
					<%} %>
					</td>
					<td><%=q.getQuestionEnrollDate() %></td>
					<td><%=q.getQuestionReadCount()%></td>
					
				</tr>
				<%}
				}%>
				
			</table>
			</div>
			<div id="pageForm">
							<c:if test="${startPage!= 1}">
				            	<a href='<%=request.getContextPath()%>/question/questionList?page=${startPage-1}'>[이전]</a>
				        	</c:if>
				        	<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
				            <c:if test="${pageNum == spage}">
				                ${pageNum}&nbsp;
				            </c:if>
				            <c:if test="${pageNum != spage}">
				                <a href='<%=request.getContextPath()%>/question/questionList?page=${pageNum}'>${pageNum}&nbsp;</a>
				            </c:if>
				        	</c:forEach>
				        
				       		 <c:if test="${endPage != maxPage }">
				            <a href='<%=request.getContextPath()%>/question/questionList?page=${endPage+1 }'>[다음]</a>
				        	</c:if>
						</div>
				<div id="writeForm">
		<%if(logginedMember!=null) {%>
		<button type="button" onclick="location.assign('<%=request.getContextPath()%>/question/questionWrite')"
		style="float:right;margin-right:5px;">글쓰기</button>
		<%} %>
				</div>
	     		<div id="searchForm">
					        <form>
					            <select name="opt">
					                <option value="0">제목</option>
					                <option value="1">내용</option>
					                <option value="2">제목+내용</option>
					                <option value="3">글쓴이</option>
					            </select>
					            <input type="text" size="20" name="condition">&nbsp;
					            <input type="submit" value="검색">
					        </form>    
				   		</div>
			</div>
		</div>
	</section>
</body>
</html>