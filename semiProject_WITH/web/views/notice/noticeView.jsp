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
<title>Insert title here</title>
 <style>
 a{
 	color:black;
 	text-decoration:none;
 }
  #noticeviewdiv {
	  	width:710px;
	  	height:440px;
	  	padding:20px;
	  	margin:20px auto;
		background:rgba(114, 133, 63,0.7);
		}
    *:focus { outline:none; }
        #contenttable {
            border-collapse: separate;
            border-spacing: 35px 15px;
        }
        #listbtn{
            width:100px;
            height: 35px;
            color:black;
            border: none;
            text-align: center;
            display: inline-block;
            font-size: 17px;
            margin: 4px;
            cursor: pointer;
            border-radius:10px;
            font-weight: bold;
            background: url( "img/list.png" ) no-repeat rgb(236, 236, 236);
            background-position:3px center;
        }
        #listbtn:hover {
            background-color: rgb(199, 197, 197);
        }

        #deletebtn{
            width:110px;
            height: 35px;
            color:black;
            border: none;
            text-align: center;
            display: inline-block;
            font-size: 17px;
            margin: 4px;
            cursor: pointer;
            border-radius:10px;
            font-weight: bold;
            background: url( "img/trash.png" ) no-repeat rgb(236, 236, 236);
            background-position:3px center;
        }
        #deletebtn:hover {
            background-color: rgb(255,117,97);
        }

        #updatebtn {
            width:110px;
            height: 35px;
            background-color: black;
            border: none;
            color:#fff;
            text-align: center;
            display: inline-block;
            font-size: 17px;
            margin: 4px;
            cursor: pointer;
            border-radius:10px;
            font-weight: bold;
            background: url( "img/enrollcheck3.png" ) no-repeat black;
            background-position:3px center;
        }
        #updatebtn:hover {
            background-color: rgb(64,114,175);
        }
  </style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
	<section id="notice-container">
		<%@ include file="/views/common/sidebar.jsp" %>
			<div id="noticeviewdiv">
				<form  method="post" enctype="multipart/form-data">
			        <table style="margin-left: auto; margin-right: auto;">
		        <!-- 글씨 -->

		        <!-- 제목,작성자,내용,첨부파일 -->
		        <tr>
		            <td colspan="2">
		                <table id="contenttable" width="600px">
		                    
		                    <tr>
		                        <td>제목</td>
		                        <td><input type="text" id="noticetitle"  name="noticeTitle" value="<%=n.getNoticeTitle() %>" readonly style="border: none; outline:none; width:425px;
		            height: 32px;
		            font-size: 14px;"/></td>
		                    </tr>
		                    <tr>
		                        <td>작성자</td>
		                        <td><input type="text" id="noticewriter" name="noticeWriter" value="<%=n.getNoticeWriter() %>" readonly style="border: none; outline:none; width:425px;
		            height: 32px;
		            font-size: 14px;"/></td>
		                    </tr>
		                    <tr>
		                        <td>첨부파일</td>
		                        <td>
			           		<%if(n.getNoticeOriginalFileName()!=null){ %>
						 		<a href="javascript:fn_fileDownload('<%=n.getNoticeOriginalFileName()%>','<%=n.getNoticeRenamedFileName()%>');">
							 		<img src="<%=request.getContextPath() %>/img/file.png" style="width:20px;height:20px;margin-left:20px;">
							 		<%=n.getNoticeOriginalFileName() %>
						 		</a>
						 		<script>
						 			function fn_fileDownload(oriname,rename){
						 				const url="<%=request.getContextPath()%>/notice/noticeFileDown";
						 				let oName=encodeURIComponent(oriname);
						 				location.assign(url+'?oName='+oName+'&rName='+rename);
						 			}
						 		</script>
						 	<%} %>
			            		</td>
		                    </tr>
		                    <tr>
		                        <td>내용</td>
		                        <td><textarea name="noticeContent" rows="5" cols="50" id="noticecontent" readonly style="border: none; outline:none; resize: none; resize: none;
		            width:425px;
		            height: 200px;
		            font-size: 16px;"><%=n.getNoticeContent() %></textarea></td>
		                    </tr>
			                    
			                </table>
	            </td>
	        </tr>
		    <tr>	     	
		        	<td style="text-align: left;">
		        		<input type="button" value="목록" id="listbtn" onclick="history.back()">
	                
	            	</td>
	            	<td style="text-align: center;">
		                <%if(logginedMember!=null && logginedMember.getId().equals("admin")){ %>
		        			<input type="button" id="updatebtn" value="수정" onclick="location.href='<%=request.getContextPath()%>/notice/noticeUpdate?noticeIdx=<%=n.getNoticeIdx()%>'">
		                	<input type="button" id="deletebtn" value="삭제" onclick="btn_notice_delete();">
		            
		            	<%} %>
	            	</td>    

		        </tr>
		    </table>
	    </form>
    </div>
	</section>
	  <script>
  function btn_notice_delete(){
		if(confirm("삭제하면 복구할 수 없습니다. 정말 삭제하시겠습니까?")){ 
			location.replace('<%=request.getContextPath()%>/notice/deleteNotice?noticeIdx=<%=n.getNoticeIdx()%>');
		}
	}

  </script>
</body>
</html>