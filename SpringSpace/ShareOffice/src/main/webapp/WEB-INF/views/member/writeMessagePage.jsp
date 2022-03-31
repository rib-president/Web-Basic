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

<script>

 function goData() {
	 var form = document.userInput
	 form.submit()
}

</script>


</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 70px;">
	<div class="col"  style="font-family: 'NanumSquare';">
		<div class="row">
			<div class="col" style="background-color: #3ad0ab; color: white; text-align: center; font-size: 1.5rem;">쪽지보내기</div>
		</div>
		
		<form action="./writeMessageProcess" class="form" role="form" style="font-size: 1.3rem;" name="userInput">
			<div class="row">
				<div class="col" style="margin-left: 0.5rem; margin-top: 0.5rem; padding-top: 0.4rem;">
					작성자 : ${sessionUser.member_nick }
				</div>
				<div class="col" style="text-align: right; margin-right: 1rem; font-size: 2rem; margin-top: 0.5rem;">
					<i class="bi bi-send" onclick="goData()"></i>
				</div>
			</div>
			<div class="mb-3" style="margin-left: 0.5rem; margin-right: 0.5rem;">
			  <input type="text" class="form-control" placeholder="받는 사람 닉네임을 입력해 주세요." name="nick" style="font-size: 1.3rem;">
			</div>
    		<hr>
			<div class="mb-3" style="margin: 0.5rem;">
			   <textarea class="form-control" id="exampleFormControlTextarea1" rows="18" name="txt" placeholder="내용을 입력해 주세요." style="font-size: 1.3rem;"></textarea>
			</div>
		</form>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>