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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">
<link href="../resources/css/shopMain.css" rel="stylesheet">

</head>
<body style="overflow-y: hidden">
<div style="margin: 0 auto;">
 <div class="container-fluid">
	<div class="row">
		<div id="nav-bar" class="col"><!-- 글로벌 nav -->
			<jsp:include page="../commons/global_nav.jsp"></jsp:include>
		</div>
	</div>

 	<div class="row">
		<jsp:include page="../commons/menu_bar.jsp"></jsp:include>
		<div class="col shop-start-col">
			<div class="row">
				<div class="col-2"></div>
				<div class="col"><h2>이용안내</h2></div>
			</div>	
			<div class="row mt-3">
				<div class="col">
					<div class="row mt-5"><div class="col"><h4><a href="../member/joinMemberPage">1. 회원가입</a></h4></div></div>
					<div class="row"><div class="col">처음 오신 분은 원활한 사이트 이용을 위해 회원가입을 진행해주세요</div></div>
					<div class="row mt-5"><div class="col"><h4><a href="../member/loginPage">2. 로그인</a></h4></div></div>
					<div class="row"><div class="col">회원가입 완료 또는 이미 계정이 있다면 로그인 해주세요</div></div>
					<div class="row"><div class="col">(카카오 로그인 연동 지원)</div></div>
					<div class="row mt-5"><div class="col"><h4>3. 상품선택</h4></div></div>
					<div class="row"><div class="col">구매할 상품과 옵션 및 수량을 선택하여 add cart 또는 buy now 버튼을 눌러주세요</div></div>
					<div class="row mt-5"><div class="col"><h4>4. 결제</h4></div></div>
					<div class="row"><div class="col">배송 정보를 입력한 뒤 결제 방법을 선택하여 결제를 진행해 주세요</div></div>
					<div class="row"><div class="col">(카카오 페이 결제 가능)</div></div>								
				</div>
				<div class="col-3"></div>
				<div class="col"><img class="img-fluid" src="../resources/img/guide.jpg" style="height: 80%;"></div>
			</div>  	  												  								
		</div>
 	</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>