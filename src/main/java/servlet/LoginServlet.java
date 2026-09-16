package servlet;
import java.io.*; // * printWriter
import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		String demail = "harsh@gmail.com";
		String dpwd = "1234";
		
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		
		if(email.isBlank() || password.isBlank())
		{
			out.println("<html>");
			out.println("<body>");
			out.println("<b>Enter email or password</b>");
			out.println("</body>");
			out.println("</html>");
			return ;
		}
		
		if(email.equals(demail) && password.equals(dpwd))
		{
			RequestDispatcher rd = req.getRequestDispatcher("HTML/success.html");
			rd.forward(req, res);
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("HTML/failure.html");
			rd.forward(req, res);
		}
	
		
}
}
