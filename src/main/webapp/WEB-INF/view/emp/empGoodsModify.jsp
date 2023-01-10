<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 수정 페이지</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	

<!--  수정 -->

	<form action="${pageContext.request.contextPath}/emp/empGoodsModify" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td rowspan="10">
					<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="200" height="200">
				</td>
				<th>상품 번호 : </th>
				<td>
					<input type="number" name="goodsCode" value="${map.goodsCode}" readonly="readonly">
				</td>
			</tr>
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
					<input type="text" name="goodsName" value="${map.goodsName}">
				</td>
			</tr>
			<tr>
				<th>상품 가격 : </th>
				<td>
					<input type="number" name="goodsPrice" value="${map.goodsPrice}">
				</td>
			</tr>
			<tr>
				<th>품절 여부 : </th>
				<td>
					<select name="soldout">
						<option value="${map.hit}">${map.hit}</option>
						<option value="Y">품절</option>
						<option value="N">재고 있음</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>직원 아이디 : </th>
				<td>
					<input type="text" name="empId" value="${map.empId}">
				</td>
			</tr>
			<tr>
				<th>히트 상품 : </th>
				<td><input type="number" name="hit"></td>
			</tr>
			<tr>
				<th>상품 이미지 : </th>
				<td>
					<input type="file" name="goodsImg">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div>상품 설명 : </div>
					<textarea name="goodsContent" rows="5" cols="100">${map.goodsContent}</textarea>
				</td>
		</tr>
		</table>
		<button type="submit">상품수정</button>
	</form>


</body>
</html>