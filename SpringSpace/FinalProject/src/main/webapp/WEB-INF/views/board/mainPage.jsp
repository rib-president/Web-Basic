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
		<tr>
			<td>3</td>
			<td>안녕하세요~!!</td>
			<td>트레이서</td>
			<td>22.1.3</td>
			<td>13</td>		
		</tr>										
		<tr>
			<td>2</td>
			<td>반갑습니다...</td>
			<td>한조</td>
			<td>22.1.1</td>
			<td>43</td>		
		</tr>	
		<tr>
			<td>1</td>
			<td>하하하하핳 밥먹자</td>
			<td>피즈</td>
			<td>21.12.31</td>
			<td>55</td>		
		</tr>																					
	</table>
	<c:if test="${!empty(sessionUser) }">
		<a href="./writeContentPage">글쓰기</a>
	</c:if>
</body>
</html>