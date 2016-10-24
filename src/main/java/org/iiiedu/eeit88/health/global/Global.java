package org.iiiedu.eeit88.health.global;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Global {
	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
	public static final String DB_USER = "sa";
	public static final String DB_PASSWORD = "passw0rd";
	public static final String JNDI = "java:comp/env/jdbc/health";
	
	private static DataSource ds;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(Global.JNDI);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
