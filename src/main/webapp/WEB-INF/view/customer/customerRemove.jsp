<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link href="../resources/css/bootstrap.form.css" rel="stylesheet">
	<title>934마켓 회원 탈퇴 | 전통주의 모든것, 934마켓</title>
</head>
<body>
<main>
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-lg-6 mx-auto d-table">
				<div class="card">
					<div class="card-header text-center">
						<h2>회원탈퇴</h2>
					</div>
					<div class="card-body">
						<div class="m-sm-3 text-center">
							<form onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerRemove" method="post">
								<table style="width:500px;">
									<tr>
										<td>계정명 </td>
										<td><input type="text" name="customerId" value="${loginCustomer.customerId}" readonly="readonly" class="form-control"></td>
									</tr>
									<tr>
										<td>비밀번호 </td>
										<td><input type="password" name="customerPw" class="form-control"></td>
									</tr>
								</table>
								<button type="submit" class="btn btn-success" style="width:300px;">탈퇴하기</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
</body>
<script>
	function check() {
		if($('#customerPw').val() == '') {
			alert("비밀번호를 입력해주세요");
			$('#customerPw').focus();
			return false;
		}
	}
</script>
</html>