<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>

	Kakao.init('dcba11bad3364b22a9a962b80ee0acfb');
	Kakao.Auth.setAccessToken('${access_token }');		
	Kakao.API.request({
	    url: '/v2/user/me',
	    data: {
	        property_keys: ["kakao_account.email","kakao_account.gender", "kakao_account.birth"]
	    },
	    success: function(response) {
	    	
	    	location.href='../member/checkJoin?member_id=' + response.id + '&member_email=' + response.kakao_account.email;
	    },
	    fail: function(error) {
	    	alert("카카오 로그인 실패");
	    	location.href='../member/loginPage';
	    }
	});
	
</script>
</head>
<body>

</body>
</html>