<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>문의사항 수정</h2>
	<form action="${pageContext.request.contextPath}/customer/costomerModifyQuestion" method="post">
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