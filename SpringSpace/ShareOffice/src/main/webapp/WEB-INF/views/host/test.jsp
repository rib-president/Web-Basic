<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 70px;">
	<div class="col">
		<%-- 내용작성 --%>
		<form action="./registerOfficeProcess" method="post" enctype="multipart/form-data">
			<h3> 공유오피스 등록 테스트중</h3>
		 		<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">공간명</span>
  				<input type="text" class="form-control" name="office_name" placeholder="공간명을 입력하세요" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">공간 간단소개</span>
  				<input type="text" class="form-control" name="office_simpleContent" placeholder="공간의 특징을 간단하게 작성하세요." aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group">
  				<span class="input-group-text">공간소개</span>
  				<textarea class="form-control" name="office_detailContent" placeholder="게스트들에게 필요한 공간 정보를 상세하게 소개해주세요." aria-label="With textarea"></textarea>
				</div><br>
				
		 		<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">사용가능인원</span>
  				<input type="text" class="form-control" name="office_personnel" placeholder="숫자만 입력하세요." aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">공간태그</span>
  				<input type="text" class="form-control" name="office_tags" placeholder="주요특징들을 키워드로 입력해주세요." aria-label="Username" aria-describedby="basic-addon1">
				</div> 
				
				<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">대여공간주소</span>
  				<input type="text" class="form-control" name="office_address" placeholder="주소를 입력하세요." aria-label="Username" aria-describedby="basic-addon1">
				</div> 
				
				<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">대여공간상세주소</span>
  				<input type="text" class="form-control" name="office_address_detail" placeholder="상세주소를 입력하세요." aria-label="Username" aria-describedby="basic-addon1">
				</div>

				<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">담당자 전화번호</span>
  				<input type="text" class="form-control" name="office_managerPhone" placeholder="공간 담당자 전화번호를 입력하세요." aria-label="Username" aria-describedby="basic-addon1">
				</div>

				<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">담당자 가상전화번호</span>
  				<input type="text" class="form-control" name="office_changedPhone" placeholder="공간 담당자 가상번호를 입력하세요." aria-label="Username" aria-describedby="basic-addon1">
				</div>

				<div class="input-group mb-3">
 				<input type="file" accept="image/*" class="form-control" name="mainFiles" id="inputGroupFile02">
				<label class="input-group-text" for="inputGroupFile02">공간대표이미지</label>
				</div>
				
				<div class="input-group mb-3">
 				<input type="file" accept="image/*" class="form-control" name="subFiles" id="inputGroupFile02">
				<label class="input-group-text" for="inputGroupFile02">공간상세이미지</label>
				</div>
				
				
				<div class="input-group mb-3">
 			 	<span class="input-group-text" id="basic-addon1">최소예약일</span>
  				<input type="text" class="form-control" name="office_min_booking_day" placeholder="숫자만 입력하세요." aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div>
				<input type=hidden name="office_approve" value="P" class="form-control">
				<!-- <input type=hidden name="office_approve_comment" value="" class="form-control">
				<input type=hidden name="office_approve_date" value="" class="form-control">  -->
				 
				</div>
				
				
				
		
		
		
		
		
		
		</form>
		
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>