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
			<h2>프로그램 생성 페이지</h2>
		</div>
		<div>
		<form action="createForm" method="post">
			<p>
			<label class="w3-text-blue">프로그램 이름</label>
			<input class="w3-input w3-borde" type="text" name="name" id="name">
			</p>
			<p>
			<p>
			<label class="w3-text-blue">프로그램 일자</label>
			<input class="w3-input w3-borde" type="date" name="date" id="date">
			<label class="w3-text-blue" for="times">회차 선택</label>
            <select name="times" id="times">
              <option value="1">10시-11시</option>
              <option value="2">11시-12시</option>
              <option value="3">14시-15시</option>
              <option value="4">16시-17시</option>
              <option value="5">17시-18시</option>
              <option value="6">19시-20시</option>
              <option value="7">20시-21시</option>
            </select>
            <label class="w3-text-blue" for="totalPerson">등록인원</label>
            <select name="totalPerson" id="totalPerson">
              <option value="5">5</option>
              <option value="10">10</option>
              <option value="15">15</option>
              <option value="20">20</option>
            </select>
			<hr>
			<div style="align-content:center;">
			<input type="submit" class="w3-btn w3-blue-grey" value="등록">
            <input type="button" class="w3-btn w3-blue-grey" value="취소" onclick="location.href='/'">
			</div>
		</form>
		</div>
	</div>
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
</body>
</html>