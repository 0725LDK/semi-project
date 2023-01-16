<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니</h1>
	<c:if test="${empty list}">
		장바구니에 담긴 상품이 없습니다.
		<a href="${pageContext.request.contextPath}/home/main">상품추가</a>
	</c:if>
	<c:if test="${not empty list}">
		<table border="1">
			<tr>
				<td>상품코드</td>
				<td>이미지</td>
				<td>상품명</td>
				<td>수량</td>
				<td>가격</td>
				<td>삭제</td>
			</tr>
			<c:forEach var="l" items="${list}">
			<tr>
				<td>${l.goodsCode}</td>
				<td>
					<img src="${pageContext.request.contextPath}/upload/${l.filename}" width="70" height="70">
				</td>
				<td>${l.goodsName}</td>
				<td>
					<form action="${pageContext.request.contextPath}/customer/customerCartModify">
						<input type="hidden" name="goodsCode" value="${l.goodsCode}">
						<input type="text" size=1 name="cartQuantity" value="${l.cartQuantity}">
						<button type="submit">수정</button>
					</form>
				</td>
				<td>${l.goodsPrice}</td>
				<td><a href="${pageContext.request.contextPath}/customer/customerCartRemove?goodsCode=${l.goodsCode}">삭제</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="4">총수량 : ${n.sumQuantity}개</td>
				<td colspan="2">총가격 : ${m.sumPrice}원</td>
			</tr>
		</table>
		<a href="${pageContext.request.contextPath}/customer/customerCartOrder">주문하기</a>
		<a href="${pageContext.request.contextPath}/home/main">상품추가</a>
	</c:if>
</body>

</html>