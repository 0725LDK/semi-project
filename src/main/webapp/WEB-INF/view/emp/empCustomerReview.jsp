<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 리뷰 리스트</h1>
	
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		<tr>
			<td>회원 ID</td>	
			<td>상품명</td>	
			<td>리뷰내용</td>	
			<td>작성일자</td>	
		</tr>
		<tr>
			<td><input type="text" name="customerId"></td>
			<td><input type="text" name="goodsName"></td>
			<td><input type="text" name="reviewMemo"></td>
			<td><input type="text" name="reviewCreatedate"></td><!-- 리뷰 등록 일자 -->
		</tr>
	</table>
</body>
</html>