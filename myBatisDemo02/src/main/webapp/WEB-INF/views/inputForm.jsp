<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.msg{ color:red }
</style>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
</head>
<body>
	<div align="center">
		<hr width="40%" color="green" />
		<h2>회원가입 페이지</h2>	
		<hr width="40%" color="green" />
		<table border="1" cellpadding="2" cellspacing="0" width="600">
			<form:form method="post" action="insertOk" commandName="mybatisMember">
				<tr>
					<td>이름</td>
					<td>
						<form:input path="name" maxlength="50" />
						<form:errors path="name" cssClass="msg" />
					</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>
						<form:input path="id" maxlength="20" />
						<form:errors path="id" cssClass="msg" />
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<form:password path="pwd" maxlength="20" />
						<form:errors path="pwd" cssClass="msg" />
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<form:input path="tel" maxlength="13" />
						<form:errors path="tel" cssClass="msg" />
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<form:input path="email" maxlength="50" />
						<form:errors path="email" cssClass="msg" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="회원 등록" />&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소" />
					 </td>
				</tr>
			</form:form>			
		</table>
	</div>
</body>
</html>