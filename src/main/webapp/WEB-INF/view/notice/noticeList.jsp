<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EVENT LIST</title>
</head>
<body>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>
	</div>

	<!--  이벤트 배너 클릭시 이벤트 상품 페이지로 이동 -->
	<table>
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
				<c:if test="${s.index != 0 && s.index % 1 == 0}">
					</tr><tr>
				</c:if>
				
				<td>
					<div>
						<a href="${pageContext.request.contextPath}/notice/noticeOne?noticeCode=${m.noticeCode}&goodsCategory=${m.goodsCategory}">
							<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="1000" height="300">
						</a>
					</div>
				</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>