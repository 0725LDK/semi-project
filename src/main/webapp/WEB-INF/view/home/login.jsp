<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form method="post" action="${pageContext.request.contextPath}/home/login">
		<table border="1">
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="loginPw"></td>
			</tr>
		</table>
	<button type="submit">로그인</button>
	<a href="${pageContext.request.contextPath}/customer/customerAdd">고객회원가입</a>
	<a href="${pageContext.request.contextPath}/emp/empAdd">직원회원가입</a>
	</form>
</body>
</html>