<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 네비메뉴 -->
	
	<a href="${pageContext.request.contextPath}/home/main">스토어</a>
	<!-- 로그인 안되어 있으면 -->
	<c:if test="${loginCustomer eq null && loginEmp eq null}">
		<a href="${pageContext.request.contextPath}/home/login">로그인</a>
	</c:if>
	<!-- 고객 로그인시 -->
	<c:if test="${loginCustomer.customerId ne null}">
		<a href="${pageContext.request.contextPath}/customer/customerOne">${loginCustomer.customerId}님</a>
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>
	<!-- 직원 로그인시 -->
	<c:if test="${loginEmp.empId ne null}">
		<a href="${pageContext.request.contextPath}/emp/empOne">${loginEmp.empId}님</a>
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/customer/cart">장바구니</a>	
	<br>
	<br>
	
	<!-- goods 상세페이지 -->	
	<div style="width:200px; height:250px; float:left; margin-right:10px;">
		<a href="${pageContext.request.contextPath}/goods/takjuPage">
	 		<img src="../img/test.jpg" alt="test" width="200" height="250">
		</a>
	</div>

	<div style="width:200px; height:250px; float:left;">
		담은[3병/6병/10병]<br>주종: 탁주<br>도수: 6.50% <br>용량: 750ml<br>판매가격: 29,700원
	</div>	
		<table>
			<tr>
				<td>수량</td>
				<td><input></td>
			</tr>
			<tr>
				<td>총 상품가격</td>
				<td><input></td>
			</tr>

		</table>
</body>
</html>