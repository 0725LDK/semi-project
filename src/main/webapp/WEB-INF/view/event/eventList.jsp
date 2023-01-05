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
<title>EVENT LIST</title>
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
	
	<!-- eventList -->
	<div class="banner">
	  <h2><a href="${pageContext.request.contextPath}/event/eventPage">이벤트 배너1</a></h2>
	</div>
	<br>
	<div class="banner">
	  <h2><a href="${pageContext.request.contextPath}#">이벤트 배너2</a></h2>
	</div>
	<br>
	<div class="banner">
	  <h2><a href="${pageContext.request.contextPath}#">이벤트 배너3</a></h2>
	</div>
	<br>
	<div class="banner">
	  <h2><a href="${pageContext.request.contextPath}#">이벤트 배너4</a></h2>
	</div>
	<br>
	<div class="banner">
	  <h2><a href="${pageContext.request.contextPath}#">이벤트 배너5</a></h2>
	</div>
</body>
</html>