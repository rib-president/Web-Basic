<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/echarts@5.3.1/dist/echarts.min.js" integrity="sha256-up/VQ00XWfwfCN9hDtxDmZk9PgDVs83dQvTPRnWK0p4=" crossorigin="anonymous"></script>
<link href="../resources/css/commons.css" rel="stylesheet">

<style>
.bg-dashboard {background-color: #fafafaa0}

.txt{
    width: 4rem;
    height: 2.594rem;
    line-height: 50px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;      
}


</style>

<script>

	function loadChartData() {
		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				drawChart1(data.totalProportion);
				drawChart2(data.officeProportion);
			}			
		};		
		
		xhr.open("GET" , "./loadChartData", true);
		xhr.send();

	}

	function drawChart1(data) {
		
		var root = document.querySelector("#chart1Box");
		var chart1Main = document.createElement("div");
		chart1Main.setAttribute("style", "width: 20rem;height:22rem; font-size:.813rem");
		
		root.appendChild(chart1Main);
		
		var chart1 = echarts.init(chart1Main);
		
		
		var dataList = [];
		for(var officeProportion of data.officeProportionList) {
			var map = {};
			map["value"] = officeProportion.cnt;
			map["name"] = officeProportion.office_name;
			dataList.push(map);
		}
		
		option = {
				  tooltip: {
					    trigger: 'item'
				 },
				  legend: {
					    top: '5%',
					    left: 'center'
				  },
				  series: [
				    {
				      name: 'RentalProportion',
				      type: 'pie',
				      top: '8%',
				      radius: ['40%', '70%'],
				      data: dataList,
				      emphasis: {
				          itemStyle: {
				            shadowBlur: 10,
				            shadowOffsetX: 0,
				            shadowColor: 'rgba(0, 0, 0, 0.5)'
				          }
				      }
				    }
				  ]
				};
		
		chart1.setOption(option);
	}
	
	function drawChart2(data) {
		
		var root = document.querySelector("#chart2Box");
		var chart2Main = document.createElement("div");
		chart2Main.setAttribute("style", "width: 20rem;height:22rem; font-size:.813rem");
		
		root.appendChild(chart2Main);
		
		var chart2 = echarts.init(chart2Main);
		
		option = {};
		
		chart2.setOption(option);
	}	
	
	window.addEventListener("DOMContentLoaded", function() {
		loadChartData();
	});


</script>

</head>
<body>
<div class="container-fluid px-0" style="overflow-x : hidden">
<jsp:include page="../commons/navbar.jsp"></jsp:include>

<div class="row bg-gray-c_3c" style="padding-top: 2em; border-top:0.063rem solid #A68A64; border-bottom: 0.063rem solid #A68A64">
	<div class="col ms-4 me-4">
		<div class="row">
			<div class="col ms-2 text-gold bold text-fs-30 fst-italic KOHIBaeumOTF pt-2" style="border-left:4px solid #A68A64">Dash board</div>
		</div>
		<div class="row rounded-10 bg-dashboard mt-4">
			<div class="col">
				<div class="row pt-6">
					<div class="col">
						<div class="row">
							<div class="col">
								<span class="col text-fs-18 font-medium ms-2"><i class="bi bi-pie-chart text-gold"></i> 전체 예약율</span>
								<span class="col text-gray-c_3c text-fs-11">등록일로부터 현재</span>							
							</div>	
						</div>
						<div class="row">
							<div id="chart1Box" class="col"></div>
						</div>
					</div>					
				</div>
			</div>
		</div>
		<div class="row rounded-10 bg-dashboard mt-4">
			<div class="col">
				<div class="row pt-6">
					<div class="col">
						<div class="row">
							<div class="col">
								<span class="col text-fs-18 font-medium ms-2"><i class="bi bi-exclamation-triangle text-gold"></i> 최근 안 좋은 리뷰</span>
								<span class="text-right text-fs-13 ms-5">평균 평점</span> <i class="bi bi-star-fill text-fs-13 text-right" style="color:#d49d4c;"></i><span class="text-fs-13 text-right bold">${reviewAvg }</span>					
							</div>	
						</div>
						<div class="row mt-3 mb-3">
							<div id="badReviewBox" class="col ms-4 me-4 py-3 rounded-5" style="background-color:#ffffff89">
								<c:forEach items="${negativeReview }" var="review">
									<div class="row mb-1 ms-2 text-fs-12">
										<div class="col-2"><i class="bi bi-star-fill" style="color:#d49d4c;"></i> ${review.review_rating }</div>
										<div class="col-4">${review.office_name }</div>										
										<c:choose>
											<c:when test="${fn:length(review.review_title) > 10 }">
												<div class="col cursor-pointer text-red-soft" onclick="location.href='../guest/officeReviewDetailPage?review_no=${review.review_no}'">${fn:substring(review.review_title,0,10) }..</div>	
											</c:when>
											<c:otherwise>
												<div class="col cursorpointer text-red-soft" onclick="location.href='../guest/officeReviewDetailPage?review_no=${review.review_no}'">${review.review_title }</div>
											</c:otherwise>
										</c:choose>
										
									</div>																
								</c:forEach>							
							</div>
						</div>						
					</div>					
				</div>
			</div>
		</div>
		<div class="row rounded-10 bg-dashboard mt-4" style="margin-bottom:4rem">
			<div class="col">
				<div class="row pt-6">
					<div class="col">
						<div class="row">
							<div class="col">
								<span class="col text-fs-18 font-medium ms-2"><i class="bi bi-bar-chart-line text-gold"></i> 오피스별 수익</span>
								<span class="col text-gray-c_3c text-fs-11">최근 5개월</span>							
							</div>	
						</div>
						<div class="row">
							<div id="chart2Box" class="col"></div>
						</div>
					</div>					
				</div>
			</div>
		</div>				
	</div>
</div>



<jsp:include page="../commons/footer.jsp"></jsp:include>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>