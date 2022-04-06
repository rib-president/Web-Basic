<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="now" value="<%=new java.util.Date()%>" />
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

<style>
	.couponBackground {
	 background-image:url('../resources/img/tempCoupon.png');
		background-size: 20.94em;
	  	height: 11.88em;
	 	background-repeat: no-repeat;
		}
	row{
	float: auto; 
	margin 100%;
	}
	col{
	float: auto; 
	margin 0 auto;
	}
		
		
		
</style>
<%--
<script>
	function check(this){
		
		var count = document.getElementByID("count");
		var today = new Date();
		
		if(count.value == 0){
			alert("남은 수량을 확인해주세요");
			return false;
		}else if(${coupon.CouponVoList.coupon_useDate } < today) {
			alert("기간이 만료된 쿠폰입니다.");
			return false;
		}else{
			document.check.submit();
			return true;
		}
	}			
</script>
 --%> 
<%-- 
<script>
	function check(this) {
	
		
		if(true){
			alert("hi")
			retrun false;
		}
		
	}
</script>
--%>

<script>

</script>

</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 2em;">
	<div class="col" style="margin:2rem">
		
		<div class="row couponBackground">
	 		<div class="col-3"></div>
	 		<div class="col-6 text-fs-30 text-center">
	 			<div class="row">벚꽃 쿠폰</div>
	 			<div class="row text-fs-40">10000원</div>
	 			<div class="row text-fs-13"></div>
	 		</div>
	 		<div class="col-3"></div>
		</div>
			
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>