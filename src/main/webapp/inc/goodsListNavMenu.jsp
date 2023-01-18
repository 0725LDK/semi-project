<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 상품 네비 메뉴 -->
<a href="${pageContext.request.contextPath}/goods/goodsMain">전체상품</a>
<a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=1">${m.categoryName}탁주</a>
<a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=2">${m.categoryName}청주</a>
<a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=3">${m.categoryName}과실주</a>
<a href="${pageContext.request.contextPath}/goods/goodsList?goodsCategory=4">${m.categoryName}증류주</a>
<a href="${pageContext.request.contextPath}/notice/noticeList">이벤트</a>

