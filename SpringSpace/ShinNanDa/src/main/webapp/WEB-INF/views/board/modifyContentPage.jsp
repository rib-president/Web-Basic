<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

<script>
	function addDeleteImage(image_no) {
		
		var addHiddenBox = document.createElement("input");
		addHiddenBox.setAttribute("type", "hidden");
		addHiddenBox.setAttribute("name", "del_image_nos");
		addHiddenBox.setAttribute("value", image_no);
		
		var hiddenBox = document.getElementById("hiddenBox");
		hiddenBox.appendChild(addHiddenBox);
		
		var removeImage = document.getElementById("image_" + image_no);
		removeImage.remove();
		
	}
</script>
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

	<form action="../board/modifyContentProcess" method="post" enctype="multipart/form-data">
	<div class="row mt-3">
		<div class="col">
		<div class="row">
			<div class="col-1">글쓴이 : </div>
			<div class="col">${sessionUser.member_nick }</div>
		</div>
		<div class="row mt-3">
			<div class="col-1">제목 : </div>
			<div class="col"><input type="text" name="board_title" class="form-control" value="${resultMap.BOARD_TITLE }"></div>
		</div>
		<div class="row mt-3">
			<div class="col">내용 : </div>
		</div>
		<div class="row">
			<div class="col">
				<textarea name="board_content" class="form-control" id="exampleFormControlTextarea1" rows="10">${resultMap.BOARD_CONTENT }</textarea>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col mb-3">
			  <input class="form-control" name="uploadFiles" type="file" id="formFileMultiple" multiple accept="image/*">
			</div>
		</div>
		<div class="row mt-1">
			<c:forEach items="${boardImageVoList }" var="boardImageVo">
				<div id="image_${boardImageVo.image_no }" class="col">
				${boardImageVo.image_originalname }<span><button onclick="addDeleteImage(${boardImageVo.image_no })"><i class="bi bi-x-circle"></i></button></span>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<div class="col" id="hiddenBox">
				<input type="hidden" name="board_no" value="${board_no }">
				<input type="hidden" name="pageNum" value="${pageNum }">
				<input type="hidden" name="tailParam" value="${tailParam }">
			</div>
		</div>
				
		<div class="row mt-3">
			<div class="col">
				<button class="btn btn-dark">수정완료</button>
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