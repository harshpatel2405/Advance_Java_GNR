package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

public class TransactionDemo2 {
	public static void main(String[] args) {
		Connection con = JDBCUtils.getConnection();
		try
		{
			if(con != null)
			{
				System.out.println("Connection Established Successfully");
			}
			con.setAutoCommit(false);
			
			String withdraw = "update bank set balance = balance - ? where id = ?";
			String deposit = "update bank set balance = balance + ? where id = ?";
			
			PreparedStatement ps1 = con.prepareStatement(withdraw);
			PreparedStatement ps2 = con.prepareStatement(deposit);
			
			// * money withdraw
			ps1.setDouble(1, 10000);
			ps1.setInt(2, 2);
			ps1.executeUpdate();
			System.out.println("Money Withdrawn Successfully");
			
			String sql = "Select * from bank";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("ID\tname\tBalance");
			while(rs.next())
			{
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getDouble("balance"));
			}
			
			// * error 
			int x = 10 / 0;
				
			// * money deposit
			ps2.setDouble(1, 10000);
			ps2.setInt(2, 1);
			ps2.executeUpdate();
			System.out.println("Money Depositted Successfully");
			
			con.commit();
			
			JDBCUtils.closeConnection(con);
		}catch(Exception e)
		{
			try
			{
				if(con != null)
				{
					con.rollback();
					System.out.println("Transaction Rolled Back Successfully");
				}
			}catch(SQLException e2)
			{
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
