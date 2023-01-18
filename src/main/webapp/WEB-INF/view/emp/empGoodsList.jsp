<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 관리자 전체상품 | 전통주의 모든것, 934마켓</title>
</head>
<body>
	<h1>상품 리스트</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<!-- 검색창 -->
	<form method="get" action="${pageContext.request.contextPath}/emp/empGoodsList">
		<c:if test="${goodsSearch != null}">
			<input class="box" type="text" name="goodsSearch" value="${goodsSearch}">
		</c:if>
		<c:if test="${goodsSearch == null}">
			<input class="box" type="text" name="goodsSearch" placeholder="상품명을 입력하세요.">
		</c:if>
		<button class="btn btn-dark" type="submit">검색</button>
	</form>	
	<br>
	
	<div>
		<a href="${pageContext.request.contextPath}/emp/empGoodsAdd">
			상품 추가
		</a>
	</div>	
	
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
				<c:if test="${s.index != 0 && s.index % 7 == 0}">
					</tr><tr>
				</c:if>				
				<td>
						<c:if test="${m.soldout == 'Y'}">
							<div class="soldout">
								<a href="${pageContext.request.contextPath}/emp/empGoodsOne?goodsCode=${m.goodsCode}">
									<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250">
								</a>
								<p>${m.goodsName}</p>
									<div value="${m.soldout}" class="soldout">품절</div>
							</div>
						</c:if>		
						<c:if test="${m.soldout == 'N'}">
							<div>
								<a href="${pageContext.request.contextPath}/emp/empGoodsOne?goodsCode=${m.goodsCode}">
									<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250">
								</a>
								<p>${m.goodsName}</p>

							</div>
						</c:if>						
				
					<a href="${pageContext.request.contextPath}/emp/empGoodsModify?goodsCode=${m.goodsCode}">수정</a>
				</td>
			</c:forEach>		
		</tr>
	</table>
</body>
</html>