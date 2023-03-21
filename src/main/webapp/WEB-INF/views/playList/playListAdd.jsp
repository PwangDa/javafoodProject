<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	String id = (String)request.getSession().getAttribute("loginId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트에 노래 추가</title>


<!-- css 파일 불러오기 -->
<link rel="stylesheet" href="/style/playList.css">


</head>
<body>
	<div class="title"><h1>노래를 추가할 플레이 리스트를 선택하세요.</h1></div>
	<br>
	<hr>
	<img class="addList" src="https://c11.kr/1asbg"> <span class="addList">리스트 추가</span>
	<!-- 플레이 리스트 추가하는 폼 -->
    <div class="search hidden">
        <form name = "PL_addList">
        	<input type="hidden" name="id" value="<%=id %>">
            <input type="text" name="addList_title" class="addList_textbar" placeholder="플레이리스트 제목을 입력해주세요."> <br>
            <input type="text" name="addList_explain" class="addList_ex_textbar" placeholder="플레이리스트 설명을 입력해주세요."> <br>
            <input type="button" name="addList_btn" class="addList_btn" value="추가">
        </form>
    </div>
	<br>
	
	<c:forEach var="playList" items="${ playList }">
		<!-- 누르면 추가함  -->
		<a href="/addContent?pl_id=${ playList.pl_id }">
			<div class="playList">
				<!-- 앨범 표지가 추가되면 해당 부분의 src를 수정할 것. -->
				<img class="album" src="https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined">
				<div class="plText">${ playList.pl_title }</div>
			</div>
		</a>
	</c:forEach>
	   	
   	<!-- js파일 불러오기 -->
   	<script src="/script/playList.js"></script>
   	
   	<!-- 반드시 jsp에 써야만 하는 스크립트 -->
   	<script>
	/*이스터에그*/
	let konamiCommand = "";
	
	document.addEventListener('keydown', (event) =>
	{
//		console.log("event.key : " + event.key);
		konamiCommand += event.key;
		console.log("konamiCommand : " + konamiCommand);
		
		if(konamiCommand == "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightba" || konamiCommand == "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightBA")
		{
			document.querySelector("img.esterEgg").classList.remove("hidden");
			cursor = "https://cdn.discordapp.com/attachments/931150181540450368/1085371872557932606/giphy_1.gif";
		}
		if
		(
				konamiCommand == "rhksflwkvpdlwl"
// 				&&
<%-- 				"admin".equals("<%= id %>")  --%>
		)
		{
			window.open('http://localhost:8080/insert_song');
		}
		if(konamiCommand != "" || konamiCommand != "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightba" || konamiCommand != "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightBA")
		{
			setTimeout(()=>{konamiCommand = ""; console.log("konamiCommand is reseted.");}, 5000);
		}
		
	});
   	</script>
   	
</body>
</html>