<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보(탈퇴)</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<form action="${pageContext.request.contextPath}/customer/customerRemove" method="post">
		<table>
			<tr>
				<td>계정명 : </td>
				<td><input type="text" name="customerId" value="" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="password" name="customerPw"></td>
			</tr>
		</table>
		<button type="submit">탈퇴하기</button>
	</form>
</body>
</html>