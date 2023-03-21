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

</head>
<body>

	<br>
	<br>
	<br>
<%-- 상단 버튼 3개 --%>
	<div class="topArea">
        <a class="topButton" href="popular_Music"><span>최신 음악</span></a>
        <a class="topButton" href="chart"><span>차트</span></a>
        <a class="topButton" href="genre"><span>장르</span></a>
    </div>
    
    <br>
    <img class="esterEgg hidden" src="https://cdn.discordapp.com/attachments/931150181540450368/1085371872557932606/giphy_1.gif">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		    	<c:forEach var="hitList" items="${gerne }" varStatus="vs">
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
		
		<br>
	    <br>
	    <br>
		
		<!-- 랜덤 아티스트 추천 -->
		<div class="hitList">
	    	<div class="subtitle">
	    		오늘의 추천 아티스트
	    		<div class="hitListController">
	    			<p class="point artistPrev"><</p>
	    			<p class="point artistNext">></p>
	    		</div>
	    	</div>
	    </div>		
		<div id = "cont3" >
            <div id="cont3_1">
                <ul id = "slds" class="clides artistPage0">
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
   

	<!-- js파일 불러오기 -->
	<script src="/script/main.js"></script>
</body>
</html>