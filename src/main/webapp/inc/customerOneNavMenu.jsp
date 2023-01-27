<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container center">
    <div class="row">
        <div class="col-lg-3">
            <div class="header__logo">
                <a href="${pageContext.request.contextPath}/home/intro"><img src="${pageContext.request.contextPath}/resources/img/logo.png" style=""></a>
            </div>
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

