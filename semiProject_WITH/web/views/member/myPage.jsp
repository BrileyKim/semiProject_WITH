<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)request.getAttribute("member");
	String[] array= m.getAddress().split(",");
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
		margin:0 25px;
		width:300px;
		border-radius:5px;
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
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="myPage-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div class="middle-container">
			<div class="profile-box">
				<div class = profile-picture>
					<img src='<%=request.getContextPath()%>/upload/member/<%=m.getProfile()%>'/>	
						<input type="button" name="upProfile" id="upProfile" onclick="showProfileChange();"/>
				</div>
				<h1 class="user-name"><%=m.getNickname()%></h1>
				<h3 class="user-grade">회원등급 : <%=m.getGrade() %></h3>
				<h3 class="user-address">활동 지역 : <%=array[0]%></h3>
				<input type="button" value="내 정보 보기" class="user-btn"
				onclick="location.href='<%=request.getContextPath()%>/memberView?id=<%=logginedMember.getId()%>'"/>
			</div>		
		</div>
	</section>
	<script>
		function showProfileChange(){
			const url = "<%=request.getContextPath()%>/changeProfile";
			const title="프로필 바꾸기";
			const status="left=100px,top=100px,width=300px,height=240px";
			open(url,title,status);
		}
	</script>
</body>
</html>