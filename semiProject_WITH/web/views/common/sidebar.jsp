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
</style>
<!-- Create login box -->
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

<!-- Create side-bar div tag -->
<div class="side-bar">
	<!-- Create logo, search, login, mypage a tag 
		Use br tag for spacing easily -->
	<a href="<%=request.getContextPath()%>" class="logo">www.WITH.com</a>
	<br>
	<br>
	<a href="#search" class="search"><i class="fas fa-search"></i></a>
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