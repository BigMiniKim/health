<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	
	<div id="join" class="w3-container">
		
		<div  class="w3-blue">
			<h2>로그인</h2>
		</div>
		<div>
		<form action="./loginForm" method="post">
			<p>
			<label class="w3-text-blue">아이디</label>
			<input class="w3-input w3-borde" type="text" name="id" id="id">
			</p>
			<p>
			<label class="w3-text-blue">패스워드</label>
			<input class="w3-input w3-borde" type="password" name="password" id="password">
			</p>
			<p>
			<div style="align-content:center;">
			<input type="submit" class="w3-btn w3-blue-grey" value="로그인">
            <input type="button" class="w3-btn w3-blue-grey" value="회원가입" onclick="location.href='join' ">
            
			</div>
		</form>
		</div>
	</div>
</body>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script>
  $(document).ready(function(){
	  var msg = '${msg}';
	  
	  if(msg != '') {
		  alert(msg);
	  }
	  
	  //board인터셉터 로직
	  var check = '${param.check}';
	  if(check != '') {
		  alert("로그인이 필요한 서비스 입니다");
	  }
  });
  
  </script>
</html>