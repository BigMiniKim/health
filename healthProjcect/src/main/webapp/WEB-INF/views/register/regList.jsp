<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
			<h2>'${sessionScope.user_id }'님의 프로그램 목록 선택 페이지</h2>
		</div>
		<div>
		<table>
			<tr>
				<th class="w3-text-blue">번호</th>
				<th class="w3-text-blue">프로그램ID</th>
				<th class="w3-text-blue">프로그램명</th>
				<th class="w3-text-blue">프로그램 날짜</th>
				<th class="w3-text-blue">회차</th>
				<th class="w3-text-blue">제한인원</th>
			</tr>	
			<c:forEach var="program" items="${programList }" varStatus="num">
			<tr>
				<td>${num.index +1}</td>
				<td>${program.pid }</td>
				<td>${program.name }</td>
				<td>${program.date }</td>
				<td>${program.times }</td>
				<td>${program.totalPerson }</td>
	            <!-- 
				1. boardDelete로 삭제 처리하세요. 
				2. 삭제 후엔 목록화면으로 리다이렉트 하세요.
				-->
				<td><input type="button" value="선택" onclick="location.href='regCreate?pid=${program.pid}'"></td>
			</tr>
			</c:forEach>
		</table>

		
		<hr>
			<div style="align-content:center;">
				<<!-- input type="button" class="w3-btn w3-blue-grey" value="등록" onclick="location.href='create'"> -->
		        <input type="button" class="w3-btn w3-blue-grey" value="취소" onclick="history.go(-1)">
			</div>

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