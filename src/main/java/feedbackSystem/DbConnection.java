package feedbackSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static String url = "jdbc:mysql://localhost:3306/java";
	private static String username = "root";
	private static String password = "root123";
	static Connection con = null;
	
	public static Connection getConnection() throws SQLException , ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username , password);
		
		return con;
	}
	
	
	public static void closeConnection(Connection con)
	{
		try
		{
			
			if(con != null)
			{
				con.close();
				System.out.println("Connection Closed Successfully...");
			}
			else
			{
				System.out.println("Error in closing the connection ....");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
