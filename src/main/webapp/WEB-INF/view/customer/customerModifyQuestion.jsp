<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>문의사항 수정</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>
	<form action="${pageContext.request.contextPath}/customer/customerModifyQuestion" method="post">
		<div>
			<label>문의번호</label>
			<input>
		</div>
		<div>
			<label>문의상품</label>
			<input>
		</div>
		<div>
			<label>문의사항</label>
			<input>
		</div>
		<div>
			<label>문의일자</label>
			<input>
		</div>
		<button type="submit" class="btn">수정</button>
	</form>
</body>
</html>