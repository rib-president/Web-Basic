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
	
		#message{
			border-radius: 0.3rem 0rem 0rem 0.3rem; 
			background-color:#BBA586; 
			color: white; 
			text-align: center; 
			font-size: 1.1rem; 
			padding-top: 0.75rem; 
			padding-bottom: 0.75rem;
			font-weight: bold;
		}
		
		#sendMessage{
			border-radius: 0rem 0.3rem 0.3rem 0rem; 
			background-color:#A68A64; 
			color: white; text-align: center; 
			font-size: 1.1rem; 
			padding-top: 0.75rem; 
			padding-bottom: 0.75rem;
			font-weight: bold;
		}
		
	</style>
	
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row"">
	<div class="col">
		<div class="row mt-4" style="margin: 1rem;">
			<div class="col" id="message" onclick="location.href='../member/messageListPage'">
			쪽지보관함</div>
			<div class="col" id="sendMessage" onclick="location.href='../member/sendMessageListPage'">
			보낸쪽지함</div>
		</div>
			<c:forEach items="${datalist }" var="data">
					<div class="card" style="width: auto; margin: 1rem;">
					  <div class="card-body">
					    <p class="card-title" style="font-size: 1.1rem; font-weight: bold;">
					    	${sessionUser.member_nick} <i class="bi bi-caret-right"></i> ${data.memberVo.member_nick }
					    	<a href="./deleteSendMessage?message_no=${data.messageVo.message_no }" style="color: black;">
								<i class="bi bi-trash3 float-right" style="font-size: 1.3rem;"></i>
							</a>
					    </p>
					    <p class="card-text">${data.messageVo.txt }</p>
					  </div>
					</div>
			</c:forEach>
			<c:if test="${empty datalist}">
				<div class="row">
					<div class="col"style="text-align: center; padding-top: 20rem; padding-bottom: 20rem;">보낸 쪽지가 없습니다.</div>
				</div>
			</c:if>
			<div class="fixed " style="bottom: 3rem; right: 3rem; z-index: 99">
				<a href="./writeMessagePage"><i class="bi bi-plus-circle-fill" style="font-size: 3rem; color: #A68A64"></i></a>
			</div>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>