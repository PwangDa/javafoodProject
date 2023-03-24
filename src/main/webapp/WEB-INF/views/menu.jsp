<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javafood menu</title>

<link rel="stylesheet" href="/style/menuCSS.css?css=css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script> 
	let id = '${loginId}'
	let imgjpg ='${param.imgjpg}'	
	console.log('imgjpg : ',imgjpg)
	console.log('id : ',${loginId})
</script>
</head>
<body>
    <header id ="menu" style="display: inline-block;" >
        <span style="font-size: 34px; font-weight: 600; cursor: pointer;">
        <a href="/main" class="a1"><img src="https://c11.kr/1asbb" class="logo-img">Music</a>
        </span>
        <div class="menu-box">
            <a href="/main" class="a1"><span class="main main_1" >홈</span></a>
            <a href="/genre" class="a1"><span class="main main_2" >장르별</span></a>
            <a href="/playList" class="a1"><span class="main main_3" >보관함</span></a>
           	<select id="opt" style="height: 30px;">
                <option value="song"><c:out value="노래검색"/></option>
	            <option value="man"><c:out value="가수검색"/></option>
            </select>
            <div class = "main-box main_4">
                <input id="pot" class="search-txt" type="text" placeholder="검색">
                <button class="search-btn" type="button" id="cli">검색</button>
            </div>
        </div>

        <span id="spa" class="abc">
        	<c:if test="${param.imgjpg != null}">
		        <a href="/my_page"><img class="menu-img" src="/ajax/filedo?fileName=${loginId}.JPG"></a>
        	</c:if>
	        <c:if test="${param.imgjpg == null}">
		        <c:if test="${loginImg!=null}">
			        <a href="/my_page"><img class="menu-img" src=" ${loginImg}"></a>
		        </c:if>
		        <c:if test="${loginImg==null}">
					<a href="/my_page"><img class="menu-img" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png"></a>
		        </c:if>
	        </c:if>
    	</span>
        
        
        
    </header>
    <div id="di">
		<a class="at" href="/my_page">마이페이지</a><br>
		<a class="at" href="/main">메인</a><br>
		<a class="at" href="/playList">보관함</a><br>
		<c:if test="${loginId==null }">
			<a class="at" href="/login">로그인</a><br>
		</c:if>
		<c:if test="${loginId!=null }">
			<a class="at" id="outId">로그아웃</a><br>
		</c:if>
		<c:if test="${loginId=='master' }">
			<a class="at" href="/insert_song">관리자 페이지</a>
		</c:if>
	</div>
	
	
</body>
<script link src ="/script/menuScript.js"></script>
</html>