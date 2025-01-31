<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">
<link href="../resources/css/shopMain.css" rel="stylesheet">

<script>

	function refreshCart() {
		var totalPrice = 0;
	  	var xhr = new XMLHttpRequest();
	  	
	  	xhr.onreadystatechange = function(){
	  		if(xhr.readyState == 4 && xhr.status == 200) {
	  			var data = JSON.parse(xhr.responseText);
				
	  			var tbody = document.querySelector("tbody");
	  			tbody.innerHTML = "";
				for(totalVo of data.totalVoList) {
					var tr = document.createElement("tr");
					
					var th = document.createElement("th");
					th.setAttribute("scope", "row");					
					var ckBox = document.createElement("input");
					ckBox.setAttribute("type", "checkbox");
					ckBox.setAttribute("name", "chkedCartNo");
					ckBox.setAttribute("value", totalVo.cartVo.cart_no);
					th.appendChild(ckBox);
					
					var td1 = document.createElement("td");
					var img = document.createElement("img");
					img.setAttribute("class", "img-fluid");
					img.setAttribute("src", "/upload/product/" + totalVo.productVo.product_image);
					img.setAttribute("style", "width: 300px;");
					td1.appendChild(img);
					
					var td2 = document.createElement("td");
					var td2_row1 = document.createElement("div");
					td2_row1.setAttribute("class", "row");
					var td2_row1_col = document.createElement("div");
					td2_row1_col.setAttribute("class", "col");
					var h3 = document.createElement("h3");
					h3.innerText = totalVo.productVo.product_title;
					td2_row1_col.appendChild(h3);
					td2_row1.appendChild(td2_row1_col);
					var td2_row2 = document.createElement("div");
					td2_row2.setAttribute("class", "row");
					var td2_row2_col = document.createElement("div");
					td2_row2_col.setAttribute("class", "col");
					td2_row2_col.innerText = totalVo.product_DetailVo.product_detail_option;
					var td2_row2_div = document.createElement("div");
					td2_row2_div.setAttribute("class", "detail_no");
					td2_row2_div.setAttribute("style", "display:none;");
					td2_row2_div.innerText = totalVo.product_DetailVo.product_detail_no;
					td2_row2.appendChild(td2_row2_col);
					td2_row2.appendChild(td2_row2_div);
					td2.appendChild(td2_row1);
					td2.appendChild(td2_row2);
					
					var td3 = document.createElement("td");
					td3.setAttribute("class", "price");
					td3.innerText = totalVo.productVo.product_price;
					
					var td4 = document.createElement("td");
					var td4_row = document.createElement("div");
					td4_row.setAttribute("class", "row");
					var td4_row_col1 = document.createElement("div");
					td4_row_col1.setAttribute("class", "col");
					var input_count = document.createElement("input");
					input_count.setAttribute("class", "count");
					input_count.setAttribute("type", "number");
					input_count.setAttribute("name", "cart_count");
					input_count.setAttribute("min", "1");
					input_count.setAttribute("max", "999");
					input_count.setAttribute("value", totalVo.cartVo.cart_count);
					var div_oldCount = document.createElement("div");
					div_oldCount.setAttribute("class", "oldCount");
					div_oldCount.setAttribute("style", "display:none;");
					div_oldCount.innerText = totalVo.cartVo.cart_count;
					var div_no = document.createElement("div");
					div_no.setAttribute("class", "no");
					div_no.setAttribute("style", "display:none;");
					div_no.innerText = totalVo.cartVo.cart_no;
					var div_stock = document.createElement("div");
					div_stock.setAttribute("class", "stock");
					div_stock.setAttribute("style", "display:none;");
					div_stock.innerText = totalVo.stock;
					td4_row_col1.appendChild(input_count);
					td4_row_col1.appendChild(div_oldCount);
					td4_row_col1.appendChild(div_no);
					td4_row_col1.appendChild(div_stock);
					var td4_row_col2 = document.createElement("div");
					td4_row_col2.setAttribute("class", "col mt-3");
					var btn_changeCount = document.createElement("button");
					btn_changeCount.setAttribute("class", "btn btn-outline-dark");
					btn_changeCount.setAttribute("onclick", "changeCount(this, event)");
					btn_changeCount.innerText = "변경";
					td4_row_col2.appendChild(btn_changeCount);
					td4_row.appendChild(td4_row_col1);
					td4_row.appendChild(td4_row_col2);
					td4.appendChild(td4_row);
					
					var td5 = document.createElement("td");
					td5.innerText = "무료";
					
					var td6 = document.createElement("td");
					td6.setAttribute("class", "calcPrice");
					td6.innerText = totalVo.productVo.product_price * totalVo.cartVo.cart_count;
					
					tr.appendChild(th);
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					tr.appendChild(td5);
					tr.appendChild(td6);
					tbody.appendChild(tr);
					
					totalPrice = totalVo.productVo.product_price * totalVo.cartVo.cart_count + totalPrice;
				}
				document.querySelector("#total").innerText = totalPrice;
	  		}
	  		
	  	};	  
	  
	  	xhr.open("get", "./getCartInfoProcess", true);
		xhr.send();		
		
	}

	function selectAll(allChk) {
	  const checkboxes = document.getElementsByName("chkedCartNo");
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = allChk.checked;
	  })		
	}

	
	function changeCount(btn, event) {
		event.preventDefault();
		
		var row = btn.closest(".row");
		
		var cart_no = row.querySelector(".no").innerText;
		var countInput = row.querySelector(".count");
		var oldCountInput = row.querySelector(".oldCount");
		var oldCount = oldCountInput.innerText;
		
		var stock = row.querySelector(".stock").innerText;
		
		if(parseInt(countInput.value) > parseInt(stock)) {
			alert("재고가 부족합니다 : " + oldCount + " 개");
			countInput.value = oldCount;
			return;
		}	

		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				refreshCart();
			}
			
		};
		
		
		xhr.open("POST" , "./changeCartCount", true);
    	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded"); //Post
		xhr.send("cart_no=" + cart_no + "&cart_count=" + countInput.value);
	}

	
	function delAllProd(event) {
		//AJAX...호출...
		var xhr = new XMLHttpRequest();
		
		//응답 받을때...
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				if(data.result == 'success') {

					refreshCart();
				}	
			}			
		};
		
		
		xhr.open("GET" , "./delCartProcess", true);
		xhr.send();

	}
	
	function delCheckedProduct(btn, event) {
		event.preventDefault();
		
		var checkList = document.getElementsByName("chkedCartNo");

		var param = "";
		for(check of checkList) {
			if(check.checked) {
				param += "checked_cart_no_list=" + check.value + "&";
			}
		}

		if(param == "") {
			alert("상품을 선택해주세요");
			return;
		}
		param = param.substring(0, param.length-1);

		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				if(data.result == 'success') {
					
					refreshCart();
				}				
			}
			
		};
		
		xhr.open("post" , "./delCheckedCartProcess", true);
    	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded"); //Post
		xhr.send(param);
    	
	}
	
	function orderCheckedProduct(btn) {
		var frm = btn.closest("form");
		
		var checkList = document.getElementsByName("chkedCartNo");
		
		var checkCount = 0;
		for(check of checkList) {
			if(check.checked) {
				checkCount++;
		
				var tr = check.closest("tr");
				
				var count = document.createElement("input");
				count.setAttribute("type", "hidden");
				count.setAttribute("name", "productCount");
				count.setAttribute("value", tr.getElementsByClassName("count")[0].value);
				
				var no = document.createElement("input");
				no.setAttribute("type", "hidden");
				no.setAttribute("name", "product_detail_no");
				no.setAttribute("value", tr.getElementsByClassName("detail_no")[0].innerText);
				
				frm.appendChild(count);
				frm.appendChild(no);
			}
		}
		
		if(checkCount == 0) {
			alert("상품을 선택해주세요");
			frm.setAttribute("action","");
			return;
		}
		
		frm.submit();
	}
	
	function orderAllProd(btn) {
		var frm = btn.closest("form");
		
		var isCartAll = document.createElement("input");
		isCartAll.setAttribute("type", "hidden");
		isCartAll.setAttribute("name", "isCartAll");
		isCartAll.setAttribute("value", true);

		frm.appendChild(isCartAll);
		frm.submit();
		
	}
	
	window.addEventListener("DOMContentLoaded" , function(){
		refreshCart();
	});
	
