<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String id = (String)request.getSession().getAttribute("loginId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<!-- css파일 불러오기 -->
<link rel="stylesheet" href="/style/main.css">
<script src="https://code.jquery.com/jquery-latest.js"></script> 
 <style>
        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */                          
        }
 
</style>

</head>
<body>

	<br>
	<br>
	<br>
<%-- 상단 버튼 3개 --%>
	<div class="topArea">
        <a class="topButton" href="popular_Music">
        	<span>
        		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-music-note-beamed" viewBox="0 0 16 16">
  					<path d="M6 13c0 1.105-1.12 2-2.5 2S1 14.105 1 13c0-1.104 1.12-2 2.5-2s2.5.896 2.5 2zm9-2c0 1.105-1.12 2-2.5 2s-2.5-.895-2.5-2 1.12-2 2.5-2 2.5.895 2.5 2z"/>
  					<path fill-rule="evenodd" d="M14 11V2h1v9h-1zM6 3v10H5V3h1z"/>
  					<path d="M5 2.905a1 1 0 0 1 .9-.995l8-.8a1 1 0 0 1 1.1.995V3L5 4V2.905z"/>
				</svg>
        		최신 음악
        	</span>
        </a>
        <a class="topButton" href="chart">
        	<span>
        		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-graph-up-arrow" viewBox="0 0 16 16">
  					<path fill-rule="evenodd" d="M0 0h1v15h15v1H0V0Zm10 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-1 0V4.9l-3.613 4.417a.5.5 0 0 1-.74.037L7.06 6.767l-3.656 5.027a.5.5 0 0 1-.808-.588l4-5.5a.5.5 0 0 1 .758-.06l2.609 2.61L13.445 4H10.5a.5.5 0 0 1-.5-.5Z"/>
				</svg>
        		차트
        	</span>
        </a>
        <a class="topButton" href="genre">
        	<span>
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-boombox" viewBox="0 0 16 16">
  					<path d="M2.5 5a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1Zm2 0a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1Zm7.5-.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0Zm1.5.5a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1Zm-7-1a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3Zm5.5 6.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0Z"/>
				  	<path d="M11.5 13a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Zm0-1a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3ZM5 10.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0Z"/>
				  	<path d="M7 10.5a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0Zm-1 0a1.5 1.5 0 1 0-3 0 1.5 1.5 0 0 0 3 0Z"/>
				  	<path d="M14 0a.5.5 0 0 1 .5.5V2h.5a1 1 0 0 1 1 1v11a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h12.5V.5A.5.5 0 0 1 14 0ZM1 3v3h14V3H1Zm14 4H1v7h14V7Z"/>
				</svg>
        		장르
        	</span>
        </a>
    </div>
    
    <br>
    <div class="esterEgg hidden" style="margin-left:3%;">
	    <img class="esterEgg hidden" src="https://cdn.discordapp.com/attachments/931150181540450368/1088295244241575976/i015935838700.gif" width="100">
		<img class="esterEgg hidden" src="https://cdn.discordapp.com/attachments/931150181540450368/1088295057838313472/25B8FC93095FA77A9919D94F95C09C61_1483409562.gif" width="150">
	    <img class="esterEgg hidden" src="https://cdn.discordapp.com/attachments/931150181540450368/1088295030990573661/i12218711522.gif" width="200">
	    <img class="esterEgg hidden" src="https://cdn.discordapp.com/attachments/931150181540450368/1085371872557932606/giphy_1.gif" width="250">
	    <img class="esterEgg hidden" src="https://cdn.discordapp.com/attachments/931150181540450368/1088295030990573661/i12218711522.gif" width="200">    
	    <img class="esterEgg hidden" src="https://cdn.discordapp.com/attachments/931150181540450368/1088295057838313472/25B8FC93095FA77A9919D94F95C09C61_1483409562.gif" width="150">
	    <img class="esterEgg hidden" src="https://cdn.discordapp.com/attachments/931150181540450368/1088295244241575976/i015935838700.gif" width="100">
    </div>
    <br>
   
    <%-- 인기곡 리스트 컨트롤러 --%>
    <c:if test="${ ls==null }">
	    <div class="hitList">
	    	<div class="subtitle">
	    		인기곡
	    		<div class="hitListController">
	    			<p class="point hitPrev"><</p>
	    			<p class="point hitNext">></p>
	    		</div>
	    	</div>
	    </div>
	    
	    <br>
	    <%-- 인기곡 리스트 --%>
	    <div class="hitSongContent songContentPage0">
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count<=4 }">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=5 && vs.count<=8}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=9 && vs.count<=12}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=13 && vs.count<=16}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=17 && vs.count<=20}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=21 && vs.count<=24}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=25 && vs.count<=28}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
		
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=29 && vs.count<=32}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=33 && vs.count<=36}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
			    	<c:if test="${vs.count>=37 && vs.count<=40}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank">${hitList.songnumber }</div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
		</div>
    </c:if>
    
	    
	    <br>
	    <br>
	    <br>
	    
    <%-- 랜덤곡 --%>
    
    	<%-- 랜덤곡 리스트 컨트롤러 --%>
	    <div class="hitList">
	    	<div class="subtitle">
	    		오늘은 이런 장르 어떠세요? <div id="warp">${gerne[0].bygenre}</div>
	    		<div class="hitListController">
	    			<p class="point ranPrev"><</p>
	    			<p class="point ranNext">></p>
	    		</div>
	    	</div>
	    </div>
	    
	    <%-- 랜덤곡 리스트 --%>
	    <div class="ranSongContent ranSongContentPage0">
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count<=4 }">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=5 && vs.count<=8}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=9 && vs.count<=12}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=13 && vs.count<=16}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=17 && vs.count<=20}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=21 && vs.count<=24}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=25 && vs.count<=28}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
		
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=29 && vs.count<=32}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=33 && vs.count<=36}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
	    
		    <div id="hitListLine">
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
			    	<c:if test="${vs.count>=37 && vs.count<=40}">
			            <div class="hitListViewerContent">
			                <div class="hitListViewerThumnail">
			                    <a href="/albumpage?album=${hitList.album_name}"><img class="thumnail" src="${hitList.imagelink }"></a>
			                </div>
			    
			                <div class="hitListRank"></div>
			    
			                <div class="songContentInfo">
			    
			                    <div class="hitListViewerSongTitle">
			                        <a target="_blank"  href="${hitList.link }">${hitList.songname }</a>
			                    </div>
			                    <div class="hitListViewerSongInfo">
			                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
			                        <a target="_blank"  class="hitListViewerArtistName" href="artistpage?artist=${ hitList.artistname }">${hitList.artistname }</a>·<a target="_blank"  class="hitListViewerAlbumName" href="albumpage?album=${ hitList.album_name }">${hitList.album_name }</a>
			                    </div>
			                </div>
			            </div>
			    	</c:if>
		    	</c:forEach>
		    </div>
		</div>
		
		<br>
	    <br>
	    <br>
		
		<!-- 랜덤 아티스트 추천 -->
		<div class="hitList">
	    	<div class="subtitle">
	    		오늘의 추천 아티스트
	    	</div>
	    </div>		
		<div id = "cont3" >
            <div id="cont3_1">
                <ul id = "slds" class="clides">
				<%-- 아티스트 부분 forEach --%>
                <c:forEach var ="artist" items="${random_artist}" varStatus="loop">
                    <li>
                        <a href="/artistpage?artist=${artist.artistname}"><img  class="image" src="${artist.artist_img}"></a>
                        <br>
                        <a style = "font-size:14px;" href="/albumpage?artist=${artist.artistname}"><span class="al_name"><strong>${artist.artistname }</strong></span></a>
                    </li>
                </c:forEach>
                </ul>
            </div>
        </div>
   
 <!-- The Modal 팝업창-->
    <div id="myModal" class="modal">
 
      <!-- Modal content 팝업창 내용 -->
      <div class="modal-content">
                <p style="text-align: center;"><span style="font-size: 14pt;"><b><span style="font-size: 24pt;">공지</span></b></span></p>
                <p style="text-align: center; line-height: 1.5;"><br /></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">사이트 서버 점검으로</span></p>
                <p style="text-align: center; line-height: 1.5;"><b><span style="color: rgb(255, 0, 0); font-size: 14pt;">10:00 - 18:00 까지</span></b></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">사이트 사용이 중지 됩니다.</span></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;"><br /></span></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">이용에 불편을 드린 점 양해를 </span></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 14pt;">부탁드립니다.</span></p>
                <p style="text-align: center; line-height: 1.5;"><br /></p>
                <p><br /></p>
            <div>
        		<input type="checkbox" name="layer_close"> 
                <span style="color: black">
                	10분동안 보지 않기
                </span>
            </div>    
            <div style="cursor:pointer;background-color:#989898;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="close_pop();">
                <span class="pop_bt" style="font-size: 13pt;" >
                     닫기
                </span>
            </div>
      </div>
 
    </div>
        <!--End Modal-->
   

	<!-- js파일 불러오기 -->
	<script src="/script/main.js"></script>
	
	<!-- 반드시 jsp에 써야만 하는 스크립트 -->
   	<script>
	/*이스터에그*/
	let konamiCommand = "";
	
	document.addEventListener('keydown', (event) =>
	{
		if(event.key != "Backspace")
		{			
			konamiCommand += event.key;
			console.log("konamiCommand : " + konamiCommand);
		}
		
		if(konamiCommand == "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightba" || konamiCommand == "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightBA")
		{
			let imgEsterEgg = document.querySelectorAll(".esterEgg");
			for(let i=0; i<imgEsterEgg.length; i++)
			{
				imgEsterEgg[i].classList.remove("hidden");
			}
			konamiCommand = "";
		}
		if
		(
				konamiCommand == "rhksflwkvpdlwl"
				&&
				"master" == "<%= id %>"
		)
		{
			window.open('http://localhost:8080/insert_song');
			konamiCommand = "";
		}
		if(event.key == "Backspace")
		{
			konamiCommand = "";
			console.log("KonamiCommand is reseted.");
		}
		
	});
	</script>
	
</body>
</html>