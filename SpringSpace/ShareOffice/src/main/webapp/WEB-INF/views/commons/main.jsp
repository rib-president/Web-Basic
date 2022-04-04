<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row" style="margin: auto;">
   <div class="col pt-2" style="background-image: url('../resources/img/mainLogo.jpg'); background-position: center; height: 31.25rem; background-size: cover;">
   		<i id="menu" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample" class="bi bi-list cursor-pointer text-fs-40" style="color:white;"></i>
   </div>
</div>

<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel" style="background-color: #e0e0e0">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title bold ms-1 text-gray-c_25" id="offcanvasExampleLabel">Menu
    	<a href="../member/messageListPage">
    		<i id="menu1" class="bi bi-bell-fill" style="font-size: 1.7rem; color: white;"></i>
    	</a>
    </h5>
    
    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
	<div class="row">
		<c:choose>
			<c:when test="${empty sessionUser }">
				<div class="col cursor-pointer" onclick="location.href='../member/loginPage'"><img class="img-fluid" src="../resources/img/4.png" style="width:100%"></div>
			</c:when>
			<c:otherwise>
				<div class="col text-gray-c_25" style="font-weight: bold; margin-left: .5rem; font-size: 1.5rem;">❤ ${sessionUser.member_nick } 님</div>
				<div class="col cursor-pointer" style="text-align: right; padding-top:.4rem" onclick="location.href='../member/logoutProcess'"><i class="bi bi-unlock text-gold"></i> logout</div>
			</c:otherwise>
		</c:choose>
	</div>

	<c:if test="${!empty sessionUser }">
	    <div class="row mt-3 mb-2">
	    	<div class="col" style="text-align: center;">
	    		<button type="button" class="btn text-white btn-block pl-7" style="background-color: #A68A64; width: 100%; text-align: left;"
				onclick="location.href='../member/testMyPage'">마이페이지</button>
	    	</div>
	    </div>
	    <div class="row">
	    	<div class="col pr-1">
	    		<button type="button" class="btn text-white btn-block" style="background-color: #A68A64; width: 100%;"
				onclick="location.href='#'">예약목록</button>
	    	</div>
	    	<div class="col pl-1 pr-1">
	    		<button type="button" class="btn text-white btn-block" style="background-color: #A68A64; width: 100%;"
				onclick="location.href='#'"><i class="bi bi-ticket-perforated text-white"></i> 쿠폰함</button>
	    	</div>
	    	<div class="col pl-1">
	    		<button type="button" class="btn text-white btn-block" style="background-color: #A68A64; width: 100%;"
				onclick="location.href='../member/messageListPage'">쪽지함</button>
	    	</div>
	    </div>
    </c:if>
    
    <div class="row mt-5 mb-3">
    	<div class="col cursor-pointer" style="font-weight: bold;">오피스</div>
    </div>
    <div class="row mt-1 ms-1">
    	<div class="col cursor-pointer" onclick="location.href='../guest/officeListPage'">오피스 목록</div>
    </div>
	<div class="row mt-1 ms-1">
		<div class="col cursor-pointer" onclick="location.href='../guest/officeMapPage'">오피스 검색</div>
	</div>
	<c:if test="${!empty sessionUser }">
		<div class="row mt-1 ms-1">
			<div class="col cursor-pointer" onclick="location.href='../guest/officeRentalListPage'">오피스 예약 목록</div>
		</div>			
	</c:if>
	
	<c:if test="${!empty sessionUser }">
		<div class="row mt-5 mb-3">
	    	<div class="col cursor-pointer" style="font-weight: bold;">호스트</div>
	    </div>
		<c:choose>
			<c:when test="${!empty sessionUser && sessionUser.member_type == 'G' }">
				<div class="row mt-1 ms-1">
					<div class="col cursor-pointer" onclick="location.href='../guest/applyHostPage'">호스트 신청하기</div>
				</div>		
			</c:when>
			<c:when test="${!empty sessionUser && sessionUser.member_type == 'H' }">
				<div class="row mt-1 ms-1">
					<div class="col cursor-pointer" onclick="location.href='../host/mainPage'">호스트 페이지</div>
				</div>
				<div class="row mt-1 ms-1">
					<div class="col cursor-pointer" onclick="location.href='../host/registerOfficePage'">오피스 등록하기</div>
				</div>
				<div class="row mt-1 ms-1">
					<div class="col cursor-pointer" onclick="location.href='../host/officeListPage'">오피스 등록 현황</div>
				</div>
				<div class="row mt-1 ms-1">
					<div class="col cursor-pointer" onclick="location.href='../host/rentalStatusPage'">오피스 예약 관리</div>
				</div>
			</c:when>
		</c:choose>
		
	</c:if>
	
	<div class="row mt-5 mb-3">
    	<div class="col cursor-pointer" style="font-weight: bold;">고객센터</div>
    </div>
	<div class="row mt-1 ms-1">
		<div class="col cursor-pointer" onclick="location.href='../board/freeBoardPage'">자유게시판</div>
	</div> 
   	<div class="row mt-1 ms-1">
		<div class="col cursor-pointer" onclick="location.href='../board/QnAPage'">Q&A</div>
	</div> 
  
  </div>
</div>

<!-- 하단 알림박스 -->
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 999999;">
	<div id="liveToast" class="toast" style="background: #adb5bd" role="alert" aria-live="assertive" aria-atomic="true" onclick="location.href='../member/messageListPage'">
		<div id="notification" class="toast-body" style="color: white;"></div>
	</div>
</div>

<script>
	
	var toastLiveExample = document.getElementById('liveToast')
	
	function newMessage(){
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				var toast = new bootstrap.Toast(toastLiveExample);
				var notification = document.getElementById('notification');
				
				var menu = document.getElementById("menu");
				
				if(data.result == 'newMessage') {
					var signal = document.createElement("span");
					signal.setAttribute("class","translate-middle badge rounded-pill bg-danger");
					signal.setAttribute("style","position:absolute; font-size: 0.75rem; top: 1rem;");
					signal.textContent = data.count;
					
					menu.appendChild(signal);
					
					notification.textContent = "새로운 알림이 " + data.count + "개 있습니다";
					
	    			toast.show();
				} else {
					menu.innerHTML="";
				}
			} 
			
		};
		
		xhr.open("GET" , "../member/newMessage", true);
		xhr.send();
	}
	 
	window.addEventListener("DOMContentLoaded" , function(){
		newMessage
		setInterval(newMessage , 4000);
	});

</script>