<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>
	</div>

	<br>

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
		<tr>
			<th>
				수량 : <input type ="hidden" name="sell_price" value="${map.goodsPrice}"> 
				<input type ="text" name="amount" value="1" size="3" max=""> 
				<input type ="button" name="add" value="+"> 
				<input type ="button" name="minus" value="-"> 
			</th>

		</tr>	
		<tr>
			<th>총 가격:
			<input type ="text" name="sum" size="11" value="" readonly="readonly">원  
			</th>
		</tr>	
	</table>	

	<div>
		<a href="${pageContext.request.contextPath}/customer/customerCart">장바구니</a>
		<a href="${pageContext.request.contextPath}/customer/customerOrder?goodsCode=${map.goodsCode}">구매하기</a>			
	</div>
	

</body>
</html>