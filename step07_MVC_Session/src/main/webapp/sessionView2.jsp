<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>sessionView2.jsp</title>
	</head>
	<body>
		<h2>sessionView2</h2>
		
		<h3>세션에 저장된 Customer 객체 데이터 값을 활용</h3>
		${sessionScope.customer.id } - ${sessionScope.customer.age }
		<hr />
		
		<a href="session/customerDelete.do">customer 객체 삭제</a>	<br/>
		<a href="index.jsp">index.jsp로 돌아가기</a>	<br/>
		
		
	</body>
</html>