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
	<h1>판매 합계 데이터</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<h3>주류별 판매금액 및 판매건수</h3>
	<table border="1">
		
		<tr>
			<th>주류</th>
			<th>판매액</th>
			<th>판매건수</th>
		</tr>
		<c:forEach var="s" items="${sumByCategory }">
			<tr>
				<td>
					<c:if test="${s.goodsCategory == 1}">
						탁주
					</c:if>
					<c:if test="${s.goodsCategory == 2}">
						청주
					</c:if>
					<c:if test="${s.goodsCategory == 3}">
						과실주
					</c:if>
					<c:if test="${s.goodsCategory == 4}">
						증류주
					</c:if>
				</td>
				<td>${s.sumByCategory }원</td>
				<td>${s.categoryCount }건</td>
			</tr>
		</c:forEach>
			
	</table>
</body>
</html>