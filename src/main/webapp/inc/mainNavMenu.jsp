<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header Section Begin -->
   <header class="header">
       <div class="header__top">
           <div class="container">
               <div class="row">
                   <div class="col-lg-6 col-md-6">
                       <div class="header__top__left">
                           <ul>
                               <li><a href="${pageContext.request.contextPath}/home/intro"><img src="${pageContext.request.contextPath}/resources/img/m.png" alt="" width="70" height="30"></a></li>
                               <li><a href="${pageContext.request.contextPath}/home/main">934마켓</a></li>
                           </ul>
                       </div>
                   </div>
                   <div class="col-lg-6 col-md-6">
                       <div class="header__top__right">
                           <div class="header__top__right__social">
                               <a href="${pageContext.request.contextPath}/customer/customerCart"><i class="fa fa-shopping-bag"></i></a>
                           </div>
                           <div class="header__top__right__social">
                            <!-- 로그인 안되어 있으면 -->
							<c:if test="${loginCustomer eq null && loginEmp eq null}">
								<a href="${pageContext.request.contextPath}/home/login"><i class="fa fa-user"></i>로그인</a>
							</c:if>
						
							<!-- 고객 로그인시 -->
							<c:if test="${loginCustomer.customerId ne null}">
								<a href="${pageContext.request.contextPath}/customer/customerOne">${loginCustomer.customerId}님, 반갑습니다.</a>
								<a href="${pageContext.request.contextPath}/logout">로그아웃</a>							
							</c:if>
							<!-- 직원 로그인시 -->
							<c:if test="${loginEmp.empId ne null}">
								<a href="${pageContext.request.contextPath}/emp/empOne">${loginEmp.empId}님, 반갑습니다.</a>
								<a href="${pageContext.request.contextPath}/logout">로그아웃</a>							
							</c:if>
                           </div>
                       </div>
                  </div>
               </div>
           </div>
       </div>
   </header>
<!-- Header Section End -->