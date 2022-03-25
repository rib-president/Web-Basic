<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script src="https://cdn.tutorialjinni.com/jquery-ui-multidatespicker/1.6.6/jquery-ui.multidatespicker.js"></script>
<script src="https://cdn.tutorialjinni.com/jquery-ui-multidatespicker/1.6.6/jquery-ui.multidatespicker.min.js"></script> 

<link href="../resources/css/mobiscroll.jquery.min.css" rel="stylesheet" />
<script src="../resources/js/mobiscroll.jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="../resources/css/commons.css">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/datePickerStyle.css">

<script>
function applyHost(){
	

	var host_owner= document.getElementById("host_owner");
    var host_name= document.getElementById("host_name");
    var host_license_img= document.getElementById("host_license_img");
	
	var host_license_number = document.getElementById("host_license_number");
	var host_license_number2 = document.getElementById("host_license_number2");
	var host_license_number3 = document.getElementById("host_license_number3");
	host_license_number.value = host_license_number.value + "-" + host_license_number2.value + "-" + host_license_number3.value;
	
    document.getElementById("apply_form").submit();
	
}



</script>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>
<div class="row" style="padding-top: 70px;">
  <div class="col">
   <div class="row mt-5 text-center"><h4>호스트 등록하기</h4></div>

				<div class="row">
					<div class="col-md-12 ">
					   <form id="apply_form" action="./applyHostProcess" method="post" enctype="multipart/form-data">				
						<div class="card text-dark bg-light mb-3 " style="margin: 20px">
							<div class="card-body">
								<div class="row mt-2">
									<div class="col">
										<p class="fw-lighter ">대표자명</p>
										<input type="text" id="host_owner" name="host_owner" 
										class="form-control form-control-sm"placeholder="대표자명을 입력해주세요.">
									</div>
								</div>
								<div class="row mt-2">
									<div class="col">
										<p class="fw-lighter">상호명</p>
										<input  type="text"  id="host_name" name="host_name" 
											class="form-control form-control-sm"placeholder="상호명을 입력해주세요.">
									</div>
								</div>


								<div class="row mt-2">
									<p class="fw-lighter">사업자 등록번호</p>
									<div class="col">
										<input id="host_license_number" name="host_license_number" type="text" maxlength="2" 
											class="form-control form-control-sm"placeholder="00">
									</div>-
									<div class="col">
										<input id="host_license_number2" name="host_license_number2"type="text" maxlength="3"
											class="form-control form-control-sm" placeholder="000">
									</div>-
									<div class="col">
										<input id="host_license_number3" name="host_license_number3"type="text" maxlength="5"
											class="form-control form-control-sm" placeholder="00000">
									</div>
								</div>
								<div class="row mt-2">
									<div class="col">
										<p class="fw-lighter">사업자 등록증 첨부</p>
										<input class="form-control form-control-sm" id="host_license_img"
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
									<input type="button" class="btn btn-light" onclick="applyHost(event)" value="submit">
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