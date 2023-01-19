<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 고객센터 문의내역 | 전통주의 모든것, 934마켓</title>

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
								<p class="card-title">고객 문의 리스트</p>
								<div class="row">
									<div class="col-12">
										<div class="table-responsive">
											<table class="table table-striped table-borderless" style="width:100%">
												<tr>
													<th>문의번호</th>
													<th>문의고객</th>
													<th>상품이름</th>
													<th>카테고리</th>
													<th>문의사항</th>
													<th>문의일자</th>
													<th>답변내용</th>
													<th>답변일자</th>
													<th>답변 작성/수정</th>
													
												</tr>
												<c:forEach var="q" items="${questionList }">
													<tr>
														<td style="text-align:center">${q.questionCode }</td>
														<td>${q.customerId }</td>
														<td>${q.goodsName }</td>
														<td style="text-align:center">${q.category }</td>
														<td>${q.questionMemo }</td>
														<td>${q.questionCreatedate }</td>
														
														<c:if test="${q.commentMemo != null}">
															<td>${q.commentMemo }</td>
															<td>${q.commentCreatedate }</td>
															<td><a href="${pageContext.request.contextPath}/emp/empQuestionModify?questionMemo=${q.questionMemo}&commentMemo=${q.commentMemo}&questionCode=${q.questionCode}">답변수정</a></td>
														</c:if>
														<c:if test="${q.commentMemo == null}">
															<td>답변 작성 필요</td>
															<td></td>
															<td><a href="${pageContext.request.contextPath}/emp/empQuestionAdd?questionCode=${q.questionCode}&questionMemo=${q.questionMemo}">답변작성</a></td>
														</c:if>
													</tr>
												</c:forEach>
												<tr><!-- 페이징 버튼 -->
													<td colspan="9" style="text-align:center">
														<c:if test="${currentPage == 1 }">
															<span>&nbsp;처음으로&nbsp;</span>
															<span>&nbsp;이전&nbsp;</span>
														</c:if>
														
														<c:if test="${currentPage != 1 }">
															<a href="${pageContext.request.contextPath}/emp/empQuestionList?firstPage=${firstPage}">&nbsp;처음으로&nbsp;</a>
															<a href="${pageContext.request.contextPath}/emp/empQuestionList?currentPage=${currentPage-1}">&nbsp;이전&nbsp;</a>
														</c:if>
														
															<span>[ ${currentPage} ]</span>
														
														<c:if test="${currentPage == lastPage }">
															<span>&nbsp;다음 &nbsp;</span>
															<span>&nbsp;마지막으로&nbsp;</span>
														</c:if>
														
														<c:if test="${currentPage != lastPage}">
															<a href="${pageContext.request.contextPath}/emp/empQuestionList?currentPage=${currentPage+1}">&nbsp;다음&nbsp;</a>
															<a href="${pageContext.request.contextPath}/emp/empQuestionList?lastPage=${lastPage}">&nbsp;마지막으로&nbsp;</a>
														</c:if>
													</td>
												</tr>		
												<tr><!-- 검색 -->
													<td colspan="9" style="text-align:center">
														<form action="${pageContext.request.contextPath}/emp/empQuestionList" method="get" id="searchForm">
															<input type="text" name="search" placeholder="고객 ID 검색">
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