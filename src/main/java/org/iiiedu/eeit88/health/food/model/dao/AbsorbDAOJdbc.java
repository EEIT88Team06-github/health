package org.iiiedu.eeit88.health.food.model.dao;

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

import org.iiiedu.eeit88.health.food.model.AbsorbBean;
import org.iiiedu.eeit88.health.food.model.AbsorbDAO;


public class AbsorbDAOJdbc implements Serializable,AbsorbDAO {
//	//for test by use DriverManager
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";
	
	
	//for test by use datasource
	private DataSource dataSource;
	public AbsorbDAOJdbc(){
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}	
	} //end of AbsorbDAOJdbc
	
	
	private static final String SELECT_ALL = "SELECT ID,ABSORBDATE,MEMID FROM ABSORB";
	@Override
	public List<AbsorbBean> select() {
		List<AbsorbBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<AbsorbBean>();
			while(rs.next()){
				AbsorbBean bean = new AbsorbBean();
				bean.setId(rs.getInt("ID"));
				bean.setAbsorbDate(rs.getDate("ABSORBDATE"));
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
	}//end of SELECT_ALL
	
	
	private static final String SELECT_BY_ID = "SELECT ID,ABSORBDATE,MEMID FROM ABSORB WHERE MEMID=?";
	@Override
	public List<AbsorbBean> select(int memId) {
		List<AbsorbBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, memId);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<AbsorbBean>();
			while(rs.next()){
				AbsorbBean bean = new AbsorbBean();
				bean.setId(rs.getInt("ID"));
				bean.setAbsorbDate(rs.getDate("ABSORBDATE"));
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
	
	
	private static final String SELECT_BY_ONEDATE = "SELECT ID,ABSORBDATE,MEMID FROM ABSORB WHERE MEMID=? AND ABSORBDATE=?";
	public List<AbsorbBean> selectByDate(int memId,String absorbDate){
		List<AbsorbBean> result=null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_ONEDATE);
			pstmt.setInt(1, memId);
			pstmt.setString(2, absorbDate);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<AbsorbBean>();
			while(rs.next()){
				AbsorbBean bean = new AbsorbBean();
				bean.setId(rs.getInt("ID"));
				bean.setAbsorbDate(rs.getDate("ABSORBDATE"));
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
	}//end of select by one day
	
	
	//select id from absorb where memid=1 and absorbDate between '2016/10/12' and '2016/10/13'
	private static final String SELECT_BY_DATE = "SELECT ID,ABSORBDATE,MEMID FROM ABSORB WHERE MEMID=? AND ABSORBDATE BETWEEN ? AND ?";
	public List<AbsorbBean> selectByDate(int memId, String absorbDateStart, String absorbDateEnd){
		List<AbsorbBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_DATE);
			pstmt.setInt(1, memId);
			pstmt.setString(2, absorbDateStart);
			pstmt.setString(3, absorbDateEnd);
			rs = pstmt.executeQuery();
			result = new ArrayList<AbsorbBean>();
			while(rs.next()){
				AbsorbBean bean = new AbsorbBean();
				bean.setId(rs.getInt("ID"));
				bean.setAbsorbDate(rs.getDate("ABSORBDATE"));
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
	} //end of SELECT by memid and absorbDate
	
	
	
	
//	//select id from absorb where memid=1 and absorbDate between '2016/10/12' and '2016/10/13'
//		private static final String SELECT_BY_DATE = "SELECT ID FROM ABSORB WHERE MEMID=? AND ABSORBDATE BETWEEN ? AND ?";
//		public List<Integer> selectByDate(int memId, String absorbDateStart, String absorbDateEnd){
//			List<Integer> result = null;
//			
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			try {
////				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//				conn = dataSource.getConnection();
//				pstmt = conn.prepareStatement(SELECT_BY_DATE);
//				pstmt.setInt(1, memId);
//				pstmt.setString(2, absorbDateStart);
//				pstmt.setString(3, absorbDateEnd);
//				rs = pstmt.executeQuery();
//				result = new ArrayList<Integer>();
//				while(rs.next()){
//					int id = rs.getInt("ID");
//					result.add(id);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally{
//				if (rs!=null) {
//					try {
//						rs.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} 
//				}
//				if (pstmt!=null) {
//					try {
//						pstmt.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} 
//				}
//				if (conn!=null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} 
//				}
//			}
//			return result;
//		} //end of SELECT by memid and absorbDate
		
	
	private static final String SELECT_ONE_BYID = "SELECT ID,ABSORBDATE,MEMID FROM ABSORB WHERE ID=?";
	@Override
	public AbsorbBean selectOne(int id) {
		AbsorbBean result = null;
		
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
				result = new AbsorbBean();
				result.setId(rs.getInt("ID"));
				result.setAbsorbDate(rs.getDate("ABSORBDATE"));
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
	
	
	private static final String INSERT = "INSERT INTO ABSORB (ABSORBDATE,MEMID) VALUES (?,?)";
	@Override
	public AbsorbBean insert(java.util.Date absorbDate, int memId) {
		AbsorbBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			if(absorbDate!=null) {
				long time = absorbDate.getTime();
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
	} //end of insert
	
	
	private static final String UPDATE = "UPDATE ABSORB SET ABSORBDATE=? WHERE ID=? ";
	@Override
	public AbsorbBean update(Date absorbDate, int id, int memId) {
		AbsorbBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			if(absorbDate!=null) {
				long time = absorbDate.getTime();
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
	}  //end of update
	
	
	private static final String DELETE = "DELETE FROM ABSORB WHERE ID=?	";
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
		AbsorbDAOJdbc test = new AbsorbDAOJdbc();
//		//test insert
//		System.out.println(test.insert(new java.util.Date(), 2));
//		//test update (absorbDate, id, memId)，這個memId是for印出資料要用的
//		System.out.println(test.update(new java.util.Date(0), 1, 1));
//		//select all
//		System.out.println(test.select());
//		//select all by memId
//		System.out.println(test.select(1));
//		//select one by id
//		System.out.println(test.selectOne(2));
//		//delete
//		System.out.println("是否已成功刪除？"+test.delete(3));
//		//test select by memid and absordDate
//		System.out.println(test.selectByDate(1, "2016/10/12", "2016/10/13"));
		//test select by one day
		System.out.println(test.selectByDate(1, "2016/10/12"));
	}
	
	
	
}//end of class
