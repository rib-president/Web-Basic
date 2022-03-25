<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
 a {text-decoration: none; color:#3ad0ab;}
 i {text-decoration: none; color:#3ad0ab;}
</style>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

	<div class="row" style="padding-top: 70px;">
		<div class="col">
			<%-- 내용작성 --%>
			<!-- 이미지 -->
			<div class="row">
				<div id="carouselExampleDark" class="carousel carousel-dark slide"
					data-bs-ride="carousel">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleDark"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleDark"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleDark"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active" data-bs-interval="10000">
							<img src="https://via.placeholder.com/150" class="d-block w-100"
								alt="임시 이미지">
							<div class="carousel-caption d-none d-md-block">
								<h5>First slide label</h5>
								<p>Some representative placeholder content for the first
									slide.</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="https://via.placeholder.com/150" class="d-block w-100"
								alt="임시 이미지">
							<div class="carousel-caption d-none d-md-block">
								<h5>Second slide label</h5>
								<p>Some representative placeholder content for the second
									slide.</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="https://via.placeholder.com/150" class="d-block w-100"
								alt="임시 이미지">
							<div class="carousel-caption d-none d-md-block">
								<h5>Third slide label</h5>
								<p>Some representative placeholder content for the third
									slide.</p>
							</div>
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleDark" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleDark" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>

			</div>
			<!-- 설명 -->
			<div class="row mt-3 " style="margin: 15px">
				<div class="col ">
					<div class="row mt-3">
						<h3>${office.officeVo.office_name }</h3>
					</div>
					<div class="row">
						<p>${office.officeVo.office_simpleContent }</p>
					</div>
					<div class="row">
						<p class="fs-7 text-muted">#${office.officeVo.office_tags }</p>
					</div>
					<div class="row ">
						<div class="col d-grid">
							<a href="./orderPage" class="btn btn-outline-secondary">예약 하러 가기</a>
						</div>
					</div>
					
					<div class="row mt-3">
					   <ul class="nav nav-tabs"></ul>
					</div>
					
					<!-- 상세 이미지 -->
					<div class="row">
						<div class="col">
							<c:forEach items="${office.officeImageList}" var="imageVo">
								<img src="/upload/${imageVo.image_url}">
								<br>
							</c:forEach>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">
							<p class="fs-6 fw-bold">오피스 소개</p>
						</div>
						<br>
						<p>${office.officeVo.office_detailContent }</p>
					</div>
					<div class="row mt-3">
					    <div class="col">
						     <p class="fs-6 fw-bold">편의시설</p>						
						<c:forEach items="${office.facilityCategoryList }" var="facilityVo">
							    <p>${facilityVo.facility_name }</p><br>
						</c:forEach>						     
						</div>
					</div>
					<div class="row mt-3">
					    <div class="col"> 
						      <p class="fs-6 fw-bold">추가 정보</p>
						</div>
						<p>-최소 가능 인원:${office.officeVo.office_personnel }명</p>
						<p>-최소 예약일:${office.officeVo.office_min_booking_day }일</p>
						<p>-위치:${office.officeVo.office_address }${office.officeVo.office_adrress_detail }
					</div>


					<div class="row mt-3">
						<div class="col">
							<p class="fs-6 fw-bold">운영 시간</p>
							<table class="table table-borderless">
								<thead class="fw-lighter text-muted">
									<tr >
										<th scope="col">운영일</th>
										<th scope="col">운영 시간</th>
										<th scope="col">이용 가격</th>
									</tr>
								</thead>

								<c:forEach items="${office.businessDayList }" var="businessDayVo">
									<tbody>
										<tr class="table-light">
											<td>${businessDayVo.business_day}</td>
											<td>${businessDayVo.business_time_start}-${businessDayVo.business_time_finish}</td>
											<td>${businessDayVo.business_day_price}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
					</div>
					<div class="row mt-3">
					   <ul class="nav nav-tabs"></ul>
					</div>
					<!-- 리뷰보러가기 -->
				
					<div class="row mt-2 ">
						<div class="col" >
						   <div class="row">
						     <div class="col-9"> <a href="./officeReviewPage?office_no=${office.officeVo.office_no }">이용 후기</a>  </div>
						     				  
						   </div>
							<div class="card" style="">
								<div class="row">									
									<div class="col">
										<div class="card-body">
										 <div class="row">
											<div class="col-8">
											   <i class="bi bi-star-fill"></i>
											   <i class="bi bi-star-fill"></i>
											   <i class="bi bi-star-fill"></i>
											   <i class="bi bi-star-fill"></i>
											   <i class="bi bi-star"></i> 
											</div> 
											<div class="col">
											  <p class="card-text"><small class="text-muted">리뷰 작성일</small></p>
											</div>
											
										 </div>	
										 <div class="row">  
										   <div class="col">
										      <img src="https://via.placeholder.com/70" class="img-fluid rounded-start" >
									       </div>
										   <div class="col-8 text-left">
										      <p class="card-text">디자인만 봐주세요</p>
											  <p class="card-text">출력 아직 못했습니다,,,</p>
										   </div>
										    <div class="col">
										      <i class="bi bi-chevron-right"></i>
										    </div>
										</div>	
										</div>
									</div>
									
								</div>
							</div>









							<div class="card">
						    <ul class="list-group list-group-flush">
								<c:forEach  items="${reviewList}" >
									<li class="list-group-item d-flex justify-content-between">
									    <div>${review.reviewVo.review_title }</div>
										<div>${review.reviewVo.review_content }</div>

									</li>
								</c:forEach>
							</ul>
						
						 </div>   
					     </div>
					</div>
                   


                    <!-- Top 위로 스크롤 -->
					<div class="row">
						<div class="col" style="">
							<div style="position: fixed; bottom: 1.5em; right: 1.5em;">
								<a href="#header" onClick="javascript:window.scrollTo(0,0)"><i
									class="bi bi-chevron-double-up"></i><br>TOP</a>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>