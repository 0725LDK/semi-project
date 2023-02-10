<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="../resources/css/bootstrap.form.css" rel="stylesheet">
<title>934마켓 직원 회원가입 | 전통주의 모든것, 934마켓</title>
<style>
	table {
		width: 500px;
	}
</style>
</head>
<body>
<main>	
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-lg-6 mx-auto d-table">
				<div class="card">
					<div class="card-header text-center">
					<h3>
						<a href="${pageContext.request.contextPath}/home/main">
					    	<img src="${pageContext.request.contextPath}/resources/img/m.png" alt="" width="150" height="60">
					 	</a>  
					</h3> 	 
					</div>
					<div class="card-body">
						<div class="m-sm-3 text-center">					
							<form method="post" onsubmit="return check()" action="${pageContext.request.contextPath}/emp/empAdd" >
								<table>
									<tr>
										<td>아이디</td>
										<td><input type="text" name="empId" id="empId" class="form-control"></td>
									</tr>
									<tr>
										<td>비밀번호</td>
										<td><input type="password" name="empPw" id="empPw" class="form-control"></td>
									</tr>
									<tr>
										<td>비밀번호 확인</td>
										<td><input type="password" name="pwCheck" id="pwCheck" class="form-control"></td>
									</tr>
									<tr>
										<td>이름</td>
										<td><input type="text" name="empName" id="empName" class="form-control"></td>
									</tr>
								</table>
								<br>
								<button type="submit" class="btn btn-primary" style="width:300px;">직원 회원가입</button>
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
// 회원가입 버튼 누르면 확인
function check() {
	let getCheck = RegExp(/^[A-Za-z0-9]{4,12}$/); //영문대소문자,숫자 4~12자리만 가능
	
	// 아이디 공백확인
	if($('#empId').val() == '') {
		alert("아이디를 입력해주세요");
		$('#empId').focus();
		return false;
	}
	// 아이디 영문대소문자,숫자 4~12자리만 가능 확인
	if(!getCheck.test($('#empId').val())) {
		alert("아이디는 4~12자리의 영문 대소문자와 숫자로만 입력 가능합니다");
		$('#empId').val('');
		$('#empId').focus();
		return false;
	}
	
	// 비밀번호 공백확인
	if($('#empPw').val() == '' || $('#pwCheck').val() == '') {
		alert("비밀번호를 입력해주세요");
		$('#empPw').focus();
		return false;
	}
	// 비밀번호 영문대소문자,숫자 4~12자리만 가능 확인
	if(!getCheck.test($('#empPw').val())) {
		alert("비밀번호는 4~12자리의 영문 대소문자와 숫자로만 입력 가능합니다");
		$('#empPw').val('');
		$('#pwCheck').val('');
		$('#empPw').focus();
		return false;
	}
	// 비밀번호 확인 check
	if($('#empPw').val() != ($('#pwCheck').val())) {
		alert("비밀번호가 다릅니다");
		$('#empPw').val('');
		$('#pwCheck').val('');
		$('#empPw').focus();
		return false;
	}
	
	// 이름 공백확인
	if($('#empName').val() == '') {
		alert("이름을 입력해주세요");
		$('#empName').focus();
		return false;
	}

}
</script>
</html>