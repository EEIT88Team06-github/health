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

import org.iiiedu.eeit88.health.food.model.AbsorbDetailBean;
import org.iiiedu.eeit88.health.food.model.AbsorbDetailDAO;




public class AbsorbDetailDAOJdbc implements Serializable, AbsorbDetailDAO{
	
//	//for test by use DriverManager
//		private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//		private static final String USERNAME = "sa";
//		private static final String PASSWORD = "passw0rd";
		
		//for test by use DataSource
		private DataSource dataSource;
		public AbsorbDetailDAOJdbc(){
			try {
				Context ctx = new InitialContext();
				dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} // end of AbsorbDetailDAOJdbc

	private static final String SELECT_ALL = "SELECT ID,ABSORBID,FOODID,QUANTITY FROM ABSORBDETAIL";
	@Override
	public List<AbsorbDetailBean> select() {
		List<AbsorbDetailBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<AbsorbDetailBean>();
			while(rs.next()){
				AbsorbDetailBean beans = new AbsorbDetailBean();
				beans.setId(rs.getInt("ID"));
				beans.setAbsorbId(rs.getInt("ABSORBID"));
				beans.setFoodId(rs.getInt("FOODID"));
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
	}//end of select all

	
	private static final String SELECT_ALL_ABSORBID = "SELECT ID,ABSORBID,FOODID,QUANTITY FROM ABSORBDETAIL WHERE ABSORBID=?";
	@Override
	public List<AbsorbDetailBean> select(int absorbId) {
		List<AbsorbDetailBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL_ABSORBID);
			pstmt.setInt(1, absorbId);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<AbsorbDetailBean>();
			while(rs.next()){
				AbsorbDetailBean beans = new AbsorbDetailBean();
				beans.setId(rs.getInt("ID"));
				beans.setAbsorbId(rs.getInt("ABSORBID"));
				beans.setFoodId(rs.getInt("FOODID"));
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
	}//end of select all by absorbId

	
	private static final String SELECT_ONE_BYID = "SELECT ID,ABSORBID,FOODID,QUANTITY FROM ABSORBDETAIL WHERE ID=?";
	@Override
	public AbsorbDetailBean selectOne(int id) {
		AbsorbDetailBean result = null;
		
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
				result = new AbsorbDetailBean();
				result.setId(rs.getInt("ID"));
				result.setAbsorbId(rs.getInt("ABSORBID"));
				result.setFoodId(rs.getInt("FOODID"));
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
	}//end of select one by id

	
	private static final String INSERT = "INSERT INTO ABSORBDETAIL (ABSORBID,FOODID,QUANTITY) VALUES (?,?,?)";
	@Override
	public AbsorbDetailBean insert(int absorbId, int foodId, int quantity,int id) {  //this id for select
		AbsorbDetailBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setInt(1, absorbId);
			pstmt.setInt(2, foodId);
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
	}//end of insert

	
	private static final String UPDATE = "UPDATE ABSORBDETAIL SET FOODID=?,QUANTITY=? WHERE ID=? ";
	@Override
	public AbsorbDetailBean update(int foodId, int quantity, int id) {
		AbsorbDetailBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setInt(1, foodId);
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
	}//end of update

	
	private static final String DELETE = "DELETE FROM ABSORBDETAIL WHERE ID=?";
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
		AbsorbDetailDAOJdbc test = new AbsorbDetailDAOJdbc();
//		//insert (absorbId, foodId, quantity, id)
//		System.out.println(test.insert(1, 5, 2 ,1));
//		//update (foodId, quantity, id)
//		System.out.println(test.update(3, 2, 1));
//		//select all
//		System.out.println(test.select());
//		//select all by absorbID
//		System.out.println(test.select(1));
//		//select one by id
//		System.out.println(test.selectOne(5));
//		//delete
//		System.out.println("是否成功刪除？"+test.delete(6));
	}
}
