<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 취소</title>
<script>
	window.close();
	
	window.addEventListener('unload', function() {
		window.opener.sendMeData("결제 취소");
	});
</script>
</head>
<body>

</body>
</html>