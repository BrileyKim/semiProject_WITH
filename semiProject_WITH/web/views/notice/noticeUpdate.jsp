<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.notice.model.vo.Notice" %>
<%
	Notice n=(Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Update</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/noticeWrite.css" type="text/css">
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
	<section id="notice-container">
		<%@ include file="/views/common/sidebar.jsp" %>
  <div id="noticewritediv">
	<h2 style="text-align: center;margin:0;"><img src="<%=request.getContextPath() %>/img/gear.png" alt="">&nbsp;&nbsp;공지사항 수정</h2>
	
	<form action="#" id="updateForm"  method="post" enctype="multipart/form-data">
        <table class="tableinput" style="width:650px;" >
            <tr>
                <th>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 </th>
                <td>
                    <input type="text" id="noticetitle" name="notice_title" value="<%=n.getNoticeTitle()%>" placeholder="제목을 입력해주세요."/>
                </td>
            </tr>
            <tr>
                <th>작 성 자 </th>
                <td>
                    <input type="text" id="noticewriter" name="notice_writer" value="<%=logginedMember.getId() %>" style="border:none;"  readonly>
                </td>
            </tr>
            <tr>
                <th style="vertical-align: top;">내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용 </th>
                <td>
                    <textarea name="notice_content" rows="5" cols="50" id="noticecontent" style="resize:none;" placeholder="내용을 입력해주세요."><%=n.getNoticeContent()%></textarea>
                </td>
            </tr>
            <tr>
                <th>첨부파일</th>
				<td>
					
					
					<!-- <input type="text" id="fileload" name="fileLoad" value="새로운 파일 첨부하기" style="border:none;"   readonly>
					 -->
<!-- 					<input type="file" class="fileload" name="fileload" value="" readonly>
					<input type="file" class="fileview" name="fileview"> 
                    <input type="button" class="fileadd" name="fileadd" value="추가" > -->

					
					<input type="text" class="fileload" name="fileLoad" 
					value="<%=n.getNoticeOriginalFileName()==null?"새로운 파일을 첨부,수정 클릭":n.getNoticeOriginalFileName()%>" style="border:none;" readonly> 
					<input type="file" class="fileview" name="fileview" >
                    <button type="button" class="fileadd" name="fileadd" >수정</button>
                    <button type="button" id="filedeletebtn" name="fileDeletebtn">삭제</button>
					
				</td>
            </tr>
           
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="button" id="cancelbtn" value="취  소" onclick="cancelbutton();"/> 
                    <input type="button" id="enrollbtn" value="수 정" onclick="updatebutton();" /> 
                </td>
            </tr>
        </table>
        	<input	type="hidden" id="noticeIdx" value="<%=n.getNoticeIdx()%>">
        </form> 
  </div>
	</section>
	<script>
	$(document).ready(function(){
		$(".fileview").hide();
		let fileCount=0;
		$(".fileadd").click(function(){
			if(fileCount==0){
	    		$(".fileload").hide();
	    		$(".fileview").show();
	    		$(".fileadd").html("수정취소");

	    		fileCount++;
			}else{
				$(".fileload").show();
	    		$(".fileview").hide();
	    		$(".fileadd").html("수정");
	    		fileCount=0;
			}
		})
/* 		$(".fileview").change(function(){
	    	var file = this.files[0].name;
	    	console.log(file.name);
	    	$(".filehidden").value=file;
	    	console.log($(".filehidden"));
	    })
	    
	    $("#filedeletebtn").click(function(){
	    	var fileHidden = $(".filehidden").value;
	    	console.log(fileHidden);
	    }) */
	})

	/* $(function(){ */
		//파일에서 삭제
/*     	$(".fileadd").click(function(){
    		if($('#fileload').css('display') == 'none'){
                $('#fileload').show();
                $('#fileview').hide();
            }else{
                $('#fileload').hide();
                $('#fileview').show();
            }
    	})
    	
    	$("#filedeletebtn").click(function(){
    		document.getElementById("fileload").value="";
    		$("#fileview").css("display","none");
    	}) */
<%--     	$(".fileview").hide();
    	
    	$(".fileadd").click(function(){
    		if($(".fileview").hide()==true){
	    		$(".fileload").hide();
	    		$(".fileview").show();
	    	}else{
	    		$(".fileload").show();
	    		$(".fileview").hide();
	    	}
    	})
    	
    	let deleteClick=0;
    	$("#filedeletebtn").click(function(){
    		if(deleteClick==0){
    			$(".fileload").value="";
    			$("#filedeletebtn").value="삭제취소"
    			deleteClick++;
    		}else{
    			$(".fileload").value="<%=n.getNoticeOriginalFileName()%>";
    			deleteClick=0;
    		}
    		
    		
    	})
    	
    	
    		
	}); --%>

	 
	
	//취소버튼누르면 취소확인창 띄우게
	function cancelbutton() {
	    if (confirm("작성하신 내용은 저장되지 않습니다. 정말 취소하시겠습니까??") == true){    //확인
	    	location.replace("<%=request.getContextPath() %>/notice/noticeList");
	    }else{   //취소
	        return false;
	    }
	}
	
	function updatebutton(){
		const frm=$("#updateForm");
		const url="<%=request.getContextPath()%>/notice/noticeUpdateEnd?noticeIdx="+$("#noticeIdx").val();
		frm.attr({
			"action":url,
			"method":"post",
			"enctype":"multipart/form-data"
		});
		frm.submit();
	}
	
	function filebutton() {
/* 		if($('#fileload').css('display')=='none') {
			$('#fileload').show();
			$('#fileview').hide();
		}else {
			$('#fileload').hide();
			$('#fileview').show();
		} */
	}
	
	
	$(function() {
		let title=$("#noticetitle").val();
		let content=$("#noticecontent").val();
		if(title.trim().length==0) {
			alert("제목을 입력해주세요!");
		}else if(content.trim().length==0) {
			alert("내용을 입력해주세요!");
		}
	})
	
</script>
	
</body>
</html>