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

import org.iiiedu.eeit88.health.MembersOnly.model.collsubBean;
import org.iiiedu.eeit88.health.MembersOnly.model.collsubBean;
import org.iiiedu.eeit88.health.MembersOnly.model.collsubDAO;

public class collsubDAODS implements collsubDAO{
//	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
//	public static final String DB_USER = "sa";
//	public static final String DB_PASSWORD = "passw0rd";
	
	private DataSource dataSource;
	public collsubDAODS(){
	try {
		Context ctx = new InitialContext();
		dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------
	private static final String SELECT_ALL="Select c.id,c.subid,s.memid,s.publishtime,s.subjects,s.recommand,s.replynum,s.subjectstatus,s.popularity from collect c join subject s on c.subid = s.id where s.memid = ?";
	@Override
	public List<collsubBean> select(int memid) {
		List<collsubBean> result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(SELECT_ALL);
			ract.setInt(1, memid);
			rs = ract.executeQuery();
			result = new ArrayList<collsubBean>();
			
			
			while (rs.next()) {
				collsubBean bean = new collsubBean();
				
				bean.setId(rs.getInt("id"));
				bean.setSubid(rs.getInt("subid"));
				bean.setMemid(rs.getInt("memid"));
				
				
				bean.setPublishtime(rs.getDate("publishtime"));
				bean.setSubjects(rs.getString("subjects"));
				bean.setRecommand(rs.getInt("recommand"));
				bean.setReplynum(rs.getInt("replynum"));
				bean.setSubjectstatus(rs.getInt("subjectstatus"));
				bean.setPopularity(rs.getInt("popularity"));		
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String DELETE = "delete from collect where memid=?";
	@Override
	public boolean delete(int memid) {
		Connection conn = null;
		PreparedStatement ract = null;
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(DELETE);
			
			ract.setInt(1, memid);
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
