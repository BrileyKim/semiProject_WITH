<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.member.model.vo.Member" %>
<%
	Member logginedMember = (Member)(session.getAttribute("logginedMember"));
%>
<!-- Bring font awesome to use  search icon-->
<script src="https://kit.fontawesome.com/d41f04266a.js" crossorigin="anonymous"></script>
<!-- Apply sidebar.css to sidebar.jsp 
	and jquery library-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sidebar.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
/* W I T H title label */
#login-client>label{
	padding:0;
	font-size:60px;
	width:240px;
	height:60px;
	color:rgba(0,0,0,0.9);
	position:absolute;
	left:65px;
	top:0px;
}
#searchSlide{
	height:100%;
	width:0;
	position:fixed;
	z-index:1;
	top:0;
	right:0;
	background-color:rgba(114,133,63,0.8);
	overflow-x:hidden;
	transition:0.5s;
	padding-top:60px;
}
#searchSlide a{
	padding: 8px 8px 8px 34px;
	text-decoration: none;
	font-size:12px;
	color:rgba(0,0,0,0.5);
	display:block;
	transition:0.3s;
}
#searchSlide a:hover{
	color:#f1f1f1;
}
#searchSlide .closebtn{
	position:absolute;
	top:0;
	right:25px;
	font-size:36px;
	margin-left:50px;
}
@media screen and (max-height: 450px){
	#searchSlide {padding-top:15px;}
	#searchSlide a {font-size : 18px;}
}
#search-Opt{
	margin-left:15px;
	font-size:15px;
}
#searchText{
 width:170px;
 font-size:15px;
 margin-left:15px;
 margin-top:10px;
}
#searchSubmit{
	font-size:15px;
	background-color:rgba(250,247,242,0.8);
	border:1px solid rgb(250,247,242,0.8);
	position:absolute;
	right:30px;
	top:95px;
}
</style>
<!-- Create login box -->
<%if(logginedMember==null){%>
<div id="loginBox">
	<form action="<%=request.getContextPath()%>/login" method="post">
		<div id="login-client">
			<label class="login-show" id="login-label">W I T H</label>
			<ul class="login-show">
				<li id="login-option-id">
					<input type="text" id="id" name="id" placeholder="I D">
				</li>
				<li id="login-option-pw">
					<input type="password" id="pw" name="password" placeholder="PASSWORD">
				</li>		
			</ul>
			<div class="login-show" id="login-find" style="text-decoration:none;">
				<a href="#" id="find-id">Find ID</a>
			</div>
			<br>
			<div class="login-show" id="login-btns">
				<input type="submit" value="login" id="login-button">
				<!-- If you want to use two button in one form tag, 
					have to write type="button" to the button that is not a submit -->
				<button type="button" id="join-button" onclick="location.replace('<%=request.getContextPath()%>/joinMember');">Join</button>
			</div>
		</div>
	</form>
</div>
<%} %>

<div id="searchSlide">
	<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	        <form>
	            <select name="opt" id="search-Opt">
	                <option value="0">모임</option>
	                <option value="1">사용자</option>
	                <option value="2">산책</option>
	            </select>
	            <br>
	            <input type="text" size="20" name="condition" id="searchText">&nbsp;
	            <input type="submit" value="검색" id="searchSubmit">
	        </form> 
	        <div id="pageForm">
				<c:if test="${startPage!= 1}">
	            	<a href='<%=request.getContextPath()%>/notice/noticeList?page=${startPage-1}'>[이전]</a>
	        	</c:if>
	        	<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
	            <c:if test="${pageNum == spage}">
	                ${pageNum}&nbsp;
	            </c:if>
	            <c:if test="${pageNum != spage}">
	                <a href='<%=request.getContextPath()%>/notice/noticeList?page=${pageNum}'>${pageNum}&nbsp;</a>
	            </c:if>
	        	</c:forEach>
	        
	       		 <c:if test="${endPage != maxPage }">
	            <a href='<%=request.getContextPath()%>/notice/noticeList?page=${endPage+1 }'>[다음]</a>
	        	</c:if>
			</div>
</div>

<!-- Create side-bar div tag -->
<div class="side-bar">
	<!-- Create logo, search, login, mypage a tag 
		Use br tag for spacing easily -->
	<a href="<%=request.getContextPath()%>" class="logo">www.WITH.com</a>
	<br>
	<br>
	<span class="search" onclick="openNav();"><i class="fas fa-search"></i></span>
	<script>
		function openNav(){
			document.getElementById("searchSlide").style.width="280px";
		}
		function closeNav(){
			document.getElementById("searchSlide").style.width="0";
		}
	</script>
	<br>
	<br>
	<% if(logginedMember==null) {%>
	<a href="#login" class="login">Login</a>
	<%}else{ %>
	<a href="<%=request.getContextPath()%>/logout" class="login">Logout</a>
	<br>
	<br>
	<a href="<%=request.getContextPath()%>/myPage?id=<%=logginedMember.getId()%>" class="mypage">My Page</a>
	<%} %>
</div>

<script>
	// When client pressed login a tag
	$(function(){
		let LoginCount=0;
		$(".login").click(function(){
			if(LoginCount==0){
				$("#login-client").css("opacity","1");
				$("#login-client").css("width","350");
				$(".login-show").css("opacity","1");
				$("#login-client").css("z-index","10");
				$(".login-show").css("transition","10s");				
				LoginCount++;
			}else{
				$("#login-client").css("opacity","0");
				$("#login-client").css("width","1");
				$(".login-show").css("transition","0.2s");
				LoginCount=0;
			}
		});	
	})
</script>