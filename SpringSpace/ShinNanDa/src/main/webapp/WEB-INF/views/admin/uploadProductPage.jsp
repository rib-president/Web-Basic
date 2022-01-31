<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">

<script>
	function addOptionStockBox() {
		var row = document.createElement("div");
		var col1 = document.createElement("div");
		var col2 = document.createElement("div");
		var optionBox = document.createElement("input");
		var stockBox = document.createElement("input");
		
		row.setAttribute("class", "row mt-2");
		col1.setAttribute("class", "col");
		col2.setAttribute("class", "col");
		
		optionBox.setAttribute("type", "text");
		optionBox.setAttribute("name", "product_detail_option");
		optionBox.setAttribute("placeholder", "옵션을 입력하세요");
		
		stockBox.setAttribute("type", "text");
		stockBox.setAttribute("name", "product_detail_stock");
		stockBox.setAttribute("placeholder", "재고를 입력하세요");
		
		col1.appendChild(optionBox);
		col2.appendChild(stockBox);
		
		row.appendChild(col1);
		row.appendChild(col2);
		
		var optionStockBox = document.getElementById("optionStockBox");
		optionStockBox.appendChild(row);	
	}


</script>
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
		
		<form action="./uploadProductProcess" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col">
				<div class="row mt-2">
					<div class="col">카테고리 : </div>
					<div class="col">
						<select name="product_category_no">
						  <c:forEach items="${product_categoryVoList }" var="product_categoryVo">
							<option value=${product_categoryVo.product_category_no }>${product_categoryVo.product_category_name }</option>						  
						  </c:forEach>																					
						</select>
					</div>
				</div>
				<div class="row mt-2">
					<div class="col">브랜드 : </div>
					<div class="col">
						<select name="brand_no">
						  <c:forEach items="${brand_categoryVoList }" var="brand_categoryVo">
							<option value=${brand_categoryVo.brand_no }>${brand_categoryVo.brand_name }</option>						  
						  </c:forEach>
						</select>
					</div>
				</div>
				<div class="row mt-2">
					<div class="col">상품명 : </div>
					<div class="col"><input name="product_title" type="text"></div>
				</div>
				<div class="row mt-2">
					<div class="col">모델명 : </div>
					<div class="col"><input name="product_model" type="text"></div>
				</div>
				<div class="row mt-2">
					<div class="col">가격 : </div>
					<div class="col"><input name="product_price" type="text"></div>
				</div>
				<div class="row mt-2">
					<div class="col">상품 설명 :</div>
					<div class="col"><input name="product_content" type="text"></div>
				</div>
				<div id="optionStockBox" class="row mt-2">
					<div class="col">옵션 및 재고 : <span><button type="button" onclick="addOptionStockBox()"><i class="bi bi-plus-circle"></i></button></span></div>
					<div class="row">
						<div class="col"><input name="product_detail_option" type="text" placeholder="옵션을 입력하세요"></div>
						<div class="col"><input name="product_detail_stock" type="text" placeholder="재고를 입력하세요"></div>
					</div>
				</div>
				<div class="row mt-2">
					<div class="col">
					 	대표 이미지 : 
					 </div>
					 <div class="col"><input type="file" accept="image/*" name="thumbnail"></div>
				</div>
				
				<div class="row mt-2">
					<div class="col">
					 	상세 이미지 : 
					 </div>
					 <div class="col"><input type="file" accept="image/*" multiple name="detailimages"></div>
				</div>				
				
				<div class="row mt-2">
					<div class="col"><input type="submit" value="상품 등록"></div>
				</div>
			</div>
		</div>
		</form>
		
		
		
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>