<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 각기 다른 저장공간에서 같은 key 사용하여 저장했을 경우
	pageContext.setAttribute("v1", 1111);
	request.setAttribute("v1", 2222);
	session.setAttribute("v1", 3333);
	application.setAttribute("v1", 4444);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${v1 }<br>
	${requestScope.v1 }<br>	<!-- request의 저장공간에서 탐색하는 것 명시-->
</body>
</html>