<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
	    <div class="col-lg-3">
	        <div class="header__logo">
	            <a href="./index.html"><img src="img/logo.png" alt=""></a>
	        </div>
	    </div>
	    <div class="col-lg-6">
	        <nav class="header__menu">
	            <ul>
					<!-- 고객 로그인시 -->
					<c:if test="${loginCustomer.customerId ne null}">	            
		                <li class="active"><a href="${pageContext.request.contextPath}/home/main">홈</a></li>
		                <li><a href="${pageContext.request.contextPath}/goods/goodsMain">전체상품</a></li>
		                <li><a href="#">카테고리</a>
		                    <ul class="header__menu__dropdown">
		                 <li><a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=1">${m.categoryName}탁주</a></li>
		                 <li><a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=2">${m.categoryName}청주</a></li>
		                 <li><a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=3">${m.categoryName}과실주</a></li>
		                 <li><a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=4">${m.categoryName}증류주</a></li>
		                    </ul>
		                </li>                                              
		                <li><a href="${pageContext.request.contextPath}/notice/noticeList">이벤트</a></li>
		                <li><a href="${pageContext.request.contextPath}/customer/customerOne">마이페이지</a></li>
	            	</c:if>
	            	
					<!-- 직원 로그인시 -->
					<c:if test="${loginEmp.empId ne null}">	            	
		                <li class="active"><a href="${pageContext.request.contextPath}/home/main">홈</a></li>
		                <li><a href="${pageContext.request.contextPath}/goods/goodsMain">전체상품</a></li>
		                <li><a href="#">카테고리</a>
		                    <ul class="header__menu__dropdown">
		                 <li><a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=1">${m.categoryName}탁주</a></li>
		                 <li><a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=2">${m.categoryName}청주</a></li>
		                 <li><a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=3">${m.categoryName}과실주</a></li>
		                 <li><a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=4">${m.categoryName}증류주</a></li>
		                    </ul>
		                </li>                                              
		                <li><a href="${pageContext.request.contextPath}/notice/noticeList">이벤트</a></li>
		                <li><a href="${pageContext.request.contextPath}/emp/empOne">마이페이지</a></li>
					</c:if>	            	
	            	
	            </ul>
	        </nav>
	    </div>
	</div>
	<div class="humberger__open">
	    <i class="fa fa-bars"></i>
	</div>
</div>

