<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 목록</title>
</head>
<body>
	<div align="center">
		<hr width="40%" color="green" />
		<h2>회원 정보 리스트</h2>
		<hr width="40%" color="green" />
		<table border="1" width="80%" cellpadding="2" cellspacing="0">
		<%-- <colgroup>
			<col width="">
		</colgroup> --%>
			<tr>
				<td align="center" bgcolor="yellow">아이디</td>
				<td align="center" bgcolor="yellow">비밀번호</td>
				<td align="center" bgcolor="yellow">이름</td>
				<td align="center" bgcolor="yellow">전화번호</td>
				<td align="center" bgcolor="yellow">이메일</td>
				<td align="center" bgcolor="red">관리자메뉴</td>
			</tr>
			<c:forEach items="${mybatisMembers }" var="mybatisMember">
				<tr align="center">
					<td>${mybatisMember.id }</td>
					<td>${mybatisMember.pwd }</td>
					<td>${mybatisMember.name }</td>
					<td>${mybatisMember.tel }</td>
					<td>${mybatisMember.email }</td>
					<td>
						<input type="button" value="회원정보수정" onclick="location.href='${pageContext.request.contextPath}/modifyMmeber/${mybatisMember.id}'" />
						<input type="button" value="회원정보삭제" onclick="location.href='${pageContext.request.contextPath}/delMember/${mybatisMember.id}'" />
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>