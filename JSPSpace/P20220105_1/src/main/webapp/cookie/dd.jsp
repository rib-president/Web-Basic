<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Cookie[] arrCookie = request.getCookies();
	if(arrCookie != null) {
		for(Cookie x : arrCookie) {
			System.out.println("쿠키명 : " + x.getName() + 
					", 값 : " + x.getValue());
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
	dd...
</body>
</html>