<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<!-- emp 네비 메뉴 -->
	<a href="${pageContext.request.contextPath}/emp/empCustomerList">회원정보</a>
	<a href="${pageContext.request.contextPath}/emp/empCustomerOrder">회원 주문 내역</a>
	<a href="${pageContext.request.contextPath}/emp/empCustomerCancle">회원 취소/환불 내역</a>
	<a href="${pageContext.request.contextPath}/emp/empCustomerReview">회원 리뷰</a>
	<br>
	<a href="${pageContext.request.contextPath}/emp/empList">직원정보</a><!-- 직원정보 수정(레벨수정), 삭제(탈퇴) 페이지 -->
	<br>
	<a href="${pageContext.request.contextPath}/emp/empGoodsList">상품 관리</a><!-- 상품정보 추가, 수정, 삭체  오후 시간에!-->
	<br>
	<a href="${pageContext.request.contextPath}/emp/empNoticeList">이벤트 관리</a>
	<br>
	<a href="${pageContext.request.contextPath}/emp/empQuestion">고객센터</a>
	<br>
	<a href="${pageContext.request.contextPath}/emp/empSum">판매 데이터</a>
	<br><br>