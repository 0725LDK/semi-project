<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 고객센터 답변 | 전통주의 모든것, 934마켓</title>
	
	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//문의사항 답변 수정 유효성 검사
			$('#modifyFormBtn').click(function()
					{
						if($('#commentMemo').val() == '')
						{
							alert('수정할 답변을 입력하세요');
							$('#commentMemo').focus();
							return;
						}
						
						$('#modifyForm').submit();
					});
			$('#modifyCancleBtn').click(function(){
				location.href = '${pageContext.request.contextPath}/emp/empQuestionList';
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
									<h4 class="card-title">고객센터 답변 수정</h4>
									<form class="forms-sample" action="${pageContext.request.contextPath}/emp/empQuestionModify" method="post" id="modifyForm">
										<table class="table table-striped table-borderless" style="width:100%">
											<tr>
												<td>문의 번호</td>	
												<td><input class="form-control" type="text" name="questionCode" value="${questionCode}" readonly="readonly"></td>
											</tr>
											<tr>
												<td>문의 내용</td>	
												<td><input class="form-control" type="text" name="questionMemo" value="${questionMemo}" readonly="readonly"></td>
											</tr>
											<tr>
												<td>기존 답변</td>	
												<td><input class="form-control" type="text" name="oldCommentMemo" value="${commentMemo}" readonly="readonly"></td>
											</tr>
											<tr>
												<td>수정 답변</td>	
												<td><input class="form-control" type="text" name="commentMemo" id="commentMemo"></td>
											</tr>
										</table>
										<div align="center">
											<button type="button" id="modifyFormBtn" class="btn btn-primary mr-2" >수정</button>
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