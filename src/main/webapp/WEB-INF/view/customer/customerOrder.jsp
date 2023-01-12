<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문하기</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<form action="${pageContext.request.contextPath}/customer/customerOrder" method="post">
		<table>
			<input name="goodsCode" value="${map.goodsCode}" type="hidden">
			<tr>
				<!-- <td>상품명</td> -->
				<td>상품이미지</td>
				<td>고객ID</td>
				<td>상품수량</td>
				<td>상품가격</td>
				<td>배송지</td>
			</tr>
			<tr>
				<!--<td><input name="goodsName"></td>  -->
				<td rowspan="10">
					<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="100" height="150">
				</td>
				<td><input name="customerId" value="${loginCustomer.customerId}"> </td>
				<td><input name="orderQuantity" value=""></td>
				<td><input name="orderPrice" value="${map.goodsPrice}"></td>
				<td><input name="address" value="${customer.address}"></td>
			</tr>
		</table>
		<button type="submit">주문하기</button>
	</form>
</body>
</html>