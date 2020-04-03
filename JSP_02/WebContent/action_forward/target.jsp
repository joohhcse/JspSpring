
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("target.jsp");
</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<h1>target.jsp입니다.</h1>
	<h1>이름 : <%= request.getParameter("name") %></h1>
	<h1>나이 : <%= request.getParameter("age") %></h1>
	
	
	
</body>
</html>