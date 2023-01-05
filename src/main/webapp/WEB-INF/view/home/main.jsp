<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN</title>
</head>
<body>
	<c:if test="${empty loginMember}">
		<a href="${pageContext.request.contextPath}/home/login">로그인</a>
	</c:if>
	<c:if test="${not empty loginMember}">
		<a href="${pageContext.request.contextPath}/home/login">${loginMember.memberId}</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/customer/cart">장바구니</a>
	
	<div>
		<a href="${pageContext.request.contextPath}#">전체상품</a>
		<a href="${pageContext.request.contextPath}#">신상품</a>
		<a href="${pageContext.request.contextPath}#">베스트</a>
	</div>
	
	
	<div>
		<a href="${pageContext.request.contextPath}/goods/takju">탁주</a>
		<a href="${pageContext.request.contextPath}/goods/chengju">약/청주</a>
		<a href="${pageContext.request.contextPath}/goods/wine">과실주</a>
		<a href="${pageContext.request.contextPath}/goods/soju">증류주</a>
		<a href="${pageContext.request.contextPath}/event/eventList">이벤트</a>
	</div>
	
	<!-- goodsList -->
	
</body>
</html>