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
	<div class="ddr">
		<div class="mume"><h3><a class="at" href="/insert_song"><c:out value="Genre 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" href="/insert_artist"><c:out value="Artist 관리"/></a></h3></div>
		<div class="mume" id="outsession" ><h3><a class="at" href="/insert_album"><c:out value="Album 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" id="outid" href="/insert_intoalbum"><c:out value="IntoAlbum 관리"/></a></h3></div>
	</div>
<hr>
<div class="page_1">

		<span class="h2h2">장르관리 페이지</span>
		<form action="/list/genre" class="butt_1">
			<input class="butt" type="submit" value="목록 전체조회"> 
		</form>
		<form id="join" action="insert_song_up">
			<div class="conn_1">
				<div class="conn">artistname : <input class="text_a" type="text" name="artistname" placeholder="가수명"></div>
				<div class="conn">songname : <input class="text_a" type="text" name="songname" placeholder="노래명"></div>
				<div class="conn">link : <textarea name="link" placeholder="노래링크"></textarea></div>
				<div class="conn">album_name : <textarea name="album_name" placeholder="앨범명"></textarea></div>
				<div class="conn">bygenre : <select id="select" name="bygenre" class="selectbox" onchange="">
							<option value="발라드">발라드</option>
							<option value="댄스">댄스</option>
							<option value="POP">POP</option>
							<option value="R&B">R&B</option>
							<option value="인디">인디</option>
							<option value="트로트">트로트</option>
							<option value="록">록/메탈</option>
							<option value="랩">랩/힙합</option>
						  </select></div>
				<div class="conn">playtime : <input class="text_a" type="text" name="playtime" placeholder="재생시간"></div>
				<div class="conn">imagelink :	<textarea name="imagelink" placeholder="앨범표지링크"></textarea></div>
				<div class="conn">album_add :	<textarea name="album_add" placeholder="앨범정보"></textarea></div>
				<div class="conn">artist_add : <input class="text_a" type="text" name="artist_add" placeholder="가수명번호"></div>
				<div class="conn">country : <select id="select" name="country" class="selectbox" onchange="">
							<option value="대한민국">대한민국</option>
							<option value="일본">일본</option>
							<option value="미국">미국</option>
						  </select></div>
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
							<th>Songnumber</th>
							<th>Artistname</th>
							<th>Songname</th>
							<th>Link</th>
							<th>Album_name</th>
							<th>Bygenre</th>
							<th>Playtime</th>
							<th>Imagelink</th>
							<th>Album_add</th>
							<th>Artist_add</th>
							<th>Country</th>
						</tr>
					</thead>
					<tbody id="tbody">
					<c:forEach var="genre" items= "${list }" >
						<tr>
							<td>${genre.songnumber}</td>
							<td>${genre.artistname}</td>
							<td>${genre.songname}</td>
							<td>${genre.link}</td>
							<td>${genre.album_name}</td>
							<td>${genre.bygenre}</td>
							<td>${genre.playtime}</td>
							<td>${genre.imagelink}</td>
							<td>${genre.album_add}</td>
							<td>${genre.artist_add}</td>
							<td>${genre.country}</td>
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
<script link src ="/script/insert_song.js"></script>
</html>