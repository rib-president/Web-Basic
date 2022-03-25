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

<script src="https://cdn.tutorialjinni.com/jquery-ui-multidatespicker/1.6.6/jquery-ui.multidatespicker.js"></script>
<script src="https://cdn.tutorialjinni.com/jquery-ui-multidatespicker/1.6.6/jquery-ui.multidatespicker.min.js"></script> 

<link href="../resources/css/mobiscroll.jquery.min.css" rel="stylesheet" />
<script src="../resources/js/mobiscroll.jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="../resources/css/commons.css">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/datePickerStyle.css">

<script>

	var today = new Date();

	function orderValidCheck() {
		
		//submit 실행
		var frm = document.getElementById("frm");
		frm.submit();
	}
	
	/*
	$.multiDatesPicker.setDefaults({
	  dateFormat: 'yy-mm-dd',
	  prevText: '이전 달',
	  nextText: '다음 달',
	  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	  showMonthAfterYear: true,
	  yearSuffix: '년'
	});
	*/
	
	$(function(){
	    $('.datepicker').multiDatesPicker();
	  });
	
	/*
	$(function() {
	    $.datepicker._selectDateOverload = $.datepicker._selectDate;
	    $.datepicker._selectDate = function (id, dateStr) {
	        var target = $(id);
	        var inst = this._getInst(target[0]);
	        if (target[0].multiDatesPicker != null) {
	            inst.inline = true;
	            $.datepicker._selectDateOverload(id, dateStr);
	            inst.inline = false;
	            target[0].multiDatesPicker.changed = false;
	        } else {
	            $.datepicker._selectDateOverload(id, dateStr);
	            target.multiDatesPicker.changed = false;
	        }
	        this._updateDatepicker(inst);
	    };
	 
	    $(".day-off").multiDatesPicker({
	        dateFormat: "yy-mm-dd"
	    });
	}); */
	
	mobiscroll.setOptions({
	    theme: 'ios',
	    themeVariant: 'light'
	});

	$(function () {
	    $('#demo-multi-day').mobiscroll().datepicker({
	        controls: ['calendar'],
	        dateFormat: 'YYYY-MM-DD',
	        display: 'inline',
	        selectMultiple: true,
	        min: today
	    });

	});
	  
	
</script>

</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

	<div class="row" style="padding-top: 70px;">
	
		<div class="col"></div> <!-- 왼쪽 여백 -->
		
		<div class="col-10">
		<form id="frm" action="./paymentPage" method="post">
			<div class="row mt-5">
				<div class="col fs-2 center">예약하기</div>
			</div>
			
			<div class="row mt-5">
				<div class="col fs-5">예약 공간</div>
			</div>
			
			<div class="row"><div class="col"><hr></div></div> <!-- 구분선 -->
		
			<div class="row"> <!-- 예약 오피스 정보 -->
				<div class="col-6">
					<img src="../resources/img/testImage.jpg" width="160em" height="170em">
			   <!-- <img src="/upload/${officeInfo.officeInfoVo.office_thumbnail }" width="100%" height="100%"> -->
				</div>
			
				<div class="col">
				
					<div class="row">
						<div class="col fs-5">
							<p>${officeInfo.officeInfoVo.office_name }</p>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p class="grayColor">${officeInfo.officeInfoVo.office_simpleContent }</p>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p class="grayColor">${officeInfo.officeInfoVo.office_detailContent }</p>
						</div>
					</div>
					
				</div>
			</div>
			
			<div class="row mt-5">
				<div class="col">
				
					<div class="row mt-5">
						<div class="col">오피스 운영 요일, 시간 및 가격</div>
					</div>
					
					<c:forEach items="${officeBusinessDayInfo }" var="obdi">
					<div class="row">
						<div class="col fw-light">
							<span>${obdi.businessDayVo.business_day }
							&#40;${obdi.businessDayVo.business_time_start}:00 ~ ${obdi.businessDayVo.business_time_finish}:00&#41; / 
							<fmt:formatNumber value="${obdi.businessDayVo.business_day_price }"/>원</span>
						</div>
					</div>
					</c:forEach>
					
				</div>
			</div>
			
			<div class="row mt-2">
				<div class="col">
					최소예약일수 : <span class="fw-light">${officeInfo.officeInfoVo.office_min_booking_day }일</span>
				</div>
			</div>
			
			
			<div class="row mt-5">
				<div class="col fs-5">예약 날짜 및 인원</div>
			</div>
			
			<div class="row"><div class="col"><hr></div></div> <!-- 구분선 -->
			
			<div class="row mt-4">
				<div class="col">인원선택</div>
			</div>
			
			<div class="row mt-2"> <!-- 인원체크 -->
				<div class="col">
					 <input id="personnelInput" type="number" name="order_personnel" class="form-control" min="1" max="30" value="1"/>
				</div>
			</div>
			
			<div class="row mt-3">
				<div class="col">날짜선택</div>
			</div>
			
			<div class="row mt-2"><!-- 날짜체크 -->
			
			<div class="col">
				<input type="text" name="rental_date" class="datepicker form-control">
			</div>
			
			</div>
			
			<div class="row" style="padding:150px;"></div>
			
			
			<div class="row mt-5">
				<div class="col">
					<div class="d-grid">
						<button class="btn btn-dark" onclick="orderValidCheck(event)">결제하기</button>
						<input type="hidden" name="office_no" value="${officeInfo.officeInfoVo.office_no }">
					</div>
				</div>
			</div>
			
			</form>
			
			<div class="row" style="padding:50px;"></div>
		
		</div>
		
		<div class="col"></div> <!-- 왼쪽 여백 -->
			
	</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>