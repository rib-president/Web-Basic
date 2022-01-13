<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty(sessionUser) }">
			${sessionUser.member_nick }(${sessionUser.member_no })님 환영합니다.<br>
			가입일 : ${sessionUser.member_joindate }<br>
			<a href="../member/logoutProcess">로그아웃</a>
		</c:when>
		<c:otherwise>
			비회원으로 접근하였습니다. <a href="../member/loginPage">로그인 페이지로</a> 
		</c:otherwise>
	</c:choose>
	
	<h1>게시판</h1>
	
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>		
		</tr>										
		<c:forEach items="${dataList }" var="data">
		<tr>
			<td>${data.boardVO.board_no }</td>
			<td><a href="./readContentPage?board_no=${data.boardVO.board_no }">${data.boardVO.board_title }</a></td>
			<td>${data.memberVO.member_nick }</td>
			<td>${data.boardVO.board_writedate }</td>
			<td>${data.boardVO.board_readcount }</td>
		</tr>
		</c:forEach>																					
	</table>
	<c:if test="${!empty(sessionUser) }">
		<a href="./writeContentPage">글쓰기</a>
	</c:if>
</body>
</html>