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
	<a href="${pageContext.request.contextPath}/home/intro">intro</a>
	<a href="${pageContext.request.contextPath}/#">스토어</a>
	<!-- 로그인 안되어 있으면 -->
	<c:if test="${loginCustomer eq null && loginEmp eq null}">
		<a href="${pageContext.request.contextPath}/home/login">로그인</a>
	</c:if>
	<!-- 고객 로그인시 -->
	<c:if test="${loginCustomer.customerId ne null}">
		<a href="${pageContext.request.contextPath}/customer/customerOne">${loginCustomer.customerId}님</a>
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>
	<!-- 직원 로그인시 -->
	<c:if test="${loginEmp.empId ne null}">
		<a href="${pageContext.request.contextPath}/emp/empOne">${loginEmp.empId}님</a>
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/customer/customerCart">장바구니</a>

	<!-- 상품 네비메뉴 -->
	<div>
		<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>
	</div>	
	<br>

	<!-- 검색창 -->
	<form method="get" action="${pageContext.request.contextPath}/home/main">
		<c:if test="${goodsSearch != null}">
			<input class="box" type="text" name="goodsSearch" value="${goodsSearch}">
		</c:if>
		<c:if test="${goodsSearch  == null}">
			<input class="box" type="text" name="goodsSearch" placeholder="상품명을 입력하세요.">
		</c:if>
		<button class="btn btn-dark" type="submit">검색</button>
	</form>	
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
	<!-- goodsList -->
	<h3>전체 상품</h3>
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
						<c:if test="${m.soldout == 'Y'}">
							<div class="soldout">
								<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${m.goodsCode}">
									<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250">
								</a>
								<p>${m.goodsName}</p>
								<p>${m.goodsPrice}원</p>
									<div value="${m.soldout}" class="soldout">품절</div>
							</div>
						</c:if>		
						<c:if test="${m.soldout == 'N'}">
							<div>
								<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${m.goodsCode}">
									<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250">
								</a>
								<p>${m.goodsName}</p>
								<p>${m.goodsPrice}원</p>
							</div>
						</c:if>						
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>

</body>
</html>