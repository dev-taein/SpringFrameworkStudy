<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Department객체 가져오기.-->
<%@ page import="java.util.*, com.spring.hr.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서별 현황</title>
</head>
<body>
	<div align="center">
		<hr width="40%" color="green">
		<h3>부서별 현황</h3>
		<hr width="40%" color="green">
		<table width="500" cellpadding="2" cellspacing="0" border="1">
			<tr>
				<td>부서코드</td>
				<td>부서명</td>
				<td>매니저ID</td>
				<td>위치코드</td>
			</tr>
			
			<c:forEach items="${deptList}" var="dept">
			<tr>
				<td>${dept.deptId }</td>
				<td>${dept.deptName }</td>
				<td>${dept.deptMgr }</td>
				<td>${dept.locationId }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>