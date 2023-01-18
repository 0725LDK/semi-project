<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<style>
.soldout{
	pointer-events : none;
}
</style>
</head>
<body>
	<!-- 메인 네비메뉴 -->
	<div>
		<jsp:include page="/inc/mainNavMenu.jsp"></jsp:include>
	</div>	
	<br>

	<!-- 상품 네비메뉴 -->
	<div>
		<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>
	</div>	
	<br>

	
	<!-- 신상품 -->
	<h3>신상품</h3>
	<div>
		<table border="1">
			<tr>
				<!-- 
					varStatus 변수속성
					${s.current} 현재 for문의 해당하는 번호
					${s.index} 0부터의 순서
					${s.count} 1부터의 순서
					${s.first} 첫 번째인지 여부
					${s.last} 마지막인지 여부
					${s.begin} for문의 시작 번호
					${s.end} for문의 끝 번호
					${s.step} for문의 증가값				
				-->
				<c:forEach var="n" items="${newList}" varStatus="s">
					<c:if test="${s.index != 0 && s.index % 4 == 0}">
						</tr><tr>
					</c:if>						
					<td>
						<div>
							<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${n.goodsCode}">
								<img src="${pageContext.request.contextPath}/upload/${n.filename}" width="200" height="250">
							</a>
							<p>${n.goodsName}</p>
							<p>${n.goodsPrice}원</p>
								<c:if test="${n.soldout == 'Y'}">
									<span value="${n.soldout}" id="soldout">품절</span>
								</c:if>						
						</div>
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>	
	<br>

	<!-- 히트상품 -->
	<h3>인기상품</h3>
	<div>
		<table border="1">
			<tr>
				<!-- 
					varStatus 변수속성
					${s.current} 현재 for문의 해당하는 번호
					${s.index} 0부터의 순서
					${s.count} 1부터의 순서
					${s.first} 첫 번째인지 여부
					${s.last} 마지막인지 여부
					${s.begin} for문의 시작 번호
					${s.end} for문의 끝 번호
					${s.step} for문의 증가값				
				-->
				<c:forEach var="h" items="${hitList}" varStatus="s">
					<c:if test="${s.index != 0 && s.index % 4 == 0}">
						</tr><tr>
					</c:if>						
					<td>
						<div>
							<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${h.goodsCode}">
								<img src="${pageContext.request.contextPath}/upload/${h.filename}" width="200" height="250">
							</a>
							<p>${h.goodsName}</p>
							<p>${h.goodsPrice}원</p>
								<c:if test="${h.soldout == 'Y'}">
									<span value="${h.soldout}" id="soldout">품절</span>
								</c:if>						
						</div>
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>	
	<br>
</body>
</html>