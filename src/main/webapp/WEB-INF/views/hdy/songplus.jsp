<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>앨범곡을 등록합시다</title>
</head>
<script>
	function fn_sendComment() {
		frmComment.method = "post";
		frmComment.action = "albumregi";
		frmComment.submit();
	}

	function fn_sendCommend() {
		frmCommend.method = "post";
		frmCommend.action = "albumregi";
		frmCommend.submit();
	}
</script>
<style>
textarea {
	width: 300px;
	height: 110px;
}
</style>
</head>
<body>
	<form action="">
		<div>
			<h2>앨범정보등록</h2>
			<input type="text" name="SONGNUMBER" placeholder="앨범순번">
			<textarea name="album_cover" placeholder="앨범표지링크"></textarea>
		</div>
	</form>
</html>