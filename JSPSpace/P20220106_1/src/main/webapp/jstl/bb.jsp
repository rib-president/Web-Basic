<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--prefix는 c로 고정 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	// 여기는 jsp가 아님(java code라 생각)
	int a = 30;
	request.setAttribute("v1", a);
	
	// forwarding하여 아래로 간다는 가정
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 큰 따옴표와 $대괄호 사이는 절대 공백없이 할 것 -->
	<c:if test="${v1 > 50 }">
		50보다 큽니다.
	</c:if>
	
	<c:if test="${v1 <= 50 }">
		50보다 작습니다.
	</c:if>
</body>
</html>