<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 이벤트 상세보기 | 전통주의 모든것, 934마켓</title>
	
	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//직원 삭제시 확인 alert
			$('#delete').click(function() {
		        var result = confirm('정말로 이벤트를 삭제하시겠습니까?');

		        if(result) {
		           //yes
		           location.replace('${pageContext.request.contextPath}/emp/empNoticeList');
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
								<p class="card-title">이벤트 상세보기</p>
								<div class="row">
									<div class="col-12">
										<div class="table-responsive">
											<table class="table table-striped table-borderless" style="width:100%">
												<tr>
													<td rowspan="10">
														<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="1000" height="300">
													</td>
													<th>이벤트 카테고리 : </th>
													<td>${map.goodsCategory}</td>
												</tr>
												<tr>
													<th>공지 제목 : </th>
													<td>${map.noticeTitle}</td>
												</tr>
												<tr>
													<th>공지 내용 : </th>
													<td>${map.noticeContent}</td>
												</tr>		
												<tr>
													<th>직원 아이디 : </th>
													<td>${map.empId}</td>
												</tr>
												<tr>
													<th>등록 일자 : </th>
													<td>${map.createdate}</td>
												</tr>
											</table><br>

											<div align="center">
												<button class="btn btn-light" type="button">
													<a href="${pageContext.request.contextPath}/emp/empNoticeModify?noticeCode=${map.noticeCode}">수정</a>
												</button>
												<button class="btn btn-light" type="button" id="delete">
													<a href="${pageContext.request.contextPath}/emp/empNoticeRemove?noticeCode=${map.noticeCode}">삭제</a>
												</button>
											</div>
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