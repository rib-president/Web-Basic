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
<body>
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
			<div class="row mt-3">
				<div class="col"><h1>마이 페이지</h1><hr></div>
			</div>

			<div class="row mt-3">
				<div class="col-1">총 주문</div>	
				<div class="col">${totalCount } 회</div>		
			</div>
			
			<div class="row mt-5">
				<div class="col">
					<div class="row"><div class="col"><h4>나의 주문처리 현황</h4></div></div><hr>
					<div class="row mt-2">
					  <div class="col text-center">
					  	<div class="row"><div class="col"><h3>입금대기</h3></div></div>
						<div class="row"><div class="col"><h2><a href="../shop/ordersInfoPage?searchState=입금대기">${ordersStateCountMap.get('입금대기') }</a></h2></div></div>
					  </div>
					  <div class="col text-center">
					  	<div class="row"><div class="col"><h3>입금완료</h3></div></div>
						<div class="row"><div class="col"><h2><a href="../shop/ordersInfoPage?searchState=입금완료">${ordersStateCountMap.get('입금완료') }</a></h2></div></div>
					  </div>					  
					  <div class="col text-center">
					  	<div class="row"><div class="col"><h3>배송중</h3></div></div>
						<div class="row"><div class="col"><h2><a href="../shop/ordersInfoPage?searchState=배송중">${ordersStateCountMap.get('배송중') }</a></h2></div></div>
					  </div>					  
					  <div class="col text-center">
					  	<div class="row"><div class="col"><h3>배송완료</h3></div></div>
						<div class="row"><div class="col"><h2><a href="../shop/ordersInfoPage?searchState=배송완료">${ordersStateCountMap.get('배송완료') }</a></h2></div></div>
					  </div>					  
					  					  
					</div>
				</div>
			</div>
			<hr>
			<div class="row mt-5">
				<div class="col ms-5" onclick="location.href='../shop/ordersInfoPage'" style="cursor:pointer;">
					<div class="row"><div class="col"><h4>order</h4> 주문 내역 조회</div></div>
					<div class="row"><div class="col">주문하신 상품의 주문 내역을 확인할 수 있습니다</div></div>
				</div>
				<div class="col"></div>
				<div class="col-2"><a href="../shop/ordersInfoPage"><i class="bi bi-file-earmark-text" style="font-size: 5em;"></i></a></div>
			</div>	
			<hr>  

			<div class="row mt-5">
				<div class="col ms-5" onclick="location.href='../member/memberInfo'" style="cursor:pointer;">
					<div class="row"><div class="col"><h4>profile</h4> 회원 정보</div></div>
					<div class="row"><div class="col">회원 개인 정보를 관리하는 공간입니다</div></div>
				</div>
				<div class="col"></div>
				<div class="col-2"><a href="../member/memberInfo"><i class="bi bi-person-fill" style="font-size: 5em;"></i></a></div>
			</div>	
			<hr>  

		  								
		</div>
 	</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>