<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>934마켓 장바구니 | 전통주의 모든것, 934마켓</title>
	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
	<!-- Css Styles -->
	<link rel="stylesheet" href="../resources/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="../resources/css/font-awesome.min.css" type="text/css">
	<link rel="stylesheet" href="../resources/css/elegant-icons.css" type="text/css">
	<link rel="stylesheet" href="../resources/css/nice-select.css" type="text/css">
	<link rel="stylesheet" href="../resources/css/jquery-ui.min.css" type="text/css">
	<link rel="stylesheet" href="../resources/css/owl.carousel.min.css" type="text/css">
	<link rel="stylesheet" href="../resources/css/slicknav.min.css" type="text/css">
	<link rel="stylesheet" href="../resources/css/style.css" type="text/css">
</head>
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="../resources/img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="../resources/img/language.png" alt="">
                <div>English</div>
                <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">Spanis</a></li>
                    <li><a href="#">English</a></li>
                </ul>
            </div>
            <div class="header__top__right__auth">
                <a href="#"><i class="fa fa-user"></i> Login</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a href="./shop-grid.html">Shop</a></li>
                <li><a href="#">Pages</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="./shop-details.html">Shop Details</a></li>
                        <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                        <li><a href="./checkout.html">Check Out</a></li>
                        <li><a href="./blog-details.html">Blog Details</a></li>
                    </ul>
                </li>
                <li><a href="./blog.html">Blog</a></li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                <li>Free Shipping for all Order of $99</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                                <li>Free Shipping for all Order of $99</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <div class="header__top__right__language">
                                <img src="../resources/img/language.png" alt="">
                                <div>English</div>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Spanis</a></li>
                                    <li><a href="#">English</a></li>
                                </ul>
                            </div>
                            <div class="header__top__right__auth">
                                <a href="#"><i class="fa fa-user"></i> Login</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="../resources/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="./index.html">Home</a></li>
                            <li class="active"><a href="./shop-grid.html">Shop</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./shop-details.html">Shop Details</a></li>
                                    <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                                    <li><a href="./checkout.html">Check Out</a></li>
                                    <li><a href="./blog-details.html">Blog Details</a></li>
                                </ul>
                            </li>
                            <li><a href="./blog.html">Blog</a></li>
                            <li><a href="./contact.html">Contact</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span>$150.00</span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            <li><a href="#">Fresh Meat</a></li>
                            <li><a href="#">Vegetables</a></li>
                            <li><a href="#">Fruit & Nut Gifts</a></li>
                            <li><a href="#">Fresh Berries</a></li>
                            <li><a href="#">Ocean Foods</a></li>
                            <li><a href="#">Butter & Eggs</a></li>
                            <li><a href="#">Fastfood</a></li>
                            <li><a href="#">Fresh Onion</a></li>
                            <li><a href="#">Papayaya & Crisps</a></li>
                            <li><a href="#">Oatmeal</a></li>
                            <li><a href="#">Fresh Bananas</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="../resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Shopping Cart</h2>
                        <div class="breadcrumb__option">
                            <a href="${pageContext.request.contextPath}/home/main">Home</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- 장바구니 테이블 리스트 -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <!-- 장바구니에 상품 없을때 -->
                        <c:if test="${empty productList && empty list}">
							장바구니에 담긴 상품이 없습니다.
							<div class="row">
				                <div class="col-lg-12">
				                    <div class="shoping__cart__btns">
				                        <a href="${pageContext.request.contextPath}/home/main" class="primary-btn cart-btn">상품추가 하러가기</a>
				                    </div>
				                </div>
				            </div>
						</c:if>
						<!-- 회원 장바구니 리스트 -->
						<c:if test="${not empty list}">
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td>상품코드</td>
										<td>이미지</td>
										<td>상품명</td>
										<td>상품가격</td>
										<td>수량</td>
										<td>가격</td>
										<td>삭제</td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            	<c:forEach var="l" items="${list}">
	                                <tr>
	                                	<td>${l.goodsCode}</td>
	                                    <td>
	                                        <img src="${pageContext.request.contextPath}/upload/${l.filename}" width="80" height="80">
	                                    </td>
	                                    <td>${l.goodsName}</td>
	                                    <td><fmt:formatNumber value="${l.goodsPrice}" pattern="#,###"/>원</td>
	                                    <td>
	                                    	<form action="${pageContext.request.contextPath}/customer/customerCartModify">
		                                        <input type="hidden" name="goodsCode" value="${l.goodsCode}">
		                                        <div>
		                                            <div class="pro-qty">
		                                                <input type="text" name="cartQuantity" value="${l.cartQuantity}">
		                                            </div>
		                                        </div>
		                                        <button type="submit">수정</button>
	                                        </form>
	                                    </td>
	                                    <td><fmt:formatNumber value="${l.goodsPrice * l.cartQuantity}" pattern="#,###"/>원</td>
	                                    <td>
	                                    	<a href="${pageContext.request.contextPath}/customer/customerCartRemove?goodsCode=${l.goodsCode}">
	                                        	<span class="icon_close"></span>
	                                        </a>
	                                    </td>
	                                </tr>
	                                </c:forEach>
	                                <tr>
	                                	<td colspan="4">
										<td >총수량 : ${n.sumQuantity}개</td>
										<td colspan="2">총가격 : <fmt:formatNumber value="${m.sumPrice}" pattern="#,###"/>원</td>
									</tr>
	                            </tbody>
	                        </table>
	                        <br>
	                        <div class="row">
				                <div class="col-lg-12">
				                    <div class="shoping__cart__btns">
				                        <a href="${pageContext.request.contextPath}/customer/customerCartOrder" class="primary-btn cart-btn">주문하기</a>
				                        <a href="${pageContext.request.contextPath}/home/main" class="primary-btn cart-btn cart-btn-right">상품추가</a>
				                    </div>
				                </div>
				            </div>
	                    </c:if>
                        <!-- 비회원 장바구니 리스트 -->
                        <c:if test="${not empty productList}">
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td>상품코드</td>
										<td>이미지</td>
										<td>상품명</td>
										<td>상품가격</td>
										<td>수량</td>
										<td>가격</td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            	<c:forEach var="l" items="${productList}">
	                            		<tr>
											<td>${l.goodsCode}</td>
											<td>
												<img src="${pageContext.request.contextPath}/upload/${l.filename}" width="80" height="80">
											</td>
											<td>${l.goodsName}</td>
											<td><fmt:formatNumber value="${l.goodsPrice}" pattern="#,###"/>원</td>
											<td>${l.cartQuantity}개</td>
											<td><fmt:formatNumber value="${l.goodsPrice * l.cartQuantity}" pattern="#,###"/>원</td>
										</tr>
	                            	</c:forEach>
	                            </tbody>
	                        </table>
	                        <br>
	                        <div class="row">
				                <div class="col-lg-12">
				                    <div class="shoping__cart__btns">
				                        <a href="${pageContext.request.contextPath}/home/login" class="primary-btn cart-btn">로그인 후 주문하기</a>
				                        <a href="${pageContext.request.contextPath}/home/main" class="primary-btn cart-btn cart-btn-right">상품추가</a>
				                    </div>
				                </div>
				            </div>
                        </c:if>
                    </div>
                </div>
            </div>
            
        </div>
    </section>
    <!-- Shoping Cart Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.html"><img src="../resources/img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: hello@colorlib.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Useful Links</h6>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">About Our Shop</a></li>
                            <li><a href="#">Secure Shopping</a></li>
                            <li><a href="#">Delivery infomation</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Our Sitemap</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Who We Are</a></li>
                            <li><a href="#">Our Services</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Innovation</a></li>
                            <li><a href="#">Testimonials</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <script src="../resources/js/jquery.nice-select.min.js"></script>
    <script src="../resources/js/jquery-ui.min.js"></script>
    <script src="../resources/js/jquery.slicknav.js"></script>
    <script src="../resources/js/mixitup.min.js"></script>
    <script src="../resources/js/owl.carousel.min.js"></script>
    <script src="../resources/js/main.js"></script>


</body>

</html>