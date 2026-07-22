package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchDemo {
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
			
			ps.setInt(1,  111);
			ps.setString(2, "Ravan");
			ps.setInt(3, 100001);
			ps.setDouble(4, 100);
			
			ps.addBatch();
			
			
			ps.setInt(1,  112);
			ps.setString(2, "Kumbhkaran");
			ps.setInt(3, 15000);
			ps.setDouble(4, 99.5);
			
			ps.addBatch();
			
			ps.setInt(1,  113);
			ps.setString(2, "Ahiravan");
			ps.setInt(3, 1);
			ps.setDouble(4, 99.7);
			
			ps.addBatch();
			
			int [] result = ps.executeBatch();
			
			for(int x : result)
			{
				System.out.println(x);
			}
									
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
