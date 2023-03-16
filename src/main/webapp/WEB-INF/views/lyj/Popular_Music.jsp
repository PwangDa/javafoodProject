<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<body>
	
<meta charset="UTF-8">
<title>Insert title here</title>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/style/genre.css">

</head>
<body>

<%-- <jsp:include page=""></jsp:include> --%>
<%-- <h1>${login }</h1> --%>
    <!-- <header id ="menu">
        <span style="font-size: 34px; font-weight: 600;">Music</span>
    </header> -->
    <div id="home">
        <h1><a href='http://localhost:8080/popular_Music'>최신음악</a></h1>
        
        <div class="no_chart">        
                <input type="checkbox" id="cb1" name="selectall" onclick="selectAll(this); getCheckedValue()" value="selectall; ${ genre_list.songnumber}">
                   <!-- <label for="cd1"></label> -->
            <div class="left_num">NO</div>
            <div class="left_song">곡이름</div>
            <div class="left_artist">아티스트</div>
            <div class="left_album">앨범</div>
            <div class="right_item">재생시간</div>
            <div><img class="heart" src="https://c11.kr/1asbx"></div>
            <!-- <div class="right_top_item_1">듣기</div>
            <div class="right_top_item_1">담기</div> -->
            <form method="post" action="/javafood_team/javafood?javafood=3">
            <div> <input type="hidden" class="btn" id="btn"><a href="${ genre_list.link}"target='_blank'><img class="img" src="https://c11.kr/1asd1" onmouseover="this.src='https://c11.kr/1asd5'" onmouseout="this.src='https://c11.kr/1asd1'"></a></div><!-- 노래재생 유튜브 -->
            </form>
            <form method="post">
            	<div><!-- 담기 버튼 -->
            		<img class="img addLists" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
            	</div>
            </form>
        </div>
		<c:choose>
		<c:when test="${!empty list}">
			<c:forEach var="popular_music" items="${list}" varStatus="status">
        	<div class= "musiclist">
            	 <div class="cont2">
             		<input type="checkbox" id="cb1" name="chk" onclick="checkSelectAll(); getCheckedValue()" value="${ popular_music.songnumber}">
                	<div class="left_item_bot">${ status.count} </div>  <!-- 곡 순서 -->
                	<div class="div_size"><img class="left_img" src="${ popular_music.imagelink}" ></div>  <!-- 앨범 이미지 -->
                	<div class="left_song_bot"><a href="${ popular_music.link}"target='_blank'>${ popular_music.songname}</a></div> <!-- 곡 제목 -->
                	<c:if test="${ popular_music.artistname == '아이유' || popular_music.artistname == 'SG워너비'}">
                		<div class="left_artist_bot" title="${ popular_music.artistname}"><a href="/artistpage?artist=${popular_music.artistname}">${ popular_music.artistname}</a></div> <!-- 가수명 -->
                	</c:if>
                	<c:if test="${ popular_music.artistname != '아이유' && popular_music.artistname != 'SG워너비'}">
                		<div class="left_artist_bot" title="${ popular_music.artistname}"><a href="/javafood_team/javafood?javafood=ArtistList&num=${popular_music.songnumber}">${ popular_music.artistname}</a></div> <!-- 가수명 -->
                	</c:if>
                	<div class="left_album_bot" title="${ popular_music.album_name}"><a href = "/javafood_team/javafood?javafood=AlbumList&num=${popular_music.songnumber}">${ popular_music.album_name}</a></div> <!-- 앨범 --> 
                	<div class="right_item_bot">${ popular_music.playtime}</div> <!-- 재생시간 -->
                	<form method="post" action="/javafood_team/javafood?javafood=6">
	                	<div class="right_item_bot" id="like"><%-- ${ genre_list.likes} --%><input type="image"  src="https://c11.kr/1asbx" onmouseover="this.src='https://c11.kr/1asby'" onmouseout="this.src='https://c11.kr/1asbx'" value="" class="sub"><input type="hidden" name="good" value="${popular_music.songnumber}"><!-- 좋아요 --> 
	<%--                 <div class="right_item_bot" id="like">${ genre_list.likes}<input type="image"  src="https://c11.kr/1asbx"  value="" class="sub"><input type="hidden" name="good" value="${genre_list.songnumber}"><!-- 좋아요 -->  --%>
	                		<input type="hidden" name="number" value="${ popular_music.songnumber}"> <!-- 곡 번호 -->
	                	</div>
                	</form>
                	<form method="post" action="/javafood_team/javafood?javafood=3">
                		<div> <input type="hidden" class="btn"><a href="${ popular_music.link}"target='_blank'><img class="img" src="https://c11.kr/1asd1" onmouseover="this.src='https://c11.kr/1asd5'" onmouseout="this.src='https://c11.kr/1asd1'"></a></div><!-- 노래재생 유튜브 -->
                	</form>
                	<form name="addPlayList" method="post" action="/javafood_team/javafood?javafood=3_6">
                		<div> <input type="hidden" class="put" name="songNumber" value="${ popular_music.songnumber }"><input type="hidden" class="put" name="addWhere" value="NewGenre"><img class="img addList" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'"></div><!-- 담기 버튼 -->
             		</form>
             	</div>
             	</div>
			</c:forEach>
		</c:when>
		<c:when test="${empty list}">
			<div class="not">노래가 없습니다.</div>
		</c:when>
		</c:choose>
		
            
        </div>
    </div>
