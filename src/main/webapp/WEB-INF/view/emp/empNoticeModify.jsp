<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 이벤트 수정 | 전통주의 모든것, 934마켓</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		//이벤트 수정시 유효성 검사
		$('#eventModifyFormBtn').click(function()
				{
					if($('#noticeTitle').val() == '')
					{
						alert('수정할 이벤트 제목을 입력하세요');
						$('#noticeTitle').focus();
						return;
					}
					if($('#noticeContent').val() == '')
					{
						alert('수정할 이벤트 내용을 입력하세요');
						$('#noticeContent').focus();
						return;
					}
					
					$('#eventModifyForm').submit();
				});
	});
</script>
</head>
<body>
	<h1>이벤트 수정</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<form action="${pageContext.request.contextPath}/emp/empNoticeModify" method="post" enctype="multipart/form-data" id="eventModifyForm">
		<table>
			<tr>
				<td rowspan="10">
					<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="1000" height="300">
				</td>		
			</tr>
		</table>
		<table>
			<tr>			
				<td>번호</td>	
				<td>이벤트 상품 카테고리</td>	
				<td>이벤트 제목</td>	
				<td>이벤트 내용</td>	
				<td>등록 직원</td>	
				<td>상품이미지 변경</td>	
			</tr>
			<tr>
				<td>
					<input type="number" name="noticeCode" value="${map.noticeCode}" readonly="readonly">
				</td>
				<td>
					<select name="goodsCategory">
						<option value="${map.goodsCategory}">카테고리를 선택하세요.</option>
						<option value="5">이벤트1</option>
						<option value="6">이벤트2</option>
						<option value="7">이벤트3</option>
					</select>
				</td>
				<td><input type="text" name="noticeTitle" value="${map.noticeTitle}" id="noticeTitle"></td>								
				<td><input type="text" name="noticeContent" value="${map.noticeContent}" id="noticeContent"></td>
				<td><input type="text" name="empId" value="${map.empId}"></td>
				<td>
					<input type="file" name="goodsImg">
				</td>
			</tr>
		</table>
		<button type="button" id="eventModifyFormBtn">수정하기</button>
	</form>
</body>
</html>