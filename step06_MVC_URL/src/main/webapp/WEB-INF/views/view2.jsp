<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>View2</title>
	</head>
	<body>
		<h2>view2</h2>
		
		<p>객체로 다 가져오기</p>
		${requestScope.customer.id } - ${requestScope.customer.age } <br/>
		${requestScope.customer }
		
		<br/><br/><br/>
		
		<p>하나씩 가져오기</p>
		
		${requestScope.id } - ${requestScope.age } <br/>
		
	</body>
</html>