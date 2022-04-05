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
		
		
	</style>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row">
	<div class="col">
		<div class="row mt-4 border" style="margin: 0.5rem; background-color: #A68A64; border-radius: 0.3rem;">
			<div class="col" style=" color: white; text-align: center; font-size: 1.2rem; padding-top: 0.75rem; padding-bottom: 0.75rem;" onclick="location.href='../member/messageListPage'">
			쪽지보관함</div>
			<div class="col" style=" color: white; text-align: center; font-size: 1.2rem; padding-top: 0.75rem; padding-bottom: 0.75rem;" onclick="location.href='../member/sendMessageListPage'">
			보낸쪽지함</div>
		</div>
			<c:forEach items="${datalist }" var="data">
			<c:choose>
				<c:when test="${data.messageVo.read_date eq null && data.messageVo.sender_no eq 0}">
					<div class="card" style="width: auto; margin: 0.5rem; background: #afffee">
					  <div class="card-body">
					    <h5 class="card-title">${data.memberVo.member_nick }
						    <a href="./deleteReceiveMessage?message_no=${data.messageVo.message_no }" style="color: black;">
								<i class="bi bi-trash3 float-right" style="font-size: 1.3rem;"></i>
							</a>
					    </h5>
					    <p class="card-text">${data.messageVo.txt }</p>
					  </div>
					</div>
				</c:when>
				<c:when test="${data.messageVo.read_date eq null && data.messageVo.sender_no ne 0}">
					<div class="card" style="width: auto; margin: 0.5rem; background: #ebfbff">
					  <div class="card-body">
					    <h5 class="card-title">${data.memberVo.member_nick }
					    <c:if test="${data.messageVo.sender_no ne 0 }">
					    <a href="./messageReplyPage?sender_no=${data.messageVo.sender_no }" style="font-size: 1.3rem; color: black;"><i class="bi bi-reply"></i></a>
					    </c:if>
					    <a href="./deleteReceiveMessage?message_no=${data.messageVo.message_no }" style="color: black;">
							<i class="bi bi-trash3 float-right" style="font-size: 1.3rem;"></i>
						</a>
					    </h5>
					    <p class="card-text">
						    ${data.messageVo.txt }
					    </p>
					  </div>
					</div>
				</c:when>
				<c:when test="${data.messageVo.read_date ne null}">
					<div class="card" style="width: auto; margin: 0.5rem;">
					  <div class="card-body">
					    <h5 class="card-title">${data.memberVo.member_nick }
					    	<c:if test="${data.messageVo.sender_no ne 0 }">
					   			<a href="./messageReplyPage?sender_no=${data.messageVo.sender_no }" style="font-size: 1.3rem; color: black;"><i class="bi bi-reply"></i></a>
					  		</c:if>
					    	<a href="./deleteReceiveMessage?message_no=${data.messageVo.message_no }" style="color: black; text-align: ">
								<i class="bi bi-trash3 float-right" style="font-size: 1.3rem;"></i>
							</a>
					    </h5>
					    <p class="card-text">${data.messageVo.txt }</p>
					  </div>
					</div>
				</c:when>
			</c:choose>
			</c:forEach>
			<c:if test="${empty datalist}">
				<div class="row">
					<div class="col"style="text-align: center; padding-top: 20rem; padding-bottom: 20rem;">받은 쪽지가 없습니다.</div>
				</div>
			</c:if>
			<div class="fixed " style="bottom: 3rem; right: 3rem; z-index: 99">
				<a href="./writeMessagePage"><i class="bi bi-plus-circle-fill" style="font-size: 3rem; color: #A68A64;"></i></a>
			</div>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>