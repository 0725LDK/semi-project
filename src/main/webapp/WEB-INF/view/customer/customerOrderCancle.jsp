<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 취소/환불 내역 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>취소/환불 내역</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<table border="1">
		<tr>
			<td>상품명</td>
			<td>고객ID</td>
			<td>배송지</td>
			<td>상품수량</td>
			<td>총가격</td>
			<td>주문상태</td>
		</tr>
		<c:forEach var="o" items="${orderList }">
				<input type="hidden" name="orderCode" value="${o.orderCode}">
				<tr>
					<td>${o.goodsname }</td>
					<td>${o.customerId }</td>
					<td>${o.address }</td>
					<td>${o.orderQuantity }</td>
					<td>${o.orderPrice }</td>
					<td>${o.orderState }</td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>