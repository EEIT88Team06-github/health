package org.iiiedu.eeit88.health.MembersOnly.model.dao;

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

import org.iiiedu.eeit88.health.MembersOnly.model.signinBean;
import org.iiiedu.eeit88.health.MembersOnly.model.signinDAO;

public class signinDAODS implements signinDAO {

//	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
//	public static final String DB_USER = "sa";
//	public static final String DB_PASSWORD = "passw0rd";
	
	private DataSource dataSource;
	public signinDAODS(){
	try {
		Context ctx = new InitialContext();
		dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------


	private static final String SELECT_ALL = "select * from signin where memid =?";
	@Override
	public List<signinBean> select(int memid) {
		List<signinBean> result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(SELECT_ALL);
			ract.setInt(1, memid);
			rs = ract.executeQuery();
			
			result = new ArrayList<signinBean>();
			while (rs.next()) {
				signinBean bean = new signinBean();
				bean.setId(rs.getInt("id"));
				bean.setSignintime(rs.getTimestamp("signintime"));
				bean.setLastsignin(rs.getTimestamp("lastsignin"));
				bean.setContinuous(rs.getInt("continuous"));
				bean.setMemid(rs.getInt("memid"));
				bean.setSign(rs.getBoolean("signin"));
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
	
	
	private static final String INSERT = "  insert into signin (signintime,lastsignin,continuous,signin,memid) values (?, ?, ?, ?, ?)";
	@Override
	public signinBean insert(signinBean bean) {
		signinBean result = null;
		if(bean!=null) {
			try(
//				Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
				
				stmt.setTimestamp(1, bean.getSignintime());
				stmt.setTimestamp(2, bean.getLastsignin());
				stmt.setInt(3, bean.getContinuous());
				stmt.setBoolean(4, bean.getSign());
				stmt.setInt(5, bean.getMemid());
//				stmt.setInt(6, bean.getId());
				int i = stmt.executeUpdate();
				if(i==1) {
					result = bean;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


//	@Override
//	public signinBean select() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
