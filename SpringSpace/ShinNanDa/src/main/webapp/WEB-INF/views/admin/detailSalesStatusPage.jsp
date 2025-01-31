<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="../resources/css/commons.css" rel="stylesheet">

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dcba11bad3364b22a9a962b80ee0acfb&libraries=services"></script>
<script>

	window.addEventListener("DOMContentLoaded", function() {
		var mapContainer = document.getElementById("map"), // 지도를 표시할 div 
		mapOption = {
		    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		    level: 3 // 지도의 확대 레벨
		};  
		
		//지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		//주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		//주소로 좌표를 검색합니다
		geocoder.addressSearch(document.querySelector("#address").innerText, function(result, status) {
		
		// 정상적으로 검색이 완료됐으면 
		 if (status === kakao.maps.services.Status.OK) {
		
		    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		    // 결과값으로 받은 위치를 마커로 표시합니다
		    var marker = new kakao.maps.Marker({
		        map: map,
		        position: coords
		    });
		
		    // 인포윈도우로 장소에 대한 설명을 표시합니다
		    var infowindow = new kakao.maps.InfoWindow({
		        content: '<div style="width:150px;text-align:center;padding:6px 0;">배송지</div>'
		    });
		    infowindow.open(map, marker);
		
		    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		    map.setCenter(coords);
		} 
		});
		
	});	

	
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
		<jsp:include page="../commons/admin_menu_bar.jsp"></jsp:include>


	 	<div class="row">
			<div class="col">	  
				<div class="row">
					<div class="col"><h1>판매 상세 정보</h1><hr></div>
				</div>
				<div class="row">
					<div class="col">
						<h3>주문 일자 : <fmt:formatDate value="${ordersVo.orders_date }" pattern="yyyy.MM.dd" /></h3>
					</div>
					<div class="col">
						<h3>주문 번호 : ${ordersVo.orders_no } </h3>
					</div>
					<div class="col">
						<h3>진행 상태 : ${ordersVo.orders_state }</h3>
					</div>
					
					<div class="col">
					  <form action="../admin/modifyOrdersState" method="post">
					    <input type="hidden" name="orders_no" value="${ordersVo.orders_no }">
					    <input type="hidden" name="isDetailPage" value="true">
				  	    <c:if test="${ordersVo.orders_state == '입금완료'}">
					      <input type="hidden" name="orders_state" value="배송중">					 
					      <button class="btn btn-danger">배송 시작</button>
					    </c:if>
				      </form>	
					</div>
									
				</div>
				<div class="row mt-3">
					<div class="col">
						<table class="table table-striped">
						  <thead>
						    <tr>
						      <th scope="col">상품 주문 번호</th>
						      <th scope="col">이미지</th>
						      <th scope="col">상품 정보</th>
						      <th scope="col">판매가</th>
						      <th scope="col">수량</th>
						      <th scope="col">배송비</th>
						      <th scope="col">합계</th>
						    </tr>
						  </thead>
						  <tbody>
						  <c:forEach items="${totalVoList }" var="totalVo">
						    <tr>
						      <th scope="row">${totalVo.orders_DetailVo.orders_detail_no }</th>
						      <td><img class="img-fluid" src="/upload/product/${totalVo.productVo.product_image }" style="width: 300px;"></td>
						      <td>
						      	<div class="row">
						      		<div class="col"><h3>${totalVo.productVo.product_title }</h3></div>
						      	</div>
						      	<div class="row">
						      		<div class="col">${totalVo.product_DetailVo.product_detail_option }</div>
						      	</div>
						      </td>
						      <td>${totalVo.productVo.product_price }</td>
						      <td>${totalVo.orders_DetailVo.orders_detail_count }</td>
						      <td>무료</td>
						      <td>${totalVo.productVo.product_price * totalVo.orders_DetailVo.orders_detail_count }</td>
						    </tr>
	
						    <c:set var="totalPrice" value="${totalVo.productVo.product_price * totalVo.orders_DetailVo.orders_detail_count + totalPrice }" />
						  </c:forEach>
						  </tbody>
						  <tfoot>
						    <tr>
						      <td></td>
						      <td>
						        <div class="row">
						          <div class="col">주문 금액 합계 :</div>
						          <div class="col">${totalPrice } 원</div>
						        </div>
						      </td>
						      <td></td>
						      <td></td>
						      <td></td>
						      <td></td>
						      <td></td>
						    </tr>
						  </tfoot>					  
						</table>				
					</div>
				</div>
				
				<div class="row mt-5">
				  <div class="col">
				  	<h2>배송지 정보</h2>
				  	<hr>
				  	<div class="row mt-3">
				  		<div class="col-2">받는 분 : </div>
				  		<div id="receiver" class="col">${ordersVo.orders_name }</div>
				  	</div>
				  	<div class="row mt-3">
				  		<div class="col-2">주소 : </div>
				  		<div id="address" class="col">${ordersVo.orders_address }</div>
				  	</div>
				  	<div class="row mt-3">
				  		<div class="col-2">핸드폰 번호 : </div>
				  		<div class="col">${ordersVo.orders_phone }</div>
				  	</div>
				  	<div class="row mt-3 mb-5">
				  		<div class="col-2">이메일 : </div>
				  		<div class="col">${memberEmail }</div>
				  	</div>
				  	<c:if test="${!empty payResult }">
					  	<h2>카카오페이 결제 정보</h2>
					  	<hr>
					  	<div class="row mt-3">
					  		<div class="col-2">tid : </div>
					  		<div class="col">${payResult.tid }</div>
					  	</div>
					  	<div class="row mt-3">
					  		<div class="col-2">status : </div>
					  		<div class="col">${payResult.status }</div>
					  	</div>
					  	<div class="row mt-3">
					  		<div class="col-2">결제 승인 시각 : </div>
					  		<div class="col">${payResult.approved_at }</div>
					  	</div>					  						  	
				  	</c:if>			  					  					  	
				  </div>
				  
				  <div id="map" class="col" style="width:100%;height:350px;"></div>
				</div>
				  
			  								
			</div>
	 	</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>