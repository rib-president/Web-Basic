<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>대여공간등록페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">

    <!-- Favicons -->
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 48rem) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
	<script type="text/javascript">
		function checkDay(e){
			
			var priceBox = e.parentElement.parentElement.parentElement.querySelector('.price');
			var startTimeBox = e.parentElement.parentElement.parentElement.querySelector('.start-time');
			var endTimeBox = e.parentElement.parentElement.parentElement.querySelector('.end-time');

			if(e.checked == true){
				priceBox.setAttribute("name" , "business_day_price");
				startTimeBox.setAttribute("name" , "business_time_start");				
				endTimeBox.setAttribute("name" , "business_time_finish");
				
			}else{
				priceBox.removeAttribute("name");
				startTimeBox.removeAttribute("name");				
				endTimeBox.removeAttribute("name");				
			}
		}
	
	</script>
    
</head>
<body class="bg-light">
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 4rem;">
	<div class="col">
		<%-- 내용작성 --%>
	<form action="./registerOfficeProcess" method="post" enctype="multipart/form-data">
    
	<div class="container">
	    <div class="py-4 text-center">
	      <h2>환영합니다!</h2>
	      <p class="lead">지금 MZ세대들을 위한 공간비즈니스를 시작해보세요!</p>
	    </div>
		<hr class="my-4">
	    
	    <div class="row g-5">

	      <div class="col-md-7 col-lg-8">
	        <h4 class="mb-3">오피스 등록하기</h4>
	          <div class="row g-3">
	            <div class="col-sm-6">
	            	  오피스명
	              <input type="text" class="form-control" name="office_name" placeholder="오피스명을 입력하세요." required >
	              <div class="invalid-feedback">
	                	공간명을 입력하세요.
	              </div>
	            </div>
	
	            <div class="col-sm-6">
	           		   공간 간단소개
	              <input type="text" class="form-control" name="office_simpleContent" placeholder="공간의 특징을 간단하게 작성하세요." required>
	              <div class="invalid-feedback">
	                	공간간단소개를 입력하세요.
	              </div>
	            </div>
	            
	            <div class="col-sm-6">
	              <label for="office_detailContent" class="form-label">공간소개</label>
	              <textarea rows="10" cols="80" class="form-control" name="office_detailContent" placeholder="게스트들에게 필요한 공간정보를 상세하게 소개해주세요!" required></textarea>
	              <div class="invalid-feedback">
	                	공간소개를 입력하세요.
	              </div>
	            </div>
	            
	            <div class="col-sm-6">
	              <label for="office_tags" class="form-label">공간태그</label>
	              <input type="text" class="form-control" name="office_tags" placeholder="주요특징들을 키워드로 입력해주세요." required>
	              <div class="invalid-feedback">
	                	공간태그를 입력하세요.
	             </div>
				</div>
	            
	            <div class="col-sm-6">
	              <label for="office_personnel" class="form-label">사용가능인원</label>
	              <input type="number" class="form-control" name="office_personnel" id="personnelInput" min="1" max="30" value="1" required/>
	              <small class="text-muted">최소인원은 1명입니다.</small>
	              <div class="invalid-feedback">
	                	사용가능인원을 선택하세요.
	              </div>
	            </div>
				
	            <div class="col-sm-6">
	              <label for="office_min_booking_day" class="form-label">최소예약일</label>
	              <input type="number" class="form-control" name="office_min_booking_day" id="personnelInput" min="1" max="1000" value="1" required/>
	              <small class="text-muted">최소예약 가능일은 1일부터 입니다.</small>
	              <div class="invalid-feedback">
	                	최소예약일을 선택하세요.
	              </div>
	            </div>
	            
				<hr class="my-4">
				
				<div class="col-12">
	              <label for="office_address" class="form-label">대여공간 주소</label>
	              <input type="text" class="form-control" name="office_address" placeholder="서울시 강남구 역삼동" required>
	              <div class="invalid-feedback">
	               		주소를 입력하세요.
	              </div>
	            </div>

				<div class="col-sm-6">
	              <label for="office_address_detail" class="form-label">대여공간 상세주소</label>
	              <input type="text" class="form-control" name="office_address_detail" placeholder="상세주소를 입력하세요." value="" required>
	              <div class="invalid-feedback">
	                	상세주소를 입력하세요. 
	             </div>
				</div>				
				
				<div class="col-sm-6">
	              <label for="office_managerPhone" class="form-label">담당자 전화번호</label>
	              <input type="text" class="form-control" name="office_managerPhone" placeholder="담당자 전화번호를 입력하세요." value="" required>
	              <div class="invalid-feedback">
	                	담당자 전화번호를 입력하세요.
	              </div>
	            </div>
				
				<div class="col-sm-6">
	              <label for="office_changedPhone" class="form-label">담당자 가상전화번호</label>
	              <input type="text" class="form-control" name="office_changedPhone" placeholder="" value="" required>
	              <div class="invalid-feedback">
	              
	              </div>
	            </div>
	            
	            <hr class="my-4">

				<div class="col-sm-6">
 				<input type="file" accept="image/*" class="form-control" name="mainFiles" id="inputGroupFile02">
				<label class="input-group-text" for="inputGroupFile02">공간대표이미지</label>
				</div>
				
				<div class="col-sm-6">
 				<input type="file" accept="image/*" class="form-control" name="subFiles"  id="inputFiles" multiple>
				<label class="input-group-text" for="inputFiles">공간상세이미지</label>
				</div>	            
	            
			<!-- 주소선택1 	
	            <div class="col-md-4">
	              <label for="office_address" class="form-label">지역선택</label>
	              <select class="form-select" id="office_address" required>
	                <option value="">서울</option>
	                <option>경기</option>
	              </select>
	              <div class="invalid-feedback">
	                	지역을 선택하세요
	              </div>
	            </div>						 -->
							
			   <div class="col-sm-6">
			   	<div class="row">
			   		<div class="col-2 px-0">
			          <div class="form-check">
			            <input type="checkbox" class="form-check-input" name="business_day" value="월" onchange="checkDay(this)">
			            <label class="form-check-label">월</label>
			          </div>
								   			
			   		</div>
			   		<div class="col px-0">
			   			<select class="form-control start-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">~</div>
			   		<div class="col px-0">
			   			<select class="form-control end-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">가격</div>
			   		<div class="col px-0">
						<input type="number" class="form-control price">
			   		</div>
			   	</div>
			   
			   	<div class="row">
			   		<div class="col-2 px-0">
			          <div class="form-check">
			            <input type="checkbox" class="form-check-input" name="business_day" value="화" onchange="checkDay(this)">
			            <label class="form-check-label">화</label>
			          </div>
								   			
			   		</div>
			   		<div class="col px-0">
			   			<select class="form-control start-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">~</div>
			   		<div class="col px-0">
			   			<select class="form-control end-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">가격</div>
			   		<div class="col px-0">
						<input type="number" class="form-control price">
			   		</div>
			   	</div>			   
			   	

			   	<div class="row">
			   		<div class="col-2 px-0">
			          <div class="form-check">
			            <input type="checkbox" class="form-check-input" name="business_day" value="수" onchange="checkDay(this)">
			            <label class="form-check-label">수</label>
			          </div>
								   			
			   		</div>
			   		<div class="col px-0">
			   			<select class="form-control start-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">~</div>
			   		<div class="col px-0">
			   			<select class="form-control end-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">가격</div>
			   		<div class="col px-0">
						<input type="number" class="form-control price">
			   		</div>
			   	</div>

			   	<div class="row">
			   		<div class="col-2 px-0">
			          <div class="form-check">
			            <input type="checkbox" class="form-check-input" name="business_day" value="목" onchange="checkDay(this)">
			            <label class="form-check-label">목</label>
			          </div>
								   			
			   		</div>
			   		<div class="col px-0">
			   			<select class="form-control start-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">~</div>
			   		<div class="col px-0">
			   			<select class="form-control end-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">가격</div>
			   		<div class="col px-0">
						<input type="number" class="form-control price">
			   		</div>
			   	</div>
			   	
			   	<div class="row">
			   		<div class="col-2 px-0">
			          <div class="form-check">
			            <input type="checkbox" class="form-check-input" name="business_day" value="금" onchange="checkDay(this)">
			            <label class="form-check-label">금</label>
			          </div>
								   			
			   		</div>
			   		<div class="col px-0">
			   			<select class="form-control start-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">~</div>
			   		<div class="col px-0">
			   			<select class="form-control end-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">가격</div>
			   		<div class="col px-0">
						<input type="number" class="form-control price">
			   		</div>
			   	</div>	
			   	
			   	<div class="row">
			   		<div class="col-2 px-0">
			          <div class="form-check">
			            <input type="checkbox" class="form-check-input" name="business_day" value="토" onchange="checkDay(this)">
			            <label class="form-check-label">토</label>
			          </div>
								   			
			   		</div>
			   		<div class="col px-0">
			   			<select class="form-control start-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">~</div>
			   		<div class="col px-0">
			   			<select class="form-control end-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">가격</div>
			   		<div class="col px-0">
						<input type="number" class="form-control price">
			   		</div>
			   	</div>	
			   	
			   	<div class="row">
			   		<div class="col-2 px-0">
			          <div class="form-check">
			            <input type="checkbox" class="form-check-input" name="business_day" value="일" onchange="checkDay(this)">
			            <label class="form-check-label">일</label>
			          </div>
								   			
			   		</div>
			   		<div class="col px-0">
			   			<select class="form-control start-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">~</div>
			   		<div class="col px-0">
			   			<select class="form-control end-time">
			   				<option value="0">00:00</option>
			   				<option value="1">01:00</option>
			   				<option value="2">02:00</option>
			   				<option value="3">03:00</option>
			   				<option value="4">04:00</option>
			   				<option value="5">05:00</option>
			   				<option value="6">06:00</option>
			   				<option value="7">07:00</option>
			   				<option value="8">08:00</option>
			   				<option value="9">09:00</option>
			   				<option value="10">10:00</option>
			   				<option value="11">11:00</option>
			   				<option value="12">12:00</option>
			   				<option value="13">13:00</option>
			   				<option value="14">14:00</option>
			   				<option value="15">15:00</option>
			   				<option value="16">16:00</option>
			   				<option value="17">17:00</option>
			   				<option value="18">18:00</option>
			   				<option value="19">19:00</option>
			   				<option value="20">20:00</option>
			   				<option value="21">21:00</option>
			   				<option value="22">22:00</option>
			   				<option value="23">23:00</option>
			   				<option value="24">24:00</option>
			   			</select>
			   		</div>
			   		<div class="col-1 px-0">가격</div>
			   		<div class="col px-0">
						<input type="number" class="form-control price">
			   		</div>
			   	</div>				   	
			   				   			   				   	
			   	
			 </div>
	
	
	          <hr class="my-4">
		
	          
	          <c:forEach items="${facilityCategoryList }" var="abc">
	          <div class="form-check">
	            <input type="checkbox" class="form-check-input" name="facility_no" value="${abc.facility_no }">${abc.facility_name }
	          </div>
			  </c:forEach>			 			 

	         <hr class="my-4">
	         
			</div>
		</div>
			 
	  </div>
	
	          <!-- <button class="w-100 btn btn-primary btn-lg" type="submit">등록하기</button> -->
	          <button class="w-100 btn btn-primary btn-lg" type="submit">등록하기</button>
	        </form>
	      </div>
	    </div>
			
		


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>