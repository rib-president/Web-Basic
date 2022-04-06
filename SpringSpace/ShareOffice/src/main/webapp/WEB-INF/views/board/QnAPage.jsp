<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Q&A</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">
<style>
	#ellipsis{
		overflow:hidden;
		text-overflow:ellipsis;
		white-space:nowrap;
		
	}
	
</style>

</head>
<body>
<c:choose>
	<c:when test="${!empty adminUser }">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid" style="padding-left:550px;">
		    <a class="navbar-brand">관리자 모드</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link" href="../admin/hostManagement">호스트 관리</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="../admin/guestManagement">게스트 관리</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="../board/QnAPage">Q&A 관리</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="../admin/createCouponPage">쿠폰 발급</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="../admin/createdCouponListPage">발급 쿠폰 목록</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="../admin/logoutAdmin">로그아웃</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
	</c:when>
	<c:otherwise>
		<jsp:include page="../commons/navbar.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
<div class="col" style="padding-top:1%">
	<div class="row">
		<div class="col-1"></div>
		<div class="col-10 text-center">
		<label>추천 상위 top3</label>
		</div>
		<div class="col-1"></div>
	</div>
	
	<div class="row" style="padding-right: 0%;">
			<%-- 내용작성 --%>
			
		<div class="col-1">
			<div class="text-center"></div>			
		</div>
		<div class="col-6">
			<div class="text-center">title</div>	
		</div>
		<div class="col-2">
			<div class="text-center">case</div>	
		</div>
		<div class="col-3">
			<div class="text-center">작성일</div>			
		</div>
	<div class="row text-center" style="padding-right: 0%;margin-right: 0%;margin-left: 0%;padding-left: 0%;">
		<c:forEach items="${hotQnAVoList }" var="hotList">
		<div class="col-1"></div>	
		<div class="col-6">
			<div class="ellipsis"><a href="QnAReadPage?qna_no=${hotList.QnAVo.qna_no }">
			${hotList.QnAVo.qna_title }</a></div>
		</div>
		<div class="col-2">
			
			<div class="text_center">
			<%-- 버그 수정 필요 --%>
				<c:choose>
					<c:when test="${hotList.getCheckedQnAComment >= 1}">
						<img src="../resources/img/Answercomplete_img.png"/>
					</c:when>	
					<c:otherwise>
						<img src="../resources/img/Waiting_img.png"/>
					</c:otherwise>				
				</c:choose>
			</div>
			
			
						
		</div>
		<div class="col-3">
			<div class="ellipsis"><fmt:formatDate value="${hotList.QnAVo.qna_writeDate }" pattern="M.dd"/></div>
		</div>
		</c:forEach>
	</div>
	</div>
	<hr>
	<div class="row">
		<div class="col text-center">
		광고이미지
		</div>
	</div>
	<hr>

	<div class="row" style="padding-right: 0%;">
			<%-- 내용작성 --%>
		<div class="col-1">
			<div class="text-center"></div>			
		</div>
		<div class="col-6">
			<div class="text-center">title</div>	
		</div>
		<div class="col-2">
			<div class="text-center">case</div>	
		</div>
		<div class="col-3">
			<div class="text-center">작성일</div>			
		</div>
	
	
	<div class="row" style="padding-right: 0%;margin-right: 0%;margin-left: 0%;padding-left: 0%;">
		<c:forEach items="${QnABoardList }" var="List">
			<div class="col-1">
				<div class="text-center" ><c:if test="${List.QnABoardVo.qna_screct eq 'N' }"><i class="bi bi-file-lock-fill"></i></c:if></div>
			</div>
			<div class="col-6">
			<%-- 비밀글 관련 --%>
				<c:choose>
					<c:when test="${List.QnABoardVo.qna_screct eq 'N' }">
						<c:choose>
							<c:when test="${(!empty sessionUser && sessionUser.member_no eq List.QnABoardVo.member_no) || !empty adminUser }">
								<div class="text-center ellipsis">
										<a href="QnAReadPage?qna_no=${List.QnABoardVo.qna_no }">${List.QnABoardVo.qna_title }</a></div>	
							</c:when>
							<c:otherwise>
								<div class="text-center ellipsis">비공개 글입니다</div>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<div class="text-center" style="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;">
										<a href="QnAReadPage?qna_no=${List.QnABoardVo.qna_no }">${List.QnABoardVo.qna_title }</a></div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-2">
				<div class="text_center">
					<c:choose>
						<c:when test="${List.CheckedQnAComment >= 1}">
							<img src="../resources/img/Answercomplete_img.png"/>
						</c:when>	
						<c:otherwise>
							<img src="../resources/img/Waiting_img.png"/>
						</c:otherwise>				
					</c:choose>
				</div>
					
			</div>
			<div class="col-3">
			
				<div class="text-center"><fmt:formatDate value="${List.QnABoardVo.qna_writeDate }" pattern="M.dd"/> </div>
			</div>
		</c:forEach>
	</div>
	</div>	
	<div class="row">
		<div class="col">
			<%-- 수정
			<c:if test="${!empty sessionUser }">
			</c:if>
			 --%> 
			<a href="./QnAWritePage" style="background-color: #adb5bd; color: white;" class="float-end btn btn-light">글쓰기</a>
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
				      <a class="page-link" href="./QnAPage?pageNum=${startPage-1 }">&lt;</a>
				    </li>
			  	</c:otherwise>
			  </c:choose>
			    <c:forEach begin="${startPage}" end="${endPage}" var="i">
			    	<c:choose>
			    		<c:when test="${currentPage == i}">
					    	<li class="page-item active">
					    		<a class="page-link" href="./QnAPagee?pageNum=${i}">${i}</a>
					    	</li>
			    		</c:when>
			    		<c:otherwise>
					    	<li class="page-item">
					    		<a class="page-link" href="./QnAPage?pageNum=${i}">${i}</a>
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
					      <a class="page-link" href="./QnAPage?pageNum=${endPage+1 }">&gt;</a>
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
