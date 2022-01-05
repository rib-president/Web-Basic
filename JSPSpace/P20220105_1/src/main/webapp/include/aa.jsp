<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- action tag(html 태그가 아님) -->
	<!-- jsp 문법에서 제공하는 태그 -->
	<!-- include의 대상이 되는 page 처음부터 끝까지(<!DOCTYPE html>~~</html>)를 다 가져옴 -->
	<!-- html 문법을 파괴할 수도 있어 include의 대상 구조는 신경써서 작성해야함 -->
	<jsp:include page="./bb.jsp"></jsp:include>
	aa 입니다.
</body>
</html>