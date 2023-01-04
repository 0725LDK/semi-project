<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리뷰</h1>
	<!-- 네비메뉴 -->
	<a href="${pageContext.request.contextPath}/customer/customerOne">회원정보</a>
	<a href="${pageContext.request.contextPath}/customer/customerOrder">주문내역</a>
	<a href="${pageContext.request.contextPath}/customer/customerCancle">취소/환불내역</a>
	<a href="${pageContext.request.contextPath}/customer/customerReview">리뷰</a>
	<a href="">고객센터</a>
	
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
			<td><a href="">리뷰 작성</a></td>
			<td><a href="">수정</a></td>
			<td><a href="">삭제</a></td>
		</tr>
	</table>
</body>
</html>