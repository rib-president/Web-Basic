<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function findAddr(){
		new daum.Postcode({
	        oncomplete: function(data) {
				
				// 도로명 주소 변수
				var roadAddr = data.roadAddress;
				// 지번 주소 변수
				var jibunAddr = data.jibunAddress;
				
	            if(roadAddr !== ''){
	                document.getElementById("addr").value = roadAddr;
	            } 
	            else if(jibunAddr !== ''){
	                document.getElementById("addr").value = jibunAddr;
	            }
	        }
	    }).open();
	}

	
	function joinMemberSubmit() {
		var addr = document.getElementById("addr");
		var detail_addr = document.getElementById("detail_addr");
		
		if(detail_addr.value != null) {
			addr.value = addr.value + " " + detail_addr.value;
		}
		
		var frm = document.getElementById("frm");
		frm.submit();
	}
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form id="frm" action="./joinMemberProcess" method="post">
		ID : <input type="text" name="member_id"><br>
		PW : <input type="password" name="member_pw"><br>
		Name : <input type="text" name="member_name"><br>
		Nickname : <input type="text" name="member_nick"><br>
		gender :
		<!-- check, radio, select는 value값이 미리 지정되어 있어야함 -->
		<input type="radio" name="member_gender" value="M">남
		<input type="radio" name="member_gender" value="F">여<br>
		birth : <input type="date" name="member_birth"><br>
		phone : <input type="text" name="member_phone"><br>
		address : <input type="text" id="addr" name="member_address" readonly> <span><button type="button" onclick="findAddr()">주소 찾기</button></span><br>
		detail address : <input id="detail_addr" type="text"><br>
		e-mail : <input type="text" name="member_email"><br>
		<input type="button" value="회원가입" onclick="joinMemberSubmit()">
	</form>

</body>
</html>