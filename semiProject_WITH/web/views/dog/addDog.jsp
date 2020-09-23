<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 강아지 정보입력</title>
<style>
	#addDogBox{
		background-color:rgba(250,247,242,0.7);
		border-radius:2px;
		padding:20px;
		width:620px;
		height:330px;
		margin:40px auto;
	}
	#addDog-photo{
		width:260px;
		height:220px;
		background-color:white;
		float:left;
		margin-top:35px;
		margin-bottom :20px;
		margin-left:25px;
		margin-right:20px;
	}
	#addDog-table{
		border-spacing:5px 15px;
		text-align:left;
		margin-top:0;
	}
	#submitAddDog{
		margin-left:250px;
		font-size:16px;
		margin-right:20px;
		background-color:rgba(114,133,63,0.9);
		border:1px gray solid;
		border-radius:2px;
		width:60px;
	}
	#resetAddDog{
		font-size:16px;
		background-color:white;
		border-radius:2px;
		border:1px gray solid;
		width:60px;
	}
	#dogProfile{
	    position: absolute;
	    width: 0;
	    height: 0;
	    padding: 0;
	    overflow: hidden;
	    border: 0;
	}
	#dogProfileLbl{
		vertical-align:middle;
		text-align:center;
	}

</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<section id="addDog-container">
		<%@ include file="/views/common/sidebar.jsp" %>
		<div id="addDogBox">
			<form action="<%=request.getContextPath()%>/addDogEnd" method="post" name="memberJoinFrm" enctype = "multipart/form-data">
				<input type="hidden" name="dog_owner" value="<%=logginedMember.getId()%>">
				
				<div id="addDog-photo">
				</div>
				
				<div id="addDog-div">
					<table id="addDog-table">
						<tr>
							<td colspan="2">
							<label for="dogProfile" id="dogProfileLbl">대표 사진 선택</label>
							<input type="file" id="dogProfile" name="dog_profile">
							</td>
						</tr>
						<tr>
							<td>이름 </td>
							<td> <input type="text" name="dog_name" id="dog_name" required></td>
						</tr>
						<tr>
							<td>품종 </td>
							<td>
								<div id="breedDiv">
									<select id="firstSelect" name="firstSelect" required>
        								<option>대분류 선택</option>
        								<option value="1">소형견</option>
        								<option value="2">중형견</option>
        								<option value="3">대형견</option>
   						 			</select>
    								<select id="secondSelect" name="secondSelect" required>
        								<option value="">중분류 선택</option>
    								</select>
								</div>
							</td>
						</tr>
						<tr>
							<td>몸무게 </td>
							<td>
								<input type="number" step="0.1" min="0" name="dog_weight">
							</td>
						</tr>
						<tr>
							<td>성별 </td>
							<td>
								<input type="radio" id="female" name="dog_gender" value="F" required>
								<label for="female">암컷</label>
								<input type="radio" id="male" name="dog_gender" value="M" required>
								<label for="male">수컷</label>
							</td>	
						</tr>
						<tr>
							<td>생년월일 </td>
							<td>
								<input type="date" id="dog_birth" name="dog_birth" required>
							</td>
						</tr>
						<tr>
							<td>중성화 </td>
							<td>
								<input type="radio" id="dog_neuter_yes" name="dog_neuter" value="Y" required/>
								<label for="dog_neuter_yes">중성</label>
								<input type="radio" id="dog_neuter_no" name="dog_neuter" value="N" required/>
								<label for="dog_neuter_no">미중성</label>
							</td>
						</tr>
						
						
					</table>
				</div>
							<input id="submitAddDog" type="submit" value="가입">
							<input id="resetAddDog" type="reset" value="취소">
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
						$('#secondSelect').append($("<option>",{class:"op",value:i,text:item}));
					});
				}else if(sel==2){
					$('.op').remove();
					$.each(middle,function(i,item){
						$('#secondSelect').append($("<option>",{class:"op",value:i,text:item}));
					});
				}else if(sel==3){
					$('.op').remove();
					$.each(large,function(i,item){
						$('#secondSelect').append($("<option>",{class:"op",value:i,text:item}));
					});
				}
				
			});
		});
	</script>
				<script>
				$(document).ready(function(){
					var fileTarget= $("#dogProfile");
					fileTarget.on('change',function(){
						
						var lbl = $("#dogProfileLbl");
						lbl.html("대표 사진 변경");
						
<%-- 						var frm = document.getElementById("frm_profile_img");
						frm.method='POST';
						frm.enctype='multipart/form-data';
						var fileDate = new FormData(frm);
						
						$.ajax({
							type:'POST',
							url:'<%=request.getContextPath()%>/addDogProfile',
							data:fileData,
							processData:false,
							contentType:false,
							success:function(data,textStatus,xhr){
								console.log('success');
							},
							error:function(request,status,error){
								alert("code:"+request.status+"\n"+"error"+error);
							}
						}); --%>
						for(let i =0;i<this.files.length;i++){
							if(this.files[i].type.includes("image")){
								let reader=new FileReader();
								reader.onload=function(e){
									let img=$("<img>").attr({"src":e.target.result,"width":"250px","height":"190px"});
									$("#addDog-photo").html(img);
								}
								reader.readAsDataURL(this.files[i]);
							}
						}
						// console.log(this.files);
						// var cur=$("#addDog-photo input[type='file']").val();
						// $("#dog_profile").val(cur);
					});
				});
			</script>
</body>
</html>