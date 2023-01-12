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
	
	<form action="${pageContext.request.contextPath}/customer/customerQuestionAdd" method="post">
		<div>
			<label>주문번호</label>
			<input type="text" name="ordersCode" value="${ordersCode }">
		</div>
		
		<div>
			<label>문의사항</label>
			<select name="category">
				<option value="배송">배송</option>
				<option value="교환">교환</option>
				<option value="반품">반품</option>
				<option value="기타">기타</option>
			</select>
		</div>
		<div>
			<label>문의내용</label>
			<input type="text" name="questionMemo">
		</div>
		
		<button type="submit" class="btn">추가</button>
	</form>
</body>
</html>