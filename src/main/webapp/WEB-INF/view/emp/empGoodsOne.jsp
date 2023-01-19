<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 상품 상세페이지 | 전통주의 모든것, 934마켓</title>
	
	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	
</head>
<body>
	<!-- partial:partials/main_navbar.html -->
	<div>
		<jsp:include page="/inc/empMainNavVar.jsp"></jsp:include>
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
								<p class="card-title">상품 상세 페이지</p>
								<div class="row">
									<div class="col-12">
										<div class="table-responsive">
											<table class="table table-striped table-borderless" style="width:100%">
												<tr>
													<td rowspan="11">
														<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="200" height="250">
													</td>
													<th>상품 주종 : </th>
													<td>${map.categoryName}</td>
												</tr>
												<tr>
													<th>상품 이름 : </th>
													<td>${map.goodsName}</td>
												</tr>
												<tr>
													<th>상품 가격 : </th>
													<td>${map.goodsPrice}원</td>
												</tr>
												<tr>
													<th>상품 설명 : </th>
													<td colspan="3">
														<div>${map.goodsContent}</div>
													</td>
												</tr>
												<tr>
													<th>상품 도수 : </th>
													<td>${map.goodsAlcohol}%</td>
												</tr>		
												<tr>
													<th>상품 용량 : </th>
													<td>${map.goodsLiter}ml</td>
												</tr>
												<tr>
													<th>상품 재고 : </th>
													<td>
														<c:if test="${map.soldout == 'Y'}">
															<span value="${map.soldout}">품절</span>
														</c:if>
														<c:if test="${map.soldout == 'N'}">
															<span value="${map.soldout}">재고 있음</span>
														</c:if>
													</td>
												</tr>		
												<tr>
													<th>직원 아이디 : </th>
													<td>${map.empId}</td>
												</tr>
												<tr>
													<th>베스트 상품 : </th>
													<td>
														<c:if test="${map.hit == '1'}">
															<span value="${map.hit}">베스트 상품</span>
														</c:if>
														<c:if test="${map.hit == '0'}">
															<span value="${map.hit}">일반 상품</span>
														</c:if>
													</td>
												</tr>
												<tr>
													<th>등록 일자 : </th>
													<td>${map.createdate}</td>
												</tr>
												<tr>
													<td colspan="2">
														<button type="button" class="btn btn-light">
															<a href="${pageContext.request.contextPath}/emp/empGoodsModify?goodsCode=${map.goodsCode}">수정</a>
														</button>
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