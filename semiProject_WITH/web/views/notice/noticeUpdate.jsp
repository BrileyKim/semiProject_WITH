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
					<%if(n.getNoticeOriginalFileName()==null) {%>
					
					<input type="text" id="fileload" name="fileLoad" value="" style="border:none;display:none;"   readonly>
					
					<input type="file" id='fileview' name="fileView" style="display: none;">
                    
                    
                    <input type="button" class="fileadd" name="fileadd" value="추가/삭제" onclick="filebutton" style="display:none;">
                    
                
                    
                    
					<%}else { %>
					<input type="text" id="fileload" name="fileLoad" value="<%=n.getNoticeOriginalFileName()%>" style="border:none; display:none;" readonly>
                    
					<input type="file" id='fileview' name="fileView" style="display: none;">
                    
                    <input type="button" class="fileadd" name="fileadd" value="수정" onclick="filebutton"  style="display:none;">
                    <input type="button" id="filedeletebtn" name="fileDeletebtn" value="삭제"/>
                    
					<%} %>	
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
	

	$(function(){
		//파일에서 삭제
    	$(".fileadd").click(function(){
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
    	})
    	
    		
	});
	 
	
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
		});
		frm.submit();
	}
	
	function filebutton() {
		if($('#fileload').css('display')=='none') {
			$('#fileload').show();
			$('#fileview').hide();
		}else {
			$('#fileload').hide();
			$('#fileview').show();
		}
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