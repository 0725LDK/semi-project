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
	<h1>고객센터 리스트</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table border="1">
		<tr>
			<th>문의번호</th>
			<th>문의고객</th>
			<th>상품이름</th>
			<th>카테고리</th>
			<th>문의사항</th>
			<th>문의일자</th>
			<th>답변내용</th>
			<th>답변일자</th>
			<th>답변 작성/수정</th>
			
		</tr>
		<c:forEach var="q" items="${questionList }">
			<tr>
				<td>${q.questionCode }</td>
				<td>${q.customerId }</td>
				<td>${q.goodsName }</td>
				<td>${q.category }</td>
				<td>${q.questionMemo }</td>
				<td>${q.questionCreatedate }</td>
				
				<c:if test="${q.commentMemo != null}">
					<td>${q.commentMemo }</td>
					<td>${q.commentCreatedate }</td>
					<td><a href="${pageContext.request.contextPath}/emp/empQuestionModify?questionMemo=${q.questionMemo}&commentMemo=${q.commentMemo}&questionCode=${q.questionCode}">답변수정</a></td>
				</c:if>
				<c:if test="${q.commentMemo == null}">
					<td>답변 작성 필요</td>
					<td></td>
					<td><a href="${pageContext.request.contextPath}/emp/empQuestionAdd?questionCode=${q.questionCode}&questionMemo=${q.questionMemo}">답변작성</a></td>
				</c:if>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>