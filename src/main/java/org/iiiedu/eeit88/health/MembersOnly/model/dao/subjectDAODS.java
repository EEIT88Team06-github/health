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

import org.iiiedu.eeit88.health.MembersOnly.model.slimminglogBean;
import org.iiiedu.eeit88.health.MembersOnly.model.subjectBean;
import org.iiiedu.eeit88.health.MembersOnly.model.subjectDAO;

public class subjectDAODS implements subjectDAO{

//	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
//	public static final String DB_USER = "sa";
//	public static final String DB_PASSWORD = "passw0rd";
	
	private DataSource dataSource;
	public subjectDAODS(){
	try {
		Context ctx = new InitialContext();
		dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------
//
//	private static final String SELECT_BY_ID = "select * from subject where id =?";
//	@Override
//	public subjectBean select(int id) {
//		subjectBean result = null;
//		Connection conn = null;
//		PreparedStatement ract = null;
//		ResultSet rs = null;
//		
//		try {
////		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//			conn = dataSource.getConnection();
//			ract = conn.prepareStatement(SELECT_BY_ID);
//			ract.setInt(1, id);
//			rs = ract.executeQuery();
//			if (rs.next()) {
//				result = new subjectBean();
//				result.setId(rs.getInt("id"));
//				result.setPublishtime(rs.getDate("publishtime"));
//				result.setSubjects(rs.getString("subjects"));
//				result.setSubjecttype(rs.getString("subjecttype"));
//				result.setMemid(rs.getInt("memid"));
//				result.setRecommand(rs.getInt("recommand"));
//				result.setReplynum(rs.getInt("replynum"));
//				result.setSubjectstatus(rs.getInt("subjectstatus"));
//				result.setPopularity(rs.getInt("popularity"));
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
	
	
	private static final String SELECT_ALL = "select * from subject where memid= ?";										
	@Override
	public List<subjectBean> select(int memid) {
		List<subjectBean> result = null;
		Connection conn = null;
		PreparedStatement ract = null;
		ResultSet rs = null;
		
		try {
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			conn = dataSource.getConnection();
			ract = conn.prepareStatement(SELECT_ALL);
			ract.setInt(1, memid);
			rs = ract.executeQuery();
			result = new ArrayList<subjectBean>();
			while (rs.next()) {
				subjectBean bean = new subjectBean();
				bean.setPublishtime(rs.getDate("publishtime"));
				bean.setSubjects(rs.getString("subjects"));
				bean.setMemid(rs.getInt("memid"));
				bean.setRecommand(rs.getInt("recommand"));
				bean.setReplynum(rs.getInt("replynum"));
				bean.setPopularity(rs.getInt("popularity"));
//				bean.setSubjectstatus(rs.getInt("subjectstatus"));
//				bean.setId(rs.getInt("id"));
//				bean.setSubjecttype(rs.getString("subjecttype"));
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
