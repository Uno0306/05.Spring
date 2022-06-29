<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Cookie cookie1 = new Cookie("id", "test");
	cookie1.setMaxAge(60 *60);
	response.addCookie(cookie1);
	
	// Customer : String id, int age
	session.setAttribute("id", "spring-session");
	session.setAttribute("age", 29);
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
		<a href="session/cookieTest.do">CookieTest.do</a>
	
		<hr />
		<h3>Session API Test</h3>
		<a href="session/sessionTest1.do">1. session/sessionTest1.do</a><br/>
		
		<a href="session/sessionTest2.do?id=spring&age=29">2. session/sessionTest2.do : DTO 객체를 세션에 저장</a>
		
		<hr />
		<c:choose>
			<c:when test="${sessionScope.password eq null}">
				<h3>로그인 하러 가기</h3> 
				<a href="session/loginForm.do">로그인 하러 가기</a>	
			</c:when>
			<c:otherwise>
				<h3>로그아웃 하러 가기</h3> 
				<p>비밀번호 : ${sessionScope.password }</p>
				<a href="session/logout.do">로그아웃 하러 가기</a>
			</c:otherwise>
		</c:choose>
		<br />
		
		
		
	</body>
</html>