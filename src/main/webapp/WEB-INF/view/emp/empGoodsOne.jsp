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
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>




	<br>
	<table>
		<tr>
			<td rowspan="10">
				<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="200" height="250">
			</td>
			<th>상품 주종 : </th>
			<td>${map.categoryName}</td>
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
			<th>상품 재고 : </th>
			<td>
				<c:if test="${map.soldout == 'Y'}">
					<span value="${map.soldout}">품절</span>
				</c:if>
				<c:if test="${map.soldout == 'N'}">
					<span value="${map.soldout}">재고 있음</span>
				</c:if>
			</td>
		</tr>		
		<tr>
			<th>직원 아이디 : </th>
			<td>${map.empId}</td>
		</tr>
		<tr>
			<th>베스트 상품 : </th>
			<td>
				<c:if test="${map.hit == '1'}">
					<span value="${map.hit}">베스트 상품</span>
				</c:if>
				<c:if test="${map.hit == '0'}">
					<span value="${map.hit}">일반 상품</span>
				</c:if>
			</td>
		</tr>
		<tr>
			<th>등록 일자 : </th>
			<td>${map.createdate}</td>
		</tr>
	</table>				
	<div>
		<a href="${pageContext.request.contextPath}/emp/empGoodsModify?goodsCode=${map.goodsCode}">수정</a>
	</div>
</body>
</html>