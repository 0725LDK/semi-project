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
	<h1>주문하기</h1>
		<table border="1">
			<tr>
				<td>상품코드</td>
				<td>이미지</td>
				<td>상품명</td>
				<td>수량</td>
				<td>배송비</td>
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
				<td>${l.cartQuantity}</td>
				<td>2,500원</td>
				<td>${l.goodsPrice}</td>
				<td><a href="${pageContext.request.contextPath}/customer/customerCartRemove?goodsCode=${l.goodsCode}">삭제</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="4">총수량 : ${n.sumQuantity}개</td>
				<td>배송비 : 2500원</td>
				<td colspan="2">총가격 : ${m.sumPrice+2500}원</td>
			</tr>
			<tr>
				<td colspan="7" style="color:red">&#10071;상품의 옵션 및 수량 변경은 상품상세 또는 장바구니에서 가능합니다.</td>
			</tr>
		</table>
	<h1>배송정보</h1>
	<form method="post" action="${pageContext.request.contextPath}/customer/customerCartOrder?orderPrice=${m.sumPrice+2500}">
		<table border="1">
			<tr>
				<td>받으시는 분 <span style="color:red">*</span></td>
				<td><input type="text" value="${customer.customerName}"></td>
			</tr>
			<tr>
				<td>
					주소추가 <br>
					주소선택 <span style="color:red">*</span>
				</td>
				<td>
					<input type="text" name="newAddress">
					<button type="button" onclick="return submit2(this.form);">주소추가</button>
					<br>
					<select name="address">
						<c:forEach var="ca" items="${ca}">
							<option value="${ca.address}">${ca.address}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>전화번호 <span style="color:red">*</span></td>
				<td><input type="text" value="${customer.customerPhone}"></td>
			</tr>
			<tr>
				<td>배송메세지</td>
				<td><textarea rows="5" cols="50"></textarea></td>
			</tr>
		</table>
		<button type="submit">결제하기</button>
	</form>
</body>
<script>
	function submit2(fo) {
		fo.action='${pageContext.request.contextPath}/customer/customerCartAddAddress';
		fo.submit();
		return true;
	}
</script>
</html>