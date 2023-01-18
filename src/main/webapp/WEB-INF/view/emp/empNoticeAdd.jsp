<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 이벤트 추가 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>이벤트 추가</h1>
	<form action="${pageContext.request.contextPath}/emp/empNoticeAdd" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>공지 제목 : </th>
				<td>
					<input type="text" name="noticeTitle">
				</td>
			</tr>
			<tr>
				<th>공지 내용 : </th>
				<td>
					<textarea name="noticeContent" rows="10" cols="50"></textarea>
				</td>
			</tr>
		
			<tr>
				<th>직원 아이디 : </th>
				<td>
					<input type="text" name="empId">
				</td>
			</tr>
			<tr>
				<th>상품 이미지 : </th>
				<td>
					<input type="file" name="noticeImg">
				</td>
			</tr>
		</table>
		<button type="submit">상품등록</button>
	</form>	
</body>
</html>