<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<style>
	
	.banner {
	  border: 1px outset black;
	  background-color: white;    
	  text-align: center;
	}
	
</style>
<meta charset="UTF-8">
<title>EVENT PAGE</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/home/main">스토어</a>
	<c:if test="${empty loginMember}">
		<a href="${pageContext.request.contextPath}/home/login">로그인</a>
	</c:if>
	<c:if test="${not empty loginMember}">
		<a href="#">${loginMember}</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/customer/cart">장바구니</a>
	<br>
	<br>
	
	<!-- event page -->
	<div class="banner">
	  <h2>이벤트배너1 이미지</h2>
	</div>
	<br>
	<div class="banner">
	  <h2>이벤트배너1 설명</h2>
	</div>
	<br>
	<div class="banner">
	  <h2>이벤트배너1 상품이미지..</h2>
	</div>
	<br>		
	
	
	
	
</body>
</html>