<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerAdd</title>
</head>
<body>
	<h1>고객회원가입</h1>
	<form method="post" action="${pageContext.request.contextPath}/customer/customerAdd">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="customerId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="customerPw"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="pwCheck"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="customerName"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="customerPhone"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="customerAddress"></td>
			</tr>
		</table>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>