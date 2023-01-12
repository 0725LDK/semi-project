<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td rowspan="10">
				<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="1000" height="300">
			</td>
			<th>공지 제목 : </th>
			<td>${map.noticeTitle}</td>
		</tr>
		<tr>
			<th>공지 내용 : </th>
			<td>${map.noticeContent}</td>
		</tr>		
		<tr>
			<th>직원 아이디 : </th>
			<td>${map.empId}</td>
		</tr>
		<tr>
			<th>등록 일자 : </th>
			<td>${map.createdate}</td>
		</tr>
	</table>				
	<div>
		<a href="${pageContext.request.contextPath}/emp/empNoticeModify?noticeCode=${map.noticeCode}">수정</a>
		<a href="${pageContext.request.contextPath}/emp/empNoticeRemove?noticeCode=${map.noticeCode}">삭제</a>
	</div>

</body>
</html>