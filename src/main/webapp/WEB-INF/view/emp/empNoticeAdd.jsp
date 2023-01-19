<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 이벤트 추가 | 전통주의 모든것, 934마켓</title>
	
	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//이벤트 등록시 유효성 검사
			$('#eventAddFormBtn').click(function()
					{
						if($('#noticeTitle').val() == '')
						{
							alert('이벤트 제목을 입력하세요');
							$('#noticeTitle').focus();
							return;
						}
						if($('#noticeContent').val() == '')
						{
							alert('이벤트 내용을 입력하세요');
							$('#noticeContent').focus();
							return;
						}
						$('#eventAddForm').submit();
					});
			$('#addCancleBtn').click(function(){
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
								<h4 class="card-title">이벤트 추가</h4>
								<form class="forms-sample" action="${pageContext.request.contextPath}/emp/empNoticeAdd" method="post" enctype="multipart/form-data" id="eventAddForm">
									<table class="table table-striped table-borderless" style="width:100%">
										<tr>
											<th>해당 공지 상품 카테고리 : </th>
											<td>
												<select name="goodsCategory" class="form-control">
													<option value="${map.goodsCategory}">카테고리를 선택하세요</option>
													<option value="5">이벤트1</option>		
													<option value="6">이벤트2</option>		
													<option value="7">이벤트3</option>		
												</select>
											</td>
										</tr>
										<tr>
											<th>공지 제목 : </th>
											<td>
												<input class="form-control" type="text" name="noticeTitle" id="noticeTitle">
											</td>
										</tr>
										<tr>
											<th>공지 내용 : </th>
											<td>
												<textarea class="form-control" name="noticeContent" rows="10" cols="50" id="noticeContent"></textarea>
											</td>
										</tr>
									
										<tr>
											<th>직원 아이디 : </th>
											<td>
												<input class="form-control" type="text" name="empId" value="${empIdNow }">
											</td>
										</tr>
										<tr>
											<th>상품 이미지 : </th>
											<td>
												<input class="form-control" type="file" name="noticeImg" >
											</td>
										</tr>
									</table><br>
									<div align="center">
										<button type="button" id="eventAddFormBtn" class="btn btn-primary mr-2" >상품등록</button>
										<button type="button" id="addCancleBtn" class="btn btn-light" >취소</button>
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