package jdbc;

import java.sql.Connection;

public class TestConnection {
	public static void main(String[] args) {
		Connection con = JDBCUtils.getConnection();
		
		if(con != null)
		{
			System.out.println("Connection Established Successfully");
		}
		
		
		JDBCUtils.closeConnection(con);
	}
}
