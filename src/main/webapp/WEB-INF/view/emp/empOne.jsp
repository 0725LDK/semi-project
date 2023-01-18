<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 관리자 메인 페이지 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>관리자 페이지(기본)</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<div> 환영 합니다. ${loginEmp.empId}님 
		<c:choose>
			<c:when test="${loginEmp.authCode == 0}">
				전체관리자
			</c:when>
			<c:when test="${loginEmp.authCode == 1}">
				상품관리자
			</c:when>
			<c:when test="${loginEmp.authCode == 2}">
				고객관리자
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${loginEmp.active eq 'N'}">
				[사용불가]
			</c:when>
			<c:when test="${loginEmp.active eq 'Y'}">
				[사용가능]
			</c:when>
		</c:choose>
	</div>
	
	<div>
		<c:if test="${loginEmp.authCode == 1 && loginEmp.active eq 'Y'}">
			<a href="${pageContext.request.contextPath}/emp/empGoodsList">상품 관리</a>
			<a href="${pageContext.request.contextPath}/emp/empNoticeList">이벤트 관리</a>
		</c:if>
		<c:if test="${loginEmp.authCode == 2 && loginEmp.active eq 'Y'}">
			<a href="${pageContext.request.contextPath}/emp/empQuestion">고객센터</a>
		</c:if>
	</div>
	
</body>
</html>