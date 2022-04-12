<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid" style="padding-left: 550px;">
    <a class="navbar-brand" href="../admin/adminPage">������ ���</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="hostManagement">ȣ��Ʈ ����</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="guestManagement">�Խ�Ʈ ����</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="officeManagement">���ǽ� ����</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../admin/QnAPage">Q&A ����</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="createCouponPage">���� �߱�</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="createdCouponListPage">�߱� ���� ���</a>
        </li>
        <li class="nav-item">
          <c:choose>
        	<c:when test="${!empty adminUser }">
        		<a class="nav-link" href="logoutAdmin">�α׾ƿ�</a>
        	</c:when>
        	<c:otherwise>
        		<a class="nav-link" href="loginAdmin">�α���</a>
        	</c:otherwise>
        </c:choose>  
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>