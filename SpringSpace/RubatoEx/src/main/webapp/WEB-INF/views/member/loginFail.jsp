<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function onload_alert() {
		alert("로그인 실패! 아이디와 비밀번호를 확인해 주세요");		
		location.href="../" + "<c:out value='${redirectPath }'/>";
	}
</script>
</head>
<body onload="onload_alert()">

</body>
</html>