<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>934마켓 회원 탈퇴 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>회원정보(탈퇴)</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<form onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerRemove" method="post">
		<table>
			<tr>
				<td>계정명 : </td>
				<td><input type="text" name="customerId" value="${loginCustomer.customerId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="customerPw"></td>
			</tr>
		</table>
		<button type="submit">탈퇴하기</button>
	</form>
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