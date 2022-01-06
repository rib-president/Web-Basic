<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>

<%
	// 출력되어야할 데이터가 자료구조일 경우
	ArrayList<String> names = new ArrayList<>();

	names.add("한조1");
	names.add("트레이서...");
	names.add("한조2");
	names.add("한조3");
	names.add("한조4");
	names.add("한조5");
	
	request.setAttribute("names", names);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--items: 반복할 대상--%>
	<%--var: 값이 담길 변수(내부적으로 pagecontext에 var을 key로 value로 items의 원소 1개가 setAttribute됨) --%>
	<%--해당 var 변수는 forEach문 안에서만 사용가능, forEach문 밖에서 사용 불가 --%>
	
	<c:forEach items="${names }" var="qwer">
		${qwer }<br>
	</c:forEach>
</body>
</html>