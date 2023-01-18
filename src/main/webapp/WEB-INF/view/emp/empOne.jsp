<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 관리자 메인 페이지 | 전통주의 모든것, 934마켓</title>
	
	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$.fn.dataTable.ext.errMode = 'throw';
	</script>
	
</head>
<body>
<div class="container-scroller">
	<!-- partial:partials/_navbar.html -->
	<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
		<div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
			<a class="navbar-brand brand-logo mr-5" href="index.html"><img src="${pageContext.request.contextPath}/resource1/images/logo.svg" class="mr-2" alt="logo"/></a>
			<a class="navbar-brand brand-logo-mini" href="index.html"><img src="${pageContext.request.contextPath}/resource1/images/logo-mini.svg" alt="logo"/></a>
		</div>
		<div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
			<button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
				<span class="icon-menu"></span>
			</button>
		
			<ul class="navbar-nav navbar-nav-right">
				<li class="nav-item nav-profile dropdown">
					<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
						<img src="${pageContext.request.contextPath}/resource1/images/faces/face.jpg" alt="profile"/>
					</a>
					<div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/emp/empList">
							<i class="ti-settings text-primary"></i>
							Settings
						</a>
						<a class="dropdown-item" href="${pageContext.request.contextPath}/logout">
							<i class="ti-power-off text-primary"></i>
							Logout
						</a>
					</div>
				</li>
			</ul>
		</div>
	</nav>
<!-- partial -->
<div class="container-fluid page-body-wrapper">



<!-- partial -->
<!-- partial:partials/_sidebar.html -->
<nav class="sidebar sidebar-offcanvas" id="sidebar">
<ul class="nav">
<li class="nav-item">
<a class="nav-link" data-toggle="collapse" href="#error" aria-expanded="false" aria-controls="error">
<i class="icon-layout menu-icon"></i>
<span class="menu-title">회원 관리</span>
<i class="menu-arrow"></i>
</a>
<div class="collapse" id="error">
<ul class="nav flex-column sub-menu">
<li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/empCustomerList"> 회원 정보 </a></li>
<li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/empCustomerOrder"> 회원 주문 내역 </a></li>
<li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/empCustomerCancle"> 회원 취소/환불 내역 </a></li>
<li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/empCustomerReviewList"> 회원 리뷰 작성/삭제 내역</a></li>
</ul>
</div>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/emp/empList">
<i class="icon-columns menu-icon"></i>
<span class="menu-title">직원 정보</span>
</a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/emp/empGoodsList">
<i class="icon-bar-graph menu-icon"></i>
<span class="menu-title">상품 관리</span>
</a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/emp/empNoticeList">
<i class="icon-grid-2 menu-icon"></i>
<span class="menu-title">이벤트 관리</span>
</a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/emp/empQuestion">
<i class="icon-contract menu-icon"></i>
<span class="menu-title">고객센터</span>
</a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/emp/empSum">
<i class="icon-head menu-icon"></i>
<span class="menu-title">판매 데이터</span>
</a>
</li>
</ul>
</nav>

	<!-- partial -->
<div class="main-panel">
<div class="content-wrapper">
<div class="row">
<div class="col-md-12 grid-margin">
<div class="row">
         
</div>
</div>
</div>
<div class="row">
</div>
<div class="row">
<div class="col-md-6 grid-margin stretch-card">
</div>
</div>


    
    
</div>
<!-- content-wrapper ends -->
<!-- partial:partials/_footer.html -->
<footer class="footer">
<div class="d-sm-flex justify-content-center justify-content-sm-between">
<span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2021.  Premium <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap admin template</a> from BootstrapDash. All rights reserved.</span>
</div>
<div class="d-sm-flex justify-content-center justify-content-sm-between">
<span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Distributed by <a href="https://www.themewagon.com/" target="_blank">Themewagon</a></span> 
</div>
</footer> 
<!-- partial -->
</div>
<!-- main-panel ends -->
</div>   
    <!-- page-body-wrapper ends -->
	
	
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<h1>관리자 페이지(기본)</h1>
	
	<!-- 네비메뉴 -->
	<div>
		<jsp:include page="/inc/empOneNavMenu.jsp"></jsp:include>
	</div>
	
	<div> 환영 합니다. ${loginEmp.empId}님 
		<c:choose>
			<c:when test="${loginEmp.authCode == 0}">
				전체관리자
			</c:when>
			<c:when test="${loginEmp.authCode == 1}">
				상품관리자
			</c:when>
			<c:when test="${loginEmp.authCode == 2}">
				고객관리자
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${loginEmp.active eq 'N'}">
				[사용불가]
			</c:when>
			<c:when test="${loginEmp.active eq 'Y'}">
				[사용가능]
			</c:when>
		</c:choose>
	</div>
	
	<div>
		<c:if test="${loginEmp.authCode == 1 && loginEmp.active eq 'Y'}">
			<a href="${pageContext.request.contextPath}/emp/empGoodsList">상품 관리</a>
			<a href="${pageContext.request.contextPath}/emp/empNoticeList">이벤트 관리</a>
		</c:if>
		<c:if test="${loginEmp.authCode == 2 && loginEmp.active eq 'Y'}">
			<a href="${pageContext.request.contextPath}/emp/empQuestion">고객센터</a>
		</c:if>
	</div>
	
	
	
	<div>
		<jsp:include page="/inc/empFooterScript.jsp"></jsp:include>
	</div>
</body>
</html>