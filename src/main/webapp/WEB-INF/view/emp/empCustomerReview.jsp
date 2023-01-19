<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 회원 리뷰 작성 내역 | 전통주의 모든것, 934마켓</title>

	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//검색
			$('#searchFormBtn').click(function()
			{
				$('#searchForm').submit();
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
								<p class="card-title">회원 리뷰 작성 내역</p>
								<div class="row">
									<div class="col-12">
										<div class="table-responsive">
											<table class="table table-striped table-borderless" style="width:100%">
												<tr>
													<th>주문번호</th>	
													<th>고객ID</th>	
													<th>상품명</th>	
													<th>리뷰내용</th>	
													<th>리뷰작성시간</th>	
													<th>리뷰업데이트 내용</th>	
													<th>리뷰업테이트 시간</th>	
												</tr>
												<c:forEach var="r" items="${reviewList }">
													<tr>
														<td>${r.orderCode }</td>
														<td>${r.customerId }</td>
														<td>${r.goodsname }</td>
														<td>${r.reviewMemo }</td>
														<td >${r.reviewDate }</td>
														<td >${r.pointKind }</td>
														<td>${r.pointDate}</td>
													</tr>
												</c:forEach>
												<tr><!-- 페이징 버튼 -->
													<td colspan="7" >
														<c:if test="${currentPage == 1 }">
															<span>&nbsp;처음으로&nbsp;</span>
															<span>&nbsp;이전&nbsp;</span>
														</c:if>
														
														<c:if test="${currentPage != 1 }">
															<a href="${pageContext.request.contextPath}/emp/empCustomerCancle?firstPage=${firstPage}">&nbsp;처음으로&nbsp;</a>
															<a href="${pageContext.request.contextPath}/emp/empCustomerCancle?currentPage=${currentPage-1}">&nbsp;이전&nbsp;</a>
														</c:if>
														
															<span>[ ${currentPage} ]</span>
														
														<c:if test="${currentPage == lastPage }">
															<span>&nbsp;다음 &nbsp;</span>
															<span>&nbsp;마지막으로&nbsp;</span>
														</c:if>
														
														<c:if test="${currentPage != lastPage}">
															<a href="${pageContext.request.contextPath}/emp/empCustomerCancle?currentPage=${currentPage+1}">&nbsp;다음&nbsp;</a>
															<a href="${pageContext.request.contextPath}/emp/empCustomerCancle?lastPage=${lastPage}">&nbsp;마지막으로&nbsp;</a>
														</c:if>
													</td>
												</tr>
												<tr><!-- 검색 -->
													<td colspan="7" >
														<form action="${pageContext.request.contextPath}/emp/empCustomerReviewList" method="get" id="searchForm">
															<input type="text" name="search" placeholder="고객 ID 검색" placeholder="고객 ID 검색">
															<button type="button" id="searchFormBtn" class="btn btn-light">검색</button>
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