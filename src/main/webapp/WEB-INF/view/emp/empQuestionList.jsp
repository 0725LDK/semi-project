<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>고객센터 리스트</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		<tr>
			<td>상품번호</td>	
			<td>문의 분야</td>	
			<td>문의 내용</td>	
			<td>등록 일자</td>	
			<td>수정</td>
		</tr>
		<tr>
			<td><input type="text" name="orders_code"></td>
			<td><input type="text" name="category"></td>
			<td><input type="text" name="questionMemo"></td>
			<td><input type="text" name="questionCreatedate"></td><!-- 고객센터 등록일자 -->
			<td><a href="${pageContext.request.contextPath}/emp/empQuestionModify">답변</a></td>
		</tr>
	</table>
</body>
</html>