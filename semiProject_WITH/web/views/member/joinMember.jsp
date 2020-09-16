<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#join-essential{
		margin:40px auto;
		text-align:center;
		width:700px;
	}
	#join-table-essential{
		margin: 40px 0;
		border-spacing: 10px 10px;
		text-align:center;
		float:left;
	}
	#join-table-optional{
		margin: 40px 0;
		border-spacing: 10px 10px;
		
	}
	
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="join-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="joinBox">
		<!-- Have to put method and enctype if you want to let client put profile photo -->
			<form action="<%=request.getContextPath()%>/joinMemberEnd" method="post"
			enctype="multipart/form-data">
				<div id="join-essential">
					<table id="join-table-essential">
						<tr>
							<td>아이디</td>
							<td><input type="text" placeholder="4글자이상" name="Id" id="Id" required ></td>
							<td><div id="chkMsg"></div></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="Password" id="Password" class="inputPw" required></td>
							<td>
								<div id="eye-icon">
                        			<i id="eyeOn" class="fas fa-eye" style="color:gray;"></i>
                    			</div>
                    		</td>
						</tr>
						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" id="Password2" class="inputPw"></td>
							<td>
								<div id="chkPw">
									<i id="showchk" class="fas fa-check" style="color:gray;"></i>
								</div>
							</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td>
								<input type="text" name="nickname" id="nickname" placeholder="반려견 이름을 포함시켜주세요." required>
							</td>
							<td></td>
						</tr>
					</table>
					
					<table id="join-table-optional">
						<tr>
							<td colspan="3"></td>
						<tr>
						<br>
						<tr>
							<td>생년월일</td>
							<td><input type="date" name="birth" id="birth" style="width:210px;"></td>
							<td></td>
						</tr>
						<tr>
							<td>성별</td>
							<td>
								<input type="radio" id="none" name="gender" value="none">
								<label for="none">공개안함</label>
								<input type="radio" id="female" name="gender" value="female">
								<label for="female">여</label>
								<input type="radio" id="male" name="gender" value="male">
								<label for="male">남</label>
							</td>
						</tr>
					
					</table>
					
				</div>
				
				
			</form>
		</div>
	</section>
	<script>
		$(function(){
			var newValue;
            $("#Id").on("propertychange change keyup paste input", function() {
               newValue = $(this).val();
				$.ajax({
					url:"<%=request.getContextPath()%>/checkIdDuplicate",
					type:"get",
					data:{"id":newValue},
					dataType:"html",
					success:data=>{
						console.log(data);
						$("#chkMsg").html(data);
					}
				});
            });
            
			$(".inputPw").keyup(function(){
				var inputed = $("#Password").val();
				var reinputed = $("#Password2").val();
				if(inputed!=""||reinputed!=""){
					if(inputed == reinputed){
						$("#showchk").css("color","green");
					}else{
						$("#showchk").css("color","red");
					}
				}
			})
            
			let eyeCount=0;
			$("#eyeOn").on("click",function(e){
				let pw = $("Password");
				if(eyeCount==0){
					eyeCount++;
                    $("#eyeOn").attr("class","fas fa-eye-slash");
                    $("#Password").attr("type","text");
				}else{
					eyeCount=0;
                    $("#Password").attr("type","password");
                    $("#eyeOn").attr("class","fas fa-eye");
				}
			})
			
            
		})

	</script>
</body>
</html>