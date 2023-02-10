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

  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
  
<style>

.center {
	  margin-left: auto;
	  margin-right: auto;
	}
	
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
  width: 270px;
}	
.button2 {
  background-color: #4CAF50; 
  color: white; 
  width: 270px;
}	
input[type=number]::-webkit-inner-spin-button, 
input[type=number]::-webkit-outer-spin-button {
  opacity: 1;
}
#goodsQuantity {
  width: 100px;
  height: 50px;
  font-size: 30px;
  
 }
#totalPrice {
  width: 180px;
  height: 50px;
  font-size: 50px;
  border:none;
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
                        <div>
                            <img src="${pageContext.request.contextPath}/upload/${map.filename}" width="530" height="660">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${map.goodsName}</h3>                        
                        <p>#${map.goodsContent}</p>
						<strong>주종: ${map.categoryName}</strong><br>
						<strong>도수: ${map.goodsAlcohol}%</strong><br>
						<strong>용량: ${map.goodsLiter}ml</strong><br>
						배송기간:2일 이내 배송<br>
						<br>
						<strong>판매가격:</strong><br>                       	
   						<div class="product__details__price"><fmt:formatNumber value="${map.goodsPrice}" pattern="#,###원" /></div>                          						
	                    	<input type="number" name="goodsPrice" id="goodPrice" value="${map.goodsPrice}"   hidden="hidden"> 						
 						<strong>유통기한: 유통기한 없음</strong><br>
						<strong>보관방법: 상온 보관 가능</strong><br>                                     
                        <ul>
                        	<li>
                        		<div class="product__details__quantity">                         	                         
                       				<input type="number" name="goodsQuantity" id="goodsQuantity" min="1" max="10" value="1" style="text-align:center"> 
                        		</div>
	                        </li>
	                        <li>
	                        	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	                        	총 가격(￦)&emsp; <input type="text" name="totalPrice" id="totalPrice" readonly="readonly" style="text-align:center" value="${map.goodsPrice}">                       
                       		</li>
                        </ul>
                        <br>
                        <div>
                        	<button type="button" onclick="return submit2(this.form);" class="button button1">장바구니</button>
                        	<button type="submit" class="button button2">구매하기</button>
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