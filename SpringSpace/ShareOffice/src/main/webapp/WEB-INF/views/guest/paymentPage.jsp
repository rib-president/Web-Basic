<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="../resources/css/commons.css">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/datePickerStyle.css">

<script>

	function paymentValidCheck() {
		
		//submit 실행
		var frm = document.getElementById("frm");
		frm.submit();
	}
	
	
	
</script>

</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

	<div class="row" style="padding-top: 70px;">
	
		<div class="col"></div> <!-- 왼쪽 여백 -->
		
		<div class="col-10">
		<form id="frm" action="orderAndPaymentProcess" method="post">
		
			<div class="row mt-5">
				<div class="col fs-2 center">결제하기</div>
			</div>
			
			<div class="row mt-5">
				<div class="col fs-5">결제정보</div>
			</div>
			
			<div class="row"> <div class="col"><hr></div> </div> <!-- 구분선 -->
			
			<div class="row"> <!-- 결제정보 -->
			
				<div class="col">
					<div class="row">
						<div class="col fw-light">
							예약 오피스
						</div>
						<div class="col fw-light right">
							${officeInfo.officeInfoVo.office_name }
						</div>
					</div>
					<div class="row mt-3">
						<div class="col fw-light">
							예약인원
						</div>
						<div class="col fw-light right">
							<p name="order_personnel">${ovo.order_personnel }명<p>
						</div>
					</div>
					
					<div class="row mt">
						<div class="col fw-light">
							예약날짜
						</div>
						<div class="col fw-light right">
							<c:forEach items="${formatRentalDateList }" var="formatRentalDateList">
								<p>${formatRentalDateList }</p>
							</c:forEach>
						</div>
					</div>
					
					<div class="row mt-5">
						<div class="col fs-4">
							결제금액
						</div>
						<div class="col right fs-4">
							<p><fmt:formatNumber value="${totalPayment }"/>원<p>
						</div>
					</div>
				</div>
				
			</div>
			
			<div class="row"> <!-- 구분선 -->
				<div class="col"><hr></div>
			</div>
			
			<div class="row mt-5">
				<div class="col fs-5">결제수단</div>
			</div>
			
			<div class="row mt-3"> <!-- 결제수단 선택 -->
				<div class="col">
					<div class="row">
						<div class="col">
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="order_payment" value="creditCard">
							  <label class="form-check-label">신용카드</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="order_payment" value="accountTransfer">
							  <label class="form-check-label">계좌이체</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="order_payment" value="kakaoPay">
							  <label class="form-check-label">카카오페이</label>
							</div>
						</div>
					</div>
					<div class="row"> <!-- 구분선 -->
						<div class="col"><hr></div>
					</div>
				</div>
			</div>
			
			<div class="row" style="padding:40px;"></div><!-- 여백 -->
			
			<div class="row mt-3"> <!-- 결제하기버튼 -->
				<div class="col">
					<div class="d-grid">
						<button class="btn btn-dark" onclick="paymentValidCheck(event)">결제하기</button>
						
					</div>
				</div>
			</div>
				
				<input type="hidden" name="office_no" value="${officeInfo.officeInfoVo.office_no }">
				<input type="hidden" name="order_personnel" value="${ovo.order_personnel }">
				
			<c:forEach items="${rental_date }" var="rental_date">
				<input type="hidden" name="rental_date" value="${rental_date }">
			</c:forEach>
			
			<c:forEach items="${businessDayVoList }" var="businessDayVoList">
				<input type="hidden" name="rental_price" value="${businessDayVoList.business_day_price }">
			</c:forEach>
			
			</form>
			
			<div class="row" style="padding:30px;"></div>
		
		</div>
		
		<div class="col"></div> <!-- 왼쪽 여백 -->
			
	</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>