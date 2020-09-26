<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이콘 선택하기</title>
<script src="https://kit.fontawesome.com/d41f04266a.js" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>

<style>
	body{
		text-align:center;
	}
	i{
		font-size:100px;
		width:120px;
		height:120px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td><i id="flower" class="fa fa-tree"></i></td>
			<td><i id="paw" class="fas fa-paw"></i></td>
		</tr>
		<tr>
			<td><i id="heart" class="fas fa-heart"></i></td>
			<td><i id="star"  class="fas fa-star"></i></td>
		</tr>
<!-- 		<tr>
			<td><input type="text" id="flowerTxt"  value="flower"></td>
			<td><input type="text" id="pawTxt"  value="paw"></td>
			<td><input type="text" id="heartTxt"  value="heart"></td>
			<td><input type="text" id="starTxt"  value="star"></td>
		</tr> -->
		<tr>
			<td colspan="4"><button type="button" onclick="closePage();"></button></td>
		</tr>
	</table>
<script>
	$(function(){
		let click=0;
		$("#flower").on("click",function(){
			if(click==0){
				$("#flower").css("background-color","rgba(114, 133, 63,0.9)");
				click++;
			}else{
				$("#flower").css("background-color","white");
				click=0;
			}	
		});
		$("#paw").on("click",function(){
			if(click==0){
				$("#paw").css("background-color","rgba(114, 133, 63,0.9)");
				click++;
			}else{
				$("#paw").css("background-color","white");
				click=0;
			}	
		})
		$("#heart").on("click",function(){
			if(click==0){
				$("#heart").css("background-color","rgba(114, 133, 63,0.9)");
				click++;
			}else{
				$("#heart").css("background-color","white");
				click=0;
			}	
		})
		$("#star").on("click",function(){
			if(click==0){
				$("#star").css("background-color","rgba(114, 133, 63,0.9)");
				click++;
			}else{
				$("#star").css("background-color","white");
				click=0;
			}	
		})
		
	})
	
	function closePage(){
		var backColor = $("i").css("background-color");
		if(backColor=="rgba(114, 133, 63,0.9)"){
			console.log(this);
		}
		
	}
	
</script>
</body>
</html> --%>