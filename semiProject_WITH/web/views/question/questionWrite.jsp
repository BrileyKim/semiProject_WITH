<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#questionBox{
		margin:20px auto;
		background-color:rgb(250, 247, 242); 
		width:700px;
		height:420px;
		padding:10px;
	}
	#questionfrm{
		
	}
	#upfile{
	width:230px;
	}
	table#tbl-QA{
		width: 580px; 
		border:1px black solid; 
		border-collapse: collapse;
		margin:20px auto;}
	table#tbl-QA th
	{
		border:1px solid;
		padding:5px 0;
		text-align:center;
		width:120px;
	}
	table#tbl-QA td
	{
		border:1px solid;
		padding:5px 0 5px 10px;
		text-align:left;
	}
	div#imgWrap{ width:200px;height:120px; float:right;margin-right:10px;display:inline;}
	div#imgWrap>img{width:200px;height:120px;}
	
	div#imgWrap img,label{position: absolute;} 
	
	div#imgWrap label{color:#D8D8D8; margin-top:45px;margin-left:50px;}
	#title{
		width:430px;
	}
	#questionsubmit{
		background:rgba(114, 133, 63,0.9);
		font-size:16px;
		border:1px solid rgba(0,0,0,0.3);
		border-radius:2px;
	}
	#questionreset{
		font-size:16px;
		border:1px solid rgba(0,0,0,0.3);
		border-radius:2px;
	}
</style>

</head>
<body>
<%@ include file="/views/common/header.jsp" %>
	<section id="question-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="questionBox">
			<form id="questionfrm" action="<%=request.getContextPath()%>/question/questionWriteEnd" method="post" enctype="multipart/form-data">
				<table id="tbl-QA">
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" id="title"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer" value="<%=logginedMember.getId()%>" readonly></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
							<input type="file" name="upfile" id="upfile" style="display:inline;">
							<div id="imgWrap">
								<label id="label" >미리보기 없음</label>
								<img id="img">
							</div>
						</td>
						
						
					</tr>
					
					<tr>
						<th>내용</th>
						<td><textarea name="content" rows="6" cols="53"></textarea></td>
					</tr>
					<tr>
						<th colspan="2">
							<input type="submit" id="questionsubmit" value="등록">
							<input type="reset" id="questionreset" value="취소">
						</th>
						
					</tr>
					
				</table>
			</form>
		</div>
	</section>
	<script>

$(function(){
    
    if(!$("#upfile").val()){
        $("#label").css("z-index","1");
        $("#img").css("z-index","0");
    }
	
    $("#upfile").change(function(){
    	$("#label").css("z-index","0");
        $("#img").css("z-index","1");
    })
});


$(document).ready(function(){
    $("#upfile").on("change",preview);
 });
 
 function preview(e){
    let files=e.target.files;
    let filesArr=Array.prototype.slice.call(files);
    console.log(files);
    filesArr.forEach(function(f){
       if(!f.type.match("image.*")){
          alert("확장자가 이미지 형태가 아닙니다.");
          return;
       }
       
       
       
       let reader=new FileReader();
       reader.onload=function(e){
          $("#img").attr("src",e.target.result);
       }
       reader.readAsDataURL(f);
    });
 };
</script>
	
</body>
</html>