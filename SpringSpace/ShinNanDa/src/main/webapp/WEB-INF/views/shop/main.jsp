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
	var myChart = null;
	
	var totalPageNum = 0;
	var pageNum = 1;
	
	window.addEventListener("DOMContentLoaded" , function(){
		totalPageNum = '${totalPageNum }';
		load16Product();
		
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
				
				
				//// sales graph
				const labels = [];
				const statisticData = {
				    labels: labels,
				    datasets: [{
				      label: '연령대별 판매량',
				      backgroundColor: 'rgb(255, 99, 132)',
				      borderColor: 'rgb(255, 99, 132)',
				      data: [],
				    }]
				};
				
				for(ageCnt of data.AgeCntList) {
					labels.push(ageCnt.AGE);
					statisticData.datasets[0].data.push(ageCnt.CNT);
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
				  
				  
				if(myChart instanceof Chart)
                {
					myChart.destroy();
                }
				
				myChart = new Chart(
				    document.getElementById('myChart'),
				    config
				);
				  
				////
				
				
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
	
	function load16Product() {
		if (pageNum > totalPageNum) {
			return;
		} 
		
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {

				var vo_list = JSON.parse(xhr.responseText).voList;
				
				var cnt = 0;
				var row = null;
				
				for(vo of vo_list) {
					if(cnt == 0 || cnt % 4 == 0) {
						row = document.createElement("div");
						row.setAttribute("class", "row mb-5 ms-3");
						document.querySelector(".shop-start-col").appendChild(row);
					}
					
					createProductBox(vo, row);
					cnt++;
				}
				
				if(vo_list.length % 4 > 0) {
					for(var i=0;i< 4-vo_list.length % 4;i++) {
						var col = document.createElement("div");
						col.setAttribute("class", "col product_image me-3");
						row.appendChild(col);
					}
				}
				
				pageNum++;
			}			
		}
		
		xhr.open("get", "./load16Product?pageNum=" + pageNum, true);
		xhr.send();
	}

	
	function createProductBox(vo, root) {

	  var imageBox = document.createElement("div");
	  imageBox.setAttribute("class", "col product_image me-3");
	  imageBox.setAttribute("onclick", "openDetailProductModal(" + vo.product_no + ")");
	  imageBox.setAttribute("style", "cursor:pointer;");
	  
	  var img = document.createElement("img");
	  img.setAttribute("src", "/upload/product/" + vo.product_image);
	  var row = document.createElement("div");
	  row.setAttribute("class", "row");
	  var col = document.createElement("div");
	  col.setAttribute("class", "col product_info");
	  var p = document.createElement("p");
	  p.innerText = "상품명 : " + vo.product_title + "\n모델명 : " + vo.product_model + "\n가격 : " + vo.product_price;
	  col.appendChild(p);
	  row.appendChild(col);
	  
	  imageBox.appendChild(img);
	  imageBox.appendChild(row);
	  root.appendChild(imageBox);
	}
	
	window.addEventListener('scroll', function(){ 
		const SCROLLED_HEIGHT = window.scrollY;
		const WINDOW_HEIGHT = window.innerHeight;
		const DOC_TOTAL_HEIGHT = document.body.offsetHeight;
		const IS_BOTTOM = WINDOW_HEIGHT + SCROLLED_HEIGHT === DOC_TOTAL_HEIGHT;
		 
		if (IS_BOTTOM) {
		  load16Product();
		}
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
		  								
		</div>
 	</div>
 	
	<jsp:include page="./detailProductModal.jsp"></jsp:include>
 	
 	<div style="position:fixed; bottom:35px; right:40px; z-index:99; width:100px; height:100px;"> 
		<img src="../resources/img/gotop.png" onclick="location.href = '#'" style="cursor:pointer; width:100%;">
	</div>
</div>
</div>
<script src="../resources/js/detailProductJS.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>