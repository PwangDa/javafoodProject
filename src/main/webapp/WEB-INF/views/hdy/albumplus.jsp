<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>앨범 관리페이지</title>
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
		<div class="mume" style="background-color:rgb(105, 116, 239)"><h3><a class="at" href="/insert_album"><c:out value="Album 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" id="outid" href="/insert_intoalbum"><c:out value="IntoAlbum 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" id="outid" href="/del_comment"><c:out value="댓글 관리"/></a></h3></div>
	</div>
<hr>
<div class="page_1">
			<form action="/list/album" class="butt_1">
				<span class="h2h2">Album_3 앨범정보등록</span>
				<input class="butt" type="submit" value="목록 전체조회"> 
			</form>
			<form  id="join" action="/albumplus">
			<div class="conn_1">
				<div class="conn">앨범 순서<input class="text_a" type="text" name="album_num" placeholder="album_num"></div>
				<div class="conn">앨범이미지 링크<textarea name="album_cover" placeholder="album_cover"></textarea></div>
				<div class="conn">앨범명<input class="text_a" type="text" name="album_name" placeholder="album_name"></div>
				<div class="conn">앨범소개<textarea name="album_into" placeholder="album_into"></textarea></div>
				<div class="conn">아티스트 이름<textarea name="artistname" placeholder="artistname"></textarea></div>
				<input class="butt" type="submit" value="추가">
				<input class="butt" type="reset" value="다시입력">			
			</div>
		</form>
</div>
<hr>
<!--여기서 부터 조회한 값이 테이블로 출력 -->
<div class="conn_2">
	<form action="/search/album">
	    <select id="opt" name="opt" style="height: 30px;">
	        <option value="human">가수검색</option>
            <option value="album">앨범검색</option>
        </select>
		<input class="text_a" type="text" name="artistname" placeholder="검색">
		<input class="butt" type="submit" value="검색">
	</form>
</div>
<hr>

<table class="table_1">
				<c:if test="${not empty list }">
					<thead>
						<tr>
							<th>Album_num</th>
							<th>Artistname</th>
							<th>Album_name</th>
							<th>Album_into</th>
							<th>Album_cover</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody id="tbody">
					<c:forEach var="artist" items= "${list }" >
						<tr>
							<form action="/update_album">
							<td>
								<input class="text_a text_d" type="text" name="album_num" placeholder="${artist.album_num}" value="${artist.album_num}">
							</td>
							<td>
								<input class="text_a text_b" type="text" name="artistname" placeholder="${artist.artistname}" value="${artist.artistname}">
							</td>
							<td>
								<input class="text_a text_b" type="text" name="album_name" placeholder="${artist.album_name}" value="${artist.album_name}">
							<td>
								<textarea class="text_c text_e" name="album_into" placeholder="${artist.album_into}" value="${artist.album_into}">${artist.album_into}</textarea>
							</td>
							<td>
								<textarea class="text_c text_e" name="album_cover" placeholder="${artist.album_cover}" value="${artist.album_cover}">${artist.album_cover}</textarea>
							</td>
							<td>
									<input class="butt_2" type="submit" value="수정">
							</td>
							</form>
							<td>
								<form action="/delete/artist">
									<input class="butt_2" type="submit" value="삭제">
									<input type="hidden" name="artistname" value="${artist.album_num}">
								</form>
							</td>
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