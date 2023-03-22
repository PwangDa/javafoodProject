<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	String id = (String)request.getSession().getAttribute("loginId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트에 노래 추가</title>


<!-- css 파일 불러오기 -->
<link rel="stylesheet" href="/style/playList.css">


</head>
<body>
	<div class="title"><h1>노래를 추가할 플레이 리스트를 선택하세요.</h1></div>
	<br>
	<hr>
	<img class="addList" src="https://c11.kr/1asbg"> <span class="addList">리스트 추가</span>
	<!-- 플레이 리스트 추가하는 폼 -->
    <div class="search hidden">
        <form name = "PL_addList">
        	<input type="hidden" name="id" value="<%=id %>">
            <input type="text" name="addList_title" class="addList_textbar" placeholder="플레이리스트 제목을 입력해주세요."> <br>
            <input type="text" name="addList_explain" class="addList_ex_textbar" placeholder="플레이리스트 설명을 입력해주세요."> <br>
                        <input type="text" name="addList_listImage" class="addList_textbar" placeholder="(Option)플레이 리스트에 들어갈 이미지 주소를 입력해주세요."> <br>
            <input type="button" name="addList_btn" class="addList_btn" value="추가">
        </form>
    </div>
	<br>
	
	<c:forEach var="playList" items="${ playList }">
		<!-- 누르면 추가함  -->
		<a href="/addContent?pl_id=${ playList.pl_id }&listImage=${ playList.listImage }">
			<div class="playList">
				<img class="album" src="${ playList.listImage }">
				<div class="plText">${ playList.pl_title }</div>
			</div>
		</a>
	</c:forEach>
	   	
   	<!-- js파일 불러오기 -->
   	<script src="/script/playList.js"></script>
   	
</body>
</html>