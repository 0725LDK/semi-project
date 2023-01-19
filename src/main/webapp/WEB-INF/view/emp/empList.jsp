<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 직원 리스트 | 전통주의 모든것, 934마켓</title>

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
			
			$('#delete').click(function() {
		        var result = confirm('정말로 직원 계정을 삭제하시겠습니까?');

		        if(result) {
		           //yes
		           location.replace('${pageContext.request.contextPath}/emp/empList');
		           alert('삭제되었습니다.');
		        } else {
		            //no
		            return false;
		        }
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
								<p class="card-title">직원 리스트</p>
								<div class="row">
									<div class="col-12">
										<div class="table-responsive">
											<table class="table table-striped table-borderless" style="width:100%">
												<tr>
													<th>직원 번호</th>	
													<th>직원 ID</th>	
													<th>직원 이름</th>	
													<th>계정 활성 유무</th>	
													<th>관리자 레벨</th>	
													<th>입사 일자</th>	
													<th>수정</th>
													<th>삭제</th>
														
												</tr>
												<c:forEach var="e" items="${list}">
													<tr>
														<td>${e.empCode}</td>
														<td>${e.empId}</td>
														<td>${e.empName}</td>
														<td>${e.active}</td>
														<td>${e.authCode}</td>
														<td>${e.createdate}</td><!-- 직원 등록 일자 -->
														<td><a href="${pageContext.request.contextPath}/emp/empModify?empCode=${e.empCode}&empId=${e.empId}&empName=${e.empName}">수정</a></td>
														<td><a href="${pageContext.request.contextPath}/emp/empRemove?empCode=${e.empCode}&empId=${e.empId}" id="delete">삭제</a></td>
													</tr>
												</c:forEach>
												<tr><!-- 페이징 버튼 -->
													<td colspan="8" >
														<c:if test="${currentPage == 1 }">
															<span>&nbsp;처음으로&nbsp;</span>
															<span>&nbsp;이전&nbsp;</span>
														</c:if>
														
														<c:if test="${currentPage != 1 }">
															<a href="${pageContext.request.contextPath}/emp/empList?firstPage=${firstPage}">&nbsp;처음으로&nbsp;</a>
															<a href="${pageContext.request.contextPath}/emp/empList?currentPage=${currentPage-1}">&nbsp;이전&nbsp;</a>
														</c:if>
														
															<span>[ ${currentPage} ]</span>
														
														<c:if test="${currentPage == lastPage }">
															<span>&nbsp;다음 &nbsp;</span>
															<span>&nbsp;마지막으로&nbsp;</span>
														</c:if>
														
														<c:if test="${currentPage != lastPage}">
															<a href="${pageContext.request.contextPath}/emp/empList?currentPage=${currentPage+1}">&nbsp;다음&nbsp;</a>
															<a href="${pageContext.request.contextPath}/emp/empList?lastPage=${lastPage}">&nbsp;마지막으로&nbsp;</a>
														</c:if>
													</td>
												</tr>
												<tr><!-- 검색 -->
													<td colspan="8" >
														<form action="${pageContext.request.contextPath}/emp/empList" method="get" id="searchForm">
															<input type="text" name="search" placeholder="직원 ID 검색">
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