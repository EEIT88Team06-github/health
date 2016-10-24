package org.iiiedu.eeit88.health.namage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.namage.model.PermissionsBean;
import org.iiiedu.eeit88.health.namage.model.PermissionsDAO;

public class PermissionsDAODS implements PermissionsDAO{
	
//	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
//	public static final String DB_USER = "sa";
//	public static final String DB_PASSWORD = "passw0rd";
	
	private DataSource dataSource;
	public PermissionsDAODS(){
	try {
		Context ctx = new InitialContext();
		dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------

	
	private static final String PALL = "select * from member";
	@Override
	public List<PermissionsBean> select() {
		List<PermissionsBean> result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(PALL);
			rs = ract.executeQuery();{
			result = new ArrayList<PermissionsBean>();
			
			while (rs.next()) {
				PermissionsBean bean = new PermissionsBean();
				bean.setId(rs.getInt("id"));
				bean.setAccount(rs.getString("account"));
				bean.setLastname(rs.getString("lastname"));
				bean.setFirstname(rs.getString("firstname"));
				bean.setGender(rs.getString("gender"));
				bean.setNickname(rs.getString("nickname"));
//				bean.setEmail(rs.getString("email"));
				bean.setBonus(rs.getInt("bonus"));
				result.add(bean);
			}
		} 
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ract != null) {
				try {
					ract.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
