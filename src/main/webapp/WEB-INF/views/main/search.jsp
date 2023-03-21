<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/style/artistCSS.css">
</head>

<body>
 <div id ="cont1_1">
            <h2 style="text-align: center; margin: 13px;">음악</h2>            
			<%-- 음악 부분 forEach --%>
           	
           		<c:forEach var="album" items="${searchlist}" varStatus="loop">
	            <div id = "cont1">
	                <div class = "box1_1">
	                    <a href="/albumpage?album=${album.album_name}"><img class="img1" src="${album.imagelink }"></a>
	                </div>
	                <div class = "box1 text2"><a href="${album.link}"><strong>${album.songname}</strong></a></div>
	                <div class = "box1 text2" style = "color:rgb(192, 192, 192);">${album_list[0].artistname }</div>
	                <div class = "box1 text2"><a style = "color:rgb(192, 192, 192);" href="/albumpage?album=${album.album_name}">${album.album_name }</a></div>
	                <div><!-- 하트 버튼 -->
	                	<img class="img2 heart" src="https://c11.kr/1asbx" onclick="good(${ album.songnumber })">
	                </div>
	                <div><!-- 재생 버튼 -->
	                	<a href="${album.link}" target='_blank'><img class="img img2" src="https://c11.kr/1asd1" onmouseover="this.src='https://c11.kr/1asd5'" onmouseout="this.src='https://c11.kr/1asd1'" onclick="hit(${ album.songnumber })"></a>
	                </div>
	                <form name="addPlayList" method="post" action="/playListAdd">
						<div><!-- 담기 버튼 -->
							<input type="hidden" class="put" name="songNumber" value="${ album.songnumber }">
							<input type="hidden" class="put" name="addWhere" value="NewGenre">
	            			<img class="img img2 addList" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
	            		</div>	  
            		</form>              
	            </div>
	            <hr>
            	</c:forEach>
		
<script link src ="/script/artistScript.js"></script>
</body>
</html>