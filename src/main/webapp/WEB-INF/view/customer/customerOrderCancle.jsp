<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>934마켓 취소/환불 내역 | 전통주의 모든것, 934마켓</title>
	<!-- 메인 네비메뉴 -->
	<jsp:include page="/inc/customerCss.jsp"></jsp:include>
	<style>
		table, td {
			height: 60px;
			text-align: center;
		}
		table {
			width: 100%;
		}
		th {
			height: 50px;
		}
	</style>
</head>
<body>
	<!-- 상단 네비메뉴 -->
	<div>
		<jsp:include page="/inc/mainNavMenu.jsp"></jsp:include>
	</div>	
	
	<!-- 카테고리 네비메뉴 -->
	<div>
	   <jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>   
	</div>   

    <!-- 고객 주문 취소/환불 리스트 -->
    <div class="text-center">
		<br><h2>취소/환불내역</h2>
	</div>
    <section class="shoping-cart spad">
        <div class="container">
            <table class="table">
				<tr>
					<th>상품명</th>
					<th>고객ID</th>
					<th>배송지</th>
					<th>상품수량</th>
					<th>총가격</th>
					<th>주문상태</th>
				</tr>
				<c:forEach var="o" items="${orderList }">
						<input type="hidden" name="orderCode" value="${o.orderCode}">
						<tr>
							<td>${o.goodsname }</td>
							<td>${o.customerId }</td>
							<td>${o.address }</td>
							<td>${o.orderQuantity }</td>
							<td><fmt:formatNumber value="${o.orderPrice}" pattern="#,###"/>원</td>
							<td>${o.orderState }</td>
						</tr>
				</c:forEach>
			</table>
        </div>
    </section>
 
    <!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>
</body>
</html>