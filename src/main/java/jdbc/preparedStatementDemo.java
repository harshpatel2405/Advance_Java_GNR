package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class preparedStatementDemo {
	public static void main(String[] args) {
		String username = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/jdbcDemo";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url , username , password);
			
			
			String query = "INSERT INTO STUDENT VALUES (?,?,?,?)";
			PreparedStatement  ps= con.prepareStatement(query);
			
			ps.setInt(1,  102);
			ps.setString(2, "Bharat");
			ps.setInt(3, 21);
			ps.setDouble(4, 98.7);
			int rows = ps.executeUpdate();
			System.out.println(rows + " rows inserted successfullly");
			

//			ps.setInt(1,  103);
//			ps.setString(2, "Kshatrughan");
//			ps.setInt(3, 20);
//			ps.setDouble(4, 97.5);
//			rows = ps.executeUpdate();
//			System.out.println(rows + " rows inserted successfullly");
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
