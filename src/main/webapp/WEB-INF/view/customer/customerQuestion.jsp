<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>934마켓 고객센터 | 전통주의 모든것, 934마켓</title>
	<!-- 메인 네비메뉴 -->
	<jsp:include page="/inc/customerCss.jsp"></jsp:include>
	<style>
		table, td {
			height: 60px;
			text-align: center;
		}
		table {
			width: 100%;
		}
		th {
			height: 50px;
		}
	</style>
</head>
<body>
	<!-- 상단 네비메뉴 -->
	<div>
		<jsp:include page="/inc/mainNavMenu.jsp"></jsp:include>
	</div>	
	
	<!-- 카테고리 네비메뉴 -->
	<div>
	   <jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>   
	</div>   

    <!-- 고객센터 -->
    <div class="text-center">
		<br><h2>고객센터</h2>
	</div>
    <section class="shoping-cart spad">
        <div class="container">
            <table class="table">
				<tr>
					<th>문의번호</th>
					<th>문의상품</th>
					<th>카테고리</th>
					<th>문의사항</th>
					<th>문의일자</th>
					<th>답변 유무</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach var="q" items="${questionList}">
					<tr>
						<td>${q.questionCode }</td>
						<td>${q.ordersCode }</td>
						<td>${q.category }</td>
						<td>${q.questionMemo }</td>
						<td>${q.createdate }</td>
						<c:if test="${q.commentMemo == null}">
							<td>..답변중..</td>
							<td><a type="button" href='${pageContext.request.contextPath}/customer/customerQuestionModify?questionCode=${q.questionCode }&ordersCode=${q.ordersCode}&questionMemo=${q.questionMemo}&category=${q.category}'>수정</a></td>
							<td><a type="button" href='${pageContext.request.contextPath}/customer/customerQuestionRemove?questionCode=${q.questionCode }'>삭제</a></td>
						</c:if>
						<c:if test="${q.commentMemo != null}">
							<td>${q.commentMemo }</td>
							<td>불가</td>
							<td>불가</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
        </div>
    </section>

   	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>
</body>
</html>