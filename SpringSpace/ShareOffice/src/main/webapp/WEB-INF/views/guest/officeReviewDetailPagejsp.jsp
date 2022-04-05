<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!-- star-rating -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/fontawesome-stars.css">
<script type="text/javascript" src="../resources/js/jquery.barrating.min.js"></script>
<script>
$(function() {
    $('.reviewRating').barrating({
      theme: 'fontawesome-stars',
      readonly: true,
    });
    $('.reviewRating').barrating('set', 5);
 });

</script>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="margin: 1em;">
	<div class="col">
		<%-- 내용작성 --%>
		<div class="row mt-2">	
			 <div class="col"><a href="javascript:history.back();"class="btn" style="color: #A68A64"><i class="bi bi-arrow-left"></i></a></div>
		     <div class="col text-center"><h3>이용 후기</h3></div>
		     <div class="col"></div>
		</div>		
		<div class="card" style="width: 20rem;">
			<div class="row mt-2">
			  <div class="col text-center">
			    <!-- 별점 출력 수정 -->
				    <select class="reviewRating">
                      <c:forEach begin="1" end="${review.reviewVo.review_rating }">
                        <option value="5">5</option>
                      </c:forEach>  
                     </select>
                  </div>
			 </div>
		  <div class="card-body">		
			     <div class="row">	    
			         <div class="col"><p class="card-text muted"> 작성자:${review.memberVo.member_nick }</p></div>	  	     
			         <div class="col"> <p class="card-text muted"> <fmt:formatDate value="${review.reviewVo.review_date}" pattern="yyyy-MM-dd"/></p></div>	
			     </div>	
				 <div class="row">	
				      <img src="/soUpload/reviewImage/${review.reviewVo.review_image }" class="card-img-top" alt="..." width=100%, height=250em>
				  </div>	
                  <div class="row">
					   <h5 class="card-title">제목:${review.reviewVo.review_title }</h5>
				   </div>
				   <div class="row">
					   <p class="card-text">내용:${review.reviewVo.review_content }</p>
				   </div>				
					<!-- <a href="#" class="btn btn-primary">Go somewhere</a> -->
		    </div>
				
			</div>
		



		
	</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>


