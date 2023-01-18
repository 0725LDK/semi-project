<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 직원 리스트 | 전통주의 모든것, 934마켓</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		//검색
		$('#searchFormBtn').click(function()
		{
			$('#searchForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>직원 리스트</h1>
	
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table border="1">
		<tr>
			<td>직원 번호</td>	
			<td>직원 ID</td>	
			<td>직원 이름</td>	
			<td>계정 활성 유무</td>	
			<td>관리자 레벨</td>	
			<td>입사 일자</td>	
			<td>수정</td>
			<td>삭제</td>
				
		</tr>
		<c:forEach var="e" items="${list}">
			<tr>
				<td>${e.empCode}</td>
				<td>${e.empId}</td>
				<td>${e.empName}</td>
				<td>${e.active}</td>
				<td>${e.authCode}</td>
				<td>${e.createdate}</td><!-- 직원 등록 일자 -->
				<td><a href="${pageContext.request.contextPath}/emp/empModify?empCode=${e.empCode}&empId=${e.empId}&empName=${e.empName}">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/emp/empRemove?empCode=${e.empCode}&empId=${e.empId}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 검색 기능 -->
	<div>
		<form action="${pageContext.request.contextPath}/emp/empList" method="get" id="searchForm">
			<span>직원 ID 검색 : </span>
			<input type="text" name="search">
			<button type="button" id="searchFormBtn">검색</button>
		</form>
	</div>
	
	<!-- 페이징 버튼 -->
	<div>
		<c:if test="${currentPage == 1 }">
			<span>처음으로</span>
			<span>이전</span>
		</c:if>
		
		<c:if test="${currentPage != 1 }">
			<a href="${pageContext.request.contextPath}/emp/empList?firstPage=${firstPage}">처음으로</a>
			<a href="${pageContext.request.contextPath}/emp/empList?currentPage=${currentPage-1}">이전</a>
		</c:if>
		
			<span>${currentPage}</span>
		
		<c:if test="${currentPage == lastPage }">
			<span>다음</span>
			<span>마지막으로</span>
		</c:if>
		
		<c:if test="${currentPage != lastPage}">
			<a href="${pageContext.request.contextPath}/emp/empList?currentPage=${currentPage+1}">다음</a>
			<a href="${pageContext.request.contextPath}/emp/empList?lastPage=${lastPage}">마지막으로</a>
		</c:if>
	</div>
</body>
</html>