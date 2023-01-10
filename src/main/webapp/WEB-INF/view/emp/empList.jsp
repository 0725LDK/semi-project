<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원 리스트</h1>
	
	<!-- 네비메뉴 -->
	
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<table>
		<tr>
			<td>직원 번호</td>	
			<td>직원 ID</td>	
			<td>직원 이름</td>	
			<td>계정 활성 유무</td>	
			<td>관리자 레벨</td>	
			<td>입사 일자</td>	
			<td>수정</td>
			<td>삭제</td>
				
		</tr>
		<tr>
			<td><input type="text" name="empCode"></td>
			<td><input type="text" name="empId"></td>
			<td><input type="text" name="empName"></td>
			<td><input type="text" name="empActice"></td>
			<td><input type="text" name="empAuthCode"></td>
			<td><input type="text" name="empCreatedate"></td><!-- 직원 등록 일자 -->
			<td><a href="${pageContext.request.contextPath}/emp/empModify">수정</a></td>
			<td><a href="${pageContext.request.contextPath}/emp/empRemove">삭제</a></td>
			
			
			<!-- <td>
				<select name="active">
					<option value="Y">활성화</option>
					<option value="N">비활성화</option>
				</select>
			</td>
			<td>
				<select name="authCode">
					<option value="noCode">--코드선택--</option>
					<option value="0">0-관리자</option>
					<option value="1">1-상품관리</option>
					<option value="2">2-고객관리</option>
				</select>
			</td> -->
		</tr>
	</table>
</body>
</html>