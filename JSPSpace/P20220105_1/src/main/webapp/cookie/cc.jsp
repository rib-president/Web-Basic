<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 제한 사항2(영어만 가능, 한글 안 됨)
	Cookie c1 = new Cookie("q1","qwer1");
	response.addCookie(c1);
	
	Cookie c2 = new Cookie("q2","qwer2");
	response.addCookie(c2);
	
	Cookie c3 = new Cookie("q3","qwer3");
	response.addCookie(c3);
	
	Cookie c4 = new Cookie("q4","qwer4");
	response.addCookie(c4);
	
	Cookie c5 = new Cookie("q5","qwer5");
	response.addCookie(c5);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	cc...
</body>
</html>