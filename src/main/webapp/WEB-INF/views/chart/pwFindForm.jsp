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
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link rel="stylesheet" href="/style/chartCSS.css">
</head>
<body>

	<div class="pwFind-form">
    <form action="pwFindForm_ok.do" method="post" class="form-horizontal" name="pfrm">
	
      	<div class="row">
        	<div align="center">
			<h2>비밀번호 찾기</h2>
		</div>	
      	</div>			
        <div class="form-group row">
		<label class="col-form-label col-4">아이디</label>
		<div class="col-8">
			<input type="text" class="form-control" name="id" placeholder="아이디를 입력하세요." required="required">
		</div>        	
        </div>

	<div class="form-group row">
		<label class="col-form-label col-4">이메일</label>
		<div class="col-8">
			<input type="text" class="form-control" name="mail" placeholder="메일을 입력하세요." required="required">
		</div>        	
        </div>
	<div class="form-group row">
		<button type="submit" id="submit" class="btn btn-primary btn-lg">비밀번호 찾기</button>
	</div>		

    </form>
</div>
</body>
</html>