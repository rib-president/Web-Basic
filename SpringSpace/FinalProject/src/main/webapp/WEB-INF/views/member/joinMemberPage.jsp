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

</script>
</head>
<body>
	<h1>회원가입</h1>
	<form id="frm1" action="./joinMemberProcess" method="post">
		ID : <input id="inputId" type="text" name="member_id"><br>
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