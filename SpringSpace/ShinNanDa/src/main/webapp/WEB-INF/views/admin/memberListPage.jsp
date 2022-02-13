<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="../resources/css/commons.css" rel="stylesheet">
</head>
<body>
<div style="width:1200px;margin : 0 auto">
	<div class="container-fluid">
		<div class="row">
			<div class="col"><!-- 글로벌 nav -->
				<jsp:include page="../commons/global_nav.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="../commons/admin_menu_bar.jsp"></jsp:include>

		<div class="row">
			<div class="col">
				<table class="table table-hover">
				  <thead>
				    <tr>
				      <th scope="col">회원번호</th>
				      <th scope="col">아이디</th>
				      <th scope="col">이름</th>
				      <th scope="col">닉네임</th>
				      <th scope="col">가입일</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${memberVoList }" var="memberVo">
				  	  <c:if test="${memberVo.member_admin == 'N' }">
					    <tr>
					      <th scope="row">${memberVo.member_no }</th>
					      <td><a href="../admin/detailMemberPage?member_no=${memberVo.member_no }">${memberVo.member_id }</a></td>
				          <td>${memberVo.member_name }</td>					      
					      <td>${memberVo.member_nick }</td>
					      <td><fmt:formatDate value="${memberVo.member_joindate }" pattern="yyyy년 MM월 dd일" /></td>
					    </tr>
					  </c:if>				  
				  	</c:forEach>
				  </tbody>
				</table>			
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>