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

@WebServlet("/setAttribute")
public class  SetAttribute extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		ServletContext sc = getServletContext();
		
		sc.setAttribute("username", "Demo");

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		
		pw.println("<h2>Inside Set Attribute File</h2>");
		
		RequestDispatcher rd = req.getRequestDispatcher("/getAttribute");
		
		rd.include(req,res);
		
		pw.println("<h2>Set Attribute File Completed</h2>");
	
		
		
		
	}
}

