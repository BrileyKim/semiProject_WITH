<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List,com.with.walk.model.vo.Walk" %>    
<%
	List<Walk> list = (List<Walk>)request.getAttribute("walks");
	int meetIdx = (int)request.getAttribute("meetIdx");
%>
	
<style>
	#plusBtn{
		float:right;
	}
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

</style>
<div class="cal_top">
	<a href="#" id="movePrevMonth"><span id="prevMonth" class="cal_tit">&lt;</span></a>
	<span id="cal_top_year"></span>
	<span id="cal_top_month"></span>
	<a href="#" id="moveNextMonth"><span id="nextMonth" class="cal_tit">&gt;</span></a>
	<a href="<%=request.getContextPath()%>/walk/walkAdd?meetIdx=<%=meetIdx!=0?meetIdx:""%>" id="plusBtn"><i class="fas fa-plus"></i></a>
</div>
<div class="calendar_sidebar">

</div>
<div id="cal_tab" class="cal">
         
</div>
	
<script>

	var today = null;
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
	}

</script>