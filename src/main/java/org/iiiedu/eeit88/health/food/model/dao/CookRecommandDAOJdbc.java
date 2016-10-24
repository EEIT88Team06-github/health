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

import org.iiiedu.eeit88.health.food.model.CookRecommandBean;
import org.iiiedu.eeit88.health.food.model.CookRecommandDAO;



public class CookRecommandDAOJdbc implements Serializable, CookRecommandDAO {
	//test for DriverManager
//		private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//		private static final String USERNAME = "sa";
//		private static final String PASSWORD = "passw0rd";
		
		//test for DataSource
		private DataSource dataSource;
		public CookRecommandDAOJdbc(){
			try {
				Context ctx = new InitialContext();
				dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}  //end of CookRecommandDAO
		
		
		private static final String SELECT_ALL = "SELECT ID,COOKRECOMMANDDATE,COOKID,MEMID FROM COOKRECOMMAND";
		@Override
		public List<CookRecommandBean> select(){
			List<CookRecommandBean> result = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(SELECT_ALL);
				rs = pstmt.executeQuery();
				
				result = new ArrayList<CookRecommandBean>();
				while(rs.next()){
					CookRecommandBean beans = new CookRecommandBean();
					beans.setId(rs.getInt("ID"));
					beans.setCookRecommandDate(rs.getDate("COOKRECOMMANDDATE"));
					beans.setCookId(rs.getInt("COOKID"));
					beans.setMemId(rs.getInt("MEMID"));
					result.add(beans);
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
		}//end of select(All)
		
		
		private static final String SELECT_ALL_BYID = "SELECT COOKID FROM COOKRECOMMAND WHERE MEMID=?";
		@Override
		public List<Integer> selectAll(int memid){
			List<Integer> result = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(SELECT_ALL_BYID);
				pstmt.setInt(1, memid);
				rs = pstmt.executeQuery();
				
				result = new ArrayList<Integer>();
				while(rs.next()){
					Integer cookid = rs.getInt("COOKID");	
					result.add(cookid);
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
		}  //end of select cookid by memid
		
		
		
		private static final String SELECT_ID = "SELECT ID,COOKRECOMMANDDATE,COOKID,MEMID FROM COOKRECOMMAND WHERE MEMID=?";
		@Override
		public CookRecommandBean select(int memId){
			CookRecommandBean result = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(SELECT_ID);
				pstmt.setInt(1, memId);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					result = new CookRecommandBean();
					result.setId(rs.getInt("ID"));
					result.setCookRecommandDate(rs.getDate("COOKRECOMMANDDATE"));
					result.setCookId(rs.getInt("COOKID"));
					result.setMemId(rs.getInt("MEMID"));
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

		
		private static final String INSERT = "INSERT INTO COOKRECOMMAND (COOKRECOMMANDDATE,COOKID,MEMID) VALUES (?,?,?)";
		/* (non-Javadoc)
		 * @see model.CookRecommandDAO#insert(java.util.Date, int, int)
		 */
		@Override
		public CookRecommandBean insert(java.util.Date cookRecommandDate, int cookId,int memId){
			CookRecommandBean result = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(INSERT);
				if(cookRecommandDate!=null) {
					long time = cookRecommandDate.getTime();
					java.sql.Date date = new java.sql.Date(time);
					pstmt.setDate(1, date);
				} else {
					pstmt.setDate(1, null);
				}
				pstmt.setInt(2, cookId);
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
			CookRecommandDAO test = new CookRecommandDAOJdbc();
			//test by select all
			System.out.println(test.select());
			//test select by mem_id
			System.out.println(test.select(2));
			//test insert
			CookRecommandBean bean = test.insert(new java.util.Date(), 4, 2);
			System.out.println(bean);
			//test select cookid by memid
			System.out.println(test.selectAll(3));
		}
		
}//end of class
