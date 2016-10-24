package org.iiiedu.eeit88.health.member.dao;

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

import org.iiiedu.eeit88.health.bean.MemberBean;

public class MemberDAO implements Serializable {
	//for test by use DriverManager
//		private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//		private static final String USERNAME = "sa";
//		private static final String PASSWORD = "passw0rd";
		
		//for test by use DataSource
		private DataSource dataSource;
		public MemberDAO(){
			try {
				Context ctx = new InitialContext();
				dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} // end of MemberDAO
		
		private static final String SELECT_ALL = 
				"SELECT ID,LASTNAME,FIRSTNAME,GENDER,NICKNAME,BIRTH,PHONE,"
				+ "ACCOUNT,PASSWORDS,HEIGHT,WEIGHTS,EMAIL,MAILCHECK,"
				+ "CITY,COUNTY,ADDR,BONUS,PICTURE,PAIR FROM MEMBER";
		public List<MemberBean> select(){
			List<MemberBean> result = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(SELECT_ALL);
				rs = pstmt.executeQuery();
				
				result = new ArrayList<MemberBean>();
				while(rs.next()){
					MemberBean beans = new MemberBean();
					beans.setId(rs.getInt("ID"));
					beans.setLastname(rs.getString("LASTNAME"));
					beans.setFirstname(rs.getString("FIRSTNAME"));
					beans.setGender(rs.getString("GENDER"));
					beans.setNickName(rs.getString("NICKNAME"));
					beans.setBirth(rs.getDate("BIRTH"));
					beans.setPhone(rs.getString("PHONE"));
					beans.setAccount(rs.getString("ACCOUNT"));
					beans.setPasswords(rs.getString("PASSWORDS"));
					beans.setHeight(rs.getFloat("HEIGHT"));
					beans.setWeights(rs.getFloat("WEIGHTS"));
					beans.setEmail(rs.getString("EMAIL"));
					//beans.setMailCheck(rs.getBoolean("MAILCHECK"));
					beans.setCity(rs.getString("CITY"));
					beans.setCounty(rs.getString("COUNTY"));
					beans.setAddr(rs.getString("ADDR"));
					beans.setBonus(rs.getInt("BONUS"));
					//beans.setPicture(rs.getBytes("PICTURE"));
					beans.setPair(rs.getBoolean("PAIR"));
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
		}//end of select 
		
		
		
		private static final String SELECT = "SELECT * FROM MEMBER WHERE ID=?";
		public MemberBean select(int id){
			MemberBean result = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(SELECT);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					result = new MemberBean();
					result.setId(rs.getInt("ID"));
					result.setLastname(rs.getString("LASTNAME"));
					result.setFirstname(rs.getString("FIRSTNAME"));
					result.setGender(rs.getString("GENDER"));
					result.setNickName(rs.getString("NICKNAME"));
					result.setBirth(rs.getDate("BIRTH"));
					result.setPhone(rs.getString("PHONE"));
					result.setAccount(rs.getString("ACCOUNT"));
					result.setPasswords(rs.getString("PASSWORDS"));
					result.setHeight(rs.getFloat("HEIGHT"));
					result.setWeights(rs.getFloat("WEIGHTS"));
					result.setEmail(rs.getString("EMAIL"));
					//result.setMailCheck(rs.getBoolean("MAILCHECK"));
					result.setCity(rs.getString("CITY"));
					result.setCounty(rs.getString("COUNTY"));
					result.setAddr(rs.getString("ADDR"));
					result.setBonus(rs.getInt("BONUS"));
					//result.setPicture(rs.getBytes("PICTURE"));
					result.setPair(rs.getBoolean("PAIR"));
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
		}  //end of select
		
		//for test
		public static void main(String[] args){
			MemberDAO test = new MemberDAO();
			System.out.println(test.select());
			System.out.println(test.select(1));
		}//end of main
		
}//end of class
