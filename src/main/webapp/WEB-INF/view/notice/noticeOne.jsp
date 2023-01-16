<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EVENT PAGE</title>
</head>
<body>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		<tr>
			<td rowspan="10">
				<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="1000" height="300">
			</td>			
	</table>	
	
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
							<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${list.goodsCode}">
								<img src="${pageContext.request.contextPath}/upload/${list.filename}" width="200" height="250">
							</a>
						</div>
						<div>
							<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${list.goodsCode}">
								${list.goodsName}
							</a>
						</div>
						<br>
						<div>
							<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${list.goodsCode}">
								${list.goodsPrice}원
							</a>						
						</div>
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>	
	
				
	<div>
		<a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=5">${m.goodsCategory}구매하러가기</a>		
	</div>
</body>
</html>