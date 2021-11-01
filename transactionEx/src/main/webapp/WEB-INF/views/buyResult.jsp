<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓 구매 정보</title>
</head>
<body>
	<div align="center">
		<hr width="40%" color="red" />
		<h2> 티켓을 구매 하셨습니다.!!! </h2>
		<hr width="40%" color="red" />
		
		<!-- 여기서 userId는 buy.jsp에서 input 타입의 name속성의 값을 넣어야한다. -->
		${buyInfo.userId }님은 <br/>
		한일전 축구 경기 티켓을 ${buyInfo.amount }매 구매하셨습니다.
	</div>
</body>
</html>