<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

<link href="../resources/css/commons.css" rel="stylesheet">
<link href="../resources/css/shopMain.css" rel="stylesheet">

<script>

	document.addEventListener('keydown', function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		  };
		}, true);	


	var old_count = 0;

	function optionOnChange(selectBox) {
		
		  if(selectBox.value == "invalidOption") return;
		
		  var idx = selectBox.selectedIndex;

		  var value = selectBox[idx].innerText;
		  
		  var selectedProductBox = document.getElementById("selectedProductBox");
		  
		  var optionList = selectedProductBox.getElementsByClassName("option");
		  
		  for(option of optionList) {
			  if(option.innerText == value) {
				  return;
			  }
		  }
		  
		  var row = document.createElement("div");
		  row.setAttribute("class", "row mb-3");
		  
		  var col1 = document.createElement("div");
		  col1.setAttribute("class", "col option");
		  col1.innerText = value;
		  
		  var col2 = document.createElement("div");
		  col2.setAttribute("class", "col");
		  
		  var hidden_no = selectBox.value.split("&stock")[0];
		  var hidden_stock = selectBox.value.split("&stock")[1];

		  var submitOptions = document.createElement("input");
		  submitOptions.setAttribute("type", "hidden");
		  submitOptions.setAttribute("name", "product_detail_no");
		  submitOptions.setAttribute("value", hidden_no);

		  var submitDiv = document.createElement("div");
		  submitDiv.setAttribute("style", "display: none;");
		  submitDiv.setAttribute("class", "stock");
		  submitDiv.innerText = hidden_stock;
		  
		  var inputNumber = document.createElement("input");
		  inputNumber.setAttribute("type", "number");
		  inputNumber.setAttribute("name", "productCount");
		  inputNumber.setAttribute("min", "1");
		  inputNumber.setAttribute("max", "999");
		  inputNumber.setAttribute("value", "1");
		  inputNumber.setAttribute("class", "count")
		  inputNumber.setAttribute("onchange", "countOnChange(this)");
		  
		  var delBtn = document.createElement("button");
		  delBtn.innerText = "X";
		  delBtn.setAttribute("class", "ms-2 delBtn");
		  delBtn.setAttribute("onclick", "deleteOption(this)");
		  
		  col2.appendChild(submitOptions);
		  col2.appendChild(submitDiv);
		  col2.appendChild(inputNumber);
		  col2.appendChild(delBtn);
		
		  old_count++;
		  
		  document.getElementById("totalPrice").innerText = "<c:out value='${productVo.product_price}'/>" * old_count;
		  document.getElementById("totalCount").innerText = "(" + old_count + "개)";		  
		  
		  
		  
		  row.appendChild(col1);
		  row.appendChild(col2);
		  selectedProductBox.appendChild(row);		  
	}
	
	function countOnChange(cnt) {
		var col = cnt.closest(".col");
		var stock = col.querySelector(".stock").innerText;
		
		if(parseInt(cnt.value) > parseInt(stock)) {
			alert("재고가 부족합니다. 현재  " + stock + "개");
			cnt.value = stock;
		}
		
		changeTotal();
	}
	
	function changeTotal() {
		var countList = document.getElementsByClassName("count");
		var totalCount = 0;
		for(count of countList) {
			totalCount += count.value*1;
		}
		old_count = totalCount;
		
		document.getElementById("totalPrice").innerText = "<c:out value='${productVo.product_price }'/>"  * totalCount;
		document.getElementById("totalCount").innerText = "(" + totalCount + "개)";		
	}
	
	function deleteOption(delBtn) {
		var target = delBtn.closest(".row");
		target.remove();
		changeTotal();
	}
	
	function buynow(btn) {
		var form = btn.closest("#frm");
		
		if(form.querySelector("input[name='product_detail_no']") == null) {
			alert("상품 옵션을 선택해주세요");
			return;
		}
		
		form.setAttribute("action", "../shop/orderPage");
		form.setAttribute("target", "_self");
		
		form.submit();
	}
	
	/*function addCart(btn) {

		var param = $("#frm").serialize();

		$.ajax({
			url: "addCartProcess",
			type: "POST",
			data: param,
			success:function(data) {
				$("#layerpop").modal("show");
			}
		})
	}*/
	
	function addCart(btn) {
		var form = btn.closest("#frm");
		
		if(form.querySelector("input[name='product_detail_no']") == null) {
			alert("상품 옵션을 선택해주세요");
			return;
		}
		
		form.setAttribute("action", "../shop/addCartProcess");
		form.setAttribute("target", "iframe1");
		
		form.submit();
		$("#layerpop").modal("show");
	}
	
	function closeModal() {
	    $("#layerpop").modal("hide");

	}
