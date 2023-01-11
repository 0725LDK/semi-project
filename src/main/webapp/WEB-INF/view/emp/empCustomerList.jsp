<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<table border="1">
		<tr>
			<td>회원 번호</td>
			<td>회원 ID</td>
			<td>회원 이름</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>보유 포인트</td>
			<td>가입 일자</td>
		</tr>
		<c:forEach var="c" items="${customerList}">
			<tr>
				<td>${c.customerCode}</td>
				<td>${c.customerId}</td>
				<td>${c.customerName}</td>
				<td>${c.customerPhone}</td>
				<td>${c.address}</td>
				<td>${c.point}</td>
				<td>${c.createdate}</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>