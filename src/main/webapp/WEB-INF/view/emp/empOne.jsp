<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 관리자 메인 페이지 | 전통주의 모든것, 934마켓</title>
	
	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$.fn.dataTable.ext.errMode = 'throw';
	</script>
</head>
<body>
	<div class="container-scroller">
		
		<!-- partial:partials/main_navbar.html -->
		<div>
			<jsp:include page="/inc/empMainNavVar.jsp"></jsp:include>]
		</div>
		
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			
			<!-- partial:partials/_sidebar.html -->
			<div>
				<jsp:include page="/inc/empSideBar.jsp"></jsp:include>
			</div>
			
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-md-7 grid-margin stretch-card">
							 <div class="card">
								 <div class="card-body">
								 	<a href="${pageContext.request.contextPath}/emp/empCustomerList">
								 		<p class="card-title mb-0">고객 리스트</p>
								 	</a>
								 	<div class="table-responsive">
										 <table class="table table-striped table-borderless">
										 	<tr>
												<td>회원 번호</td>
												<td>회원 ID</td>
												<td>회원 이름</td>
												<td>주소</td>
												<td>보유 포인트</td>
												<td>가입 일자</td>
											</tr>
											<c:forEach var="c" items="${customerList}">
												<tr>
													<td>${c.customerCode}</td>
													<td>${c.customerId}</td>
													<td>${c.customerName}</td>
													<td>${c.address}</td>
													<td>${c.point}</td>
													<td>${c.createdate}</td>
												</tr>
											</c:forEach>		
							 			</table>
									</div>
								 </div>       
							</div>
						</div>
						<div class="col-md-5 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<a href="${pageContext.request.contextPath}/emp/empSum">
										<p class="card-title mb-0">주류별  구매 데이터</p>
									</a>
									<div class="table-responsive">
										<table class="table table-striped table-borderless">
										 	<tr>
												<td>주류</td>
												<td>판매액</td>
												<td>판매건수</td>
											</tr>
											<c:forEach var="s" items="${sumByCategory }">
												<tr>
													<td>
														<c:if test="${s.goodsCategory == 1}">
															탁주
														</c:if>
														<c:if test="${s.goodsCategory == 2}">
															청주
														</c:if>
														<c:if test="${s.goodsCategory == 3}">
															과실주
														</c:if>
														<c:if test="${s.goodsCategory == 4}">
															증류주
														</c:if>
														<c:if test="${s.goodsCategory == 5}">
															이벤트1-막쿠르트
														</c:if>
														<c:if test="${s.goodsCategory == 6}">
															이벤트2-설 프로모션
														</c:if>
														<c:if test="${s.goodsCategory == 7}">
															이벤트3-설 선물set
														</c:if>
													</td>
													<td>${s.sumByCategory }원</td>
													<td>${s.categoryCount }건</td>
												</tr>
											</c:forEach>
							 			</table>
									</div>
								</div>       
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<a href="${pageContext.request.contextPath}/emp/empCustomerOrder">
										<p class="card-title">고객 주문 내역</p>
									</a>
									<div class="row">
										<div class="col-12">
											<div class="table-responsive">
												<table class="table table-striped table-borderless" style="width:100%">
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
																		<form action="${pageContext.request.contextPath}/emp/empCustomerOrderStateModify" method="post" id="stateForm">
																			<input type="hidden" name="orderCode" value="${o.orderCode}">
																			<input type="hidden" name="currentPage" value="${currentPage}">
																			<select name="orderState">
																				<option value="배송중">배송중</option>
																				<option value="배송완료">배송완료</option>
																			</select>
																			<button type="button" id="stateFormBtn">변경</button>
																		</form>
																	</c:if>
																</div>
															</td>
															<td>${o.createdate }</td>
														</tr>
													</c:forEach>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
		            </div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<div>
					<jsp:include page="/inc/empCopyright.jsp"></jsp:include>
				</div>
			<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>   
	    <!-- page-body-wrapper ends -->
	</div>
	
	<!-- CSS script -->
	<div>
		<jsp:include page="/inc/empFooterScript.jsp"></jsp:include>
	</div>
</body>
</html>