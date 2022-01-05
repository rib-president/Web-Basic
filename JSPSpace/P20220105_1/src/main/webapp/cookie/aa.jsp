<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// java(service = 코어로직, 비즈니스 로직)
	String value = "10";

	// 세션
	session.setAttribute("v1", value);	// 서버 메모리(RAM)에 저장
	
	// 쿠키 활용(value는 문자열만 가능)
	Cookie c1 = new Cookie("v1", value);
	response.addCookie(c1);	// 쿠키를 client가 저장하게 유도
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	aa...
</body>
</html>