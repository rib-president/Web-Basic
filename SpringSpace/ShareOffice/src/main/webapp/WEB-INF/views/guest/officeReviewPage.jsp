<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<style type="text/css">
 a {text-decoration: none; color:#3ad0ab;}
 i {text-decoration: none; color:#3ad0ab;}
</style>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 70px;">
	<div class="col">
			<div class="row mt-3 text-center" style="">
				<h3>이용후기</h3>
			</div>
			<div class="row mt-2 ">
				<div class="col">
					<div class="card" style="">
						<div class="row">
							<div class="col">
								<div class="card-body">
									<div class="row">
										<div class="col-8">
											<i class="bi bi-star-fill"></i> <i class="bi bi-star-fill"></i>
											<i class="bi bi-star-fill"></i> <i class="bi bi-star-fill"></i>
											<i class="bi bi-star"></i>
										</div>
										<div class="col">
											<p class="card-text">
												<small class="text-muted">리뷰 작성일</small>
											</p>
										</div>

									</div>
									<div class="row">
										<div class="col">
											<img src="https://via.placeholder.com/70"
												class="img-fluid rounded-start">
										</div>
										<div class="col-8 text-left">
											<p class="card-text">디자인만 봐주세요 </p>
											<p class="card-text">출력 아직 못했습니다,,,</p>
										</div>
										<div class="col">
											<i class="bi bi-chevron-right"></i>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="card">
						    <ul class="list-group list-group-flush">
								<c:forEach  items="${reviewList}" >
									<li class="list-group-item d-flex justify-content-between">
									    <div>${review.reviewVo.review_title }</div>
										<div>${review.reviewVo.review_content }</div>
										

									</li>
								</c:forEach>
							</ul>
						
					 </div>   
				</div>
			</div>


		</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>