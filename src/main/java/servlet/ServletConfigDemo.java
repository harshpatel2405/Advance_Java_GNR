package servlet;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// modern approach 
//@WebServlet(
//	    urlPatterns = "/configDemo",
//	    initParams = {
//	        @WebInitParam(name = "username", value = "Demo"),
//	        @WebInitParam(name = "password", value = "Demo@123")
//	    }
//	)

public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		ServletConfig sc = getServletConfig();
		System.out.println("UserName : " + sc.getInitParameter("username"));
		System.out.println("Password : " + sc.getInitParameter("password"));
		
		ServletContext s1c = getServletContext();
		System.out.println("Token : " + s1c.getInitParameter("token"));
		
	}
}	
