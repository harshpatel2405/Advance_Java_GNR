package feedbackSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet("/feedbackServlet")
public class FeedbackServlet extends HttpServlet{
	private static String url = "jdbc:mysql://localhost:3306/jdbc_demo";
	private static String username = "root";
	private static String password = "root123";
	private static int id = 1;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
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

			
		String name = req.getParameter("name");
		String courseName= req.getParameter("courseName");
		double rating = Double.parseDouble(req.getParameter("rating"));
		String comment = req.getParameter("comment");
		
		
		String Query = "Insert into  feedback values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(Query);
		
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, courseName);
		ps.setDouble(4, rating);
		ps.setString(5, comment);
		id++;
		int rows = ps.executeUpdate();
		
		System.out.println(rows + " rows inserted successfully in database ......");
		
		
		
		
		PrintWriter out  = res.getWriter();
		
		out.println("<h1>"+rows + " rows inserted successfully in database ......</h1>");
		
		out.println("<h1>Name : " + name + "</h1>");
		out.println("<h1>Course Name : " + courseName + "</h1>");
		out.println("<h1>Rating : " +rating+ "</h1>");
		out.println("<h1>Coments : " +comment+ "</h1>");
		
		DbConnection.closeConnection(con);
		}
		catch(Exception e)
		{
				e.printStackTrace();
		}
	}
}	
