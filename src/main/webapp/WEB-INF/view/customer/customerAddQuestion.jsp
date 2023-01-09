<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>문의사항 추가</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<form action="${pageContext.request.contextPath}/customer/customerAddQuestion" method="post">
		<div>
			<label>주문번호</label>
			<input type="text" name="ordersCode" value="${ordersCode }">
		</div>
		
		<div>
			<label>문의상품</label>
			<input type="text" name="goodsname">
		</div>
		<div>
			<label>문의사항</label>
			<input type="text" name="questionMemo">
		</div>
		<div>
			<label>문의일자</label>
			<input type="text" name="questionCreate">
		</div>
		<button type="submit" class="btn">추가</button>
	</form>
</body>
</html>