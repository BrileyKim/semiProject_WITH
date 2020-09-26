<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.with.meet.model.vo.Meet" %>
<%
	List<Meet> list = (List<Meet>)request.getAttribute("meets");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meet List</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#my-meet{
			cursor:pointer;
			left:12.5%;
			top:48px;
			width:75%;
			min-width:60%;
			max-width:75%;
			height:50px;
			position:relative;
			text-align:center;
			/* background-color:#ABABAB; */
			background:rgba(114, 133, 63,0.9);
			z-index:1;
			border-radius:3px;
			transition:1s;
			overflow:hidden;
		}
		#my-meet i,label{
			cursor:pointer;
			position:relative;
			top:8px;
		}
		#my-meet label{
			font-size:26px;
			color:white;
			font-weight:lighter;
			transition:1s;
		}
		#icon-dog{
			margin:0;
			padding:0;
			font-size:32px;
			color:white;
			transition:1s;
		}
		#icon-cancel{
			top:0px;
			right:0px;
			position:absolute;
			cursor:point;
			color:black;
			transition:1s;
			font-size:32px;
			z-index:2;
			opacity:0;
			display:none;
		}
		#icon-cancel label{
			left:20px;
			font-size:26px;
			top:-3px;
			color:white;
			transition:1s;
			font-weight:100;
		}
		#searchForm{
			margin:5px auto;
		}
		#meetList{
			background-color:rgb(250, 247, 242); 
			width:700px;
			height:435px;
			margin:100px auto;
			text-align:center;
			padding-top:20px;
		}
		#tableDiv{
			
			width:660px;
			height:300px;
			margin:20px auto;
		}
		#pageForm{
			margin:5px auto;
		}
		table#tbl-meet{
			width:630px;
			border-spacing:5px 10px;
			border:1px black solid; 
			border-collapse:collapse;
			margin:15px;
		}
		table#tbl-meet th, table#tbl-meet td{
			border:1px solid; 
			padding-top:5px;
			padding-bottom:5px;
		}
		#tbl-meet a{
			text-decoration:none;
			color:black;
		}
		
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="meet-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="meetBox">
			<input type="hidden" id="meetHidden" value="<%=logginedMember!=null?logginedMember.getId():""%>">
			<div id="my-meet">
				<i id="icon-dog" class="fas fa-mouse"></i>
				<label id="my-meet-title">&nbsp; 내 모임 보기</label>
				
			</div>
			<div id="meetList">
				<div id="tableDiv">
					<table id="tbl-meet">
						<tr>
							<th>번호</th>
							<th>모임이름</th>
							<th>모임장</th>
							<th>최대인원</th>
							<th>개설일</th>
						</tr>
						<%if(list.isEmpty()) {%>
						<tr>
							<td colspan="5">
								등록된 게시물이 없습니다.
							</td>
						</tr>
						<%}else{ 
							for(Meet m : list){%>
								<tr>
									<td><%=m.getIdx()%></td>
									<td>
										<a href="<%=request.getContextPath()%>/meet/meetView?meet_idx=<%=m.getIdx()%>&id=<%=logginedMember!=null?logginedMember.getId():""%>">
											<%=m.getTitle()%>
										</a>
									</td>
									<td><%=m.getLeader()%></td>
									<td><%=m.getHeadCount()%></td>
									<td><%=m.getCreateDate()%></td>
								</tr>
						<%	} 
						  }  %>
					</table>
				</div>
				<div id="pageForm">
					<c:if test="${startPage!= 1}">
		            	<a href='<%=request.getContextPath()%>/meet/meetList?page=${startPage-1}'>[이전]</a>
		        	</c:if>
		        	<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
		            <c:if test="${pageNum == spage}">
		                ${pageNum}&nbsp;
		            </c:if>
		            <c:if test="${pageNum != spage}">
		                <a href='<%=request.getContextPath()%>/meet/meetList?page=${pageNum}'>${pageNum}&nbsp;</a>
		            </c:if>
		        	</c:forEach>
		        
		       		 <c:if test="${endPage != maxPage }">
		            <a href='<%=request.getContextPath()%>/meet/meetList?page=${endPage+1 }'>[다음]</a>
		        	</c:if>
				</div>
				
<%-- 				<div id="writeForm">
					<%if(logginedMember!=null) {%>
					<button type="button" onclick="location.assign('<%=request.getContextPath()%>/meet/meetEnroll')"
					style="float:right;margin-right:5px;">모임만들기</button>
					<%} %>
				</div> --%>
				<br>
				<div id="searchForm">
			        <form>
			            <select name="opt">
			                <option value="0">모임이름</option>
			                <option value="1">모임설명</option>
			                <option value="2">모임이름+설명</option>
			                <option value="3">모임장</option>
			            </select>
			            <input type="text" size="20" name="condition">&nbsp;
			            <input type="submit" value="검색">
			        </form>    
				</div>
			</div>


		</div>
	</section>
<script>
	
	$(function(){
		var newValue;
		let mm = 0 ;
		$("#my-meet").on("click",function(){
			newValue = $("#meetHidden").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/myMeet",
				type:"get",
				data:{"id":newValue},
				dataType:"html",
				success:data=>{
					console.log(data);
					$("#my-meet").html(data);
				}
			});
		if(mm==0){
			$("#my-meet").css("height","500px");
/* 	        $("#my-meet").css("cursor","default");
	        $("#icon-dog").css("cursor","default");
	        $("#my-meet-title").css("cursor","default"); */
/* 	        $("#icon-dog").css("opacity","0");
	        $("#my-meet-title").css("opacity","0"); */
/* 	        $("#icon-cancel").css("opacity","1");
	        $("#icon-dog").css("display","none"); */
/*  	   	$("#icon-cancel").css("display","inline");
 	        $("#my-meet-title").css("display","none"); */
	        mm++;
		}else{
		  	$("#my-meet").css("height","50px");
/*  	        $("#my-meet").css("cursor","pointer");
	        $("#icon-dog").css("cursor","pointer");
	        $("#my-meet-title").css("cursor","pointer"); 
 	        $("#icon-dog").css("opacity","1");
	        $("#my-meet-title").css("opacity","1"); */
	      /*  $("#icon-cancel").css("opacity","0");
	        $("#icon-cancel").css("display","none");
	        $("#icon-dog").css("display","inline");
	        $("#my-meet-title").css("display","inline"); */
	        mm=0;
		}	
		});
	});
</script>
</body>
</html>