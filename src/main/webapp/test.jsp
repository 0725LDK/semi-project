<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>jQuery</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$( document ).ready( function() {
			$( '#cellCost, #num' ).change( function() {
				var cellCost = $( '#cellCost' ).val();
				var num = $( '#num' ).val();
				var totalPrice = cellCost * num;
				$( '#totalPrice' ).text( totalPrice );
			} );
		} );
	</script>

</head>
<body>
    
    <!-- 네비메뉴 -->
   <div>
      <jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>
   </div>
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
         <th>주종: ${map.goodsCategory}</th>   

      </tr>
      <tr>
         <th>도수: ${map.goodsAlcohol}</th>   

      </tr>
      <tr>
         <th>용량: ${map.goodsLiter}</th>

      </tr>
      <tr>
         <th>판매 가격:<input type="number" id="cellCost" value="10000" ></th>

      </tr>
      <tr>
         <th>수량 : <input type="number" id="num" ></th> 
      </tr>
      <tr>
         <th>총 가격 : <span id="totalPrice"></span></th> 
      </tr>
      
   </table>   
   
            
          

   <div>
      <a href="${pageContext.request.contextPath}/customer/customerCart">장바구니</a>
      <a href="${pageContext.request.contextPath}/customer/customerOrder?goodsCode=${map.goodsCode}">구매하기</a>         
   </div>

  </body>
</html>