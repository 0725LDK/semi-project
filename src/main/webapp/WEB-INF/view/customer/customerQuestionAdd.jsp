<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>934마켓 문의사항 추가 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>문의사항 추가</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<form onsubmit="return check()" action="${pageContext.request.contextPath}/customer/customerQuestionAdd" method="post">
		<div>
			<label>주문번호</label>
			<input type="text" name="ordersCode" value="${ordersCode}" readonly="readonly">
		</div>
		
		<div>
			<label>카테고리</label>
			<select name="category" id="category">
				<option value="X">==선택==</option>
				<option value="배송">배송</option>
				<option value="교환">교환</option>
				<option value="반품">반품</option>
				<option value="기타">기타</option>
			</select>
		</div>
		<div>
			<label>문의내용</label>
			<textarea rows="5" cols="50" id="questionMemo" name="questionMemo"></textarea>
		</div>
		<button type="submit">추가</button>
	</form>
</body>
<script>
	function check() {
		if($('#category').val() == "X") {
			alert("카테고리를 선택해주세요");
			$('#category').focus();
			return false;
		}
		if($('#questionMemo').val() == '') {
			alert("문의내용을 입력해주세요");
			$('#questionMemo').focus();
			return false;
		}
	}
</script>
</html>