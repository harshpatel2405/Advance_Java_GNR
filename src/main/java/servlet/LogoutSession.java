package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logoutSession")
public class LogoutSession extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		System.out.println("HS Status : ");
		System.out.println(hs);
		
		if(hs != null)
		{
			hs.invalidate();
			res.sendRedirect("/HTML/login.html");
		}else
		{
			res.sendRedirect("/HTML/login.html");
		}
	}
}
