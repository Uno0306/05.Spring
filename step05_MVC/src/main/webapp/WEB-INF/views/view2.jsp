<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>View2</title>
	</head>
	<body>
		<h2>View2</h2>
		
		<br/><hr/>
		1. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.msg} <br />
		2. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.customer} <br />
		3. ${requestScope.customer.id} - ${requestScope.customer.age} <br />
		
		
	</body>
</html>