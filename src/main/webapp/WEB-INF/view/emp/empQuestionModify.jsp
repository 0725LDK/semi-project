<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<td>문의 내용</td>	
				<td>문의 답변</td>	
			</tr>
			<tr>
				<td><input type="text" name="questionContent"></td>
				<td><input type="text" name="commentMemo"></td>
			</tr>
		</table>
		<button type="submit">답변하기</button>
	</form>
</body>
</html>