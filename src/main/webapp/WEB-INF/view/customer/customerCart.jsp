<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니</h1>
	<form>
		<table>
			<tr>
				<td>상품명</td>
				<td>가격</td>
				<td>수량</td>
			</tr>
			<tr>
				<td>${goodsName}</td>
				<td>${goodsPrice}</td>
				<td>${goodsOrderQuantity}</td>
			</tr>
			<tr>
				<td>총가격 : ${totalPrice}</td>
			</tr>
		</table>
		<button type="submit">결제하기</button>
	</form>
</body>
</html>