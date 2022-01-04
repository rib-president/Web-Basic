<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// <% .. 이 scriptlet은 앞으로 java코드로 빼내야될 코드임
	request.setCharacterEncoding("utf-8");
	String v1 = request.getParameter("v1");	// 제일 중요!
	System.out.println("v1 : " + v1);

	String v2 = request.getParameter("v2");	// 제일 중요!
	System.out.println("v2 : " + v2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
테스트...
</body>
</html>