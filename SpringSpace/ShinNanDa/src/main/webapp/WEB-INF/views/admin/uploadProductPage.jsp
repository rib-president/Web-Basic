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

<style>
	.image-selected {border: 3px solid black; opacity: 0.5;}

</style>

<script>

	var image_map = new Map();


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

	
	function viewUploadDetailImage(event) {
		image_map.clear();

		const image_container = document.querySelector("div#image_container");
		while (image_container.hasChildNodes()) {	
			image_container.removeChild(image_container.firstChild);
		}
		
		var i = 0;
		//var j = 0;
		for (var image of event.target.files) {
			
			var reader = new FileReader();

			image_map.set("img_" + i, image);
			reader.onload = function(e) {
				var img = document.createElement("img");
				//img.setAttribute("id", "img_" + j);
				img.setAttribute("src", e.target.result);
				img.setAttribute("style", "width: 300px;");
				img.setAttribute("onclick", "selectThumbnail(this)");
				document.querySelector("div#image_container").appendChild(img);
				//image_map.set("img_" + j, event.target.files[j]);
				
				//j++;
			};
			console.log(image);
			reader.readAsDataURL(image); 
			i++;
		}
	}
	
	function selectThumbnail(img) {
		
		if(img.getAttribute("class") != null) return;
		
		var selected_images = document.getElementsByClassName("image-selected");
		if(selected_images != null) {
			for(selected_image of selected_images) {
				selected_image.removeAttribute("class");
			}
		}
		
		img.setAttribute("class", "image-selected");
	}
	
	function registProduct(event) {
		event.preventDefault();
		var formData = new FormData(document.querySelector("#frm"));
		//var selected_image = document.querySelector(".image-selected");

		var imgs = document.querySelector("div#image_container").querySelectorAll("img");
		var selected_image = null;
		var thumbnail_id = 0;

		for(var j=0;j<imgs.length;j++) {
			if(imgs[j].getAttribute("class") == "image-selected") {
				selected_image = imgs[j];
				thumbnail_id = "img_" + j;
			}	
		}		
		
		if(selected_image == null) {
			alert("대표이미지를 선택해주세요.");
			return;
		}
		
		//var thumbnail_id = selected_image.getAttribute("id");
		
		
		var thumbnail = image_map.get(thumbnail_id);

		formData.append("thumbnail", thumbnail);
		image_map.delete(thumbnail_id);

		for(key of image_map.keys()) {
			formData.append("detailimages", image_map.get(key));
		}

		formData.enctype='multipart/form-data';

		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			
			if(xhr.readyState == 4 && xhr.status == 200) {
				location.href = "../admin/manageProductPage";
				
			}
		};
		
		xhr.open("POST", "./uploadProductProcess", true);
		xhr.send(formData);
		
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
		
		<form id="frm" method="post" enctype="multipart/form-data">
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
				<%-- <div class="row mt-2">
					<div class="col">
					 	대표 이미지 : 
					 </div>
					 <div class="col"><input type="file" accept="image/*" name="thumbnail"></div>
				</div> --%>
				
				<div class="row mt-2">
					<div class="col">
					 	이미지 : 
					 </div>
					 <div class="col"><input type="file" accept="image/*" multiple onchange="viewUploadDetailImage(event);"></div>
				</div>
				<div class="row mt-2">
					<div class="col"><div id="image_container"></div></div>
				</div>				
				
				<div class="row mt-2">
					<div class="col"><button onclick="registProduct(event)">상품 등록</button></div>
				</div>
			</div>
		</div>
		</form>
		
		
		
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>