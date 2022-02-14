<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="../resources/css/commons.css" rel="stylesheet">

<script>
	function createContainer(data, isRefresh=false) {
		
		var root = document.querySelector("#restockContainer");
		
		if(isRefresh) {
			var arr = root.querySelectorAll(".row");
			
			arr[1].querySelector("products").value;
		}
		
		
		var row = document.createElement("div");
		row.setAttribute("class", "row mt-3");
		
		var col1 = document.createElement("div");
		col1.setAttribute("class", "col");
		col1.innerText = "상품 선택";
		var col2 = document.createElement("div");
		col2.setAttribute("class", "col");
		var selectProduct = document.createElement("select");
		selectProduct.setAttribute("class", "products");
		selectProduct.setAttribute("onchange", "getOptionInfo(this)");
		selectProduct.required = true;
		var productDefaultOption = document.createElement("option");
		productDefaultOption.value = "";
		productDefaultOption.disabled = true;
		productDefaultOption.selected = true;
		//productDefaultOption.setAttribute("style", "display: none;");
		productDefaultOption.innerText = "상품을 선택하세요";
		selectProduct.appendChild(productDefaultOption);
		for(productVo of data.productVoList) {
			var option = document.createElement("option");
			option.value = productVo.product_no;
			option.innerText = productVo.product_title;
			selectProduct.appendChild(option);
		}		
		col2.appendChild(selectProduct);
		
		var col3 = document.createElement("div");
		col3.setAttribute("class", "col");
		col3.innerText = "옵션 선택";
		var col4 = document.createElement("div");
		col4.setAttribute("class", "col");
		var selectOption = document.createElement("select");
		selectOption.setAttribute("class", "options");
		selectOption.setAttribute("onchange", "getStock(this)");
		selectOption.required = true;
		var optionDefaultOption = document.createElement("option");
		optionDefaultOption.value = "";
		optionDefaultOption.disabled = true;
		optionDefaultOption.selected = true;
		//optionDefaultOption.setAttribute("style", "display: none;");
		optionDefaultOption.innerText = "옵션을 선택하세요";
		selectOption.appendChild(optionDefaultOption);
		
		col4.appendChild(selectOption);				
		
		var col5 = document.createElement("div");
		col5.setAttribute("class", "col");
		col5.innerText = "수량 입력";
		var col6 = document.createElement("div");
		col6.setAttribute("class", "col");
		var inputRestockNum = document.createElement("input");
		inputRestockNum.setAttribute("class", "restockNums");
		inputRestockNum.setAttribute("type", "number");
		inputRestockNum.setAttribute("min", "1");
		inputRestockNum.setAttribute("max", "99999");
		inputRestockNum.setAttribute("value", "1");
		col6.appendChild(inputRestockNum);
		
		var col7 = document.createElement("div");
		col7.setAttribute("class", "col");
		col7.innerText = "현재 수량 : ";
		var col8 = document.createElement("div");
		col8.setAttribute("class", "col stockNums");
		
		var col9 = document.createElement("div");
		col9.setAttribute("class", "col oldStockNums");
		
		row.appendChild(col1);
		row.appendChild(col2);
		row.appendChild(col3);
		row.appendChild(col4);
		row.appendChild(col5);
		row.appendChild(col6);
		row.appendChild(col7);
		row.appendChild(col8);
		
		root.appendChild(row);
	}
	
	function getProductInfo() {
	    var xhr = new XMLHttpRequest();	
	    
	    xhr.onreadystatechange = function() {
	        if(xhr.readyState == 4 && xhr.status == 200) {
	            
	            var data = JSON.parse(xhr.responseText);

	            createContainer(data);
	        }
	    };
	    
	    xhr.open("GET", "./getProductInfo", true);
	    xhr.send();
		
	}
	
	function getOptionInfo(productSelectBox) {
		var productNo = productSelectBox.value;
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				
				var data = JSON.parse(xhr.responseText);
				
				var row = productSelectBox.closest(".row");
				
				var optSelectBox = row.querySelector(".options");				
				optSelectBox.innerHTML = "";
				
				var optionDefaultOption = document.createElement("option");
				optionDefaultOption.value = "";
				optionDefaultOption.disabled = true;
				optionDefaultOption.selected = true;				
				optionDefaultOption.innerText = "옵션을 선택하세요";
				optSelectBox.appendChild(optionDefaultOption);
								
				
				for(product_DetailVo of data.product_DetailVoList) {
					var option = document.createElement("option");
					option.value = product_DetailVo.product_detail_no;
					option.innerText = product_DetailVo.product_detail_option;					
					optSelectBox.appendChild(option);					
				}
			}
		};
		
		xhr.open("GET", "./getProductDetailInfo?product_no=" + productNo);
		xhr.send();
	}
		
	function getStock(optSelectBox) {
		
		var productDetailNo = optSelectBox.value;			
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);							
				
				optSelectBox.closest(".row").querySelector(".stockNums").innerText = data.stock + "개";
			}
		};
		
		xhr.open("GET", "./getStock?product_detail_no=" + productDetailNo);
		xhr.send();
		
	}
	
	function restock() {
				
		var option_list = []; 
			
		for(option of document.querySelectorAll(".options")) {
			option_list.push(option.value);
		}
		
		var stock_list = [];
		
		for(restockNum of document.querySelectorAll(".restockNums")) {
			stock_list.push(restockNum.value);
		}			
		
		var vo_list = [];
		
		for(var i=0;i<option_list.length;i++) {
			vo_list.push({
				product_detail_no : option_list[i],
				product_detail_stock : stock_list[i]
			});
		}
		
		var sendData = {
				voList : vo_list
		};
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {							
				
				var data = JSON.parse(xhr.responseText);
				
				alert("재입고가 완료되었습니다.");
				document.querySelector("#restockContainer").innerHTML = "";
				getProductInfo();
				
			}
		};
		
		xhr.open("POST", "./restockProcess");
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(JSON.stringify(sendData));
	}
	
	window.addEventListener("DOMContentLoaded", function() {
		getProductInfo();		
	});
	
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
		
		<div class="row"><div id="restockContainer" class="col"></div></div>
		
		
		<div class="row mt-5">
			<div class="col"></div>
			<div class="col-3 d-grid"><button class="btn btn-danger" onclick="getProductInfo()">행추가</button></div>
			<div class="col-3 d-grid"><button class="btn btn-outline-danger" onclick="restock()">재입고</button></div>			
		</div>				
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>