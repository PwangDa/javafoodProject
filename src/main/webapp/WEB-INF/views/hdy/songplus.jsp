<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>앨범곡을 등록합시다</title>
</head>
<script>
	function fn_sendComment(){
		frmComment.method = "post";
		frmComment.action = "albumregi";
		frmComment.submit();
	}
	
	function fn_sendCommend(){
		frmCommend.method = "post";
		frmCommend.action = "albumregi";
		frmCommend.submit();
	}
</script>
<style>
	textarea{
            width: 300px;
            height: 110px;
    }
</style>
</head>
<body>
	<form action="/albumplus">
		<div>
			<h2>앨범정보등록</h2>
			<input type="text" name="album_num" placeholder="앨범순번">
			<textarea name="album_cover" placeholder="앨범표지링크"></textarea>
			<input type="text" name="album_name" placeholder="앨범이름">
			<textarea name="album_into" placeholder="앨범소개글"></textarea>
			<textarea name="artistname" placeholder="아티스트이름"></textarea>
			<input class="btn" type="submit" value="등록">
			
		</div>
	</form>
		<br>
	<form action="/songplus">
		<div>
			<h2>그 앨범의 수록곡 등록</h2>
			<input type="text" name="album_num" placeholder="앨범num">
			<input type="text" name="music_num" placeholder="music_num">
			<input type="text" name="music_name" placeholder="음악이름">
			<textarea name="music_link" placeholder="음악링크"></textarea>
			<input type="text" name="music_time" placeholder="음악런타임">
			<input type="text" name="album_name" placeholder="album_name">
			<input class="btn1" type="submit" value="등록">
		</div>
	</form>
</html>