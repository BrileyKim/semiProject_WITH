<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List,com.with.walk.model.vo.Walk,com.with.member.model.vo.Member" %>    
<%
	List<Walk> list = (List<Walk>)request.getAttribute("walks");
	int meetIdx = (int)request.getAttribute("meetIdx");
	String meetGrade = (String)request.getAttribute("meetGrade");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Walk List</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	a{
		text-decoration:none;
		color:black;
	}
	*:focus { outline:none; }
	#tablediv{
		background:rgba(114, 133, 63,0.95);
	  	width:730px;
	  	height:440px;
	  	padding:20px;
	  	margin:20px auto;
	  	text-align:center;
	} 
	.card {
		background: #ffeddf;
		border-radius: 40px;
		display: inline-block;
		width: 180px;
		height:200px;
		margin-bottom:20px;
		position: relative;
		box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
	    /* transition: all 0.1s cubic-bezier(.25,.8,.25,1); */
	}
	.card:hover {
  		/* box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22); */
  		border: orange 2px solid;
	}
	#writebtn{
            width:80px;
            height: 30px;
            color:black;
            border: none;
            text-align: center;
            display: inline-block;
            font-size: 16px;
            
            cursor: pointer;
            border-radius:3px;
            font-weight: bold;
            background: rgb(236, 236, 236);
            background-position:3px center;
    }
        #writebtn:hover {
        background-color: rgb(199, 197, 197);
    }
    #backtable{
    	width:730px;
    	height:440px;
    	background-color:rgb(250, 247, 242);
    	padding:0;
    	margin:auto;
    	position:fixed;
    }
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="walk-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="tablediv">
			
			<table id="backtable">
				<tr>
					<td style="padding:0; height:100px;" colspan="3">
						<p style="font-size:35px; margin:0;">전체 산책 보기</p>
					<button type="button" style="float:left; padding:4px; margin-left:10px; background-color:white; border-radius:2px; border:1px solid rgba(0,0,0,0.4); font-size:15px;">우리 모임 메인 화면으로 돌아가기 </button>
					</td>
				</tr>

				<tr>
			<%if(list!=null){
				for(Walk w : list){%>
					<td style="margin-top: 10px;">
						<div id="cardlist" style=""> 
							<div class="card" onclick="location.href='<%=request.getContextPath() %>/walk/walkView?walkIdx=<%=w.getWalkNo()%>&meetIdx=<%=meetIdx%>'" >		
								<table style="width:180px;">
									<tr>
										<td  style="text-align: left; padding-top:20px; padding-left: 20px;">
											<%if(w.getWalkTitle().length()>8){%>
												<%=w.getWalkTitle().substring(0,8) %>
											<%} else{%>
												<%=w.getWalkTitle()%>
											<%} %>
										</td>
									</tr>
									<tr>
										<td    style="text-align: left; padding-top:30px; padding-left: 20px; font-size:20px">
											<%=w.getWalkWriter()%>
										</td>
									</tr>
									<tr>
										<td style="text-align: right; padding-top:50px; padding-right: 20px;">
											<%=w.getWalkDate().substring(0,10)%>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</td>
			<%	}%>
			</tr>
			<%}%>
			<tr>
				<td colspan="3">
					<div id="pageForm">
						<c:if test="${startPage!= 1}">
			            	<a href='<%=request.getContextPath()%>/walk/walkList?page=${startPage-1}'>[이전]</a>
			        	</c:if>
			        	<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
			            <c:if test="${pageNum == spage}">
			                ${pageNum}&nbsp;
			            </c:if>
			            <c:if test="${pageNum != spage}">
			                <a href='<%=request.getContextPath()%>/walk/walkList?page=${pageNum}'>${pageNum}&nbsp;</a>
			            </c:if>
			        	</c:forEach>
			        
			       		 <c:if test="${endPage != maxPage }">
			            <a href='<%=request.getContextPath()%>/walk/walkList?page=${endPage+1 }'>[다음]</a>
			        	</c:if>
					</div> 
					
			   				<%if(logginedMember!=null && meetGrade!=null){ %>
			  				<button onclick="location.assign('<%=request.getContextPath()%>/walk/walkAdd?meetIdx=<%=meetIdx%>')" style="float:right; margin-top: 0;" id="writebtn">산책 만들기</button>
			  				<%} %>

				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div id="searchForm">
				        <form>
				        <input type="hidden" name="meet_idx" value="<%=meetIdx%>">
				            <select name="opt">
				                <option value="0">산책 이름</option>
				                <option value="1">산책 설명</opstion>
				                <option value="2">산책 이름+설명</option>
				                <option value="3">산책 대표</option>
				            </select>
				            <input type="text" size="20" name="condition">&nbsp;
				            <input type="submit" value="검색">
				        </form>    
					</div>
				</td>
			</tr>
			
			</table>
		</div>
	</section>
</body>
</html>