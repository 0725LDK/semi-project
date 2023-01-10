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

	<form action="${pageContext.request.contextPath}/emp/empGoodsAdd" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>상품 종류 : </th>
				<td>
					<select name="goodsCategory">
						<option value="${map.goodsCategory}">${map.goodsCategory}</option>
						<option value="1">탁주</option>
						<option value="2">청주</option>
						<option value="3">과실주</option>
						<option value="4">증류주</option>		
					</select>
				</td>
			</tr>
			<tr>
				<th>상품 이름 : </th>
				<td>
					<input type="text" name="goodsName">
				</td>
			</tr>
			<tr>
				<th>상품 가격 : </th>
				<td>
					<input type="number" name="goodsPrice">
				</td>
			</tr>
			<tr>
				<th>상품 설명 : </th>
				<td>
					<textarea name="goodsContent" rows="10" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<th>직원 아이디 : </th>
				<td>
					<input type="text" name="empId">
				</td>
			</tr>
			<tr>
				<th>히트 상품 : </th>
				<td>
					<input type="number" name="hit">
				</td>
			</tr>
			<tr>
				<th>상품 이미지 : </th>
				<td>
					<input type="file" name="goodsImg">
				</td>
			</tr>
		</table>
		<button type="submit">상품등록</button>
	</form>	

</body>
</html>