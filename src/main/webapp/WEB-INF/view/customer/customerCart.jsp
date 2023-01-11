<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니</h1>
	<form action="${pageContext.request.contextPath}/in" method="post">
		<table border="1">
			<tr>
				<td>상품코드</td>
				<td>이미지</td>
				<td>상품명</td>
				<td>가격</td>
			</tr>
			<c:forEach var="n" items="${list}">
			<input type="hidden" name="goodsCode" value="${n.goodsCode}">
			<tr>
				<td>${n.goodsCode}</td>
				<td>
					<img src="${pageContext.request.contextPath}/upload/${n.filename}" width="100" height="100">
				</td>
				<td>${n.goodsName}</td>
				<td>${n.goodsPrice}</td>
			</tr>
			</c:forEach>
			<tr>
				<td>총가격 :</td>
			</tr>
		</table>
		<button type="submit">결제하기</button>
	</form>
</body>
</html>