<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<%
 String strReferer = request.getHeader("referer");
 
 if(strReferer == null){
%>
 <script language="javascript">
  alert("정상적인 경로를 통해 다시 접근해 주세요.");
  document.location.href="loginAdmin";
 </script>
<%
  return;
 }
%>

<script>
	function clearAuthorityHost(host_no, member_no)
	{
			if(confirm('권한을 해제하시겠습니까?'))
			{
				var approveComment = prompt('권한 해제 사유를 입력하세요.');
				
				if(approveComment != null)
					location.href="./hostRefuseGuest?refuseReason=" + approveComment + "&host_no=" + host_no  + "&member_no=" + member_no;
			}
	}

</script>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>게스트 관리 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>
<div class="row" style="padding-top: 5em;">
	<div class="col">
		<h1>호스트 관리</h1>
		<table border="1">
			<col width="50"><col width="200"><col width="200"><col width="150">
			<col width="200"><col width="100"><col width="100"><col width="200">
			<tr>
				<th>N O</th>
				<th>상 호 명</th>
				<th>대 표 자 명</th>
				<th>사 업 자 번 호</th>
				<th>신 청 일</th>
				<th>승 인 여 부</th>
				<th>거 절 사 유</th>
				<th>승 인 / 거 절 날 짜</th>
				<!-- <th>예 약 거 절 횟 수</th>-->
			</tr>
				<c:forEach items="${hostList }" var="list">
				<tr>
					<c:if test = "${list.hostVo.host_approve != 'P'}">
						<td>${list.hostVo.host_no }</td>
						<td>${list.hostVo.host_owner }</td>
						<td>${list.hostVo.host_name }</td>
						<td>${list.hostVo.host_license_number }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.hostVo.host_apply_date }"/></td>
						<td>${list.hostVo.host_approve }</td>
						<td>${list.hostVo.host_approve_comment }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.hostVo.host_approve_date }"/></td>
						<%-- <td>${list.hostVo.host_refuse_count }</td> --%>
						<c:if test = "${list.hostVo.host_approve == 'Y'}">
							<td><button type="button" class="btn btn-secondary" onclick="clearAuthorityHost(${list.hostVo.host_no }, ${list.hostVo.member_no })">호스트 권한 해제</button></td>
						</c:if>
						<c:if test = "${list.hostVo.host_refuse_count > 0}">
							<td><button type="button" class="btn btn-secondary" onclick="location.href='hostRefuseDetail?host_no=${list.hostVo.host_no }';">예약 거부 현황</button></td>
						</c:if>
					</c:if>
				</tr>
				</c:forEach>
				<button type="button" class="btn btn-secondary" onclick="location.href='adminPage'">메인 페이지</button></td>
				<button type="button" class="btn btn-secondary" onclick="location.href='applyHostCheckList'">호스트 신청자 목록</button></td>
		</table>
		<form action="./hostManagement" method="get">
		<div class="row mb-3">
			<div class="col">
				<select name="searchOption" class="form-select">
					<option value="number">번호</option>
					<option value="name">대표자명</option>
					<option value="id">상호명</option>
					<option value="approve">승인여부</option>
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
		<!--  
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link">이전</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=1">1</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=2">2</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=3">3</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=4">4</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=5">5</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=6">6</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=7">7</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=8">8</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=9">9</a></li>
		    <li class="page-item"><a class="page-link" href="./hostManagement?pageNum=10">10</a></li>
		    <li class="page-item"><a class="page-link">다음</a></li>
		  </ul>
</nav>
-->
	</div>
</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>