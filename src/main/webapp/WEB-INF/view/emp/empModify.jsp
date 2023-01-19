<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 직원 정보 수정 | 전통주의 모든것, 934마켓</title>

	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//직원정보 수정 유효성 검사
			$('#empModifyFormBtn').click(function()
					{
						if($('#empName').val() == '')
						{
							alert('이름을 입력하세요');
							$('#empName').focus();
							return;
						}
						$('#empModifyForm').submit();
					});
			$('#modifyCancleBtn').click(function(){
				location.href = '${pageContext.request.contextPath}/emp/empList';
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
									<h4 class="card-title">직원 정보 수정</h4>
									<form class="forms-sample" action="${pageContext.request.contextPath}/emp/empModify" method="post"  id="empModifyForm">
										<div class="form-group">
											<label for="exampleInputName1">직원 번호</label>
											<input type="text" class="form-control" name="empCode" value="${empCode }" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputName1">직원 ID</label>
											<input type="text" class="form-control" name="empId" value="${empId }" readonly="readonly">
										</div>
										<div class="form-group">
											<label for="exampleInputName1">직원 이름</label>
											<input type="text" class="form-control"  name="empName" value="${empName }" id="empName">
										</div>
										<div class="form-group">
											<label for="exampleSelectGender">계정 활성 유무</label>
											<select class="form-control" name="active">
												<option value="Y">활성화</option>
												<option value="N">비활성화</option>
											</select>
										</div>
										<div class="form-group">
											<label for="exampleSelectGender">관리자 레벨</label>
											<select class="form-control" name="authCode">
												<option value="0">0-관리자</option>
												<option value="1">1-상품관리</option>
												<option value="2">2-고객관리</option>
											</select>
										</div>
										<div align="center">
											<button type="button" id="empModifyFormBtn" class="btn btn-primary mr-2">수정</button>
											<button type="button" id="modifyCancleBtn" class="btn btn-light">취소</button>
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