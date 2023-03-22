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
<title><%= id %>님의 플레이 리스트</title>


<!-- css 파일 불러오기 -->
<link rel="stylesheet" href="/style/playList.css">


</head>
<body>
	<br>
	<div class="title"><h1><%= id %>님의 플레이 리스트</h1></div>
	    <br>
    <hr>
    <img class="addList" src="https://c11.kr/1asbg"> <span class="addList">리스트 추가</span>
    <img id="editList" class="addList" src="https://cdn.discordapp.com/attachments/931150181540450368/1087936598156525578/edit-icon.png"> <span id="editList" class="addList">리스트 수정하기</span>
    
    <!-- 플레이 리스트 추가하는 폼 -->
    <div class="search hidden">
        <form name = "PL_addList">
<!--         	<input type="hidden" name="javafood" value="3_2"> -->
        	<input type="hidden" name="id" value="<%=id %>">
            <input type="text" name="addList_title" class="addList_textbar" placeholder="플레이리스트 제목을 입력해주세요."> <br>
            <input type="text" name="addList_explain" class="addList_ex_textbar" placeholder="(Option)플레이리스트 설명을 입력해주세요."> <br>
            <input type="text" name="addList_listImage" class="addList_textbar" placeholder="(Option)플레이 리스트에 들어갈 이미지 주소를 입력해주세요."> <br>
            <input type="button" name="addList_btn" class="addList_btn" value="추가">
        </form>
    </div>
    
    <br>
    
   	<c:choose>
   		<%-- 해당 유저의 플레이 리스트가 아무것도 없다면 --%>
		<c:when test="${ empty playList }">
			<div class="noList">등록된 리스트가 없습니다. 리스트를 추가해 주세요.</div>
		</c:when>
		
		<%-- 해당 유저의 플레이 리스트가 하나라도 존재한다면 --%>
		<c:when test="${ !empty playList }">
			<c:forEach var="list" items="${ playList }">
			<a href="playListContent?pl_id=${ list.pl_id }&listImage=${ list.listImage }">
				<div class="playList">
					<img class="album" src="${ list.listImage }">
					<div class="plText">${ list.pl_title }</div>
				</div>
			</a>
			</c:forEach>
		</c:when>
   	</c:choose>
   	
   	
   	<!-- js파일 불러오기 -->
   	<script src="/script/playList.js"></script>
   	
   	
   	
</body>
</html>