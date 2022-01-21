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
		alert("메일 인증을 완료해야 로그인이 가능합니다.");		
		location.href="../member/mailAuthPage?member_no=" + "<c:out value='${member_no }'/>";
	}
</script>
</head>
<body onload="onload_alert()">

</body>
</html>