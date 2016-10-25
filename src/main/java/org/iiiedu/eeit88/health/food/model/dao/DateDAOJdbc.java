package org.iiiedu.eeit88.health.food.model.dao;

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

import org.iiiedu.eeit88.health.food.model.DateBean;
import org.iiiedu.eeit88.health.food.model.DateDAO;



public class DateDAOJdbc implements Serializable,DateDAO{
//	//for test by use DriverManager
//		private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//		private static final String USERNAME = "sa";
//		private static final String PASSWORD = "passw0rd";
		
		
		//for test by use datasource
		private DataSource dataSource;
		public DateDAOJdbc(){
			try {
				Context ctx = new InitialContext();
				dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
			} catch (NamingException e) {
				e.printStackTrace();
			}	
		} //end of DateDAOJdbc
		
		private static final String SELECT = "SELECT ID,DATE FROM DATE";
		public List<DateBean> select(){
			List<DateBean> result = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(SELECT);
				rs = pstmt.executeQuery();
				
				result = new ArrayList<DateBean>();
				while(rs.next()){
					DateBean bean = new DateBean();
					bean.setId(rs.getInt("ID"));
					bean.setDate(rs.getDate("DATE"));
					result.add(bean);
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
		}//end of select
		
		
		private static final String SELECT_ONE = "SELECT ID,DATE FROM DATE WHERE DATE=?";
		public DateBean select(String date){
			DateBean result = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(SELECT_ONE);
				pstmt.setString(1, date);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					result = new DateBean();
					result.setId(rs.getInt("ID"));
					result.setDate(rs.getDate("DATE"));
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
		}  //select one
		
		
		private static final String SELECT_DURING = "SELECT ID,DATE FROM DATE WHERE DATE BETWEEN ? AND ?";
		public List<DateBean> select(String startDay,String endDay){
			List<DateBean> result = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(SELECT_DURING);
				pstmt.setString(1, startDay);
				pstmt.setString(2, endDay);
				rs = pstmt.executeQuery();
				
				result = new ArrayList<DateBean>();
				while(rs.next()){
					DateBean bean = new DateBean();
					bean.setId(rs.getInt("ID"));
					bean.setDate(rs.getDate("Date"));
					result.add(bean);
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
		}//end of select during
		
		
		
		//for test
		public static void main(String[] args){
			DateDAOJdbc test = new DateDAOJdbc();
			//test selectAll
			System.out.println(test.select());
			//test selectOne
			System.out.println(test.select("2016-10-1"));
			//test select during
			System.out.println(test.select("2016-10-1", "2016-10-5"));
		}
		
}//end of class
