<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/style/genre.css">
</head>

<body>
<h1 class="h_1 h_2">검색결과</h1>
<div class="no_chart">        
            <input type="checkbox" id="cb1" name="selectall" onclick="selectAll(this); getCheckedValue()" value="selectall; ${ searchlist.songnumber}">
                   <!-- <label for="cd1"></label> -->
            <div class="left_num">NO</div>
            <div class="left_song">곡이름</div>
            <div class="left_artist">아티스트</div>
            <div class="left_album">앨범</div>
            <div class="right_item">재생시간</div>
            <div><img class="heart" src="https://c11.kr/1asbx"></div>
            <!-- <div class="right_top_item_1">듣기</div>
            <div class="right_top_item_1">담기</div> -->
            <form method="post">
            <div> <input type="hidden" class="btn" id="btn"><a href="${ searchlist.link}"target='_blank'><img class="img" src="https://c11.kr/1asd1" onmouseover="this.src='https://c11.kr/1asd5'" onmouseout="this.src='https://c11.kr/1asd1'"></a></div><!-- 노래재생 유튜브 -->
            </form>
            <form method="post">
            	<div><!-- 담기 버튼 -->
            		<img class="img addLists" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
            	</div>
            </form>
        </div>
		<c:if test="${empty searchlist}">
			<div class="not">노래가 없습니다.</div>
		</c:if>
		<c:if test="${!empty searchlist}">
			<c:forEach var="searchlist" items="${searchlist}" varStatus="status">
	        	<div class= "musiclist">
	            	 <div class="cont2">
	<!-- 체크박스 -->   <input type="checkbox" id="cb1" name="chk" onclick="checkSelectAll(); getCheckedValue()" value="${ searchlist.songnumber}">
	                	<div class="left_item_bot">${ status.count} </div>  <!-- 곡 순서 -->
	<!-- 앨범이미지 --> <div class="div_size"><img class="left_img" src="${ searchlist.imagelink}" ></div>  <!-- 앨범 이미지 -->
	<!-- 곡이름 -->		<div class="left_song_bot"><a href="${ searchlist.link}"target='_blank'>${ searchlist.songname}</a></div> <!-- 곡 제목 -->
	<!-- 아티스트 -->   <div class="left_artist_bot" title="${ searchlist.artistname}"><a href="/artistpage?artist=${searchlist.artistname}">${ searchlist.artistname}</a></div> <!-- 가수명 -->
	<!-- 앨범명 -->  	<div class="left_album_bot" title="${ searchlist.album_name}"><a href = "/albumpage?album=${searchlist.album_name}">${ searchlist.album_name}</a></div> <!-- 앨범 --> 
	<!-- 재생시간 --> 	<div class="right_item_bot">${ searchlist.playtime}</div> <!-- 재생시간 -->
	                	<form method="post" action="/javafood_team/javafood?javafood=6">
	<!--하트 -->	    	<div class="right_item_bot" id="like"><%-- ${ searchlist.likes} --%><input type="image"  src="https://c11.kr/1asbx" onmouseover="this.src='https://c11.kr/1asby'" onmouseout="this.src='https://c11.kr/1asbx'" value="" class="sub"><input type="hidden" name="good" value="${searchlist.songnumber}"><!-- 좋아요 --> 
		                		<input type="hidden" name="number" value="${ searchlist.songnumber}"> <!-- 곡 번호 -->
		                	</div>
	                	</form>
	                	<form method="post" action="/javafood_team/javafood?javafood=3">
	<!--재생 -->            <div> <input type="hidden" class="btn"><a href="${ searchlist.link}"target='_blank'><img class="img" src="https://c11.kr/1asd1" onmouseover="this.src='https://c11.kr/1asd5'" onmouseout="this.src='https://c11.kr/1asd1'"></a></div><!-- 노래재생 유튜브 -->
	                	</form>
	                	<form name="addPlayList" method="post" action="/playListAdd">
	<!--담기 -->            <div> <input type="hidden" class="put" name="songNumber" value="${ searchlist.songnumber }"><input type="hidden" class="put" name="addWhere" value="NewGenre"><img class="img addList" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'"></div><!-- 담기 버튼 -->
	             		</form>
	             	</div>
	             </div>
			</c:forEach>
		</c:if>
		
	<script link src ="/script/genre.js"></script>
</body>
</html>