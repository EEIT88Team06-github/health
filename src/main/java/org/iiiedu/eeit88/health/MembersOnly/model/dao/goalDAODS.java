package org.iiiedu.eeit88.health.MembersOnly.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.MembersOnly.model.goalBean;
import org.iiiedu.eeit88.health.MembersOnly.model.goalDAO;
import org.iiiedu.eeit88.health.MembersOnly.model.slimminglogBean;

public class goalDAODS implements goalDAO{
	
	
//	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
//	public static final String DB_USER = "sa";
//	public static final String DB_PASSWORD = "passw0rd";
	
	private DataSource dataSource;
	public goalDAODS(){
	try {
		Context ctx = new InitialContext();
		dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------

	private static final String SELECT_BY_ID = "select * from goal where goal=?";
	@Override
	public goalBean select(int goal) {
		goalBean result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(SELECT_BY_ID);
			ract.setInt(1, goal);
			rs = ract.executeQuery();
			
			if (rs.next()) {
				result = new goalBean();
				result.setGoal(rs.getInt("goal"));
			}
		} catch (SQLException e) {
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

	
	private static final String UPDATE = "update logs set goal=?,content=?,goaltime=? where memid=?";
	@Override
	public goalBean update(Integer goal, Float content, Date goaltime, Integer memid) {
		goalBean result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(UPDATE);
			
			ract.setInt(1, goal);
			ract.setFloat(2, content);
			ract.executeUpdate(); 
			int i = ract.executeUpdate();
			if(i==1) {
				result = this.select(memid);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
