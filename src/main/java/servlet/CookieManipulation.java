package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieManipualtion")
public class CookieManipulation extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		ServletContext sc = getServletContext();
		
		
		Cookie cookie = new Cookie("username","harsh");
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		
		String username = cookie.getAttribute("username");
		
		if(username.equals("harsh"))
		{
			pw.println("<h2>Hello, "+username+", Inside IF</h2>");
		}else if(username.equals("shyam"))
		{
			pw.println("<h2>Hello, "+username+", Inside else IF</h2>");
		}
		
		sc.removeAttribute("username");
		
		
	}
}

