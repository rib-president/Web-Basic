<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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