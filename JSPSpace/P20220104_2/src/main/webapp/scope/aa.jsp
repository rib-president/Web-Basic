<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/* 네 가지 저장공간 :
	 pageContext, request, session, application
	 -모두 setAttribute, getAttribute 메소드 제공
	 -key와 value(map)로 넣을 수 있음
	 -key의 타입은 항상 String
	 -value의 타입은 Object => 다형성에 의해 아무 값이나 넣을 수 있음
	 -각각 life cycle(생명주기)이 다름
	 -특히, request(MVC 핵심), session(대부분 인증 정보 담는 용도)이 중요
	*/
	
	// key<String>, value<Object>
	pageContext.setAttribute("v1","page 값");
	request.setAttribute("v2", "request 값");
	session.setAttribute("v3", "session 값");
	application.setAttribute("v4", "application 값");
	
	String v1 = (String) pageContext.getAttribute("v1");
	System.out.println(v1);
	String v2 = (String) request.getAttribute("v2");
	System.out.println(v2);
	String v3 = (String) session.getAttribute("v3");
	System.out.println(v3);
	String v4 = (String) application.getAttribute("v4");
	System.out.println(v4);
	
	
	// 주의사항
	// 없는 값 get하면 exception이 아닌 정상적으로 null값 리턴
	// => session쪽에서 이거 잘 이용해야함
	String v7 = (String) session.getAttribute("v7");
	System.out.println(v7);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL : Expression Language, jsp 문법 -->
	<!-- 네 가지 저장공간에서 값 뽑아오기 -->
	<!-- getAttribute 결과값을 출력하는 용도(key값을 따옴표 없이 사용) -->
	1: ${v1 }<br>
	2: ${v2 }<br>
	3: ${v3 }<br>
	4: ${v4 }
</body>
</html>