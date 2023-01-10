<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
</head>
<body>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>
	</div>

	<br>
<div>
	<table>
		<tr>
			<td rowspan="10">
				<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="200" height="250">
			</td>
			<th>${map.goodsName}</th>
		</tr>
		<tr>
			<td>${map.goodsContent}</td>		
		</tr>
		<tr>
			<th>주종: ${map.goodsCategory}</th>	

		</tr>
		<tr>
			<th>도수: ${map.goodsAlcohol}</th>	

		</tr>
		<tr>
			<th>용량: ${map.goodsLiter}</th>	

		</tr>
		<tr>
			<th>판매 가격: ${map.goodsPrice}</th>
		</tr>	
	</table>	
	<table border="1">
		<tr>
			<th>수량</th>
			<td>
				<input type="number" name="orderQuantity" value="">
			</td>
		</tr>	
		<tr>
			<th>총 상품가격</th>
			<td>
				<input type="number" name="orderPrice" value="">
			</td>
		</tr>	
	</table>
	<div>
		<a href="${pageContext.request.contextPath}/customer/customerCart">장바구니</a>
		<a href="${pageContext.request.contextPath}/customer/customerOrder">구매하기</a>			
	</div>
	
</div>
</body>
</html>