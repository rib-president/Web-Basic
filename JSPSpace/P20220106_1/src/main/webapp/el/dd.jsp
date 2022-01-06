<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--jsp import code, 나중엔 java와 jsp 분리할 거라 사용할 일 없을 것 --%>    
<%@ page import="a.a.a.StudentVo" %>
<%
	// 출력돼야할 데이터
	int value = 10;
	request.setAttribute("v1", value);
	
	StudentVo vo = new StudentVo("한조", 39, 70);
	request.setAttribute("v2", vo);
	
	StudentVo vo2 = new StudentVo("트레", 15, 99);
	request.setAttribute("qwer", vo2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${v1 }<br>
	${v2.name }<br>
	${v2.score }<br>
	${v2.age }<br>
	
	${qwer.name }<br>
	${qwer.age }<br>
	${qwer.score }<br>
</body>
</html>