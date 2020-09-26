<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.with.meet.model.vo.Meet" %>
<%
	List<Meet> list = (List<Meet>)request.getAttribute("list");
%>
<style>
#first{
			width:200px;
			height:250px;
			position:absolute;
			left:70px;
			top:130px;
		}
		#second{
			width:200px;
			height:250px;
			position:absolute;
			left:370px;
			top:130px;
		}
		#third{
			width:200px;
			height:250px;
			position:absolute;
			left:670px;
			top:130px;
		}
		.first-img{
			height:100%;
			width:100%;
			left:0px;
			top:0px;
			position:absolute;
		}
		#nothing{
			width:100%;
			height:100%;
			border:1px blus solid;
			box-shadow:3px 3px 5px lightgray;
			background-color:white;
			font-size:64px;
			font-weight:100;
			color:gray;
			border-radius:3px;
			cursor:pointer;
		}
		#nothing i{
			position:absolute;
			left:70px;
			top:95px;
		}
		.front{
		position:absolute;
		top:0px;
		left:0px;
		width:100%;
		height:100%;
		transition: all 3s;
		backface-visibility:hidden;
		z-index:2;
		border-radius:3px;
		-webkit-transform:rotateY(0deg); 
		-webkit-transform-style: preserve-3d;
		transform:rotateY(0deg); 
		transform-style: preserve-3d;
		overflow:hidden;
		box-shadow: -60px 0px 100px -90px #000000,
			60px 0px 100px -90px #000000;
	}
	.back{
		border-radius:3px;
		top:0px;
		left:0px;
		width:100%;
		height:100%;
		z-index:1;
		transform:rotateY(-180deg);
		transfrom-style:preserve-3d;
		-webkit-transform:rotateY(-180deg); 
		-webkit-transform-style:preserve-3d;
		transition: all 3s;
		box-shadow: -60px 0px 100px -90px #000000,
			60px 0px 100px -90px #000000;
		cursor:pointer;
		overflow:hidden;
	}
</style>
<i id="icon-dog" class="fas fa-dog"></i>
<label id="my-meet-title">&nbsp; 내 모임</label>
<div id="first">
	<% if(!(list.size()>0)){ %>
		<div id="nothing" onclick="location.replace('<%=request.getContextPath()%>/meet/meetEnroll');">
			<i class="fas fa-plus"></i>
		</div>
	<%}else{ %>
	<form id="frm-first" action="<%=request.getContextPath()%>/meet/meetView?meet_idx=<%=list.get(0).getIdx()%>"method="post">
		<div id="first-front" class="front">
			<img class="first-img" src="<%=request.getContextPath()%>/upload/meet/<%=list.get(0).getFrontRename()%>">
			<label class="first-title"><%=list.get(0).getTitle() %></label>
			<input type="hidden" name="firstMeet" value="<%=list.get(0).getTitle() %>">
		</div>
		<div id="first-back" class="back">
			<img class="first-img" src=<%=request.getContextPath()%>/upload/meet/<%=list.get(0).getBackRename()%>>
			<label class="meet-content"><%=list.get(0).getContent() %></label>
		</div>
	</form>
	<%} %>
</div>

<div id="second">
	<%if(!(list.size()>1)) {%>
		<div id="nothing" onclick="location.replace('<%=request.getContextPath()%>/meet/meetEnroll');">
			<i class="fas fa-plus"></i>
		</div>
	<%}else {%>
	<form id="frm-second" action="<%=request.getContextPath()%>/meet/meetView?meet_idx=<%=list.get(1).getIdx()%>"method="post">
		<div id="second-front" class="front">
			<img class="first-img" src="<%=request.getContextPath()%>/upload/meet/<%=list.get(1).getFrontRename()%>">
			<label class="first-title"><%=list.get(1).getTitle() %></label>
		</div>
		<div id="second-back" class="back">
			<img class="first-img" src=<%=request.getContextPath()%>/upload/meet/<%=list.get(1).getBackRename()%>>
			<label class="meet-content"><%=list.get(1).getContent() %></label>
		</div>
	</form>	
	<%} %>
</div>	
<div id="third">
	<%if(!(list.size()>2)) {%>
		<div id="nothing" onclick="location.replace('<%=request.getContextPath()%>/meet/meetEnroll');">
			<i class="fas fa-plus"></i>
		</div>
	<%}else {%>
	<form id="frm-third" action="<%=request.getContextPath()%>/meet/meetView?meet_idx=<%=list.get(2).getIdx()%>"method="post">
		<div id="third-front" class="front">
			<img class="first-img" src="<%=request.getContextPath()%>/upload/meet/<%=list.get(2).getFrontRename()%>">
			<label class="first-title"><%=list.get(2).getTitle() %></label>
		</div>
		<div id="third-back" class="back">
			<img class="first-img" src=<%=request.getContextPath()%>/upload/meet/<%=list.get(2).getBackRename()%>>
			<label class="meet-content"><%=list.get(2).getContent() %></label>
		</div>
	</form>
	<%} %>
</div>
<script>
$(function(){
	$("#first-front").click(function(){
		$("#frm-first").submit();
	});
	$("#first-back").click(function(){
		$("#frm-first").submit();
	})
});
$(function(){
	$("#second-front").click(function(){
		$("#frm-second").submit();
	});
	$("#second-back").click(function(){
		$("#frm-second").submit();
	})
});
$(function(){
	$("#third-front").click(function(){
		$("#frm-third").submit();
	});
	$("#third-back").click(function(){
		$("#frm-third").submit();
	})
});
$(function(){
	$("#first").hover(function(){
		$("#first-front").css("z-index","1");
		$("#first-front").css("transform","rotateY(180deg)");
		$("#first-back").css("z-index","2");
		$("#first-back").css("transform","rotateY(0deg)");
	},
	function(){
		$("#first-front").css("z-index","2");
		$("#first-front").css("transform","rotateY(0deg)");
		$("#first-back").css("z-index","1");
		$("#first-back").css("transform","rotateY(-180deg)");
	})
});
$(function(){
	$("#second").hover(function(){
		$("#second-front").css("z-index","1");
		$("#second-front").css("transform","rotateY(180deg)");
		$("#second-back").css("z-index","2");
		$("#second-back").css("transform","rotateY(0deg)");
	},
	function(){
		$("#second-front").css("z-index","2");
		$("#second-front").css("transform","rotateY(0deg)");
		$("#second-back").css("z-index","1");
		$("#second-back").css("transform","rotateY(-180deg)");
	})
});

$(function(){
	$("#third").hover(function(){
		$("#third-front").css("z-index","1");
		$("#third-front").css("transform","rotateY(180deg)");
		$("#third-back").css("z-index","2");
		$("#third-back").css("transform","rotateY(0deg)");
	},
	function(){
		$("#third-front").css("z-index","2");
		$("#third-front").css("transform","rotateY(0deg)");
		$("#third-back").css("z-index","1");
		$("#third-back").css("transform","rotateY(-180deg)");
	})
});
</script>