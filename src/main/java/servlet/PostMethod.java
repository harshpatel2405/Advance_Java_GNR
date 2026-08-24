package servlet;
import java.io.*; // * printWriter
import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

@WebServlet("/postmethod")
public class PostMethod extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		String username = req.getParameter("uname");
		
		out.println("<html>");
		out.println("<body>");
		if(username.isEmpty())
		{
			out.println("<b>Enter name to see output over here </b>");
			
		}else
		{
			out.println("<b>Name Entered by user is "+username+"</b>");	
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
		
}
}
