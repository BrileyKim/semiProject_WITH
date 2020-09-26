<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Walk Write</title>
<style>
	#walkBox{
		margin:20px auto;
		background-color:rgb(250, 247, 242); 
		width:700px;
		height:420px;
		padding:10px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="walk-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="walkBox">
			<form id="walkfrm" action="<%=request.getContextPath()%>/walk/walkAddEnd" method="post" enctype="multipart/form-data">
				<table id="tbl-Walk">
					<tr>
						<td>아이콘</td>
						<td><input type="button" value="선택하기" onclick="window.open('<%=request.getContextPath()%>/iconChoose','아이콘 선택하기','top=20, right=20, width=300, height=300')"></td>
					</tr>
				</table>
			</form>
		</div>
	</section>
<script>
	function fn_icon_choose(){
		const = url=""
	}

</script>
</body>
</html>