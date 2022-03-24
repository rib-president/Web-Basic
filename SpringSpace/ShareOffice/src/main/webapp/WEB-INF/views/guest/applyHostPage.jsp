<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>

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
<script type="text/javascript">
function applyHost(){
	
	if($("#inputOwner").val() == ""){
		alert("대표자명을 입력해주세요.");
		$("#inputId").focus();
		return;
	}
	
	
	var inputNumeber = document.getElementById("inputNumeber");
	var inputNumeber2 = document.getElementById("inputNumeber2");
	var inputNumeber3 = document.getElementById("inputNumeber3");
	inputNumber.value = inputNumber.value + "-" + inputNumber2.value + "-" + inputNumber3.value;
	
	var frm = document.getElementById("frm");
		
	frm.submit();
}

/*
window.onload = function() {
    document.getElementById('btn').onclick = function() {
    	var inputNumeber = document.getElementById("inputNumeber");
		var inputNumeber2 = document.getElementById("inputNumeber2");
		var inputNumeber3 = document.getElementById("inputNumeber3");
		inputNumber.value = inputNumber.value + "-" + inputNumber2.value + "-" + inputNumber3.value;
    	
        document.getElementById('frm').submit();

    };
};
*/
</script>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>
<div class="row" style="padding-top: 70px;">
  <div class="col">
   <div class="row mt-5 text-center"><h4>호스트 등록하기</h4></div>

				<div class="row">
					<div class="col-md-12 ">
					   <form id="frm" action="./applyHostProcess" method="post" enctype="multipart/form-data">				
						<div class="card text-dark bg-light mb-3 " style="margin: 20px">
							<div class="card-body">
								<div class="row mt-2">
									<div class="col">
										<p class="fw-lighter ">대표자명</p>
										<input type="text" id="inputOwner" name="host_owner" 
										class="form-control form-control-sm"placeholder="대표자명을 입력해주세요.">
									</div>
								</div>
								<div class="row mt-2">
									<div class="col">
										<p class="fw-lighter">상호명</p>
										<input  type="text" name="host_name"
											class="form-control form-control-sm"placeholder="상호명을 입력해주세요.">
									</div>
								</div>


								<div class="row mt-2">
									<p class="fw-lighter">사업자 등록번호</p>
									<div class="col">
										<input id="inputNumber" name="host_license_number" type="text" maxlength="2" 
											class="form-control form-control-sm"placeholder="00">
									</div>-
									<div class="col">
										<input id="inputNumber2" type="text" maxlength="3"
											class="form-control form-control-sm" placeholder="000">
									</div>-
									<div class="col">
										<input id="inputNumber3" type="text" maxlength="5"
											class="form-control form-control-sm" placeholder="00000">
									</div>
								</div>
								<div class="row mt-2">
									<div class="col">
										<p class="fw-lighter">사업자 등록증 첨부</p>
										<input class="form-control form-control-sm" id="formFileSm"
											type="file" name="host_license_img" accept="image/*" multiple name="license_img">
									</div>
								</div>
							</div>
						   <input type=hidden name="member_no" value="2" class="form-control">
						   <input type=hidden name="host_approve" value="P" >
						   <input type=hidden name="host_approve_comment" value="">
						   <input type=hidden name="host_approve_date" value="">
							<div class="row text-center mt-4" >
								<div class="col" >
									<a onclick="location.href = document.referrer;" type="button" class="btn btn-light">cancel</a>
								</div>
								<div class="col">
									<button type="button" class="btn btn-light" onclick="applyHost()">submit</button>
								</div>
							</div>
						</div>
                       </form>
					</div>
				</div>
		</div>
</div>	
	
	<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>