<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="./joinMemberProcess">
		ID : <input type="text" name="id"><br>
		PW : <input type="password" name="pw"><br>
		Nickname : <input type="text"><br>
		gender :
		<input type="radio"> 남
		<input type="radio"> 여<br>
		birth : <input type="date"><br>
		phone : <input type="text"><br>
		e-mail : <input type="text"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>