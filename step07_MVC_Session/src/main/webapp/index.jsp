<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie1 = new Cookie("id", "test");
	cookie1.setMaxAge(60 *60);
	response.addCookie(cookie1);
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index.jsp</title>
	</head>
	<body>
		<h2>Index.jsp</h2>
		
		<h3>Cookie API Test</h3>
		<a href="cookieTest.do">CookieTest.do</a>
	
	</body>
</html>