<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%
	String strReferer = request.getHeader("referer");

if (strReferer == null) {
%>
<script language="javascript">
	alert("정상적인 경로를 통해 다시 접근해 주세요.");
	document.location.href = "loginAdmin";
</script>
<%
	return;
}
%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>오피스 관리</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../commons/navbar.jsp"></jsp:include>
	<div class="row" style="padding-top: 5em;">
		<div class="col">
			<div class="card" style="margin: 1em">
				<button type="button" class="btn btn-secondary"
					onclick="location.href='adminPage'">메인 페이지</button>
				<button type="button" class="btn btn-secondary"
					onclick="location.href='adminOfficeDetail'">오피스 신청 현황 보기</button>
				</td>
				<h5 class="card-title text-center mt-4">오피스 현황</h5>
				<c:forEach items="${officeList }" var="list">
					<c:if test = "${list.getOffice.office_approve != 'P'}">
						<div class="card-body text-left">
							<p class="card-text">오피스 번호 :${list.getOffice.office_no}</p>
							<p class="card-text">오피스 이름 :${list.getOffice.office_name}</p>
							<p class="card-text">간략 설명 :${list.getOffice.office_simpleContent}</p>
							<p class="card-text">상세 설명 :${list.getOffice.office_detailContent}</p>
							<p class="card-text">사용 인원 :${list.getOffice.office_personnel}</p>
							<p class="card-text">태그 :${list.getOffice.office_tags}</p>
							<p class="card-text">주소 :${list.getOffice.office_address} ${list.getOffice.office_address_detail}</p>
							<p class="card-text">담당자 전화번호 (가상번호) :${list.getOffice.office_managerPhone} ( ${list.getOffice.office_changedPhone} )</p>
							<p class="card-text">최소 예약일 :${list.getOfficeVo.office_min_booking_day}</p>
							<p class="card-text">승인 여부 :${list.getOffice.office_approve}</p>
							<p class="card-text">거절 사유 :${list.getOffice.office_approve_comment}</p>
							<p class="card=text">승인 / 거절 날짜 :<fmt:formatDate value="${list.getOffice.office_approve_date}" pattern="yy-MM-dd"/></p>
						</div>
					</c:if>
				</c:forEach>
				<form action="./officeManagement" method="get">
				<div class="row mb-3">
					<div class="col">
						<select name="searchOption" class="form-select">
							<option value="number">번호</option>
							<option value="officename">오피스 이름</option>
							<option value="approve">승인 여부</option>
						</select>
					</div>
					<div class="col-8">
						<input name="searchStr" type="text" class="form-control">
					</div>
					<div class="col d-grid">
						<input type="submit" value="검색" class="btn btn-primary">
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>	

	<jsp:include page="../commons/footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>