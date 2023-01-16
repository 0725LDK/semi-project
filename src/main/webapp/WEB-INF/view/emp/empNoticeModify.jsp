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
	
	<form action="${pageContext.request.contextPath}/emp/empNoticeModify" method="post" enctype="multipart/form-data">
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
					<select name="noticeCategory">
						<option value="${map.goodsCategory}">${map.goodsCategory}</option>
						<option value="5">이벤트1</option>
						<option value="6">이벤트2</option>
						<option value="7">이벤트3</option>
					</select>
				</td>
				<td><input type="text" name="noticeTitle" value="${map.noticeTitle}"></td>								
				<td><input type="text" name="noticeContent" value="${map.noticeContent}" ></td>
				<td><input type="text" name="empId" value="${map.empId}"></td>
				<td>
					<input type="file" name="goodsImg">
				</td>
			</tr>
		</table>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>