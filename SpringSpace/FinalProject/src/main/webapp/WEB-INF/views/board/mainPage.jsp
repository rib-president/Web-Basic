<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div style="width:1200px; margin: 0 auto;">
		<div class="container-fluid">
			<div class="row">
				<div class="col"> <!-- 글로벌 navi -->
					<jsp:include page="../commons/global_nav.jsp"></jsp:include>
				</div>
			</div>		
			<div class="row ">
				<div class="col"></div>
				<div class="col-10">
					<div class="row my-3">	<!-- 배너 -->
						<div class="col">
							<img src="../resources/img/banner.jpg" class="img-fluid">
						</div>
					</div>
				
					<div class="row mt-3">	<!-- 검색 -->
						<div class="col">
							<select class="form-select">
								<option>제목</option>
								<option>내용</option>
								<option>닉네임</option>
							</select>
						</div>
						<div class="col-8">
							<input type="text" class="form-control" placeholder="검색할 단어를 입력하세요">
						</div>
						<div class="col d-grid">
							<input type="submit" value="검색" class="btn btn-primary">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">
							<table class="table table-hover">
							  <thead>
							    <tr>
							      <th scope="col">글번호</th>
							      <th scope="col">제목</th>
							      <th scope="col">작성자</th>
							      <th scope="col">작성일</th>
							      <th scope="col">조회수</th>
							    </tr>
							  </thead>
							  <tbody>
							    <c:forEach items="${dataList }" var="data">
							    <tr>
							    	<th scope="row">${data.boardVO.board_no }</th>
							    	<td><a href="./readContentPage?board_no=${data.boardVO.board_no }">${data.boardVO.board_title }</a></td>
							    	<td>${data.memberVO.member_nick }</td>
							    	<td>${data.boardVO.board_writedate }</td>
							    	<td>${data.boardVO.board_readcount }</td>
							    </tr>
							    </c:forEach>
							  </tbody>
							</table>
						</div>
					</div>
					<div class="row mt-1">
						<div class="col-3"></div>
						<div class="col">
							<nav aria-label="...">
							  <ul class="pagination mb-0">
							    <li class="page-item disabled">
							      <a class="page-link">Previous</a>
							    </li>
							    <li class="page-item"><a class="page-link" href="#">1</a></li>
							    <li class="page-item active" aria-current="page">
							      <a class="page-link" href="#">2</a>
							    </li>
							    <li class="page-item"><a class="page-link" href="#">3</a></li>
							    <li class="page-item"><a class="page-link" href="#">4</a></li>
							    <li class="page-item"><a class="page-link" href="#">5</a></li>
							    <li class="page-item">
							      <a class="page-link" href="#">Next</a>
							    </li>
							  </ul>
							</nav>
						</div>
						<div class="col-2 d-grid">
							<c:if test="${!empty sessionUser }">
								<a href="./writeContentPage" class="btn btn-primary">글쓰기</a>
							</c:if>
						</div>
					</div>
				</div>
				<div class="col"></div>
			</div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>