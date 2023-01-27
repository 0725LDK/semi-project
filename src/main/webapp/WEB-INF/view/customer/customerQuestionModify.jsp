<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link href="../resources/css/bootstrap.form.css" rel="stylesheet">
	<!-- 메인 네비메뉴 -->
	<jsp:include page="/inc/customerCss.jsp"></jsp:include>
	<title>934마켓 문의사항 수정 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<!-- 상단 네비메뉴 -->
	<div>
		<jsp:include page="/inc/mainNavMenu.jsp"></jsp:include>
	</div>	
	
	<!-- 카테고리 네비메뉴 -->
	<div>
	   <jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>   
	</div>   
	
	<!-- 문의사항 수정폼 -->  
	<main>
		<div class="container d-flex flex-column">
			<div class="row pt-5">
				<div class="col-lg-6 mx-auto d-table"><br><br>
					<div class="text-center">
						<h2>문의사항 수정하기</h2><br>
					</div>
					<div class="card">
						<div class="card-body">
							<div class="m-sm-3 text-center">
								<form onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerQuestionModify" method="post">
									<table style="width:500px;">
										<tr>
											<td>문의번호</td>
											<td><input type="text" name="questionCode" value="${questionCode }" readonly="readonly" class="form-control"></td>
										</tr>
										<tr>
											<td>문의상품</td>
											<td><input type="text" name="ordersCode" value="${ordersCode }" readonly="readonly" class="form-control"></td>
										</tr>
										<tr>
											<td>카테고리</td>
											<td><input type="text" name="category" value="${category}" readonly="readonly" class="form-control"></td>
										</tr>
										<tr>
											<td>문의내용</td>
											<td><textarea rows="4" cols="40" id="questionMemo" name="questionMemo" class="form-control">${questionMemo}</textarea></td>
										</tr>
									</table>
									<button type="submit" class="primary-btn border-0" style="width:300px;">수정하기</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<br><br><br><br><br><br>
	
   	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>
</body>
<script>
	function check() {
		if($('#questionMemo').val() == '') {
			alert("수정할 내용을 입력해주세요");
			$('#questionMemo').focus();
			return false;
		}
	}
</script>
</html>