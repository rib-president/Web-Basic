<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
		<div id="menu-bar" class="col-2" style="margin-top:3%; height:100%;">
			<div class="row mt-5">
				<div class="col">
					<a id="logo" href="../shop/main">ShinNanDa</a>
				</div>
			</div>
			<div class="row mt-5">
				<div class="col">
					<div class="row center-text">
						<div class="col">
							<div class="row ms-2">
							  <c:choose>
							    <c:when test="${!empty sessionUser }">
							    	<div class="col zero-padding" onclick="logout()" style="cursor:pointer;">logout</div>
							    </c:when>
							    <c:otherwise>
									<div class="col-3 zero-padding"><a href="../member/loginPage">login</a></div>
									<div class="col-1 zero-padding">&nbsp;|&nbsp;</div>
									<div class="col-3 zero-padding"><a href="../member/joinMemberPage">join</a></div>
									<div class="col"></div>							 							    
							    </c:otherwise>
							  </c:choose>
							</div>
							<div class="row ms-2">
								<div class="col-3 zero-padding"><a href="../shop/guidePage">guide</a></div>
								<div class="col-1 zero-padding">&nbsp;|&nbsp;</div>
								<div class="col-3 zero-padding"><a href="../shop/ordersInfoPage">order</a></div>
								<div class="col-1 zero-padding">&nbsp;|&nbsp;</div>
								<div class="col zero-padding"><a href="../shop/myPage">my page</a></div>

							</div>
						</div>
					</div>
					<div class="row mt-5">
						<div class="col-1"><a href="../shop/cartPage"><i class="bi bi-cart"></i></a></div>
						<div class="col-1"><a href="#"><i class="bi bi-search"></i></a></div>
						<div class="col-10"></div>
					</div>
					<div class="row mt-5">
						<div class="col"><a href="../shop/aboutUsPage">about us</a></div>
					</div>
					<div class="row mt-5">
						<div class="col">
							<div class="row">
								<div class="col"><a href="#">recommend item</a></div>
							</div>
							<div class="row">
								<div class="col"><a href="../shop/categoryViewPage?product_category_no=1">sneakers</a></div>
							</div>
							<div class="row">
								<div class="col"><a href="../shop/categoryViewPage?product_category_no=2">dress-shoes</a></div>
							</div>
							<div class="row">
								<div class="col"><a href="../shop/categoryViewPage?product_category_no=3">sandal</a></div>
							</div>
							<div class="row">
								<div class="col"><a href="../shop/categoryViewPage?product_category_no=4">flip-flops</a></div>
							</div>
						</div>
					</div>
					<div class="row mt-4">
						<div class="col"><a href="https://www.cjlogistics.com/ko/tool/parcel/tracking" target="blank">delivery</a></div>
					</div>
				
				</div>
			</div>
			<div class="row mt-4">
				<div class="col">
					070-0000-0000<br>
					010-0000-0000<br>
					mon-fri 10:00 - 18:00<br>
					sat/sun/holiday off<br>
					국민 000000-00-00000 예금주			
				</div>
			</div>
			<div class="row mt-2 mb-5">
				<div class="col-1"><i class="bi bi-instagram"></i></div>
				<div class="col-1"><i class="bi bi-facebook"></i></div>
				<div class="col-1"><i class="bi bi-chat-dots-fill"></i></div>
				<div class="col-9"></div>
			</div>
		</div>  		