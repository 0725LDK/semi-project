<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 통계데이터 | 전통주의 모든것, 934마켓</title>
	
	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	
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
						<div class="col-md-5 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<a href="${pageContext.request.contextPath}/emp/empSum">
										<p class="card-title mb-0">주류별  구매 데이터</p>
									</a><br>
									<div class="table-responsive">
										<table class="table table-striped table-borderless">
										 	<tr>
												<th>주류</th>
												<th>판매액</th>
												<th>판매건수</th>
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
													<td style="text-align: center">${s.categoryCount }건</td>
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
										<p class="card-title mb-0">접속 데이터</p>
									</a><br>
									<div class="table-responsive">
										<table class="table table-striped table-borderless">
											<tr>
												<td>현재 접속자수 : ${currentCount }</td>
											</tr>
											<tr>
												<td>오늘 접속자수 : ${todayCount }</td>
											</tr>
											<tr>
												<td>누적 접속자수 : ${totalCount}</td>
											</tr>
										</table>
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