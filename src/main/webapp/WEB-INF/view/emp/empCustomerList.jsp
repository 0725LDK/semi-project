<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 리스트</h1>
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		<tr>
			<td>회원 ID</td>
			<td>회원 이름</td>
			<td>전화번호</td>
			<td>보유 포인트</td>
			<td>가입 일자</td>
		</tr>
		<tr>
			<td><input type="text" name="customerId"></td>
			<td><input type="text" name="customerName"></td>
			<td><input type="text" name="customerPhone"></td>
			<td><input type="text" name="customerPoint"></td>
			<td><input type="text" name="customerCreatedate"></td>
		</tr>
	</table>
</body>
</html>