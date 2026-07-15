package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDemo {
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
			
			Statement st = con.createStatement();
			
			String query = "delete from student where id = 1";
            //  String query = "Insert into student values ("+id+",'Raghav',16,95)";
		
			
			int rows = st.executeUpdate(query);
			if(rows > 0)
			{				
				System.out.println(rows + " row(s) inserted successfully in student table of jdbcDemo database");
			}else
			{
				System.out.println("Failed to insert data in table");
			}
			
			con.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
