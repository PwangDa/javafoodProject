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
		<div class="mume"><h3><a class="at" href="/insert_song?page=a"><c:out value="Genre 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" href="/insert_song?page=b"><c:out value="Artist 관리"/></a></h3></div>
		<div class="mume" id="outsession" ><h3><a class="at" href="/insert_song?page=c"><c:out value="Album 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" id="outid" href="/insert_song?page=d"><c:out value="IntoAlbum 관리"/></a></h3></div>
	</div>
<hr>
<div class="page_1">
	<c:if test="${page=='a'}" >
		<span class="h2h2">장르관리 페이지</span>
		<form action="/list/artist" class="butt_1">
			<input id="btn_all" class="butt" type="button" value="목록 전체조회">
		</form>
		<form action="insert_song_up">
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
	</c:if>
</div>
<div class="page_1">
	<c:if test="${page=='b'}" >
				<span class="h2h2">아티스트 정보등록</span>
			<form action="/list/artist" class="butt_1">
				<input id="btn_all" class="butt" type="button" value="목록 전체조회">
			</form>
			<form action="/artistplus">
				<div class="conn_1">
					<div class="conn">아티스트 이름<input class="text_a" type="text" name="artistname" placeholder="Artistname"></div>
					<div class="conn">아티스트 소개<textarea name="artist_info" placeholder="artist_info"></textarea></div>
					<div class="conn">아티스트 사진링크<textarea name="artist_img" placeholder="artist_img"></textarea></div>
					<input class="butt" type="submit" value="추가">
					<input class="butt" type="reset" value="다시입력">
				</div>
			</form>
	</c:if>
</div>
<div class="page_1">
	<c:if test="${page=='c'}" >
			<span class="h2h2">Album_3 앨범정보등록</span>
			<form action="/list/album" class="butt_1">
				<input id="btn_all" class="butt" type="button" value="목록 전체조회">
			</form>
			<form action="/albumplus">
			<div class="conn_1">
				<!-- 시퀀스로 자동등록<div class="conn"><input class="text_a" type="text" name="album_num" placeholder="앨범순번"></div> -->
				<div class="conn">앨범이미지 링크<textarea name="album_cover" placeholder="album_cover"></textarea></div>
				<div class="conn">앨범명<input class="text_a" type="text" name="album_name" placeholder="album_name"></div>
				<div class="conn">앨범소개<textarea name="album_into" placeholder="album_into"></textarea></div>
				<div class="conn">아티스트 이름<textarea name="artistname" placeholder="artistname"></textarea></div>
				<input class="butt" type="submit" value="추가">
				<input class="butt" type="reset" value="다시입력">
				
			</div>
		</form>
	</c:if>
</div>
<div class="page_1">
	<c:if test="${page=='d'}" >
		<span class="h2h2">intoAlbum_2 의 수록곡 등록</span>
		<form action="/list/song" class="butt_1">
			<input id="btn_all" class="butt" type="button" value="목록 전체조회">
		</form>
		<form action="/songplus">
			<div class="conn_1">
				<div class="conn">앨범 순서<input class="text_a" type="text" name="album_num" placeholder="album_num"></div>
				<div class="conn">수록곡 순서<input class="text_a" type="text" name="music_num" placeholder="music_num"></div>
				<div class="conn">수록곡 이름<input class="text_a" type="text" name="music_name" placeholder="music_name"></div>
				<div class="conn">수록곡 재생링크<textarea name="music_link" placeholder="music_link"></textarea></div>
				<div class="conn">수록곡 재생시간<input class="text_a" type="text" name="music_time" placeholder="music_time"></div>
				<div class="conn">앨범명<input class="text_a" type="text" name="album_name" placeholder="album_name"></div>
				<input class="butt" type="submit" value="추가">
				<input class="butt" type="reset" value="다시입력">
			</div>
		</form>
	</c:if>
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
							<td><input type="checkbox" name="chk" value="${emp.empno}"></td>
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
<script link src ="/script/insert_song.js"></script>
</html>