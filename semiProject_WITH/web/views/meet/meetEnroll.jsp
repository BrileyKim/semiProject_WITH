<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#meetBox{
		margin:10px auto;
		width:700px;
		height:470px;
		overflow:hidden;
		background-color:rgba(250,247,242,0.8);
		text-align:center;
	}
	#enroll{
		font-size:25px;
		margin:10px;
		padding:10px;
	}
	#front{
		width:130px;
		height:130px;
		border:1px solid rgb(167,132,15);
		text-align:center;
		
	}
	#front-img{
		width:130px;
		height:130px;
	}
	#back{
		width:130px;
		height:130px;
		border:1px solid rgb(167,132,15);
		text-align:center;
	}
	#back-img{
		width:130px;
		height:130px;
	}
	#tbl-container{
		width:620px;
		height:420px;
		margin:10px auto;
	}
	#front label{color:#D8D8D8; margin-top:45px;margin-left:0;}
	#back label{color:#D8D8D8; margin-top:45px;margin-left:0;}
	.font{
		width:330px;
		font-size:18px;
	}
	#create{
		width:80px;
		height:30px;
		background-color:rgba(114,133,63,0.9);
		border-radius:2px;
		font-size:18px;
		border:1px solid rgba(0,0,0,0.5);
		margin-left:90px;
		margin-right:20px;
	}
	#reset{
		width:80px;
		height:30px;
		background-color:white;
		border-radius:2px;
		border:1px solid rgba(0,0,0,0.5);
		font-size:18px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="meet-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="meetBox">
			<label id="enroll">모임 개설</label>
	<form action="<%=request.getContextPath()%>/meet/meetEnrollEnd" method="post"
	enctype="multipart/form-data">
	<div>
	<table id="tbl-container">
		<tr>
			<th>제목</th>
			<td><input name="title" class="font" type="text" size="16"></td>
			<td rowspan="3">
				<div id="front">
					<label id="label" >미리보기</label>
					<img id="front-img" src="">
				</div>
			</td>
		</tr>
		<tr>
			<th>주최자</th>
			<td><input type="text" class="font" name="leader" value="<%=logginedMember.getId()%>" readonly size="5"></td>
		</tr>
		<tr>
			<th>모임 인원 수 &nbsp;</th>
			<td><input class="font" name="headCount" type="number" value="1" min="1" max="10"></td>
		</tr>
		<tr>
			<th>모임 설명 </th>
			<td><textarea name="content" type="textarea" cols="40" rows="8"></textarea></td>
			<td>
				<div id="back">
					<label id="label" >미리보기</label>
					<img id="back-img" src="">
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<input id="front-file" name="upFront" type="file">
				<input id="back-file" name="upBack" type="file">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input id="create" type="submit" value="개설">
				<input id="reset" type="reset" value="취소">
			</td>
		</tr>
	</table>
	</div>
	</form>
		</div>
	</section>
	<script>
	$(document).ready(function(){
		let front=$("#front-file").val();
		
	})
	$(document).ready(function(){
		$("#front-file").on("change",changeFrontImg);
	});
	
	function changeFrontImg(e){
		let files=e.target.files;
		let filesArr=Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert("확장자가 이미지 형태가 아닙니다.");
				return;
			}
			
			let reader=new FileReader();
			reader.onload=function(e){
				$("#front-img").attr("src",e.target.result);
			}
			reader.readAsDataURL(f);
		});
	};
	$("#back-file").change(function(e){
		let files=e.target.files;
		let filesArr=Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert("확장자가 이미지 형태가 아닙니다.");
				return;
			}
			
			let reader=new FileReader();
			reader.onload=function(e){
				$("#back-img").attr("src",e.target.result);
			}
			reader.readAsDataURL(f);
		});
	})
	</script>
	
</body>
</html>