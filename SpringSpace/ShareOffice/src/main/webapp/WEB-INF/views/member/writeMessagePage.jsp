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


</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 70px;">
	<div class="col">
		<div class="row">
			<div class="col" style="background-color: #3ad0ab; color: white; text-align: center; font-size: 1.5em; font-weight: bold;">쪽지보내기</div>
		</div>
		
		<form action="./writeMessageProcess" method="post" class="form" role="form" style="font-size: 1.5em;">
			<div class="mb-3 row">
				<div class="col" style="margin-left: 0.5em; margin-top: 0.5em;">작성자 :</div>
			</div>
			<div class="mb-3 row">
				<div class="col" style="margin-left: 0.5em;">받는 사람 : </div>
	    		<div class="col-sm-10"><input type="text" name="receive_no" class="form-control"></div>
    		</div>
    		<hr>
    		<div class="row" >
				<div class="col" style="margin-left: 0.5em;">내용 : </div>
			</div>
			<textarea rows="15" name="txt" class="form-control input-lg"></textarea><br>
			<button class="btn btn-lg btn-primary btn-block " type="submit">보내기</button>
		</form>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>