<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>helloMVC Web Application</title>
</head>
<body>

	This is the home page for shopping

	<p> <a href="/helloMVC/home?action=login"> go to login page </a> </p>
	<p> <a href="/helloMVC/home?action=register"> go to register page </a> </p> <%-- 사용자의 선택에 따라 login 또는 register 페이지로 응답한다. --%>
	
</body>
</html>