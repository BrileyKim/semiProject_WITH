<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.with.dog.model.vo.Dog, com.with.walk.model.vo.Walk,java.util.List,com.with.walk.model.vo.WalkAccept" %>
<%	
		Dog d = (Dog)request.getAttribute("dog");
		List<Walk> list = (List<Walk>)request.getAttribute("walk1");
		List<WalkAccept> list2=(List<WalkAccept>)request.getAttribute("walkAccepts");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<style>
	.middle-container{
		/* background-color:rgba(250,247,242,0.7); */
		background-color:rgba(114,133,63,0.79);
		margin-left:80px;
		margin-top:20px;
		margin-bottom:20px;
		margin-right:40px;
		width:370px;
		height:390px;
		border-radius:5px;
		display:inline-block;
	}
	.profile-box{
		height:350px;
		text-align:center;
	}
	.profile-picture{
		text-align:center;
	}
	.profile-picture>img{
		margin-top:25px;
		border-radius:50%;
		width:120px;
		height:120px;
	}
	.user-name{
		margin:25px 0 16px;
		text-align:center;
	}
	.profile-description{
		width:210px;
		margin:0 auto;
		text-align:center;
	}
	.user-btn{
		font-size:17px;
		boder-radius:5px;
		background-color:white;
		border:1px solid rgba(250,247,242,0.7);
		margin-right:15px;
		margin-top:5px;
	}
	#upProfile{
		margin:0;
		position:absolute;
		top:110px;
		left:140px;
		opacity:0;
		width:80px;
		height:80px;
	}
	.myPageDog-container{
		width:570px;
		height:290px;
		background-color:#fff;
		background: linear-gradient(#f8f8f8, #fff);
  		box-shadow: 0 8px 16px -8px rgba(0,0,0,0.4);
 		border-radius: 6px;
  		overflow: hidden;
  		position: absolute;
  		margin: 20px 20px;
  		display:inline-block;
	}
	.center {
	  position: absolute;
	  top: 50%;
	  left: 50%;
	  -webkit-transform: translate(-50%, -50%);
	  font-size:19px;
	  color:rgb(255,255,255);
	}
	.myPageDog-container h1{
		text-align:center;
	}
	.myPageDog-container .additional{
		position:absolute;
		width:150px;
		height:100%;
		background: linear-gradient(#E17561, #E17561);
 		transition: width 0.4s;
  		overflow: hidden;
 	 	z-index: 2;
	}
	.myPageDog-container:hover .additional{
		width:100%;
		border-radius:0 5px 5px 0;
	}
	.myPageDog-container .additional .user-card{
		width:150px;
		height:100%;
		position:relative;
		float:left;
	}
	.myPageDog-container .additional .more-info {
	  width: 300px;
	  float: left;
	  position: absolute;
	  left: 150px;
	  height: 100%;
	}
	
	.myPageDog-container .additional .more-info h1 {
	  color: #fff;
	  margin-bottom: 0;
	}
	
	.myPageDog-container .additional .coords {
	  margin: 0 1rem;
	  color: #fff;
	  font-size: 1rem;
	}
	.myPageDog-container .additional .coords span + span {
  		float: right;
	}
	.myPageDog-container .additional .status {
	  font-size: 2rem;
	  display: flex;
	  position: absolute;
	  bottom: 1rem;
	  left: 1rem;
	  right: 1rem;
	  top: auto;
	  color: #fff;
	}
	.myPageDog-container .additional .status > div {
	  flex: 1;
	  text-align: center;
	}
	.myPageDog-container .additional .status > div > input[type="button"] {
		font-size:17px;
		boder-radius:5px;
		background-color:white;
		border:1px solid rgba(250,247,242,0.7);
	}
	.myPageDog-container .general {
	  width: 360px;
	  height: 100%;
	  position: absolute;
	  top: 0;
	  right: 0;
	  z-index: 1;
	  box-sizing: border-box;
	  padding: 1rem;
	  padding-top: 0;
	}
	
	.myPageDog-container .general .more {
	  position: absolute;
	  bottom: 1rem;
	  right: 1rem;
	  font-size: 0.9em;
	}

	
	.walk-container{
		width:1060px;
		height:300px;
		background-color:rgba(250,247,242,0.7);
		margin:20px auto;
		/* border:1px solid black; */
		border-radius:3px;
		padding:10px;
	}
	.walk-container h2{
		margin-top:0;
	}
		::-webkit-scrollbar{width: 15px;}
	::-webkit-scrollbar-track {background-color:#f1f1f1;}
	::-webkit-scrollbar-thumb {background-color:rgba(237,165,65,0.8);}
	::-webkit-scrollbar-thumb:hover {background: rgba(0,0,0,0.5);}
	::-webkit-scrollbar-button:start:decrement,::-webkit-scrollbar-button:end:increment {
	width:16px;height:16px;background:rgba(237,165,65,0.8);} 
	
	.cal_top{
		text-align:center;
		margin-top:30px;
		margin-bottom:20px;
		color:black;
		
		font-size:1.5em;
	}
	.cal_top a, span{
		padding-top:10px;
		color:black;
	}
	#cal_tab{
		margin-right:15px;
		margin-top:15px;
		float:right;
	}
	.calendar_sidebar{
		float:left;
		background-color:rgba(0,0,0,0.3);
		width:330px;
		height:450px;
		margin-left:50px;
		margin-top:20px;
		border-radius:3px;
	}
	.meet-container{
		float:right;
		position:absolute;
		right:170px;
		top:410px;
		width:580px;
		background-color:rgba(209,185,121,0.7);
		border-radius:2px;
		text-align:center;
		overflow: hidden;
	}
	
	.meet-container a{
		text-decoration:black;
		color:black;
	}
	.day{
		width:140px;
		height:100px;
	}
	#calTbl{
		
		text-align:center;
		font-size:22px;
	}
	.bottom{
	margin:20px auto;
	width:990px;
	padding-top:20px;
	}
	#walk-calendar{
		width:1060px;
		height:300px;
		margin:20px auto;
		border:1px black solid;
		border-radius:5px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="myPage-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div class="middle-container">
			<div class="profile-box">
				<div class = profile-picture>
					<img src='<%=request.getContextPath()%>/upload/member/<%=logginedMember.getProfile()%>'/>	
						<input type="button" name="upProfile" id="upProfile" onclick="showProfileChange();"/>
				</div>
				<h1 class="user-name"><%=logginedMember.getNickname()%></h1>
				<h3 class="user-grade">회원등급 : <%=logginedMember.getGrade() %></h3>
				<h3 class="user-address">활동 지역 : <%=logginedMember.getAddress().split(",")[0]%></h3>
				<input type="button" value="정보보기" class="user-btn"
				onclick="location.href='<%=request.getContextPath()%>/memberView?id=<%=logginedMember.getId()%>'"/>
				<input type="button" class ="user-btn" value="탈퇴하기">
			</div>		
		</div>
		<%if(d==null) {%>
		<div class="myPageDog-container">
			<div class="additional">
				<div class="user-card">
					<div class="level center">
						<!-- #WITH들어가는 곳 -->
					</div>
				</div>
				<div class="more-info">
					<h1></h1>
					<div class="coords">
					<!-- 강아지 사진 -->
						<a href="<%=request.getContextPath()%>/addDog?id=<%=logginedMember.getId()%>">
						<img src="<%=request.getContextPath()%>/img/plus.jpg"
						style="width:150px;height:150px;margin-left:10px; margin-top:60px;"/>
						</a>
					</div>
					<div class="status">
						<div>
							<!--<input type="button" value="자세히 보기"/>  -->
						</div>
						<div>
							<!--<input type="button" value="수정하기"/>-->
						</div>
					</div>
				</div>
			</div>
			<div class="general">
				<h1>이름</h1>
				<p>견종</p>
				<p>나이</p>
				<p>중성화</p>
				<span class="more" style="color:red">※마우스를 올려보세요</span>
			</div>
		</div>
		<%}else{ %>
		<div class="myPageDog-container">
			<div class="additional">
				<div class="user-card">
					<div class="level center">
						# WITH
					</div>
				</div>
				<div class="more-info">
					<h1><%=d.getDogName() %></h1>
					<div class="coords">
					<!-- 강아지 사진 -->
						
						<img src="<%=request.getContextPath()%>/upload/dog/<%=d.getDogProfile()==null?"with20200921_193036_167.png":d.getDogProfile()%>"
						style="width:170px;height:120px;margin-left:50px; margin-top:10px;"/>
						
					</div>
					<div class="status">
						<div>
							<input type="button" value="상세보기" onclick="fn_update_submit();"/>
						</div>
						<div>
							<input type="button" value="삭제하기" onclick="fn_delete_dog();"/>
						</div>
					</div>
				</div>
			</div>
			<div class="general">
				
				<h1><%=d.getDogName()%></h1>
				<p>견종 : <%=d.getDogBreed2() %></p>
				<p>생일 : <%=d.getDogBirth().substring(0, 10)%></p>
				<p>
					성별 : <%=d.getDogGender().equals("F")?"여":"남"%>
				</p>
				<p>중성화 : <%if(d.getDogNeuter().equals("Y")){%>
							중성
						<%}else{ %>
							미중성
						<%} %>
				</p>
				<p>
					몸무게 : <%=d.getDogWeight()%> kg
				</p>
				<span class="more" style="color:red">※마우스를 올려보세요</span>
			</div>
		</div>
		
		
		<%} %>
		
		<div class="meet-container">
			<a href="#"><h2>내 모임 관리하기</h2></a>
		</div>
		
		<div class="walk-container">
			<h2>현재 참여 중인 산책</h2>
			<table>
				<tr>
					
					<td>내가 대표인 산책이 <%=!list.isEmpty()?list.size():0%>개 있습니다.</td>
				</tr>
				<!-- 이부분 계속 null뜸 -->
				<%if(!list2.isEmpty()){
					for(WalkAccept wa : list2) {
						if(wa.getAcceptCheck().equals("미처리")){%>
				
				<tr>
					<td>산책 번호 <%=wa.getAcceptWalkIdx()%>에서 <%=wa.getAcceptMemberId()%>님의 신청을 수락하시겠습니까?</td>

				</tr>
				<tr>
					<td>
						<form action="<%=request.getContextPath()%>/walk/memberJoinEnd">
							<input type="radio" id="ok" name="accept_check" value="Y">
							<label for="ok">수락</label>
							<input type="radio" id="no" name="accept_check" value="N">
							<label for="no">거절</label>
							<input type="hidden" name="accept_walk_idx" value="<%=wa.getAcceptWalkIdx()%>">
							<input type="hidden" name="accept_member_id" value="<%=wa.getAcceptMemberId()%>">
							<input type="submit" id="submitBtn" value="확정하기">
						</form>
					</td>
				</tr>
				<%}
				} 
			}else{%> 
				<tr>
					<td>새로운 산책 참여 신청이 없습니다.</td>
				</tr>
			<% }%> 
			</table>
			
		
<!-- 			<div class="cal_top">
                <a href="#" id="movePrevMonth"><span id="prevMonth" class="cal_tit">&lt;</span></a>
                <span id="cal_top_year"></span>
                <span id="cal_top_month"></span>
                <a href="#" id="moveNextMonth"><span id="nextMonth" class="cal_tit">&gt;</span></a>
            </div>
            <div class="calendar_sidebar">
            
            </div>
            <div id="cal_tab" class="cal">
            
            </div> -->
		
<!-- 		<div id="walk-calendar">
			<div class="top" style="text-align:center;">
				<h2> 2020년 10월의 산책</h2>
			</div>
			<div class="bottom">
				<table id="calTbl">
					<tr>
						<th style="color:#dc2742"><div class="day" id="sun">일</div></th>
						<th><div class="day" id="mon">월</div></th>
						<th><div class="day">화</div></th>
						<th><div class="day">수</div></th>
						<th><div class="day">목</div></th>
						<th><div class="day">금</div></th>
						<th style="color:blue"><div class="day">토</div></th>
					</tr>
					<tr>
						<td style="color:#dc2742"></td>
						<td></td>
						<td></td>
						<td></td>
						<td><div class="day" id="1">1</div></td>
						<td><div class="day" id="2">2</div></td>
						<td style="color:blue"><div class="day" id="3">3</div></td>
					</tr>
					<tr>
						<td style="color:#dc2742"><div class="day" id="4">4</div></td>
						<td><div class="day" id="5">5</div></td>
						<td><div class="day" id="6">6</div></td>
						<td><div class="day" id="7">7</div></td>
						<td><div class="day" id="8">8</div></td>
						<td><div class="day" id="9">9</div></td>
						<td style="color:blue"><div class="day" id="10">10</div></td>
					</tr>
					<tr>
						<td style="color:#dc2742"><div class="day" id="11">11</div></td>
						<td><div class="day" id="12">12</div></td>
						<td><div class="day" id="13">13</div></td>
						<td><div class="day" id="14">14</div></td>
						<td><div class="day" id="15">15</div></td>
						<td><div class="day" id="16">16</div></td>
						<td style="color:blue"><div class="day" id="17">17</div></td>
					</tr>
					<tr>
						<td style="color:#dc2742"><div class="day" id="18">18</div></td>
						<td><div class="day" id="19">19</div></td>
						<td><div class="day" id="20">20</div></td>
						<td><div class="day" id="21">21</div></td>
						<td><div class="day" id="22">22</div></td>
						<td><div class="day" id="23">23</div></td>
						<td style="color:blue"><div class="day" id="24">24</div></td>
					</tr>
					<tr>
						<td style="color:#dc2742"><div class="day" id="25">25</div></td>
						<td><div class="day" id="26">26</div></td>
						<td><div class="day" id="27">27</div></td>
						<td><div class="day" id="28">28</div></td>
						<td><div class="day" id="29">29</div></td>
						<td><div class="day" id="30">30</div></td>
						<td style="color:blue"><div class="day" id="31">31</div></td>
					</tr>
				
				</table>
			</div>
		
		</div> -->
	</section>
<%-- 	<%if(!list.isEmpty()) {
		int i=0;
		for(i=0;i<list.size();i++){
			%>
			<input type="hidden" class="chkMon" id="<%=list.get(i).getWalkDate().substring(6,8)%>">
			<input type="hidden" class="chkDay" id="<%=list.get(i).getWalkDate().substring(8,10)%>">
	<%	}
	} %> --%>
	<script>
/* 	$(document).ready(function(){
		var days = document.getElementsByClassName("day");
		for(var i=0;i<days.length;i++){
			var day = days.item(i);
			console.log(day.id);

			}
		var chkMons = document.getElementsByClassName("chkMon");
		for(var j=0;j<chkMons.length;j++){
			console.log(chkMons.id);
		}
	}) */
	    /* var today = null;
	    var year = null;
	    var month = null;
	    var firstDay = null;
	    var lastDay = null;
	    var $tdDay = null;
	    var $tdSche = null;
		
        $(document).ready(function() {
            drawCalendar();
            initDate();
            drawDays();
            $("#movePrevMonth").on("click", function(){movePrevMonth();});
            $("#moveNextMonth").on("click", function(){moveNextMonth();});
        });
	
        //calendar 그리기
        function drawCalendar(){
            var setTableHTML = "";
            setTableHTML+='<table class="calendar">';
            setTableHTML+='<tr align=left><th></th><th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th></tr>';
            for(var i=0;i<6;i++){
                setTableHTML+='<tr height="80">';
                    setTableHTML+='<th style="font-size:2em;">';
                for(var j=0;j<7;j++){

                    setTableHTML+='<td class="tds" style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap;width:70px;font-size:1.6em">';
                    setTableHTML+='    <div class="cal-day"></div>';
                    setTableHTML+='    <div class="cal-schedule"></div>';
                    setTableHTML+='</td>';
                }
                setTableHTML+='</tr>';
            }
            setTableHTML+='</table>';
            $("#cal_tab").html(setTableHTML);

            $(".cal-day").one("mousedown",function(){
            var a =$(this).text();
            var c = "";
            if(month==1){
                c="January";
            }else if(month==2){
                c="February";
            }else if(month==3){
                c="March";
            }else if(month==4){
                c="April";
            }else if(month==5){
                c="May";
            }else if(month==6){
                c="June";
            }else if(month==7){
                c="July";
            }else if(month==8){
                c="August";
            }else if(month==9){
                c="September";
            }else if(month==10){
                c="October";
            }else if(month==11){
                c="November";
            }else if(month==12){
                c="December";
            }  
            var b = document.getElementById("sample");
            b.append(c);
            var d = document.getElementById("sample2");
            d.append(a);

            })
        }
        
        //날짜 초기화
        function initDate(){
            $tdDay = $("td div.cal-day")
            $tdSche = $("td div.cal-schedule")
            dayCount = 0;
            today = new Date();
            year = today.getFullYear();
            month = today.getMonth()+1;
            firstDay = new Date(year,month-1,1);
            lastDay = new Date(year,month,0);
        }
        //calendar 날짜표시
        function drawDays(){
            $("#cal_top_year").text(year+"년");
            $("#cal_top_month").text(month+"월");
            // console.log($(".sample").text(month));
            for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
                $tdDay.eq(i).text(++dayCount);
            }
            for(var i=0;i<42;i+=7){
                $tdDay.eq(i).css("color","#dc2742");
            }
            for(var i=6;i<42;i+=7){
                $tdDay.eq(i).css("color","blue");
            }
        }
        
        //calendar 월 이동
        function movePrevMonth(){
            month--;
            if(month<=0){
                month=12;
                year--;
            }
            if(month<10){
                month=String("0"+month);
            }
            getNewInfo();
         }
        
        function moveNextMonth(){
            month++;
            if(month>12){
                month=1;
                year++;
            }
            if(month<10){
                month=String("0"+month);
            }
            getNewInfo();
        }
        
        function getNewInfo(){
            for(var i=0;i<42;i++){
                $tdDay.eq(i).text("");
            }
            dayCount=0;
            firstDay = new Date(year,month-1,1);
            lastDay = new Date(year,month,0);
            drawDays();
        } */
	
		function showProfileChange(){
			const url = "<%=request.getContextPath()%>/changeProfile";
			const title="프로필 바꾸기";
			const status="left=100px,top=100px,width=300px,height=240px";
			open(url,title,status);
		}
		
		function fn_update_submit(){
			location.replace('<%=request.getContextPath()%>/dog/updateDog?id=<%=logginedMember.getId()%>');
		}
		
		function fn_delete_dog(){
			location.replace('<%=request.getContextPath()%>/dog/deleteDog?id=<%=logginedMember.getId()%>');
		}
	</script>
</body>
</html>