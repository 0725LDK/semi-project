<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 이벤트 추가 | 전통주의 모든것, 934마켓</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		//회원가입시 유효성 검사
		$('#eventAddForm').click(function()
				{
					if($('#noticeTitle').val() == '')
					{
						alert('이벤트 제목을 입력하세요');
						$('#noticeTitle').focus();
						return;
					}
					if($('#noticeContent').val() == '')
					{
						alert('이벤트 내용을 입력하세요');
						$('#noticeContent').focus();
						return;
					}
					$('#eventAddForm').submit();
				});
	});
</script>
</head>
<body>
	<h1>이벤트 추가</h1>
	<form action="${pageContext.request.contextPath}/emp/empNoticeAdd" method="post" enctype="multipart/form-data" id="eventAddForm">
		<table border="1">
			<tr>
				<th>공지 제목 : </th>
				<td>
					<input type="text" name="noticeTitle" id="noticeTitle">
				</td>
			</tr>
			<tr>
				<th>공지 내용 : </th>
				<td>
					<textarea name="noticeContent" rows="10" cols="50" id="noticeContent"></textarea>
				</td>
			</tr>
		
			<tr>
				<th>직원 아이디 : </th>
				<td>
					<input type="text" name="empId" value="${empIdNow }">
				</td>
			</tr>
			<tr>
				<th>상품 이미지 : </th>
				<td>
					<input type="file" name="noticeImg" >
				</td>
			</tr>
		</table>
		<button type="button" id="eventAddForm">상품등록</button>
	</form>	
</body>
</html>