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
							<td><input type="text" placeholder="4글자이상" name="Id" id="Id" required ></td>
							<td><div id="chkMsg"></div></td>
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
		$(function(){
			var newValue;
            $("#Id").on("propertychange change keyup paste input", function() {
               newValue = $(this).val();
				$.ajax({
					url:"<%=request.getContextPath()%>/checkIdDuplicate",
					type:"get",
					data:{"id":newValue},
					dataType:"html",
					success:data=>{
						console.log(data);
						$("#chkMsg").html(data);
					}
				});
            });
		})

	</script>
</body>
</html>