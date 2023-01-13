<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 주문 내역</h1>
	
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		
		<table border="1">
			<tr>
				<td>상품명</td>
				<td>고객ID</td>
				<td>배송지</td>
				<td>상품수량</td>
				<td>총가격</td>
				<td>주문상태</td>
				<td>결제일자</td>
			</tr>
			<c:forEach var="o" items="${orderList }">
				<tr>
					<td>${o.goodsname }</td>
					<td>${o.customerId }</td>
					<td>${o.address }</td>
					<td>${o.orderQuantity }</td>
					<td>${o.orderPrice }</td>
					<td>
							<div>
									${o.orderState }
								
								<c:if test="${o.orderState != '구매확정' && o.orderState != '취소' && o.orderState != '배송완료'}">
									<form action="${pageContext.request.contextPath}/emp/empCustomerOrderStateModify" method="post">
										<input type="hidden" name="orderCode" value="${o.orderCode}">
										<select name="orderState">
											<option value="배송중">배송중</option>
											<option value="배송완료">배송완료</option>
										</select>
										<button type="submit">변경</button>
									</form>
								</c:if>
							</div>
					</td>
					<td>${o.createdate }</td>
				</tr>
			</c:forEach>
		</table>
	</table>
</body>
</html>