<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체상품리스트</title>
</head>
<body>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>
	</div>	
	<!--  네비메뉴로 수정예정 -->
	<div>
		<a href="${pageContext.request.contextPath}/goods/goodsList">전체상품</a>
		<a href="${pageContext.request.contextPath}#">신상품</a>
		<a href="${pageContext.request.contextPath}#">베스트</a>
	</div>
	<!-- 상품 네비메뉴 -->
	<div>
		<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>
	</div>	
		
	
	<!-- goodsList -->
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
				<c:forEach var="m" items="${list}" varStatus="s">
					<c:if test="${s.index != 0 && s.index % 4 == 0}">
						</tr><tr>
					</c:if>		
						
					<td>
						<div>
							<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${m.goodsCode}">
								<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250">
							</a>
						</div>
						<div>
							<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${m.goodsCode}">
								${m.goodsName}
							</a>
						</div>
						<br>
						<div>
							<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${m.goodsCode}">
								${m.goodsPrice}원
							</a>						
						</div>
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>