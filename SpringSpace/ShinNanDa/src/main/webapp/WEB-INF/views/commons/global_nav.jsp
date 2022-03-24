<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../board/mainPage">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../board/mainPageJS">김중수님 자유게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../board/mainPageSC">신수철님 자유게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../board/mainPageJH">장지훈님 자유게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../board/mainPageHJ">조혜정님 자유게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../board/mainPageJH2">홍종화님 자유게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="../board/mainPageRN">황루니님 자유게시판</a>
        </li>
        <li class="nav-item">
       	   <a class="nav-link" href="../shop/main">쇼핑몰</a>
        </li>
        <li class="nav-item">
	       	<c:if test="${!empty sessionAdmin }">
    	   	  <a class="nav-link" href="../admin/main">쇼핑몰 관리자 페이지</a>
       		</c:if>        
        </li>
      </ul>
	<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
		<c:choose>
			<c:when test="${!empty sessionUser }">
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		          ${sessionUser.member_nick }
		        </a>
		        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <li><a class="dropdown-item" href="../shop/myPage">마이페이지</a></li>
		          <li><a class="dropdown-item" href="#">내가 쓴 글 목록</a></li>
		          <li><hr class="dropdown-divider"></li>
		          <li><a class="dropdown-item" onclick="logout()">로그아웃 ${sessionUser.member_kakao}</a></li>
		        </ul>
		      </li>
			</c:when>
			<c:when  test="${!empty sessionAdmin }">
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		          ${sessionAdmin.member_name }
		        </a>
		        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <li><a class="dropdown-item" href="../member/logoutProcess">로그아웃</a></li>
		        </ul>
		      </li>			
			</c:when>
			<c:otherwise>
		      <li class="nav-item">
		        <a class="nav-link" href="../member/loginPage">로그인</a>
		      </li>
			</c:otherwise>
		</c:choose>
      
	</ul>      
      
    </div>
  </div>
</nav>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>

	function logout() {		
		
		if('${sessionUser.member_kakao}' == 'Y') {
			Kakao.init('dcba11bad3364b22a9a962b80ee0acfb');
			
			if (!Kakao.Auth.getAccessToken()) {
			  console.log('Not logged in.');
			  return;
			}
			Kakao.Auth.logout(function() {
			  //console.log(Kakao.Auth.getAccessToken());
			});
		}
		
		location.href="../member/logoutProcess"
	}
</script>    