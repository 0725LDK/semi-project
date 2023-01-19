<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 문의사항 답변작성 | 전통주의 모든것, 934마켓</title>

	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//문의사항 답변 유효성 검사
			$('#answerFormBtn').click(function()
					{
						if($('#commentMemo').val() == '')
						{
							alert('답변사항을 입력하세요');
							$('#commentMemo').focus();
							return;
						}
						
						$('#answerForm').submit();
					});
		
		$('#cancleBtn').click(function(){
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
									<h4 class="card-title">고객 문의사항 답변</h4>
									<form class="forms-sample" action="${pageContext.request.contextPath}/emp/empQuestionAdd" method="post" id="answerForm">
										<div>
											<label for="exampleInputName1">문의번호</label>
											<input class="form-control" type="text" name="questionCode" value="${questionCode}" readonly="readonly">
										</div><br>
										<div>
											<label for="exampleInputName1">문의사항</label>
											<input class="form-control" type="text" name="questionMemo" value="${questionMemo}" readonly="readonly">
										</div><br>
										<div>
											<label for="exampleInputName1">답변 내용 작성</label>
											<input class="form-control" type="text" name="commentMemo" id="commentMemo">
										</div><br>
										<div align="center">
											<button class="btn btn-primary mr-2" type="button" name="answerFormBtn" id="answerFormBtn">답변 작성</button>
											<button class="btn btn-light" type="button" id="cancleBtn" >취소</button>
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
	


















	<h1>문의사항 답변작성</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<form action="${pageContext.request.contextPath}/emp/empQuestionAdd" method="post" id="answerForm">
		<div>
			<label>문의번호</label>
			<input type="text" name="questionCode" value="${questionCode}" readonly="readonly">
		</div>
		<div>
			<label>문의사항</label>
			<input type="text" name="questionMemo" value="${questionMemo}" readonly="readonly">
		</div>
		<div>
			<label>답변 내용 작성</label>
			<input type="text" name="commentMemo" id="commentMemo">
		</div>
		<button type="submit" name="answerFormBtn" id="answerFormBtn">답변 작성</button>
	</form>

</body>
</html>