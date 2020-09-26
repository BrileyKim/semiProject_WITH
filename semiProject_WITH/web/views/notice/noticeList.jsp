<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.with.notice.model.vo.Notice" %>    
<%
	List<Notice> list = (List<Notice>)request.getAttribute("notices");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	a{
		text-decoration:none;
		color:black;
	}
	*:focus { outline:none; }
	 #tablediv{
		background:rgba(114, 133, 63,0.95);
	  	width:730px;
	  	height:435px;
	  	padding:20px;
	  	margin:20px auto;
	  	text-align:center;
	} 
	.card {
		background: #ffeddf;
		border-radius: 2px;
		display: inline-block;
		width: 180px;
		height:200px;
		margin-bottom:20px;
		position: relative;
		box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
	    /* transition: all 0.1s cubic-bezier(.25,.8,.25,1); */
	}
	.card:hover {
  		/* box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22); */
  		border: orange 2px solid;
	}
	
	#writebtn{
            width:80px;
            height: 30px;
            color:black;
            border: none;
            text-align: center;
            display: inline-block;
            font-size: 16px;
            
            cursor: pointer;
            border-radius:3px;
            font-weight: bold;
            background: rgb(236, 236, 236);
            background-position:3px center;
    }
    #writebtn:hover {
        background-color: rgb(199, 197, 197);
    }
    #backtable{
    	width:730px;
    	height:420px;
    	background-color:rgb(250, 247, 242);
    	padding:0;
    	margin:auto;
    	position:fixed;
    }
</style>

</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="notice-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="tablediv">
			<table id="backtable">
			<!-- 글씨 -->
				<tr>
					<td style="padding:0; height:100px;" colspan="3">
      				<p style="font-size:38px; margin-top:20px;">공지사항</p>
    				</td>
				</tr>
  				  <!-- 게시물 -->
  				<tr>
  				<%if(!list.isEmpty()) {%>
					<%for(Notice n : list) {%>
				    	<td style="margin-top: 20px;">
				      		<div id="cardlist" style=""> 
					        	<div class="card" onclick="location.href='<%=request.getContextPath() %>/notice/noticeView?noticeIdx=<%=n.getNoticeIdx()%>'" >		
						          	<table style="width:180px;">
						            	<tr>
						              		<td colspan="2"   style="text-align: left; padding-top:20px; padding-left: 20px;">No.<%=n.getNoticeIdx() %></td>
						           	 	</tr>
						            	<tr>
						              		<td colspan="2"   style="text-align: left; padding-top:30px; padding-left: 20px; font-size:20px">
						              		<%if(n.getNoticeTitle().length()>8){ %>
						              		<%=n.getNoticeTitle().substring(0,8) %>
						              		<%}else{ %>
						              		<%=n.getNoticeTitle()%>
						              		<%} %>
						              		</td>
						            	</tr>
						            	<tr>
						              		<td style="text-align: left; padding-top:50px; padding-left: 20px;">
												<%if(n.getNoticeOriginalFileName()!=null) {%>
													<img src="<%=request.getContextPath() %>/img/clip.png" width="20" height="20"> 
												<%} %>
									  		</td>
						              		<td style="text-align: right; padding-top:50px; padding-right: 20px;">
						              			<%=n.getNoticeEnrollDate() %>
						              		</td>
						            	</tr>
						          	</table>
					        	</div>
				      		</div>
				     	</td> 
				  	<%}%>
				  </tr>
				  <%} %>
				  <tr>
    			  	<td colspan="3">
    			  		<div id="pageForm">
							<c:if test="${startPage!= 1}">
				            	<a href='<%=request.getContextPath()%>/notice/noticeList?page=${startPage-1}'>[이전]</a>
				        	</c:if>
				        	<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
				            <c:if test="${pageNum == spage}">
				                ${pageNum}&nbsp;
				            </c:if>
				            <c:if test="${pageNum != spage}">
				                <a href='<%=request.getContextPath()%>/notice/noticeList?page=${pageNum}'>${pageNum}&nbsp;</a>
				            </c:if>
				        	</c:forEach>
				        
				       		 <c:if test="${endPage != maxPage }">
				            <a href='<%=request.getContextPath()%>/notice/noticeList?page=${endPage+1 }'>[다음]</a>
				        	</c:if>
						</div>
						
	      				<%if(logginedMember!=null && logginedMember.getId().equals("admin")){ %>
	     				<button onclick="location.assign('<%=request.getContextPath()%>/notice/noticeWrite')" style="float:right; margin-top: 0;" id="writebtn">글쓰기</button>
	     				<%} %>
						
    				</td>

 				  </tr>
				<tr>
					<td colspan="3">
						<div id="searchForm">
					        <form>
					            <select name="opt">
					                <option value="0">제목</option>
					                <option value="1">내용</option>
					                <option value="2">제목+내용</option>
					                <option value="3">글쓴이</option>
					            </select>
					            <input type="text" size="20" name="condition">&nbsp;
					            <input type="submit" value="검색">
					        </form>    
				   		</div>
		   			</td>
		   		<tr>
			</table>
		</div>
	</section>
</body>
</html>