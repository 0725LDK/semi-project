<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>934마켓 장바구니 | 전통주의 모든것, 934마켓</title>
	<!-- 메인 네비메뉴 -->
	<jsp:include page="/inc/customerCss.jsp"></jsp:include>
</head>
<body>
	<!-- 상단 네비메뉴 -->
	<div>
		<jsp:include page="/inc/mainNavMenu.jsp"></jsp:include>
	</div>	

	<!-- 카테고리 네비메뉴 -->
	<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>

    <!-- 장바구니 테이블 리스트 -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <!-- 장바구니에 상품 없을때 -->
                        <div class="text-center">
	                        <c:if test="${empty productList && empty list}">
								장바구니에 담긴 상품이 없습니다.
								<div class="row">
					                <div class="col-lg-12"><br>
					                    <div class="shoping__cart__btns">
					                        <a href="${pageContext.request.contextPath}/home/main" class="primary-btn cart-btn">상품추가 하러가기</a>
					                    </div>
					                </div>
					            </div>
							</c:if>
						</div>
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
    
	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>
</body>

</html>