<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<style>
a:link { color: black; text-decoration: none;}
a:visited { color: black; text-decoration: none;}
a:hover { color: black; text-decoration: underline;}

#writeBtn { color: white; text-decoration: none;}
</style>
</head>
<body>
<div style="width:1200px;margin : 0 auto">
	<div class="container-fluid">
		<div class="row">
			<div class="col"><!-- 글로벌 nav -->
				<jsp:include page="../commons/global_nav.jsp"></jsp:include>
			</div>
		</div>	
		<div class="row mt-3">
			<div class="col"><h1>전체 글 보기</h1></div>
		</div>

		<div class="row row-cols-1 row-cols-md-3 g-2">
		  <c:forEach items="${boardList }" var="board">
		  <div class="col">
		    <div class="card h-100">
 		      <h5 class="card-title">${board.memberVo.member_nick }</h5>
 		      <h6><fmt:formatDate value="${board.boardVo.board_writedate }" pattern="MMM dd, yyyy" /></h6>
		      <div class="card-body">
		      	<a href="" class="card-text">${board.boardVo.board_content }</a><br><br>
		      	<img src="${board.boardImageVo.image_url }" class="card-img-top" alt="Image not found">
		      </div>
		      <div class="card-footer">
		      	<small class="text-muted">글 번호 : ${board.boardVo.board_no }</small>
		        <small class="text-muted">조회수 : ${board.boardVo.board_readcount }</small>
		      </div>
		    </div>
		  </div>		  		  
		  </c:forEach>
		</div>			
		<div class="row mt-3">
			<div class="col-3"></div>
			<div class="col">
				<nav aria-label="...">
				  <ul class="pagination mb-0">
				    <c:choose>
				    	<c:when test="${startPage <= 1 }">
						    <li class="page-item disabled page-link">&lt;</li>	    	
				    	</c:when>
				    	<c:otherwise>
						    <li class="page-item">
						      <a class="page-link" href="./mainPageRN?pageNum=${startPage-1 }${tailParam }">&lt;</a>
						    </li>							    	
				    	</c:otherwise>
				    </c:choose>
				    <c:forEach begin="${startPage }" end="${endPage }" var="i">
						<c:choose>
							<c:when test="${currentPage == i }">
								<li class="page-item active">
				    			<a class="page-link" href="./mainPageRN?pageNum=${i }${tailParam }">${i }</a>
				    			</li>		
							</c:when>
							<c:otherwise>
								<li class="page-item">
				    			<a class="page-link" href="./mainPageRN?pageNum=${i }${tailParam }">${i }</a>
				    			</li>
							</c:otherwise>
						</c:choose>							   
				    </c:forEach>
				    <c:choose>
				    	<c:when test="${endPage >= totalPageCount }">
						    <li class="page-item disabled page-link">&gt;</li>	    	
				    	</c:when>
				    	<c:otherwise>
						    <li class="page-item">
						      <a class="page-link" href="./mainPageRN?pageNum=${endPage+1 }${tailParam }">&gt;</a>
						    </li>							    	
				    	</c:otherwise>
				    </c:choose>
				  </ul>
				</nav>
			</div>
			<div class="col-2 d-grid">
				<c:if test="${!empty sessionUser }">
					<a id="writeBtn" href="./writeContentPage" class="btn btn-primary">글쓰기</a>
				</c:if>
			</div>
		</div>		
	
		
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
</body>
</html>