<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#join-div{
		margin:auto auto;
		text-align:center;
		width:700px;
	}
	#join-table-essential{
		padding-top:20px;
		margin-top:25px;
		padding-right:10px;
		padding-left:10px;
		border-spacing: 10px 10px;
		text-align:center;
		float:left;
		background-color:rgba(250,247,242,0.7);
		border-radius:2px;
	}	
	.add{
		width:60px;
	}
	#submitJoin{
		margin-right:10px;
		margin-top:10px;
		margin-bottom:10px;
		font-size:16px;
		border:1px gray solid;
		border-radius:2px;
		width:60px;
		background-color:rgba(114,133,63,0.9);
	}
	#resetJoin{
	margin-top:10px;
		font-size:16px;
		margin-bottom:10px;
		border-radius:2px;
		border:1px gray solid;
		width:60px;
		background-color:white;
	}
</style>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="join-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="joinBox">
		<!-- Have to put method and enctype if you want to let client put profile photo -->
			<form action="<%=request.getContextPath()%>/joinMemberEnd" method="post"
			enctype="multipart/form-data" name="memberJoinFrm">
				<div id="join-div">
					<table id="join-table-essential">
						<tr>
							<td>아이디</td>
							<td><input type="text" placeholder="4글자이상" name="Id" id="Id" required ></td>
							<td colspan="2">
								<div id="chkMsg"></div>
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="Password" id="Password" class="inputPw" required></td>
							<td>
								<div id="eye-icon">
                        			<i id="eyeOn" class="fas fa-eye" style="color:gray;"></i>
                    			</div>
                    		</td>
                    		<td>
                    			<div id="chkPwRule"></div>
                    		</td>
						</tr>
						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" id="Password2" class="inputPw" required></td>
							<td>
								<div id="chkPw">
									<i id="showchk" class="fas fa-check" style="color:gray;"></i>
								</div>
							</td>
							<td></td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td>
								<input type="text" name="nickname" id="nickname" placeholder="반려견 이름을 포함시켜주세요." required>
							</td>
							<td colspan="2">
								<div id="chkNickMsg"></div>
							</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="text" name="phone" id="phone" required></td>
							<td colspan="2"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type=text id="email" name="email" required></td>
							<td><i id="envelope" class="fa fa-envelope" onclick="fn_email_check();"></i></td>
							<td><div id="emailMsg">이메일 입력 후 버튼을 눌러주세요.</div></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" id="si" name="si" class="add" readonly>
								<input type="text" id="gu" name="gu" class="add" readonly> 
								<input type="text" id="dong" name="dong" class="add" readonly></td>
							<td><i id="getAdd" class="fa fa-map-marker"></i></td>
							<td><span>주소 입력을 위해 버튼을 눌러주세요.</span></td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td><input type="date" name="birth" id="birth" style="width:210px;"></td>
							<td colspan="2"></td>
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
							<td>
							
							</td>
							<td>
								<div id="radioMsg"></div>
							</td>
						</tr>
						<tr>
							
							<td colspan="4"><input id="submitJoin" type="submit" value="가입">
							<input id="resetJoin" type="reset" value="취소"></td>
							
						</tr>
					</table>
				</div>
				
				
			</form>
		</div>
		<form action="" name="emailCheck">
		<!--form이나 queryString으로 넘기는 방법있음.-->
		<!-- 아이디에 입력한 값을 여기에 몰래 집어넣고 전송 -->
			<input type="hidden" name="Email">
		</form>
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
            
            $("#nickname").on("propertychange change keyup paste input", function() {
                newValue = $(this).val();
 				$.ajax({
 					url:"<%=request.getContextPath()%>/checkNickname",
 					type:"get",
 					data:{"nickname":newValue},
 					dataType:"html",
 					success:data=>{
 						console.log(data);
 						$("#chkNickMsg").html(data);
 					}
 				});
             });
            
            
   	    	$("#Password").blur(e=>{
   	    		let pw=$(e.target).val();
   	    		let regPw = /(?=.*\d{1,16})(?=.*[~`!@#$%\^&*()-+=]{1,16})(?=.*[a-zA-Z]{1,16}).{8,16}$/;
   	    		if(!regPw.test(pw)){
   	    			$("#chkPwRule").html("영문자, 숫자 ,특수기호 포함하여 8~16자");
   	    			$(e.target).val("");
   	    		}
   	    	})
            
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
			
			$("#getAdd").click(function(){
			    new daum.Postcode({
			        oncomplete: function(data) {
						var si='';
						var gu='';
						var dong='';
						//if client selected roadAddress
						if(data.userSelectedType == 'R'){
							si = data.sido;
							gu = data.sigungu;
							dong = data.bname;
						// if client selected jibunAddress
						}else if(data.userSelectedType=='J'){
							si = data.sido;
							gu = data.sigungu;
							dong = data.bname;
						}
						document.getElementById("si").value=si;
						document.getElementById("gu").value=gu;
						document.getElementById("dong").value=dong;
			        }
			    }).open();
			});
		})

		function fn_email_check(){
			let email = $("#email").val().trim();
			const url = "<%=request.getContextPath()%>/emailCheck";
			const title="emailCheck";
			const status="left=500px,top=100px,width=300px,height=200px";
			open("",title,status);
			
			emailCheck.target=title;
			emailCheck.action=url;
			emailCheck.method="post";
			emailCheck.Email.value=email;
			//form 전송하기
			emailCheck.submit();
		}
		
		jQuery(document).ready(function(){
			$('input:radio[value="none"]').click(function(){
				$("#radioMsg").html("모임 참여에 제약이 있을 수 있습니다.");
			});
			$('input:radio[value="female"]').click(function(){
				$("#radioMsg").html("");
			});
			$('input:radio[value="male"]').click(function(){
				$("#radioMsg").html("");
			});
		})
	</script>
</body>
</html>