<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 이벤트 수정 | 전통주의 모든것, 934마켓</title>

	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//이벤트 수정시 유효성 검사
			$('#eventModifyFormBtn').click(function()
					{
						if($('#noticeTitle').val() == '')
						{
							alert('수정할 이벤트 제목을 입력하세요');
							$('#noticeTitle').focus();
							return;
						}
						if($('#noticeContent').val() == '')
						{
							alert('수정할 이벤트 내용을 입력하세요');
							$('#noticeContent').focus();
							return;
						}
						
						$('#eventModifyForm').submit();
					});
			
			$('#modifyCancleBtn').click(function(){
				location.href = '${pageContext.request.contextPath}/emp/empNoticeList';
			});
		});
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
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">이벤트 수정</h4>
									<form class="forms-sample" action="${pageContext.request.contextPath}/emp/empNoticeModify" method="post" enctype="multipart/form-data" id="eventModifyForm">
										<table class="table table-striped table-borderless" style="width:100%">
											<tr>
												<td rowspan="10">
													<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="1000" height="300">
												</td>		
											</tr>
										</table>
										<table class="table table-striped table-borderless" style="width:100%">
											<tr>			
												<td>번호</td>	
												<td><input  class="form-control" type="number" name="noticeCode" value="${map.noticeCode}" readonly="readonly"></td>
											</tr>
											<tr>	
												<td>이벤트 상품 카테고리</td>	
												<td>
													<select  class="form-control" name="goodsCategory">
														<option value="${map.goodsCategory}">카테고리를 선택하세요.</option>
														<option value="5">이벤트1</option>
														<option value="6">이벤트2</option>
														<option value="7">이벤트3</option>
													</select>
												</td>
											</tr>
											<tr>
												<td>이벤트 제목</td>
												<td><input class="form-control" type="text" name="noticeTitle" value="${map.noticeTitle}" id="noticeTitle"></td>
											</tr>
											<tr>		
												<td>이벤트 내용</td>	
												<td><input class="form-control" type="text" name="noticeContent" value="${map.noticeContent}" id="noticeContent"></td>
											</tr>
											<tr>	
												<td>등록 직원</td>	
												<td><input class="form-control" type="text" name="empId" value="${map.empId}"></td>
											</tr>
											<tr>
												<td>상품이미지 변경</td>	
												<td>
													<input  class="form-control" type="file" name="goodsImg">
												</td>
											</tr>
										</table>
										<div align="center">
											<button class="btn btn-primary mr-2" type="button" id="eventModifyFormBtn">수정</button>
											<button class="btn btn-primary mr-2" type="button" id="modifyCancleBtn">취소</button>
										</div>
									</form>
									
								</div>
							</div>
						</div>
					</div>
				</div>
					<!-- partial:partials/_footer.html -->
				<div>
					<jsp:include page="/inc/empCopyright.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
	
	<!-- CSS script -->
	<div>
		<jsp:include page="/inc/empFooterScript.jsp"></jsp:include>
	</div>
	
</body>
</html>