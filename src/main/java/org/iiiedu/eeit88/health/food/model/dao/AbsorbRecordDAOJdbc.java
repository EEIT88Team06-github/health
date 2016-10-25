package org.iiiedu.eeit88.health.food.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.food.model.AbsorbBean;
import org.iiiedu.eeit88.health.food.model.AbsorbDetailBean;
import org.iiiedu.eeit88.health.food.model.AbsorbRecordDAO;


public class AbsorbRecordDAOJdbc implements Serializable,AbsorbRecordDAO {

//	//for test by use DriverManager
//		private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//		private static final String USERNAME = "sa";
//		private static final String PASSWORD = "passw0rd";
		
		
		//for test by use datasource
		private DataSource dataSource;
		public AbsorbRecordDAOJdbc(){
			try {
				Context ctx = new InitialContext();
				dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
			} catch (NamingException e) {
				e.printStackTrace();
			}	
		} //end of AbsorbRecordDAOJdbc
		
	private static final String INSERT_INTO_ABSORB = "INSERT INTO ABSORB (ABSORBDATE,MEMID) VALUES (?,?)";
	private static final String INSERT_INTO_ABSORBDETAIL = "INSERT INTO ABSORBDETAIL (ABSORBID,FOODID,QUANTITY) VALUES (?,?,?)";
	@Override
	public void insert(AbsorbBean bean) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet generatedKeys = null;
		PreparedStatement pstmt2 = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);//Transaction
				pstmt = conn.prepareStatement(INSERT_INTO_ABSORB,Statement.RETURN_GENERATED_KEYS);
				if(bean.getAbsorbDate() != null) {
					long time = bean.getAbsorbDate().getTime();
					java.sql.Date date = new java.sql.Date(time);
					pstmt.setDate(1, date);
				} else {
					pstmt.setDate(1, null);
				}
				pstmt.setInt(2, bean.getMemId());
				int a1 = pstmt.executeUpdate();
//				if(a1==1){
//					System.out.println("absorb insert success");
//				}
				generatedKeys = pstmt.getGeneratedKeys();  //擷取執行這個 SQLServerStatement 物件最後所建立之任何自動產生的索引鍵
				int absorbId = 0;
				if(generatedKeys.next()){
					absorbId = generatedKeys.getInt(1);  //取得absorb在insert時自動產生的PK
				}
				List<AbsorbDetailBean> items = bean.getItems();
				pstmt2 = conn.prepareStatement(INSERT_INTO_ABSORBDETAIL);
				for (AbsorbDetailBean adb : items) {
					pstmt2.setInt(1, absorbId);
//					System.out.println("absorbId="+absorbId);
					pstmt2.setInt(2, adb.getFoodId());
//					System.out.println("FoodId"+aib.getFoodId());
					pstmt2.setInt(3, adb.getQuantity());
					int a2 = pstmt2.executeUpdate();
//					if(a2==1){
//						System.out.println("detail insert success");
//					}
					pstmt2.clearParameters();//
				}
			conn.commit();//Transaction
	
		} catch (SQLException e) {
			System.out.println("rollback");
			if(conn!= null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		} finally{
			if (pstmt2!=null) {
				try {
					pstmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (generatedKeys!=null) {
				try {
					generatedKeys.close();
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
	}//end of insert

	
	//for test
	public static void main(String[] args){
		AbsorbRecordDAOJdbc test = new AbsorbRecordDAOJdbc ();
		
	}
}//end of class


