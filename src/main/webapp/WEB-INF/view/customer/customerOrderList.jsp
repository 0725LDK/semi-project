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
	<h1>주문내역</h1>
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
			<td>상품가격</td>
			<td>주문상태</td>
			<td>결제일자</td>
			<td>고객센터 문의하기</td>
		</tr>
		<c:forEach var="o" items="${orderList }">
			<tr>
				<td>${o.goodsname }</td>
				<td>${o.customerId }</td>
				<td>${o.address }</td>
				<td>${o.orderQuantity }</td>
				<td>${o.orderPrice }</td>
				<td>${o.orderState }</td>
				<td>${o.createdate }</td>
				<td><a href="${pageContext.request.contextPath}/customer/customerQuestionAdd?ordersCode=1">문의등록</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>