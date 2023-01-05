<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 취소/환불 내역</h1>
	
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		<tr>
			<td>회원 ID</td>	
			<td>상품명</td>	
			<td>상품수량</td>	
			<td>주소</td>
			<td>취소/환불</td>	
			<td>요청일자</td>	
		</tr>
		<tr>
			<td><input type="text" name="customerId"></td>
			<td><input type="text" name="goodsName"></td>
			<td><input type="text" name="orderQuantity"></td>
			<td><input type="text" name="customerAddress"></td>
			<td><input type="text" name="orderState"></td>
			<td><input type="text" name="orderCreatedate"></td><!-- 취소/환불 일자 -->
		</tr>
	</table>
</body>
</html>