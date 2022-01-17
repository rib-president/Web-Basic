<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/header.css">
<link rel="stylesheet" type="text/css" href="../resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="../resources/css/main.css">

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
    <li><a href="../board/boardListPage">자유 게시판</a></li>
    <li><a href="#">기타 연주</a></li>
    <li><a href="#">공동 구매</a></li>
    <li><a href="#">연주회 안내</a></li>
    <li><a href="#">회원 게시판</a></li>
  </ul>
</nav>
</header> <!-- header -->
<aside>
  <jsp:include page="../commons/loginBox.jsp"></jsp:include>
  <article id="guestbook">
    <div id="guestbook_title">
      <img src="../resources/img/ttl_memo.gif">
    </div>
    <ul>
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
    </ul>
  </article>
</aside>

<section id="main">
  <img src="../resources/img/main_img.png">
  <section id="notice_free_youtube">
    <article id="notice"> 	<!-- 공지사항 -->
      <div class="latest_title">
        <img class="latest_img" src="../resources/img/latest1.gif">
        <img class="more" src="../resources/img/more.gif">
        <div class="clear"></div>					
      </div>
      <div class="latest_content">
        <img class="image" src="../resources/img/book_pen.gif">
        <ul class="list">
          <li>
            <div class="subject">루바토 개편과 사이트 이용...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>								
          <li>
            <div class="subject">루바토 개편과 사이트 이용...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>		
          <li>
            <div class="subject">루바토 개편과 사이트 이용...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>	
          <li>
            <div class="subject">루바토 개편과 사이트 이용...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>				
        </ul>							
      </div>
    </article>
    <article id="free"> 	<!--자유 게시판 -->
      <div class="latest_title">
        <img class="latest_img" src="../resources/img/latest2.gif">
        <a href="../board/boardListPage"><img class="more" src="../resources/img/more.gif"></a>
        <div class="clear"></div>					
      </div>
      <div class="latest_content">
        <img class="image" src="../resources/img/book_pen.gif">
        <ul class="list">
        <c:forEach items="${resultList }" var="vo">
        	<li>
            <div class="subject" OnClick="location.href ='../board/boardViewPage?board_no=${vo.boardVO.board_no}'" style="cursor:pointer;">${vo.boardVO.board_title }</div>
            <div class="date"><fmt:formatDate value="${vo.boardVO.board_writedate }" pattern="yyyy-MM-dd" /></div>
            <div class="clear"></div>	
        	</li>
        </c:forEach>
        </ul>							
      </div>
    </article>			
    <article id="youtube">	    <!-- YOUTUBE 동영상 -->		
      <div class="latest_title">
        <img class="latest_img" src="../resources/img/latest3.gif">
        <img class="more" src="../resources/img/more.gif">
        <div class="clear"></div>					
      </div>				
      <img id="youtube_img" src="../resources/img/bach.jpg">
    </article>
  </section> <!-- notice_free_youtube -->
  <section id="gallery">
    <img src="../resources/img/latest4.gif">
    <div id="gallery_box">
      <div id="gallery_list">
        <div class="items">
          <ul>
            <li><img src="../resources/img/img1.jpg"></li>
            <li>기타 페스티벌 4중주</li>
          </ul>
        </div>
        <div class="items">
          <ul>
            <li><img src="../resources/img/img1.jpg"></li>
            <li>기타 페스티벌 4중주</li>
          </ul>
        </div>
        <div class="items">
          <ul>
            <li><img src="../resources/img/img1.jpg"></li>
            <li>기타 페스티벌 4중주</li>
          </ul>
        </div>
      </div> <!-- galley_list -->
    </div> <!-- gallery_box -->		
  </section> <!-- gallery -->
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