<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		a{color: black;}
		
	</style>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 1rem;">
	<div class="col">
		<div class="row mb-2">
			<div class="col-9"></div>
			<div class="col me-3 rounded-full" style="background-color: #3ad0ab; color: white; text-align: center; font-size: 1.5rem;">
			<a href="./writeMessagePage" style="color: white;">쪽지쓰기</a></div>
		</div>
		<div class="row" >
			<div class="col" style="background-color: #3ad0ab; color: white; text-align: center; font-size: 1.5rem;">
			<a href="./messageListPage" style="color: white;">쪽지보관함</a></div>
			<div class="col" style="background-color: #3ad0ab; color: white; text-align: center; font-size: 1.5rem;">
			<a href="./sendMessageListPage" style="color: white;">보낸쪽지함</a></div>
		</div>
			<c:forEach items="${datalist }" var="data">
			<c:if test="${data.messageVo.read_date eq null }">
					<div class="card" style="width: auto; margin: 0.5rem; background: #d7f1fa">
					  <div class="card-body">
					    <h5 class="card-title">${data.memberVo.member_nick }
					    <a href="./messageReplyPage?sender_no=${data.messageVo.sender_no }" style="font-size: 1.5rem;"><i class="bi bi-reply"></i></a></h5>
					    <p class="card-text">${data.messageVo.txt }</p>
					  </div>
					</div>
			</c:if>
			<c:if test="${data.messageVo.read_date ne null }">
					<div class="card" style="width: auto; margin: 0.5rem;">
					  <div class="card-body">
					    <h5 class="card-title">${data.memberVo.member_nick }
					    <a href="./messageReplyPage?sender_no=${data.messageVo.sender_no }" style="font-size: 1.5rem;"><i class="bi bi-reply"></i></a></h5>
					    <p class="card-text">${data.messageVo.txt }</p>
					  </div>
					</div>
			</c:if>
			</c:forEach>
			<div class="fixed " style="bottom: 3rem; right: 3rem; z-index: 99">
				<a href="./writeMessagePage"><i class="bi bi-plus-circle-fill" style="font-size: 3rem; color: #3ad0ab"></i></a>
			</div>
		<div class="row" style="text-align: center; font-size: 1.3em">
			<div class="col" style="margin-right: 1em; text-align: center; font-size: 1em;"><a href="./testMyPage">마이 페이지</a></div>
		</div>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>