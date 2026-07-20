package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {
	public static void main(String[] args) {
		String username = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/jdbcDemo";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url , username , password);
			
			
			Statement st = con.createStatement();
			
			String query = "select * from student";
			
			ResultSet rs = st.executeQuery(query);
			
			
			while(rs.next())
			{
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
