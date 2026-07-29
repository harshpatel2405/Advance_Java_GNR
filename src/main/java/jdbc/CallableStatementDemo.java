package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementDemo {
	public static void main(String[] args) {
		Connection con = JDBCUtils.getConnection();
		try
		{	
			if(con != null)
			{
				System.out.println("Connection Established Succesfully");
			}
			
			CallableStatement cs = con.prepareCall("{call getAllData()}");
			ResultSet rs = cs.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt("id"));
			}
			
			JDBCUtils.closeConnection(con);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

/*
 1. 
DELIMITER //

2. 

CREATE PROCEDURE getAllData()
BEGIN
    SELECT * FROM BANK;
END //

3. 
DELIMITER ;

4. 
call getAllData()

*/
