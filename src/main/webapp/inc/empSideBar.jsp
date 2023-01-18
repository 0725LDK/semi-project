<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/emp/empOne">
							<i class="icon-paper menu-icon"></i>
							<span class="menu-title">메인 페이지</span>
						</a>
					</li>
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