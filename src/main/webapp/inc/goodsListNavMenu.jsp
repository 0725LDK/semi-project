<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                
                                <li>전통주의 모든것, 934마켓 </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-shopping-bag"></i></a>
                            </div>
                            <div class="header__top__right__auth">
                                <a href="${pageContext.request.contextPath}/home/login"><i class="fa fa-user"></i> 로그인</a>
                            </div>
                        </div>
                   </div>
                </div>
            </div>
        </div>
        <div class="container center" >
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="${pageContext.request.contextPath}/home/intro"><img src="${pageContext.request.contextPath}/resources/img/logo.png" style=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
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
                            <li><a href="${pageContext.request.contextPath}/#">마이페이지</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
