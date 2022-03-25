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
<div class="row" style="padding-top: 70px;">
	<div class="col">
		<h1>게스트 회원 관리</h1>
		<table border="1">
			<col width="50"><col width="200"><col width="100"><col width="50"><col width="150">
			<col width="200"><col width="200"><col width="200"><col width="150">
			<tr>
				<th>N O</th>
				<th>I D</th>
				<th>닉 네 임</th>
				<th>성 별</th>
				<th>생 년 월 일</th>
				<th>연 락 처</th>
				<th>이 메 일</th>
				<th>가 입 일 자</th>
				<th>기 능</th>
			</tr>
				<c:forEach items="${guestList }" var="list">
				<tr>
					<td>${list.memberVo.member_no }</td>
					<td>${list.memberVo.member_id }</td>
					<td>${list.memberVo.member_nick }</td>
					<td>${list.memberVo.member_gender }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.memberVo.member_birth }"/></td>
					<td>${list.memberVo.member_phone }</td>
					<td>${list.memberVo.member_email }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.memberVo.member_joindate }"/></td>
					<td><button type="button" class="btn btn-outline-light" onclick="if (confirm('회원탈퇴를 진행하시겠습니까?')) location.href='./deleteGuest?member_no=${list.memberVo.member_no }';">회원탈퇴</button></td>
				</tr>
				</c:forEach>
				<button type="button" class="btn btn-outline-light" onclick="location.href='adminPage'">메인 페이지</button></td>
		</table>
		
		<form action="./guestManagement" method="get">
		<div class="row mb-3">
			<div class="col">
				<select name="searchOption" class="form-select">
					<option value="number">번호</option>
					<option value="nickname">닉네임</option>
					<option value="id">아이디</option>
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
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link">이전</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=1">1</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=2">2</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=3">3</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=4">4</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=5">5</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=6">6</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=7">7</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=8">8</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=9">9</a></li>
		    <li class="page-item"><a class="page-link" href="./guestManagement?pageNum=10">10</a></li>
		    <li class="page-item"><a class="page-link">다음</a></li>
		  </ul>
</nav>
	</div>
</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>