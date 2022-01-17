<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/header.css">
<link rel="stylesheet" type="text/css" href="../resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="../resources/css/board_left.css">
<link rel="stylesheet" type="text/css" href="../resources/css/board_view_main.css">

<style>
.fleft { float: left;}
.fright { float: right;}
.comment_div {margin: 5px; }
</style>
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
  <jsp:include page="../commons/loginBox.jsp"></jsp:include>
  <nav id="sub_menu">
    <ul>
      <li><a href="./boardListPage">+ 자유 게시판</a></li>
      <li><a href="#">+ 방명록</a></li>
      <li><a href="#">+ 공지사항</a></li>
      <li><a href="#">+ 등업 요청</a></li>
      <li><a href="#">+ 포토갤러리</a></li>
    </ul>
  </nav>
  <article id="sub_banner">
    <ul>
      <li><img src="../resources/img/banner1.png"></li>
      <li><img src="../resources/img/banner2.png"></li>		
      <li><img src="../resources/img/banner3.png"></li>
    </ul>	
  </article>
</aside> 

<section id="main">
  <img src="../resources/img/comm.gif">
  <h2 id="board_title">자유 게시판 </h2>
  <div id="view_title_box"> 
    <span>${resultBoard.boardVO.board_title }</span>
    <span id="info">${resultBoard.memberVO.member_nick } | 조회 : ${resultBoard.boardVO.board_readcount } | <fmt:formatDate value="${resultBoard.boardVO.board_writedate }" pattern="yyyy-MM-dd (HH:mm)" /></span>
  </div>	
  <p id="view_content">
  ${resultBoard.boardVO.board_content }
  </p>
  
  <c:forEach items="${resultComment }" var="comment">
  <hr>
  <div style="overflow: hidden;">
  <c:choose>
  	<c:when test="${!empty modifyCommentNo && modifyCommentNo == comment.commentVO.comment_no }">
  	  <form action="../comment/commentModifyByNoProcess" method="post">
 		<div class="fleft comment_div">${comment.memberVO.member_nick } </div>
  		<textarea name="comment_content">${comment.commentVO.comment_content }</textarea>
  		<input type="hidden" name="comment_no" value="${modifyCommentNo }">
  		<input type="hidden" name="board_no" value="${comment.commentVO.board_no }">
  		<input type="submit" value="수정 완료">
  	  </form>
  	</c:when>
	<c:otherwise>
		<div class="fleft comment_div">${comment.memberVO.member_nick } </div>
	  	<div class="fleft comment_div">${comment.commentVO.comment_content }</div>
	  	<div class="fright comment_div"><fmt:formatDate value="${comment.commentVO.comment_writedate }" pattern="yy-MM-dd" /></div>
	  	<c:if test="${sessionUser.member_no == comment.memberVO.member_no }">
	  		<div class="fright comment_div"><a href="../comment/commentDeleteByNoProcess?comment_no=${comment.commentVO.comment_no }&board_no=${comment.commentVO.board_no }">삭제 </a></div>
	  		<div class="fright comment_div"> | </div>
	  		<div class="fright comment_div"><a href="../comment/commentModifyByNoPage?comment_no=${comment.commentVO.comment_no }&board_no=${comment.commentVO.board_no }"> 수정</a></div>
	  	</c:if>	
	</c:otherwise>
  </c:choose>
  </div>
  </c:forEach>
  <c:choose>
  	<c:when test="${!empty sessionUser }">
	  <form action="../comment/commentWriteProcess" method="post">		
  	  <div id="comment_box">
    	<img id="title_comment" src="../resources/img/title_comment.gif">
    	<textarea name="comment_content"></textarea>
    	<input type="hidden" name="board_no" value="${resultBoard.boardVO.board_no }">
    	<input type="hidden" name="member_no" value="${sessionUser.member_no }">
    	<button><img id="ok_ripple" src="../resources/img/ok_ripple.gif"></button>
  	  </div>
  	  </form>
  	</c:when>
  	<c:otherwise>
  	  <div id="comment_box">
    	<img id="title_comment" src="../resources/img/title_comment.gif">
    	<textarea disabled placeholder="로그인 후 사용할 수 있는 기능입니다"></textarea>
    	<button disabled><img id="ok_ripple" src="../resources/img/ok_ripple.gif"></button>
  	  </div>  	
  	</c:otherwise>
  </c:choose>
  <div id="buttons">
  	<c:if test="${!empty sessionUser && sessionUser.member_no == resultBoard.boardVO.member_no }">
  	<a href="./boardModifyPage?board_no=${resultBoard.boardVO.board_no }"><img src="../resources/img/modify.png"></a>
    <a href="./boardDeleteProcess?board_no=${resultBoard.boardVO.board_no }"><img src="../resources/img/delete.png"></a>
    </c:if>	
    
    <c:choose>
    	<c:when test="${!empty category && !empty keyword }">
    		<a href="./boardListPage?category=${category }&keyword=${keyword }"><img src="../resources/img/list.png"></a>
    	</c:when>
    	<c:otherwise>
			<a href="./boardListPage"><img src="../resources/img/list.png"></a>    	
    	</c:otherwise>
    </c:choose>
   	<c:if test="${!empty sessionUser }">
    <a href="./boardWritePage"><img src="../resources/img/write.png"></a>
    </c:if>			
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
</body>
</html>