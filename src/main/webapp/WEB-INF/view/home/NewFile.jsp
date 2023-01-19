<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 카테고리 상품 | 전통주의 모든것, 934마켓</title>
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