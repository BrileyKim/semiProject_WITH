<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="join-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="joinBox">
		<!-- Have to put method and enctype if you want to let client put profile photo -->
			<form action="<%=request.getContextPath()%>/joinMemberEnd" method="post"
			enctype="multipart/form-data">
				<div id="join-essential">
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" placeholder="4글자이상" name="Id" id="Id" required oninput="checkId();"></td>
							<td><span id="chkMsg"></span></td>
						</tr>
					</table>
				</div>
				<div id="join-optional">
					<table>
					
					</table>
				</div>
			</form>
		</div>
	</section>
	<script>
		function checkId(){
			var id = $("#Id").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/checkIdDuplicate",
				type:"post",
				data:{id:id},
				sucess:data=>{
					console.log(data);
				}
			})
		}
	</script>
</body>
</html>