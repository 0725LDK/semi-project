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
						<option value="${map.goodsCategory}">${map.categoryName}</option>
						<option value="1">탁주</option>
						<option value="2">청주</option>
						<option value="3">과실주</option>
						<option value="4">증류주</option>		
						<option value="5">이벤트1</option>	
						<option value="6">이벤트2</option>	
						<option value="7">이벤트3</option>	
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
				<th>상품 설명 : </th>
				<td>		
					<textarea name="goodsContent"  rows="10" cols="50">${map.goodsContent}</textarea>
				</td>
			</tr>
			<tr>
				<th>상품 도수 : </th>
				<td>
					<input type="number" name="goodsAlcohol" value="${map.goodsAlcohol}">
				</td>
			</tr>			
			<tr>
				<th>상품 용량 : </th>
				<td>
					<input type="number" name="goodsLiter" value="${map.goodsLiter}">
				</td>
			</tr>			
			<tr>
				<th>상품 품절 : </th>
				<td>
					<select name="soldout">
						<option value="${map.soldout}">${map.soldout}</option>
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
				<td><input type="number" name="hit" value="${map.hit}"></td>
			</tr>
			<tr>
				<th>상품 이미지 변경 : </th>
				<td>
					<input type="file" name="goodsImg">
				</td>
			</tr>
		</table>
		<button type="submit">상품수정</button>
	</form>


</body>
</html>