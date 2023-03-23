<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>

	<form id="upload-file-form">
	  <input type="text" name="extra">
	  <label for="upload-file-input">Upload your file:</label>
	  <input id="upload-file-input" type="file" name="uploadfile" accept="*" />
	  <button type="button" id="upload">업로드</button>
	</form>
<script>
$('#upload').on('click',function () {
	  $.ajax({
	    url: "/uploadFile",
	    type: "POST",
	    data: new FormData($("#upload-file-form")[0]),
	    enctype: 'multipart/form-data',
	    processData: false,
	    contentType: false,
	    cache: false,
	    success: function () {
	      // Handle upload success
	      // ...
	    },
	    error: function () {
	      // Handle upload error
	      // ...
	    }
	  });
	})
</script>
</body>
</html>