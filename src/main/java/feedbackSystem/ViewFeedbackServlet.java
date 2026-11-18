package feedbackSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewFeedbackServlet")
public class ViewFeedbackServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String url = "jdbc:mysql://localhost:3306/jdbc_demo";
	private static String username = "root";
	private static String password = "root123";
	private static int id = 1;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, username , password);
			
				if(con == null)
				{
					System.out.println("Connection Creation error ");
					return ;
				}
				System.out.println("Connection Created Successfullyy");
				PrintWriter out = res.getWriter();
				res.setContentType("text/html");
				
				String Query = "Select * from feedback";
			
				
				PreparedStatement ps = con.prepareStatement(Query);
				
				ResultSet rs = ps.executeQuery();
				System.out.println("ID\tStudent Name\tCourse Name\tRating\tFeedback");
				
				out.println("<h2>Student Feedback Details</h2>");
				
				out.println("<table border='1' cellpadding='10' cellspacing='0'>");

				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Student Name</th>");
				out.println("<th>Course Name</th>");
				out.println("<th>Rating</th>");
				out.println("<th>Comment</th>");
				out.println("</tr>");

				while (rs.next()) {
				    out.println("<tr>");

				    out.println("<td>" + rs.getInt("id") + "</td>");
				    out.println("<td>" + rs.getString("studentname") + "</td>");
				    out.println("<td>" + rs.getString("coursename") + "</td>");
				    out.println("<td>" + rs.getDouble("rating") + "</td>");
				    out.println("<td>" + rs.getString("comment") + "</td>");

				    out.println("</tr>");
				}
				out.println("</table>");
				
				
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
}
