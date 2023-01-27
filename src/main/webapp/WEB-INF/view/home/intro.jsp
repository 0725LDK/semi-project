<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 | 전통주의 모든것, 934마켓</title>
<!-- 메인 네비메뉴 -->
<jsp:include page="/inc/customerCss.jsp"></jsp:include>

<style type="text/css">
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

    
    <br>
    <br>
    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row ">

                <div class="col-lg-12">
                    <div class="hero__item set-bg" data-setbg="${pageContext.request.contextPath}/resources/img/hero/f.jpg">
                        <div class="hero__text center">

                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->    

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row ">

                <div class="col-lg-12">
                    <div class="hero__item set-bg" data-setbg="${pageContext.request.contextPath}/resources/img/hero/g.jpg">
                        <div class="hero__text center">

                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->    
    
	<!-- Footer 네비 -->
	<div>
		<jsp:include page="/inc/customerFooter.jsp"></jsp:include>
	</div>
</body>	
</html>