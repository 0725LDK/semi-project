<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 회원 리뷰 작성 내역 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>회원 리뷰 작성 내역</h1>
	
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
	
	<!-- 검색 기능 -->
	<div>
		<form action="${pageContext.request.contextPath}/emp/empCustomerReviewList" method="get">
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
			<a href="${pageContext.request.contextPath}/emp/empCustomerReviewList?firstPage=${firstPage}">처음으로</a>
			<a href="${pageContext.request.contextPath}/emp/empCustomerReviewList?currentPage=${currentPage-1}">이전</a>
		</c:if>
		
			<span>${currentPage}</span>
		
		<c:if test="${currentPage == lastPage }">
			<span>다음</span>
			<span>마지막으로</span>
		</c:if>
		
		<c:if test="${currentPage != lastPage}">
			<a href="${pageContext.request.contextPath}/emp/empCustomerReviewList?currentPage=${currentPage+1}">다음</a>
			<a href="${pageContext.request.contextPath}/emp/empCustomerReviewList?lastPage=${lastPage}">마지막으로</a>
		</c:if>
	</div>
</body>
</html>