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
	<h1>주문내역</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
		<table border="1">
			<tr>
				<td>상품명</td>
				<td>고객ID</td>
				<td>배송지</td>
				<td>상품수량</td>
				<td>총가격</td>
				<td>주문상태</td>
				<td>결제일자</td>
				<td>고객센터 문의하기</td>
			</tr>
			<c:forEach var="o" items="${orderList }">
				<input type="hidden" name="orderCode" value="${o.orderCode}">
				<tr>
					<td>${o.goodsname }</td>
					<td>${o.customerId }</td>
					<td>${o.address }</td>
					<td>${o.orderQuantity }</td>
					<td>${o.orderPrice }</td>
					<td>
							${o.orderState }
							<c:if test="${o.orderState == '배송완료'}">
								<a href="${pageContext.request.contextPath}/customer/customerOrderStateModify?orderState=구매확정&orderCode=${o.orderCode}&customerId=${customerId}">구매확정</a>
							</c:if>
							
							<c:if test="${o.orderState != '배송완료' && o.orderState != '구매확정'}">
								<a href="${pageContext.request.contextPath}/customer/customerOrderCancle?orderCode=${o.orderCode}">구매취소</a>
							</c:if>
							
							<c:if test="${o.orderState == '구매확정'}">
								<div>
										<c:if test="${empty o.reviewMemo}">
											<c:if test="${empty o.pointKind || empty o.pointCode}">
												<form action="${pageContext.request.contextPath}/customer/customerReviewAdd" method="get">
													<input type="hidden" name="orderCode" value="${o.orderCode}">
													리뷰작성 : <input type="text" name="reviewMemo">
													<button type="submit">작성</button>
												</form>
											</c:if>
											<c:if test="${not empty o.pointCode && not empty o.pointKind}">
												리뷰 삭제됨..재입력 불가
											</c:if>
										</c:if>
										
										<c:if test="${not empty o.reviewMemo}">
											작성한 리뷰 : ${o.reviewMemo}
											<a href="${pageContext.request.contextPath}/customer/customerReviewRemove?orderCode=${o.orderCode}&noAdd=1">삭제</a>
										</c:if>
								</div>
							</c:if>
					</td>
					<td>${o.createdate }</td>
					<td><a href="${pageContext.request.contextPath}/customer/customerQuestionAdd?ordersCode=1">문의등록</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>