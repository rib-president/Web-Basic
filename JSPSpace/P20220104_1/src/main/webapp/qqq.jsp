<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var a = 10;
	var b = 20;
	var c = a+b;
	alert(c);
</script>
</head>
<body>
	안녕하세요
	<%
		// scriptlet(여기에 자바코드 작성 가능함)
		int a = 10;
		int b = 20;
		int q = (int)(Math.random()*10)+1;
		
		for(int i=1;i<=q;i++) {
			out.println("반갑습니다.");
		}
	%>
</body>
</html>