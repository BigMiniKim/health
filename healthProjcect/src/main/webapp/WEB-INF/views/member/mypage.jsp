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
			<h2>회원 정보</h2>
		</div>
		<div>
		<form>
			<p>
			<label class="w3-text-blue">아이디</label>
			<input class="w3-input w3-borde" type="text" name="id" id="id" value="testid" readonly>
			</p>
			<p>
			<label class="w3-text-blue">패스워드</label>
			<input class="w3-input w3-borde" type="password" name="password" id="pw" value="testpw" readonly>
			</p>
			<p>
			<label class="w3-text-blue">전화번호</label>
			<input class="w3-input w3-borde" type="tel" name="phone" id="tel" value="testname">
			</p>
			<p>
			<label class="w3-text-blue">생일</label>
			<input class="w3-input w3-borde" type="date" name="birthDay" id="birthday" value="2020-10-23">
			</p>
			<p>
			<label class="w3-text-blue">이메일</label>
			<input class="w3-input w3-borde" type="email" name="email" id="email" value="test@test.com">
			</p>
			<div class="w3-row">
			<h4 class="w3-text-blue">성별 선택</h4>
			<input class="w3-radio" type="radio" name="gender" id="gender" value="남자" checked><label class="">남자</label><br>		
			<input class="w3-radio" type="radio" name="gender" id="gender" value="여자"><label class="">여자</label><br>
			</div>
			<hr>
			<div>
				회원권 정보 출력<button class="w3-blue-grey"> 회원권 보기 </button>
			</div>
			<hr>
			<div style="align-content:center;">
			<input type="button" class="w3-btn w3-blue-grey" value="메인" onclick="location.href='/'">
			<input type="button" class="w3-btn w3-blue-grey" value="일정(수업)" onclick="location.href='#'">
			<input type="button" class="w3-btn w3-blue-grey" value="회원 정보 수정" onclick="location.href='#'">
			<input type="button" class="w3-btn w3-blue-grey" value="패스워드 변경" onclick="location.href='#'">
			<button class="w3-btn w3-blue-grey">회원 탈퇴</button>
			</div>
		</form>
		</div>
	</div>
	
</body>
</html>