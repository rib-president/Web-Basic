<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>
<%@ page import="a.a.a.StudentVo"%>

<%
	ArrayList<StudentVo> list = new ArrayList<>();
	
	list.add(new StudentVo("한조1", 30, 90));
	list.add(new StudentVo("한조2", 30, 90));
	list.add(new StudentVo("한조3", 30, 90));
	list.add(new StudentVo("한조4", 30, 90));
	list.add(new StudentVo("한조5", 30, 90));
	
	request.setAttribute("studentList", list);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${studentList }" var="student">
		${student.name }<br>
	</c:forEach>
</body>
</html>