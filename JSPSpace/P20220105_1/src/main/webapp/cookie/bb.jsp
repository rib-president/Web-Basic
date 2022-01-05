<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// java
	
	// 세션에서 값 뽑아오는 법
	String v1 = (String) session.getAttribute("v1");
	System.out.println("session v1 : " + v1);
	
	// 쿠키에서 값 뽑아오는 법(하나만 못 뽑음, 전체 다 뽑아야 함)
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("v1")) {	// getName() : 쿠키의 키 값 뽑음
				String cookieValue = cookie.getValue();
				System.out.println("cookie v1 : " + cookieValue);
			}
		}
	}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	bb...
</body>
</html>