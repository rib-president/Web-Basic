<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	// jQuery version
	function joinMemberSubmit1() {	
		// 유효성 검사(사용자가 입력한 값이 정상적인 값인지 판단)
		// 정규표현식 사용
		// 영소문자로 시작하여 영소문자 및 숫자로 이루어진 6~20개 사이의 문자
		var regExp = /^[a-z][a-z0-9]{5,19}$/g;
		
		// 위 정규표현식에 부합하는지 true/false 리턴
		//regExp.test(text);
		
		if(!regExp.test($("#inputId").val())) {
			alert("아이디는 영소문자로 시작하는 총 6자 ~ 20자 사이의 영소문자/숫자 조합으로 작성하셔야 합니다.");
			$("#inputId").focus();
			return;
		}
		
		
		//var regExp = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/;

		// 아래처럼 RegExp 객체 생성해서 해도 됨(생성자로 정규식들어감)
		var regExp = RegExp(/^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/);
		
		if(!regExp.test($("#inputPw").val())) {
			alert("비밀번호는 소문자와 대문자로 시작하는 최소 8자 최대 12자, 특수문자와 대소문자가 조합되어야 합니다.");
			inputPw.focus();
			return;			
		}

		
		if($("#inputPw").val() != $("#inputPwConfirm").val()) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");

			$("#inputPw").val("");
			$("#inputPwConfirm").val("");
			$("#inputPw").focus();
			
			return;
		}
		
		if($("#inputBirth").val() == "") {
			alert("생일을 선택해주세요.")
			$("#inputBirth").focus();
		
			return;
		}
		
		if(isConfirmed == false) {
			alert("아이디 중복 검사를 해야 합니다.");
			return;
		}
		
		$("#frm1").submit();
	}
	
	// vanilla JS version
	function joinMemberSubmit2() {
		var inputId = document.getElementById("inputId");
		
		if(inputId.value == "") {
			alert("아이디 확인...");
			inputId.focus();
			return;
		}
		
		var frm1 = document.getElementById("frm1");
		frm1.submit();
	}
	
	var isConfirmed = false;
	function confirmId() {
		var idBox = document.getElementById("inputId");
		var idValue = idBox.value;
		
		// ajax 호출(vanilla js)
		var xhr = new XMLHttpRequest();	// js 내장 API
		
		// 응답받을 때 실행되는 function 설정(함수를 변수에 담음, 콜백함수)
		// 총 4번 호출 : open, send, server에 도달했을 때, server로부터 응답받을 때
		xhr.onreadystatechange = function() {
			// server로부터 응답받을 때만 실행되도록 조건 설정
			// 200 : 서버쪽 정상 응답(400, 500은 에러)
			if(xhr.readyState == 4 && xhr.status == 200) {
				//alert("서버로부터 받은 데이터 : " +  xhr.responseText); // {"result":true}
				
				// JSON 형태 문자열을 js object로 decoding
				var data = JSON.parse(xhr.responseText);
				
				// 화면 조작(핵심 DOM 조작)
				var confirmAlertBox = document.getElementById("confirmAlertBox");
				// data["result"]도 가능
				if(data.result == true) {
					isConfirmed = false;
					confirmAlertBox.innerText = "이미 존재하는 아이디 입니다.";
					confirmAlertBox.style.color = "red";				
				} else {
					isConfirmed = true;
					confirmAlertBox.innerText = "사용 가능한 아이디 입니다.";
					confirmAlertBox.style.color = "green";					
				}
			}
		};
		
		xhr.open("GET", "./isExistId?id=" + idValue, true);	// 3번째 파라미터는 일반적으로 true(동기식 호출, 가급적 피해라)
		xhr.send();
		
	}

</script>
</head>
<body>
	<h1>회원가입</h1>
	<form id="frm1" action="./joinMemberProcess" method="post">
		ID : <input id="inputId" type="text" name="member_id" onblur="confirmId()">
		<br>		
		<div id="confirmAlertBox"></div>		
		PW : <input id="inputPw" type="password" name="member_pw"><br>
		PW Confirm : <input id="inputPwConfirm" type="password"><br>
		
		Nickname : <input id="inputNick" type="text" name="member_nick"><br>
		gender :
		<!-- 체크, 라디오, 셀렉트는 value값을 미리 지정해야함 -->
		<input type="radio" name="member_gender" value="M" checked> 남
		<input type="radio" name="member_gender" value="F"> 여<br>
		
		취미 :
		<c:forEach items="${hobbyCategoryList }" var="hobbyCategory">
			<input type="checkbox" name="hobby_category_no" value="${hobbyCategory.hobby_category_no }">${hobbyCategory.hobby_category_name }
		</c:forEach>
		<br>
		
		birth : <input id="inputBirth" type="date" name="member_birth"><br>
		phone : <input id="inputPhone" type="text" name="member_phone"><br>
		e-mail : <input id="inputEmail" type="text" name="member_email"><br>
		<input type="button" value="회원가입" onclick="joinMemberSubmit1()">
	</form>
</body>
</html>