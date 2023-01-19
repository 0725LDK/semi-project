<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="../resources/css/bootstrap.form.css" rel="stylesheet">
<title>934마켓 회원 정보 수정 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<!-- 회원정보 -->
	<main>
		<div class="container d-flex flex-column">
			<div class="row pt-5">
				<div class="col-lg-6 mx-auto d-table">
					<div class="card">
						<div class="card-header text-center">
							<h2>회원정보(수정)</h2>
						</div>
						<div class="card-body">
							<div class="m-sm-3 text-center">
								<form onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerModify" method="post">
									<table style="width:500px;">
										<tr>
											<td>계정명</td>
											<td><input type="text" name="customerId" value="${loginCustomer.customerId}" readonly="readonly" class="form-control"></td>
										</tr>
										<tr>
											<td>이름</td>
											<td><input type="text" id="customerName" name="customerName" value="${loginCustomer.customerName}" class="form-control"></td>
										</tr>
										<tr>
											<td>비밀번호</td>
											<td><input type="password" id="customerPw" name="customerPw" class="form-control"></td>
										</tr>
										<tr>
											<td>변경할 비밀번호</td>
											<td><input type="password" id="newPw" name="newPw" class="form-control"></td>
										</tr>
										<tr>
											<td>변경할 비밀번호 확인</td>
											<td><input type="password" id="newPwCk" name="newPwCk" class="form-control"></td>
										</tr>
										<tr>
											<td>휴대폰</td>
											<td><input type="text" id="customerPhone" oninput="autoHyphen(this)" name="customerPhone" value="${loginCustomer.customerPhone}" class="form-control"></td>
										</tr>
									</table>
									<button type="submit" class="btn btn-success" style="width:300px;">변경하기</button>
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
	//전화번호 입력시 - 자동입력 (000-0000-0000), 숫자만 입력가능
	const autoHyphen = (target) => {
		target.value = target.value
		.replace(/[^0-9]/g, '')
		.replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
	}
	// 버튼클릭시 유효성검사
	function check() {
		let getCheck = RegExp(/^[A-Za-z0-9]{4,12}$/); //영문대소문자,숫자 4~12자리만 가능

		// 이름 공백확인
		if($('#customerName').val() == '') {
			alert("이름을 입력해주세요");
			$('#customerName').focus();
			return false;
		}
		
		// 비밀번호 공백확인
		if($('#customerPw').val() == '') {
			alert("비밀번호를 입력해주세요");
			$('#customerPw').focus();
			return false;
		}
		// 변경할 비밀번호 공백확인
		if($('#newPw').val() == '') {
			alert("변경할 비밀번호를 입력해주세요");
			$('#newPw').focus();
			return false;
		}
		// 변경할 비밀번호 영문대소문자,숫자 4~12자리만 가능 확인
		if(!getCheck.test($('#newPw').val())) {
			alert("비밀번호는 4~12자리의 영문 대소문자와 숫자로만 입력 가능합니다");
			$('#newPw').val('');
			$('#newPwCk').val('');
			$('#newPw').focus();
			return false;
		}
		// 현재비밀번호, 변경할비밀번호 일치확인
		if($('#customerPw').val() == $('#newPw').val()) {
			alert("현재비밀번호와 변경할비밀번호가 같습니다");
			$('#newPw').val('');
			$('#newPwCk').val('');
			$('#newPw').focus();
			return false;
		}
		// 변경할 비밀번호 일치 확인
		if($('#newPw').val() != $('#newPwCk').val()) {
			alert("변경할 비밀번호가 다릅니다");
			$('#newPw').val('');
			$('#newPwCk').val('');
			$('#newPw').focus();
			return false;
		}
		// 전화번호 공백확인
		if($('#customerPhone').val() == '') {
			alert("전화번호를 입력해주세요");
			$('#customerPhone').val('');
			$('#customerPhone').focus();
			return false;
		}
	}
</script>
</html>