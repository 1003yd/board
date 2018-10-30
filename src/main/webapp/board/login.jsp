<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Signin Template for Bootstrap</title>
    <%@ include file="/common/basicLib.jsp" %>
    
	<script type="text/javascript">
    	//$ define에러가 나면 jquert 라이브러리가 설정이 안되어있다는 뜻!! 라이브러리 추가해줘!!
		 $(document).ready(function(){
			console.log("test");
			//remember 쿠기값이 Y이면 
			//remember-me 체크박스 체크
			//userId input value userId 쿠키값으로 설정 
			if(getCookie("remember")== "Y"){
				var check = document.getElementById("remember-me");
				//$("#check").prop("checked", true); 도 가능 
				$("#check").attr("checked",true);	//atrr은 HTML의 속성을 다루는게 가능하다.
				$("#userId").val(getCookie("userId"));
			}
			
			
		});
 	
		function getCookie(cookieName){
			//cookieString = > document.cookie
			var cookies = document.cookie.split("; ");
			
			var cookieValue = "";
			for(var i=0; i< cookies.length; i++){
				var str  = cookies[i];
				if(str.startsWith(cookieName + "=")){
					cookieValue = str.substring((cookieName + "=").length);
				}
			}
			
			return cookieValue;
		}
		//getCookie("userId");
		//getCookie("remember");
	</script>
    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">
    
    
	<script src="/js/jquery-3.3.1.min.js"></script>
  </head>

  <body class="text-center">
    <form class="form-signin" action="/loginServlet" method="post">
      <img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail"  class="sr-only">Email address</label>
      <input type="text" id="userId" name="userId" class="form-control" value="" placeholder="아이디 입력하세요" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" name ="password" class="form-control" value="brownpass" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" id="check" name="remember-me" value="remember-me"> Remember me
        </label>
      </div>
      <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in" />
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>
