<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>jQuery</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- 메인 네비메뉴 -->
<jsp:include page="/inc/customerCss.jsp"></jsp:include>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<style>
	.soldout{
		pointer-events : none;
	}	
	.center {
	  margin-left: auto;
	  margin-right: auto;
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
<!-- 메인 상단 네비메뉴 -->
<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="${pageContext.request.contextPath}/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>934 Market</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">home</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

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
					수량 :  <input type="number" name="goodsQuantity" id="goodsQuantity">병
				</th>
			</tr>	
			<tr>
				<th>
					총 가격(￦) : <input type="text" name="totalPrice" id="totalPrice" value="">원 
				</th>
			</tr>
		</table>	
		<button type="button" onclick="return submit2(this.form);">장바구니</button>		
		<button type="submit">구매하기</button>
	</form>

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