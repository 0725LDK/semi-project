<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리뷰 작성</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>
	
	<form action="${pageContext.request.contextPath}/customer/customerReviewAdd" method="post">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="goodsName"></td>
			</tr>
			<tr>
				<td>리뷰 내용</td>
				<td><input type="text" name="addReview"></td>
			</tr>
		</table>
		<button type="submit">작성하기</button>
	</form>
</body>
</html>