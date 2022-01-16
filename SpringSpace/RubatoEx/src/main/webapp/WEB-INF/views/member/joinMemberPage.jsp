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
	<form action="./joinMemberProcess" method="post">
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
					아이디 : <input type="text" name="member_id" value="${memberVO.member_id }">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					비밀번호 : <input type="password" name="member_pw">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					닉네임 : <input type="text" name="member_nick" value="${memberVO.member_nick }">
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
					생년월일 : <input type="date" name="member_birth">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					핸드폰번호 : <input type="text" name="member_phone" value="${memberVO.member_phone }">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col">
					이메일 : <input type="email" name="member_email" value="${memberVO.member_email }">
				</div>
			</div>												
		</div>
	</div>
	<div class="row mt-4">
		<hr>
		<div class="col-2 mt-1">
			<input type="submit" class="btn btn-dark d-grid" value="가입신청">
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