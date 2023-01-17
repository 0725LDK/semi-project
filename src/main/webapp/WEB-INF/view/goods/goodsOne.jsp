<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>jQuery</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$( document ).ready( function() {
			$( '#goodsPrice, #goodsQuantity' ).change( function() {
				var goodsPrice = parseInt($('#goodPrice' ).val());
				var goodsQuantity = parseInt($('#goodsQuantity').val());
				var totalPrice = parseInt(goodsPrice * goodsQuantity);
				$('input[name=totalPrice]').attr('value',totalPrice);
				//$("#totalPrice").text(totalPrice);
				console.log($('#goodPrice' ).val());
				console.log(goodsQuantity);
				console.log(totalPrice);
				console.log(typeof goodsPrice);
				console.log(typeof goodsQuantity);
				console.log(typeof totalPrice);
			} );
		} );
		//장바구니 버튼 submit
		function submit2(fo) { 
			fo.action='${pageContext.request.contextPath}/customer/customerCart';
			fo.submit();
			return true;
		}
	</script>

</head>
<body>

	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>
	</div>

	<br>
	<form action="${pageContext.request.contextPath}/customer/customerOrder" method="get">
		<input type="hidden" name="goodsCode" value="${map.goodsCode }">
		<table>
			<tr>
				<td rowspan="10">
					<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="200" height="250">
				</td>
				<th>${map.goodsName}</th>
			</tr>
			<tr>
				<td>${map.goodsContent}</td>		
			</tr>
			<tr>
				<th>주종: ${map.categoryName}</th>	
	
			</tr>
			<tr>
				<th>도수: ${map.goodsAlcohol}</th>	
	
			</tr>
			<tr>
				<th>용량: ${map.goodsLiter}</th>	
	
			</tr>
			<tr>
				<th>판매 가격: <input type="number" name="goodsPrice" id="goodPrice" value="${map.goodsPrice}" readonly="readonly"></th>
			</tr>		
			<tr>
				<th>
					수량 :  <input type="number" name="goodsQuantity" id="goodsQuantity">
				</th>
			</tr>	
			<tr>
				<th>
					총 가격(￦) : <input type="text" name="totalPrice" id="totalPrice" value=""> 
				</th>
			</tr>
		</table>	
		<button type="button" onclick="return submit2(this.form);">장바구니</button>		
		<button type="submit">구매하기</button>
	</form>

</body>
</html>