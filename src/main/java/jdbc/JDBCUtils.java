package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	private static final String username = "root";
	private static final String password = "root123";
	private static final String url = "jdbc:mysql://localhost:3306/jdbcDemo";
	
	public static Connection getConnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url , username , password);
		}catch(ClassNotFoundException e)
		{
			System.out.println("Driver Not Found");
			e.printStackTrace();
		}catch(SQLException e)
		{
			System.out.println("Database not connected");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con)
	{
		try
		{
			if(con != null)
			{
				con.close();
				System.out.println("Connection Closed Successfully");
			}
		}catch(SQLException e)
		{
			System.out.println("SQL Error Occured");
			e.printStackTrace();
		}
	}
}
