<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title>클래식기타 커뮤니티</title>
  <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
  <link rel="stylesheet" type="text/css" href="../resources/css/header.css">
  <link rel="stylesheet" type="text/css" href="../resources/css/footer.css">
  <link rel="stylesheet" type="text/css" href="../resources/css/board_left.css">
  <link rel="stylesheet" type="text/css" href="../resources/css/board_list_main.css">
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
    <div id="total_search">
      <div id="total">▷ 총 ${countBoard }개의 게시물이 있습니다.</div>
      <div id="search">
      <form action="../board/boardListPage">
        <div id="select_img"><img src="../resources/img/select_search.gif"></div>
        <div id="search_select">
          <select name="category">
			<c:choose>
				<c:when test="${category == 'content' }">
				  <option value="title">제목</option>
            	  <option value="content" selected>내용</option>
            	  <option value="writer">글쓴이</option>
				</c:when>
				<c:when test="${category == 'writer' }">
				  <option value="title">제목</option>
            	  <option value="content">내용</option>
            	  <option value="writer" selected>글쓴이</option>				
				</c:when>
				<c:otherwise>
				  <option value="title" selected>제목</option>
            	  <option value="content">내용</option>
            	  <option value="writer">글쓴이</option>				
				</c:otherwise>
			</c:choose>
          </select> 
        </div>
        <div id="search_input"><input type="text" name="keyword" value="${keyword }"></div>
        <div id="search_btn"><button><img src="../resources/img/search_button.gif"></button></div>
      </form>
      </div>
    </div>
    <table>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>일시</th>
        <th>조회수</th>
      </tr>
      <c:forEach items="${resultBoardList }" var="map">
      	<tr>
      		<td class="col1">${map.boardVO.board_no }</td>
      		<c:choose>
      			<c:when test="${!empty category && !empty keyword}">
      				<td class="col2"><a href="./boardViewPage?board_no=${map.boardVO.board_no }&category=${category }&keyword=${keyword }">${map.boardVO.board_title }</a></td>
      			</c:when>
      			<c:otherwise>
      				<td class="col2"><a href="./boardViewPage?board_no=${map.boardVO.board_no }">${map.boardVO.board_title }</a></td>
      			</c:otherwise>
      		</c:choose>
      		<td class="col3">${map.memberVO.member_nick }</td>
      		<td class="col4">${map.writedate }</td>
      		<td class="col5">${map.boardVO.board_readcount }</td>
      	</tr>
      </c:forEach>
    </table>
    <div id="buttons">
      <div class="col1">◀ 이전 1 다음 ▶</div>
      <div class="col2">
        <a href="./boardListPage"><img src="../resources/img/list.png"></a>
        <c:if test="${!empty sessionUser }">
        <a href="./boardWritePage"><img src="../resources/img/write.png"></a>
        </c:if> 
      </div>
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