</script>
</head>
<body>
<div style="margin: 0 auto;">
 <div class="container-fluid">
	<div class="row">
		<div id="nav-bar" class="col"><!-- 글로벌 nav -->
			<jsp:include page="../commons/global_nav.jsp"></jsp:include>
		</div>
	</div>

	
	
 	<div class="row">
		<jsp:include page="../commons/menu_bar.jsp"></jsp:include>
		<div class="col shop-start-col">	  
			<div class="row">
				<div class="col"><h1>cart</h1><hr></div>
			</div>
			<div class="row">
				<div class="col">
					<h1>01 cart > 02 order > 03 pay > 04 delivery</h1>
				</div>
			</div>
			<div class="row mt-3">

				<div class="col">
					<table class="table table-striped">
					  <thead>
					    <tr>
					      <th scope="col">
					      	<input type="checkbox" onclick="selectAll(this)"/>
					      </th>
					      <th scope="col">이미지</th>
					      <th scope="col">상품 정보</th>
					      <th scope="col">판매가</th>
					      <th scope="col">수량</th>
					      <th scope="col">배송비</th>
					      <th scope="col">합계</th>
					    </tr>
					  </thead>
					  <tbody>

					  </tbody>
					  <tfoot>
					    <tr>
					      <td></td>
					      <td>
					        <div class="row">
					          <div class="col-5">상품 구매 금액 합계(배송비 무료) :</div>
					          <div id="total" class="col-3"></div>
					          <div class="col-1">원</div>
					          <div class="col"></div>
					        </div>
					      </td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td></td>
					    </tr>
					    <tr>
					      <td></td>
					      <td>
					      	<div class="row mt-3">

				      		<div class="col-5 mb-2"><button class="btn btn-primary" onclick="delCheckedProduct(this, event)">선택 상품 삭제</button></div>
				      		<div class="col"><button class="btn btn-outline-primary" onclick="delAllProd(event)">장바구니 비우기</button></div>

					      	</div>
					      </td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td></td>					      
					    </tr>
					  </tfoot>					  
					</table>
					
					<form id="orderFrm" action="orderPage" method="post">
					<div class="row mt-5 mb-5">
						<div class="col d-grid">
							<button class="btn btn-warning" onclick="orderAllProd(this)">전체 상품 주문</button>
						</div>
						<div class="col d-grid">
							<button class="btn btn-outline-warning" onclick="orderCheckedProduct(this)">선택 상품 주문</button>
						</div>
					</div>
					</form>
								
				</div>

			</div>
	 		<%-- <iframe id="iframe1" name="iframe1" style="display:none"></iframe> --%>			
		  								
		</div>
 	</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>