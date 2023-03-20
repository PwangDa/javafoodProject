<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	background: black;
}
</style>
<br>
<br>
<br>


<body>
	<form action="">
		<h1>관리자 페이지</h1>
		<div>
			songnumber : <input type="text" name="songnumber" placeholder="노래번호"><br>
			artistname : <input type="text" name="artistname" placeholder="가수명"><br>
			songname : <input type="text" name="songname" placeholder="노래명"><br>
			link : <textarea name="link" placeholder="노래링크"></textarea><br> 
			album_name : <textarea name="album_name" placeholder="앨범명"></textarea><br>
			bygenre : <select id="select" name="bygenre" class="selectbox" onchange="">
						<option value="발라드">발라드</option>
						<option value="댄스">댄스</option>
						<option value="POP">POP</option>
						<option value="R&B">R&B</option>
						<option value="인디">인디</option>
						<option value="트로트">트로트</option>
						<option value="록">록/메탈</option>
						<option value="랩">랩/힙합</option>
					  </select><br>
			playtime : <input type="text" name="playtime" placeholder="재생시간"><br>
			imagelink :	<textarea name="imagelink" placeholder="앨범표지링크"></textarea><br>
			album_add :	<textarea name="album_add" placeholder="앨범정보"></textarea><br> 
			artist_add : <input type="text" name="artist_add" placeholder="가수명번호"><br>
			country : <select id="select" name="country" class="selectbox" onchange=""><br>
						<option value="대한민국">대한민국</option>
						<option value="일본">일본</option>
						<option value="미국">미국</option>
					  </select>
		</div>
	</form>
</body>
</html>