<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 등록 페이지</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	<form action="${pageContext.request.contextPath}/emp/empGoodsAdd" method="post">
		<table>
			<tr>
				<td>상품 이름</td>	
				<td>상품 사진</td>	
				<td>상품 가격</td>	
				<td>품절 여부</td>	
				<td>등록 직원</td>	
			</tr>
			<tr>
				<td><input type="text" name="goodsCode"></td>
				<td><input type="text" name="goodsName"></td>
				<td><input type="text" name="goodsPicture"></td><!-- 상품 사진 -->
				<td><input type="text" name="goodsPrice"></td>
				<td>
					<select name="soldout">
						<option value="Y">품절</option>
						<option value="N">재고 있음</option>
					</select>	
				</td>
				<td><input type="text" name="empId"></td>
			</tr>
		</table>
		<button	type="submit">등록하기</button>
	</form>
</body>
</html>