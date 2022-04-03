<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<div class="row" style="background-color: #22223B; margin: auto;" id="banner">
   <div class="col pt-2"><i data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample" class="bi bi-list cursor-pointer text-fs-40" style="color:white;"></i></div>
   <div class="col text-center">
      <img alt="logo" src="../resources/img/logo.png">
   </div>
   <div class="col"></div>
</div>

<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Menu</h5>
    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
	<div class="row" style="padding-top:1.5rem">
		<c:choose>
			<c:when test="${empty sessionUser }">
				<div class="col cursor-pointer" onclick="location.href='../member/loginPage'">로그인</div>	
			</c:when>
			<c:otherwise>
				<div class="col cursor-pointer" onclick="location.href='../member/logoutProcess'">로그아웃</div>
			</c:otherwise>
		</c:choose>
		
	</div>

    <div class="row mt-3 mb-3">
    	<div class="col cursor-pointer" onclick="location.href='../member/testMyPage'">마이페이지</div>
    </div>
	<div class="row mt-3 mb-3">
		<div class="col cursor-pointer" onclick="location.href='../board/freeBoardPage'">자유게시판</div>
	</div> 
   <div class="row mt-3 mb-3">
		<div class="col cursor-pointer" onclick="location.href='../board/QnAPage'">Q&A</div>
	</div> 
  
    <div class="row mt-5 mb-3">
    	<div class="col cursor-pointer" onclick="location.href='../guest/officeListPage'">오피스 목록</div>
    </div>
	<div class="row mt-3 mb-3">
		<div class="col cursor-pointer" onclick="location.href='../guest/officeMapPage'">오피스 검색</div>
	</div>
	<c:if test="${!empty sessionUser }">
		<div class="row mt-3 mb-3">
			<div class="col cursor-pointer" onclick="location.href='../guest/officeRentalListPage'">오피스 예약 목록</div>
		</div>			
	</c:if>
	<c:choose>
		<c:when test="${!empty sessionUser && sessionUser.member_type == 'G' }">
			<div class="row mt-3 mb-3">
				<div class="col cursor-pointer" onclick="location.href='../guest/applyHostPage'">호스트 신청</div>
			</div>		
		</c:when>
		<c:when test="${!empty sessionUser && sessionUser.member_type == 'H' }">
			<div class="row mt-3 mb-3">
				<div class="col cursor-pointer" onclick="location.href='../host/mainPage'">호스트 센터</div>
			</div>
		</c:when>	
	</c:choose>    
  </div>
</div>