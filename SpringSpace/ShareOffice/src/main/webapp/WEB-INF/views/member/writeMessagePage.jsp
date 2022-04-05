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

<script>

 var isConfirmed = false;
 
 function goData() {
	 
	 if(isConfirmed == false){
			alert("존재하지 않는 닉네임 입니다.");
			$("inputNick").val("");
			return;
		}
	 var form = document.userInput
	 form.submit()
}

 function confirmId(){

 	var idBox = document.getElementById("inputNick");
 	var idValue = idBox.value;
 	
 	var xhr = new XMLHttpRequest();
 	
 	xhr.onreadystatechange = function(){
 		if(xhr.readyState == 4 && xhr.status == 200){
 			var data = JSON.parse(xhr.responseText);
 			
 			var confirmAlertBox = document.getElementById("confirmAlertBox");
 			if(data.result == 'notNick'){
 				isConfirmed = false;
 				confirmAlertBox.innerText = "존재하지 않는 닉네임 입니다.";
 				confirmAlertBox.setAttribute("style","margin-left: 1rem; font-size: 0.75rem; color: red; padding-top: 0.5rem;");
 			}else{
 				isConfirmed = true;
 				confirmAlertBox.innerHTML = "";
 				confirmAlertBox.setAttribute("style","padding-top: 0rem;");
 			}
 			
 		}
 		
 	};
 	
 	
 	xhr.open("GET" , "./checkNick?nick=" + idValue , true);
 	xhr.send();
 	
 }
</script>

	<style>
	
		#writeMessage{
			border-radius: 0.3rem 0.3rem 0.3rem 0.3rem; 
			background-color:#A68A64; 
			color: white; 
			text-align: center; 
			font-size: 1.1rem; 
			padding-top: 0.3rem; 
			padding-bottom: 0.3rem;
			font-weight: bold;
		}
	
	</style>

</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row">
	<div class="col">
		<div class="row mt-4" style="margin: 1rem;">
			<div class="col" id="writeMessage">쪽지보내기</div>
		</div>
		
		<form action="./writeMessageProcess" class="form" role="form" style="font-size: 1.1rem;" name="userInput">
			<div class="row">
				<div class="col" style="margin-left: 1rem; padding-top: 0.5rem;">
					작성자 : ${sessionUser.member_nick }
				</div>
				<div class="col" style="text-align: right; margin-right: 1rem; font-size: 1.8rem;">
					<i class="bi bi-send" onclick="goData()"></i>
				</div>
			</div>
			<div style="margin-left: 1rem; margin-right: 1rem;">
			  <input type="text" id="inputNick" onblur="confirmId()" class="form-control" placeholder="받는 사람 닉네임을 입력해 주세요." name="nick">
			</div>
			<div id="confirmAlertBox"></div>
    		<hr>
			<div class="mb-3" style="margin: 1rem;">
			   <textarea class="form-control" id="exampleFormControlTextarea1" rows="18" name="txt" placeholder="내용을 입력해 주세요."></textarea>
			</div>
		</form>
	</div>
</div>


<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>