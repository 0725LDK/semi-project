<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이벤트 리스트</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		<tr>
			<td>이벤트 제목</td>	
			<td>이벤트 내용</td>	
			<td>등록 직원</td>	
			<td>등록 일자</td>	
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<tr>
			<td><input type="text" name="noticeTitle"></td>
			<td><input type="text" name="noticeContent"></td>
			<td><input type="text" name="empId"></td>
			<td><input type="text" name="noticeCreatedate"></td><!-- 이벤트 등록일자 -->
			<td><a href="${pageContext.request.contextPath}/emp/empNoticeModify">수정</a></td>
			<td><a href="${pageContext.request.contextPath}/emp/empNoticeRemove">삭제</a></td>
		</tr>
	</table>
</body>
</html>