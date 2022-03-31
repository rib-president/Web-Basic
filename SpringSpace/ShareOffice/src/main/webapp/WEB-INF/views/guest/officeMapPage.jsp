<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../resources/css/commons.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>주소로 장소 표시하기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">    
</head>
<body>
<jsp:include page="../commons/navbar.jsp"></jsp:include>
<div class="row " style="padding-top: 5em;">
   <div class="col" style="margin:1em">
      <div class="row mt-3">      
           <div class="col-9">           
           <input  type="text"  id="host_name" name="host_name" 
			 class="form-control form-control-sm"placeholder="검색할 지역명을 입력해주세요.">		    
		   </div>  
		   <div class="col"><button type="button" onclick="getLocationList()" class="btn btn-lg default"><i class="bi bi-search"></i></button>
		   </div>
		   
      </div>

      <div class="row">
         <div class="col">
			<p style="margin-top: -0.75em">
				<em class="link"> <a href="javascript:void(0);"
					onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">

				</a>
				</em>
			</p>
			<div id="map" style="width:100%;height:21em;"></div>
		</div>			
	 </div>		
  </div>
</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a89f71e1f43b65b9072477b5fb3f976&libraries=services"></script>
<script>
var address_list = new Array();
function getLocationList(){

	
	//AJAX...호출...
	var xhr = new XMLHttpRequest();
	
	//응답 받을때...
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = JSON.parse(xhr.responseText);
			
			var mapContainer = document.getElementById("map"), // 지도를 표시할 div 
			mapOption = {
			    center: new kakao.maps.LatLng(37.4997900799939, 127.031119235961), // 지도의 중심좌표
			    level: 3 // 지도의 확대 레벨
			};  
			
			//지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 			
			
			//주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
			// 주소 리스트 수정
			//var address_list = ["서울 강남구 강남대로 406 지하1층 감성타코", "서울 강남구 테헤란로 109 강남제일빌딩", "서울 서초구 서초대로77길 7 서초빌딩 1층"];		
			//var address_list = '${office.officeVo.office_address}';
			
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
			for(var officeInfoVo of data.locationList) {
				//주소로 좌표를 검색합니다
				geocoder.addressSearch(officeInfoVo.office_address, function(result, status) {
			    address_list.push(officeInfoVo.office_address);
				
				// 정상적으로 검색이 완료됐으면 
				 if (status === kakao.maps.services.Status.OK) {
					  var imageSize = new kakao.maps.Size(24, 35); 
					  var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
				      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				
				    // 결과값으로 받은 위치를 마커로 표시합니다
				    var marker = new kakao.maps.Marker({
				        map: map,
				        position: coords,
				        image : markerImage
				    });

				    var iwContent = '<div style="padding:0.5em;">' + officeInfoVo.office_name + '<br><a href="https://map.kakao.com/link/map/' + officeInfoVo.office_name + '!,' + result[0].y + "," + result[0].x + '" style="color:#415a77" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/${officeInfoVo.office_name}!,' + result[0].y + "," + result[0].x + '" style="color:#415a77" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		            iwPosition = new kakao.maps.LatLng(geocoder); //인포윈도우 표시 위치입니다				    
				    
				    var infowindow = new kakao.maps.InfoWindow({
			             position : iwPosition, 
			             content : iwContent 
			            });
			        			        			        
			        infowindow.open(map, marker);				    
				    
				    map.setCenter(coords);
				   
				} 
				
									
				});
			}
			
		}
		
	};
	
	
	xhr.open("GET" , "./getLocationList?searchKeyword=" + document.querySelector("#host_name").value, true);
    xhr.send();
	
}


	
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>