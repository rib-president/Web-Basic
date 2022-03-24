<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	window.close();
	
	window.addEventListener('unload', function() {
		window.opener.sendMeData('${response_code}');
	});
</script>
</head>
<body>
</body>
</html>