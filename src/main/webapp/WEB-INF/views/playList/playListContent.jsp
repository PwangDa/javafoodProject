<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	String id = (String)request.getSession().getAttribute("loginId");
	String pl_id = request.getParameter("pl_id");
	String listImage = request.getParameter("listImage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= id %>님의 ${ playListContent[0].pl_title }</title>

<!-- css 파일 불러오기 -->
<link rel="stylesheet" href="/style/playListContent.css">


</head>
<body>
	<div class="divBody">
	
		<c:choose>
		<%-- 해당 플레이 리스트의 내용이 하나도 없다면 --%>
		<c:when test="${ empty playListContent }">
		<div class="album_info">
				<img class="list_thumnail" src="<%= listImage %>">
				<br>
				<br>
				<h2 style="text-shadow:2px 2px 2px gray; color:whitesmoke;">${ playListContent[0].pl_title }</h2>
				<br>
				<div class="ablum_explain">
					${ playListContent[0].pl_explain }
				</div>
			</div>
				
			<span class="delete">
				<form name="deleteList">
					<input type="hidden" name="pl_id" value="${ playListContent[0].pl_id }">
					<input type="hidden" name="id" value="<%=id %>">
					<input type="hidden" name="javafood" value="3_5">
					<span id="delete">
						<img class="delete_icon" src="https://cdn.discordapp.com/attachments/931150181540450368/1075584965003182150/x_before.JPG" width="50">
						<div style="font-size:12px; text-align:center;">삭제하기</div>
					</span>
				</form>
				<span id="editList">
					<img id="editList" class="editList" src="https://cdn.discordapp.com/attachments/931150181540450368/1087936598156525578/edit-icon.png">
		 			<div style="font-size:12px; text-align:center; width:50px; height:50px;" id="editList" class="editList">리스트<br>수정</div>
				</span>
 			</span>
			<div class="noList list_parent">등록된 곡이 없습니다.<br>곡을 추가해 주세요.</div>
		</c:when>
		
		
		
		
		
		
		
		
		
		<%-- 해당 플레이 리스트의 내용이 하나라도 존재한다면 --%>
		<c:when test="${ !empty playListContent }">
				<div class="album_info">
					<img class="list_thumnail" src="<%= listImage %>">
					<br>
					<br>
					<form name="PL_editList">
						<input type="text" placeholder="표지 변경하기(이미지 URL 입력)" class="hidden edit editList_textbar" name="editList_listImage">
						<br>
						<h2 style="text-shadow:2px 2px 2px gray; color:whitesmoke;">${ playListContent[0].pl_title }</h2>
						<input type="text" placeholder="제목 변경하기" class="hidden edit editList_textbar" name="editList_title">
						<br>
						<br>
						<div class="ablum_explain">
							${ playListContent[0].pl_explain }
						</div>
						<input type="text" placeholder="설명 변경하기" class="hidden edit editList_ex_textbar" name="editList_explain">
						<br>
						<input type="hidden" name="editList_pl_id" value="${ playListContent[0].pl_id }">
						<br>
						<input type="button" class="hidden edit editList_btn" value="수정">
					</form>
				</div>
				
			<span class="delete">
				<form name="deleteList">
					<input type="hidden" name="pl_id" value="${ playListContent[0].pl_id }">
					<input type="hidden" name="id" value="<%=id %>">
					<input type="hidden" name="javafood" value="3_5">
					<span id="delete">
						<img class="delete_icon" src="https://cdn.discordapp.com/attachments/931150181540450368/1075584965003182150/x_before.JPG" width="50">
						<div style="font-size:12px; text-align:center;">삭제하기</div>
					</span>
					<span id="editList">
						<img id="editList" class="editList" src="https://cdn.discordapp.com/attachments/931150181540450368/1087936598156525578/edit-icon.png">
		 				<div style="font-size:12px; text-align:center; width:50px; height:50px;" id="editList" class="editList">리스트<br>수정</div>
					</span>
				</form>
 			</span>
 				
			<div class="list_parent">
			<c:forEach var="list" items="${ playListContent }">
				<div class="list_child">
					<input style="vertical-align:top;" class="checkListNumber" type="checkbox" name="listNumber" value="${ list.listNumber }">
					<a href="albumpage?album=${ list.album_name }"><img class="album" src="${ list.imageLink }"></a>
					<div class="list_info">
						<a href="${ list.link }" target="_blank"><span class="song_title">${ list.songName }</span></a>
						<br>
						<br>
						<a href="artistpage?artist=${ list.artistName }">${ list.artistName }</a>
						<br>
						<a href="albumpage?album=${ list.album_name }">${ list.album_name }</a>
					</div>
					<span class="deleteSong">
						<form class="deleteSong">
							<img class="sDelete_icon" src="https://cdn.discordapp.com/attachments/931150181540450368/1075584965003182150/x_before.JPG" width="25">
							<input type="hidden" name="listNumber" value="${ list.listNumber }">
							<input type="hidden" name="pl_id" value="${ list.pl_id }">
						</form>
					</span>
				</div>
				<form name="PLC_delete_list">
					<input type="hidden" name="doDeleteList" value="doDelete">
					<input type="hidden" name="res.PL_ID" value="${ list.pl_id }">
				</form>
			</c:forEach>
			</div>
		</c:when>
	</c:choose>
	</div>
   	
   	<!-- js파일 불러오기 -->
   	<script src="/script/playListContent.js"></script>
   	
   	
</body>
</html>