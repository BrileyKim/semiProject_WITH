<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
<%
	String msg = (String)request.getAttribute("msg");
	String loc = (String)request.getAttribute("loc");
	String script=(String)request.getAttribute("script");
%>
</head>
<body>
	<script>
		alert("<%=msg%>");
		
		if(<%=script!=null%>){
			<%=script%>
		}
		location.replace('<%=request.getContextPath()%><%=loc%>');
	</script>
</body>
</html>