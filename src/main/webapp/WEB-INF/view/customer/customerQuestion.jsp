<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>고객센터</h1>
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>	
	</div>	
	
	<table border="1">
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
								<td><a type="button" href='${pageContext.request.contextPath}/customer/customerQuestionModify?questionCode=${q.questionCode }&ordersCode=${q.ordersCode}&category=${q.category}'>수정</a></td>
								<td><a type="button" href='${pageContext.request.contextPath}/customer/customerQuestionRemove?questionCode=${q.questionCode }'>삭제</a></td>
							</c:if>
							<c:if test="${q.commentMemo != null}">
								<td>${q.commentMemo }</td>
								<td>불가</td>
								<td><a type="button" href='${pageContext.request.contextPath}/customer/customerQuestionRemove?questionCode=${q.questionCode }'>삭제</a></td>
							</c:if>
				</tr>
			</c:forEach>
	</table>
	
</body>
</html>