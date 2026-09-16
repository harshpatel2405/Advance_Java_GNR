package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAttribute")
public class GetAttribute extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		ServletContext sc = getServletContext();
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		pw.println("<h2>Inside Get Attribute File</h2>");
		pw.println("<b>UserName : " + sc.getAttribute("username")+"</b>");
		pw.println("<h2>Get Attribute File Completed..</h2>");
		
		sc.removeAttribute("username");
		
		
	}
}

