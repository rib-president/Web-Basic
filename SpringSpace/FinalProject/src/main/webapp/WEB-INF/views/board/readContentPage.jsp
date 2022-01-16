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
	<h1>${data.boardVO.board_title }</h1>
	
	작성자 : ${data.memberVO.member_nick }<br>
	작성일 : ${data.boardVO.board_writedate }<br>
	조회수 : ${data.boardVO.board_readcount }<br>
	내용 :<br>
	${data.boardVO.board_content }<br>
	
	<a href="./mainPage">목록으로</a>
	
	<!-- 로그인+본인이 쓴 글일경우 수정, 삭제 버튼 나타남 -->
	<c:if test="${!empty sessionUser && sessionUser.member_no == data.boardVO.member_no }">
	<a href="./deleteContentProcess?board_no=${data.boardVO.board_no }">삭제</a>
	<a href="./updateContentPage?board_no=${data.boardVO.board_no }">수정</a>
	</c:if>
</body>
</html>