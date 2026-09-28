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
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginSession")
public class LoginSession extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		if(username.equals("admin") && password.equals("admin@123"))
		{
			HttpSession hs = req.getSession();
			
			hs.setAttribute("username",username);
			RequestDispatcher rd = req.getRequestDispatcher("HTML/success.html");
			rd.forward(req, res);				
		}
		else
		{
			out.println("<b>Invalid Credentials..</b>");
			out.println("<a href='/HTML/LoginSessionDemo.html'>Click to go to Login Page</a>");
			
		}
	}
}

