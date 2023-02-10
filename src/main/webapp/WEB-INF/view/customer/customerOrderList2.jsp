<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>934마켓 주문내역 | 전통주의 모든것, 934마켓</title>
	<!-- 메인 네비메뉴 -->
	<jsp:include page="/inc/customerCss.jsp"></jsp:include>
	<style>
		table, td {
			height: 80px;
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
 
    <!-- 고객 주문 리스트 -->
    <div class="text-center">
		<br><h2>주문내역</h2>
	</div>
    <section class="shoping-cart spad">
        <div class="container">
            <table class="table">
				<tr>
					<th style="width:150px;">상품명</th>
					<th>고객ID</th>
					<th>배송지</th>
					<th>수량</th>
					<th>총가격</th>
					<th style="width:260px;">주문상태</th>
					<th>결제일자</th>
					<th>문의하기</th>
				</tr>
				<c:forEach var="o" items="${orderList }">
					<input type="hidden" name="orderCode" value="${o.orderCode}">
					<tr>
						<td>${o.goodsname }</td>
						<td>${o.customerId }</td>
						<td>${o.address }</td>
						<td>${o.orderQuantity }</td>
						<td><fmt:formatNumber value="${o.orderPrice}" pattern="#,###"/>원</td>
						<td>
							${o.orderState }
							<c:if test="${o.orderState == '배송완료'}">
								<a href="${pageContext.request.contextPath}/customer/customerOrderStateModify?orderState=구매확정&orderCode=${o.orderCode}&customerId=${customerId}">구매확정</a>
							</c:if>
							
							<c:if test="${o.orderState != '배송완료' && o.orderState != '구매확정'}">
								<a href="${pageContext.request.contextPath}/customer/customerOrderCancle?orderCode=${o.orderCode}" id="orderCancle">구매취소</a>
							</c:if>
							
							<c:if test="${o.orderState == '구매확정'}">
								<div>
									<c:if test="${o.reviewMemo eq null}">
										<c:if test="${o.rhistoryMemo eq null }">
											<form onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerReviewAdd" method="get">
												<input type="hidden" name="orderCode" value="${o.orderCode}">
												리뷰작성<input type="text" id="reviewMemo" name="reviewMemo">
												<button type="submit" class="border-0">작성</button>
											</form>
										</c:if>
										<c:if test="${o.rhistoryMemo ne null }">
											<span>삭제된 리뷰-재작성 불가</span>
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
						<td><a href="${pageContext.request.contextPath}/customer/customerQuestionAdd?ordersCode=${o.orderCode}">문의등록</a></td>
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
<script>
	function check() {
		// 리뷰내용 공백확인
		if($('#reviewMemo').val() == '') {
			alert("내용을 입력해주세요");
			$('#reviewMemo').focus();
			return false;
		}
	}
	function check() {
		// 포인트 구매시
		if($('#orderCancle').val() == '') {
			alert("포인트 구매후 주문취소시 포인트는 반환되지 않습니다");
			$('#orderCancle').focus();
			return false;
		}
	}
</script>
</html>