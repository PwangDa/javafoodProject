<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 
      .con{
        width: 100%;
        margin: 0px auto;
        border: 0px solid #bcbcbc;
      }
      .hea {
        padding: 0px;
        margin: 0px;
        border: 0px solid #bcbcbc;
        background-color: lightgreen;
      }
</style>
</head>
<body>
<div class="hea">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div class="con">
	<tiles:insertAttribute name="body"></tiles:insertAttribute>
</div>
</body>
</html>