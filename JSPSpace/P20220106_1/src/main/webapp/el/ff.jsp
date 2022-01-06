<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int a = 20;
	int b = 20;
	String c = "30";
	String d = "49";
	
	request.setAttribute("v1", a);
	request.setAttribute("v2", b);
	request.setAttribute("v3", c);
	request.setAttribute("v4", d);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${v1 }<br>
	${v2 }<br>
	${v3 }<br>
	${v1 >= v2 }<br>
	${v1 == v2 }<br>
	${v1 < v2 }<br>
	${v1 == v3 }<br>
	${v3 == v4 }<br>
	
	${!empty(v5) }<br>
	${!empty(v4) }<br>
</body>
</html>