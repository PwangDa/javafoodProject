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
					<c:if test="${not empty login}">
						<div class="table1">
							<p>비밀번호는 <span style="color:rgb(79, 117, 255); font-weight: bold; font-size: 20px; margin:10px;">${login[0].PWD}</span> 입니다</p>							
						 </div>
						 <br>
						 <br>
						 <a href="/login" style="margin-right: 190px;">로그인 하러가기</a>
						 <a href="/searchID">아이디 찾기</a>
					</c:if>
					<c:if test="${empty login}">
						<div class="table1">
							<span style="font-weight: bold;">비밀번호가 없습니다.</span>
						</div>
						<br>
						<br>
						<a href="/searchPW" style="margin-right: 190px;">다시찾기</a>
						<a href="/login?membership=0">회원가입 하러가기</a>
					</c:if>
				</div>
</div>
</body>
</html>