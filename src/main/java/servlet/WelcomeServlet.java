package servlet;
import java.io.*; // * printWriter
import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

@WebServlet("/hello")
public class WelcomeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		String username = req.getParameter("uname");
		
		if(username == "")
		{
			out.println("<h2>Welcome ., Undefined</h2>");
		}
		else 
		{
			out.println("<h2>Welcome, "+username+"</h2>");
		}
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<b>Hello World</b>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
}
}
