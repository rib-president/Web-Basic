<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="../resources/css/commons.css" rel="stylesheet">

<script>

	var memberNo = '${member_no}';
	var memberPw = null;
	function refreshMemberInfo() {
		document.querySelector("#member_pw").value = "";
		
		//AJAX...호출...
		var xhr = new XMLHttpRequest();
		
		//응답 받을때...
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){				
				var data = JSON.parse(xhr.responseText);
				memberPw = data.memberVo.member_pw;
				document.querySelector("#member_id").innerText = data.memberVo.member_id;
				document.querySelector("#member_name").value = data.memberVo.member_name;
				document.querySelector("#member_nick").value = data.memberVo.member_nick;
										  
			    if(data.memberVo.member_gender == 'M') {
			    	document.querySelector("#male").checked = true;
			    } else {
			    	document.querySelector("#female").checked = true;
			    }			   
			    			  
			    var birth = new Date(data.memberVo.member_birth);
			    var month = birth.getMonth() + 1;
			    if(month < 10) {
			    	month = "0" + month;
			    }
			    
			    var date = birth.getDate();
			    if(date < 10) {
			    	date = "0" + date;
			    }
			    var formatted_birth = birth.getFullYear() + "-" + month + "-" + date;
				document.querySelector("#member_birth").value = formatted_birth;
				document.querySelector("#member_phone").value = data.memberVo.member_phone;
				document.querySelector("#member_address").value = data.memberVo.member_address;
				document.querySelector("#member_email").value = data.memberVo.member_email;			
			}
			
		};
		
		
		xhr.open("get" , "../member/getMemberInfo?member_no=" + memberNo , true);
		xhr.send();		
		
	}

	function modifyMemberSubmit() {
		var pw = document.getElementById("member_pw");
		
		if(pw.value != "") {
			memberPw = pw.value;
		}
		
	    var radioGenders = document.getElementsByName("member_gender");
	    var gender = null;
	    for(radioGender of radioGenders){
	         if(radioGender.checked){
	        	 gender = radioGender.value;
	         }
	    }
		
		var data = {
				member_no : memberNo,
				member_pw : memberPw,
				member_name : document.querySelector("#member_name").value,
				member_nick : document.querySelector("#member_nick").value,
				member_gender : gender,
				member_birth : document.querySelector("#member_birth").value,
				member_phone : document.querySelector("#member_phone").value,
				member_address : document.querySelector("#member_address").value,
				member_email :document.querySelector("#member_email").value
		};
		
		//AJAX...호출...
		var xhr = new XMLHttpRequest();
		
		//응답 받을때...
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				refreshMemberInfo();
				alert("수정되었습니다.");
			}
			
		};
		
		
		xhr.open("post" , "../member/modifyMemberInfo" , true);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(JSON.stringify(data));
	}

	window.addEventListener("DOMContentLoaded" , function(){
		refreshMemberInfo();
	});

</script>

</head>
<body>
<div style="width:1200px;margin : 0 auto">
	<div class="container-fluid">
		<div class="row">
			<div class="col"><!-- 글로벌 nav -->
				<jsp:include page="../commons/global_nav.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="../commons/admin_menu_bar.jsp"></jsp:include>


	 	<div class="row">
			<div class="col">	  
				<div class="row">
					<div class="col"><h1>회원 상세 정보</h1><hr></div>
				</div>

				<div class="row mt-5">
				  <div class="col">
				    <div class="row mt-3">
				      <div class="col-3">아이디</div>
				      <div id="member_id" class="col">${memberVo.member_id }</div>
				    </div>
				    <div class="row mt-3">
				      <div class="col-3">비밀번호</div>
				      <div class="col"><input class="form-control" id="member_pw" type="password"></div>
				    </div>
				    <div class="row mt-3">
				      <div class="col-3">이름</div>
				      <div class="col"><input class="form-control" type="text" id="member_name" value="${memberVo.member_name }"></div>
				    </div>				    
				    <div class="row mt-3">
				      <div class="col-3">닉네임</div>
				      <div class="col"><input class="form-control" type="text" id="member_nick" value="${memberVo.member_nick }"></div>
				    </div>			    			    
				    <div class="row mt-3">
				      <div class="col-3">성별</div>			      
				      <div class="col">
				        <c:choose>
				          <c:when test="${memberVo.member_gender =='M' }">
							<input type="radio" id="male" name="member_gender" value="M" checked>남
							<input type="radio" id="female" name="member_gender" value="F">여<br>
				          </c:when>
				          <c:otherwise>
							<input type="radio" id="male" name="member_gender" value="M">남
							<input type="radio" id="female" name="member_gender" value="F" checked>여<br>
				          </c:otherwise>
				        </c:choose>
				      </div>
				    </div>	
				    <div class="row mt-3">
				      <div class="col-3">생년월일</div>
				      <div class="col"><input type="date" id="member_birth" value="${memberVo.member_birth }"></div>
				    </div>	
				    <div class="row mt-3">
				      <div class="col-3">핸드폰 번호</div>
				      <div class="col"><input class="form-control" type="text" id="member_phone" value="${memberVo.member_phone }"></div>
				    </div>	
				    <div class="row mt-3">
				      <div class="col-3">주소</div>
				      <div class="col"><input class="form-control" type="text" id="member_address" value="${memberVo.member_address }"></div>
				    </div>			    
				    <div class="row mt-3">
				      <div class="col-3">이메일</div>
				      <div class="col"><input class="form-control" type="text" id="member_email" value="${memberVo.member_email }"></div>
				    </div>
				
					<input type="button" value="수정완료" onclick="modifyMemberSubmit()">
				  </div>
				</div>	
			  								
			</div>
	 	</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>