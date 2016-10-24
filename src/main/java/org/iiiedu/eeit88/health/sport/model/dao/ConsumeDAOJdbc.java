package org.iiiedu.eeit88.health.sport.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.sport.model.ConsumeBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeDAO;




public class ConsumeDAOJdbc implements Serializable, ConsumeDAO {
	
//	//for test by use DriverManager
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";
	
	
	//for test by use datasource
	private DataSource dataSource;
	public ConsumeDAOJdbc(){
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}	
	} //end of ConsumeDAOJdbc
	
	
	
	private static final String SELECT_ALL= "SELECT ID,CONSUMEDATE,MEMID FROM CONSUME";
	@Override
	public List<ConsumeBean> select() {
		List<ConsumeBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<ConsumeBean>();
			while(rs.next()){
				ConsumeBean bean = new ConsumeBean();
				bean.setId(rs.getInt("ID"));
				bean.setConsumeDate(rs.getDate("CONSUMEDATE"));
				bean.setMemId(rs.getInt("MEMID"));
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
	}//end of select all

	
	private static final String SELECT_BY_MEMID = "SELECT ID,CONSUMEDATE,MEMID FROM CONSUME WHERE MEMID=?";
	@Override
	public List<ConsumeBean> select(int memId) {
		List<ConsumeBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_MEMID);
			pstmt.setInt(1, memId);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<ConsumeBean>();
			while(rs.next()){
				ConsumeBean bean = new ConsumeBean();
				bean.setId(rs.getInt("ID"));
				bean.setConsumeDate(rs.getDate("CONSUMEDATE"));
				bean.setMemId(rs.getInt("MEMID"));
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
	}  //end of select by memid

	
	private static final String SELECT_BY_ONEDATE = "SELECT ID,CONSUMEDATE,MEMID FROM CONSUME WHERE MEMID=? AND CONSUMEDATE=?";
	@Override
	public List<ConsumeBean> selectByDate(int memId, String consumeDate) {
		List<ConsumeBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_ONEDATE);
			pstmt.setInt(1, memId);
			pstmt.setString(2, consumeDate);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<ConsumeBean>();
			while(rs.next()){
				ConsumeBean bean = new ConsumeBean();
				bean.setId(rs.getInt("ID"));
				bean.setConsumeDate(rs.getDate("CONSUMEDATE"));
				bean.setMemId(rs.getInt("MEMID"));
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
	}//end of select by date

	
	private static final String SELECT_BY_DURINGDATE = "SELECT ID,CONSUMEDATE,MEMID FROM CONSUME WHERE MEMID=? AND CONSUMEDATE BETWEEN ? AND ?";
	@Override
	public List<ConsumeBean> selectByDate(int memId, String consumeDateStart, String consumeDateEnd) {
		List<ConsumeBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_DURINGDATE);
			pstmt.setInt(1, memId);
			pstmt.setString(2, consumeDateStart);
			pstmt.setString(3, consumeDateEnd);
			rs = pstmt.executeQuery();
			result = new ArrayList<ConsumeBean>();
			while(rs.next()){
				ConsumeBean bean = new ConsumeBean();
				bean.setId(rs.getInt("ID"));
				bean.setConsumeDate(rs.getDate("CONSUMEDATE"));
				bean.setMemId(rs.getInt("MEMID"));
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
	}//end of select by during day

	
	private static final String SELECT_ONE = "SELECT ID,CONSUMEDATE,MEMID FROM CONSUME WHERE ID=?";
	@Override
	public ConsumeBean selectOne(int id) {
		ConsumeBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ONE);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new ConsumeBean();
				result.setId(rs.getInt("ID"));
				result.setConsumeDate(rs.getDate("CONSUMEDATE"));
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
	}//end of select by id

	
	private static final String INSERT= "INSERT INTO CONSUME(CONSUMEDATE,MEMID) VALUES (?,?)";
	@Override
	public ConsumeBean insert(Date consumeDate, int memId) {
		ConsumeBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			if(consumeDate!=null) {
				long time = consumeDate.getTime();
				java.sql.Date date = new java.sql.Date(time);
				pstmt.setDate(1, date);
			} else {
				pstmt.setDate(1, null);
			}
			pstmt.setInt(2, memId);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				result = this.selectOne(memId);
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

	
	private static final String UPDATE = "UPDATE CONSUME SET CONSUMEDATE=? WHERE ID=?";
	@Override
	public ConsumeBean update(Date consumeDate, int memId, int id) {
		ConsumeBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			if(consumeDate!=null) {
				long time = consumeDate.getTime();
				java.sql.Date date = new java.sql.Date(time);
				pstmt.setDate(1, date);
			} else {
				pstmt.setDate(1, null);
			}
			pstmt.setInt(2, id);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				result = this.selectOne(memId);
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
	}//end of update

	
	private static final String DELETE = "DELETE FROM CONSUME WHERE ID=?";
	@Override
	public Boolean delete(int id) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				result = true;
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
	}//end of delete 
	
	
	
	//for test
	public static void main(String[] args){
		ConsumeDAOJdbc test = new ConsumeDAOJdbc();
//		//insert
//		System.out.println(test.insert(new java.util.Date(), 1));
//		//update 
//		System.out.println(test.update(new java.util.Date(0), 1, 1));
//		//select one by id
//		System.out.println(test.selectOne(1));
//		//select by two day
//		System.out.println(test.selectByDate(1, "2016-9-25", "2016-9-27"));
//		//select by one day
//		System.out.println(test.selectByDate(1, "2016-9-25"));
//		//select by memid
//		System.out.println(test.select(1));
//		//select all
//		System.out.println(test.select());
		//delete 
		System.out.println("是否成功刪除: "+test.delete(4));
	}//end of test

}//end of class
