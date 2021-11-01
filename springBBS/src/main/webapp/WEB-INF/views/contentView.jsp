<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기 페이지</title>
</head>
<body>
<div align="center">
	<h2>글 내용 확인</h2>
	<hr width="500" color="green" />
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
			<!-- 게시글을 수정할때 bNo정보를 파라미터로 전달해야 게시글을 수정할 수 있다.
				ModifyCmd 커맨드패키지에서 bDAO.modify(bNo, bName, bSubject, bContent);에서 
					bNo정보를 넘겨주기 때문에 jsp폼태그 안에서 bNo 정보를 input 태그로 전달한다(대신 hidden를 사용해 안보이게) -->
			<input type="hidden" name="bNo" value="${contentView.bNo }" />
			<tr>
				<td>번호</td>
				<td>${contentView.bNo }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${contentView.bHit }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bName" value="${contentView.bName }" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bSubject" value="${contentView.bSubject }" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent">${contentView.bContent}</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정하기" />
					&nbsp;&nbsp;&nbsp;<a href="list">목록보기</a>
					 <!-- 해당 글번호의 글을 삭제하기 위해서 delete?bNo=${contentView.bNo}작성 -->
					&nbsp;&nbsp;&nbsp;<a href="delete?bNo=${contentView.bNo}">삭제</a>
					&nbsp;&nbsp;&nbsp;<a href="replyForm?bNo=${contentView.bNo }">답변</a>
				</td>
			</tr>
		</form>
	</table>
</div>	
</body>
</html>