<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	
	var idAvailable = false;
	var pwAvailable = false;

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
	
	function checkId() {

		var idBox = document.querySelector("#id");
		var checkIdBox = document.querySelector("#checkIdBox");
		
		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function() {			
			if(xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);
				
				if(data.isExist) {
					idAvailable = false;
					checkIdBox.innerText = "이미 존재하는 아이디 입니다";
					checkIdBox.style.color = "red";
				} else {
					idAvailable = true;
					checkIdBox.innerText = "";
				}
			}
		}

		xhr.open("get", "./checkId?member_id=" + idBox.value, true);
		xhr.send();

	}
	
	function checkPw() {
		pwAvailable = false;
		
		var pw = document.querySelector("#pw");
		var pwCheck = document.querySelector("#pwCheck");
		
		if(pw.value != "" && pw.value == pwCheck.value) {
			pwAvailable = true;
		} else if(pwCheck.value == "") {
			return;
		}
		
		var checkPwBox = document.querySelector("#checkPwBox");
		
		if(!pwAvailable) {		
			checkPwBox.innerText = "비밀번호가 일치하지 않습니다.";
			checkPwBox.style.color = "red";

		} else {
			checkPwBox.innerText = "";
		}
	}

	
	function joinMemberSubmit(isKakao) {
		
		if(!isKakao) {
			var id = document.querySelector("#id");
			
			if(id.value == "") {
				alert("아이디를 입력해주세요");
				
				id.focus();
				return;
			}
			
			if(!idAvailable) {
				alert("아이디 중복검사를 완료해주세요.");
				
				id.focus();
				return;	
			}
			
			var pw = document.querySelector("#pw");
			
			if(pw.value == "") {
				alert("비밀번호를 입력해주세요");
				
				pw.focus();
				return;
			}
			
			if(!pwAvailable) {
				alert("비밀번호를 확인해주세요.");
				
				pw.focus();
				return;
			}			
		}
		
		var name = document.querySelector("#name");
		
		if(name.value == "") {
			alert("이름을 입력해주세요");
			
			name.focus();
			return;
		}
		
		var nickName = document.querySelector("#nickName");
		
		if(nickName.value == "") {
			alert("닉네임을 입력해주세요");
			
			nickName.focus();
			return;
		}
		
		var birth = document.querySelector("#birth");
		
		if(birth.value == "") {
			alert("생년월일을 입력해주세요");
			
			birth.focus();
			return;
		}
		
		var phone = document.querySelector("#phone");
		
		if(phone.value == "") {
			alert("핸드폰번호를 입력해주세요");
			
			phone.focus();
			return;
		}
		
		var addr = document.querySelector("#addr");
		
		if(addr.value == "") {
			alert("주소를 입력해주세요");
			
			addr.focus();
			return;
		}		
		
		if(!isKakao) {
			var email = document.querySelector("#email");
			
			if(email.value == "") {
				alert("이메일을 입력해주세요");
				
				email.focus();
				return;
			}
		}
		
		var detail_addr = document.getElementById("detail_addr");

		if(detail_addr.value != null) {
			addr.value = addr.value + " " + detail_addr.value;
		}
		
		var frm = document.getElementById("frm");
		frm.submit();
	}
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form id="frm" action="./joinMemberProcess" method="post">
		<c:choose>
			<c:when test="${empty member_kakao }"> 
				ID : <input type="text" id="id" name="member_id" onblur="checkId()"><div id="checkIdBox" style="display:inline;"></div><br>
				PW : <input type="password" name="member_pw" id="pw" onblur="checkPw()"><div id="checkPwBox" style="display:inline;"></div><br>
				PW Check : <input type="password" id="pwCheck" onblur="checkPw()"><br>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="member_id" value="${member_id }">
				<input type="hidden" name="member_pw" value="kakaoMember">
			</c:otherwise>
		</c:choose>
		Name : <input id="name" type="text" name="member_name"><br>
		Nickname : <input id="nickName" type="text" name="member_nick"><br>
		gender :
		<!-- check, radio, select는 value값이 미리 지정되어 있어야함 -->
		<input type="radio" name="member_gender" value="M" checked>남
		<input type="radio" name="member_gender" value="F">여<br>
		birth : <input id="birth" type="date" name="member_birth"><br>
		phone : <input id="phone" type="text" name="member_phone"><br>
		address : <input type="text" id="addr" name="member_address" readonly> <span><button type="button" onclick="findAddr()">주소 찾기</button></span><br>
		detail address : <input id="detail_addr" type="text"><br>
		<c:choose>
			<c:when test="${empty member_kakao}">
				e-mail : <input id="email" type="text" name="member_email"><br>
				<input type="hidden" name="member_kakao" value="N">
			</c:when>
			<c:otherwise>
				<input type="hidden" name="member_email" value="${member_email }">
				<input type="hidden" name="member_kakao" value="Y">
			</c:otherwise>
		</c:choose>
		<input type="button" value="회원가입" onclick="joinMemberSubmit(${!empty member_kakao })">
	</form>

</body>
</html>