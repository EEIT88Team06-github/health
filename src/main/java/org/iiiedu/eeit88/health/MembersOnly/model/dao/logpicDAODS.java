package org.iiiedu.eeit88.health.MembersOnly.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.model.logpicBean;
import org.iiiedu.eeit88.health.MembersOnly.model.logpicDAO;
import org.iiiedu.eeit88.health.MembersOnly.model.slimminglogBean;

public class logpicDAODS implements logpicDAO{

	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
	public static final String DB_USER = "sa";
	public static final String DB_PASSWORD = "passw0rd";
	
	
	private static final String SELECT_BY_ID = "select * from logpic where id =?";
	@Override
	public logpicBean select(int id) {
		logpicBean result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ract = conn.prepareStatement(SELECT_BY_ID);
			ract.setInt(1, id);
			rs = ract.executeQuery();
			
			if (rs.next()) {
				result = new logpicBean();
				result.setLogid(rs.getInt("logid"));
				result.setPic(rs.getBytes("pic"));
				result.setId(rs.getInt("id"));
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
	
	
	private static final String SELECT_ALL = "select * from logpic";
	@Override
	public List<logpicBean> select() {
		List<logpicBean> result = new ArrayList<logpicBean>();
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ract = conn.prepareStatement(SELECT_ALL);
			rs = ract.executeQuery();
			while (rs.next()) {
				logpicBean bean = new logpicBean();
				bean.setId(rs.getInt("id"));
				bean.setLogid(rs.getInt("logid"));
				bean.setPic(rs.getBytes("pic"));
				result.add(bean);
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
}
