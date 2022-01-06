<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 여기는 jsp가 아님(java code라 생각)
	int a = 12;
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
	<c:choose>
		<c:when test="${v1 < 10 }">
			<div>10보다 작습니다.</div>
		</c:when>
		<c:when test="${v1 < 20 }">
			20보다 작습니다.
		</c:when>
		<c:otherwise>	<%-- else --%>
			그 이외 경우입니다.
		</c:otherwise>
	</c:choose>
</body>
</html>