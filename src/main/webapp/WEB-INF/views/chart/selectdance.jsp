<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>순위</td>
			<td>인기점수</td>
			<td>번호</td>
			<td>앨범</td>
			<td>앨범명</td>
			<td>제목</td>
			<td>가수</td>
			<td>장르</td>
			<td>조회수</td>
			<td>좋아요</td>
			<td>재생 시간</td>
		</tr>
			<c:forEach var="dance" items="${list }">
				<tr>
					<td>${list.ranking }</td>
					<td>${list.famous }</td>
					<td>${list.songnumber }</td>
					<td>${list.imagelink }</td>
					<td>${list.album_name }</td>
					<td>${list.songname }</td>
					<td>${list.artistname }</td>
					<td>${list.bygenre }</td>
					<td>${list.hits }</td>
					<td>${list.likes }</td>
					<td>${list.playtime }</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>