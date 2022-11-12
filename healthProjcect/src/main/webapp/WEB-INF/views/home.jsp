<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}
</style>
</head>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-blue w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
  <div class="w3-container">
    <h3 class="w3-padding-64"><b>Company<br>Name</b></h3>
  </div>
  <c:choose>
	<c:when test="${sessionScope.user_id != null }">
	  <h4>[${sessionScope.user_id }]님 환영합니다</h4>
	  <div class="w3-bar-block">
	    <a href="#" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
	    <a href="/member/mypage" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">마이페이지</a> 
	    <a href="/member/logout" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">로그아웃</a> 
	    <a href="#" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">수업 신청</a> 
	    <a href="#" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">수업 신청 확인</a> 
	    <a href="/health/healthusebuy" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">이용권 구매</a>
	  </div>
	</c:when>
	<c:otherwise>
	  <div class="w3-bar-block">
	    <a href="#" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
	    <a href="/member/join" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">회원가입</a> 
	    <a href="/member/login" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">로그인</a> 
	  </div>
	</c:otherwise>
  </c:choose> 
 
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-blue w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-blue w3-margin-right" onclick="w3_open()">☰</a>
  <span>Company Name</span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

  <!-- Header -->
  <div class="w3-container" style="margin-top:80px" id="showcase">
    <h1 class="w3-jumbo w3-text-blue"><b>헬스 이용권 테스트</b></h1>
    <hr style="width:50px;border:5px solid blue" class="w3-round">
  </div>
  
  <!-- Contact -->
  <div class="w3-container" id="contact" style="margin-top:75px">
    <h1 class="w3-xxxlarge w3-text-blue"><b>문의하기.</b></h1>
    <hr style="width:50px;border:5px solid blue" class="w3-round">
    <p>이용에 궁금한 것이 있으면 언제든지 문의하세요!!</p>
    <form action="#" target="_blank">
      <div class="w3-section">
        <label>Name</label>
        <input class="w3-input w3-border" type="text" name="Name" required>
      </div>
      <div class="w3-section">
        <label>Email</label>
        <input class="w3-input w3-border" type="text" name="Email" required>
      </div>
      <div class="w3-section">
        <label>Message</label>
        <input class="w3-input w3-border" type="text" name="Message" required>
      </div>
      <button type="submit" class="w3-button w3-block w3-padding-large w3-blue w3-margin-bottom">문의하기</button>
    </form>  
  </div>

<!-- End page content -->
</div>

<!-- W3.CSS Container -->
<div class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:58px"><p class="w3-right">Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-opacity">w3.css</a></p></div>

<script>
// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}
</script>
</body>
</html>
