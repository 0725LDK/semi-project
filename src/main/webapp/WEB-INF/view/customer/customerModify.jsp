<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보(수정)</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	
	<!-- 회원정보 -->
	<form action="${pageContext.request.contextPath}/customer/customerModify" method="post">
		<table>
			<tr>
				<td>계정명 : </td>
				<td><input type="text" name="customerId" value="" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="customerName"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="customerAddress"></td>
			</tr>
			<tr>
				<td>휴대폰 : </td>
				<td><input type="text" name="customerName"></td>
			</tr>
		</table>
		<button type="submit">변경하기</button>
	</form>
</body>
</html>