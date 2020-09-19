<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Dog</title>
<style>
	#addDog-table{
		background-color:rgba(250,247,242,0.7);
		border-radius:2px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="addDog-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="addDogBox">
			<form action="<%=request.getContextPath()%>/addDogEnd" method="post" name="memberJoinFrm">
				<div id="addDog-div">
					<table id="addDog-table">
						<tr>
							<td>이름 </td>
							<td> <input type="text" name="dog_name" id="dog_name"></td>
						</tr>
						<tr>
							<td>품종</td>
							<td>
								<div id="breedDiv">
									<select id="firstSelect">
        								<option>대분류 선택</option>
        								<option value="1">소형견</option>
        								<option value="2">중형견</option>
        								<option value="3">대형견</option>
   						 			</select>
    								<select id="secondSelect">
        								<option value="">중분류 선택</option>
    								</select>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</section>
	<script type="text/javascript">
		$(document).ready(function(){
			var small=["믹스견","스피츠","시츄","요크셔테리어","말티즈","포메라니안","푸들","치와와","미니핀","슈나우저","페키니즈","닥스훈트","빠삐용","기타"];
			var middle=["비숑 프리제","보스턴 테리어","샤페이","웰시코기","비글","코카스파니엘","불독","기타"];
			var large=["사모예드","피레니즈","리트리버","말라뮤트","한국 토종견","허스키","세퍼트","하운드","달마시안","콜리","쉽독","기타"];
			
			$('#firstSelect').change(function(){
				var sel = $(this).val();
				if(sel==1){
					$('.op').remove();
					$.each(small,function(i,item){
						$('#secondSelect').append('<option class="op">'+item+'</option>');
					});
				}else if(sel==2){
					$('.op').remove();
					$.each(middle,function(i,item){
						$('#secondSelect').append('<option class="op">'+item+'</option>');
					});
				}else if(sel==3){
					$('.op').remove();
					$.each(large,function(i,item){
						$('#secondSelect').append('<option class="op">'+item+'</option>');
					});
				}
				
			});
		});
	</script>
</body>
</html>