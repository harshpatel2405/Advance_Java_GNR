package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcConnection {
	public static void main(String[] args) {
		String username = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/jdbcDemo";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url , username , password);
			
			if(con != null)
			{
				System.out.println("Connection Established Successfullly");
			}
			
			con.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
