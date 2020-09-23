<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.dog.model.vo.Dog" %>
<%	
		Dog d = (Dog)request.getAttribute("dog");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<style>
	.middle-container{
		/* background-color:rgba(250,247,242,0.7); */
		background-color:rgba(114,133,63,0.79);
		margin:20px 20px;
		width:290px;
		border-radius:5px;
		display:inline-block;
	}
	.profile-box{
		height:350px;
		text-align:center;
	}
	.profile-picture{
		text-align:center;
	}
	.profile-picture>img{
		margin-top:25px;
		border-radius:50%;
		width:100px;
		height:100px;
	}
	.user-name{
		margin:25px 0 16px;
		text-align:center;
	}
	.profile-description{
		width:210px;
		margin:0 auto;
		text-align:center;
	}
	.user-btn{
		font-size:17px;
		boder-radius:5px;
		background-color:white;
		border:1px solid rgba(250,247,242,0.7);
	}
	#upProfile{
		margin:0;
		position:absolute;
		top:110px;
		left:140px;
		opacity:0;
		width:80px;
		height:80px;
	}
	.myPageDog-container{
		width:450px;
		height:250px;
		background-color:#fff;
		background: linear-gradient(#f8f8f8, #fff);
  		box-shadow: 0 8px 16px -8px rgba(0,0,0,0.4);
 		border-radius: 6px;
  		overflow: hidden;
  		position: absolute;
  		margin: 20px 20px;
  		display:inline-block;
	}
	.center {
	  position: absolute;
	  top: 50%;
	  left: 50%;
	  -webkit-transform: translate(-50%, -50%);
	  font-size:19px;
	  color:rgb(255,255,255);
	}
	.myPageDog-container h1{
		text-align:center;
	}
	.myPageDog-container .additional{
		position:absolute;
		width:150px;
		height:100%;
		background: linear-gradient(#E17561, #E17561);
 		transition: width 0.4s;
  		overflow: hidden;
 	 	z-index: 2;
	}
	.myPageDog-container:hover .additional{
		width:100%;
		border-radius:0 5px 5px 0;
	}
	.myPageDog-container .additional .user-card{
		width:150px;
		height:100%;
		position:relative;
		float:left;
	}
	.myPageDog-container .additional .more-info {
	  width: 300px;
	  float: left;
	  position: absolute;
	  left: 150px;
	  height: 100%;
	}
	
	.myPageDog-container .additional .more-info h1 {
	  color: #fff;
	  margin-bottom: 0;
	}
	
	.myPageDog-container .additional .coords {
	  margin: 0 1rem;
	  color: #fff;
	  font-size: 1rem;
	}
	.myPageDog-container .additional .coords span + span {
  		float: right;
	}
	.myPageDog-container .additional .status {
	  font-size: 2rem;
	  display: flex;
	  position: absolute;
	  bottom: 1rem;
	  left: 1rem;
	  right: 1rem;
	  top: auto;
	  color: #fff;
	}
	.myPageDog-container .additional .status > div {
	  flex: 1;
	  text-align: center;
	}
	.myPageDog-container .additional .status > div > input[type="button"] {
		font-size:17px;
		boder-radius:5px;
		background-color:white;
		border:1px solid rgba(250,247,242,0.7);
	}
	.myPageDog-container .general {
	  width: 300px;
	  height: 100%;
	  position: absolute;
	  top: 0;
	  right: 0;
	  z-index: 1;
	  box-sizing: border-box;
	  padding: 1rem;
	  padding-top: 0;
	}
	
	.myPageDog-container .general .more {
	  position: absolute;
	  bottom: 1rem;
	  right: 1rem;
	  font-size: 0.9em;
	}
	
	
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="myPage-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div class="middle-container">
			<div class="profile-box">
				<div class = profile-picture>
					<img src='<%=request.getContextPath()%>/upload/member/<%=logginedMember.getProfile()%>'/>	
						<input type="button" name="upProfile" id="upProfile" onclick="showProfileChange();"/>
				</div>
				<h1 class="user-name"><%=logginedMember.getNickname()%></h1>
				<h3 class="user-grade">회원등급 : <%=logginedMember.getGrade() %></h3>
				<h3 class="user-address">활동 지역 : <%=logginedMember.getAddress()%></h3>
				<input type="button" value="내 정보 보기" class="user-btn"
				onclick="location.href='<%=request.getContextPath()%>/memberView?id=<%=logginedMember.getId()%>'"/>
			</div>		
		</div>
		<%if(d==null) {%>
		<div class="myPageDog-container">
			<div class="additional">
				<div class="user-card">
					<div class="level center">
						<!-- #WITH들어가는 곳 -->
					</div>
				</div>
				<div class="more-info">
					<h1></h1>
					<div class="coords">
					<!-- 강아지 사진 -->
						<a href="<%=request.getContextPath()%>/addDog?id=<%=logginedMember.getId()%>">
						<img src="<%=request.getContextPath()%>/img/plus.jpg"
						style="width:100px;height:100px;margin-left:10px; margin-top:45px;"/>
						</a>
					</div>
					<div class="status">
						<div>
							<!--<input type="button" value="자세히 보기"/>  -->
						</div>
						<div>
							<!--<input type="button" value="수정하기"/>-->
						</div>
					</div>
				</div>
			</div>
			<div class="general">
				<h1>이름</h1>
				<p>견종</p>
				<p>나이</p>
				<p>중성화</p>
				<span class="more" style="color:red">※마우스를 올려보세요</span>
			</div>
		</div>
		<%}else{ %>
		<div class="myPageDog-container">
			<div class="additional">
				<div class="user-card">
					<div class="level center">
						# WITH
					</div>
				</div>
				<div class="more-info">
					<h1><%=d.getDogName() %></h1>
					<div class="coords">
					<!-- 강아지 사진 -->
						
						<img src="<%=request.getContextPath()%>/upload/dog/<%=d.getDogProfile()%>"
						style="width:170px;height:120px;margin-left:50px; margin-top:10px;"/>
						
					</div>
					<div class="status">
						<div>
							<input type="button" value="상세보기" onclick="fn_update_submit();"/>
						</div>
						<div>
							<input type="button" value="삭제하기" onclick="fn_delete_dog();"/>
						</div>
					</div>
				</div>
			</div>
			<div class="general">
				<h1><%=d.getDogName()%></h1>
				<p>견종 : <%=d.getDogBreed2() %></p>
				<p>생일 : <%=d.getDogBirth().substring(0, 10)%></p>
				<p>중성화 : <%if(d.getDogNeuter().equals("Y")){%>
							중성
						<%}else{ %>
							미중성
						<%} %>
				</p>
				<span class="more" style="color:red">※마우스를 올려보세요</span>
			</div>
		</div>
		
		
		<%} %>
	</section>
	<script>
		function showProfileChange(){
			const url = "<%=request.getContextPath()%>/changeProfile";
			const title="프로필 바꾸기";
			const status="left=100px,top=100px,width=300px,height=240px";
			open(url,title,status);
		}
		
		function fn_update_submit(){
			location.replace('<%=request.getContextPath()%>/dog/updateDog?id=<%=logginedMember.getId()%>');
		}
		
		function fn_delete_dog(){
			location.replace('<%=request.getContextPath()%>/dog/deleteDog?id=<%=logginedMember.getId()%>');
		}
	</script>
</body>
</html>