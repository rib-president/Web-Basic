<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/header.css">
<link rel="stylesheet" type="text/css" href="../resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="../resources/css/board_left.css">
<link rel="stylesheet" type="text/css" href="../resources/css/board_write_main.css">
</head>
<body>
<div id="wrap">
<header>
  <a href="../main/main"><img id="logo" src="../resources/img/logo.png"></a>
<nav id="top_menu">
  <a href="../main/main">HOME</a> | LOGIN | <a href="../member/joinMemberPage">JOIN</a> | NOTICE
</nav>
<nav id="main_menu">
  <ul>
    <li><a href="./boardListPage">자유 게시판</a></li>
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
    <c:choose>
    <c:when test="${empty sessionUser }">
	    <form action="../member/loginProcess" method="post">
	    <div id="input_button">
	    <ul id="login_input">
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
    </c:when>
    <c:otherwise>
    	<div style="margin: 10px;">
    	${sessionUser.member_nick }님 환영합니다!
    	</div>
    	<br>
    	<a href="../member/logoutProcess"><button>로그아웃</button></a>
    </c:otherwise>
    </c:choose>
  </article>
  <nav id="sub_menu">
    <ul>
      <li><a href="./boardListPage">+ 자유 게시판</a></li>
      <li><a href="#">+ 방명록</a></li>
      <li><a href="#">+ 공지사항</a></li>
      <li><a href="#">+ 등업요청</a></li>
      <li><a href="#">+ 포토갤러리</a></li>
    </ul>
  </nav>
  <article id="sub_banner">
    <ul>
      <li><img src="img/banner1.png"></li>
      <li><img src="img/banner2.png"></li>		
      <li><img src="img/banner3.png"></li>
    </ul>    
  </article>
</aside> 

<section id="main">
  <img src="../resources/img/comm.gif">
  <h2 id="board_title">자유 게시판 </h2>
  <div id="write_title"><h2>수정하기</h2></div>
  <form action="./boardModifyProcess" method="post">
  <table>
    <tr id="name">
      <td class="col1">이름</td>
      <td class="col2">${sessionUser.member_nick }</td>
    </tr>
    <tr id="subject">
      <td class="col1">제목</td>
      <td class="col2"><input type="text" name="board_title" value="${boardVO.board_title }"></td>
    </tr>		
    <tr id="content">
      <td class="col1">내용</td>
      <td class="col2"><textarea name="board_content">${boardVO.board_content }</textarea>
      <input type="hidden" name="board_no" value="${boardVO.board_no }">
      </td>
    </tr>	
    <tr id="upload">
      <td class="col1">업로드 파일</td>
      <td class="col2"><input type="file"></td>
    </tr>	
  </table>
  <div id="buttons">
    <button><img src="../resources/img/ok.png"></button>
    <a href="./boardListPage"><img src="../resources/img/list.png"></a>
  </div>
  </form>
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
</body>
</html>
