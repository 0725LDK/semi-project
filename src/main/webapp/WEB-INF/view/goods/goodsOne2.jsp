<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>934마켓 전체상품 | 전통주의 모든것, 934마켓</title>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- 메인 네비메뉴 -->
<jsp:include page="/inc/customerCss.jsp"></jsp:include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<style>

	.center {
	  margin-left: auto;
	  margin-right: auto;
	}
 /**	
	input[type="number"]{
		width: 5em;
	}
	input[type="text"]{
		width: 5em;
	}
	
	input {
  width:30px;
  height:30px;
  font-size:15px;
 **/
}
	
</style>


	<script>
		$( document ).ready( function() {
			$( '#goodsPrice, #goodsQuantity' ).change( function() {
				var goodsPrice = parseInt($('#goodPrice' ).val());
				var goodsQuantity = parseInt($('#goodsQuantity').val());
				var totalPrice = parseInt(goodsPrice * goodsQuantity);
				$('input[name=totalPrice]').attr('value',totalPrice);
				//$("#totalPrice").text(totalPrice);
				console.log($('#goodPrice' ).val());
				console.log(goodsQuantity);
				console.log(totalPrice);
				console.log(typeof goodsPrice);
				console.log(typeof goodsQuantity);
				console.log(typeof totalPrice);
			} );
		} );
		//장바구니 버튼 submit
		function submit2(fo) { 
			fo.action='${pageContext.request.contextPath}/customer/customerCart';
			fo.submit();
			return true;
		}
		

	</script>

</head>
<body>
	<!-- 상단 네비메뉴 -->
	<div>
		<jsp:include page="/inc/mainNavMenu.jsp"></jsp:include>
	</div>	

	<!-- 카테고리 네비메뉴 -->
	<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>
	
	<!-- 배너 네비메뉴 -->
	<jsp:include page="/inc/banner.jsp"></jsp:include>


	<br>
    <!-- Product Details Section Begin -->
    <section class="product-details spad">
    <form action="${pageContext.request.contextPath}/customer/customerOrder" method="get">
    	<input type="hidden" name="goodsCode" value="${map.goodsCode}">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-6 col-md-6">
	                    <div class="product__details__pic">
	                        
	                            <img src="${pageContext.request.contextPath}/upload/${map.filename}" alt="" width="200" height="250">
	                       
	
	                    </div>
	                </div>
	                <div class="col-lg-6 col-md-6">
	                    <div class="product__details__text">
	                        <h3>${map.goodsName}</h3>

	                        <ul>
	                            <li><b>주종</b> <span>${map.categoryName}</span></li>
	                            <li><b>도수</b> <span>${map.goodsAlcohol}%</span></li>
	                            <li><b>용량</b> <span>${map.goodsLiter}ml</span></li>	
	                        </ul>
	                        <ul>
	                            <li><b>판매 가격</b> <span><input type="number" name="goodsPrice" id="goodPrice" value="${map.goodsPrice}" readonly="readonly">원</span></li>
	                            <li><b>수량</b> <span><input type="number" name="goodsQuantity" id="goodsQuantity" min="0"></span></li>
	                            <li><b>총 가격(￦)</b> <span><input type="text" name="totalPrice" id="totalPrice" >원 </span></li>	
	                        </ul>
	                        <button type="submit" class="primary-btn">구매하기</button>
	                        <button type="button" class="heart-icon" onclick="return submit2(this.form);"><span class="icon_heart_alt"></span>장바구니</button>		
	                    </div>
	                </div>	
	            </div>
	        </div>
	    </form>
    </section>
    <!-- Product Details Section End -->
		
		
		
		
		
	<form action="${pageContext.request.contextPath}/customer/customerOrder" method="get">
		<input type="hidden" name="goodsCode" value="${map.goodsCode}">
		<table>
			<tr>
				<td rowspan="10">
					<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="200" height="250">
				</td>
				<th>${map.goodsName}</th>
			</tr>
			<tr>
				<td>${map.goodsContent}</td>		
			</tr>
			<tr>
				<th>주종: ${map.categoryName}</th>	
	
			</tr>
			<tr>
				<th>도수: ${map.goodsAlcohol}%</th>	
	
			</tr>
			<tr>
				<th>용량: ${map.goodsLiter}ml</th>	
	
			</tr>
			<tr>
				<th>판매 가격: <input type="number" name="goodsPrice" id="goodPrice" value="${map.goodsPrice}" readonly="readonly">원</th>
			</tr>		
			<tr>
				<th>
					수량 :  <input type="number" name="goodsQuantity" id="goodsQuantity" >병
				</th>
			</tr>	
		
			
			<tr>
				<th>
					총 가격(￦) : <input type="text" name="totalPrice" id="totalPrice" >원 
				</th>
			</tr>
		</table>	
		<button type="button" onclick="return submit2(this.form);">장바구니</button>		
		<button type="submit">구매하기</button>
	</form>
	
	
    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h6><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click here</a> to enter your code
                    </h6>
                </div>
            </div>
            <div class="checkout__form">
                <h4>Billing Details</h4>
                <form action="#">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Fist Name<span>*</span></p>
                                        <input type="text">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Last Name<span>*</span></p>
                                        <input type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>Country<span>*</span></p>
                                <input type="text">
                            </div>
                            <div class="checkout__input">
                                <p>Address<span>*</span></p>
                                <input type="text" placeholder="Street Address" class="checkout__input__add">
                                <input type="text" placeholder="Apartment, suite, unite ect (optinal)">
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Phone<span>*</span></p>
                                        <input type="text">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Email<span>*</span></p>
                                        <input type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input__checkbox">
                                <label for="acc">
                                    Create an account?
                                    <input type="checkbox" id="acc">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <p>Create an account by entering the information below. If you are a returning customer
                                please login at the top of the page</p>
                            <div class="checkout__input">
                                <p>Account Password<span>*</span></p>
                                <input type="text">
                            </div>
                            <div class="checkout__input__checkbox">
                                <label for="diff-acc">
                                    Ship to a different address?
                                    <input type="checkbox" id="diff-acc">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="checkout__input">
                                <p>Order notes<span>*</span></p>
                                <input type="text"
                                    placeholder="Notes about , e.g. special notes for delivery.">
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="checkout__order">
                                <h4>Your Order</h4>
                                <div class="checkout__order__products">Products <span>Total</span></div>
                                <ul>
                                    <li>Vegetable’s Package <span>$75.99</span></li>
                                    <li>Fresh Vegetable <span>$151.99</span></li>
                                    <li>Organic Bananas <span>$53.99</span></li>
                                </ul>
                                <div class="checkout__order__subtotal">Subtotal <span>$750.99</span></div>
                                <div class="checkout__order__total">Total <span>$750.99</span></div>
                                
                                <button type="submit" class="site-btn">PLACE ORDER</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<h4>고객 리뷰</h4>
	<c:forEach var="m" items="${list}">
		<div>
			<div>
				<span>고객 아이디 : ${m.customerId}</span>
			</div>
			<div>
				<p>
					댓글 내용 : ${m.reviewMemo}
				</p>
			</div>
			<div>
				<span>댓글 작성일 : ${m.createdate}</span>
			</div>			
		</div>
	</c:forEach>






	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>


</body>
</html>