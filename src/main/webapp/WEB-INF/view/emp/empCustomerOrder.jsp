<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 회원 주문 내역 | 전통주의 모든것, 934마켓</title>
	
	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//배송 상태 변경
			$('#stateFormBtn').click(function()
			{
				$('#stateForm').submit();
			});
		});
	</script>
</head>
<body>
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
					<div class="col-md-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<p class="card-title">회원 주문 리스트</p>
								<div class="row">
									<div class="col-12">
										<div class="table-responsive">
											<table class="table table-striped table-borderless" style="width:100%">
												<tr>
													<th>상품명</th>
													<th>고객ID</th>
													<th>배송지</th>
													<th>상품수량</th>
													<th>총가격</th>
													<th>주문상태</th>
													<th>결제일자</th>
												</tr>
												<c:forEach var="o" items="${orderList }">
													<tr>
														<td>${o.goodsname }</td>
														<td>${o.customerId }</td>
														<td>${o.address }</td>
														<td >${o.orderQuantity }</td>
														<td >${o.orderPrice } 원</td>
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
												<tr><!-- 페이징 버튼 -->
													<td colspan="7" >
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
													</td>
												</tr>
												<tr><!-- 검색 -->
													<td colspan="7" >
														<form action="${pageContext.request.contextPath}/emp/empCustomerOrder" method="get">
															<input type="text" name="search" placeholder="고객 ID 검색">
															<button type="submit" class="btn btn-light">검색</button>
														</form>
													</td>
												</tr>
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
	
	<!-- CSS script -->
	<div>
		<jsp:include page="/inc/empFooterScript.jsp"></jsp:include>
	</div>

</body>
</html>