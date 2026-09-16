package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		String user = req.getParameter("username");
		int time = Integer.parseInt(req.getParameter("time"));
		Cookie cook = new Cookie("username", user);
		PrintWriter out = res.getWriter();
		
		if(req.getParameter("action").equals("read"))
		{
			String cookieName = cook.getName();
			String cookieValue = cook.getValue();
//			out.println("<b>Max Age : " + cook.getMaxAge()+"</b><br>");
			
//			
//			out.println("<b>Cookie Name : " + cook.getName() + "</b><br>");
//			out.println("<b>Cookie Value : " + cook.getValue() + "</b>");
			
			
			Cookie[] cookie = req.getCookies();

			if(cookie != null)
			{
				
				for(Cookie ck : cookie)
				{
					if(ck.getName().equals("username"))
					{
						out.println("<b>Cookie Name : " + ck.getName() + "</b><br>");
						out.println("<b>Cookie Value : " + ck.getValue() + "</b>");
					}
				}
			}
			else
			{
				out.println("<b>No Cookies present</b>");
			}
			
		}else if(req.getParameter("action").equals("create"))
		{
			cook.setMaxAge(time);
			res.addCookie(cook);
			out.println("<b>Cookie Set Successfully...</b>");
			
		}else if(req.getParameter("action").equals("delete"))
		{
			cook.setMaxAge(0);
			res.addCookie(cook);
			out.println("<b>Cookie Deleted Successfully...</b>");
		}
	}
}
