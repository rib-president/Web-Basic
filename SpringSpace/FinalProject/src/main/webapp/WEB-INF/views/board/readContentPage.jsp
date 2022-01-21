<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<title>Insert title here</title>
</head>
<body>
	<h1>${data.boardVO.board_title }</h1>
	
	작성자 : ${data.memberVO.member_nick }<br>
	작성일 : ${data.boardVO.board_writedate }<br>
	조회수 : ${data.boardVO.board_readcount }<br>
	
	이미지 : <br>
	<c:forEach items="${data.boardImageVOList }" var="boardImageVO">
		<img src="/upload/${boardImageVO.image_url }"><br>
	</c:forEach>
	
	
	내용 :<br>
	${data.boardVO.board_content }<br>
	
	<br>
	<c:if test="${!empty sessionUser }">
		<c:choose>
			<c:when test="${myLikeCount > 0 }">
				<a href="./likeProcess?board_no=${data.boardVO.board_no }"><i class="bi bi-heart-fill fs-1 text-danger"></i></a>		
			</c:when>
			<c:otherwise>
				<a href="./likeProcess?board_no=${data.boardVO.board_no }"><i class="bi bi-heart fs-1 text-danger"></i></a>	
			</c:otherwise>
		</c:choose>
	<br>
	
	</c:if>
	좋아요 수 : ${totalLikeCount }
	<br>
	
	<br><a href="./mainPage">목록으로</a>
	
	<!-- 로그인+본인이 쓴 글일경우 수정, 삭제 버튼 나타남 -->
	<c:if test="${!empty sessionUser && sessionUser.member_no == data.boardVO.member_no }">
	<a href="./deleteContentProcess?board_no=${data.boardVO.board_no }">삭제</a>
	<a href="./updateContentPage?board_no=${data.boardVO.board_no }">수정</a>
	</c:if>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
</body>
</html>