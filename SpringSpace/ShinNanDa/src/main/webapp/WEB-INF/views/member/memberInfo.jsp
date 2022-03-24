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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">
<link href="../resources/css/shopMain.css" rel="stylesheet">

<script>
	var memberNo = '${sessionUser.member_no}';
	var memberPw = null;

	function findAddr(){
		new daum.Postcode({
	        oncomplete: function(data) {
				
				// 도로명 주소 변수
				var roadAddr = data.roadAddress;
				// 지번 주소 변수
				var jibunAddr = data.jibunAddress;
				
	            if(roadAddr !== ''){
	                document.getElementById("addr").value = roadAddr;
	            } 
	            else if(jibunAddr !== ''){
	                document.getElementById("addr").value = jibunAddr;
	            }
	        }
	    }).open();
	}	

	function refreshMemberInfo() {
		document.querySelector("#member_pw").value = "";
		if('${sessionUser.member_kakao}' == 'N') {
			document.querySelector("#check_pw").value = "";
		}
		document.querySelector("#detail_addr").value = "";
		
		//AJAX...호출...
		var xhr = new XMLHttpRequest();
		
		//응답 받을때...
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){				
				var data = JSON.parse(xhr.responseText);
				memberPw = data.memberVo.member_pw;
				document.querySelector("#member_id").innerText = data.memberVo.member_id;
				document.querySelector("#member_name").innerText = data.memberVo.member_name;
				document.querySelector("#member_nick").value = data.memberVo.member_nick;
										  
			    if(data.memberVo.member_gender == 'M') {
			    	document.querySelector("#member_gender").innerText = '남';
			    } else {
			    	document.querySelector("#member_gender").innerText = '여';
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
				document.querySelector("#member_birth").innerText = formatted_birth;
				document.querySelector("#member_phone").value = data.memberVo.member_phone;
				document.querySelector("#addr").value = data.memberVo.member_address;
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
		
		var fullAddress = document.getElementById("addr").value;
		var detail_addr = document.getElementById("detail_addr").value;		
		
		if(detail_addr != "") {
			fullAddress = fullAddress + " " + detail_addr;
		}		
		
		var data = {
				member_no : memberNo,
				member_pw : memberPw,
				member_nick : document.querySelector("#member_nick").value,				
				member_phone : document.querySelector("#member_phone").value,
				member_address : fullAddress,
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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<div style="margin: 0 auto;">
 <div class="container-fluid">
	<div class="row">
		<div id="nav-bar" class="col"><!-- 글로벌 nav -->
			<jsp:include page="../commons/global_nav.jsp"></jsp:include>
		</div>
	</div>

 	<div class="row">
		<jsp:include page="../commons/menu_bar.jsp"></jsp:include>
		<div class="col shop-start-col">	  
			<div class="row">
				<div class="col"><h1>회원 정보 관리</h1><hr></div>
			</div>
			
			<%-- <form id="frm" action="../member/modifyMemberInfo" method="post"> --%>
			<div class="row mt-5">
			  <div class="col">
			    <c:choose>
			      <c:when test="${sessionUser.member_kakao == 'N' }">
				    <div class="row mt-3">
				      <div class="col-3">아이디</div>
				      <div id="member_id" class="col"></div>
				    </div>
			    
				    <div class="row mt-3">
				      <div class="col-3">비밀번호</div>
				      <div class="col"><input class="form-control" id="member_pw" type="password" name="member_pw"></div>
				    </div>
				    <div class="row mt-3">
				      <div class="col-3">비밀번호 확인</div>
				      <div class="col"><input id="check_pw" class="form-control" type="password"></div>
				    </div>
			      </c:when>
			      <c:otherwise>
			        <div id="member_id" style="display:none;"></div>
			        <input id="member_pw" type="hidden" name="member_pw">
			      </c:otherwise>
			    </c:choose>
			    <div class="row mt-3">
			      <div class="col-3">이름</div>
			      <div id="member_name" class="col"></div>
			    </div>				    
			    <div class="row mt-3">
			      <div class="col-3">닉네임</div>
			      <div class="col"><input class="form-control" type="text" id="member_nick"></div>
			    </div>			    			    
			    <div class="row mt-3">
			      <div class="col-3">성별</div>
			      <div class="col" id="member_gender"></div>
			    </div>	
			    <div class="row mt-3">
			      <div class="col-3">생년월일</div>
			      <div class="col" id="member_birth"></div>
			    </div>	
			    <div class="row mt-3">
			      <div class="col-3">핸드폰 번호</div>
			      <div class="col"><input class="form-control" type="text" id="member_phone"></div>
			    </div>	
			    <div class="row mt-3">
			      <div class="col-3">주소</div>
			      <div class="col"><input class="form-control" type="text" id="addr" readonly></div>
			      <div class="col"><button class="btn btn-primary" type="button" onclick="findAddr()">주소 찾기</button></div>
			    </div>
			    <div class="row mt-3">
			      <div class="col-3">상세 주소</div>
			      <div class="col"><input class="form-control" id="detail_addr" type="text"></div>
			    </div>				    
			    <div class="row mt-3">			      			     
			      	<c:choose>
			      		<c:when test="${sessionUser.member_kakao == 'N' }">
			      		  <div class="col-3">이메일</div>
			      		  <div class="col">
			      			<input class="form-control" type="text" id="member_email">
			      		  </div>
			      		</c:when>
			      		<c:otherwise>
						  <div class="col" id="member_email"></div>
			      		</c:otherwise>
			      	</c:choose>			      
			    </div>

				<input type="button" value="수정완료" onclick="modifyMemberSubmit()">
			  </div>
			</div>				
			<%-- </form> --%>
	  								
		</div>
 	</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>