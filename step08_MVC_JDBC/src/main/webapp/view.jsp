<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>view.jsp</title>
	</head>
	<body>
		<hr/>
		
		<p>부서 정보 : ${requestScope.dept }</p><br/>
		
		<p>부서 번호 : ${deptno }</p>
		<p>부서 이름 : ${dname}</p>
		<p>부서 위치 : ${loc}</p>
	
	
	</body>
</html>