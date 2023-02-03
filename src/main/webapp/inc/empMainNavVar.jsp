<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
		<div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
			<img src="${pageContext.request.contextPath}/resource1/images/m.png" class="mr-2" alt="logo" width="70" height="30"/>
		</div>
		<div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
			<button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
				<span class="icon-menu"></span>
			</button>
			<ul class="navbar-nav mr-lg-2">
	          <li class="nav-item nav-search d-none d-lg-block">
	            <div class="input-group">
					<span style="font-size:20px; font-family:Avant Garde;">전통주의 모든것, 934마켓 - 관리자 페이지</span>	              
	            </div>
	          </li>
	        </ul>
			<ul class="navbar-nav navbar-nav-right">
				<li class="nav-item nav-profile dropdown">
					<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
						<img src="${pageContext.request.contextPath}/resource1/images/faces/face.png" alt="profile"/>
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