<%--  totalCount : ${totalCount }<br>
 pageNum : ${pageNum }<br>
 countPerPage : ${countPerPage }<br> --%>
 <%

	int totalCount = (int)request.getAttribute("totalCount");
	int pageNum = (int)request.getAttribute("pageNum");
	int countPerPage = (int)request.getAttribute("countPerPage");
	System.out.println("jsp에서 getAttribute를 받아 int로 형변환한 결과 : " + totalCount);
	System.out.println("jsp에서 getAttribute를 받아 int로 형변환한 결과 : " + pageNum);
	System.out.println("jsp에서 getAttribute를 받아 int로 형변환한 결과 : " + countPerPage);
	int lastPage = (int)Math.ceil ((double)totalCount / countPerPage);
	int section = 5; // 페이징 보여줄 갯수
	
	int sec_position = ( ((int) Math.ceil( (double)pageNum / section )) -1 );
	int firstSec = ( sec_position * section ) + 1;
	int lastSec = firstSec + section - 1;
	if(lastSec > lastPage){
		lastSec = lastPage;
	}
	
	
	/* System.out.println("totalCount : " + totalCount);
	System.out.println("pageNum : " + pageNum);
	System.out.println("countPerPage : " + countPerPage);
	System.out.println("lastPage : " + lastPage);
	System.out.println("sec_position : " + sec_position);
	System.out.println("firstSec : " + firstSec);
	System.out.println("lastSec : " + lastSec); */
	%>
	<c:set var="pageNum2" value="<%= pageNum %>" />
	<div class="page">

	<c:if test="<%= firstSec == 1 || firstSec == 2 %>"> 
		<img class="img" src="https://c11.kr/1ascb" onmouseover="this.src='https://c11.kr/1ascc'" onmouseout="this.src='https://c11.kr/1ascb'"></a> 
	</c:if>
	<c:if test="<%= firstSec != 1 %>"> 
		<a href="/popular_Music?pageNum=<%= firstSec-1 %>"><img class="img" src="https://c11.kr/1ascb" onmouseover="this.src='https://c11.kr/1ascc'" onmouseout="this.src='https://c11.kr/1ascb'"></a> 
	</c:if>

	<c:forEach var="i" begin="<%= firstSec %>" end="<%= lastSec %>" >
		<c:if test="${ i == pageNum2 }">
			<a href="/popular_Music?pageNum=${i }" class="num_p"><strong>${i}</strong></a>
		</c:if>
		<c:if test="${ i != pageNum2 }">
			<a href="/popular_Music?pageNum=${i }" class="num_p">${i}</a>
		</c:if>
	</c:forEach>

	<c:if test="<%= lastSec != lastPage %>">
		<a href="/popular_Music?pageNum=<%= lastSec+1 %>"><img class="img" src="https://c11.kr/1ascx" onmouseover="this.src='https://c11.kr/1ascy'" onmouseout="this.src='https://c11.kr/1ascx'"></a>
	</c:if>
	<c:if test="<%= lastSec == lastPage %>">
		<img class="img" src="https://c11.kr/1ascx" onmouseover="this.src='https://c11.kr/1ascy'" onmouseout="this.src='https://c11.kr/1ascx'"></a>
	</c:if>

	</div>
	
	<script link src ="/script/genre.js"></script>
</body>

</html>

</html>