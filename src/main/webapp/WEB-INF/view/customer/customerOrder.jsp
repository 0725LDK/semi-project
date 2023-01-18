<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$( document ).ready( function() {
			var point = parseInt($('#usedPoint').val());
			var usedPoint = point * (-1);
			var orderPrice = parseInt($('#orderPrice').val());
			var totalPrice = orderPrice - point; 
			$('#pointUse').click(function(){
				$('#pointUse').hide();
				$('input[name=orderPrice]').attr('value',totalPrice);
				$('input[name=usedPoint]').attr('value',usedPoint);
				console.log(point);
				console.log(orderPrice);
				console.log(totalPrice);
				console.log(typeof point);
				console.log(typeof orderPrice);
				console.log(typeof totalPrice);
			});
		});
	</script>
</head>
<body>
	<h1>주문하기</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<form action="${pageContext.request.contextPath}/customer/customerOrder" method="post">
		<input name="goodsCode" value="${map.goodsCode}" type="hidden">
		<table>
			<tr>
				<!-- <td>상품명</td> -->
				<td>상품이미지</td>
				<td>고객ID</td>
				<td>상품수량</td>
				<td>상품가격</td>
				<td>배송지</td>
				<td>사용 가능한 포인트</td>
			</tr>
			<tr>
				<!--<td><input name="goodsName"></td>  -->
				<td rowspan="10">
					<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="100" height="150">
				</td>
				<td><input name="customerId" value="${loginCustomer.customerId}" readonly="readonly">  </td>
				<td><input name="orderQuantity" value="${goodsQuantity }" readonly="readonly"></td>
				<td><input name="orderPrice" id="orderPrice" value="${totalPrice}" readonly="readonly"></td>
				<td><input name="address" value="${customer.address}"></td>
				<td>
					<input name="usedPoint" id="usedPoint" value="${customer.point}" readonly="readonly"><br>
					<button type="button" id="pointUse">포인트 사용</button>
				</td>
			</tr>
		</table>
		<button type="submit">주문하기</button>
	</form>
</body>
</html>