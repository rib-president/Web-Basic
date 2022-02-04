<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">
<link href="../resources/css/shopMain.css" rel="stylesheet">

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
		  	  
		  <c:set var="endNum" value="${fn:length(voList)/4-1}" />
		  <c:set var="res" value="${fn:length(voList)% 4 }" />
		  <c:set var="lastJ" value="0" />
		  
		  <c:if test="${fn:length(voList)>=4 }">
			  <c:forEach begin="0" end="${endNum }" var="i">
			    <div class="row mt-5 ms-3">
			      <c:forEach begin="${i*4 }" end="${i*4+3 }" var="j">
			  	  	<div class="col product_image">
			  	  	  <a href="../shop/detailProductPage?product_no=${voList.get(j).product_no }"><img class="img-fluid" src="/upload/product/${voList.get(j).product_image }" style="height:500px;"></a>
			  	  	  <div class="row">
			  	  	  	<div class="col product_info">
			  	  	  	  <p>
				  	  	  	상품명 : ${voList.get(j).product_title }<br>
				  	  	  	모델명 : ${voList.get(j).product_model }<br>
				  	  	  	가격 : ${voList.get(j).product_price }
				  	  	  </p> 	  	  	  	
			  	  	  	</div>
			  	  	  </div>		  	  	  
			  	  	</div>
			  	  	<c:set var="lastJ" value="${j+1 }" />		        
			      </c:forEach>
			    </div>
			  </c:forEach>
		  </c:if>
		
		  <c:if test="${res > 0 }">
		    <div class="row mt-5 ms-3">
		  	  <c:forEach begin="${lastJ }" end="${lastJ + 3 }" var="j">
		  	    <c:choose>
		  	      <c:when test="${fn:length(voList) <= j }">
		  	        <div class="col"></div>
		  	      </c:when>
		  	      <c:otherwise>
			  	  	<div class="col product_image">
			  	  	  <a href="../shop/detailProductPage?product_no=${voList.get(j).product_no }"><img class="img-fluid" src="/upload/product/${voList.get(j).product_image }" style="height:500px;"></a>
			  	  	  <div id="aaa" class="row">
			  	  	  	<div class="col product_info">
			  	  	  	  <p>
				  	  	  	상품명 : ${voList.get(j).product_title }<br>
				  	  	  	모델명 : ${voList.get(j).product_model }<br>
				  	  	  	가격 : ${voList.get(j).product_price }
				  	  	  </p> 	  	  	  	
			  	  	  	</div>
			  	  	  </div>		  	  	  
			  	  	</div>			  	      
		  	      </c:otherwise>
		  	    </c:choose>		    
		  	  </c:forEach>
		  	</div>
		  </c:if>
			  
		  								
		</div>
 	</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>