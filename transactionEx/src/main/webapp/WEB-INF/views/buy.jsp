<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓 구매</title>
</head>
<body>

<div align="center">
	<hr width="40%" color="green" />
		<h2>한일전 축구 경기 티켓 구매</h2>
	<hr width="40%" color="green" />	
		<table border="1" cellpadding="0" cellspacing="0">
			<form action="buyOk" method="post">
				<tr>
					<td>유저 아이디 : </td>
					<td><input type="text" name="userId" /></td>
				</tr>
				
				<tr>
					<td>티켓 매수 </td>
					<td><input type="text" name="amount" size="2" /> 매</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="카드결제" /></td>
				</tr>
			</form>
		</table>
</div>
</body>
</html>