<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	int v1 = (int) request.getAttribute("v1");
	
	if(v1 > 50) {
		out.println("v1은 50보다 큽니다.");
	} else {
		out.println("v1은 50과 작습니다.");
	}
%>
</body>
</html>