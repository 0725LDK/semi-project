<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  메인 네비 메뉴 -->
<a href="${pageContext.request.contextPath}/home/intro">인트로</a>
<a href="${pageContext.request.contextPath}/home/main">934마켓</a>
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