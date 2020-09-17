<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String authNum = (String)request.getAttribute("authNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<div id="checkEmail-container">
		<input type="text" id="emailNum">
		<button type="button" id="chk-email-btn" style="color:gray;">인증번호 입력</button>
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
					alert("인증완료");
					self.close();
				}else{
					alert("틀린번호 입니다. 인증번호를 다시 입력해주세요.");
					$("#emailNum").val()="";
					return false;
				}
			}
		})
	})
</script>
</html>