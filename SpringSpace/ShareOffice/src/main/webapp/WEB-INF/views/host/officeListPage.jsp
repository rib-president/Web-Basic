<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>호스트/공유오피스목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">
<link href="https://webfontworld.github.io/naver/NanumSquareRound.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 5rem;">
	<div class="col">
		<%-- 내용작성 --%>
		<div class="jumbotron" style="font-family: 'NanumSquareRound';">
  			<h1>공유오피스 리스트</h1>
  			<p>등록하신 공유오피스 목록입니다.</p>
 		</div> 
		
	<c:forEach items="${officeList }" var="office">	
 		
			<div class="card" style="width: auto; margin:0.5rem; font-family: 'NanumSquareRound';">
			  <img src="/soUpload/officeImage/${office.office_thumbnail }" class="card-img-top" >
			  <div class="card-body">
			    <h5 class="card-title">${office.office_name}</h5>
			    <p class="card-text">${office.office_address}</p>
			    <a href="./officeDetailPage?office_no=${office.office_no }" class="btn btn-outline-info">상세보기</a>
			  </div>
			</div>
			

			
	</c:forEach>	
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>