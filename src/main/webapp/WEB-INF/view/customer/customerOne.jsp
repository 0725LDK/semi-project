<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- 메인 네비메뉴 -->
	<jsp:include page="/inc/customerCss.jsp"></jsp:include>
	<title>934마켓 회원 정보 | 전통주의 모든것, 934마켓</title>

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
	
	<!-- 회원정보 -->
	<div class="container d-flex flex-column">
		<div class="row pt-5">
			<div class="col-lg-6 mx-auto d-table"><br><br><br>
				<div class="card border-0">
					<div class="text-center">
						<h2>회원정보</h2>
					</div>
					<div class="card-body">
						<div class="m-sm-3 text-center">
							<table class="table">
							   <tr>
							      <td>계정명 : </td>
							      <td><strong>${customer.customerId}</strong></td>
							   </tr>
							   <tr>
							      <td>이름 : </td>
							      <td><strong>${customer.customerName}</strong></td>
							   </tr>
							   <tr>
							      <td>주소 : </td>
							      <td><strong>${customer.address}</strong></td>
							   </tr>
							   <tr>
							      <td>휴대폰 : </td>
							      <td><strong>${customer.customerPhone}</strong></td>
							   </tr>
							   <tr>
							      <td>포인트 : </td>
							      <td><strong>${customer.point}P</strong></td>
							   </tr>
							</table>
							<!-- 수정/탈퇴 -->
							<a href="${pageContext.request.contextPath}/customer/customerModify" class="primary-btn">수정하기</a>
							<a href="${pageContext.request.contextPath}/customer/customerRemove" class="primary-btn">회원탈퇴</a>
  						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br><br>
	
   	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>
</body>
</html>