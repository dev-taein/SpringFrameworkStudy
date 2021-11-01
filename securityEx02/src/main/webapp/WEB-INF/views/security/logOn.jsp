<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logOn</title>
</head>
<body>
<div align="center">
	<!-- 아이디 값이 비어 있지 않다면 -->
	<c:if test="${not empty pageContext.request.userPrincipal }">
		<h2>${pageContext.request.userPrincipal.name }로그인 되었습니다.</h2><br/>
	</c:if>
	
	<!-- 아이디 값이 비어있다면 -->
	<c:if test="${empty pageContext.request.userPrincipal }">
		<h2>로그아웃 되었습니다.</h2><br/>
	</c:if>
	
	<a href="${pageContext.request.contextPath}/j_spring_security_logout">로그아웃</a>
</div>
</body>
</html>