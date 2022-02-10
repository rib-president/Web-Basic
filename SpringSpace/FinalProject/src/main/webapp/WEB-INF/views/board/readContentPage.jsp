<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<title>Insert title here</title>

<script>
	var sessionInfo = null;
	
	var board_no = ${data.boardVO.board_no };

	function doLike() {
		
		if(sessionInfo == null) {
			var value = confirm("로그인하셔야 이용가능 합니다. 로그인 페이지로 이동하시겠습니까?");
			
			if(value == true) {
				location.href="../member/loginPage";
			}
			
			return;
		}
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);

				refreshHeart();
				refreshTotalCount();
			}
			
		};
		
		xhr.open("post", "./doLike", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("board_no=" + board_no);
	}
	
	function refreshHeart() {
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				if(data.result == 'error') {
					//alert(data.reason);
					return;
				}
				
				var heartBox = document.getElementById("heartBox");
				
				if(data.status == 'like') {
					heartBox.setAttribute("class", "bi bi-heart-fill fs-1 text-danger");
				} else {
					heartBox.setAttribute("class", "bi bi-heart fs-1 text-danger");
				}
			}
			
		};
		
		xhr.open("get", "./getMyLikeStatus?board_no=" + board_no, true);
		xhr.send();
	}
	
	function refreshTotalCount() {
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				var totalLikeCountBox = document.getElementById("totalLikeCountBox");
				totalLikeCountBox.innerText = data.totalLikeCount;
			}
			
		};
		
		xhr.open("get", "./getTotalLikeCount?board_no=" + board_no, true);
		xhr.send();			
	}
	
	function getSessionInfo() {
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				if(data.result != 'empty') {
					sessionInfo = {
						memberNo : data.memberNo,
						memberNick : data.memberNick
					};
				}
				
			}
			
		};
		
		xhr.open("get", "../member/getSessionInfo", false);	// false: 동기식(웬만하면 쓰지망)
		xhr.send();
	}
	
	
	function writeComment() {
		if(sessionInfo == null) {
			alert("로그인 후 이용 가능합니다");
			return;
		}
		
		var commentInput = document.getElementById("commentInput");
		var commentValue = commentInput.value;
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);
				
				commentInput.value = "";
				refreshCommentList();
			}
		};
		
		xhr.open("post", "./writeComment", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("member_no=" + sessionInfo.memberNo + "&board_no=" + board_no + "&comment_content=" + commentValue);
		
	}
	
	function refreshCommentList() {
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				
				var data = JSON.parse(xhr.responseText);
							
				// 데이터를 이용하여 렌더링				

				var commentRoot = document.getElementById("commentRoot");
				commentRoot.innerHTML = "";	// 전부 자식 element 제거
				
				for(commentData of data.commentList) {
					var rowBox = document.createElement("div");
					rowBox.setAttribute("class", "row commentBox");
					
					var nicknameBox = document.createElement("div");
					nicknameBox.setAttribute("class", "col-2 fw-bold bg-danger");
					nicknameBox.innerText = commentData.MEMBER_NICK;
					rowBox.appendChild(nicknameBox);
					
					var contentBox = document.createElement("div");
					contentBox.setAttribute("class", "col-6 bg-secondary");
					contentBox.innerText = commentData.COMMENT_CONTENT;
					rowBox.appendChild(contentBox);
					
					var dateBox = document.createElement("div");
					dateBox.setAttribute("class", "col-2 bg-warning");
					dateBox.innerText = commentData.COMMENT_WRITEDATE;
					rowBox.appendChild(dateBox);
					
					if(sessionInfo != null && commentData.MEMBER_NO == sessionInfo.memberNo) {
						var deleteBox = document.createElement("div");
						deleteBox.setAttribute("class", "col-1 bg-success");
						deleteBox.innerText = "X";
						rowBox.appendChild(deleteBox);
						
						var updateBox = document.createElement("div");
						updateBox.setAttribute("class", "col bg-info");
						updateBox.innerText = "수정";
						rowBox.appendChild(updateBox);
					}
					commentRoot.appendChild(rowBox);
				}								
			}
		};
		
		xhr.open("get", "./getCommentList?board_no=" + board_no, true);
		xhr.send();
				
	}
	
	window.addEventListener("DOMContentLoaded", function(){
		getSessionInfo();
		refreshTotalCount();
		refreshHeart();
		refreshCommentList();
		
		setInterval(refreshCommentList, 3000);
	});


</script>

</head>
<body>
	<h1>${data.boardVO.board_title }</h1>
	
	작성자 : ${data.memberVO.member_nick }<br>
	작성일 : ${data.boardVO.board_writedate }<br>
	조회수 : ${data.boardVO.board_readcount }<br>
	
	이미지 : <br>
	<c:forEach items="${data.boardImageVOList }" var="boardImageVO">
		<img src="/upload/${boardImageVO.image_url }"><br>
	</c:forEach>
	
	
	내용 :<br>
	${data.boardVO.board_content }<br>
	
	<br>
	<i id="heartBox" class="bi bi-heart fs-1 text-danger" onclick="doLike()"></i>
	<br>
	좋아요 수 : <span id="totalLikeCountBox"></span>
	<br>
	
	<br><a href="./mainPage">목록으로</a>
	
	<!-- 로그인+본인이 쓴 글일경우 수정, 삭제 버튼 나타남 -->
	<c:if test="${!empty sessionUser && sessionUser.member_no == data.boardVO.member_no }">
	<a href="./deleteContentProcess?board_no=${data.boardVO.board_no }">삭제</a>
	<a href="./updateContentPage?board_no=${data.boardVO.board_no }">수정</a>
	</c:if>
	
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-8">
				<textarea id="commentInput" class="form-control" placeholder="댓글 입력하세요"></textarea>
			</div>
			<div class="col d-grid">
				<button class="btn btn-outline-danger" onclick="writeComment()">입력</button>
			</div>
		</div>
		
		<div class="row"> <!-- 댓글 리스트 루트 -->
			<div class="col" id="commentRoot">
										
			</div>
		</div>
		
	</div>
	
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
</body>
</html>