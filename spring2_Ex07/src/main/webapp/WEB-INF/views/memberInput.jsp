<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form:form action="addMember" method="post">
		<table>
			<tr>
				<%-- <td><form:label path="name">이름</form:label></td>  label 추가하는 법--%>
				<td>이름</td>
				<td><form:input path="name"/></td>
			</tr>
			
			<tr>
				<td>아이디</td>
				<td><form:input path="id"/></td>
			</tr>
			
			<tr>
				<td>이메일</td>
				<td><form:input path="email"/></td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td><form:input path="hp"/></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="전송" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>