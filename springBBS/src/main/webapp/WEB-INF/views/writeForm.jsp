<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center"> 
	<h2>글쓰기 페이지 </h2>
	<hr width="500"/>
	<a href="list">목록</a>
	<table border="1" cellpadding="0" cellspacing="0" width="500">
		<form:form commandName="BVO" action="writeOk" method="post">
			<tr>
				<td>작성자</td>
				<td><form:input path="bName" size="20" /></td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td><form:input path="bSubject" size="20" /></td>
			</tr>
			
			
			<tr>
				<td>내용</td>
				<td><form:textarea path="bContent" cols="100" rows="8" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등록" /></td>
			</tr>
		</form:form>
	</table>
</div>
</body>
</html>