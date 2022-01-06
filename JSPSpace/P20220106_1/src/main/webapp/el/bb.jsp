<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("a1", 1111);
	request.setAttribute("a2", "안녕하세요");
	request.setAttribute("a3", null);
	request.setAttribute("a4", 2222);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${a1 }<br>
	${a2 }<br>
	${a3 }<br>
	${a4 }<br>
	${a5 }<br>	<!-- a5는 없음 -->
</body>
</html>