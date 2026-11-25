
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Main JSP Page</h1>



<%
	String name = request.getParameter("uname");

	response.setContentType("text/html");

	out.println("<b>This is inside the scriptlet...");

	session.setAttribute("username","Aryan");
	String sessionName = (String)session.getAttribute("username");
	

	application.setAttribute("college", "ABC College");
	String CollegeName = (String)application.getAttribute("college");
	
	pageContext.setAttribute("age",22);
	int age = (Integer)pageContext.getAttribute("age");
	
	
	
%>
<b>Name = <%=name %></b>
<b>Session Name = <%=sessionName %></b>
<h1>College Name : <%= CollegeName %></h1>
<h1>Age : <%= age %></h1>
</body>
</html>