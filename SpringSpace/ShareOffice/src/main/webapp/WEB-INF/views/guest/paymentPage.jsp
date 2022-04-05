<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

<style>
body { padding-right: 0 !important }

.divider {background-color: #cccbcbe5; margin-top:1rem; margin-bottom:1rem}
</style>

<script>

	var rental_date_list = [];

	function convertRentalDate(totalResvDay) {
		var monthMap = new Map();
		
		monthMap.set("Jan", "01");
		monthMap.set("Feb", "02");
		monthMap.set("Mar", "03");
		monthMap.set("Apr", "04");
		monthMap.set("May", "05");
		monthMap.set("Jun", "06");
		monthMap.set("Jul", "07");
		monthMap.set("Aug", "08");
		monthMap.set("Sep", "09");
		monthMap.set("Oct", "10");
		monthMap.set("Nov", "11");
		monthMap.set("Dec", "12");
		
		rental_date_list = [];		
		
		for(var rental_date of document.getElementsByName("rental_date")) {
			var splitDate = rental_date.value.split(" ");
			var convertedDate = new Date(splitDate[5] + "-" + splitDate[1] + "-" + splitDate[2]);
			rental_date.value = convertedDate;
			
			var month = splitDate[1];
			if(monthMap.has(month)) {
				month = monthMap.get(month);
			}
			rental_date_list.push(splitDate[5] + "-" + month + "-" + splitDate[2]);
		}

		kakaoPay(totalResvDay);
	}
	
	// for mobile
	/*function kakaoPay(totalResvDay) {
		var xhr = new XMLHttpRequest();	
		
		var quantity = 1;			
		
		var item_name = '${officeInfo.officeInfoVo.office_name}' + "(" + totalResvDay + "일)";			
		
		var total_amount = document.querySelector("#totalPrice").innerText.split(",").join("");
		
		var rental_price_list = [];
		for(var rentalPrice of document.getElementsByName("rental_price")) {
			rental_price_list.push(rentalPrice.value);
		}
		
		var formData = new FormData(document.querySelector("#frm"));
		
		var sendData = {
			"item_name" : item_name,
			"quantity" : quantity,
			"total_amount" : total_amount,
			"office_no" : formData.get("office_no"),
			"order_personnel" : formData.get("order_personnel"),
			"rental_date" : rental_date_list,
			"rental_price" : rental_price_list,
			"allot_no" : formData.get("allot_no"),
			"coupon_discount" : formData.get("coupon_discount")
		};		
		
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);				

				location.href = data.next_redirect_mobile_url;
			}
		};
		
		xhr.open("POST", "../guest/payToKakao", true);
		xhr.setRequestHeader("Content-type","application/json");
		xhr.send(JSON.stringify(sendData));
	}*/
	
	
	// for pc
	function kakaoPay(totalResvDay) {
		var xhr = new XMLHttpRequest();	
		
		var quantity = 1;			
		
		var item_name = '${officeInfo.officeInfoVo.office_name}' + "(" + totalResvDay + "일)";			
		
		var total_amount = document.querySelector("#totalPrice").innerText.split(",").join("");
		
		var newWindow;
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);				
				
				var tidInput = document.createElement("input");
				tidInput.setAttribute("type", "hidden");
				tidInput.setAttribute("name", "order_tid");
				tidInput.value = data.tid;
				document.querySelector("form").appendChild(tidInput);
				
				newWindow = window.open(data.next_redirect_pc_url, "_blank");
			}
		};
		
		xhr.open("post", "../guest/payToKakao", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("item_name=" + item_name + "&quantity=" + quantity + "&total_amount=" + total_amount);
	}
	
	function sendMeData(data) {
		var frm = document.querySelector("form");

		if(data == 200) {
			frm.submit();
		} else {
			alert(data);
			return;
		}
	}			
	
	function applyCoupon() {
		var couponPrice = 0;
		for(var allotNo of document.querySelectorAll(".allotNo")) {
			if(allotNo.checked) {
				couponPrice = parseInt(allotNo.closest(".row").querySelector(".couponPrice").innerText.slice(0, -1).split(",").join(""));
				document.querySelector("#allot_no").value = allotNo.value;
				document.querySelector("#coupon_discount").value = couponPrice;
			}
		}
		document.querySelector("#couponPrice").innerText = couponPrice.toLocaleString();
		
		var originPrice = '${totalPayment }';
		totalPrice.innerText = (parseInt(originPrice) - couponPrice).toLocaleString();
		
		var offCanvasBottom = document.querySelector("#offcanvasBottom");
		offCanvasBottom.classList.remove("show");
		offCanvasBottom.setAttribute("style", "visibility: hidden");
		offCanvasBottom.setAttribute("aria-hidden", true);
		offCanvasBottom.removeAttribute("aria-modal");
		offCanvasBottom.removeAttribute("role");
		document.querySelector("body").setAttribute("style","");
		document.querySelector(".offcanvas-backdrop").classList.remove("show");		
	}
	
</script>

