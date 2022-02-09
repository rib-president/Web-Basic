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
	function selectAll(allChk) {
	  const checkboxes = document.getElementsByName("chkedCartNo");
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = allChk.checked;
	  })		
	}

	
	function changeCount(btn, event) {
		event.preventDefault();
		
		var row = btn.closest(".row");
		
		var cart_no = row.querySelector(".no").value;
		var countInput = row.querySelector(".count");
		var oldCountInput = row.querySelector(".oldCount");
		var oldCount = oldCountInput.innerText;
		
		var stock = row.querySelector(".stock").innerText;
		
		if(parseInt(countInput.value) > parseInt(stock)) {
			alert("재고가 부족합니다 : " + oldCount + " 개");
			countInput.value = oldCount;
			return;
		}
		
		
		var priceTd = row.closest("tr").getElementsByClassName("price")[0];		
		var price = priceTd.innerText;
		
		var calcPrice = row.closest("tr").getElementsByClassName("calcPrice")[0];

		var oldPrice = calcPrice.innerText;
		var curPrice = countInput.value * price;
		calcPrice.innerText = curPrice;
		oldCountInput.innerText = countInput.value;
		
		if(oldPrice > curPrice) {
			document.querySelector("#total").innerText = (document.querySelector("#total").innerText*1) - (oldPrice-curPrice);

		} else if(oldPrice < curPrice) {
			document.querySelector("#total").innerText = (document.querySelector("#total").innerText*1) + (curPrice-oldPrice);
		}
		

		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
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
					var trs = document.querySelectorAll("table tbody tr");
					for(tr of trs) {
						tr.remove();
					}
					
					document.querySelector("#total").innerText = 0;
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
					var checkList = document.getElementsByName("chkedCartNo");
					var tr_list = [];
					for(check of checkList) {
						if(check.checked) {
							var tr = check.closest("tr");
							
							var calcPrice = tr.querySelector(".calcPrice");
							
							document.querySelector("#total").innerText = parseInt(document.querySelector("#total").innerText) - parseInt(calcPrice.innerText);
							
							tr_list.push(tr);														
						}						
					}
					for(tr of tr_list) {
						tr.remove();
					}
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

	
	<c:set var="totalPrice" value="0" />
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
					  <c:forEach items="${totalVoList }" var="totalVo">

					    <tr>
					      <th scope="row">
					      	<input type="checkbox" name="chkedCartNo" value="${totalVo.cartVo.cart_no }">
					      </th>
					      <td><img class="img-fluid" src="/upload/product/${totalVo.productVo.product_image }" style="width: 300px;"></td>
					      <td>
					      	<div class="row">
					      		<div class="col"><h3>${totalVo.productVo.product_title }</h3></div>
					      	</div>
					      	<div class="row">
					      		<div class="col">${totalVo.product_DetailVo.product_detail_option }</div>
					      		<div class="detail_no" style="display:none;">${totalVo.product_DetailVo.product_detail_no }</div>
					      	</div>
					      </td>
					      <td class="price">${totalVo.productVo.product_price }</td>
					      <td>

					      	<div class="row">
					      		<div class="col">						      			
					      			<input class="count" type="number" name="cart_count" min="1" max="999" value="${totalVo.cartVo.cart_count }">
					      			<div class="oldCount" style="display: none;">${totalVo.cartVo.cart_count }</div>
					      			<input class="no" type="hidden" name="cart_no" value="${totalVo.cartVo.cart_no }">
					      			<div class="stock" style="display: none;">${totalVo.stock }</div>
					      		</div>
					      		<div class="col mt-3">
					      			<button class="btn btn-outline-dark" onclick="changeCount(this, event)">변경</button>
					      		</div>
					      	</div>

					      </td>
					      <td>무료</td>
					      <td class="calcPrice">${totalVo.productVo.product_price * totalVo.cartVo.cart_count }</td>
					    </tr>

					    
					    <c:set var="totalPrice" value="${totalVo.productVo.product_price * totalVo.cartVo.cart_count + totalPrice }" />
					  </c:forEach>
					  </tbody>
					  <tfoot>
					    <tr>
					      <td></td>
					      <td>
					        <div class="row">
					          <div class="col-5">상품 구매 금액 합계(배송비 무료) :</div>
					          <div id="total" class="col-3">${totalPrice }</div>
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