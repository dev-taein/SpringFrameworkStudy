<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div align="center">
		<h2>회원가입 페이지</h2>
		<hr>
		<form action="inputOK">
		<table border="1" cellpadding="2" cellspacing="0">
			
				<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""/></td>
				</tr>
				
				<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value=""/></td>
				</tr>
				
				<tr>
				<td>주민번호</td>
				<td><input type="text" name="memNo" value=""/></td>
				</tr>
				
		</table><br/>
		<input type="submit" value="전송"/>
		</form>
	</div>

</body>
</html>