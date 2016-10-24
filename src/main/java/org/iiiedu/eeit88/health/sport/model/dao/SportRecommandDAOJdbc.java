package org.iiiedu.eeit88.health.sport.model.dao;

import java.io.Serializable;
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

import org.iiiedu.eeit88.health.sport.model.SportRecommandBean;
import org.iiiedu.eeit88.health.sport.model.SportRecommandDAO;



public class SportRecommandDAOJdbc implements Serializable, SportRecommandDAO {
	//for test by use DriverManager
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";
	
	//for test by use DataSource
	private DataSource dataSource;
	public SportRecommandDAOJdbc(){
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	} // end of SportRecommandDAO
	
	
	private static final String SELECT_ALL= "SELECT ID,SPORTRECOMMANDDATE,SPORTID,MEMID FROM SPORTRECOMMAND";
	@Override
	public List<SportRecommandBean> select(){
		List<SportRecommandBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			result = new ArrayList<SportRecommandBean>();
			while (rs.next()){
				SportRecommandBean beans = new SportRecommandBean();
				beans.setId(rs.getInt("ID"));
				beans.setSportRecommandDate(rs.getDate("SPORTRECOMMANDDATE"));
				beans.setSportId(rs.getInt("SPORTID"));
				beans.setId(rs.getInt("MEMID"));
				result.add(beans);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}//end of select all
	
	
	private static final String SELECT_ALL_BYID = "SELECT SPORTID FROM SPORTRECOMMAND WHERE MEMID=?";
	@Override
	public List<Integer> selectAll(int memId){
		List<Integer> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL_BYID);
			pstmt.setInt(1, memId);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<Integer>();
			while(rs.next()){
				Integer sportId = rs.getInt("SPORTID");	
				result.add(sportId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;		
	}  //end of select id by memid
	
	
	
	
	
	
	
	private static final String SELECT = "SELECT ID,SPORTRECOMMANDDATE,SPORTID,MEMID FROM SPORTRECOMMAND WHERE MEMID=?";
	/* (non-Javadoc)
	 * @see model.SportRecommandDAO#select(int)
	 */
	@Override
	public SportRecommandBean select(int memId){
		SportRecommandBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT);
			pstmt.setInt(1, memId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new SportRecommandBean();
				result.setId(rs.getInt("ID"));
				result.setSportRecommandDate(rs.getDate("SPORTRECOMMANDDATE"));
				result.setSportId(rs.getInt("SPORTID"));
				result.setId(rs.getInt("MEMID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;
	}//end of select by mem_id
	
	
	private static final String INSERT = "INSERT INTO SPORTRECOMMAND (SPORTRECOMMANDDATE,SPORTID,MEMID) VALUES (?,?,?)";
	/* (non-Javadoc)
	 * @see model.SportRecommandDAO#insert(java.util.Date, int, int)
	 */
	@Override
	public SportRecommandBean insert(java.util.Date sportRecommandDate,int sportId,int memId){
		SportRecommandBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			if(sportRecommandDate!=null) {
				long time = sportRecommandDate.getTime();
				java.sql.Date date = new java.sql.Date(time);
				pstmt.setDate(1, date);
			} else {
				pstmt.setDate(1, null);
			}
			pstmt.setInt(2, sportId);
			pstmt.setInt(3, memId);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				result = this.select(memId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;
	}//end of insert
	
	
	//for test
	public static void main(String[] args){
		SportRecommandDAO test = new SportRecommandDAOJdbc();
		//test by select all
		System.out.println(test.select());
		//test select by mem_id
		System.out.println(test.select(2));
		//test insert
		System.out.println(test.insert(new java.util.Date(), 5, 2));
		//test select sportId by memId
		System.out.println(test.selectAll(2));
	}//end of main
}  //end of class
