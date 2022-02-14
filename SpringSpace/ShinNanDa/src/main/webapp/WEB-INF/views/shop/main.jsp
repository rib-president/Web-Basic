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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link href="../resources/css/commons.css" rel="stylesheet">
<link href="../resources/css/shopMain.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
.modal {
   z-index: 99999;
}

</style>

<script>
	var detailProductModal = null;
	
	
	window.addEventListener("DOMContentLoaded" , function(){
		var modalRoot = document.getElementById('detailProductModal');
		detailProductModal = new bootstrap.Modal(modalRoot);
	});
	
	
	var product_price = 0;
	
	function openDetailProductModal(product_no) {		
		
		var xhr = new XMLHttpRequest();
		var modalRoot = document.getElementById('detailProductModal');

		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				
				var tttt = [
					{age : 0 , cnt : 5},
					{age : 10 , cnt : 33},
					{age : 20 , cnt : 22},
					{age : 30 , cnt : 11},
					{age : 40 , cnt : 17},
				]; 		
				
				
				////....
				  const labels = [];
				  const statisticData = {
						    labels: labels,
						    datasets: [{
						      label: 'My First dataset',
						      backgroundColor: 'rgb(255, 99, 132)',
						      borderColor: 'rgb(255, 99, 132)',
						      data: [],
						    }]
						  };
				
				
				for(x of tttt){
					labels.push(x.age);
					statisticData.datasets[0].data.push(x.cnt);
				}
				
				
				
				
				  
				  const config = {
						  type: 'bar',
						  data: statisticData,
						  options: {
						    scales: {
						      y: {
						        beginAtZero: true
						      }
						    }
						  },
						};				  
				  
				
				  const myChart = new Chart(
						    document.getElementById('myChart'),
						    config
						  );
				  myChart.destroy()
				////.....
				
				
				
				
				
				modalRoot.addEventListener('hidden.bs.modal', closeDetailProductModal());
				
				modalRoot.querySelector(".modal-title").innerText = data.productVo.product_title;
				modalRoot.querySelector("#thumbnail").setAttribute("src", "/upload/product/" + data.productVo.product_image);
				modalRoot.querySelector("#model").innerText = data.productVo.product_model;
				modalRoot.querySelector("#price").innerText = data.productVo.product_price;
				
				var selectOption = modalRoot.querySelector("#select-option");
				
				while (selectOption.hasChildNodes()) {	
					selectOption.removeChild(selectOption.firstChild);
				}
				
				var option = document.createElement("option");
				option.setAttribute("value", "invalidOption");
				option.selected = true;
				option.innerText = "옵션선택";
				selectOption.appendChild(option);
  	  	   		 
  	  	   		 for(productDetailVo of data.productDetailVoList) {
  	  	   			 if(productDetailVo.stock <= 0) {
  	  	   				 var option = document.createElement("option");
  	  	   				 option.disabled = true;
  	  	   				 option.innerText = productDetailVo.detailVo.product_detail_option + " (품절)";
  	  	   			 } else {
  	  	   				 var option = document.createElement("option");
  	  	   				 option.setAttribute("value", productDetailVo.detailVo.product_detail_no + "&stock" + productDetailVo.stock);
  	  	   				 option.innerText = productDetailVo.detailVo.product_detail_option;
  	  	   			 }
  	  	   			 selectOption.appendChild(option);
  	  	   		 }
								
				product_price = data.productVo.product_price;
				
				modalRoot.querySelector("#product_content").innerText = data.productVo.product_content;
				
				var detailImageBox = modalRoot.querySelector("#detailImageBox");
				
				for(productImageVo of data.productImageVoList) {

					var row = document.createElement("div");
					row.setAttribute("class", "row mt-5");
					
					var col = document.createElement("div");
					col.setAttribute("class", "col text-center");
					
					var img = document.createElement("img");
					img.setAttribute("class", "img-fluid");
					img.setAttribute("src", "/upload/product/" + productImageVo.image_url);
					
					col.appendChild(img);
					row.appendChild(col);
					detailImageBox.appendChild(row);
				}
  	  	   		 
				detailProductModal.show();				
			}			
		};
		
		
		xhr.open("get" , "./detailProductPage?product_no=" + product_no, true);   		
		xhr.send();
	}
	
	function closeDetailProductModal() {
		var selectedProductBox = document.querySelector("#selectedProductBox");
		
		while (selectedProductBox.hasChildNodes()) {	
			selectedProductBox.removeChild(selectedProductBox.firstChild);
		}	
		
		document.querySelector("#totalPrice").innerText = "";
		document.querySelector("#totalCount").innerText = "";
		old_count = 0;
		
		detailProductModal.hide();
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

	
 	<div class="row">
		
		<jsp:include page="../commons/menu_bar.jsp"></jsp:include>
		
		<div class="col shop-start-col">
		  <c:set var="endNum" value="${fn:length(voList)/4-1}" />
		  <c:set var="res" value="${fn:length(voList)% 4 }" />
		  <c:set var="lastJ" value="0" />
		  
		  <c:if test="${fn:length(voList)>=4 }">
			  <c:forEach begin="0" end="${endNum }" var="i">
			    <div class="row mb-5 ms-3">
			      <c:forEach begin="${i*4 }" end="${i*4+3 }" var="j">
			  	  	<div class="col product_image me-3" onclick="openDetailProductModal('${voList.get(j).product_no }')" style="cursor:pointer;">
			  	  	  <img src="/upload/product/${voList.get(j).product_image }">
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
		    <div class="row mb-5 ms-3">
		  	  <c:forEach begin="${lastJ }" end="${lastJ + 3 }" var="j">
		  	    <c:choose>
		  	      <c:when test="${fn:length(voList) <= j }">
		  	        <div class="col"></div>
		  	      </c:when>
		  	      <c:otherwise>
			  	  	<div class="col product_image me-3" onclick="openDetailProductModal('${voList.get(j).product_no }')" style="cursor:pointer;">
			  	  	  <img src="/upload/product/${voList.get(j).product_image }">
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
		  	      </c:otherwise>
		  	    </c:choose>		    
		  	  </c:forEach>
		  	</div>
		  </c:if>
			  
		  								
		</div>
 	</div>
 	
	<jsp:include page="./detailProductModal.jsp"></jsp:include>
 	
 	
 	
</div>
</div>
<script src="../resources/js/detailProductJS.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>