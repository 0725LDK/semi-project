<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>판매 합계 데이터</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		<tr>
			<td>청주 총 판매액</td>
			<td>소주 총 판매액</td>
			<td>탁주 총 판매액</td>
			<td>와인 총 판매액</td>
		</tr>
		<tr>
			<td><input type="text" name="chungjuSum"></td>
			<td><input type="text" name="sojuSum"></td>
			<td><input type="text" name="takjuSum"></td>
			<td><input type="text" name="wineSum"></td>
		</tr>
		
	</table>
</body>
</html>