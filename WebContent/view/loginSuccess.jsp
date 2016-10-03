<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP Expression Language --%>
	<h1> ${customer.name} logged in successfully.</h1> <%-- request객체에 저장 된 customer객체의 name 값 불러오기 --%>
	<p>
		<a href="/helloMVC/index.jsp"> go to home page</a>
	</p>
</body>
</html>