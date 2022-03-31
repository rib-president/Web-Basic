<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>호스트/오피스 상세 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

		<div class="row" style="padding-top: 4rem;">
			<div class="col">
			
				<div class="row" style="padding-top: 4rem";>
					<div class="col">
						
						<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
							  <div class="carousel-inner">
							  	<c:forEach items="${data.imageDetailVoList }" var="image" varStatus="sttttttttt">
							  	
							  	<c:choose>
							  		<c:when test="${sttttttttt.index == 0 }">
							    <div class="carousel-item active">
							      <img src="/soUpload/officeImage/${image.image_url}" class="d-block w-100" alt="...">
							    </div>
							  		</c:when>
							  		<c:otherwise>
							    <div class="carousel-item">
							      <img src="/soUpload/officeImage/${image.image_url}" class="d-block w-100" alt="...">
							    </div>
							  		</c:otherwise>
							  	</c:choose>
							  	
							    </c:forEach>
							  </div>
							  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
							    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
							    <span class="visually-hidden">Previous</span>
							  </button>
							  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
							    <span class="carousel-control-next-icon" aria-hidden="true"></span>
							    <span class="visually-hidden">Next</span>
							  </button>
						</div>
					</div>
				</div>
				
					<!-- <div class="row"></div>  -->
					<!-- <div class="col"></div>  -->
					
				<div class="row" style="padding-top: 4rem;">
					<div class="col">
					<div class="card" style="width: 17.5rem;">
				 	<div class="card-body">
				 	
				 	<div class="row mt-3">
				 	<div class="col">
				    <h5 class="card-title">${data.officeInfoVo.office_name }</h5>
					</div>
				    <p class="card-subtitle mb-2 text-muted">${data.officeInfoVo.office_address } <br> ${data.officeInfoVo.office_address_detail }</p>
				    </div>
				    
				    <hr class="my-4">
				    
				    <div class="row mt-3">
				    <div class="col">
				    <h6>담당자 전화번호</h6>
				    </div>
				    <h6 class="card-subtitle mb-2 text-muted">${data.officeInfoVo.office_managerPhone }</h6>
				    </div>
				    
				    <hr class="my-4">
				    
				    <div class="row mt-3">
				    <div class="col">
				    <h6>대여공간 상세설명</h6>
				    </div>
				    <p class="card-subtitle mb-2 text-muted">${data.officeInfoVo.office_detailContent }</p>
				    </div>
				    
				    <hr class="my-4">
				    
				    <div class="row mt-3">
				    <div class="col">
				    <h6>특징 키워드</h6>
				    </div>
				    <p class="card-subtitle mb-2 text-muted">#${data.officeInfoVo.office_tags }</p>
				    </div>				    
				    
				    <hr class="my-4">
				    
				    <div class="row mt-3">
				    <div class="col">
				    <h6>예약옵션</h6>
				    </div>
				    <h6 class="card-subtitle mb-2 text-muted">-사용가능인원 : ${data.officeInfoVo.office_personnel }명</h6>
				    <h6 class="card-subtitle mb-2 text-muted">-최소예약일 : ${data.officeInfoVo.office_min_booking_day }일</h6>
				    </div>
				    
				    <hr class="my-4">
				    	
				    <div class="row mt-3">
				    <div class="col">
				   	 <h6>운영요일 및 시간</h6>
				   	</div> 
				     <c:forEach items="${data.businessDayVoList }" var="day">
				    <h6 class="card-subtitle mb-2 text-muted">-${day.business_day }요일 ${day.business_time_start }시 ~ ${day.business_time_finish }시</h6>
				    </c:forEach>
				    </div>
				    
				    <hr class="my-4">
				    
				    <div class="row mt-3">
				    <div class="col">
				     <h6>편의시설</h6>
				    </div>
				     <c:forEach items="${data.facilityCategoryVoList }" var="facility">
				    <h6 class="card-subtitle mb-2 text-muted">-${facility.facility_name }</h6> 
				     </c:forEach>
				    </div>
				    
				    <hr class="my-4">
				    
				    <div class="row mt-3">
				    <div class="col">
				    <h6>승인상태</h6>
				    </div>
				    <c:if test="${data.officeInfoVo.office_approve eq 'P' }">
				    	<p class="card-subtitle mb-2 text-muted">승인대기중</p>
				    </c:if>
				    
				    <c:if test="${data.officeInfoVo.office_approve eq 'Y' }">
				    	<p class="card-subtitle mb-2 text-muted">승인완료</p>
				    </c:if>
				    
				    <c:if test="${data.officeInfoVo.office_approve eq 'N' }">
				    	<p class="card-subtitle mb-2 text-muted">승인거절</p>
				    	<p class="card-subtitle mb-2 text-muted">${data.officeInfoVo.office_approve_comment }</p>
				    </c:if>				    				    
				    </div>	
				    
				    <hr class="my-4">
				    
					<div class="d-grid gap-2">
					  <button type="button" class="btn btn-dark" onclick="location.href='./updateOfficePage?office_no=${data.officeInfoVo.office_no }'">수정</button>
					  <button type="button" class="btn btn-outline-dark" onclick="location.href='./deleteOfficeProcess?office_no=${data.officeInfoVo.office_no }'">삭제</button>
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