<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>934마켓 리뷰 작성 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>리뷰 작성</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>
	
	<form onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerAddReview" method="post">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="goodsName"></td>
			</tr>
			<tr>
				<td>리뷰 내용</td>
				<td><input type="text" id="addReview" name="addReview"></td>
			</tr>
		</table>
		<button type="submit">작성하기</button>
	</form>
</body>
<script>
	function check() {
		// 리뷰내용 공백확인
		if($('#addReview').val() == '') {
			alert("내용을 입력해주세요");
			$('#addReview').focus();
			return false;
		}
	}
</script>
</html>