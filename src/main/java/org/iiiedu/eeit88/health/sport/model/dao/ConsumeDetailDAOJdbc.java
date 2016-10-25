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

import org.iiiedu.eeit88.health.sport.model.ConsumeDetailBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeDetailDAO;





public class ConsumeDetailDAOJdbc implements Serializable, ConsumeDetailDAO {

//	//for test by use DriverManager
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";
	
	//for test by use DataSource
	private DataSource dataSource;
	public ConsumeDetailDAOJdbc(){
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	} // end of ConsumeDetailDAOJdbc
	
	
	private static final String SELECT_ALL = "SELECT ID,CONSUMEID,SPORTID,QUANTITY FROM CONSUMEDETAIL";
	@Override
	public List<ConsumeDetailBean> select() {
		List<ConsumeDetailBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<ConsumeDetailBean>();
			while(rs.next()){
				ConsumeDetailBean beans = new ConsumeDetailBean();
				beans.setId(rs.getInt("ID"));
				beans.setConsumeId(rs.getInt("CONSUMEID"));
				beans.setSportId(rs.getInt("SPORTID"));
				beans.setQuantity(rs.getInt("QUANTITY"));
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
	}//END OF SELECT

	
	private static final String SELECT_BY_CONSUMEID = "SELECT ID,CONSUMEID,SPORTID,QUANTITY FROM CONSUMEDETAIL WHERE CONSUMEID=?";
	@Override
	public List<ConsumeDetailBean> select(int consumeId) {
		List<ConsumeDetailBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_CONSUMEID);
			pstmt.setInt(1, consumeId);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<ConsumeDetailBean>();
			while(rs.next()){
				ConsumeDetailBean beans = new ConsumeDetailBean();
				beans.setId(rs.getInt("ID"));
				beans.setConsumeId(rs.getInt("CONSUMEID"));
				beans.setSportId(rs.getInt("SPORTID"));
				beans.setQuantity(rs.getInt("QUANTITY"));
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
	}

	
	private static final String SELECT_ONE_BYID = "SELECT ID,CONSUMEID,SPORTID,QUANTITY FROM CONSUMEDETAIL WHERE ID=?";
	@Override
	public ConsumeDetailBean selectOne(int id) {
		ConsumeDetailBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ONE_BYID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new ConsumeDetailBean();
				result.setId(rs.getInt("ID"));
				result.setConsumeId(rs.getInt("CONSUMEID"));
				result.setSportId(rs.getInt("SPORTID"));
				result.setQuantity(rs.getInt("QUANTITY"));
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

	
	private static final String INSERT = "INSERT INTO CONSUMEDETAIL (CONSUMEID,SPORTID,QUANTITY) VALUES (?,?,?)";
	@Override
	public ConsumeDetailBean insert(int consumeId, int sportId, int quantity, int id) {
		ConsumeDetailBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setInt(1, consumeId);
			pstmt.setInt(2, sportId);
			pstmt.setInt(3, quantity);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				result = this.selectOne(id);
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
	}  //END OF INSERT

	
	private static final String UPDATE = "UPDATE CONSUMEDETAIL SET SPORTID=?, QUANTITY=? WHERE ID=?";
	@Override
	public ConsumeDetailBean update(int sportId, int quantity, int id) {
		ConsumeDetailBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setInt(1, sportId);
			pstmt.setInt(2, quantity);
			pstmt.setInt(3, id);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				result = this.selectOne(id);
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
	}//END OF UPDATE 

	
	private static final String DELETE = "DELETE FROM CONSUMEDETAIL WHERE ID=?";
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
	}//END OF DELETE 

	
	
	//for test 
	public static void main(String[] args){
		ConsumeDetailDAOJdbc test = new ConsumeDetailDAOJdbc();
//		//insert
//		System.out.println(test.insert(1, 5, 2, 1));
//		//update
//		System.out.println(test.update(5, 3, 1));
//		//select one by id
//		System.out.println(test.selectOne(1));
//		//select by consumeid
//		System.out.println(test.select(2));
//		//select all
//		System.out.println(test.select());
//		//delete 
//		System.out.println("是否成功刪除: "+test.delete(7));
	}//end of test
}//end of class
