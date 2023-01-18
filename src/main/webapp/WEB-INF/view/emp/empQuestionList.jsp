<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 고객센터 문의내역 | 전통주의 모든것, 934마켓</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		//검색
		$('#searchFormBtn').click(function()
		{
			$('#searchForm').submit();
		});
	});
</script>
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
	
	<!-- 검색 기능 -->
	<div>
		<form action="${pageContext.request.contextPath}/emp/empQuestion" method="get" id="searchForm">
			<span>고객 ID 검색 : </span>
			<input type="text" name="search">
			<button type="button" id="searchFormBtn">검색</button>
		</form>
	</div>
	
	<!-- 페이징 버튼 -->
	<div>
		<c:if test="${currentPage == 1 }">
			<span>처음으로</span>
			<span>이전</span>
		</c:if>
		
		<c:if test="${currentPage != 1 }">
			<a href="${pageContext.request.contextPath}/emp/empQuestion?firstPage=${firstPage}">처음으로</a>
			<a href="${pageContext.request.contextPath}/emp/empQuestion?currentPage=${currentPage-1}">이전</a>
		</c:if>
		
			<span>${currentPage}</span>
		
		<c:if test="${currentPage == lastPage }">
			<span>다음</span>
			<span>마지막으로</span>
		</c:if>
		
		<c:if test="${currentPage != lastPage}">
			<a href="${pageContext.request.contextPath}/emp/empQuestion?currentPage=${currentPage+1}">다음</a>
			<a href="${pageContext.request.contextPath}/emp/empQuestion?lastPage=${lastPage}">마지막으로</a>
		</c:if>
	</div>
</body>
</html>