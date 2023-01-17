<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerAdd</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<h1>고객회원가입</h1>
	<form method="post" onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerAdd">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="customerId" name="customerId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="customerPw" name="customerPw"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="pwPw" name="pwCheck"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="customerName" name="customerName"></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td>
					<input type="text" id="customerJumin" name="customerJumin">-
					<input type="text" id="customerJumin1" name="customerJumin1">
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" id="customerPhone" name="customerPhone"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<select name="customerAddress">
						<option value="서울특별시">서울특별시</option>
						<option value="인천광역시">인천광역시</option>
						<option value="부산광역시">부산광역시</option>
						<option value="대전광역시">대전광역시</option>
						<option value="대구광역시">대구광역시</option>
						<option value="울산광역시">울산광역시</option>
						<option value="광주광역시">광주광역시</option>
						<option value="경기도">경기도</option>
						<option value="강원도">강원도</option>
						<option value="충청도">충청도</option>
						<option value="전라도">전라도</option>
						<option value="경상도">경상도</option>
						<option value="제주특별자지도">제주특별자지도</option>
					</select>
				</td>
			</tr>
		</table>
		<button type="submit">회원가입</button>
	</form>
</body>
<script>
	// 주민등록번호 숫자만 입력가능
	$('#customerJumin').bind('keyup', function(event) {
		let regNumber = /^[0-9]*$/;
		let temp = $('#customerJumin').val();
		if(!regNumber.test(temp)) { // 숫자만 입력가능
			alert("숫자만 입력하세요");
			$('#customerJumin').val(temp.replace(/[^0-9]/g,"")); // 숫자가아니면 지우기
		}
	});
	$('#customerJumin1').bind('keyup', function(event) {
		let regNumber = /^[0-9]*$/;
		let temp = $('#customerJumin1').val();
		if(!regNumber.test(temp)) {
			alert("숫자만 입력하세요");
			$('#customerJumin1').val(temp.replace(/[^0-9]/g,""));
		}
	});
	// 현재 년도 구하기
	now = new Date();
	nowYear = now.getFullYear();
	// 주민등록번호 성인 확인
	$('#customerJumin').on('keyup', function(){
		if($(this).val().length == 6)
			$('#customerJumin1').trigger('focus');
	});
	$('#customerJumin1').on('keyup', function(){
		if($('#customerJumin1').val().length == 7){
			let ch = $('#customerJumin1').val().substr(0,1);
			let year = $('#customerJumin').val().substr(0,2);
			let age;
			if(ch == '1' || ch == '2') {
				//1900년대
				age = nowYear - (1900 + Number(year)) + 1;
			} else if (ch == '3' || ch == '4') {
				//2000년대
				age = nowYear - (2000 + Number(year)) + 1;
			}         
			if(age > 19) {
				console.log(age+'성인');
				alert('성인인증 완료 되었습니다.');
				$('#customerPhone').focus();
			} else {
				console.log(age+'미성년자');
				$('#customerJumin').val('');
				$('#customerJumin1').val('');
				$('#customerJumin').focus();
				alert('미성년자는 가입할 수 없습니다.');
			}
		}              
	});
	// 회원가입 버튼 누르면 확인
	function check() {
		var getCheck=RegExp(/^{4,12}$/);
		
		// 아이디 공백확인
		if($('#customerId').val() == '') {
			alert("아이디를 입력해주세요");
			$('#customerId').focus();
			return false;
		}
		// 아이디 4~12자리만 가능 확인
		if(!getCheck.test($('#customerId').val())) {
			alert("4~12자리만 가능합니다");
			$('#customerId').val('');
			$('#customerId').focus();
			return false;
		}
	
	}
</script>
</html>