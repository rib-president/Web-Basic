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

 	<div class="row">
		<jsp:include page="../commons/menu_bar.jsp"></jsp:include>
		<div class="col">	  
			<div class="row">
				<div class="col"><h1>주문 내역</h1><hr></div>
			</div>

			<div class="row mt-3">
				<div class="col">
					<table class="table table-striped">
					  <thead>
					    <tr>
					      <th scope="col">주문 번호</th>
					      <th scope="col">주문일</th>
					      <th scope="col">이미지</th>
					      <th scope="col">상품 정보</th>
					      <th scope="col">주문 금액</th>
					      <th scope="col">주문 상태</th>
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach items="${totalVoList }" var="totalVo">
					    <tr>
					      <th scope="row">${totalVo.ordersVo.orders_no }</th>
					      <td><fmt:formatDate value="${totalVo.ordersVo.orders_date }" pattern="yyyy.MM.dd" /></td>
					      <td><img class="img-fluid" src="/upload/product/${totalVo.productVo.product_image }" style="width: 300px;"></td>
					      <td>
					      	<div class="row">
					      		<div class="col">
					      		  <h3>
					      		    <a href="../shop/detailOrdersInfoPage?orders_no=${totalVo.ordersVo.orders_no }">
					      		      ${totalVo.productVo.product_title } (${totalVo.product_DetailVo.product_detail_option })
					      		    </a>
					      		  </h3>
					      		</div>
					      	</div>
					      	<div class="row"><div class="col"> 외 ${totalVo.ordersCount }건</div></div>
					      </td>
					      <td>${totalVo.orders_price } 원</td>
					      <td>
					        <div class="row">
					          <div class="col">${totalVo.ordersVo.orders_state }</div>
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
					     </td>
					    </tr>
					  </c:forEach>
					  </tbody>				  
					</table>				
				</div>
			</div>		  
		  								
		</div>
 	</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>