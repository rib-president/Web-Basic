<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="modal fade" id="detailProductModal">
			<div class="modal-dialog modal-dialog-centered modal-lg modal-dialog-scrollable">
				<div class="modal-content">
					<!-- header -->
					<div class="modal-header">
						<!-- header title -->
						<h4 class="modal-title"></h4>
						<!-- 닫기(x) 버튼 -->						
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<!-- body -->
					<div class="modal-body">
					  <div class="row mt-5">
					  	<div class="col"><img id="thumbnail" class="img-fluid"></div>
					  	<div class="col">
					  		<div class="row">
					  		  <div class="col">
					  		  	<div class="row mt-3">
					  		  	  <div class="col">모델명 : </div>
					  		  	  <div id="model" class="col"></div>
					  		  	</div>
					  		  	<div class="row mt-3">
					  		  	  <div class="col">판매가 : </div>
					  		  	  <div id="price" class="col"></div>
					  		  	</div>
					  		  	<div class="row mt-3">
					  		  	  <div class="col">배송방법 : </div>
					  		  	  <div class="col">택배</div>
					  		  	</div>
					  		  </div>
					  		</div>
					  		<hr>
					  		<%-- <form id="frm" method="post"> --%>
					  		  <div id="optionBox" class="row">
					  		  	<div class="col">
					  		  	  <div class="row">
					  		  	  	<div class="col">옵션 : </div>
					  		  	  	<div class="col">
					  		  	  	  <select id="select-option" class="form-select" onchange="optionOnChange(this)">
	  		  	  	    
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
					  		  	  <%-- <input type="hidden" name="product_no" value="${productVo.product_no }"> --%>
					  		  	  <%-- <div class="row mt-3">
					  		  	  	<div class="col d-grid"><button class="btn btn-dark" onclick="buynow(this)">buy now</button></div>
					  		  	  </div>
			  		  		  	  <div class="row mt-3">
					  		  	  	<div class="col d-grid"><button class="btn btn-outline-dark" onclick="addCart(this, event)">add cart</button></div>
					  		  	  </div> --%>
					  		  	  
					  		  	</div>
					  		  </div>
					  		<%-- </form> --%>
					  				  		
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
							  	    <p id="product_content"></p>
							  	  </div>
							  	</div>
							  	<div class="row">
							  		<div id="detailImageBox" class="col"></div>
							  	</div>

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
					<!-- Footer -->
					
						<div class="row">
							<div class="col">
								<canvas id="myChart"></canvas>							
							</div>
						</div>
					
					
					<div class="modal-footer">
						<form id="buyNowFrm" method="post" action="../shop/orderPage">						
							<button type="button" class="btn btn-outline-dark" data-dismiss="modal" onclick="buynow(this)">buy now</button>
						</form>						
						<button type="button" class="btn btn-dark" data-dismiss="modal" onclick="addCart(this)">add cart</button>
					</div>
				</div>
			</div>
		</div>	
		
		
		<div class="modal fade" id="layerpop" data-bs-backdrop="static">
			<div class="modal-dialog modal-dialog-centered">
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