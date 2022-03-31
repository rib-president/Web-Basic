<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>호스트 메인페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../resources/css/commons.css">
<link rel="stylesheet" href="../resources/css/style.css">

</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 4rem;">
	<div class="col">
		<div class="row" style="padding-top:1.5rem">
			<c:choose>
				<c:when test="${empty sessionUser }">
					<div class="col d-grid"><button class="btn btn-dark" onclick="location.href='../member/loginPage'">로그인</button></div>	
				</c:when>
				<c:otherwise>
					<div class="col d-grid"><button class="btn btn-dark" onclick="location.href='../member/logoutProcess'">로그아웃</button></div>
				</c:otherwise>
			</c:choose>
			
		</div>
		<div class="row mt-3 mb-3">
			<div class="col d-grid"><button class="btn btn-outline-dark" onclick="location.href='../guest/officeListPage'">오피스 목록</button></div>
		</div>	
		<c:choose>
			<c:when test="${!empty sessionUser && sessionUser.member_type == 'G' }">
				<div class="row mt-3 mb-3">
					<div class="col d-grid"><button class="btn btn-warning" onclick="location.href='../guest/applyHostPage'">호스트 신청</button></div>
				</div>		
			</c:when>
			<c:when test="${!empty sessionUser && sessionUser.member_type == 'H' }">
				<div class="row mt-3 mb-3">
					<div class="col d-grid"><button class="btn btn-warning" onclick="location.href='../host/mainPage'">호스트 센터</button></div>
				</div>
			</c:when>	
		</c:choose>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>