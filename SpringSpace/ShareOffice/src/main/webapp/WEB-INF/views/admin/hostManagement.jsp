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
<script>
	function refuseEvent(host_no)
	{		
		var refuseReason = prompt("거절 사유를 입력해주세요.");
		
		if(refuseReason != null)
		{
			location.href="./hostRefuseGuest?refuseReason=" + refuseReason + "&host_no=" + host_no;
		}
	}
</script>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>호스트 관리 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>
<div class="row" style="padding-top: 5em; padding-bottom: 5em; padding-left: 5em; padding-right: 5em;">
	<div class="col">
		<h1>호스트 관리</h1>
		<table class="table">
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
			<button type="button" style="margin-bottom: 2em;" class="btn btn-warning" onclick="location.href='adminPage'">메인 페이지</button>
			<button type="button" style="margin-left: 2.5em; margin-bottom: 2em;" class="btn btn-secondary" onclick="location.href='guestManagement'">게스트 관리</button>
			<button type="button" style="margin-left: 2.5em; margin-bottom: 2em;" class="btn btn-success" onclick="location.href='officeManagement'">오피스 관리</button>
			<button type="button" style="margin-left: 2.5em; margin-bottom: 2em;" class="btn btn-danger" onclick="location.href='../board/QnAPage'">Q&A 관리</button>
			<button type="button" style="margin-left: 2.5em; margin-bottom: 2em;" class="btn btn-dark" onclick="location.href='../admin/logoutAdmin'">로그아웃</button>
			<col width="50"><col width="200"><col width="200"><col width="150">
			<col width="150"><col width="100"><col width="200"><col width="250">
			<col width="250">
			<thead>
			    <tr>
			      <th scope="col">NO</th>
			      <th scope="col">상호명</th>
			      <th scope="col">대표자명</th>
			      <th scope="col">사업자번호</th>
			      <th scope="col">신청일</th>
			      <th scope="col">승인여부</th>
			      <th scope="col">거절사유</th>
			      <th scope="col">승인/거절 날짜</th>
			      <th scope="col">예 약 거 절 횟 수</th>
			      <th scope="col">기능</th>
			    </tr>
			 </thead>
			 <tbody>
				<c:forEach items="${hostList }" var="list">
				<tr>
					<th scope="row">${list.hostVo.host_no }</th>
					<td>${list.hostVo.host_owner }</td>
					<td>${list.hostVo.host_name }</td>
					<td>${list.hostVo.host_license_number }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.hostVo.host_apply_date }"/></td>
					<td>${list.hostVo.host_approve }</td>
					<td>${list.hostVo.host_approve_comment }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.hostVo.host_approve_date }"/></td>
					<td>${list.hostVo.host_refuse_count }</td>
					<c:choose>
						<c:when test = "${list.hostVo.host_approve == 'Y'}">
							<td><button type="button" class="btn btn-secondary" onclick="clearAuthorityHost(${list.hostVo.host_no }, ${list.hostVo.member_no })">호스트 권한 해제</button></td>
						</c:when>
						<c:when test = "${list.hostVo.host_approve == 'P'}">
							<td><button type="button" class="btn btn-secondary" onclick="if (confirm('승인하시겠습니까?')) location.href='./hostApplyGuest?member_no=${list.hostVo.member_no }&host_no=${list.hostVo.host_no }';">승인</button></td>
							<td><button type="button" class="btn btn-secondary" onclick="refuseEvent(${list.hostVo.host_no })">거절</button></td>
						</c:when>
					</c:choose>
					<c:if test = "${list.hostVo.host_refuse_count > 0}">
						<td><button type="button" class="btn btn-secondary" onclick="location.href='hostRefuseDetail?host_no=${list.hostVo.host_no }';">예약 거부 현황</button></td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
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