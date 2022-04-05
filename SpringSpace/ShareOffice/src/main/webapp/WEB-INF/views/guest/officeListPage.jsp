<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">
<style>
i {text-decoration: none; color:#A68A64;}
</style>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row" style="padding-top: 2em;width: auto; margin: 0.5em;">
	<div class="col">
			<%-- 내용작성 --%>
			<c:forEach items="${officelist}" var="office">
				<div class="card mb-3">
				<a href="./officeDetailPage?office_no=${office.officeVo.office_no }">
					<img src="/soUpload/officeImage/${office.officeVo.office_thumbnail }" width=100%, height=250em class="card-img-top" alt="..."> 
					
					</a>
					<div class="card-body">
						<div class="row text-fs-23 font-medium2">
							<p class="card-title ">${office.officeVo.office_name }</p>
						</div>
						
						<div class="row text-fs-16">					
								<p class="card-text">
									<small > 
									   <i class="bi bi-geo-alt"></i>${office.officeVo.office_address }
									</small>
								</p>
						</div>
						<div class="row text-fs-13">
						    <p class="card-text">
									<small class="text-muted"> 
						                 #${office.officeVo.office_tags }
						            </small>
						    </p>             
						</div>
						<div class="row ms-1" >	
						      
						    <c:forEach items="${office.facilityCategoryList }" var="facilityVo" end="4">						   					        					          
							       <c:if test="${facilityVo.facility_no eq '1'  }">	
							         <div class="col" style="padding:0rem"><img src="../resources/img/wifi (1).png" width=20em, height=20em></div>						         			   	
							       </c:if>			     										             
							        <c:if test="${facilityVo.facility_no eq '2'  }">								      
							           <div class="col" style="padding:0rem"> <img src="../resources/img/desktop.png" width=20em, height=20em></div>  		   								   													   	       
							        </c:if>					     							     
							         <c:if test="${facilityVo.facility_no eq '3'  }">							         
							           <div class="col"style="padding:0rem"> <img src="../resources/img/fax.png" width=20em, height=20em></div>		   								   	                                      				   	       
							        </c:if>		      
							         <c:if test="${facilityVo.facility_no eq '4'  }">								          								          
							           <div class="col"style="padding:0rem"> <img src="../resources/img/printer.png" width=20em, height=20em></div>		   								   	                                 				   	       
							        </c:if> 
							         <c:if test="${facilityVo.facility_no eq '5'  }">							          								         
							           <div class="col"style="padding:0rem"> <img src="../resources/img/whiteBoard.png" width=20em, height=20em></div>		   								   	                                   				   	       
							        </c:if>					      							     
							         <c:if test="${facilityVo.facility_no eq '6'  }">	
							           <div class="col"style="padding:0rem"> <img src="../resources/img/projector (1).png" width=25em, height=25em></div>		   								   	                                      				   	       
							        </c:if>							      						 
							         <c:if test="${facilityVo.facility_no eq '7'  }">	
							           <div class="col"style="padding:0rem"> <img src="../resources/img/air-purifier.png" width=25em, height=25em></div>		   								   	    				   	       
							        </c:if>		      
							         <c:if test="${facilityVo.facility_no eq '8'  }">	
							           <div class="col"style="padding:0rem"> <img src="../resources/img/lockers.png" width=25em, height=25em></div>		   								   	                                   				   	       
							        </c:if>					       
							         <c:if test="${facilityVo.facility_no eq '9'  }">	
							           <div class="col"style="padding:0rem"> <img src="../resources/img/kitchen.png" width=25em, height=25em></div>		   								   	                                 				   	       
							        </c:if>	     
							         <c:if test="${facilityVo.facility_no eq '10'  }">	
                                       <div class="col"> <img src="../resources/img/parking.png" width=25em, height=25em></div>		 			   	       
							        </c:if>				             
						    </c:forEach>	
						        <div class="col"></div>					       						    					   
						        <div class="col-6 text-fs-16">
						            <p class="card-text" style="text-align: right;"> <fmt:formatNumber value="${office.officeMinPrice}" pattern="#,###"/>~ <small class="text-muted text-fs-13"> 원/일</small></p>
						       </div>
						    					
						</div>

					</div>
				</div>

			</c:forEach>
		</div>
</div>

<jsp:include page="../commons/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>