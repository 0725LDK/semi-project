<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<form>
		<table>
			<tr>
				<td>상품명</td>
				<td>상품수량</td>
				<td>상품가격</td>
				<td>총 가격</td>
				<td>배송지</td>
			</tr>
			<tr>
				<td><input name="goodsName"></td>
				<td><input name="orderQuantity"></td>
				<td><input name="orderPrice"></td>
				<td><input name="address"></td>
			</tr>
		</table>
		<button type="submit">주문하기</button>
	</form>
</body>
</html>