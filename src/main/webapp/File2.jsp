<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	int x =10;
int y = 0;
%>
	<h1><%=x/y %></h1>
	<h1>Name: <%= request.getParameter("name") %></h1>
	<h1>Address :<%= request.getParameter("address") %></h1>
</body>
</html>