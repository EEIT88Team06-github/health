package org.iiiedu.eeit88.health.MembersOnly.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.model.slimminglogBean;
import org.iiiedu.eeit88.health.MembersOnly.model.slimminglogDAO;

public class slimminglogDAODS implements slimminglogDAO{

	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
	public static final String DB_USER = "sa";
	public static final String DB_PASSWORD = "passw0rd";
	
	
	
	private static final String SELECT_BY_ID = "select * from logs where id =?";
	@Override
	public slimminglogBean select(int id) {
		slimminglogBean result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ract = conn.prepareStatement(SELECT_BY_ID);
			ract.setInt(1, id);
			rs = ract.executeQuery();
			
			if (rs.next()) {
				result = new slimminglogBean();
				result.setId(rs.getInt("id"));
				result.setDate(rs.getDate("date"));
				result.setContent(rs.getString("content"));
				result.setMemid(rs.getInt("memid"));
				result.setShare(rs.getBoolean("share"));			
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

	private static final String SELECT_ALL = "select * from logs";
	@Override
	public List<slimminglogBean> select() {
		List<slimminglogBean> result = new ArrayList<slimminglogBean>();
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ract = conn.prepareStatement(SELECT_ALL);
			rs = ract.executeQuery();
			while (rs.next()) {
				slimminglogBean bean = new slimminglogBean();
				bean.setId(rs.getInt("id"));
				bean.setDate(rs.getDate("date"));
				bean.setContent(rs.getString("content"));
				bean.setMemid(rs.getInt("memid"));
				bean.setShare(rs.getBoolean("share"));
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

	private static final String INSERT = "insert into logs (id, date, content, memid, share) values (?, ?, ?, ?, ?)";
	@Override
	public slimminglogBean insert(slimminglogBean bean) {

		slimminglogBean result = null;
		ResultSet rs = null;
		
		if(bean!=null) {
			try(
				Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement ract = conn.prepareStatement(INSERT);) {

				ract.setInt(1, bean.getId());
				java.util.Date date = bean.getDate();
				if(date!=null) {
					long time = date.getTime();
					java.sql.Date dates = new java.sql.Date(time);
					ract.setDate(2, dates);
				} else {
					ract.setDate(2, null);
				}
				ract.setString(3, bean.getContent());
				ract.setInt(4, bean.getMemid());
				ract.setBoolean(5,bean.getShare());
				
				int i = ract.executeUpdate();
				if(i==1) {
					result = bean;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String UPDATE = "update logs set date=?,content=?,share=? where id=?";
	@Override
	public slimminglogBean update(Integer id,Date date, String content, Boolean share) {
		slimminglogBean result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ract = conn.prepareStatement(UPDATE);
			
			if(date!=null) {
				long time = date.getTime();
				java.sql.Date dates = new java.sql.Date(time);
				ract.setDate(1, dates);
			} else {
				ract.setDate(1, null);
			}
			
			ract.setString(2, content);
			ract.setBoolean(3, share);
			ract.executeUpdate(); 
			int i = ract.executeUpdate();
			if(i==1) {
				result = this.select(id);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	private static final String DELETE = "delete from logs where id=?";
	@Override
	public boolean delete(Integer id) {
		Connection conn = null;
		PreparedStatement ract = null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ract = conn.prepareStatement(DELETE);
			
			ract.setInt(1, id);
			int i = ract.executeUpdate();
			if(i==1) {
				return true;
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
