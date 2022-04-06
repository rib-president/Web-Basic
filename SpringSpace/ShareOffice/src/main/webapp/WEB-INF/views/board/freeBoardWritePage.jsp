<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
	#bgColor {
		background-color: #3ad0ab;
	}
</style>


<title>Insert title here</title>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 2em;">
	<div class="col" style="margin:2rem">
	<%-- 내용작성 --%>
		<div class="row">
			<form action="./freeBoardWriteProcess" method="get">
			<div class="col">
				<h4 class="text-center">글쓰기페이지</h4>
			</div>
				<div class="row">
					<div class="col">
						제목  <input type="text" class="form-control" name="freeboard_title">
					</div>	
				</div>	
				 
				<div class="row">
					<div class="col">
						작성자 : <div>${sessionUser.member_nick }</div>
					</div>
				</div>
				 
				 
				<hr>			
				<div class="row">
					<div class="col">
						내용  <textarea class="form-control" rows="5" name="freeboard_content"></textarea>
					</div>
				</div>
				<!-- 
				<div class="row">
					<div class="col">
						<input type="file" accept="image/*" class="form-control" multiple name="" aria-describedby="inputGroupFileAddon03" aria-label="Upload">
					</div>
				</div>
				 -->
				<div class="row">
					<div class="col mt-2">
						<input type="submit" style="background-color: rgb(58,208,171);" class="float-end btn btn-light" value="글작성">						
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

	
