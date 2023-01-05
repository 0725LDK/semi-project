<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이벤트 수정</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<form action="${pageContext.request.contextPath}/emp/empNoticeModify" method="post">
		<table>
			<tr>
				<td>이벤트 제목</td>	
				<td>이벤트 내용</td>	
			</tr>
			<tr>
				<td><input type="text" name="noticeTitle"></td>
				<td><input type="text" name="noticeContent"></td>
			</tr>
		</table>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>