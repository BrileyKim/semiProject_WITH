<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Notice</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/noticeWrite.css" type="text/css">

</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="notice-container">
		<%@ include file="/views/common/sidebar.jsp" %>
  		<div id="noticewritediv">
  			<h2 style="text-align: center;margin-bottom:0;margin-top:0"><img src="<%=request.getContextPath() %>/img/risk.png" alt="">&nbsp;&nbsp;공지사항 작성</h2>
		  	<form action="<%=request.getContextPath() %>/notice/noticeWriteEnd" method="post" name="inputform" enctype="multipart/form-data">
		        <table class="tableinput">
		            <tr>
		                <th>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 </th>
		                <td>
		                    <input type="text" id="noticetitle" name="notice_title" placeholder="제목을 입력해주세요."/>
		                </td>
		            </tr>
		            <tr>
		                <th>작 성 자 </th>
		                <td>
		                    <input type="text" id="noticewriter" name="notice_writer" value="<%=logginedMember.getId()%>" style="border:none;"  readonly>
		                </td>
		            </tr>
		            <tr>
		                <th style="vertical-align: top;">내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용 </th>
		                <td>
		                    <textarea name="notice_content" rows="5" cols="50" id="noticecontent" placeholder="내용을 입력해주세요."></textarea>
		                </td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
						<td><input type="file" name="notice_filepath"></td>
		            </tr>
		            
		            <tr>
		                <td style="text-align: left;">
		                    <input type="reset" id="resetbtn" value="  초기화" />
		                </td>
		                <td style="text-align: right;">
		                    <input type="button" id="cancelbtn" value="취  소" onclick="cancelbutton();"/> 
		                    <input type="submit" id="enrollbtn" value="등  록" onclick="return inputbutton();" /> 
		                </td>
		            </tr>
		        </table>
		        </form> 
		</div>
	</section>
	<script>
	
	
	//취소버튼누르면 취소확인창 띄우게
	function cancelbutton() {
	    if (confirm("작성하신 내용은 저장되지 않습니다. 정말 취소하시겠습니까??") == true){    //확인
	    	location.href="<%=request.getContextPath() %>/notice/noticeList";
	    }else{   //취소
	        return false;
	    }
	}
	
	function inputbutton(){
		const title=$("[name=notice_title]").val();
		const content=$("[name=notice_content]").val();
		if(title.trim().length==0){
			alert("제목을 입력해주세요!");
			$("[name=notice_title]");
			return false;
		}else if(content.trim().length==0){
			alert("내용을 입력해주세요!");
			$("[name=notice_content]").focus();
			return false;
		}else if(title.trim().length==0 && content.trim().length==0){
			alert("제목과 내용을 입력해주세요!");
			return false;
		}
	}
</script>
</body>
</html>