<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
	<script link src ="/script/loginScript.js"></script>
	
	<link rel="stylesheet" href="/style/loginCSS.css?css=css">
</head>
<body>
<div class="table">
				<div>
					<div>
						<img src="https://c11.kr/1asbb" class="logo-img">
						<h1 style="margin-top:-11px;">MUSIC</h1>
					</div>
					<div class="table1">
						<h1 class="h1_1"><c:out value="Find ID"/></h1>
					    <form action="/searchID/what">
					        <div class="head1">
					            <div class = "inputbtn">
					            	<input class = "tt" type="text" name="NIC" id="id12" placeholder="닉네임">
					            	<button class="btnClear" type="button" ></button>
					            </div>
					            <br>
					            <input class = "tt" type="text" name="PHONE" placeholder="핸드폰 번호">
					            <button class="btnClear" type="button" ></button>
					            <input class="sub sub1" type="submit" value="아이디 찾기">
					            <br>
					            <br>
					            <a href="/login" style="margin-right: 140px; font-size:10px;">로그인 하러가기</a>
					            <a href="/login?membership=0" style="font-size:10px;">회원가입 하러가기</a>
					            </div>
					    </form>
					 </div>
				</div>
</div>
</body>
</html>