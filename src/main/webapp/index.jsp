<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP Page</title>
</head>
<body>
	<h1>This is my First JSP Page</h1>
	
	 
	 <%!
	 	int arr[] = {10,20,30,40,50};
	 
	 
	 	int [] getArray()
	 	{
	 		return arr;
	 	}
	 	
	 	String getArrayString()
	 	{
	 		String res = "[";
	 		for(int i = 0 ; i < 5;i++)
	 		{
	 			res+=arr[i]+", ";
	 		}
	 		res+="]";
	 		
	 		return res;
	 	}
	 
	 %>
	 
	 <h1>Array : <%= Arrays.toString(getArray()) %></h1>
	 <h1>Array : <%= getArrayString() %></h1>
	 
	 
	 <%
	 	for(int i = 0 ; i < 5;i++)
	 	{		
	 %>
	 <b><%=arr[i] %></b>
	 <%
	 }
	 %>
	 <br>
	 
	 <% 
	 for(int i = 1 ; i <= 3;i++)
	 	{	
		 for(int j = 1 ; j <= 5;j++)
		 	{	
	 %>
	 
	 <b><%= j %></b>
	 
	 <%
		 	}
	 %>
	 <br>
	 <%
	 	}
	 %>
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
</body>
</html>