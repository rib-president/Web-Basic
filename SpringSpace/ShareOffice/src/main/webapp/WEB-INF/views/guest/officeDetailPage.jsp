<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
 a {text-decoration: none; color:#A68A64;}
 a:link {
  color : #A68A64;
}
a:hover {
  color : #A68A64;
}
 a:active {
  color : #A68A64;
}
i {text-decoration: none; color:#A68A64;}

 
</style>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

	<div class="row" style="padding-top: 5em;">
		<div class="col">
		
			<!-- 이미지 -->
			<div class="row">
				<div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
					<div class="carousel-inner">
						<c:forEach items="${office.officeImageList }" var="imageVo"
							varStatus="image">
							<c:choose>
								<c:when test="${image.index == 0 }">
									<div class="carousel-item active" data-bs-interval="10000">
										<img src="/soUpload/officeImage/${imageVo.image_url }" width=100%, height=300em class="d-block w-100" alt="">
									</div>
								</c:when>
								<c:otherwise>
									<div class="carousel-item">
										<img src="/soUpload/officeImage/${imageVo.image_url}" width=100%, height=300em class="d-block w-100" alt="...">
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
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
					<span class="badge rounded-pill" style="background-color:#A68A64">${imageCount}</span>
				</div>
			</div>
			
			<!-- 설명 -->
			<div class="row mt-3 " style="margin: 1em">
				<div class="col ">
					<!-- 오피스 간단 소개 -->
					<div class="row mt-3">
						<h3>${office.officeVo.office_name }</h3>
					</div>
					<div class="row">
						<p>${office.officeVo.office_simpleContent }</p>
					</div>
					<div class="row">
						<p class="fs-7 text-muted">#${office.officeVo.office_tags }</p>
					</div>
					<div class="row">
					    <div class="col-7">공간 이용료</div>
                        <div class="col text-right"><p class="fw-bold">${office.businessDayList[0].business_day_price }~</p></div>	
                        <div class="col text-right">원/일</div>				
					</div>
					<div class="row ">
						<div class="col d-grid">
							<a href="./orderPage?office_no=${office.officeVo.office_no }" class="btn" style="background-color: #A68A64; color: #ffffff;">예약 하러 가기</a>
						</div>
					</div>
					
					<div class="row mt-3">
					   <ul class="nav nav-tabs"></ul>
					</div>
					
			
                    <!-- 오피스 상세 소개 -->
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
							<p class="fs-6 fw-bold">운영 시간</p>
							<table class="table table-borderless">
								<thead class="fw-lighter text-muted">
									<tr class="text-center" >
										<th scope="col">운영일</th>
										<th scope="col">운영 시간</th>
										<th scope="col">이용 가격</th>
									</tr>
								</thead>

								<c:forEach items="${office.businessDayList }" var="businessDayVo">
									<tbody>
										<tr class="table-light text-center">
											<td>${businessDayVo.business_day}</td>
											<td>${businessDayVo.business_time_start}-${businessDayVo.business_time_finish}</td>
											<td> <fmt:formatNumber value="${businessDayVo.business_day_price}" pattern="#,###"/> </td>
											
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
					</div>
					<div class="row mt-3">
					    <div class="col"> 
						      <p class="fs-6 fw-bold">추가 정보</p>
						</div>
						<p><i class="bi bi-people"></i> 최소 가능 인원: ${office.officeVo.office_personnel } 명</p>
						<p><i class="bi bi-calendar-check"></i> 최소 예약 일수: ${office.officeVo.office_min_booking_day } 일</p>
						<p><i class="bi bi-telephone"></i> 오피스 전화번호: ${office.officeVo.office_changedPhone }</p>			
					</div>
					
					<!-- 지도 출력 -->
					<div class="row mt-3">
					   <div class="col">
							<div class="row"><p class="fs-6 fw-bold">오피스 위치</p></div>
							<div class="row"><p><i class="bi bi-geo-alt"></i>${office.officeVo.office_address }, ${office.officeVo.office_address_detail }</p></div>
					   </div>					   					 
					</div>
					<div id="map" style="width:100%;height:21em;"></div>
					
					<div class="row mt-3">
					   <ul class="nav nav-tabs"></ul>
					</div>
					<!-- 리뷰보러가기 -->			
					<div class="row mt-2 ">
						<div class="col" >
						   <div class="row fw-bold">
						     <div class="col"> <a href="./officeReviewPage?office_no=${office.officeVo.office_no}">이용 후기</a><i class="bi bi-chevron-right"></i> </div>			     				  
						   </div>
							<div class="row mt-3">
								<div class="col">
									<c:forEach items="${orderList}" var="review" end="2">
										<div class="card" style="">
											<div class="row">
												<div class="col">
													<div class="card-body">
														<div class="row">
															<div class="col-8">
																<i class="bi bi-star-fill"></i> <i
																	class="bi bi-star-fill"></i> <i class="bi bi-star-fill"></i>
																<i class="bi bi-star-fill"></i> <i class="bi bi-star"></i>
															</div>
															<div class="col">
																<p class="card-text">
																	<small class="text-muted"><fmt:formatDate value="${review.reviewVo.review_date}" pattern="yyyy-MM-dd"/></small>
																</p>
															</div>

														</div>
														<div class="row">
															<div class="col">
																<img src="/soUpload/reviewImage/${review.reviewVo.review_image }"
																	class="img-fluid rounded-start">
															</div>
															<div class="col-8 text-left">
																<c:choose>
																	<c:when
																		test="${fn:length(review.reviewVo.review_title) > 10}">
																		<c:out
																			value="${fn:substring(review.reviewVo.review_title,0,9)}" />....
                                                </c:when>
																	<c:otherwise>
																		<c:out value="${review.reviewVo.review_title}" />
																	</c:otherwise>
																</c:choose>
																<br>
																<c:choose>
																	<c:when
																		test="${fn:length(review.reviewVo.review_content) > 10}">
																		<c:out
																			value="${fn:substring(review.reviewVo.review_content,0,9)}" />....
                                                </c:when>
																	<c:otherwise>
																		<c:out value="${review.reviewVo.review_content}" />
																	</c:otherwise>
																</c:choose>

															</div>
															<div class="col">
																<i class="bi bi-chevron-right"></i>
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>
									</c:forEach>
								</div>
							</div>

						</div>
					</div>
                   


                    <!-- Top 위로 스크롤 -->
					<div class="cursor-pointer" onClick="javascript:window.scrollTo(0,0)" style="position: fixed; bottom: 1.5em; right: 1.5em; z-index:99999;">
						 <i class="bi bi-chevron-double-up pl-2"></i>
						 <span class="block">TOP</span>
					</div>


				</div>
			</div>

		</div>
	</div>
	
<%--<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a89f71e1f43b65b9072477b5fb3f976&libraries=services"></script> --%>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dcba11bad3364b22a9a962b80ee0acfb&libraries=services"></script>
<script>
var mapContainer = document.getElementById("map"), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${office.officeVo.office_address}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });
 
        
        //마커가 지도 위에 표시되도록 설정합니다.
       marker.setMap(map);
       
        // 링크 바꿈 
        var iwContent = '<div style="padding:0.5em;">${office.officeVo.office_name}<br><a href="https://map.kakao.com/link/map/${office.officeVo.office_name}!,' + result[0].y + "," + result[0].x + '" style="color:#415a77" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/${office.officeVo.office_name}!,' + result[0].y + "," + result[0].x + '" style="color:#415a77" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
            iwPosition = new kakao.maps.LatLng(geocoder); //인포윈도우 표시 위치입니다
        
         // 인포윈도우로 장소에 대한 설명을 표시합니다
         var infowindow = new kakao.maps.InfoWindow({
             position : iwPosition, 
             content : iwContent 
            });
        
        
        
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    


</script>
<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>