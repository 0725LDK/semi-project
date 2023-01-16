<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- orderQuantity   /customer/customerCart  -->
	<!-- quantity /customer/customerCartAdd -->
	<form action="${pageContext.request.contextPath}/customer/customerCart" >
		<input type="hidden" name="goodsCode" value="15">
		<input type="hidden" name="goodsQuantity" value="5">
		<button type="submit">장바구니</button>
	</form>
	
</body>
</html>