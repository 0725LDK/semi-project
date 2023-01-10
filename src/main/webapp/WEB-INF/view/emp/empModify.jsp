<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원 정보 수정</h1>
	
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	<form action="${pageContext.request.contextPath}/emp/empModify" method="post">
	<table>
		<tr>
			<td>직원 번호</td>	
			<td>직원 ID</td>	
			<td>직원 이름</td>	
			<td>계정 활성 여부</td>	
			<td>관리자 레벨</td>	

		</tr>
		<tr>
		<td><input type="text" name="empCode" value="${empCode }" readonly="readonly"></td>
			<td><input type="text" name="empId" value="${empId }" readonly="readonly"></td>
			<td><input type="text" name="empName" value="${empName }"></td>
			<td>
				<select name="active">
					<option>--계정 활성 여부--</option>
					<option value="Y">활성화</option>
					<option value="N">비활성화</option>
				</select>
			</td>
			<td>
				<select name="authCode">
				<option>--레벨 선택--</option>
					<option value="0">0-관리자</option>
					<option value="1">1-상품관리</option>
					<option value="2">2-고객관리</option>
				</select>
			</td> 
		</tr>
	</table>
	<button type="submit">수정하기</button>
	</form>
</body>
</html>