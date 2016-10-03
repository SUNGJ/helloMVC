<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP Expression Language --%>
	<h1> You registered successfully.</h1>
	<p>
	<ul>
	<li>id: ${customer.id} </li>
	<li>password: ${customer.password} </li>
	<li>gender: ${customer.gender} </li>
	<li>Name: ${customer.name} </li>
	<li>Email: ${customer.email} </li> <%-- request객체에 저장 된 customer객체의 정보를 불러온다. --%>
	</ul>
		<a href="/helloMVC/index.jsp"> go to home page</a>
	</p>
</body>
</html>