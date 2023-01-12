<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 리뷰 리스트</h1>
	
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table border="1">
		<tr>
			<td>주문번호</td>	
			<td>고객ID</td>	
			<td>상품명</td>	
			<td>리뷰내용</td>	
			<td>리뷰작성시간</td>	
			<td>리뷰업데이트 내용</td>	
			<td>리뷰업테이트 시간</td>	
		</tr>
		<c:forEach var="r" items="${reviewList }">
			<tr>
				<td>${r.orderCode }</td>
				<td>${r.customerId }</td>
				<td>${r.goodsname }</td>
				<td>${r.reviewMemo }</td>
				<td>${r.reviewDate }</td>
				<td>${r.pointKind }</td>
				<td>${r.pointDate}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>