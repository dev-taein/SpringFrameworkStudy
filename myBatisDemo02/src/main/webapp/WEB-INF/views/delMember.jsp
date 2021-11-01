<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제 페이지</title>
<style type="text/css">
	.errMsg{font-size:9pt; color:red}
</style>
</head>
<body>
	<div align="center">
	<hr width="40%" color="red" />
	<h2>회원 삭제</h2>
	<hr width="40%" color="red" />
		<table width="500" border="1" cellpadding="2" cellspacing="0" >
			<form:form modelAttribute="mybatisMember" method="post" 
							action="${pageContext.request.contextPath}/deleteOk" name="frm">
				<tr align="center">
					<td>
						아이디 : <form:input path="id" maxlength="20" /> <br/>
						 	   <%-- <form:errors path="id" cssClass="errMsg" /> --%>
						 	   <span id="del" style="display:none">
				 					<input type="submit" value="회원 삭제" />
				 					<input type="reset" value="취소" />
				 				</span>
				 	</td>
				</tr>
			</form:form>
		</table>
	</div>
	
	<script type="text/javascript">
		if(document.frm.id.value != ""){
			document.getElementById("del").style.display="";
		}
	</script>
</body>
</html>