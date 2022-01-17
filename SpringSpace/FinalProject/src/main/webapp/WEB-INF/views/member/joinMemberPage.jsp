<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="./joinMemberProcess" method="post">
		ID : <input type="text" name="member_id"><br>
		PW : <input type="password" name="member_pw"><br>
		Nickname : <input type="text" name="member_nick"><br>
		gender :
		<!-- 체크, 라디오, 셀렉트는 value값을 미리 지정해야함 -->
		<input type="radio" name="member_gender" value="M" checked> 남
		<input type="radio" name="member_gender" value="F"> 여<br>
		
		취미 :
		<c:forEach items="${hobbyCategoryList }" var="hobbyCategory">
			<input type="checkbox" name="hobby_category_no" value="${hobbyCategory.hobby_category_no }">${hobbyCategory.hobby_category_name }
		</c:forEach>
		<br>
		
		birth : <input type="date" name="member_birth"><br>
		phone : <input type="text" name="member_phone"><br>
		e-mail : <input type="text" name="member_email"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>