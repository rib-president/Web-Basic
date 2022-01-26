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
	
	<div class="row mt-5">
		<div class="col"><h1>게시글 작성</h1></div>
	</div>

	<form action="../board/writeContentProcess" method="post" enctype="multipart/form-data">
	<div class="row mt-3">
		<div class="col">
		<div class="row">
			<div class="col-1">글쓴이 : </div>
			<div class="col">${sessionUser.member_nick }</div>
		</div>
		<div class="row mt-3">
			<div class="col-1">제목 : </div>
			<div class="col"><input type="text" name="board_title" class="form-control"></div>
		</div>
		<div class="row mt-3">
			<div class="col">내용 : </div>
		</div>
		<div class="row">
			<div class="col">
				<textarea name="board_content" class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col mb-3">
			  <input class="form-control" name="uploadFiles" type="file" id="formFileMultiple" multiple accept="image/*">
			</div>
		</div>		
		<div class="row mt-3">
			<div class="col">
				<button class="btn btn-dark">작성완료</button>
			</div>
		</div>
		</div>
	</div>
	</form>
	
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>