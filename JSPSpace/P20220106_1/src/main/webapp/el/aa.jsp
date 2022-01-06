<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 분리된 servlet 코드 or model(business/core logic) 부분이라고 생각
	int a1 = 20;
	String b1 = "안녕하세요";
	
	// html로 출력되어야할 값을 request 저장공간에 담는다
	request.setAttribute("xxx1", a1);
	request.setAttribute("xxx2", b1);
	
	// 아래 jsp로 forwarding 된다고 가정
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${xxx1 }<br>
	${xxx2 }
</body>
</html>