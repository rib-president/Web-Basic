<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">

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


function modifyMemberSubmit() {
	var pw = document.getElementById("pw");
	var addr = document.getElementById("addr");
	var detail_addr = document.getElementById("detail_addr");
	
	if(pw.value == "") {
		pw.value = '${sessionUser.member_pw}';
	}
	
	if(detail_addr.value != "") {
		addr.value = addr.value + " " + detail_addr.value;
	}
	
	var frm = document.getElementById("frm");
	frm.submit();
}
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<div style="margin: 0 auto;">
 <div class="container-fluid">
	<div class="row">
		<div class="col"><!-- 글로벌 nav -->
			<jsp:include page="../commons/global_nav.jsp"></jsp:include>
		</div>
	</div>

 	<div class="row">
		<jsp:include page="../commons/menu_bar.jsp"></jsp:include>
		<div class="col">	  
			<div class="row mt-3">
				<div class="col"><h1>회원 정보 관리</h1><hr></div>
			</div>
			
			<form id="frm" action="../member/modifyMemberInfo" method="post">
			<div class="row mt-5">
			  <div class="col">
			    <div class="row mt-3">
			      <div class="col-3">아이디</div>
			      <div class="col">${sessionUser.member_id }</div>
			    </div>
			    <div class="row mt-3">
			      <div class="col-3">비밀번호</div>
			      <div class="col"><input class="form-control" id="pw" type="password" name="member_pw"></div>
			    </div>
			    <div class="row mt-3">
			      <div class="col-3">비밀번호 확인</div>
			      <div class="col"><input class="form-control" type="password"></div>
			    </div>
			    <div class="row mt-3">
			      <div class="col-3">이름</div>
			      <div class="col">${sessionUser.member_name }</div>
			    </div>				    
			    <div class="row mt-3">
			      <div class="col-3">닉네임</div>
			      <div class="col"><input class="form-control" type="text" name="member_nick" value="${sessionUser.member_nick }"></div>
			    </div>			    			    
			    <div class="row mt-3">
			      <div class="col-3">성별</div>
			      <div class="col">
			        <c:choose>
			          <c:when test="${sessionUser.member_gender =='M' }">
			          	남
			          </c:when>
			          <c:otherwise>
			          	여
			          </c:otherwise>
			        </c:choose>
			      </div>
			    </div>	
			    <div class="row mt-3">
			      <div class="col-3">생년월일</div>
			      <div class="col"><fmt:formatDate value="${sessionUser.member_birth }" pattern="yyyy-MM-dd" /></div>
			    </div>	
			    <div class="row mt-3">
			      <div class="col-3">핸드폰 번호</div>
			      <div class="col"><input class="form-control" type="text" name="member_phone" value="${sessionUser.member_phone }"></div>
			    </div>	
			    <div class="row mt-3">
			      <div class="col-3">주소</div>
			      <div class="col"><input class="form-control" type="text" id="addr" name="member_address" value="${sessionUser.member_address }" readonly></div>
			      <div class="col"><button class="btn btn-primary" type="button" onclick="findAddr()">주소 찾기</button></div>
			    </div>
			    <div class="row mt-3">
			      <div class="col-3">상세 주소</div>
			      <div class="col"><input class="form-control" id="detail_addr" type="text"></div>
			    </div>				    
			    <div class="row mt-3">
			      <div class="col-3">이메일</div>
			      <div class="col"><input class="form-control" type="text" name="member_email" value="${sessionUser.member_email }"></div>
			    </div>

				<input type="button" value="수정완료" onclick="modifyMemberSubmit()">
			  </div>
			</div>				
			</form>
	  								
		</div>
 	</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>