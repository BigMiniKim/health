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
			<h2>이용권 구매 페이지</h2>
		</div>
		<div>
		<form action="create" method="post">
			<p>
			<label class="w3-text-blue">아이디</label>
			<input class="w3-input w3-borde" type="text" name="id" id="id" value="${sessionScope.user_id }">
			</p>
			<p>
			<label class="w3-text-blue">패스워드</label>
			<input class="w3-input w3-borde" type="password" name="pw" id="pw" value="">
			</p>
			<p>
			<label class="w3-text-blue" for="useRight">이용권 선택</label>
            <select name="useRight" id="useRight">
              <option value="C">1달(10회권)-15만원</option>
              <option value="B">3달(30회권)-25만원</option>
              <option value="A">6달(60회권)-50만원</option>
              <option value="S">1년(120회권)-80만원</option>
            </select>
			<hr>
			<div style="align-content:center;">
			<input type="submit" class="w3-btn w3-blue-grey" value="결제">
            <input type="button" class="w3-btn w3-blue-grey" value="취소" onclick="history.go(-1)">
			</div>
		</form>
		</div>
	</div>
	
</body>
</html>