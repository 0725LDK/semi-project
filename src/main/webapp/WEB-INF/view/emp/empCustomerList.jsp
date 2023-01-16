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
	<h1>회원 정보 리스트</h1>
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>

	<table border="1">
		<tr>
			<td>회원 번호</td>
			<td>회원 ID</td>
			<td>회원 이름</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>보유 포인트</td>
			<td>가입 일자</td>
		</tr>
		<c:forEach var="c" items="${customerList}">
			<tr>
				<td>${c.customerCode}</td>
				<td>${c.customerId}</td>
				<td>${c.customerName}</td>
				<td>${c.customerPhone}</td>
				<td>${c.address}</td>
				<td>${c.point}</td>
				<td>${c.createdate}</td>
			</tr>
		</c:forEach>		
	</table>
	
	<!-- 검색 기능 -->
	<div>
		<form action="${pageContext.request.contextPath}/emp/empCustomerList" method="get">
			<span>고객 ID 검색 : </span>
			<input type="text" name="search">
			<button type="submit">검색</button>
		</form>
	</div>
	
	<!-- 페이징 버튼 -->
	<div>
		<c:if test="${currentPage == 1 }">
			<span>처음으로</span>
			<span>이전</span>
		</c:if>
		
		<c:if test="${currentPage != 1 }">
			<a href="${pageContext.request.contextPath}/emp/empCustomerList?firstPage=${firstPage}">처음으로</a>
			<a href="${pageContext.request.contextPath}/emp/empCustomerList?currentPage=${currentPage-1}">이전</a>
		</c:if>
		
			<span>${currentPage}</span>
		
		<c:if test="${currentPage == lastPage}">
			<span>다음</span>
			<span>마지막으로</span>
		</c:if>
		
		<c:if test="${currentPage != lastPage}">
			<a href="${pageContext.request.contextPath}/emp/empCustomerList?currentPage=${currentPage+1}">다음</a>
			<a href="${pageContext.request.contextPath}/emp/empCustomerList?lastPage=${lastPage}">마지막으로</a>
		</c:if>
	</div>
</body>
</html>