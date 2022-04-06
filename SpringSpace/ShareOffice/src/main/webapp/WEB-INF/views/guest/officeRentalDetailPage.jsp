<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

</head>
<body>
<div class="container-fluid px-0" style="overflow-x:hidden">
<jsp:include page="../commons/navbar.jsp"></jsp:include>

	<div class="row" style="padding-top: 2em;">
	
		<div class="col"></div> <!-- 왼쪽 여백 -->
		
		<div class="col-10">
		
			<div class="row">
				<div class="col fs-2 center font-medium1">예약상세</div>
			</div>
			
			<div class="row"> <!-- 결제정보 -->
			
				<div class="col">
					<div class="row">
						<div class="col fw-light">
							예약 오피스
						</div>
						<div class="col fw-light right">
							${orderData.officeVo.office_name }
						</div>
					</div>
					<div class="row mt-3">
						<div class="col fw-light">
							예약인원
						</div>
						<div class="col fw-light right">
							<p>${orderData.orderVo.order_personnel }명<p>
						</div>
					</div>
					
					<div class="row">
						<div class="col fw-light">
							예약날짜
						</div>
						<div class="col-8 fw-light right">
							<c:forEach items="${orderData.rentalVoList }" var="rentalVo">
								<p><fmt:formatDate value="${rentalVo.rental_date }" pattern="yyyy년 MM월 dd일(E)"></fmt:formatDate></p>
							</c:forEach>
						</div>
					</div>
					
					<div class="row"> <!-- 구분선 -->
						<div class="col divider" style="height:.25rem"></div>
					</div>
								
					<div class="row mt-5 leading-tight" style="height:1.5rem">
						<div class="col text-fs-13 pt-1">결제수단</div>
						<div class="col">
							<img class="ms-1 float-right" src="../resources/img/kakaopay.png" style="height:60%">				
						</div>
					</div>
					<div class="row mt-1">
						<div class="col">
							<div class="row">
								<div class="col fs-5">
									결제금액 <i class="bi bi-wallet2 text-gold"></i>
								</div>
							</div>
							<div class="row"> <div class="col"><hr></div> </div> <!-- 구분선 -->
							<div class="row">
								<div class="col">
									<div class="row">
										<div class="col">
											총 예약 금액
										</div>
										<div class="col right">
											<p><fmt:formatNumber value="${originPrice }"/>원<p>
										</div>
									</div>
									<div class="row">
										<div class="col">
											쿠폰 사용
										</div>
										<div class="col right">
											<p>(-) <fmt:formatNumber value="${couponPrice }원"/><p>
										</div>
									</div>
									<div class="row">
										<div class="col">
											결제 취소
										</div>
										<div class="col right">
											<p>(-) <fmt:formatNumber value="${cancelPrice }원"/><p>
										</div>
									</div>																		
									<div class="row"> <div class="col"><hr></div> </div> <!-- 구분선 -->
									<div class="row">
										<div class="col fs-4">
											총 결제 금액
										</div>
										<div class="col right fs-4">
											<p>￦  <fmt:formatNumber value="${totalPrice }"/>원<p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
										
				</div>
				
			</div>			


			
			<div class="row" style="padding:1em;"></div>
		
		</div>
		
		<div class="col"></div> <!-- 왼쪽 여백 -->
			
	</div>


<jsp:include page="../commons/footer.jsp"></jsp:include>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>