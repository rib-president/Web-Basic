<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ page import="java.util.*" %>
<%@ page import="a.a.a.*" %>  
    
<%
	// 자료구조를 넣을 수 있음(핵심)
	HashMap<String, Object> map = new HashMap<>();
	
	map.put("v1", "안녕하세요");
	map.put("v2", "111");
	map.put("v3", "222");
	
	StudentVo st1 = new StudentVo("베인", 40, 77);
	map.put("v4", st1);
	
	request.setAttribute("xx", map);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${xx.v1 }<br>
	${xx.v2 }<br>
	${xx.v3 }<br>
	${xx.v4.name }<br>
	${xx.v4.age }<br>
	${xx.v4.score }<br>
</body>
</html>