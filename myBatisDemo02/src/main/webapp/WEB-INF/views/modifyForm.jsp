<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
<style type="text/css">
	.errMsg {font-size:9pt; color:red}
</style>
</head>
<body>
	<div align="center">
	<hr width="40%" color="green">
	<h2>회원 수정 페이지</h2>
	<hr width="40%" color="green">
	<table border="1" cellpadding="2" cellspacing="0" width="500">
		<%-- <form:form commandName="mybatisMember" method="post" action="${pageContext.request.contextPath}/modifyOk"> --%>
		<!-- commandName대신에 modelAttribute를 사용해도 똑같은 결과가 나온다. -->
		<form:form modelAttribute="mybatisMember" method="post" action="${pageContext.request.contextPath}/modifyOk">
			<tr>
				<td>아이디</td>
				<td>
					<form:input path="id" maxlength="20" readonly="true" />
					<form:errors path="id" cssClass="errMsg" />
				</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<form:password path="pwd" maxlength="20" />
					<form:errors path="pwd" cssClass="errMsg" />
				</td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td>
					<form:input path="name" maxlength="50" />
					<form:errors path="name" cssClass="errMsg" />
				</td>
			</tr>
			
			
			<tr>
				<td>전화번호</td>
				<td>
					<form:input path="tel" maxlength="13" />
					<form:errors path="tel" cssClass="errMsg" />
				</td>
			</tr>
			
			<tr>
				<td>이메일</td>
				<td>
					<form:input path="email" maxlength="50" />
					<form:errors path="email" cssClass="errMsg" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="회원 수정" /></td>
			</tr>
		</form:form>
	</table>
	</div>
</body>
</html>