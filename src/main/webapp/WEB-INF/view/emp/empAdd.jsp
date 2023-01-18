<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 직원 회원 가입 | 전통주의 모든것, 934마켓</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		//회원가입시 유효성 검사
		$('#empAddFormBtn').click(function()
				{
					if($('#empId').val() == '')
					{
						alert('아이디를 입력하세요');
						$('#empId').focus();
						return;
					}
					if($('#empPw').val() == '')
					{
						alert('비밀번호를 입력하세요');
						$('#empPw').focus();
						return;
					}
					if($('#pwCheck').val() == '')
					{
						alert('비밀번호를 입력하세요');
						$('#pwCheck').focus();
						return;
					}
					if($('#empPw').val() != $('#pwCheck').val())
					{
						alert('비밀번호가 맞지 않습니다');
						$('#empPw').focus();
						return;
					}
					if($('#empName').val() == '')
					{
						alert('사용할 이름를 입력하세요');
						$('#empName').focus();
						return;
					}
					$('#empAddForm').submit();
				});
	});
</script>
</head>
<body>
	<h1>직원 회원 가입</h1>
	<form method="post" action="${pageContext.request.contextPath}/emp/empAdd" id="empAddForm">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="empId" id="empId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="empPw" id="empPw"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="pwCheck" id="pwCheck"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="empName" id="empName"></td>
			</tr>
		</table>
		<button id="empAddFormBtn" type="button">회원가입</button>
	</form>
</body>
</html>