<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보(기본)</h1>
	<!-- 네비메뉴 -->
	<!-- 네비메뉴 -->
	<a href="${pageContext.request.contextPath}/customer/customerOne">회원정보</a>
	<a href="${pageContext.request.contextPath}/customer/customerOrder">주문내역</a>
	<a href="${pageContext.request.contextPath}/customer/customerCancle">취소/환불내역</a>
	<a href="${pageContext.request.contextPath}/customer/customerReview">리뷰</a>
	<a href="">고객센터</a>
	
	
	<!-- 회원정보 -->
	<table>
		<tr>
			<td>계정명 : </td>
			<td><input></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><input></td>
		</tr>
		<tr>
			<td>주소 : </td>
			<td><input></td>
		</tr>
		<tr>
			<td>휴대폰 : </td>
			<td><input></td>
		</tr>
	</table>
	
	<!-- 수정/삭제/탈퇴 -->
	<a href="${pageContext.request.contextPath}/customer/customerModify">수정</a>
	<a href="${pageContext.request.contextPath}/customer/customerRemove">회원탈퇴</a>
</body>
</html>