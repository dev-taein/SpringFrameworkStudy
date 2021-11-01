<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 성공</title>
</head>
<body>
	<h2>회원 가입 성공</h2>
	<hr/>
	회원 정보<br/>
	이름 : ${member.name } <br/>
	아이디 : ${member.id } <br/>
	주소 : ${member.address.address1 } <br/>
		 ${member.address.address2 }
</body>
</html>