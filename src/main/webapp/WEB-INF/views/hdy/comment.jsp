<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아티스트 관리페이지</title>
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
		<div class="mume"><h3><a class="at" href="/insert_album"><c:out value="Album 관리"/></a></h3></div>
		<div class="mume"><h3><a class="at" id="outid" href="/insert_intoalbum"><c:out value="IntoAlbum 관리"/></a></h3></div>
		<div class="mume" style="background-color:rgb(105, 116, 239)"><h3><a class="at" id="outid" href="/del_comment"><c:out value="댓글 관리"/></a></h3></div>
	</div>
<hr>
<div class="page_1">
			<form action="/list/comment" class="butt_1">
			<span class="h2h2">댓글 전체 조회</span>
				<input class="butt" type="submit" value="댓글 전체조회"> 
			</form>
</div>
<hr>
<!--여기서 부터 조회한 값이 테이블로 출력 -->
<div class="conn_2">
	<form action="/search/id">
		<input class="text_a" type="text" name="id" placeholder="아이디 검색">
		<input class="butt" type="submit" value="검색">
	</form>
</div>
<hr>
 <table class="table_1">
				<c:if test="${not empty list }">
					<thead>
						<tr class="trtr">
							<th>articleNO</th>
							<th>parentNO</th>
							<th>comment_num</th>
							<th>comment_id</th>
							<th>comment_cont</th>
							<th>comment_date</th>
							<th>artistname</th>
							<th>id</th>
						</tr>
					</thead>
					<tbody id="tbody">
					<c:forEach var="artist" items= "${list }" >
						<tr>
							<td>
								<input class="text_a text_b" type="text" name="artistname" placeholder="${artist.articleNO}" value="${artist.articleNO}">
							</td>
							<td>
								${artist.parentNO}
							</td>
							<td>${artist.comment_num}</td>
							<td>${artist.comment_id}</td>
							<td>${artist.comment_cont}</td>
							<td>${artist.comment_Date}</td>
							<td>${artist.artistname}</td>
							<td>${artist.id}</td>

							<td>
								<form action="/delete/articleNO">
									<input class="butt" type="submit" value="삭제">
									<input type="hidden" name="articleNO" value="${artist.articleNO}">
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