<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 전체상품 | 전통주의 모든것, 934마켓</title>
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
                        <h2>Organi Shop</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- 검색 시작 -->
	<br>
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="hero__search">
                        <div class="hero__search__form">
							<form method="get" action="${pageContext.request.contextPath}/goods/goodsMain">
								<c:if test="${goodsSearch != null}">
									<input class="box" type="text" name="goodsSearch" value="${goodsSearch}">
								</c:if>
								<c:if test="${goodsSearch  == null}">
									<input class="box" type="text" name="goodsSearch" placeholder="상품명을 검색하세요.">
								</c:if>
								<button class="site-btn" type="submit">검색</button>
							</form>	
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- 검색 끝 -->

    
    <!-- 신상품 Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>전체상품</h2>
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
							<c:forEach var="m" items="${list}" varStatus="s">
								<c:if test="${s.index != 0 && s.index % 4 == 0}">
									</tr><tr>
								</c:if>						
								<td>
									<c:if test="${m.soldout == 'Y'}">
										<div class="soldout">
											<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${m.goodsCode}">
												<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250" style="margin-left: 20px; margin-bottom: 10px;">
											</a>
											<div class="featured__item__text">
												<h5>${m.goodsName}</h5>
												<div value="${m.soldout}" class="soldout">품절</div>
											</div>
										</div>
									</c:if>		
									<c:if test="${m.soldout == 'N'}">
										<div>
											<a href="${pageContext.request.contextPath}/goods/goodsOne?goodsCode=${m.goodsCode}">
												<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="200" height="250" style="margin-left: 20px; margin-bottom: 10px;">
											</a>
											<div class="featured__item__text">
												<h5>${m.goodsName}</h5>												
												<h6>${m.goodsPrice}원</h6>
											</div>
										</div>
									</c:if>						
								</td>
							</c:forEach>
						</tr>
					</table>
				</div>                        
             </div>               
        </div>
    </section>
    <!-- Featured Section End -->


	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>


</body>

</html>