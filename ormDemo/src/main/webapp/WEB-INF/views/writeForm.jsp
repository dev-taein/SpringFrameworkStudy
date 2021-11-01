<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 폼 페이지</title>
</head>
<body>
	<div align="center">
	<h3>글쓰기 폼</h3>
	<hr width="50%" />
		<a href="list">글 목록</a>
		<table border="1" cellpadding="1" cellspacing="0">
			<form action="writeOk" method="post">
				<colgroup>
					<col bgcolor="#ffaabb" width="20%">
					<col width="80%">
				</colgroup>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="name" size="30" /></td>
				</tr>
				
				<tr>
					<td>내용</td>
					<td><input type="text" name="bContent" size="50" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록" /> &nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소" />
					</td>
				</tr>
			</form>			
		</table>
	</div>
</body>
</html>