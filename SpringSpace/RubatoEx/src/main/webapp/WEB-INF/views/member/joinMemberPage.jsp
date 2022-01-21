<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/header.css">
<link rel="stylesheet" type="text/css" href="../resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="../resources/css/main.css">

<style>
.zero-marin-padding {
	margin: 0px;
	padding: 0px;
}
</style>

<script>
	function joinMemberSubmit() {
		var frm = document.getElementById("frm");		
		var inputId = document.getElementById("inputId");
		var inputPw = document.getElementById("inputPw");
		var inputPwChk = document.getElementById("inputPwChk");
		var inputNick = document.getElementById("inputNick");
		var inputBirth = document.getElementById("inputBirth");
		var inputPhone = document.getElementById("inputPhone");
		var inputEmail = document.getElementById("inputEmail");
		
		var regExp = /^[a-z0-9_]{4,20}$/;
		
		if(!regExp.test(inputId.value)) {
			alert("아이디는 영소문자/숫자/_로 이루어진 4~20자 이어야 합니다.");
			inputId.focus();
			return;
		}
		
		regExp = /(?=.*\d)(?=.*[a-zA-ZS]).{6,16}/;
		
		if(!regExp.test(inputPw.value)) {
			alert("비밀번호는 문자와 숫자를 포함한 6~16자 이어야 합니다.");
			inputPw.focus();
			return;
		}
		
		if(inputPw.value != inputPwChk.value) {
			alert("비밀번호와 비밀번호 확인 문자가 일치하지 않습니다.");
			inputPw.value = "";
			inputPwChk.value = "";
			inputPw.focus();
			return;
		}
		
		if(inputNick.value == "") {
			alert("닉네임을 입력해주세요.");
			inputNick.focus();
			return;
		}	
		
		if(inputBirth.value == "") {
			alert("생년월일을 선택해주세요.");
			inputBirth.focus();
			return;
		}		
		
		if(inputBirth.value == "") {
			alert("생년월일을 선택해주세요.");
			inputBirth.focus();
			return;
		}			
		
		regExp = /^\d{3}-\d{3,4}-\d{4}$/;
		if(!regExp.test(inputPhone.value)) {
			alert("휴대폰번호 형식에 맞게 입력해주세요.");
			inputPhone.focus();
			return;
		}
		
		regExp = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		if(!regExp.test(inputEmail.value)) {
			alert("이메일 형식에 맞게 입력해주세요.");
			inputEmail.focus();
			return;
		}
		
		frm.submit();
		alert("회원가입이 완료되었습니다. 가입시 입력한 이메일로 인증을 해주셔야 로그인 서비스 이용가능합니다.");
		
	}

</script>
</head>
<body>
<div id="wrap" style="overflow: hidden;">
<header>
  <a href="../main/main"><img id="logo" src="../resources/img/logo.png"></a>
<nav id="top_menu">
  <a href="../main/main">HOME</a> | LOGIN | <a href="../member/joinMemberPage">JOIN</a> | NOTICE
</nav>
<nav id="main_menu">
  <ul class="zero-marin-padding">
    <li><a href="../board/boardListPage">자유 게시판</a></li>
    <li><a href="#">기타 연주</a></li>
    <li><a href="#">공동 구매</a></li>
    <li><a href="#">연주회 안내</a></li>
    <li><a href="#">회원 게시판</a></li>
  </ul>
</nav>
</header> <!-- header -->
<aside>
  <article id="login_box">
    <img id="login_title" src="../resources/img/ttl_login.png">
    <form action="../member/loginProcess" method="post">
    <div id="input_button" style="overflow: hidden;">
    <ul id="login_input" class="zero-marin-padding">
      <li><input type="text" name="member_id"></li>
      <li><input type="password" name="member_pw"></li>
    </ul>
    <button><img id="login_btn" src="../resources/img/btn_login.gif"></button>
    </div>
    </form>
    <div class="clear"></div>
    <div id="join_search">
      <a href="../member/joinMemberPage"><img src="../resources/img/btn_join.gif"></a>
      <img src="../resources/img/btn_search.gif">
    </div>
  </article>
  <article id="guestbook">
    <div id="guestbook_title">
      <img src="../resources/img/ttl_memo.gif">
    </div>
    <ul class="zero-marin-padding">
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
    </ul>
  </article>
</aside>

<section id="main">
<div class="continer-fluid">
	<form id="frm" action="./joinMemberProcess" method="post">
	<div class="row">
		<div class="col fs-7 fw-bold mt-5 ms-3 mb-3" style="border-left: 3px solid #272727;">
			회원가입
		</div>
		<hr>
	</div>
	<div class="row mt-3">
		<div class="col">
			<div class="row">
				<div class="col">
					아이디 : <input id="inputId" type="text" name="member_id" value="${memberVO.member_id }">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					비밀번호 : <input id="inputPw" type="password" name="member_pw">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					비밀번호 확인 : <input id="inputPwChk" type="password">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					닉네임 : <input id="inputNick" type="text" name="member_nick" value="${memberVO.member_nick }">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					성별 : <input type="radio" name="member_gender" value="M" checked>남
						<input type="radio" name="member_gender" value="F">여
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					생년월일 : <input id="inputBirth" type="date" name="member_birth">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					핸드폰번호 : <input id="inputPhone" type="text" name="member_phone" value="${memberVO.member_phone }">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					이메일 : <input id="inputEmail" type="email" name="member_email" value="${memberVO.member_email }">
				</div>
			</div>												
		</div>
	</div>
	<div class="row mt-4">
		<hr>
		<div class="col-2 mt-1">
			<input type="button" onclick="joinMemberSubmit()" class="btn btn-dark d-grid" value="회원가입">
		</div>
		<c:if test="${!empty isEmpty }">
		<div class="col">입력하지 않은 정보가 있습니다.</div>
		</c:if>
	</div>
	</form>
</div>
</section> <!-- section main -->
<div class="clear"></div>

<footer>
  <img id="footer_logo" src="../resources/img/footer_logo.gif">
  <ul id="address">
    <li>서울시 강남구 삼성동 1234 우 : 123-1234</li>  
    <li>TEL : 031-123-1234  Email : email@domain.com</li>
    <li>COPYRIGHT (C) 루바토 ALL RIGHTS RESERVED</li>
  </ul>
  <ul id="footer_sns">
    <li><img src="../resources/img/facebook.gif"></li>  
    <li><img src="../resources/img/blog.gif"></li>
    <li><img src="../resources/img/twitter.gif"></li>
  </ul>
</footer> <!-- footer -->

</div> <!-- wrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>