<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">

<style>
	table {
		border-collapse: collapse;
		border-spacing: 0;
		width: 100%;
		border: 1px solid #ddd;
		font-size: 1em;
	}
	th, td {
  		text-align: left;
	}

	tr:nth-child(even) {
		background-color: #f2f2f2;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 70px;">
	
			<div style="overflow-x:auto;">
	<div class="col m-3">
	<%-- 내용작성 --%>
		<div class="row">
			<div class="col">
			
			
			<table class="table">
				 
				    <tr>
				      <th class="text-center">no</th>
				      <th class="text-center">제목</th>
				
				    </tr>
				 
				  <c:forEach items="${freeBoardList }" var="freeBoardList">
				    <tr>
				      	<td class="text-center">${freeBoardList.freeBoardVo.freeboard_no }</td>
				    	<td>
					      	
					      	<a href="./freeBoardReadPage?freeboard_no=${freeBoardList.freeBoardVo.freeboard_no }">
					      	 
					      	${freeBoardList.freeBoardVo.freeboard_title }
					      	</a>
					      	 <%-- 고민
					      	<c:if test="${!empty data.newKeyword }">
					      		<span class="badge bg-danger">new</span>
					      	</c:if>
					      	  --%> 
					      	  <br>
				      	<span>작성자 : ${freeBoardList.memberVo.member_nick }</span>
				      	<span>작성일 : <fmt:formatDate value="${freeBoardList.freeBoardVo.freeboard_writeDate }" pattern="M.dd" /></span>
				      	<span>조회수 : ${freeBoardList.freeBoardVo.freeboard_readCount }</span>
				      	</td>
				    	</tr>
					</c:forEach>
				
			</table>	
			
			</div>
			
		</div>
	</div>
</div>
		<div class="row">
			<div class="col">
				<%-- 수정
				<c:if test="${!empty sessionUser }">
				</c:if>
				 --%>
					<a href="./freeBoardWritePage" style="background-color: #adb5bd; color: white;" class="float-end btn btn-light">글쓰기</a>
				
			</div>
		</div>
			
		<div class="row">
			<div class="col"></div>
			<div class="col">
				
				<nav aria-label="...">
				  <ul class="pagination mb-0">
				  <c:choose>
				  	<c:when test="${startPage <= 1}">
					    <li class="page-item disabled">
					      <a class="page-link">&lt;</a>
					    </li>
				  	</c:when>
				  	<c:otherwise>
					    <li class="page-item">
					      <a class="page-link" href="./freeBoardPage?pageNum=${startPage-1 }">&lt;</a>
					    </li>
				  	</c:otherwise>
				  </c:choose>
				    <c:forEach begin="${startPage}" end="${endPage}" var="i">
				    	<c:choose>
				    		<c:when test="${currentPage == i}">
						    	<li class="page-item active">
						    		<a class="page-link" href="./freeBoardPage?pageNum=${i}">${i}</a>
						    	</li>
				    		</c:when>
				    		<c:otherwise>
						    	<li class="page-item">
						    		<a class="page-link" href="./freeBoardPage?pageNum=${i}">${i}</a>
						    	</li>
				    		</c:otherwise>
				    	</c:choose>
				    
				    </c:forEach>
				    <c:choose>
				    	<c:when test="${endPage >= totalPageCount}">
						    <li class="page-item disabled">
						      <a class="page-link">&gt;</a>
						    </li>
				    	</c:when>
				    	<c:otherwise>
						    <li class="page-item">
						      <a class="page-link" href="./freeBoardPage?pageNum=${endPage+1 }">&gt;</a>
						    </li>
				    	</c:otherwise>							    
				    </c:choose>
				  </ul>
				</nav>							
			
			
			</div>
			<div class="col"></div>
		</div>	


</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>