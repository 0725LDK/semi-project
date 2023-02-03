<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Signin Template · Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

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
      
	 a:link { color: red; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: blue; text-decoration: underline;}
    </style>

   
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">  
	<main class="form-signin">
  		<form method="post" action="${pageContext.request.contextPath}/home/login">
    		<img class="mb-4" src="${pageContext.request.contextPath}/resources/img/m.png" alt="" width="150" height="70">
    
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
		    		<a href="${pageContext.request.contextPath}/home/login" style="text-decoration:none" class="text-black"><strong>회원로그인</strong></a>
				</div> 	  	 
			</form>
	  	<br>
		<a href="${pageContext.request.contextPath}/customer/customerAdd" style="text-decoration:none" class="text-black">고객회원가입</a>
		<a href="${pageContext.request.contextPath}/emp/empAdd" style="text-decoration:none" class="text-black">직원회원가입</a>	
	</main>
</body>
</html>