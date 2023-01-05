<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TAKJU</title>
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
	
	<div>
		<a href="${pageContext.request.contextPath}/goods/takju">탁주</a>
		<a href="${pageContext.request.contextPath}/goods/chungju">약/청주</a>
		<a href="${pageContext.request.contextPath}/goods/wine">과실주</a>
		<a href="${pageContext.request.contextPath}/goods/soju">증류주</a>
		<a href="${pageContext.request.contextPath}/event/eventList">이벤트</a>
	</div>
	
	<!-- goods 소개 -->	
	<h3>탁주</h3>
	<p>맛있는 막걸리는 다 있어요</p>
	
	<!-- goodsList -->
	<div>
		<a href="${pageContext.request.contextPath}/goods/takjuPage">
	 		<img src="../img/test.jpg" alt="test" width="200" height="250">
	 	</a>
	 	&ensp;
	 	<a href="${pageContext.request.contextPath}/3">
	 		<img src="../img/test.jpg" alt="test" width="200" height="250">
	 	</a>
	 	&ensp;
	 	<a href="${pageContext.request.contextPath}/#">
	 		<img src="../img/test.jpg" alt="test" width="200" height="250">
	 	</a>
	 	&ensp;
	 	<a href="${pageContext.request.contextPath}/#">
	 		<img src="../img/test.jpg" alt="test" width="200" height="250">
	 	</a>
	</div>
	
	
	
	<p>이미지 및 설명 넣기</p>
	
	
</body>
</html>