package resource.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DButils 
{	
	private DButils()
	{
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		return con = DriverManager.getConnection("jdbc:mysql://localhost/testdbrest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "admin") ; // create connection with DB
	}
}
