<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html 주석 -->
	<%-- jsp 주석 --%>
	
	<!-- 파라미터 보내는 법 -->
	<!-- 1.파라미터가 확정적인 경우 -->
	<a href="result.jsp">결과로 이동하기...1</a><br>
	<a href="result.jsp?v1=qwer">결과로 이동하기...2</a><br>
	<a href="result.jsp?v2=1111">결과로 이동하기...3</a><br>
	<a href="result.jsp?v1=1111&v2=qqqq">결과로 이동하기...4</a><br>
	<br>
	
	<!-- 2.입력양식을 활용한 법(사용자가 입력한 값을 보내야할 때) => js로 구현해도됨 -->
	
	<!-- 2-1.입력 양식을 감싸는 form태그 존재 -->
	<!-- 2-3.request를 받을 곳 설정-->
	<form action="./result.jsp" method="get"> 
	<!-- 2-4.입력양식에 name을 지정 -->
	v1 : <input type="text" name="v1"><br>
	v2 : <input type="text" name="v2"><br>
	<!-- 2-2.submit이 발생하는 버튼 생성 -->
	<!-- <button>전송</button> -->
	<input type="submit" value="전송">
	</form>	
</body>
</html>