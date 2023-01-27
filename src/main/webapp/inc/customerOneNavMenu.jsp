<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
	
	 a:link { color: white; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: white; text-decoration: none;}
	 
</style>	

<div class="container center">
    <div class="row">
        <div class="col-lg-3">

        </div>
        <div class="col-lg-8">
            <nav class="header__menu">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/home/main">메인으로</a></li>
                    <li><a href="${pageContext.request.contextPath}/customer/customerOne">회원정보</a></li>
                    <li><a href="${pageContext.request.contextPath}/customer/customerOrderList?customerId=${customerId}">주문내역</a></li>                                     
                    <li><a href="${pageContext.request.contextPath}/customer/customerOrderCancleList?customerId=${customerId}">취소/환불내역</a></li>
                    <li><a href="${pageContext.request.contextPath}/customer/customerQuestion">고객센터</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="humberger__open">
        <i class="fa fa-bars"></i>
    </div>
</div>

