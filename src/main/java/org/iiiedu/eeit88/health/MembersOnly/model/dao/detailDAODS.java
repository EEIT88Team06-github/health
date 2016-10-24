package org.iiiedu.eeit88.health.MembersOnly.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.MembersOnly.model.detailBean;
import org.iiiedu.eeit88.health.MembersOnly.model.detailDAO;

public class detailDAODS implements detailDAO{

//	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
//	public static final String DB_USER = "sa";
//	public static final String DB_PASSWORD = "passw0rd";
	
	private DataSource dataSource;
	public detailDAODS(){
	try {
		Context ctx = new InitialContext();
		dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_ID = "select * from detail where id =?";
	@Override
	public detailBean select(int id) {
		 
		 detailBean result = null;
		 Connection conn = null;
		 PreparedStatement ract = null;
		 ResultSet rs = null;
		 
		 try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(SELECT_BY_ID);
			ract.setInt(1, id);
			rs = ract.executeQuery();
			
			if(rs.next()){			
				result = new detailBean();
				result.setId(rs.getInt("id"));
				result.setOrdid(rs.getInt("ordid"));
				result.setProdid(rs.getInt("prodid"));
				result.setQuantiy(rs.getInt("quantiy"));
				result.setTotal(rs.getInt("total"));
				
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

	private static final String SELECT_ALL = "select * from detail";
	@Override
	public List<detailBean> select() {
		List<detailBean> result = new ArrayList<detailBean>();
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(SELECT_ALL);
			rs = ract.executeQuery();
			while(rs.next()) {
				detailBean bean = new detailBean();
				bean.setId(rs.getInt("id"));
				bean.setOrdid(rs.getInt("ordid"));
				bean.setProdid(rs.getInt("prodid"));
				bean.setQuantiy(rs.getInt("quantiy"));
				bean.setTotal(rs.getInt("total"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return result;
	}
	
	
	private static final String DELETE = "delete from detail where id=?";
	@Override
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, id);
			int i = stmt.executeUpdate();
			if(i==1) {
				return true;
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
