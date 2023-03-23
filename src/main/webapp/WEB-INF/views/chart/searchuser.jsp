<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>닉네임</th>
			</tr>
		</thead>
		<tbody>
			<form action="searchuser" method="post">
				<input type="submit" value="${loginNic }" name="nic">
			</form>
		</tbody>
			
	</table>
	
</body>
</html>