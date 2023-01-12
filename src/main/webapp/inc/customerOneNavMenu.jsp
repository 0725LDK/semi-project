<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- 네비메뉴 -->
	<a href="${pageContext.request.contextPath}/customer/customerOne">회원정보</a>
	<a href="${pageContext.request.contextPath}/customer/customerOrderList?customerId=${customerId}">주문내역</a>
	<a href="${pageContext.request.contextPath}/customer/customerOrderCancleList?customerId=${customerId}">취소/환불내역</a>
	<a href="${pageContext.request.contextPath}/customer/customerQuestion">고객센터</a>
	<a href="${pageContext.request.contextPath}/logout">로그아웃</a>	
	<br><br>