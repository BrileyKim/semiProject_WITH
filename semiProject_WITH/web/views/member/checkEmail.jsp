<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String authNum = (String)request.getAttribute("authNum");
	String email = (String)request.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@500&display=swap" rel="stylesheet">
<style>
	#checkEmail-container{
		text-align:center;
		font-family:"Noto Serif KR";
	}
</style>
</head>
<body>
	<div id="checkEmail-container">
		<br>
		<span>작성하신 이메일에 발송된</span>
		<br>
		<span>인증번호를 입력해주세요.</span>
		<br>
		<br>
		<input type="text" id="emailNum">
		<button type="button" id="chk-email-btn" style="color:gray;">인증번호 입력</button>
		<span id="here"></span>
	</div>
</body>

<script>
	$(function(){
		$("#chk-email-btn").click(function(){
			const number = $("#emailNum").val();
			if(number==null){
				alert("인증번호를 입력하세요.")
				return false;
			}else{
				if(number==<%=authNum%>){
					alert("인증되었습니다.");
					$(opener.document).find("#envelope").css("color","green");
					self.close();
				}else{
					alert("틀린번호 입니다. 인증번호를 다시 입력해주세요.");
					$("#emailNum").val()="";
					$("#here").append("메일이 발송되지 않았다면 메일 주소를 다시 확인해주세요.");
					return false;
				}
			}
		})
	})
</script>
</html>