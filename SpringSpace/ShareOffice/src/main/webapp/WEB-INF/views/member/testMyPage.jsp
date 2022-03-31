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
<link href="https://webfontworld.github.io/naver/NanumSquare.css" rel="stylesheet">

</head>

<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 1rem;">
	<div class="col" style="text-align: right; font-family: 'NanumSquare'; margin: 0.5rem; position:relative">
		${sessionUser.member_nick } 님
		<a href="../member/messageListPage">
			<i id="alram" class="bi bi-bell" style="color: black; font-size: 2rem;"></i> <!-- 쪽지함 -->
		</a>
		<a href="../member/logoutProcess">로그아웃</a>	
	</div>
<div class="row mb-3">
	<div class="col"></div>
	<div class="col cursor-pointer rounded-full" style="background-color: #3ad0ab; color: white; text-align: center; font-size: 1.5rem;" onclick="location.href='../member/messageListPage'">쪽지함 가기</div>
	<div class="col"></div>
</div>
		<!-- 하단 알림박스 -->
		<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11;">
		  <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
		    <div id="notification" class="toast-body">
		    </div>
		  </div>
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
				
				var alram = document.getElementById("alram");
				
				if(data.result == 'newMessage') {
					var signal = document.createElement("span");
					signal.setAttribute("class","translate-middle badge rounded-pill bg-danger");
					signal.setAttribute("style","position:absolute; font-size: 0.75rem; top: 0.25rem;");
					signal.textContent = data.count;
					
					alram.appendChild(signal);
					
					notification.textContent = "새로운 알림이 " + data.count + "개 있습니다";
					
	    			toast.show();
				} else {
					alram.innerHTML="";
				}
			} 
			
		};
		
		xhr.open("GET" , "./newMessage", true);
		xhr.send();
	}
	 
	window.addEventListener("DOMContentLoaded" , function(){
		newMessage
		setInterval(newMessage , 4000);
	});
	
		

</script>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>