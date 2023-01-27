<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<title>934마켓 주문하기 | 전통주의 모든것, 934마켓</title>
	<!-- 메인 네비메뉴 -->
	<jsp:include page="/inc/customerCss.jsp"></jsp:include>
	<script>
		$( document ).ready( function() {
			var point = parseInt($('#usedPoint').val());
			var usedPoint = point * (-1);
			var orderPrice = parseInt($('#orderPrice').val());
			var totalPrice = orderPrice - point; 
			$('#pointUse').click(function(){
				$('#pointUse').hide();
				$('input[name=orderPrice]').attr('value',totalPrice);
				$('input[name=usedPoint]').attr('value',usedPoint);
				console.log(point);
				console.log(orderPrice);
				console.log(totalPrice);
				console.log(typeof point);
				console.log(typeof orderPrice);
				console.log(typeof totalPrice);
			});
		});
	</script>
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
                        <form action="${pageContext.request.contextPath}/customer/customerOrder" id="form" method="post">
	                        <input type="hidden" name="address" value="${customer.address}">
	                        <input type="hidden" name="customerId" value="${loginCustomer.customerId}">
	                        <table>
	                            <thead>
	                                <tr>
	                                    <th>상품코드</th>
	                                    <th>이미지</th>
	                                    <th>상품명</th>
	                                    <th>수량</th>
	                                    <th>가격</th>
	                                    <th>사용 가능한 포인트</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                                <tr>
	                                	<td><input type="text" name="goodsCode" value="${map.goodsCode}" style="border:0 solid black;text-align:center;"></td>
	                                    <td>
	                                        <img src="${pageContext.request.contextPath}/upload/${map.filename}" width="80" height="80">
	                                    </td>
	                                    <td><input type="text" name="goodsName" value="${map.goodsName}" style="border:0 solid black;text-align:center;"></td>
	                                    <td><input type="text" name="orderQuantity" value="${goodsQuantity}" style="border:0 solid black;text-align:center;"></td>
	                                    <td><input type="text" name="orderPrice" id="orderPrice" value="${totalPrice}" style="border:0 solid black;text-align:center;"></td>
	                                	<td>
											<input name="usedPoint" id="usedPoint" value="${customer.point}" readonly="readonly"><br>
											<button type="button" id="pointUse">포인트 사용</button>
										</td>
	                                </tr>
	                            </tbody>
	                        </table>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="${pageContext.request.contextPath}/home/main" class="primary-btn cart-btn">다른상품 보기</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>배송정보</h5>
                          		<table style="text-align:center;">
								<tr>
									<td>받으시는 분 <span style="color:red">*</span></td>
									<td><input type="text" style="width:385px;text-align:center;" value="${customer.customerName}" readonly="readonly"></td>
								</tr>
								<tr>
									<td>
										주소 <span style="color:red">*</span>
									</td>
									<td>
										<input type="text" style="width:385px;text-align:center;" value="${customer.address}" readonly="readonly">
									</td>
								</tr>
								<tr>
									<td>전화번호 <span style="color:red">*</span></td>
									<td><input type="text" style="width:385px;text-align:center;" value="${customer.customerPhone}" readonly="readonly"></td>
								</tr>
								<tr>
									<td>배송메세지</td>
									<td><textarea rows="5" cols="50"></textarea></td>
								</tr>
							</table>            
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>
                            <li>총 수량 <input value="${goodsQuantity}개" style="border:0; background: transparent; text-align:right; width:400px" readonly="readonly"></li>
                            <li>총 가격 <input name="orderPrice" id="orderPrice" value="${totalPrice}" style="border:0; background: transparent; text-align:right; width:400px" readonly="readonly"></li>
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
</html>