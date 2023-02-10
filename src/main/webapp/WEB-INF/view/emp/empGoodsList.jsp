<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 관리자 전체상품 | 전통주의 모든것, 934마켓</title>
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
								<p class="card-title">상품 리스트</p>
								<div align="right">
									<button type="button" class="btn btn-light" >
										<a href="${pageContext.request.contextPath}/emp/empGoodsAdd">상품 추가</a>
									</button>
								</div><br>
								<div class="row">
									<div class="col-12">
										<div class="table-responsive">
											<table class="table table-striped table-borderless" style="width:100%">
												<tr>
													<c:forEach var="m" items="${list}" varStatus="s">
														<c:if test="${s.index != 0 && s.index % 7 == 0}">
															</tr><tr>
														</c:if>				
														<td>
															<c:if test="${m.soldout == 'Y'}">
																<div class="soldout">
																	<a href="${pageContext.request.contextPath}/emp/empGoodsOne?goodsCode=${m.goodsCode}">
																		<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250">
																	</a>
																	<p>${m.goodsName}</p>
																		<div value="${m.soldout}" class="soldout">품절</div>
																</div>
															</c:if>		
															<c:if test="${m.soldout == 'N'}">
																<div>
																	<a href="${pageContext.request.contextPath}/emp/empGoodsOne?goodsCode=${m.goodsCode}">
																		<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250">
																	</a>
																	<p>${m.goodsName}</p>
									
																</div>
															</c:if>						
														
															<a href="${pageContext.request.contextPath}/emp/empGoodsModify?goodsCode=${m.goodsCode}">수정</a>
														</td>
													</c:forEach>		
												</tr>
												<tr>
													<td colspan="7">
														<form method="get" action="${pageContext.request.contextPath}/emp/empGoodsList" id="searchForm">
															<c:if test="${goodsSearch != null}">
																<input class="box" type="text" name="goodsSearch" value="${goodsSearch}">
															</c:if>
															<c:if test="${goodsSearch == null}">
																<input class="box" type="text" name="goodsSearch" placeholder="상품명을 입력하세요.">
															</c:if>
															<button class="btn btn-light" type="button" id="searchFormBtn">검색</button>
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