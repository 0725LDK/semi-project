<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 고객센터 답변 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>고객센터 답변</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<form action="${pageContext.request.contextPath}/emp/empQuestionModify" method="post">
		<table>
			<tr>
				<td>문의 번호</td>	
				<td>문의 내용</td>	
				<td>기존 답변</td>	
				<td>수정 답변</td>	
			</tr>
			<tr>
				<td><input type="text" name="questionCode" value="${questionCode}" readonly="readonly"></td>
				<td><input type="text" name="questionMemo" value="${questionMemo}" readonly="readonly"></td>
				<td><input type="text" name="oldCommentMemo" value="${commentMemo}" readonly="readonly"></td>
				<td><input type="text" name="commentMemo"></td>
			</tr>
		</table>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>