<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>934마켓 장바구니 주문하기 | 전통주의 모든것, 934마켓</title>
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

    <!-- 장바구니 주문테이블 리스트 -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>상품코드</th>
                                    <th>이미지</th>
                                    <th>상품명</th>
                                    <th>상품가격</th>
                                    <th>수량</th>
                                    <th>가격</th>
                                    <th>삭제</th>
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
	                                    <td>${l.cartQuantity}개</td>
	                                    <td><fmt:formatNumber value="${l.goodsPrice * l.cartQuantity}" pattern="#,###"/>원</td>
	                                    <td>
	                                    	<a href="${pageContext.request.contextPath}/customer/customerCartRemove?goodsCode=${l.goodsCode}">
	                                        	<span class="icon_close"></span>
	                                        </a>
	                                    </td>
	                                </tr>
                                </c:forEach>
                                <tr>
									<td colspan="6" style="color:red">&#10071;상품의 옵션 및 수량 변경은 상품상세 또는 장바구니에서 가능합니다.</td>
								</tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="${pageContext.request.contextPath}/home/main" class="primary-btn cart-btn">쇼핑 더하기</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>배송정보</h5>
                            <form method="post" id="form" action="${pageContext.request.contextPath}/customer/customerCartOrder?orderPrice=${m.sumPrice}">
                           		<table>
									<tr>
										<td>받으시는 분 <span style="color:red">*</span></td>
										<td><input type="text" style="width:385px" value="${customer.customerName}"></td>
									</tr>
									<tr>
										<td>
											주소추가 <br>
											주소선택 <span style="color:red">*</span>
										</td>
										<td>
											<select name="newAddress">
												<option value="서울특별시">서울특별시</option>
												<option value="인천광역시">인천광역시</option>
												<option value="부산광역시">부산광역시</option>
												<option value="대전광역시">대전광역시</option>
												<option value="대구광역시">대구광역시</option>
												<option value="울산광역시">울산광역시</option>
												<option value="광주광역시">광주광역시</option>
												<option value="경기도">경기도</option>
												<option value="강원도">강원도</option>
												<option value="충청도">충청도</option>
												<option value="전라도">전라도</option>
												<option value="경상도">경상도</option>
												<option value="제주특별자지도">제주특별자지도</option>
											</select>
											<button type="button" onclick="return submit2(this.form);">주소추가</button>
											<br>
											<select name="address">
												<c:forEach var="ca" items="${ca}">
													<option value="${ca.address}">${ca.address}</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<td>전화번호 <span style="color:red">*</span></td>
										<td><input type="text" style="width:385px" value="${customer.customerPhone}"></td>
									</tr>
									<tr>
										<td>배송메세지</td>
										<td><textarea rows="5" cols="50"></textarea></td>
									</tr>
								</table>
							</form>                      
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>
                            <li>총 수량 <span>${n.sumQuantity}개</span></li>
                            <li>총 가격 <span><fmt:formatNumber value="${m.sumPrice}" pattern="#,###"/>원</span></li>
                        </ul>
                        <button type="submit" form="form" class="primary-btn col-lg-12" style="color:white;" >구매하기</button>
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
<script>
	// 주소추가 버튼 클릭시 action변경
	function submit2(fo) {
		fo.action='${pageContext.request.contextPath}/customer/customerCartAddAddress';
		fo.submit();
		return true;
	}
</script>
</html>