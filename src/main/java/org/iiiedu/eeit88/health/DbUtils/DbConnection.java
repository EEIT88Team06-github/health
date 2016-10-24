package org.iiiedu.eeit88.health.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public static Connection getConn(){
	
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;" 
						+ "databaseName=health;user=sa;password=passw0rd;");
				return connection;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			

	}

}
