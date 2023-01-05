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
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a type="button" class="btn btn-dark" href='${pageContext.request.contextPath}/customer/customerModifyQuestion'>수정</a></td>
			<td><a type="button" class="btn btn-dark" href='${pageContext.request.contextPath}/customer/customerRemoveQuestion'>삭제</a></td>
		
		</tr>
	</table>
	<div>
		<a type="button" class="btn btn-dark" href="${pageContext.request.contextPath}/customer/customerAddQuestion">글추가</a>
	</div>	
</body>
</html>