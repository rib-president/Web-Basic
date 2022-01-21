<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증키 입력</title>

<style>
	#container {margin: 0px auto; width: 1200px;}
</style>
</head>
<body>
	<div id="container">
		<div>인증키를 입력해주세요.(30초 이내에 발행된 인증 메일만 유효합니다.)</div>
		<div>
		<form action="mailAuthProcess" method="post">
			<input type="text" name="mailauth_key"><br>
			<input type="hidden" name="member_no" value="${member_no }"><br>
			<input type="submit" value="인증하기"><br>
		</form>
		<br>
		<c:choose>
			<c:when test="${deny_no == 1 }"><div>인증 키가 만료되었습니다. 인증메일 재발송 버튼을 눌러주세요.</div></c:when>
			<c:when test="${deny_no == 2 }"><div>인증 키가 일치하지 않습니다. 재입력 또는 인증메일 재발송 버튼을 눌러주세요.</div></c:when>
		</c:choose>
		</div>
		<div><a href="./resendMailAuthProcess?member_no=${member_no }">인증메일 재발송</a></div>
	
	
	
	</div>
</body>
</html>