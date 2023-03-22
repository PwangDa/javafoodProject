<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/style/insert_song.css?css=css">
<br>
<br>
<br>
<body>
<body>
	<div class="ddr">
		<div class="mume"><h3><a class="at" href="/insert_song"><c:out value="Genre 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" href="/insert_artist"><c:out value="Artist 관리"/></a></h3></div>
		<div class="mume" id="outsession" ><h3><a class="at" href="/insert_album"><c:out value="Album 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" id="outid" href="/insert_intoalbum"><c:out value="IntoAlbum 관리"/></a></h3></div>
	</div>
<hr>
<div class="page_1">
		<span class="h2h2">아티스트 정보등록</span>
			<form action="/list/artist" class="butt_1">
				<input class="butt" type="submit" value="목록 전체조회"> 
			</form>
			<form id="join" action="/artistplus">
				<div class="conn_1">
					<div class="conn">아티스트 이름<input class="text_a" type="text" name="artistname" placeholder="Artistname"></div>
					<div class="conn">아티스트 소개<textarea name="artist_info" placeholder="artist_info"></textarea></div>
					<div class="conn">아티스트 사진링크<textarea name="artist_img" placeholder="artist_img"></textarea></div>
					<input class="butt" type="submit" value="추가">
					<input class="butt" type="reset" value="다시입력">
				</div>
			</form>
</div>
<hr>
<!--여기서 부터 조회한 값이 테이블로 출력 -->

 <table border=1>
				<c:if test="${not empty list }">
					<thead>
						<tr>
							<th>Artistname</th>
							<th>Artist_info</th>
							<th>Artist_img</th>
						</tr>
					</thead>
					<tbody id="tbody">
					<c:forEach var="artist" items= "${list }" >
						<tr>
							<td>${artist.artistname}</td>
							<td>${artist.artist_info}</td>
							<td>${artist.artist_img}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${ empty list }">
					<tr>
						<td colspan="7" style="text-align:center;">데이터를 조회해 주세요.
					</tr>
				</c:if>
				</tbody>
			</table> 
</body>
</body>
<script link src ="/script/insert_song.js"></script>
</html>