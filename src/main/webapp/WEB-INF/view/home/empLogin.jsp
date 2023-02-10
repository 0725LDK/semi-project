<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
    <title>934마켓 직원 로그인 | 전통주의 모든것, 934마켓</title>
	<!-- 메인 네비메뉴 -->
	<jsp:include page="/inc/loginCss.jsp"></jsp:include>
	
	<!-- js -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>	
	<script>
		$(document).ready(function(){
			$('#submitBtn').click(function(){
				if($('#loginId').val().length==0){
					alert('아이디를 입력해주세요.');
					$('#loginId').focus();
					return;
				}
				if($('#loginPw').val().length==0){
					alert('비밀번호를 입력해주세요.');
					$('#loginPw').focus();
					return;
				}
				$('#login').submit();
			});
		})
	</script>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
	 .border-separator {
	  padding-right: 0.5em;
	  border-right: 1px solid #000;
	  margin-right: 0.5em;
	}
    </style>

   
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">  
	<main class="form-signin">
  		<form method="post" action="${pageContext.request.contextPath}/home/login">
		  	<a href="${pageContext.request.contextPath}/home/main">
		    	<img class="mb-4" src="${pageContext.request.contextPath}/resources/img/m.png" alt="" width="150" height="60">
		 	</a> 
   			<div class="form-floating">
     				<input type="text" class="form-control" id="loginId" name="loginId" placeholder="아이디" value="admin">
   			</div>
   			<div class="form-floating">
     				<input type="password" class="form-control" id="loginPw" name="loginPw" placeholder="비밀번호" value="1234">
  				</div>
  				<div class="checkbox mb-3">
     			<label>
        			<input type="checkbox" value="remember-me"> 아이디 저장하기
      			</label>
    		</div> 
    		<div>  
    			<button class="w-100 btn btn-lg btn btn-primary" type="submit" id="submitBtn">직원 로그인</button>
  			</div>
  			<br>
		    <div class="text-center">
	    		<a href="${pageContext.request.contextPath}/home/login" style="color: green;"><strong>회원이신가요?</strong></a>
			</div> 	  	 
		</form>
	  	<br>
		<span class="border-separator"><a href="${pageContext.request.contextPath}/customer/customerAdd">고객회원가입</a></span>
		<a href="${pageContext.request.contextPath}/emp/empAdd"  >직원회원가입</a>	
	</main>
</body>
</html>