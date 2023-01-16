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
	
	<!-- 검색 기능 -->
	<div>
		<form action="${pageContext.request.contextPath}/emp/empCustomerOrder" method="get">
			<span>고객 ID 검색 : </span>
			<input type="text" name="search">
			<button type="submit">검색</button>
		</form>
	</div>
	
	<!-- 페이징 버튼 -->
	<div>
		<c:if test="${currentPage == 1 }">
			<span>처음으로</span>
			<span>이전</span>
		</c:if>
		
		<c:if test="${currentPage != 1 }">
			<a href="${pageContext.request.contextPath}/emp/empCustomerOrder?firstPage=${firstPage}">처음으로</a>
			<a href="${pageContext.request.contextPath}/emp/empCustomerOrder?currentPage=${currentPage-1}">이전</a>
		</c:if>
		
			<span>${currentPage}</span>
		
		<c:if test="${currentPage == lastPage }">
			<span>다음</span>
			<span>마지막으로</span>
		</c:if>
		
		<c:if test="${currentPage != lastPage}">
			<a href="${pageContext.request.contextPath}/emp/empCustomerOrder?currentPage=${currentPage+1}">다음</a>
			<a href="${pageContext.request.contextPath}/emp/empCustomerOrder?lastPage=${lastPage}">마지막으로</a>
		</c:if>
	</div>
</body>
</html>