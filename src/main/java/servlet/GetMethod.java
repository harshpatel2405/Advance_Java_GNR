package servlet;
import java.io.*; // * printWriter
import java.util.Map;

import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

@WebServlet("/getmethod")
public class GetMethod extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		String username = req.getParameter("uname");
		String gender = req.getParameter("gender");
		String []hobby = req.getParameterValues("hobby");
		
		System.out.println(req.getMethod());
		System.out.println(req.getContextPath());
		System.out.println(req.getRequestURI());
		
		Map<String , String[]>data = req.getParameterMap();
		
		
		out.println("<html>");
		out.println("<body>");
		if(username.isEmpty())
		{
			out.println("<b>Enter name to se e output over here </b>");
			
		}else
		{
			if(gender.equals("male"))
				out.println("<b>Hello, Mr. "+username+"</b>");	
			else
				out.println("<b>Hello, Ms./Mrs. "+username+"</b>");
			out.println("<b>Hobbies : </b>");
			for(String h : hobby)
			{
				out.print("<b>"+h+"</b>, ");
			}
		}
		
//		for(String key : data.keySet())
//		{
//			System.out.print("\n" + key+ " -> ");
//			String [] values = data.get(key);
//			
//			for(String value : values)
//			{
//				System.out.println(value);
//			}
//		}
		
		out.println("<a href='../../HTML/Get.html'>Get.html</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
}
}
