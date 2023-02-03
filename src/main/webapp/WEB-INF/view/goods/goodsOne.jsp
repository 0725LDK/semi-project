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
	
	input {
  width:110px;
  height:30px;
  

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
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                src="${pageContext.request.contextPath}/upload/${map.filename}" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${map.goodsName}</h3>					
                        <p>#${map.goodsContent}</p>
                        <div class="product__details__price">
                        	<input type="number" name="goodsPrice" id="goodPrice" value="${map.goodsPrice}" readonly="readonly" style="border:none">원
                        </div>
                        <div class="product__details__quantity">
                            <div class="quantity">
                               <div class="pro-qty"> 
                                    <input type="number" name="goodsQuantity" id="goodsQuantity" min="0">
                               </div>
                            </div>
                        </div>
                        총 가격(￦) <input type="text" name="totalPrice" id="totalPrice" style="border:none">
                       
                        <div>
                        <br>
                        <button type="submit"  class="primary-btn">구매하기</button>
                        <button type="button" onclick="return submit2(this.form);" class="heart-icon"><span class="icon_heart_alt"></span>장바구니</button>
                        </div>
                        <ul>
                            <li><b>주종</b> <span>${map.categoryName}</span></li>
                            <li><b>도수</b> <span>${map.goodsAlcohol}%</span></li>
                            <li><b>용량</b> <span>${map.goodsLiter}ml</span></li>                            
                        </ul>
                    </div>
                </div>
               
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                    aria-selected="false">리뷰</a>
                            </li>
                        </ul>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
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
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </form>
    </section>
    <!-- Product Details Section End -->	

	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>


</body>
</html>