<%@ page import="com.java.food.dto.login_DTO"%>
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
	<%
	request.setCharacterEncoding("utf-8");
	

	String id = (String)request.getAttribute("id");
	String pwd = (String)request.getAttribute("pwd");
	
	int flag = (Integer)request.getAttribute( "flag" );
	out.println( " <script type='text/javascript'> " );

	if( flag == 0 ) {	// 아이디, 메일 일치
		out.println( " alert('비밀번호는"+pwd+"입니다.')" );
		out.println( " location.href='./loginForm.do'" );
		
	} else if( flag == 1 ) {	//메일 틀림
		out.println( " alert('메일을 다시 확인해주세요.'); " );
		out.println( " history.back(); " );
	} else if( flag == 2 ) {	//회원정보없음
		out.println( " alert('회원정보가 없습니다. 회원가입해주세요.'); " );
		out.println( " history.back(); " );
	} else {					//기타 에러났을 때
		out.println( " alert('다시 입력해주세요.'); " );
		out.println( " history.back(); " );
	}
	out.println( " </script> " );

%>
</body>
</html>