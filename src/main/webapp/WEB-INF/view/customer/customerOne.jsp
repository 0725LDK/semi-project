<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 회원 정보 | 전통주의 모든것, 934마켓</title>
</head>
<body>
   <h1>회원정보(기본)</h1>
   
   <!-- 네비메뉴 -->
   <div>
      <jsp:include page="/inc/customerOneNavMenu.jsp"></jsp:include>   
   </div>   
   
   <!-- 회원정보 -->
   <table>
      <tr>
         <td>계정명 : </td>
         <td>${customer.customerId}</td>
      </tr>
      <tr>
         <td>이름 : </td>
         <td>${customer.customerName}</td>
      </tr>
      <tr>
         <td>주소 : </td>
         <td>${customer.address}</td>
      </tr>
      <tr>
         <td>휴대폰 : </td>
         <td>${customer.customerPhone}</td>
      </tr>
      <tr>
         <td>포인트 : </td>
         <td>${customer.point}P</td>
      </tr>
   </table>
   
   <!-- 수정/탈퇴 -->
   <a href="${pageContext.request.contextPath}/customer/customerModify">수정</a>
   <a href="${pageContext.request.contextPath}/customer/customerRemove">회원탈퇴</a>
</body>
</html>