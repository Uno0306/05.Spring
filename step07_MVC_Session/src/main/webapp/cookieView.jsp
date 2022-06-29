<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>cookieView.jsp</title>
	</head>
	<body>
		<h2>cookieView</h2>
		<%
			// 쿠키값 가져오기
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null){
				
				for(int i=0; i < cookies.length; i++){
					Cookie c = cookies[i] ;
					
					// 저장된 쿠키 이름을 가져온다
					String cName = c.getName();
					if ("id".equals(cName) ){
					%>
						<%= cName %>
					<%
						// 쿠키값을 가져온다
						String cValue = c.getValue() ;
					 %>
					 	<%= cValue %>
					 <%
					}
				}
			}
		%>
		<br /><br />
		${cookie.id.name }
		${cookie.id.value }
		${cookie.id }
		
	</body>
</html>