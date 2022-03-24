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


</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 70px;">
	<div class="col">
	    <div class="row mt-3">
	       <div class="col">
				<div class="card" style="margin: 20px">
				   <h5 class="card-title text-center mt-4">호스트 등록 현황</h5>
					<div class="card-body text-left">						
						<p class="card-text">대표자명:${host.hostVo.host_owner}</p>
						<p class="card-text">상호명:${host.hostVo.host_name}</p>
						<p class="card-text">사업자 번호:${host.hostVo.host_license_number }
						<i class="bi bi-file-earmark" onclick="licenseImg()"></i><!-- 사업자등록증 팝업띄우기 --></p>
					 </div>
					 <div class="card-body text-center">	 
					    <!-- approve =="P"이면 진행중 어쩌구 -->										
						<c:if test="${host.hostVo.host_approve eq 'P' }">
						   <p class="card-text ">호스트 신청이 완료되었습니다.<br>관리자의 승인 대기 중입니다.</p> 
						</c:if>
						<c:if test="${host.hostVo.host_approve eq 'Y' }">  
						   <p class="card-text ">호스트 승인이 완료되었습니다.</p>
						   <a href="" class="btn btn-outline-secondary">호스트 페이지로 가기</a>
					    </c:if>
					    <c:if test="${host.hostVo.host_approve eq 'N' }">  
						   <p class="card-text ">호스트 승인이 거절되었습니다.<br>거절 사유:${host.hostVo.host_approve_comment }</p>
						   <div class="col d-grid"><a href="./applyHostPage" class="btn btn-outline-secondary">호스트 신청하러 가기</a></div>
					    </c:if>
					   <div class="col d-grid"><a href="./officeListPage" class="btn btn-outline-secondary">목록으로 가기</a></div>	
					</div>
								
				</div>
			  </div>	
			</div>

	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>