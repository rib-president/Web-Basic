<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">

	<style>
	.ellipsis{
		overflow:hidden;
		text-overflow:ellipsis;
		white-space:nowrap;
	}
	.border_bottom{
		border-bottom:0.063em solid #d1d1d1;
	}
	.bold{
		font-weigth:bold;
	}
	.main_color{
		color:#464444;
	}
	
	.basic_color{
		color: #868e96
	}
	.complete_color{
		color:#38dd2b;
	}
	
	.pattern:nth-child(even) {
		background-color: #f8f9fa;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	
	</style>

</head>
<body>
<div class="container-fluid px-0" style="overflow-x : hidden">

	 
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
	
	
	
	<div class="row" style="padding-top: 2em ">
		
		<div class="col" style="margin: 1rem;">
			
			
			<div class="row">
				<div class="col text-center text-fs-23 bold"><i class="bi bi-file-text"></i> QnA</div>
			</div>
			<%--
			<div class="row mt-3">
				<div class="col text-center text-fs-20 bold">best 3</div>		
			</div>
				
			 --%>
			<div class="row mt-3">
				
				<div class="col-8 pr-0">
					<div class="pb-1 text-center text-fs-16 bold" style="border-bottom:0.125em solid;">best3 title</div>	
				</div>
				<div class="col-2 px-0">
					<div class="pb-1 text-center text-fs-16 bold" style="border-bottom:0.125em solid;">case</div>	
				</div>
				<div class="col-2 pl-0">
					<div class="pb-1 text-center text-fs-16 bold" style="border-bottom:0.125em solid;">date</div>	
				</div>
			</div>
			
				<c:forEach items="${hotQnAVoList }" var="hotList">
			<div class="row pt-1 text-center pattern">
					
				<div class="col-8 ml-3 py-2 pr-0">
					<div class="ellipsis"><a class="main_color text-fs-16 bold" href="QnAReadPage?qna_no=${hotList.QnAVo.qna_no }">
					${hotList.QnAVo.qna_title }</a></div>
				</div>
		
					<c:choose>
						<c:when test="${hotList.getCheckedQnAComment >= 1}">
				<div class="col-2 py-2 px-0 text_center text-fs-20"><i class="complete_color bi bi-patch-check"></i></div>
						</c:when>	
						<c:otherwise>
				<div class="col-2 py-2 px-0 text_center text-fs-20"><i class="bi bi-patch-question"></i></div>
						</c:otherwise>				
					</c:choose>
				
				
				<div class="col-2 py-2 pl-0">
					<div class="ellipsis"><fmt:formatDate value="${hotList.QnAVo.qna_writeDate }" pattern="M.dd"/></div>
				</div>
				
			</div>
				<hr class="my-1">
				</c:forEach>

	
			<div class="row mt-3">
				<div class="col text-center"><img src="../resources/img/iu-상큼.webp" style="width:20.438em;"></div>		
			</div>
			

	
			<div class="row mt-3">
				<div class="col-8 pr-0">
					<div class="pb-1 text-center text-fs-16 bold" style="border-bottom:0.125em solid;">title</div>	
				</div>
				<div class="col-2 px-0">
					<div class="pb-1 text-center text-fs-16 bold" style="border-bottom:0.125em solid;">case</div>	
				</div>
				<div class="col-2 pl-0">
					<div class="pb-1 text-center text-fs-16 bold" style="border-bottom:0.125em solid;">date</div>			
				</div>
				
			</div>		
			
			<c:forEach items="${QnABoardList }" var="List">
			
			
			
			<div class="row pt-1 pattern">
			
				<div class="col-8 pr-0">
				<%-- 비밀글 관련 --%>
					<c:choose>
						<c:when test="${List.QnABoardVo.qna_screct eq 'N' }">
							<c:choose>
								<c:when test="${(!empty sessionUser && sessionUser.member_no eq List.QnABoardVo.member_no) || !empty adminUser }">
									<div class="text-center ellipsis pr-0 py-2 text-fs-16 bold">
											<a class="main_color" href="QnAReadPage?qna_no=${List.QnABoardVo.qna_no }">${List.QnABoardVo.qna_title }</a></div>	
								</c:when>
								<c:otherwise>
									<div class="basic_color text-center ellipsis pr-0 py-2 text-fs-16 bold"><i class="py-3 text-fs-20 bi bi-file-lock-fill"></i> 비공개 글입니다.</div>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<div class="text-center text-fs-16 ellipsis pr-0 py-2 bold">
							<a class="main_color bold" href="QnAReadPage?qna_no=${List.QnABoardVo.qna_no }">${List.QnABoardVo.qna_title }</a></div>
						</c:otherwise>
					</c:choose>
				</div>
				
					<c:choose>
						<c:when test="${List.CheckedQnAComment >= 1}">
				<div class="col-2 px-0 py-2 text-center text-fs-20"><i class="complete_color bi bi-patch-check"></i></div>
						</c:when>	
						<c:otherwise>
				<div class="col-2 px-0 py-2 text-center text-fs-20"><i class="bi bi-patch-question"></i></div>
						</c:otherwise>				
					</c:choose>
				
				<div class="col-2 pl-0">
					<div class="text-center py-2"><fmt:formatDate value="${List.QnABoardVo.qna_writeDate }" pattern="M.dd"/> </div>
				</div>
			</div>
			<hr class="my-1">
			</c:forEach>
				<%--
			<div class="row">
				<div class="col">
					<a href="./QnAWritePage" style="background-color: #adb5bd; color: white;" class="float-end btn btn-light pt-2 px-0">글쓰기</a>
				</div>
			</div>
				 --%>
				<c:if test="${!empty sessionUser }">
					<div class="fixed " style="bottom: 4rem; right: 3rem; z-index: 99">
						<a href="QnAWritePage"><i class="bi bi-pencil" style="font-size: 2.5rem; color: #A68A64;"></i></a>
					</div>
				</c:if>
			
		
		
		<div class="row mt-3" style="padding-bottom: 2em;">
			<div class="col"></div>
			<div class="col">
				
				<nav aria-label="...">
				  <ul class="pagination mb-0 my">
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
						    	<li class="page-item active ">
						    		<a class="page-link" href="./freeBoardPage?pageNum=${i}" style="background-color: #A68A64; border-color: #A68A64">${i}</a>
						    	</li>
				    		</c:when>
				    		<c:otherwise>
						    	<li class="page-item">
						    		<a class="page-link" href="./freeBoardPage?pageNum=${i}" style="color: #A68A64;">${i}</a>
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
	</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>