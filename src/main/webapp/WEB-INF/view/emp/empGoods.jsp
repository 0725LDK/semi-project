<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 리스트</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<a href="${pageContext.request.contextPath}/emp/empGoodsAdd"> 추가하기</a>
	<table>
		<tr>
			<td>상품 번호</td>	
			<td>상품 이름</td>	
			<td>상품 사진</td>	
			<td>상품 가격</td>	
			<td>품절 여부</td>	
			<td>등록 직원</td>	
			<td>히트 상품</td>	
			<td>등록 일자</td>	
			<td>수정</td>
			<td>삭제</td>
				
		</tr>
		<tr>
			<td><input type="text" name="goodsCode"></td>
			<td><input type="text" name="goodsName"></td>
			<td><input type="text" name="goodsPicture"></td><!-- 상품 사진 -->
			<td><input type="text" name="goodsPrice"></td>
			<td><input type="text" name="soldout"></td>
			<td><input type="text" name="empId"></td>
			<td><input type="text" name="hit"></td>
			<td><input type="text" name="goodsCreatedate"></td><!-- 상품 등록 일자 -->
			<td><a href="${pageContext.request.contextPath}/emp/empGoodsModify">수정</a></td>
			<td><a href="${pageContext.request.contextPath}/emp/empGoodsRemove">삭제</a></td>
		</tr>
	</table>
</body>
</html>