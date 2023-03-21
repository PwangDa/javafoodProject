
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>JavaFood Music</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link rel="stylesheet" href="/style/chartCSS.css">

</head>
<%-- <jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include> --%>
<body>
 		<div>
			<form name="addPlayList" method="post" action="/playListAdd"">
				<input type="hidden" name="songNumber" value="${dao.songnumber }">
				<input type="hidden" name="addWhere" value="song">
				<img id="addLists" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
			</form>
		</div>
		<div class="time">
			<strong>국가 선택</strong>
			<a href="/chart?country=대한민국"><input class="tab1 tab1_1" type="button" name="country" value="한국"></a>
			<a href="/chart?country=일본"><input class="tab1 tab1_2" type="button" name="country" value="일본"></a>
			<a href="/chart?country=미국"><input class="tab1 tab1_3" type="button" name="country" value="미국"></a>
			<input type="text" size="10" id="timebox"> 현재시각 기준
		</div>
	<div class="list">		
		<table class="table">
			<tr class="table2">
				<td style="width: 200px;"><input type="checkbox" id="selectbtn" name="checkall" onclick="selectAll(this); getCheckedValue()" value="checkall; ${dao.songnumber }">체크</td>
				<td style="width: 60px;">순위</td>
				<td style="width: 250px;">인기점수</td>
				<td style="width: 100px;">번호</td>
				<td style="width: 100px;">앨범</td>
				<td style="width: 400px;">앨범명</td>
				<td style="width: 400px;">제목</td>
				<td style="width: 400px;">가수</td>
				<td style="width: 100px;">장르</td>
				<td style="width: 100px;">조회수</td>
				<td style="width: 120px;">좋아요</td>
				<td style="width: 120px;">재생 시간</td>
				<td style="width: 50px;">재생</td>
				<td style="width: 80px;">담기</td>
			</tr>
			<c:forEach var="dao" items="${ list}">
				<tr class="table3 table3_${dao.songnumber }">
					<td><input type="checkbox" id="checkbox1" name="check" onclick="checkSelectAll(); getCheckedValue()" value="${dao.songnumber }"></td>
					<td>${dao.ranking }</td>
					<td>${dao.famous }</td>
					<td>${dao.songnumber }</td>
					<td><img src=${ dao.imagelink} " style="width: 80px;"></td>
					<td><a
						href="/albumpage?album=${dao.album_name}">${ dao.album_name}</a></td>
					<td>${dao.songname }</td>
					<td><a
						href="/artistpage?artist=${dao.artistname}">${ dao.artistname}</a></td>

					<td>${dao.bygenre }</td>

					<form method="post" action="/chart">
						<td>${dao.hits }<input type="hidden" name="addhit"
							value="${dao.songnumber}">
						</td>
					</form>

					<form method="post" action="/my_page/good2">
						<td>${dao.likes }<input type="image"
							src="https://c11.kr/1asbx" value=" " class="like"> <input
							type="hidden" name="good" value="${dao.songnumber}">
						</td>
					</form>

					<td>${dao.playtime }</td>

					<td><a href="#"
						onclick="window.open('https://www.youtube.com/results?search_query=${dao.songname }'); hit('${dao.songnumber }'); "><img
							class="play" src="https://c11.kr/1asd1"></a></td>

					<td>
						<form name="addPlayList" method="post" action="/playListAdd">
							<input type="hidden" name="songNumber" value="${dao.songnumber }">
							<input type="hidden" name="addWhere" value="song">
							<img class="addList" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

<%
int totalCount = (int) request.getAttribute("totalCount");
int pageNum = (int) request.getAttribute("pageNum");
int countPerPage = (int) request.getAttribute("countPerPage");
// int / int = int
// double / int = double
int lastPage = (int) Math.ceil((double) totalCount / countPerPage);
int section = 50;

int sec_position = (((int) Math.ceil((double) pageNum / section)) - 1);
int firstSec = (sec_position * section) + 1;
int lastSec = firstSec + section - 1;
if (lastSec > lastPage) {
	lastSec = lastPage;
}
String country = request.getParameter("country");
%>
		<c:set var="pageNum2" value="<%=pageNum%>" />
		<div class="paging">
<% if(country != null && country.equals("대한민국") )
	{%>

			<c:if test="<%=firstSec != 1%>">
				<a
					href="/chart?pageNum=<%= firstSec-1 %>&country=<%= country %>"><img
					class="mouse" src="https://c11.kr/1ascb"
					onmouseover="this.src='https://c11.kr/1ascc'"
					onmouseout="this.src='https://c11.kr/1ascb'"></a>
			</c:if>

			<c:forEach var="i" begin="<%=firstSec%>" end="<%=lastSec%>">
				<c:if test="${ i == pageNum2 }">
					<a
						href="/chart?pageNum=${i }&country=<%= country %>"
						class="number"><strong>${i}</strong></a>
				</c:if>
				<c:if test="${ i != pageNum2 }">
					<a
						href="/chart?pageNum=${i }&country=<%= country %>"
						class="number">${i}</a>
				</c:if>
			</c:forEach>

			<c:if test="<%=lastSec != lastPage%>">
				<a
					href="/chart?pageNum=<%= lastSec+1 %>&country=<%= country %>"><img
					class="img" src="https://c11.kr/1ascx"
					onmouseover="this.src='https://c11.kr/1ascy'"
					onmouseout="this.src='https://c11.kr/1ascx'"></a>
			</c:if>

		</div>
	<%} %>
	</div>
<script link src="/script/chartScript.js"></script>
</body>
</html>
