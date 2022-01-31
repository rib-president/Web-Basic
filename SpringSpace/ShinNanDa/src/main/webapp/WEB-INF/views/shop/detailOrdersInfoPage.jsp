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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">

</head>
<body>
<div style="margin: 0 auto;">
 <div class="container-fluid">
	<div class="row">
		<div class="col"><!-- 글로벌 nav -->
			<jsp:include page="../commons/global_nav.jsp"></jsp:include>
		</div>
	</div>

	<c:set var="totalPrice" value="0" />
 	<div class="row">
		<jsp:include page="../commons/menu_bar.jsp"></jsp:include>
		<div class="col">	  
			<div class="row">
				<div class="col"><h1>주문 상세 정보</h1><hr></div>
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
				  <form action="../shop/modifyOrdersState" method="post">
				    <input type="hidden" name="orders_no" value="${ordersVo.orders_no }">
					<c:choose>
					  <c:when test="${ordersVo.orders_state == '입금대기'}">
					    <input type="hidden" name="orders_state" value="입금완료">					 
					    <button class="btn btn-danger">입금완료</button>
					  </c:when>
					  <c:when test="${ordersVo.orders_state == '배송중'}">
					    <input type="hidden" name="orders_state" value="배송완료">
					    <button class="btn btn-danger">배송완료</button>					    
					  </c:when>	
					</c:choose>
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
			  		<div class="col-1">받는 분 : </div>
			  		<div class="col">${ordersVo.orders_name }</div>
			  	</div>
			  	<div class="row mt-3">
			  		<div class="col-1">주소 : </div>
			  		<div class="col">${ordersVo.orders_address }</div>
			  	</div>
			  	<div class="row mt-3">
			  		<div class="col-1">핸드폰 번호 : </div>
			  		<div class="col">${ordersVo.orders_phone }</div>
			  	</div>
			  	<div class="row mt-3">
			  		<div class="col-1">이메일 : </div>
			  		<div class="col">${sessionUser.member_email }</div>
			  	</div>			  					  					  	
			  </div>
			</div>
			  
		  								
		</div>
 	</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>