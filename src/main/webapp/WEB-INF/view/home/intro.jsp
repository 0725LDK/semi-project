<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INTRO</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/home/intro">intro</a>
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
	<a href="${pageContext.request.contextPath}/customer/customerCart">장바구니</a>
	
</html>