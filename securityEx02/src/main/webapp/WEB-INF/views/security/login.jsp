<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>

<!-- name 속성의  j_username은 공식처럼 정해진 것이므로 무조건 j_username으로 사용해야한다. -->
<!-- name 속성의  j_password은 공식처럼 정해진 것이므로 무조건 j_password으로 사용해야한다. -->
<%-- <form action="<c:url value="j_spring_security_check/>" method="post"> 
		폼태그의 action의 속성 값도 jsp태그라이브러리를 이용해서 j_spring_security_check를 사용 --%>
<div align="center">
	<hr width="40%" />
	<h2>로그인</h2>
	<hr width="40%" />
	<table border="1" cellpadding="3" cellspacing="0">
	
	<c:url value='j_spring_security_check' var="loginUrl"/>
		<form action="${loginUrl }" method="post">
			<tr>
				
				<td colspan="2">
					<c:if test="${param.fail != null }">
						로그인 실패했습니다.<br/>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				
				<td><input type="text" name="j_username" /></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="j_password" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" />
				</td>
			</tr>
		</form>
	</table>
</div>
</body>
</html>