</script>

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
		  <div class="row mt-3"><div class="col" style="text-align: center;">${productVo.product_title }</div></div>
		  <div class="row mt-5">
		  	<div class="col"><img class="img-fluid" src="/upload/product/${productVo.product_image }"></div>
		  	<div class="col">
		  		<div class="row">
		  		  <div class="col">
		  		  	<div class="row mt-3">
		  		  	  <div class="col">모델명 : </div>
		  		  	  <div class="col">${productVo.product_model }</div>
		  		  	</div>
		  		  	<div class="row mt-3">
		  		  	  <div class="col">판매가 : </div>
		  		  	  <div class="col">${productVo.product_price }</div>
		  		  	</div>
		  		  	<div class="row mt-3">
		  		  	  <div class="col">배송방법 : </div>
		  		  	  <div class="col">택배</div>
		  		  	</div>
		  		  </div>
		  		</div>
		  		<hr>
		  		<form id="frm" method="post">
		  		  <div class="row">
		  		  	<div class="col">
		  		  	  <div class="row">
		  		  	  	<div class="col">옵션 : </div>
		  		  	  	<div class="col">
		  		  	  	  <select class="form-select" onchange="optionOnChange(this)">
		  		  	  	    <option value="invalidOption" selected>옵션선택</option>
		  		  	  	    <c:forEach items="${productDetailVoList }" var="productDetailVo">
		  		  	  	      <c:choose>		  		  	  	      
		  		  	  	        <c:when test="${productDetailVo.stock <= 0 }">
		  		  	  	          <option disabled>${productDetailVo.detailVo.product_detail_option } (품절)</option>
		  		  	  	        </c:when>
		  		  	  	      	<c:otherwise>
		  		  	  	      	  <option value="${productDetailVo.detailVo.product_detail_no }&stock${productDetailVo.stock }">${productDetailVo.detailVo.product_detail_option }</option>
		  		  	  	      	</c:otherwise>
		  		  	  	      </c:choose>		  		  	  	      
		  		  	  	    </c:forEach>		  		  	  	    
		  		  	  	  </select>
		  		  	  	</div>
		  		  	  </div>
		  		  	  <hr>
		  		  	  
		  		  	  <div class="row mb-5">
		  		  	    <div class="col" id="selectedProductBox"></div>
		  		  	  </div>
		  		  	  
		  		  	  <div class="row">
		  		  	  	<div class="col">총 상품금액(수량) : </div>
		  		  	  	<div id="totalPrice" class="col"></div>
		  		  	  	<div id="totalCount" class="col"></div>
		  		  	  </div>
		  		  	  <input type="hidden" name="product_no" value="${productVo.product_no }">
		  		  	  <div class="row mt-3">
		  		  	  	<div class="col d-grid"><button class="btn btn-dark" onclick="buynow(this)">buy now</button></div>
		  		  	  </div>
  		  		  	  <div class="row mt-3">
		  		  	  	<div class="col d-grid"><button class="btn btn-outline-dark" onclick="addCart(this)">add cart</button></div>
		  		  	  </div>
		  		  	  
		  		  	</div>
		  		  </div>
		  		</form>
		  				  		
		  	</div>
		  </div>
		  <hr class="mt-5">
	  	  <div class="row">
	  	    <div class="col">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
				  <li class="nav-item" role="presentation">
				    <button class="nav-link active" id="detail-tab" data-bs-toggle="tab" data-bs-target="#detail" type="button" role="tab" aria-controls="detail" aria-selected="true">detail</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="guide-tab" data-bs-toggle="tab" data-bs-target="#guide" type="button" role="tab" aria-controls="guide" aria-selected="false">guide</button>
				  </li>
				</ul>
				<div class="tab-content" id="myTabContent">
				  <div class="tab-pane fade show active" id="detail" role="tabpanel" aria-labelledby="detail-tab">
				  	<div class="row mt-5">
				  	  <div class="col text-center">
				  	    <p>${productVo.product_content }</p>
				  	  </div>
				  	</div>
				  	  <c:forEach items="${productImageVoList }" var="productImageVo">
				    	<div class="row mt-5">				      
					      	<div class="col text-center">
					        	<img class="img-fluid" src="/upload/product/${productImageVo.image_url }">
					        </div>			      
				    	</div>
				    </c:forEach>
				  </div>
				  <div class="tab-pane fade" id="guide" role="tabpanel" aria-labelledby="guide-tab">
				    <div class="row mt-5">
				      <div class="col text-center">
				        <p>
					                교환, 환불 안됩니다.<br>
					                샀으면 평생 신으세요.<br>
				        </p>
				      </div>     
				    </div>
				  </div>
				</div>	  		    
	  		</div>
	  	  </div>	
					
		</div>
 	</div>	

	<iframe id="iframe1" name="iframe1" style="display:none"></iframe>

	<div class="modal fade" id="layerpop" data-bs-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- header -->
					<div class="modal-header">
						<!-- header title -->
						<h4 class="modal-title">장바구니 담기</h4>
						<!-- 닫기(x) 버튼 -->
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<!-- body -->
					<div class="modal-body">
						선택하신 상품이 장바구니에 담겼습니다.
					</div>
					<!-- Footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-outline-dark" data-dismiss="modal" onclick = "location.href = '../shop/cartPage' ">장바구니 이동</button>
						<button id="closeBtn" type="button" class="btn btn-dark" data-dismiss="modal" aria-label="Close" onclick="closeModal()">쇼핑계속하기</button>
					</div>
				</div>
			</div>
		</div>	
 	
 	
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>