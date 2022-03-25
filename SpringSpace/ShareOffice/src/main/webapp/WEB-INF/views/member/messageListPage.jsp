<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link href="../resources/css/commons.css" rel="stylesheet">
	
	<style>
	
		a{color: black;}
		
	</style>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 70px;">
	<div class="col">
		<div class="row">
			<div class="col" style="background-color: #3ad0ab; color: white; text-align: center; font-size: 1.5em; font-weight: bold;">쪽지보관함</div>
		</div>
		<table class="table" style="font-size: 1.3em">
			<thead>
			</thead>
			<c:forEach items="${datalist }" var="data">
			<c:choose>
			<c:when test="${data.messageVo.receive_no == 2 }">
			<tr>
				<td>
					<div class="row">
						<div class="col" style="font-weight: bold;">${data.memberVo.member_nick }</div>
						<div class="col"></div>
						<div class="col border" style="text-align:center; margin-right: 1em;"><a href="#">답장하기</a></div>
					</div>
					<div class="row">
						<div class="col">${data.messageVo.txt }</div>
					</div>
				</td>
			</tr>
			</c:when>
			</c:choose>
			</c:forEach>
		</table>
		<div class="row" style="text-align: center; font-size: 1.3em">
			<div class="col border" style="margin-left: 1em;"><a href="./writeMessagePage">쪽지쓰기</a></div>
			<div class="col"></div>
			<div class="col">
					<c:if test="${!empty sessionUser}">
						${sessionUser }아아아
					</c:if>
					
					<c:if test="${empty sessionUser}">
						<a href="./loginProcess?member_no=2">로그인</a>
					</c:if>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>