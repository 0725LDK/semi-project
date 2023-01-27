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




	<!--  이벤트 배너 클릭시 이벤트 상품 페이지로 이동 -->
	<section class="breadcrumb-section set-bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
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
				<c:if test="${s.index != 0 && s.index % 1 == 0}">
					</tr><tr>
				</c:if>
				
				<td>
					<div>
						<a href="${pageContext.request.contextPath}/notice/noticeOne?noticeCode=${m.noticeCode}&goodsCategory=${m.goodsCategory}">
							<img src="${pageContext.request.contextPath}/upload/${m.filename}" width="1000" height="300" style="margin-left: 0px; margin-bottom: 20px;">
						</a>
					</div>
				</td>
			</c:forEach>
		</tr>
	</table>
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