<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>health Join</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	
	<div id="join" class="w3-container">
		
		<div  class="w3-blue">
			<h2>회원 가입</h2>
		</div>
		<div>
		<form  action="./joinForm" method="post">
			<p>
			<label class="w3-text-blue">아이디</label>
			<!-- name = 파라미터 명 -->
			<input class="w3-input w3-borde" type="text" name="id" id="id">
			</p>
			<p>
			<label class="w3-text-blue">패스워드</label>
			<input class="w3-input w3-borde" type="password" name="password" id="pw">
			</p>
			<p>
			<label class="w3-text-blue">패스워드 확인</label>
			<input class="w3-input w3-borde" type="password" name="password-check" id="check">
			</p>
			<p>
			<label class="w3-text-blue">이름</label>
			<input class="w3-input w3-borde" type="text" name="name" id="name">
			</p>
			<p>
			<label class="w3-text-blue">전화번호</label>
			<input class="w3-input w3-borde" type="tel" name="phone" id="phone">
			</p>
			<p>
			<label class="w3-text-blue">생일</label>
			<input class="w3-input w3-borde" type="date" name="birthday" id="birth">
			</p>
			<p>
			<label class="w3-text-blue">이메일</label>
			<input class="w3-input w3-borde" type="email" name="email" id="id">
			</p>
			<div class="w3-row">
			<h4 class="w3-text-blue">성별 선택</h4>
			<input class="w3-radio" type="radio" name="gender" id="gender" value="남자"><label class="">남자</label><br>		
			<input class="w3-radio" type="radio" name="gender" id="gender" value="여자"><label class="">여자</label><br>
			</div>
			<hr>
			<div style="align-content:center;">
			<input type="button" class="w3-btn w3-blue-grey" onclick="submit()" value = "회원 가입">
			<input type="button" class="w3-btn w3-blue-grey" value = "취소" onclick = "history.go(-1)">
			</div>
		</form>
		</div>
	</div>
	
</body>
</html>