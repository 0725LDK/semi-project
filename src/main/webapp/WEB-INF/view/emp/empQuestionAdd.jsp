<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>문의사항 답변작성</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<form action="${pageContext.request.contextPath}/emp/empQuestionAdd" method="post">
		<div>
			<label>문의번호</label>
			<input type="text" name="questionCode" value="${questionCode}" readonly="readonly">
		</div>
		<div>
			<label>문의사항</label>
			<input type="text" name="questionMemo" value="${questionMemo}" readonly="readonly">
		</div>
		<div>
			<label>답변 내용 작성</label>
			<input type="text" name="commentMemo" >
		</div>
		<button type="submit" class="btn">답변 작성</button>
	</form>

</body>
</html>