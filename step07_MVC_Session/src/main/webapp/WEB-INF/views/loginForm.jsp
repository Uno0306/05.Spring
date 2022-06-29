<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LoginForm.jsp</title>
	</head>
	<body>
		<h2>관리자 로그인</h2>
		
		<form action="login.do" method="POST">
			PW : <input type="password" name="password" placeholder="비밀번호를 입력해주세요." /><br/>
			<input type="submit" value="입력" />
		</form>
	</body>
</html>