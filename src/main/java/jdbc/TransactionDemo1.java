/*
 Transaction -- group of queries executed together
 
 commit 
 Example 
 Account A --> Withdrawn 10000
 Account B --> Deposit 10000
 
  1. Both should get successfully executed 
  2. none should does not affect database
  
  original values should be there 
 */


package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionDemo1 {
	public static void main(String[] args) {
		try
		{
			
		Connection con = JDBCUtils.getConnection();
		
		
		if(con != null)
		{
			System.out.println("Connection Established Successfully");
		}
		con.setAutoCommit(false);
		
		String withdraw = "update bank set balance = balance - ? where id = ?";
		String deposit = "update bank set balance = balance + ? where id = ?";
		
		PreparedStatement ps1 = con.prepareStatement(withdraw);
		PreparedStatement ps2 = con.prepareStatement(deposit);
		
		ps1.setDouble(1, 10000);
		ps1.setInt(2, 2);
		
		ps2.setDouble(1, 10000);
		ps2.setInt(2, 1);
		
		ps1.executeUpdate();
		System.out.println("Money Withdrawn Successfully");
		ps2.executeUpdate();
		System.out.println("Money Depositted Successfully");
		
		JDBCUtils.closeConnection(con);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

/*
 1. create table bank(id INTEGER, balance DOUBLE, name varchar(20));
 */
