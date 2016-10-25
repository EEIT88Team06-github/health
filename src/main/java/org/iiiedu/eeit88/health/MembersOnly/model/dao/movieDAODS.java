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

import org.iiiedu.eeit88.health.MembersOnly.model.movieBean;
import org.iiiedu.eeit88.health.MembersOnly.model.movieDAO;
import org.iiiedu.eeit88.health.MembersOnly.model.slimminglogBean;

public class movieDAODS implements movieDAO{

//	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
//	public static final String DB_USER = "sa";
//	public static final String DB_PASSWORD = "passw0rd";
	
	private DataSource dataSource;
	public movieDAODS(){
	try {
		Context ctx = new InitialContext();
		dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------

	private static final String SELECT_ALL = "select * from movie where memid =?";
	@Override
	public List<movieBean> select(int memid) {
		List<movieBean> result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(SELECT_ALL);
			ract.setInt(1, memid);
			rs = ract.executeQuery();
			
			result = new ArrayList<movieBean>();
			while (rs.next()) {
				
				movieBean bean = new movieBean();
				bean.setMemid(rs.getInt("memid"));
				bean.setMoviesubject(rs.getString("moviesubject"));
				bean.setUpload(rs.getDate("upload"));
				bean.setContent(rs.getString("content"));
				bean.setMoviestatus(rs.getBoolean("moviestatus"));
				
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
	
//	private static final String SELECT_ALL2 = "select * from movie  where memid =?";
//	@Override
//	public List<movieBean> select() {
//		List<movieBean> result = new ArrayList<movieBean>();
//		Connection conn = null;
//		PreparedStatement ract = null;
//		ResultSet rs = null;
//
//		try {
////			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//			conn = dataSource.getConnection();
//			ract = conn.prepareStatement(SELECT_ALL2);
//			rs = ract.executeQuery();
//			while (rs.next()) {
//				movieBean bean = new movieBean();
//				bean.setMoviesubject(rs.getString("moviesubject"));
//				bean.setContent(rs.getString("content"));
//				bean.setUpload(rs.getDate("upload"));
//				bean.setMoviestatus( rs.getBoolean("moviestatus"));
//				result.add(bean);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (ract != null) {
//				try {
//					ract.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
	
}
