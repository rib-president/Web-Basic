<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div style="width:1200px;margin : 0 auto">
  <div class="container-fluid">
	<div class="row">
		<div class="col"><!-- 글로벌 nav -->
			<jsp:include page="../commons/global_nav.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="row">
		<div class="col-2">제목 : </div>
		<div class="col">${resultVo.board_title }</div>
		<div class="col-2">조회수 : </div>
		<div class="col">${readCount }</div>
	</div>
	<c:forEach items="${resultVo.boardImageVo }" var="boardImageVo">
		<img src="${resultVo.boardImageVo.image_url }"><br>
	</c:forEach>

	<div class="row">
		<div class="col">내용 : </div>
	</div>
	<div class="row">
		<div class="col">${resultVo.board_content }</div>
	</div>
	<div class="row">
		<a class="btn btn-primary" href="../board/mainPageRN?pageNum=${pageNum }${tailParam }">목록</a>
	</div>
	
	
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>