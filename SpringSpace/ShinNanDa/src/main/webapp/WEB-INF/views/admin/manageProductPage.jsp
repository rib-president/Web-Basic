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
<link href="../resources/css/commons.css" rel="stylesheet">
</head>
<body>
<div style="width:1200px;margin : 0 auto">
	<div class="container-fluid">
		<div class="row">
			<div class="col"><!-- 글로벌 nav -->
				<jsp:include page="../commons/global_nav.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="../commons/admin_menu_bar.jsp"></jsp:include>

		<div class="row">
			<div class="col">
				<table class="table table-hover">
				  <thead>
				    <tr>
				      <th scope="col">no</th>
				      <th scope="col">thumbnail</th>
				      <th scope="col">상품명(모델명)</th>
				      <th scope="col">옵션 및 재고</th>
				      <th scope="col">판매가</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${totalVoList }" var="totalVo">
					    <tr>
					      <th scope="row">${totalVo.productVo.product_no }</th>
					      <td><img class="img-fluid" src="/upload/product/${totalVo.productVo.product_image }" style="width: 300px;"></td>
					      <td>${totalVo.productVo.product_title }(${totalVo.productVo.product_model })</td>
				          <td>
				            <c:forEach begin="0" end="${fn:length(totalVo.product_DetailVoList)-1}" var="i">
					          <div class="row mt-2">
					            <div class="col">
					              ${totalVo.product_DetailVoList.get(i).product_detail_option }
					            </div>
			                    <div class="col">
			                      <c:choose>
			                        <c:when test="${totalVo.product_DetailVoList.get(i).product_detail_stock - totalVo.sumOrdersDetailCount.get(i) <= 0 }">
			                          <div class="row"><div class="col" style="color:red; font-weight:bold;">품절</div></div>
			                        </c:when>
			                        <c:otherwise>
			                          ${totalVo.product_DetailVoList.get(i).product_detail_stock - totalVo.sumOrdersDetailCount.get(i) } 개
			                        </c:otherwise>
			                      </c:choose>
				                </div>				                
					          </div>				                  
				            </c:forEach>
				          </td>					      
					      <td>${totalVo.productVo.product_price }원</td>
					    </tr>				  
				  	</c:forEach>
				  </tbody>
				</table>			
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>