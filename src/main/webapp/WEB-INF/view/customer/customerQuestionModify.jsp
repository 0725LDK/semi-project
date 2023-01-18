<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>934마켓 문의사항 수정 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>문의사항 수정</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>
	<form onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerQuestionModify" method="post">
		<div>
			<label>문의번호</label>
			<input type="text" name="questionCode" value="${questionCode }" readonly="readonly">
		</div>
		<div>
			<label>문의상품</label>
			<input type="text" name="ordersCode" value="${ordersCode }" readonly="readonly">
		</div>
		<div>
			<label>카테고리</label>
			<input type="text" name="category" value="${category}" readonly="readonly">
		</div>
		<div>
			<label>문의내용</label>
			<textarea rows="5" cols="50" id="questionMemo" name="questionMemo">${questionMemo}</textarea>
		</div>
		<button type="submit">수정</button>
	</form>
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