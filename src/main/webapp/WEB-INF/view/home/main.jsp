<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 | 전통주의 모든것, 934마켓</title>
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
	  
	 a:link { color: red; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: blue; text-decoration: underline;}
</style>

</head>

<body>
	<!-- 상단 네비메뉴 -->
	<div>
		<jsp:include page="/inc/mainNavMenu.jsp"></jsp:include>
	</div>	
	
	<!-- 카테고리 네비메뉴 -->
	<jsp:include page="/inc/goodsListNavMenu.jsp"></jsp:include>

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row ">

                <div class="col-lg-12">
                    <div class="hero__item set-bg" data-setbg="${pageContext.request.contextPath}/resources/img/hero/b.jpg">

                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Categories Section Begin -->
	<div class="section-title">
		<h2>이번 주 934 PICK!</h2>
    </div>
    <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="${pageContext.request.contextPath}/upload/우주멜론미.jpg">
                            <h5><a href="#">우주멜론미</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="${pageContext.request.contextPath}/upload/요새로제.jpg">
                            <h5><a href="#">요새로제</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="${pageContext.request.contextPath}/upload/허니문배.jpg">
                            <h5><a href="#">허니문배</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="${pageContext.request.contextPath}/upload/매실원주.jpg">
                            <h5><a href="#">매실원주</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="${pageContext.request.contextPath}/upload/니모메.jpg">
                            <h5><a href="#">니모메</a></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section End -->

    <!-- 신상품 Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>신상품</h2>
                    </div>
				</div>                    
				<div class="center">				
					<table>
						<tr>
							<!-- 
								varStatus 변수속성
								${s.current} 현재 for문의 해당하는 번호
								${s.index} 0부터의 순서
								${s.count} 1부터의 순서
								${s.first} 첫 번째인지 여부
								${s.last} 마지막인지 여부
								${s.begin} for문의 시작 번호
								${s.end} for문의 끝 번호
								${s.step} for문의 증가값				
							-->
							<c:forEach var="n" items="${newList}" varStatus="s">
								<c:if test="${s.index != 0 && s.index % 4 == 0}">
									</tr><tr>
								</c:if>						
								<td>
									<div>
										<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${n.goodsCode}">
											<img src="${pageContext.request.contextPath}/upload/${n.filename}" width="200" height="250" style="margin-left: 20px; margin-bottom: 10px;">
										</a>
										<div class="featured__item__text">
											<h6>${n.goodsName}</h6>							
											<h5>${n.goodsPrice}원</h5>
										</div>
											<c:if test="${n.soldout == 'Y'}">
												<span value="${n.soldout}" id="soldout">품절</span>
											</c:if>						
									</div>
								</td>
							</c:forEach>
						</tr>
					</table>
				</div>                        
             </div>               
        </div>
    </section>
    <!-- Featured Section End -->
    
    
    <!-- 인기상품 Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>인기상품</h2>
                    </div>
				</div>                    
				<div class="center">				
					<table>
						<tr>
							<!-- 
								varStatus 변수속성
								${s.current} 현재 for문의 해당하는 번호
								${s.index} 0부터의 순서
								${s.count} 1부터의 순서
								${s.first} 첫 번째인지 여부
								${s.last} 마지막인지 여부
								${s.begin} for문의 시작 번호
								${s.end} for문의 끝 번호
								${s.step} for문의 증가값				
							-->
							<c:forEach var="h" items="${hitList}" varStatus="s">
								<c:if test="${s.index != 0 && s.index % 4 == 0}">
									</tr><tr>
								</c:if>						
								<td>
									<div>
										<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${h.goodsCode}">
											<img src="${pageContext.request.contextPath}/upload/${h.filename}" width="200" height="250" style="margin-left: 20px; margin-bottom: 10px;">
										</a>
										<div class="featured__item__text">
											<h6>${h.goodsName}</h6>							
											<h5>${h.goodsPrice}원</h5>
										</div>
											<c:if test="${h.soldout == 'Y'}">
												<span value="${h.soldout}" id="soldout">품절</span>
											</c:if>						
									</div>
								</td>
							</c:forEach>
						</tr>
					</table>
				</div>                        
             </div>               
        </div>
    </section>
    <!-- Featured Section End -->

    <!-- Banner Begin -->
    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-2.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner End -->

 



	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>
</body>

</html>