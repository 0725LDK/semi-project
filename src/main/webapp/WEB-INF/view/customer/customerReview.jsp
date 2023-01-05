<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리뷰 리스트</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<table>
		<tr>
			<td>상품명</td>
			<td>구매확정여부</td>
			<td>리뷰 내용</td>
			<td>리뷰 작성</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<tr>
			<td><input name="goodsName"></td>
			<td><input name="orderState"></td>
			<td><input name="reviewMemo"></td>
			<td><a href='${pageContext.request.contextPath}/customer/customerAddReview'>리뷰 작성</a></td>
			<td><a href='${pageContext.request.contextPath}/customer/customerModifyReview'>수정</a></td>
			<td><a href='${pageContext.request.contextPath}/customer/customerRemoveReview'>삭제</a></td>
		</tr>
	</table>
</body>
</html>