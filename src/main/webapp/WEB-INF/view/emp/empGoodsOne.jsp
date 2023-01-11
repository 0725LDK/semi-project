<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
</head>
<body>
	<h1>상품 수정 페이지</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>
	</div>




	<br>
	<table>
		<tr>
			<td rowspan="10">
				<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="200" height="250">
			</td>
			<th>상품 종류 : </th>
			<td>${map.goodsCategory}</td>
		</tr>
		<tr>
			<th>상품 이름 : </th>
			<td>${map.goodsName}</td>
		</tr>
		<tr>
			<th>상품 가격 : </th>
			<td>${map.goodsPrice}원</td>
		</tr>
		<tr>
			<th>상품 설명 : </th>
			<td colspan="3">
				<div>${map.goodsContent}</div>
			</td>
		</tr>
		<tr>
			<th>상품 도수 : </th>
			<td>${map.goodsAlcohol}%</td>
		</tr>		
		<tr>
			<th>상품 용량 : </th>
			<td>${map.goodsLiter}ml</td>
		</tr>
		<tr>
			<th>상품 품절 : </th>
			<td>${map.soldout}</td>
		</tr>		
		<tr>
			<th>직원 아이디 : </th>
			<td>${map.empId}</td>
		</tr>
		<tr>
			<th>히트 상품 : </th>
			<td>${map.hit}</td>
		</tr>
		<tr>
			<th>등록 일자 : </th>
			<td>${map.createdate}</td>
		</tr>
	</table>				
	<div>
		<a href="${pageContext.request.contextPath}/emp/empGoodsModify?goodsCode=${map.goodsCode}">수정</a>
		<a href="${pageContext.request.contextPath}/emp/empGoodsRemove?goodsCode=${map.goodsCode}">삭제</a>
	</div>
</body>
</html>