</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

	<div class="row" style="padding-top: 2em;">
	
		<div class="col"></div> <!-- 왼쪽 여백 -->
		
		<div class="col-10">
		<form id="frm" action="./orderProcess" method="post">
		
			<div class="row">
				<div class="col fs-2 center font-medium1">결제하기</div>
			</div>
			
			<div class="row mt-5">
				<div class="col fs-5">결제정보 <i class="bi bi-file-earmark-text text-gold"></i></div>
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
					
					<div class="row">
						<div class="col fw-light">
							예약날짜
						</div>
						<div class="col-8 fw-light right">
							<c:forEach items="${formatRentalDateList }" var="formatRentalDateList">
								<p>${formatRentalDateList }</p>
							</c:forEach>
						</div>
					</div>
					
					<div class="row"> <!-- 구분선 -->
						<div class="col divider" style="height:.25rem"></div>
					</div>
					<div class="row">
						<div class="col text-fs-16 pt-1">
							쿠폰 <i class="bi bi-ticket-perforated text-gold"></i>
						</div>
						<div class="col-6 right px-0" style="width:5rem">
							<button class="rounded-full bg-gray-c_e1t btn text-fs-11 font-bold right" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">쿠폰사용</button>
						</div>
					</div>					
					<div class="row"> <!-- 구분선 -->
						<div class="col divider" style="height:.25rem"></div>
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
											<p><fmt:formatNumber value="${totalPayment }"/>원<p>
										</div>
									</div>
									<div class="row">
										<div class="col">
											쿠폰 사용
										</div>
										<div class="col right">
											<p>(-) <span id="couponPrice">0</span>원<p>
										</div>
									</div>
									<div class="row"> <div class="col"><hr></div> </div> <!-- 구분선 -->
									<div class="row">
										<div class="col fs-4">
											총 결제 금액
										</div>
										<div class="col right fs-4">
											<p>￦ <span id="totalPrice"><fmt:formatNumber value="${totalPayment }"/></span>원<p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
										
				</div>
				
			</div>			
			
			<div class="row mt-5 leading-tight" style="height:1.5rem">
				<div class="col text-fs-13 pt-1">결제수단</div>
				<div class="col">
					<img class="ms-1 float-right" src="../resources/img/kakaopay.png" style="height:60%"><input type="radio" class="float-right form-check-input" checked>					
				</div>
			</div>
								
			<div class="row mt-1"> <!-- 결제하기버튼 -->
				<div class="col">
					<div class="d-grid">
						<button class="btn buttonColor" type="button" onclick="convertRentalDate(${fn:length(formatRentalDateList) })">결제하기</button>
						
					</div>
				</div>
			</div>
				
				<input type="hidden" name="office_no" value="${officeInfo.officeInfoVo.office_no }">
				<input type="hidden" name="order_personnel" value="${ovo.order_personnel }">
			<c:forEach items="${rental_date }" var="rentalDate">
				<input type="hidden" name="rental_date" value="${rentalDate }">
			</c:forEach>
			
			<c:forEach items="${businessDayVoList }" var="businessDayVoList">
				<input type="hidden" name="rental_price" value="${businessDayVoList.business_day_price }">
			</c:forEach>
				<input id="allot_no" type="hidden" name="allot_no" value="0">
				<input id="coupon_discount" type="hidden" name="coupon_discount" value="0">
			</form>
			
			<div class="row" style="padding:1em;"></div>
		
		</div>
		
		<div class="col"></div> <!-- 왼쪽 여백 -->
			
	</div>

<div class="offcanvas offcanvas-bottom h-50" tabindex="-1" id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasBottomLabel">쿠폰 사용 <i class="bi bi-bookmark-dash text-gold"></i></h5>    
  </div>
  <div class="offcanvas-body small">
  	<c:forEach items="${memberCouponList }" var="memberCoupon">
	     <div class="row border rounded-5 mt-2 py-3 px-3" style="margin-right:.8rem; margin-left:0.01rem">
	    	<div class="col-1 pt-4 me-2">
	    		<input type="radio" class="allotNo form-check-input" name="allot_no" value="${memberCoupon.allot_no }">
	    	</div>
	    	<div class="col">
	    		<div class="row text-fs-15 bold">
	    			<div class="couponPrice col"><fmt:formatNumber value="${memberCoupon.coupon_discount }"/> 원</div>
	    		</div>
	    		<div class="row mt-2 text-fs-13">
	    			<div class="col">${memberCoupon.coupon_name }</div>
	    		</div>
	    		<div class="row text-fs-11 text-gray-c_3c">
	    			<div class="col"><i class="bi bi-stopwatch text-gold"></i>&nbsp;<fmt:formatDate value="${memberCoupon.coupon_useDate }" pattern="yyyy년MM월dd일 HH:mm"/>까지</div>
	    		</div>
	    	</div>
	    </div> 	
  	</c:forEach>
	<div class="row mt-3" style="margin-right:.15rem;">
    	<div class="col d-grid">
    		<button type="button" class="btn btn-dark" onclick="applyCoupon()">선택완료</button>
    	</div>
    </div>         
  </div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>